package calculator.parser;

import calculator.lexer.Lexer;
import calculator.lexer.Token;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @ParameterizedTest
    @MethodSource("parserTestCases")
    void should_build_valid_ast(String source, String expectedAst){
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();
        Parser parser = new Parser(tokens);
        Expr ast = parser.parse();
        AstPrinter printer = new AstPrinter();
        String actualAst = printer.print(ast);
        assertEquals(expectedAst,actualAst);
    }

    static Stream<Arguments>
    parserTestCases() {
        return Stream.of(
                Arguments.of(
                        "2 + 3",
                        "(+ 2 3)"
                ),
                Arguments.of(
                        "2 + 3 * 4",
                        "(+ 2 (* 3 4))"
                ),
                Arguments.of(
                        "10 - 5 - 2",
                        "(- (- 10 5) 2)"
                ),
                Arguments.of(
                        "8 / 2 * 3",
                        "(* (/ 8 2) 3)"
                ),
                Arguments.of(
                        "23 / 443 * 223",
                        "(* (/ 23 443) 223)"
                ),
                Arguments.of(
                        "8 / (2 * 3)",
                        "(/ 8 (group (* 2 3)))"
                )
        );
    }
}