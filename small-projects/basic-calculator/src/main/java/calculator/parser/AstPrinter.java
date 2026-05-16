package calculator.parser;

public class AstPrinter implements ExprVisitor<String>{

    String print(Expr expr){
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return "(" +
                expr.operator.lexeme +
                " " +
                expr.left.accept(this) +
                " " +
                expr.right.accept(this) +
                ")";
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        return String.valueOf(expr.value);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return "(group " +
                expr.expression.accept(this) +
                ")";
    }
}
