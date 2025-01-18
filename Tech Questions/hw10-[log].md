1. Is System.out.print thread safe?
   Write code using thread pool and multi-thread to answer this question.
2. Why do we NOT use System.out.print for logging in Spring? Why do we use loggers such as Log4j?
3. If System.out.print is thread-safe, is there any other reason why we dislike it?
4. Explain slf4j logging levels, and what is included in slf4j logs.
5. Write a Spring boot Rest application (using Spring Web starter on ) from Scratch, prove it is a multithreaded application by nature (without explicit configuration) according to logs.
6. For your application in 5, make packaging type to war , deploy it to an external tomcat server,
   document how to deploy it, upload screenshot of each steps.
7. For your application in 5, write a global exception handler to render java exceptions to corresponding http
   statuses, explain your code with comments.