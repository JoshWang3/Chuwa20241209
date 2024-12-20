# HW4
## Questions:
### 1. Learn Java generics by reading and practicing following code:
code: /Coding/HW4/
### 2. Read the following code repo and type it one by one by yourself.
code: /Coding/HW4/
### 3. Practice following stream API exercises at least 3 times
code: /Coding/HW4/
### 4. Practice Optional methods at least 2 times
code: /Coding/HW4/

### 5. Discuss best practices on nullptr exception prevention ,provide code snippet for each practice that you mentioned.
code: /Coding/HW4/

### 6. Discuss Java 8 new features with code snippet.
code: /Coding/HW4/

### 7. What are the advantages of the Optional class?
1. Could be to wrap data before returning, adding some flexibility to throw exceptions
2. Perform extra checks on data retrieved, getter or local variables

### 8. Explain Functional Interface and Lambda with code samples.
code: /Coding/HW4/

### 9. Explain Method Reference with code samples?
code: /Coding/HW4/

### 10. Explain "Lambda can use unchanged variable outside of lambda", with code snippet.
code: /Coding/HW4/

### 11. Can a functional interface extend/inherit another interface?
Yes, as long as the parent interface is
1. Default methods
2. Static methods
3. Methods from `Object` (e.g. toString, hashcode)


### 12. What are Intermediate and Terminal operations?
**Intermediate Operations**: the operations take a stream as input and produce a new stream as output. It just modify the element or structure of the stream. Can be chained using `filter()`, `map()`, `sorted`, `distinct`

**Terminal Operations**: consume the stream and give a final result, like `collect()`, `forEach()`, `reduce()`, `count()`, `min()/max()` 

### 13. Demontrate the most commonly used Intermediate operations in Stream API, with code snippet.
code: /Coding/HW4/

### 14. How are Collections different from Stream?
1. Stream API used for processing data, while Collections can store data
2. Stream API is lazy (intermediate ops), Collections will be computed
3. Stream elements cannot be modified

### 15. Implement Stream API's filter and map methods by your self.
code: /Coding/HW4/
