package manning.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Output:
 * supportsParameter called
 * resolveParameter called
 * Hello from injected service
 * */

@ExtendWith(GreetingResolver.class)
public class DependencyInjectionTest {

    @Test
    void testGreeting(GreetingService service){
        System.out.println(service.greet());
    }
}
