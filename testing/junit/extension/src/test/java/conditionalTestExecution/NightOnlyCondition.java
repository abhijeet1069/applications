package conditionalTestExecution;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.LocalTime;

public class NightOnlyCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        int hour = LocalTime.now().getHour();
        int limit = 20;
        if(hour >= limit)
            return ConditionEvaluationResult.enabled("Night time");
        return ConditionEvaluationResult.disabled("Skipping test, Current hour = %d , Try post %d"
                .formatted(hour,limit));
    }
}