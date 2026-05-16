package calculator.parser;

public interface ExprVisitor<T> {
    T visitBinaryExpr(Binary expr);
    T visitLiteralExpr(Literal expr);
    T visitGroupingExpr(Grouping expr);
}
