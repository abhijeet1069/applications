package parameterResolution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ParameterResolutionTest {

    @Test
    @ExtendWith(RandomNumberResolver.class)
    void testRandom(int number){
        System.out.println("Injected number: "+number);
    }
}
