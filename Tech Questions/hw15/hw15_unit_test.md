## Explain and compare following concepts, provide specific examples when doing comparison:
    Testing related:
        1. Unit Testing
            Testing the smallest testable units of a program, such as functions or methods. Verify the correctness of individual components. 
            Example: test a new function in existing module.
        2. Functional Testing
            Testing functions of a single component/module. Verify the functions of single component/module. 
            Example, test a newly develop module.
        3. Integration Testing
            Testing the interactions between multiple components or modules. Verify that the collaboration between components or modules is correct. 
            Example, test with your partner application
        4. Regression Testing
            After modifying the program or environment, re-run previously run tests to confirm that no new errors have been introduced. Ensure that after changes, existing functionality is still correct
            Example: Test the production logic is not affected by new method. 
        5. Smoke Testing
            A.K.A Build verification test, it is part of the CICD pipeline, it verifies if the newly deployed executable performs basic functions, if yes, then continue with futher tests and stages, if not, it stops the pipeline.
            Ensure new executable performs basic functions.
            Example: test before in to production. Test newly develop function works.
        6. Performance Testing
            Testing the performance and response time of a system under a specific workload. Verify the performance and efficiency of the system -> 200ms
            Example: call a api. check the time.
        7. A/B Testing
            A/B testing is widely used in software development to evaluate and compare different implementations of features, designs, or user experiences in a controlled environment. 
            The goal is to use real-world user data to identify the best-performing option, whether it's a UI design, a product feature, or a backend process.
        8. User Acceptance Testing:
            The end user tests the software to confirm that it can perform the required tasks under actual conditions. Ensure that the software meets user needs and expectations.
    Environment related:
        1. Development: Unit Test, Functional Test, Integration Test
        2. QA (Quality Assurance): Regression Test, End-to-End test
        3. Pre-prod/Staging: Smoke Test, Preformance Test, UAT
        4. Production: A/B Test
## Write unit test using Junit and PowerMock for following code (a static http client method which calls an external public API):
    Use Mockito 5 -> fail to new URL("example.com")
    Change to not static method. And use MockedConstruction to solve the issue. 
    See Coding/hw14/redbook/src/test/java/com/chuwa/redbook/util/http/HttpClientServiceTest.java

    