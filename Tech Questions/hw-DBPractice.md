### Create oms_company_address table
```
CREATE TABLE oms_company_address (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address_name VARCHAR(200) COMMENT '地址名称',
    send_status INT(1) DEFAULT 0 COMMENT '默认发货地址：0->否；1->是',
    receive_status INT(1) DEFAULT 0 COMMENT '是否默认收货地址：0->否；1->是',
    name VARCHAR(64) COMMENT '收发货人姓名',
    phone VARCHAR(64) COMMENT '收货人电话',
    province VARCHAR(64) COMMENT '省/直辖市',
    city VARCHAR(64) COMMENT '市',
    region VARCHAR(64) COMMENT '区',
    detail_address VARCHAR(200) COMMENT '详细地址'
) ENGINE=InnoDB COMMENT='地址信息表';
```

### Insert some random data to oms_company_address table
```
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
    (1, 'Company HQ', 1, 0, 'John Doe', '1234567890', 'California', 'Los Angeles', 'Downtown', '123 Main Street'),
    (2, 'Temporary Location', 0, 0, 'Michael Johnson', '3344556677', 'Illinois', 'Chicago', 'South Side', '202 Lake Shore Drive');
```

### Write a SQL query to fetch all data from oms_company_address table
```
select * from oms_company_address;
```

### Write a SQL query to fetch top 3 records from oms_company_address table
```
select * from oms_company_address limit 3;
```

### Update oms_company_address table to set all phoneto 666-6666-8888
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

### Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address WHERE id = 1;
```



### Create testDB
```
use testDB
```
### Create oms_company_address collection (method: createCollection() )
```
db.createCollection("oms_company_address");
```
### Insert few random entries to oms_company_address collection (method: insert() )
```

db.oms_company_address.insert([
    {
        address_name: "Home",
        send_status: 1,
        receive_status: 0,
        name: "John Doe",
        phone: "123-456-7890",
        province: "California",
        city: "Los Angeles",
        region: "Central",
        detail_address: "123 Main St, Apartment 4B"
    },
    {
        address_name: "Office",
        send_status: 0,
        receive_status: 1,
        name: "Jane Smith",
        phone: "987-654-3210",
        province: "Texas",
        city: "Dallas",
        region: "North",
        detail_address: "456 Elm St, Suite 101"
    },
    {
        address_name: "Warehouse",
        send_status: 1,
        receive_status: 1,
        name: "Warehouse Manager",
        phone: "555-555-5555",
        province: "New York",
        city: "New York City",
        region: "East",
        detail_address: "789 Maple Ave, Building C"
    }
]);
```
### Read one entry from oms_company_address collection (method: find() )
```
db.oms_company_address.findOne();
```
### Read all entries from oms_company_address collection (method: find() )
```
db.oms_company_address.find().pretty();
```
### Update one entry from oms_company_addresscollection (method: update() or save() )
```
db.oms_company_address.updateOne(
    { phone: "123-456-7890" }, 
    { $set: { name: "Jane Doe", phone: "987-654-3210" } } 
);
```
### Remove one entry from oms_company_addresscollection (method: remove() )
```
db.oms_company_address.remove({}); 
```
