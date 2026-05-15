package exceptionHandling;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class IgnoreIllegalArgument implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable ex) throws Throwable {
        if(ex instanceof IllegalArgumentException){
            System.out.println("Ignored Exception: "+ex.getMessage());
            return;
        }
        throw ex;
    }
}
