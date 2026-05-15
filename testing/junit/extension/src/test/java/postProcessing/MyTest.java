package postProcessing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectMessageExtension.class)
public class MyTest {
    String message;

    @Test
    void test(){
        System.out.println(message);
    }
}
