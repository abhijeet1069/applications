package calculator.parser;

public interface Expr {
    <T> T accept(ExprVisitor<T> visitor);
}
