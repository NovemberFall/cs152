package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.fwjs.parser.FeatherweightJavaScriptBaseVisitor;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser;

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

    //added
    @Override
    public Expression visitWhile(FeatherweightJavaScriptParser.WhileContext ctx) {
        Expression cond=visit(ctx.expr());
        Expression body=visit(ctx.block());
        return new WhileExpr(cond,body);
    }

    //added
    @Override
    public Expression visitPrint(FeatherweightJavaScriptParser.PrintContext ctx) {
        Expression expression=visit(ctx.expr());
        return new PrintExpr(expression);
    }

    //added
    @Override
    public Expression visitMulDivMod(FeatherweightJavaScriptParser.MulDivModContext ctx) {
        int operation = ctx.op.getType();
        Expression expr0 = visit(ctx.expr(0));
        Expression expr1 = visit(ctx.expr(1));
        if(operation == FeatherweightJavaScriptParser.MUL){
            return new BinOpExpr(Op.MULTIPLY,expr0,expr1);
        }
        else if(operation == FeatherweightJavaScriptParser.DIV){
            return new BinOpExpr(Op.DIVIDE,expr0,expr1);
        }
        else{
            return new BinOpExpr(Op.MOD,expr0,expr1);
        }
        
    }

    //added
    @Override
    public Expression visitAdditionSubtraction(FeatherweightJavaScriptParser.AdditionSubtractionContext ctx) {
        int operation=ctx.op.getType();
        Expression expr0 = visit(ctx.expr(0));
        Expression expr1 = visit(ctx.expr(1));
        
        if (operation==FeatherweightJavaScriptParser.ADD){         
            return new BinOpExpr(Op.ADD,expr0,expr1);
        }else{
            return new BinOpExpr(Op.SUBTRACT,expr0,expr1);
        }
    }

    //added
    @Override
    public Expression visitComparison(FeatherweightJavaScriptParser.ComparisonContext ctx) {
        int operation=ctx.op.getType();
        Expression expr0 = visit(ctx.expr(0));
        Expression expr1 = visit(ctx.expr(1));

        if (operation==FeatherweightJavaScriptParser.GT){
            return new BinOpExpr(Op.GT,expr0,expr1);
        } else if (operation == FeatherweightJavaScriptParser.GE){
            return new BinOpExpr(Op.GTE,expr0,expr1);
        } else if (operation == FeatherweightJavaScriptParser.LT){
            return new BinOpExpr(Op.LT,expr0,expr1);
        } else if (operation == FeatherweightJavaScriptParser.LE){
            return new BinOpExpr(Op.LTE,expr0,expr1);
        } else{
            return new BinOpExpr(Op.EQ,expr0,expr1);
        } 
    }

    //added
    @Override
    public Expression visitParens(FeatherweightJavaScriptParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    //added
    @Override
    public Expression visitInt(FeatherweightJavaScriptParser.IntContext ctx) {
        int val = Integer.valueOf(ctx.INT().getText());
        return new ValueExpr(new IntVal(val));
    }

    //added
    @Override
    public Expression visitBool(FeatherweightJavaScriptParser.BoolContext ctx) {
        int val = Boolean.valueOf(ctx.BOOL().getText());
        return new ValueExpr(new BoolVal(val));
    }

    //added
    @Override
    public Expression visitVarDecl(FeatherweightJavaScriptParser.VarDeclContext ctx) {
        String ID;
        ID = ctx.ID().getText();
        Expression expression = visit(ctx.expr());
        return new VarDeclExpr(id,expression);
    }

    //added
    @Override
    public Expression visitVarApp(FeatherweightJavaScriptParser.VarAppContext ctx) {
        String ID;
        ID = ctx.ID().getText();
        return new VarExpr(id);
    }    

    //added
    @Override
    public Expression visitVarAsgn(FeatherweightJavaScriptParser.VarAsgnContext ctx) {
        String id = ctx.ID().getText();
        Expression expression = visit(ctx.expr());
        return new AssignExpr(id,expression);
    }

    //added
    @Override
    public Expression visitFucApp(FeatherweightJavaScriptParser.FucAppContext ctx) {
        Expression expression = visit(ctx.expr());
        List<Expression> arguments = new ArrayList<Expression>();
        for(int i=1; i<ctx.arguments().getChildCount()-1; i++) {
            if(i%2!=0){
                Expression temp = visit(ctx.arguments().getChild(i));
                arguments.add(temp);
            }
        }
        return new FunctionAppExpr(expression,arguments);
    }

    //added
    @Override
    public Expression visitFuncDecl(FeatherweightJavaScriptParser.FuncDeclContext ctx) {
        List<String> funcParameters = new ArrayList<String>();
        List<Expression> listOfExpressions = new ArrayList<Expression>();
        for (int i=1; i<ctx.funcParameters().getChildCount()-1; i++) {
            String parameter = ctx.funcParameters().getChild(i).getText();
            if (!parameter.equals(",")){
                funcParameters.add(parameter);        
            }
        }
        for (int i=0; i<ctx.stat().size(); i++) {
            Expression expression = visit(ctx.stat(i));
            listOfExpressions.add(expression);
        }
        Expression body = listToSeqExp(listOfExpressions);
        return new FunctionDeclExpr(funcParameters, body);
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