1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
   understand it. you need to update it when you learn a new annotation. Please organize those annotations
   well, like annotations used by entity, annotations used by controller. 
File name: annotations.md
    you'd better also list a code example under the annotations.  


2. how the below annotaitons specify the table in database?
    
    >   @Column(columnDefinition = "varchar(255) default 'John Snow'")
         private String name;
    >     @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
         private String studentName;
   
      `Map name field in the entity class to a column in the db table. The column has a maximum length of 255 characters with a default value of 'John snow'. `  
      `Map studentName field in the class to a column named "STUDENT_NAME" in the db table. The column has a max len of 50 characters, not null, duplicates acceptable.`
  

3. default column names of the table in database for @Column ?
   >   @Column
         private String firstName;
         @Column
         private String operatingSystem;

   `Default column name is inferred based on the field of class names. "firstName" and "operatingSystem" in this case.`  


4. What are the layers in springboot application? what is the role of each layer?

   `Presentation layer - entry point for the application to the user, take user requests and send responses back.
    Service layer - handle the business logic, transactions and concerns like caching and validation.
    Data layer - use Spring Data JPA to interact with database to provide CRUD operations.`  

  
5. Describe the flow in all of the layers if an API is called by Postman.  

   `Use "get" request as an example. User makes a GET request to an url. Spring boot application receives the request and routes to the corresponding controller method. The
controller passes the data to the service layer for processing and respondes with the result. The service layer do some checks and then call the data layer to fetch data. The data layer uses Spring data JPA to do queries in the database.`  

6.  What is the application.properties? do you know application.yml?  

    `Both are used to add settings such as database setting, server ports, security settings for the application. application.properties uses key=value syntax. Yaml is a format allowing nested structures and easier to represent complex configurations.` 
  

7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?  
`Rest: resource oriented. HTTP methods + different endpoint. e.g. GET api/v1/users'. GraphQL: query oriented. Naming reflects actions, including queries, mutations. A single endpoint /graphql for all operations.`
  `The diff lies in different naming design: rest apis are based on predefined resources and http methods while graphql focuses on queries and mutations. `  
  

8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.  
`Fetch users and all their orders. Fetch companies and all their open positions. Fetch books and all their authors.`

  
9. Finish all the following API
   REST
   GET/PUT/DELETE post (with exception cases)
   POST/GET/PUT/DELETE comment (you need to design the table and its relation with Post)
   POST/GET/PUT/DELETE author (you need to design the table and its relation with Post)
   GraphQL
   Query postByID, getAllPost
   Mutation createPost, updatePost
10. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
    MongoDB;
