package manning.assertions;

import manning.assertions.Job;
import manning.assertions.NoJobException;
import manning.assertions.SystemUnderTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AssertionsExample {

    @Test
    void sut_when_created_should_default_to_not_verified() {
        SystemUnderTest sut = new SystemUnderTest("Our system under test");
        assertAll(
                ()->assertEquals("Our system under test",sut.getSystemName()),
                ()->assertFalse(sut.isVerified())
        );
    }

    @Test
    void sut_should_throw_exception_when_run_with_no_jobs(){
        SystemUnderTest sut= new SystemUnderTest("Our system under stress");
        assertThrows(NoJobException.class, sut::run);

        Throwable throwable = assertThrows(NoJobException.class,()-> sut.run(1000));
        assertEquals("No jobs on the execution list!",throwable.getMessage());
    }

    @Test
    void job_should_execute_within_timeout() throws InterruptedException {
        SystemUnderTest sut = new SystemUnderTest("Our system under test");
        sut.addJob(new Job("Job 1"));
        // will allow task to run 200 ms
        assertTimeout(Duration.ofMillis(300),()-> sut.run(200));
    }

    @Test
    void job_should_execute_within_timeout_preemptively() throws InterruptedException {
        SystemUnderTest sut = new SystemUnderTest("Our system under test");
        sut.addJob(new Job("Job 1"));
        // will stop task within given duration, doesent matter task completes or not
        assertTimeoutPreemptively(Duration.ofMillis(250),()-> sut.run(200));
    }
}