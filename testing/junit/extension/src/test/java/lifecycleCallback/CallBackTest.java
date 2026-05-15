package lifecycleCallback;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class CallBackTest {

    @Test
    @ExtendWith(TimingExtension.class)
    void slowTest() throws InterruptedException {
        Thread.sleep(500);
    }
    //OP : Test took: 510 ms
}
