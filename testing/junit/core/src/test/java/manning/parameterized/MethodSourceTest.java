package manning.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("stringListData")
    void should_return_list_of_strings_length(List<String> input, List<Integer> expected) {
        assertEquals(expected, getLength(input));
    }

    static Stream<Arguments> stringListData(){
        return Stream.of(
                Arguments.of(
                        List.of("Fe","Fi","Fo","Fum"),
                        List.of(2,2,2,3)
                ),
                Arguments.of(
                        List.of("I","will","find","him","I","will","beat","him"),
                        List.of(1,4,4,3,1,4,4,3)
                )
        );
    }

    public List<Integer> getLength(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for(String str : input)
            result.add(str.length());
        return result;
    }
}