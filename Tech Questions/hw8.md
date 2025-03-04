2. @Table specifies the table name and unique constraints. @Map fiedls to database columns and allows customization of column names, types, and constraints. 
3. By default, column names are the same as the field names, but they can be customized using the name attribute in @Column.
4. Layers:
   1. Controller: Handles HTTP requests
   2. Service: Contains business logic
   3. Repository: interacts with the database
   4. Model: represents the data
5. Work flow:
   1. A request is sent to the controller
   2. the controller processes the request and calls the appropriate service method
   3. the service method performs business logic and interacts with the repository
   4. the repository performs database operations and returns the result to the service layer
   5. the service layer returns the response to the controller
   6. the controller sens the response to the client
6. 
   1. application.properties: key-value paris for configuration
   2. application.yml: hierarchical and more readable configurations.
7. Rest vs GraphQL
   1. Rest: uses endpoints
   2. GraphQl: Uses a single endpoint with structure queries
8. N + 1:
   1. Fetch posts with their authors:
   2. Fetch orders with their items:
9. 