2. Checked vs unchecked exception:
   1. Checked exceptions are checked at compile time. The program will not compile if these exceptions are not handled.
      1. "try{....} catch(...) {...}"
   2. Unchecked exceptions are checked at runtime. The program will still compile but will throw exceptions during run time.
      1. "System.out.println(str) // str = null" (nullpointerexception)
3. No. Each try block can only have one finally block. 
4. The final result will be return value from the finally block.
5. Runtime vs Compile exceptions:
   1. runtime: occurs at runtime. 
   2. compile: checked at compile time. 
6. throw vs throws:
   1. throw: inside the method body
   2. throws: in the method signature.
7. Since the generic exception will handle all the exceptions, causing the specific handlers not being executed. The specific
   exceptions should appear first.
8. optional:
   1. optional is an object that can hold a value or be empty.
   2. To avoid nullpointerexceptions. 
   3. "optional<String> optional = Optional.ofNullable(null)";
9. The finally block is designed to execute cleanup code.
10. design patterns:
    1. singleton
    2. factory
    3. abstract factory
    4. builder
    5. prototype
11. SOLID:
    1. single responsibility
    2. open/closed
    3. Liskov substitution
    4. interface segregation
    5. dependency inversion
12. thread-safe
    1. use "synchronized" key word
13. open-closed:
    1. a software module should be open for extension but closed for modification.
    2. You can add new functionality but you can not alter the original code. 
14. Choose Answer 1.