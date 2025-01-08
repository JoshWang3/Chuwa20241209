### HW6: Database

#### MYSQL Exercise

#### 1, Create oms_company_address  table

oms_company_address:

```
#	字段	名称	数据类型	主键	⾮空	默认值	备注说明
1	id	id	bigint	√	
2	address_name	地址名称	varchar(200)
3	send_status	默认发货地址：0->否；1->是	int(1)	
4	receive_status	是否默认收货地址：0->否；1->是	int(1)	
5	name	收发货⼈姓名	varchar(64)	
6	phone	收货⼈电话	varchar(64)	
7	province	省/直辖市	varchar(64)	
8	city	市	varchar(64)	
9	region	区	varchar(64)	
10	detail_address	详细地址	varchar(200)
```
```
CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY,
    address_name VARCHAR(200),
    send_status INT(1) DEFAULT 0,
    receive_status INT(1) DEFAULT 0,
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200)
);
```

#### 2, Insert some random data to oms_company_address  table

```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
(1, 'Main Office', 1, 0, 'Lucy Guo', '123-456-7890', 'California', 'Los Angeles', 'Downtown', '123 Main St, Suite 100'),
(2, 'Headquarters', 1, 1, 'Mike Fan', '123-555-0101', 'California', 'San Francisco', 'Downtown', '123 Tech Street, Suite 100'),
(3, 'Branch Office', 0, 1, 'Nancy Johnson', '234-555-0202', 'washington', 'Seattle', 'Downtown', '291 Sixth Avenue, Suite 301'),
(4, 'Distribution Center', 1, 0, 'Amy Lee', '561-555-0303', 'Texas', 'Houston', 'Westside', '789 Logistics Boulevard'),
(5, 'Customer Service Center', 1, 1, 'Emily Chen', '901-555-0404', 'Illinois', 'Chicago', 'Loop', '321 Lane');
```

#### 3. Write a SQL query to fetch all data from oms_company_address  `table

SELECT * FROM oms_company_address;

#### 4. Write a SQL query to fetch top 3 records from oms_company_address  table

```
SELECT * FROM oms_company_address
LIMIT 3;
```

#### 5. Update oms_company_address  table to set all phone to 666-6666-8888

```
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

#### 6. Delete one entry from oms_company_address  table

```
DELETE FROM oms_company_address
LIMIT 1;
```

#### 7. (Optional) You can also try to create other tables that listed above




#### MONGODB Exercise

#### 1, Create test DB

use test;


#### 2. Create oms_company_address  collection  (method: createCollection() )

db.createCollection("oms_company_address");


#### 3. Insert few random entries to oms_company_address  collection (method: insert() )

```
db.oms_company_address.insert([
  {
    id: 1,
    address_name: 'Main Office',
    send_status: 1,
    receive_status: 0,
    name: 'Lucy Guo',
    phone: '123-456-7890',
    province: 'California',
    city: 'Los Angeles',
    region: 'Downtown',
    detail_address: '123 Main St, Suite 100'
  },
  {
    id: 2,
    address_name: 'Headquarters',
    send_status: 1,
    receive_status: 1,
    name: 'Mike Fan',
    phone: '123-555-0101',
    province: 'California',
    city: 'San Francisco',
    region: 'Downtown',
    detail_address: '123 Tech Street, Suite 100'
  },
  {
    id: 3,
    address_name: 'Branch Office',
    send_status: 0,
    receive_status: 1,
    name: 'Nancy Johnson',
    phone: '234-555-0202',
    province: 'Washington',
    city: 'Seattle',
    region: 'Downtown',
    detail_address: '291 Sixth Avenue, Suite 301'
  },
  {
    id: 4,
    address_name: 'Distribution Center',
    send_status: 1,
    receive_status: 0,
    name: 'Amy Lee',
    phone: '561-555-0303',
    province: 'Texas',
    city: 'Houston',
    region: 'Westside',
    detail_address: '789 Logistics Boulevard'
  },
  {
    id: 5,
    address_name: 'Customer Service Center',
    send_status: 1,
    receive_status: 1,
    name: 'Emily Chen',
    phone: '901-555-0404',
    province: 'Illinois',
    city: 'Chicago',
    region: 'Loop',
    detail_address: '321 Lane'
  }
]);
```

#### 4. Read one entry from oms_company_address  collection (method: find() )

db.oms_company_address.find().limit(1);

db.oms_company_address.find({ id: 1 }).limit(1);


#### 5. Read all entries from oms_company_address  collection (method: find() )

db.oms_company_address.find();


#### 6. Update one entry from oms_company_address collection (method: update() or save() )

db.oms_company_address.update(
  { id: 1 },  // Filter
  { $set: { phone: '999-9999-0000' } }  // Field update
);

#### 7. Remove one entry from oms_company_address collection (method: remove() )

db.oms_company_address.remove({ id: 1 });


#### 8. (Optional) You can also try to create other tables that listed above