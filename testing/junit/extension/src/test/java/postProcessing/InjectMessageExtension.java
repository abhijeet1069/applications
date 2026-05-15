package postProcessing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class InjectMessageExtension implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        if(testInstance instanceof MyTest)
            ((MyTest) testInstance).message = "Hello from extension!";
    }
}
