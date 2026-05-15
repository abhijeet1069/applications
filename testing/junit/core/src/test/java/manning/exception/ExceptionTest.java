package manning.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    void shouldThrowExceptionWithMessage(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,()->validateAge(-1));
        assertEquals("Age cannot be negative",ex.getMessage());
    }

    void validateAge(int age){
        if(age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
    }
}
