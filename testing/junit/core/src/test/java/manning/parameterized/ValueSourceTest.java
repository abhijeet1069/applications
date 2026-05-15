package manning.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testIsPositive(int number){
        assertTrue(number>0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple","banana","orange"})
    void testIsNotBlank(String str){
        assertFalse(str.isEmpty());
    }

}
