package calculator.parser;

public class Literal implements Expr{

    public final int value;

    public Literal(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visitLiteralExpr(this);
    }
}
