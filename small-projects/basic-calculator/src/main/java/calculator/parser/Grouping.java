package calculator.parser;

public class Grouping implements Expr{

    public final Expr expression;

    Grouping(Expr expression){
        this.expression = expression;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visitGroupingExpr(this);
    }
}
