package lifecycleCallback;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private long start;
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        start = System.currentTimeMillis();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        long duration = System.currentTimeMillis()-start;
        System.out.println("Test took: "+duration+" ms");
    }
}
