package spring;


import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static spring.PassengerUtil.getExpectedPassenger;

public class SimpleAppTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    private ClassPathXmlApplicationContext context;

    private Passenger expectedPassenger;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(
                APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPassenger = getExpectedPassenger();
    }

    @Test
    public void testInitPassenger() {
        Passenger passenger = (Passenger) context.getBean("passenger");
        assertEquals(expectedPassenger, passenger);
        System.out.println(passenger);
    }
}
