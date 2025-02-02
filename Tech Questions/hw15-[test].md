Explain and compare following concepts, provide specific examples when doing comparison:
Testing related:
1. Unit Testing
> test functions/methods
2. Functional Testing
> test functionality/features
3. Integration Testing
> different components work together as expected
4. Regression Testing
> new code doesn't introduce bugs on existing functionality
5. Smoke Testing
> hardware testing -> smoke appears,meaning serious issue exists and further testing is pointless
> basic, preliminary test to test the most critical functionalities, make sure build is stable enough
> Scenario: Testing an E-commerce Website
A Smoke Test for an online shopping website might include:
✅ Checking if the homepage loads.
✅ Verifying user login functionality.
✅ Ensuring product search works.
✅ Confirming users can add items to the cart.
✅ Checking if checkout completes successfully.
If any of these fail, the build is rejected and sent back for fixes before deeper testing.
6. Performance Testing
>test under expected and extreme workloads
7. A/B Testing
> UX experiment, user group a and b to check click-through rates, conversions
8. User Acceptance Testing
> final phase, real user test before going live

   Environment related:
      1. Development
      2. QA (Quality Assurance)
      3. Pre-prod/Staging
      4. Production
         Write unit test using Junit and PowerMock for following code (a static http client method which calls an
         external public API):


1. List and explain all the new learned annotations to your annotations.md
2. What is the lifecycle of Junit?
> 1️⃣ @BeforeAll (Runs once before all tests)
2️⃣ @BeforeEach (Runs before each test)
3️⃣ @Test (Runs the actual test case)
4️⃣ @AfterEach (Runs after each test)
5️⃣ @AfterAll (Runs once after all tests)
3. Explain parameterized testing?
>Parameterized testing is a technique in unit testing where a test method runs multiple times with different sets of input values. Instead of writing multiple similar test cases, you define a single test case that executes with various inputs.
4. Explain Mockito and PowerMock .
5. Compare @Mock and @InjectMocks
>@Mock, create a mock instance of a class, to stub dependencies, manual initialization needed -> MockitoAnnotations.openMocks(this)
>@InjectMocks, create an instance of a class and automatically inject mocks, to test the actual class
 ```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Enables Mockito
class UserControllerTest {

    @Mock
    private UserService userService; // Mocked dependency

    @InjectMocks
    private UserController userController; // Class under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes @Mock annotations (if not using @ExtendWith)
    }

    @Test
    void testGetUser() {
        // Mock behavior
        when(userService.getUserById(1)).thenReturn(new User(1, "John"));

        // Call the method
        User user = userController.getUserById(1);

        // Verify result
        assertEquals("John", user.getName());
        verify(userService).getUserById(1); // Ensure mock was used
    }
}

```
6. Explain stubbing .
> Define the behavior of a mock object when a specific method is called.
>// Stub the method
>when(userService.getUserName(1)).thenReturn("John Doe");
> // Test the stubbed behavior
assertEquals("John Doe", userService.getUserName(1));
assertNull(userService.getUserName(2));
7. what is Mockito ArgumentMatchers
8. >ArgumentMatchers allow us to match method arguments dynamically instead of specifying exact values.
```java
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArgumentMatcherTest {

    @Test
    void testArgumentMatcher() {
        UserService userService = mock(UserService.class);

        // Use ArgumentMatcher anyInt()
        when(userService.getUserName(anyInt())).thenReturn("Mocked User");

        // Verify any input returns the same result
        assertEquals("Mocked User", userService.getUserName(123));
        assertEquals("Mocked User", userService.getUserName(999));
    }
}

```
8. Compare @spy and @Mock?
>@Mock Creates a fully mocked object (all methods stubbed)	, when(mock.method()).thenReturn(value);
> @spy Creates a partial mock (real methods are called unless stubbed), doReturn(value).when(spy).method();
```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpyMockExampleTest {

    @Test
    void testMockAndSpy() {
        // Mock object - does NOT call real methods
        UserService mockService = mock(UserService.class);
        when(mockService.getUserName(1)).thenReturn("Mocked User");
        
        // Spy object - calls real methods unless stubbed
        UserService spyService = spy(new UserService());
        doReturn("Spied User").when(spyService).getUserName(1);

        assertEquals("Mocked User", mockService.getUserName(1)); // Uses stubbed value
        assertEquals("Spied User", spyService.getUserName(1)); // Uses stubbed value
        assertEquals(spyService.defaultUserName(), spyService.getUserName(2)); // Calls real method
    }
}

```
9. Explain Assertion .
>An assertion is used in testing to verify that an expected condition holds true. If the assertion fails, the test fails.
10. Add unit tests for CommentServiceImpl under Redbook->branch 10_testing (fork or copy the project http
    s://github.com/CTYue/springboot-redbook),
1. Enrich logics inside CommentServiceImpl methods, add if-else conditions in each methods.
2. In CommentServiceImpl, add following method, remove modelMapper dependency, and replace all
   modelMapper.map() with this method, write unit test for commentServiceMapperUtil
   public static CommentDto commentServiceMapperUtil(Comment comment) {
   ModelMapper modelMapper = new ModelMapper();
   return modelMapper.map(comment, CommentDto.class);
   }
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class CommentServiceMapperUtilTest {

    @Test
    void testCommentServiceMapperUtil() {
        // Arrange: Create a sample Comment object
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setText("This is a test comment");
        comment.setAuthor("John Doe");

        // Act: Call the method to map it to CommentDto
        CommentDto commentDto = CommentServiceMapperUtil.commentServiceMapperUtil(comment);

        // Assert: Validate if mapping is correct
        assertNotNull(commentDto);
        assertEquals(comment.getId(), commentDto.getId());
        assertEquals(comment.getText(), commentDto.getText());
        assertEquals(comment.getAuthor(), commentDto.getAuthor());
    }
}


```
3. method coverage and branch coverage for CommentServiceImpl should be 100% (as much as you
   can)