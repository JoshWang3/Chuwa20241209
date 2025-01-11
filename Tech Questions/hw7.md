## 1. GET APIs

### GET-1
**API**: `https://ghibliapi.herokuapp.com/locations`

**Response Status**: 200 OK

**Response**:
```json
[
    {
        "id": "11014596-71b0-4b3e-b8c0-1c4b15f28b9a",
        "name": "Irontown",
        "climate": "Continental",
        "terrain": "Mountain"
    }
]
```

### GET-2
**API**: `https://api.agify.io/?name=michael`

**Response Status**: 200 OK

**Response**:
```json
{
    "name": "michael",
    "age": 69,
    "count": 1532
}
```

### GET-3
**API**: `https://catfact.ninja/fact`

**Response Status**: 200 OK

**Response**:
```json
{
    "fact": "Cats have five toes on their front paws, but only four on the back ones.",
    "length": 76
}
```

### GET-4
**API**: `https://api.coindesk.com/v1/bpi/currentprice.json`

**Response Status**: 200 OK

**Response**:
```json
{
    "time": {
        "updated": "Jan 10, 2025",
        "updatedISO": "2025-01-10T00:03:00+00:00"
    },
    "bpi": {
        "USD": {
            "code": "USD",
            "rate": "43,219.3167"
        }
    }
}
```

### GET-5
**API**: `https://pokeapi.co/api/v2/pokemon/ditto`

**Response Status**: 200 OK

**Response**:
```json
{
    "name": "ditto",
    "base_experience": 101,
    "abilities": [
        {
            "ability": {
                "name": "limber",
                "url": "https://pokeapi.co/api/v2/ability/7/"
            }
        }
    ]
}
```

## 2. POST APIs

### POST-1
**API**: `https://jsonplaceholder.typicode.com/posts`

**Request Body**:
```json
{
    "title": "foo",
    "body": "bar",
    "userId": 1
}
```

**Response Status**: 201 Created

**Response**:
```json
{
    "id": 101
}
```

### POST-2
**API**: `https://reqres.in/api/users`

**Request Body**:
```json
{
    "name": "morpheus",
    "job": "leader"
}
```

**Response Status**: 201 Created

**Response**:
```json
{
    "id": "123",
    "createdAt": "2025-01-10T12:34:56.789Z"
}
```

## 3. PUT APIs

### PUT-1
**API**: `https://jsonplaceholder.typicode.com/posts/1`

**Request Body**:
```json
{
    "id": 1,
    "title": "updated title",
    "body": "updated body",
    "userId": 1
}
```

**Response Status**: 200 OK

**Response**:
```json
{
    "id": 1,
    "title": "updated title",
    "body": "updated body",
    "userId": 1
}
```

## 4. DELETE APIs

### DELETE-1
**API**: `https://jsonplaceholder.typicode.com/posts/1`

**Response Status**: 200 OK

### DELETE-2
**API**: `https://reqres.in/api/users/2`

**Response Status**: 204 No Content

## HTTP Status Codes

- **404 Not Found**: Invalid endpoint (e.g., `https://api.example.com/invalid`)
- **401 Unauthorized**: Missing authentication token (e.g., private APIs requiring login)
- **500 Internal Server Error**: Server failure during API execution.
