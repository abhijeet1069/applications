package conditionalTestExecution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ConditionalTest {

    @Test
    @ExtendWith(NightOnlyCondition.class)
    void testRunsOnlyAtNight() {
        System.out.println("Running at night!");

    }
}