# JUnit 5 extension model

JUnit 5 can extend the behavior of tests’ classes or methods, and these extensions
can be reused by many tests. 

A JUnit 5 extension is connected to an occurrence of a particular event during the execution of a test. 
This kind of event is called an extension  point.

## Extension points

- Conditional test execution : Runs test only if a condition is true
       Skip tests dynamically

- Life-cycle callback : Reacts to events in the life cycle of a test
        Setup/logging/timing

- Parameter resolution : At runtime, resolves the parameter received by a test
        Inject data into tests

- Exception handling : Defines the behavior of a test when it encounters certain types of exceptions
        Control failure behavior        

- Test instance postprocessing : Executed after an instance of a test is created
        Modify test object