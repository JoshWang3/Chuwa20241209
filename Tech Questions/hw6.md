# HW6

____

### Relational Database

1. Create `oms_company_address` table

```mysql
CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY, 
    address_name VARCHAR(200),
    send_status INT(1),
    receive_status INT(1),
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200)
)
```

2. Insert some random data to `oms_company_address` table

```mysql
INSERT INTO oms_company_address (
    id, 
    address_name, 
    send_status, 
    receive_status, 
    name, 
    phone, 
    province, 
    city, 
    region, 
    detail_address
) 
VALUES
    (1, 'Head Office', 1, 0, 'John Doe', '1234567890', 'California', 'Los Angeles', 'Downtown', '123 Main Street'),
    (2, 'Branch Office', 0, 1, 'Jane Smith', '0987654321', 'New York', 'New York City', 'Manhattan', '456 Park Avenue'),
    (3, 'Warehouse', 1, 1, 'Alice Johnson', '1122334455', 'Texas', 'Austin', 'North Austin', '789 Elm Street'),
    (4, 'Customer Service', 0, 0, 'Bob Brown', '6677889900', 'Florida', 'Miami', 'South Beach', '321 Ocean Drive'),
    (5, 'R&D Center', 1, 0, 'Charlie Davis', '5566778899', 'Washington', 'Seattle', 'Downtown', '654 Pine Street');
```

3. Write a SQL query to fetch all data from `oms_company_address` table

```mysql
SELECT * FROM oms_company_address;
```

4. Write a SQL query to fetch top 3 records from `oms_company_address` table

```mysql
SELECT * FROM oms_company_address 
LIMIT 3;
```

5. Update `oms_company_address` table to set all `phone` to 666-6666-8888

```mysql
UPDATE oms_company_address 
SET phone = '666-6666-8888';
```

6. Delete one entry from `oms_company_address` table

```mysql
DELETE FROM oms_company_address
LIMIT 1;
```

### Non-SQL Database

1. Create `test` DB
```mongodb-json
use test
```

2. Create `oms_company_address` collection
```mongodb-json
db.createCollection("oms_company_address")
```

3. Insert few random entries to `oms_company_address` collection
```mongodb-json
db.oms_company_address.insert([
    {
        id: 1,
        address_name: 'Head Office',
        send_status: 1,
        receive_status: 0,
        name: 'John Doe',
        phone: '1234567890',
        province: 'California',
        city: 'Los Angeles',
        region: 'Downtown',
        detail_address: '123 Main Street'
    },
    {
        id: 2,
        address_name: 'Branch Office',
        send_status: 0,
        receive_status: 1,
        name: 'Jane Smith',
        phone: '0987654321',
        province: 'New York',
        city: 'New York City',
        region: 'Manhattan',
        detail_address: '456 Park Avenue'
    },
    {
        id: 3,
        address_name: 'Warehouse',
        send_status: 1,
        receive_status: 1,
        name: 'Alice Johnson',
        phone: '1122334455',
        province: 'Texas',
        city: 'Austin',
        region: 'North Austin',
        detail_address: '789 Elm Street'
    },
    {
        id: 4,
        address_name: 'Customer Service',
        send_status: 0,
        receive_status: 0,
        name: 'Bob Brown',
        phone: '6677889900',
        province: 'Florida',
        city: 'Miami',
        region: 'South Beach',
        detail_address: '321 Ocean Drive'
    },
    {
        id: 5,
        address_name: 'R&D Center',
        send_status: 1,
        receive_status: 0,
        name: 'Charlie Davis',
        phone: '5566778899',
        province: 'Washington',
        city: 'Seattle',
        region: 'Downtown',
        detail_address: '654 Pine Street'
    },
])
```

4. Read one entry from `oms_company_address` collection
```mongodb-json
db.oms_company_address.find().limit(1)
```

5. Read all entries from `oms_company_address` collection
```mongodb-json
db.oms_company_address.find()
```

6. Update one entry in `oms_company_address` collection
```mongodb-json
db.oms_company_address.update(
    { id: 1 },
    { $set: { phone: '666-6666-8888', name: 'Li' } }
)
```

7. Remove one entry from `oms_company_address` collection
```mongodb-json
db.oms_company_address.remove({ id: 1 })
```
































