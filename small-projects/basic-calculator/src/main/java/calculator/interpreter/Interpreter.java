package calculator.interpreter;

import calculator.parser.Binary;
import calculator.parser.Expr;
import calculator.parser.Grouping;
import calculator.parser.Literal;

public class Interpreter {

    public Object evaluate(Expr expr){
        if(expr instanceof Literal literal)
            return visitLiteral(literal);

        if(expr instanceof Grouping grouping)
            return visitGrouping(grouping);

        if(expr instanceof Binary binary)
            return visitBinary(binary);

        throw new RuntimeException("Unknown expression");
    }

    private Object visitLiteral(Literal literal) {
        return literal.value;
    }

    private Object visitGrouping(Grouping grouping) {
        return evaluate(grouping.expression);
    }

    private Object visitBinary(Binary binary) {
        Object left = evaluate(binary.left);
        Object right = evaluate(binary.right);

        if (!(left instanceof Integer) ||
                !(right instanceof Integer)) {
            throw new RuntimeException(
                    "Operands must be integers"
            );
        }

        int leftValue = (Integer) left;
        int rightValue = (Integer) right;

        return switch(binary.operator.type){
            case PLUS -> leftValue+rightValue;
            case MINUS -> leftValue-rightValue;
            case STAR -> leftValue*rightValue;
            case SLASH -> {
                if (rightValue == 0) {
                    throw new RuntimeException("Division by zero");
                }
                yield leftValue / rightValue;
            }
            default ->
                    throw new RuntimeException("Unknown operator: " + binary.operator.type);
        };
        }
    }
