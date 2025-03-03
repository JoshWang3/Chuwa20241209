# hw6
## MySQL - Relational Database
### Create oms_company_address table
```sql
CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键 ID',
    address_name VARCHAR(200) NOT NULL COMMENT '地址名称',
    send_status INT(1) NOT NULL DEFAULT 0 COMMENT '默认发货地址: 0->否; 1->是',
    receive_status INT(1) NOT NULL DEFAULT 0 COMMENT '默认收货地址: 0->否; 1->是',
    name VARCHAR(64) NOT NULL COMMENT '收发货人姓名',
    phone VARCHAR(64) NOT NULL COMMENT '收货人电话',
    province VARCHAR(64) NOT NULL COMMENT '省/直辖市',
    city VARCHAR(64) NOT NULL COMMENT '市',
    region VARCHAR(64) NOT NULL COMMENT '区',
    detail_address VARCHAR(200) NOT NULL COMMENT '详细地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司收发货地址表';
```

### Insert some random data to oms_company_address table
```sql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES
('Warehouse A', 1, 0, 'John Doe', '18812345678', 'Guangdong', 'Shenzhen', 'Nanshan', '1234 Logistics Park'),
('Main Office', 0, 1, 'Jane Smith', '17798765432', 'Beijing', 'Beijing', 'Haidian', '5678 Business Road'),
('Branch Center', 0, 0, 'Alice Brown', '15566668888', 'Shanghai', 'Shanghai', 'Pudong', '789 Financial District');
```

### Write a SQL query to fetch all data from oms_company_address `table
```sql
SELECT * FROM oms_company_address;
```

### Write a SQL query to fetch top 3 records from oms_company_address table
```sql
SELECT * FROM oms_company_address LIMIT 3;
```

### Update oms_company_address table to set all phone to 666-6666-8888
```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

### Delete one entry from oms_company_address table
```sql
DELETE FROM oms_company_address WHERE id = 1;
```

## MongoDB - Non-SQL Database
### Create test DB
```js
use test;
```
### Create oms_company_address collection (method: createCollection() )
```js
db.createCollection("oms_company_address");
```
### Insert few random entries to oms_company_address collection (method: insert() )
```js
db.oms_company_address.insertMany([
{
address_name: "Warehouse A",
send_status: 1,
receive_status: 0,
name: "John Doe",
phone: "18812345678",
province: "Guangdong",
city: "Shenzhen",
region: "Nanshan",
detail_address: "1234 Logistics Park"
},
{
address_name: "Main Office",
send_status: 0,
receive_status: 1,
name: "Jane Smith",
phone: "17798765432",
province: "Beijing",
city: "Beijing",
region: "Haidian",
detail_address: "5678 Business Road"
},
{
address_name: "Branch Center",
send_status: 0,
receive_status: 0,
name: "Alice Brown",
phone: "15566668888",
province: "Shanghai",
city: "Shanghai",
region: "Pudong",
detail_address: "789 Financial District"
}
]);
```

### Read one entry from oms_company_address collection (method: find() )
```js
db.oms_company_address.findOne();
```

### Read all entries from oms_company_address collection (method: find() )
```js
db.oms_company_address.find().pretty();
```
### Update one entry from oms_company_address collection (method: update() or save() )
```js
db.oms_company_address.update(
    { name: "John Doe" },
    { $set: { phone: "666-6666-8888" } }
);
```
### Remove one entry from oms_company_address collection (method: remove() )
```js
db.oms_company_address.deleteOne({ name: "Alice Brown" });
```