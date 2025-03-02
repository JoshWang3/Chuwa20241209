### Practice collection
### What is the checked exception and unchecked exception in Java, could you give one example?
- **_checked exception_**: Exceptions that are checked at compile-time. For example, _SQLException_, _FileNotFoundException_
- **_unchecked exception_**: These are detected at runtime. For example, _NullPointerException_,

### Can there be multiple finally blocks?
No, There can only be one finally block

### When both catch and finally return values, what will be the final result?
It will return value from the finally block.

### What is Runtime/unchecked exception? what is Compile/Checked Exception?
- **_checked exception_**: Exceptions that are checked at compile-time. For example, _SQLException_, _FileNotFoundException_
- **_unchecked exception_**: These are detected at runtime. For example, _NullPointerException_,

### What is the difference between throw and throws?
- **_throw_**: To manually throw an exception
- **_throws_**: To declare exceptions that a method might throw

### Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

```
public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}

Output: 
java.lang.ArithmeticException: / by zero
End ...

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}

Output: 
java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "s" is null
End ...

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        String s = null;
        try {
            // System.out.println(b / a);
            // System.out.println(s.equals("aa"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("End ...");
    }
}
Output:
End ...
java.lang.RuntimeException
```
Specific exceptions must be caught before general exceptions.

### What is optional? why do you use it? write an optional example.
- **optional class**: It is a container object which is used to contain a value that might or might not be present.
- **why use it**: It can help reduce the number of NullPointerExceptions that occur in java code.
```
public Optional<String> findUserNameById(String userId){
    User user = userRepository.findById(userId);
    return Optional.ofNullable(user != null ? user.getName() : null);
}
```
### Why finally always be executed ?
Java finally block can be used for clean-up (closing) the connections, files opened, streams, etc. those must be closed before exiting the program.

### Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection
- see Coding/HW3 

### What are the types of design patterns in Java ?
- **_Creational Design Patterns_**: Concerned with object creation mechanisms, creational patterns provide flexible ways to create objects while hiding the creation logic.
- Structural Design Patterns: Focus on composing objects and classes to form larger structures, simplifying the design and promoting code reuse.
- Behavioral Design Patterns: Address communication between objects and classes, defining how they interact and collaborate to accomplish tasks.

### What are the SOLID Principles ?
SOLID is an acronym for five principles that serve as a valuable standard.
- Single Responsibility Principle 
- Open-Closed Principle 
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

### How can you achieve thread-safe singleton patterns in Java ?
```
public class Singleton {

	private static volatile Singleton instance;
	private static Object mutex = new Object();

	private Singleton() {
	}

	public static Singleton getInstance() {
		Singleton result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new Singleton();
			}
		}
		return result;
	}

}
```
### What do you understand by the Open-Closed Principle (OCP) ?
The Open-Closed Principle (OCP) states that classes should be open for extension but closed for modification.

“**Open to extension**” means that you should design your classes so that new functionality can be added as new requirements are generated. 

“**Closed for modification**” means that once you have developed a class you should never modify it, except to correct bugs.

### Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. **_It means that if the object of type A can do something, the object of type B could also be able tp
  perform the same thing_**
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
   type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
### Watch the design pattern video, and type the code, submit it to MavenProject folder
- singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
- Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
- Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
- Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9