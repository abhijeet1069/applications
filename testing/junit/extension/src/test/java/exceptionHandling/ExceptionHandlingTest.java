package exceptionHandling;

import lifecycleCallback.TimingExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ExceptionHandlingTest {

    @Test
    @ExtendWith(IgnoreIllegalArgument.class)
    void testException(){
        throw new IllegalArgumentException("Invalid input");
    }
}
