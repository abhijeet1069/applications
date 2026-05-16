package calculator.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int current = 0;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            char ch = advance();
            switch (ch) {
                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-"));
                    break;
                case '*':
                    tokens.add(new Token(TokenType.STAR, "*"));
                    break;
                case '/':
                    tokens.add(new Token(TokenType.SLASH, "/"));
                    break;
                case '(':
                    tokens.add(new Token(TokenType.LEFT_PAREN, "("));
                    break;
                case ')':
                    tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
                    break;
                case ' ':
                case '\t':
                case '\n':
                    break;
                default:
                    if (Character.isDigit(ch)) {
                        number(ch);
                    }
                    else {
                        throw new RuntimeException(
                                "Unexpected character: " + ch);
                    }
            }
        }
        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;

    }

    private void number(char firstDigit) {
        StringBuilder builder = new StringBuilder();
        builder.append(firstDigit);
        while (!isAtEnd() &&
                Character.isDigit(peek())) {
            builder.append(advance());
        }
        tokens.add(
                new Token(
                        TokenType.NUMBER,
                        builder.toString()
                )
        );
    }

    private char advance() {
        return source.charAt(current++);
    }

    private char peek() {
        if (isAtEnd()) {
            return '\0';
        }
        return source.charAt(current);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

}
