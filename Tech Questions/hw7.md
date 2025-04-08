# HW 7

## REST API

## Postman practice

### Practice with below examples (You can find any Open APIs on the internet):

### 5 GET APIs with different response type

GET https://jsonplaceholder.typicode.com/api/v1/posts

````
# HW 7
## REST API
### Postman Practice

Practice using **5 different GET APIs** that return different **response types** (JSON, XML, plain text, etc.). You can test each in **Postman** or using `curl`.

---

### 1. GET - JSON Response

**API:**
`GET https://jsonplaceholder.typicode.com/posts`

**Description:**
Returns a list of placeholder blog posts in JSON format.

**Response Type:**
`application/json`

```json
[
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati",
    "body": "quia et suscipit\nsuscipit..."
  },
  ...
]
````

---

### 2. GET - XML Response

**API:**  
`GET https://www.w3schools.com/xml/note.xml`

**Description:**  
Returns a sample XML note.

**Response Type:**  
`application/xml`

```xml
<note>
  <to>Tove</to>
  <from>Jani</from>
  <heading>Reminder</heading>
  <body>Don't forget me this weekend!</body>
</note>
```

---

### 3. GET - Plain Text Response

**API:**  
`GET https://httpbin.org/plain`

**Description:**  
Returns plain text response for testing.

**Response Type:**  
`text/plain`

```text
Just some plain text.
```

---

### 4. GET - HTML Response

**API:**  
`GET https://example.com`

**Description:**  
Returns basic HTML content of the Example domain.

**Response Type:**  
`text/html`

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Example Domain</title>
  </head>
  <body>
    <p>This domain is for use in illustrative examples...</p>
  </body>
</html>
```

---

### 5. GET - Image Response

**API:**  
`GET https://via.placeholder.com/150`

**Description:**  
Returns a sample image (150x150 px) as binary.

**Response Type:**  
`image/png`

**How to test:**  
Paste the URL in a browser or use Postman to preview the image.

---

Let me know if you want to add headers, parameters, or turn this into a Postman collection!
