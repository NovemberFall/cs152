package edu.sjsu.fwjs;

/**
 * Group project
 * author: Yuxiao Zheng
 *         Susmita Goswami
 */
public class Interpreter {

    public static void main(String[] args) throws Exception {
        Expression prog = new BinOpExpr(Op.ADD,
                new ValueExpr(new IntVal(3)),
                new ValueExpr(new IntVal(4)));
        System.out.println("'3 + 4;' evaluates to " + prog.evaluate(new Environment()));

        prog = new BinOpExpr(Op.MOD,
                new ValueExpr(new IntVal(5)),
                new ValueExpr(new IntVal(2)));
        System.out.println("'5 % 2;' evaluates to " + prog.evaluate(new Environment()));

        prog = new BinOpExpr(Op.GT,
                new ValueExpr(new IntVal(5)),
                new ValueExpr(new IntVal(2)));
        System.out.println("'5 > 2;' evaluates to " + prog.evaluate(new Environment()));

        prog = new BinOpExpr(Op.EQ,
                new ValueExpr(new IntVal(5)),
                new ValueExpr(new IntVal(2)));
        System.out.println("'5 == 2;' evaluates to " + prog.evaluate(new Environment()));
    }
}
