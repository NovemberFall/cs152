package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import edu.sjsu.fwjs.parser.FeatherweightJavaScriptBaseVisitor;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser.ExprContext;

public class ExpressionBuilderVisitor extends FeatherweightJavaScriptBaseVisitor<Expression>{
    @Override
    public Expression visitProg(FeatherweightJavaScriptParser.ProgContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=0; i<ctx.stat().size(); i++) {
            Expression exp = visit(ctx.stat(i));
            if (exp != null) stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }

    @Override
    public Expression visitBareExpr(FeatherweightJavaScriptParser.BareExprContext ctx) {
        return visit(ctx.expr());
    }

    /* IF, WHILE, PRINT */
    @Override
    public Expression visitIfThenElse(FeatherweightJavaScriptParser.IfThenElseContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block(0));
        Expression els = visit(ctx.block(1));
        return new IfExpr(cond, thn, els);
    }

    @Override
    public Expression visitIfThen(FeatherweightJavaScriptParser.IfThenContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block());
        return new IfExpr(cond, thn, null);
    }

    @Override
    public Expression visitWhile(FeatherweightJavaScriptParser.WhileContext ctx) {
    	Expression cond = visit(ctx.expr());
    	Expression block = visit(ctx.block());
		  return new WhileExpr(cond, block);
    }

    @Override
    public Expression visitPrint(FeatherweightJavaScriptParser.PrintContext ctx) {
    	Expression expr = visit(ctx.expr());
    	return new PrintExpr(expr);
    }

    /* Literals */
    @Override
    public Expression visitInt(FeatherweightJavaScriptParser.IntContext ctx) {
        int val = Integer.valueOf(ctx.INT().getText());
        return new ValueExpr(new IntVal(val));
    }

    @Override
    public Expression visitBoolean(FeatherweightJavaScriptParser.BooleanContext ctx) {
        boolean val = Boolean.valueOf(ctx.BOOL().getText());
        return new ValueExpr(new BoolVal(val));
    }

    @Override
    public Expression visitNull(FeatherweightJavaScriptParser.NullContext ctx) {
    	return new ValueExpr(new NullVal());
    }

    /* Parens and Block */
    @Override
    public Expression visitParens(FeatherweightJavaScriptParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Expression visitFullBlock(FeatherweightJavaScriptParser.FullBlockContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=1; i<ctx.getChildCount()-1; i++) {
            Expression exp = visit(ctx.getChild(i));
            stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }


@Override
public Expression visitMulDivMod(FeatherweightJavaScriptParser.MulDivModContext ctx) {
  Expression exp1 = visit(ctx.expr(0));
  Expression exp2 = visit(ctx.expr(1));
  Op op = getEnum(String.valueOf(ctx.op.getText()));
  return new BinOpExpr(op, exp1, exp2);
}

@Override
public Expression visitAddSub(FeatherweightJavaScriptParser.AddSubContext ctx) {
  Expression exp1 = visit(ctx.expr(0));
  Expression exp2 = visit(ctx.expr(1));
  Op op = getEnum(String.valueOf(ctx.op.getText()));
  return new BinOpExpr(op, exp1, exp2);
}

@Override
public Expression visitComparison(FeatherweightJavaScriptParser.ComparisonContext ctx) {
  Expression exp1 = visit(ctx.expr(0));
  Expression exp2 = visit(ctx.expr(1));
  Op op = getEnum(String.valueOf(ctx.op.getText()));
  return new BinOpExpr(op, exp1, exp2);
}

public Op getEnum(String enumVal){
      if(enumVal.equals("+")){
          return Op.ADD;
      }else if(enumVal.equals("-")){
          return Op.SUBTRACT;
      }else if(enumVal.equals("*")){
          return Op.MULTIPLY;
      }else if(enumVal.equals("/")){
          return Op.DIVIDE;
      }else if(enumVal.equals("%")){
          return Op.MOD;
      }else if(enumVal.equals(">")){
          return Op.GT;
      }else if(enumVal.equals(">=")){
          return Op.GE;
      }else if(enumVal.equals("<")){
          return Op.LT;
      }else if(enumVal.equals("<=")){
          return Op.LE;
      }else if(enumVal.equals("==")){
          return Op.EQ;
      }else{
          return null;
      }
 }


    /* Function Declaration */
    @Override
    public Expression visitFuncDecl(FeatherweightJavaScriptParser.FuncDeclContext ctx) {
      List<String> args = new ArrayList<String>();

      // Convert TerminalNode list of params to String.
      List<TerminalNode> nodes = ctx.argslist().ID();
      for(int i = 0; i < nodes.size(); i++) {
        args.add(String.valueOf(nodes.get(i)));
      }

      Expression funcBody = visit(ctx.block());
      return new FunctionDeclExpr(args, funcBody);
    }

  /* Function Application */
  @Override
  public Expression visitFuncApp(FeatherweightJavaScriptParser.FuncAppContext ctx) {
      Expression expr = visit(ctx.expr());
      List<Expression> args = new ArrayList<Expression>();

      // Convert ExprContext list of args to Expression.
      List<ExprContext> exprs = ctx.argscalllist().expr();
      for(int i = 0; i < exprs.size(); i++) {
        args.add(visit(exprs.get(i)));
      }

      return new FunctionAppExpr(expr, args);
    }

    /* Variable Decl */
    @Override
    public Expression visitVarDecl(FeatherweightJavaScriptParser.VarDeclContext ctx) {
    	String variable = String.valueOf(ctx.ID().getText());
    	Expression expr = visit(ctx.expr());
    	return new VarDeclExpr(variable, expr);
    }

    /* Variable Update */
    @Override
    public Expression visitVarAssign(FeatherweightJavaScriptParser.VarAssignContext ctx) {
    	String variable = String.valueOf(ctx.ID().getText());
    	Expression expr = visit(ctx.expr());
    	return new AssignExpr(variable, expr);
    }

    /* Variable Reference */
    @Override
    public Expression visitVarReference(FeatherweightJavaScriptParser.VarReferenceContext ctx) {
    	String variable = String.valueOf(ctx.ID().getText());
    	return new VarExpr(variable);
    }

    /**
     * Converts a list of expressions to one sequence expression,
     * if the list contained more than one expression.
     */
    private Expression listToSeqExp(List<Expression> stmts) {
        if (stmts.isEmpty()) return null;
        Expression exp = stmts.get(0);
        for (int i=1; i<stmts.size(); i++) {
            exp = new SeqExpr(exp, stmts.get(i));
        }
        return exp;
    }

    @Override
    public Expression visitSimpBlock(FeatherweightJavaScriptParser.SimpBlockContext ctx) {
        return visit(ctx.stat());
    }
}
