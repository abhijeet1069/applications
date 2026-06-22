package calculator.lexer;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LexerTest {

    @Nested
    class ForValidInputs{

        @ParameterizedTest
        @MethodSource("arithmeticTokenTestCases")
        void should_tokenize_arithmetic_expressions(String input,
                                                    List<TokenExpectation> expectedTokens){
            Lexer lexer = new Lexer(input);
            List<Token> actualTokens = lexer.scanTokens();
            assertEquals(expectedTokens.size(), actualTokens.size());
            for(int i = 0; i < expectedTokens.size(); i++){
                Token actual = actualTokens.get(i);
                TokenExpectation expected = expectedTokens.get(i);
                assertEquals(expected.type(), actual.type);
                assertEquals(expected.lexeme(), actual.lexeme);
            }
        }

        static Stream<Arguments> arithmeticTokenTestCases() {
            return Stream.of(
                    Arguments.of(
                            "12 + 34",
                            List.of(
                                    new TokenExpectation(TokenType.NUMBER, "12"),
                                    new TokenExpectation(TokenType.PLUS, "+"),
                                    new TokenExpectation(TokenType.NUMBER, "34"),
                                    new TokenExpectation(TokenType.EOF, "")
                            )
                    ),
                    Arguments.of(
                            "1 + 2 - 3",
                            List.of(
                                    new TokenExpectation(TokenType.NUMBER, "1"),
                                    new TokenExpectation(TokenType.PLUS, "+"),
                                    new TokenExpectation(TokenType.NUMBER, "2"),
                                    new TokenExpectation(TokenType.MINUS, "-"),
                                    new TokenExpectation(TokenType.NUMBER, "3"),
                                    new TokenExpectation(TokenType.EOF, "")
                            )
                    ),
                    Arguments.of(
                            "7*8/2",
                            List.of(
                                    new TokenExpectation(TokenType.NUMBER, "7"),
                                    new TokenExpectation(TokenType.STAR, "*"),
                                    new TokenExpectation(TokenType.NUMBER, "8"),
                                    new TokenExpectation(TokenType.SLASH, "/"),
                                    new TokenExpectation(TokenType.NUMBER, "2"),
                                    new TokenExpectation(TokenType.EOF, "")
                            )
                    ),
                    Arguments.of(
                            "7*(8/2)",
                            List.of(
                                    new TokenExpectation(TokenType.NUMBER, "7"),
                                    new TokenExpectation(TokenType.STAR, "*"),
                                    new TokenExpectation(TokenType.LEFT_PAREN, "("),
                                    new TokenExpectation(TokenType.NUMBER, "8"),
                                    new TokenExpectation(TokenType.SLASH, "/"),
                                    new TokenExpectation(TokenType.NUMBER, "2"),
                                    new TokenExpectation(TokenType.RIGHT_PAREN, ")"),
                                    new TokenExpectation(TokenType.EOF, "")
                            )
                    )
            );
        }

    }

    @Nested
    class ForInvalidInputs{
        @ParameterizedTest
        @MethodSource("invalidInputCases")
        void should_throw_exception_for_invalid_input(String input, String expectedMessage) {
            Lexer lexer = new Lexer(input);
            RuntimeException exception = assertThrows(RuntimeException.class, lexer::scanTokens);
            assertEquals(expectedMessage, exception.getMessage());
        }

        static Stream<Arguments> invalidInputCases() {
            return Stream.of(
                    org.junit.jupiter.params.provider.Arguments.of(
                            "2 + @",
                            "Unexpected character: @"
                    ),
                    org.junit.jupiter.params.provider.Arguments.of(
                            "#",
                            "Unexpected character: #"
                    ),
                    org.junit.jupiter.params.provider.Arguments.of(
                            "10 & 20",
                            "Unexpected character: &"
                    )
            );
        }
    }
    record TokenExpectation(TokenType type, String lexeme){}
}
