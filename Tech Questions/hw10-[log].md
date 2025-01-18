1. Is System.out.print thread safe?
   Write code using thread pool and multi-thread to answer this question.
> Yes

2. Why do we NOT use System.out.print for logging in Spring? Why do we use loggers such as Log4j?
> We cannot redirect output to a different destination. In production, we want to send log data to a central log server.
> We cannot configure log levels, context,

3. If System.out.print is thread-safe, is there any other reason why we dislike it?
>Yes, one thread can access the output at a time.

4. Explain slf4j logging levels, and what is included in slf4j logs.
>Timestamp, log level, thread,logger(class)  name, message, exception
> 
>2024-10-27 10:00:00.000 INFO  [main] com.example.MyClass - Application started.
2024-10-27 10:00:01.234 DEBUG [http-nio-8080-exec-1] com.example.MyService - Processing request for user: john.doe
2024-10-27 10:00:02.567 WARN  [http-nio-8080-exec-2] com.example.MyUtil - Resource usage approaching threshold.
2024-10-27 10:00:03.890 ERROR [main] com.example.Main - An error occurred: java.lang.NullPointerException: Some null value
at com.example.Main.main(Main.java:10)
... stack trace ...


5. Write a Spring boot Rest application (using Spring Web starter on ) from Scratch, prove it is a multithreaded application by nature (without explicit configuration) according to logs.

7. For your application in 5, make packaging type to war , deploy it to an external tomcat server,
   document how to deploy it, upload screenshot of each steps.

8. 8.For your application in 5, write a global exception handler to render java exceptions to corresponding http
   statuses, explain your code with comments.