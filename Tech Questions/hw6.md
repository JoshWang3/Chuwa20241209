# HW6 - Database
## 1. MySQL - Relational Database
### 1. Create oms_company_address table
```
CREATE TABLE oms_company_address (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address_name VARCHAR(200) COMMENT '地址名称',
    send_status INT(1) DEFAULT 0 COMMENT '默认发货地址： 0->否；1->是',
    receive_status INT(1) DEFAULT 0 COMMENT '是否默认收货地址： 0->否；1->是',
    name VARCHAR(64) COMMENT '收发货人姓名',
    phone VARCHAR(64) COMMENT '收货人电话',
    province VARCHAR(64) COMMENT '省/直辖市',
    city VARCHAR(64) COMMENT '市',
    region VARCHAR(64) COMMENT '区',
    detail_address VARCHAR(200) COMMENT '详细地址'
);
```

### 2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
    ('Warehouse', 1, 0, 'Mr.A', '111-222-3333', 'Florida', 'Miami', 'Bayshore', 'A street'),
    ('Office', 1, 1, 'Ms.B', '311-222-3334', 'New York', 'NYC', 'South', 'B street');
    ('Post Center', 0, 0, 'Ms.C', '311-222-3334', 'MA', 'Boston', 'Chinatown', 'C street');
```

### 3. Write a SQL query to fetch all data from oms_company_address table
```
SELECT * FROM oms_company_address;
```

### 4. Write a SQL query to fetch top 3 records from oms_company_address table
```
SELECT * FROM oms_company_address 
ORDER BY id ASC
LIMIT 3;
```

### 5. Update oms_company_address table to set all phoneto 666-6666-8888
```
UPDATE oms_company_address 
SET phone = '666-6666-8888';
```

### 6. Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address 
WHERE send_status = 0;
```

### 7. (Optional)You can also try to create other tables that listed above
```
CREATE TABLE oms_order_return_apply (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    company_address_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    order_sn VARCHAR(64),
    create_time DATETIME,
    member_username VARCHAR(64),
    return_amount DECIMAL(10,2),
    return_name VARCHAR(100),
    return_phone VARCHAR(100),
    status INT(1),
    handle_time DATETIME,
    product_pic VARCHAR(500),
    product_name VARCHAR(200),
    product_brand VARCHAR(200),
    product_attr VARCHAR(500),
    product_count INT,
    product_price DECIMAL(10,2),
    product_real_price DECIMAL(10,2),
    reason VARCHAR(200),
    description VARCHAR(500),
    proof_pics VARCHAR(1000),
    handle_note VARCHAR(500),
    handle_man VARCHAR(100),
    receive_man VARCHAR(100),
    receive_time DATETIME,
    receive_note VARCHAR(500),
    CONSTRAINT fk_company_address_id FOREIGN KEY (company_address_id) REFERENCES oms_company_address(id)
);

```


## 2. MongoDB - Non-SQL Database

### 1. Create testDB
```
use testDB
```
### 2. Create oms_company_address collection (method: createCollection() )
```
db.createCollection("oms_company_address");
```
### 3. Insert few random entries to oms_company_address collection (method: insert() )
```
    
db.oms_company_address.insert([
    {
        address_name: "Warehouse",
        send_status: 1,
        receive_status: 0,
        name: "Mr.A",
        phone: "111-222-3333",
        province: "Florida",
        city: "Miami",
        region: "Bayshore",
        detail_address: "A street"
    },
    {
        address_name: "Office",
        send_status: 1,
        receive_status: 1,
        name: "Ms.B",
        phone: "341-822-3434",
        province: "New York",
        city: "NYC",
        region: "South",
        detail_address: "B street"
    },
    {
        address_name: "Post Center",
        send_status: 0,
        receive_status: 0,
        name: "Ms.C",
        phone: "311-222-3334",
        province: "MA",
        city: "Boston",
        region: "Chinatown",
        detail_address: "C street"
    }
]);

```


### 4. Read one entry from oms_company_address collection (method: find() )
```
db.oms_company_address.find().linit(1);
```

### 5. Read all entries from oms_company_address collection (method: find() )
```
db.oms_company_address.find();
```


### 6. Update one entry from oms_company_addresscollection (method: update() or save() )
```
db.oms_company_address.update(
    { name: "Ms.C" }, 
    { $set: { phone: "Mr.C", phone: "311-222-3335" } } 
);
```


### 7. Remove one entry from oms_company_addresscollection (method: remove() )
```
db.oms_company_address.remove({ phone: "341-822-3434" }); 
```

### 8. (Optional) You can also try to create other tables that listed above

(1) Create the collection
```
db.createCollection("oms_order_return_apply");
```

(2) Insert Few Random Entries
```
db.oms_order_return_apply.insert([
    {
        order_id: 1,
        company_address_id: 1, // Foreign key reference to oms_company_address
        product_id: 101,
        order_sn: "ORD126",
        create_time: new Date("2015-01-01"),
        member_username: "AAA",
        return_amount: 9,
        return_name: "BBB",
        return_phone: "123-456-7890",
        status: 1,
        handle_time: null,
        product_pic: "product1.jpg",
        product_name: "Product A",
        product_brand: "Brand A",
        product_attr: "Color: Red, Size: M",
        product_count: 1,
        product_price: 99.99,
        product_real_price: 8.99,
        reason: "Defective product",
        description: "Product so bad",
        proof_pics: ["proof1.jpg", "proof2.jpg"],
        handle_note: null,
        handle_man: null,
        receive_man: null,
        receive_time: null,
        receive_note: null
    },
    {
        order_id: 2,
        company_address_id: 2,
        product_id: 1002,
        order_sn: "ORD123457",
        create_time: new Date("2020-01-02"),
        member_username: "DVC",
        return_amount: 149.99,
        return_name: "CCC",
        return_phone: "911-000-0210",
        status: 0,
        handle_time: null,
        product_pic: "product2.jpg",
        product_name: "Product B",
        product_brand: "Brand B",
        product_attr: "Color: Blue, Size: L",
        product_count: 2,
        product_price: 75.00,
        product_real_price: 70.00,
        reason: "Wrong size",
        description: "Expected size M",
        proof_pics: ["proof3.jpg"],
        handle_note: null,
        handle_man: null,
        receive_man: null,
        receive_time: null,
        receive_note: null
    }
]);
```