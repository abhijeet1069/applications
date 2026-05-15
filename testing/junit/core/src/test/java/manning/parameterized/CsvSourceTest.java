package manning.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({
            "hello world, 11",
            "JUnit 5, 7"
    })
    void calculateStringLength(String str, int expectedLength){
        assertEquals(expectedLength,str.length());
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, fe, 11",
            "JUnit 5,abra cadabra, 12"
    })
    void findLengthOfMaxString(String str1, String str2, int expectedLen){
        int maxLen = Math.max(str1.length(), str2.length());
        assertEquals(expectedLen,maxLen);
    }
}
