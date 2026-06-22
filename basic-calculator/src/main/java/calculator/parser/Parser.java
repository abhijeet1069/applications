package calculator.parser;

import calculator.lexer.Token;
import calculator.lexer.TokenType;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }

    public Expr parse(){
        return expression();
    }
    /*
     * expression -> term
     *              ( ("+" | "-") term )*
     */
    private Expr expression() {
        Expr expr = term();
        while (match(TokenType.PLUS,
                TokenType.MINUS)) {
            Token operator = previous();
            Expr right = term();
            expr = new Binary(
                    expr,
                    operator,
                    right
            );
        }
        return expr;
    }

    /*
     * term -> factor
     *         ( ("*" | "/") factor )*
     */
    private Expr term() {
        Expr expr = factor();
        while (match(TokenType.STAR,
                TokenType.SLASH)) {
            Token operator = previous();
            Expr right = factor();
            expr = new Binary(
                    expr,
                    operator,
                    right
            );
        }
        return expr;
    }

    /*
     * factor -> NUMBER
     *         | "(" expression ")"
     */
    private Expr factor() {
        if (match(TokenType.NUMBER)) {
            return new Literal(
                    Integer.parseInt(previous().lexeme)
            );
        }
        if (match(TokenType.LEFT_PAREN)) {
            Expr expr = expression();
            consume(TokenType.RIGHT_PAREN, "Expected ')'");
            return new Grouping(expr);
        }
        throw error("Expected expression");
    }

    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }
        return false;
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) {
            return false;
        }
        return peek().type == type;
    }

    private Token advance() {
        if (!isAtEnd()) {
            current++;
        }
        return previous();
    }

    private boolean isAtEnd() {
        return peek().type == TokenType.EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Token consume(TokenType type, String message) {
        if (check(type)) {
            return advance();
        }
        throw error(message);
    }

    private RuntimeException error(String message) {
        return new RuntimeException(message);
    }
}