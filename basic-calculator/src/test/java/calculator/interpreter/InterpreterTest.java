package calculator.interpreter;

import calculator.lexer.Lexer;
import calculator.lexer.Token;
import calculator.parser.Expr;
import calculator.parser.Parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void evaluate(int expected, String source) {
        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.scanTokens();
        Parser parser = new Parser(tokens);
        Expr expr = parser.parse();
        Interpreter interpreter = new Interpreter();
        Object result = interpreter.evaluate(expr);
        assertEquals(expected,result);
    }

    static Stream<Arguments> testCases(){
        return Stream.of(
                Arguments.of(
                        15,
                        "1 + 2 * (3 + 4)"
                ),
                Arguments.of(
                        28,
                        "1+2+4+5+6+10"
                ),
                Arguments.of(
                        2,
                        "(1/2)+(2/4)+(1*2)"
                )
        );
    }
}