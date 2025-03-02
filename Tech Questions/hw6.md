\1. Create oms_company_address table

```sql
CREATE TABLE oms_company_address (
   id BIGINT PRIMARY KEY,
   address_name VARCHAR(200) NOT NULL,
   send_status INT(1) DEFAULT 0,
   receive_status INT(1) DEFAULT 0,
   name VARCHAR(64) NOT NULL,
   phone VARCHAR(64),
   province VARCHAR(64),
   city VARCHAR(64),
   region VARCHAR(64),
   detail_address VARCHAR(200)
   );
```

\2. Insert some random data to oms_company_address table

```sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
   (1, 'Branch Office', 1, 0, 'Alice Johnson', '234-567-8901', 'Texas', 'Houston', 'South', '7890 Pine Road'),
   (2, 'Sales Office', 0, 1, 'Bob Brown', '345-678-9012', 'Florida', 'Miami', 'East', '9012 Oak Street');
```

\3. Write a SQL query to fetch all data from oms_company_address `table

```sql
SELECT * FROM oms_company_address;
```

\4. Write a SQL query to fetch top 3 records from oms_company_address table

```sql
SELECT * FROM oms_company_address LIMIT 3;
```

\5. Update oms_company_address table to set all phone to 666-6666-8888

```sql
UPDATE oms_company_address SET phone = '666-6666-8888';
```

\6. Delete one entry from oms_company_address table

```sql
DELETE FROM oms_company_address WHERE id = 1;
```



\1. Create test DB

```js
use test;
```

\2. Create oms_company_address collection (method: createCollection() )

```js
db.createCollection("oms_company_address");
```

\3. Insert few random entries to oms_company_address collection (method: insert() )

```js
db.oms_company_address.insertMany([
    {
        address_name: "Distribution Center B",
        send_status: 0,
        receive_status: 1,
        name: "Jane Smith",
        phone: "987-654-3210",
        province: "Texas",
        city: "Dallas",
        region: "South",
        detail_address: "5678 Industrial Area"
    },
    {
        address_name: "Headquarters",
        send_status: 1,
        receive_status: 1,
        name: "Alice Johnson",
        phone: "234-567-8901",
        province: "New York",
        city: "New York City",
        region: "East",
        detail_address: "9012 Business Park"
    }
]);
```

\4. Read one entry from oms_company_address collection (method: find() )

```js
db.oms_company_address.findOne();
```

\5. Read all entries from oms_company_address collection (method: find() )

```js
db.oms_company_address.find();
```

\6. Update one entry from oms_company_address collection (method: update() or save() )

```js
db.oms_company_address.update(
    { name: "Erin A" },
    { $set: { phone: "666-6666-8888" } }
);
```

\7. Remove one entry from oms_company_address collection (method: remove() )  

```js
db.oms_company_address.deleteOne({ name: "Erin A" });
```

