1. Create oms_company_address table

```sql
Created Table oms_company_address (
    id BIGINT PRIMARY KEY,
    address_name VARCHAR(200),
    send_status INT(1) COMMENT '默认发货地址：0->否；1->是',
    receive_status INT(1) COMMENT '是否默认收货地址：0->否；1->是',
    name VARCHAR(64) COMMENT '收发货人姓名',
    phone VARCHAR(64) COMMENT '收货人电话',
    province VARCHAR(64) COMMENT '省/直辖市',
    city VARCHAR(64) COMMENT '市',
    region VARCHAR(64) COMMENT '区',
    detail_address VARCHAR(200) COMMENT '详细地址'
);
```

2. Insert some random data to oms_company_address table

```sql
INSERT INTO oms_company_address (
    id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address
) VALUES
(1, '仓库A', 1, 0, '张三', '13800000001', '广东省', '广州市', '天河区', '天河路123号'),
(2, '仓库B', 0, 1, '李四', '13800000002', '北京市', '北京市', '朝阳区', '朝阳路456号'),
(3, '门店C', 0, 0, '王五', '13800000003', '上海市', '上海市', '黄浦区', '外滩789号'),
(4, '仓库D', 1, 1, '赵六', '13800000004', '江苏省', '南京市', '玄武区', '玄武湖路101号'),
(5, '门店E', 0, 0, '孙七', '13800000005', '浙江省', '杭州市', '西湖区', '西湖大道202号');
```

3. Write a SQL query to fetch all data from oms_company_address `table

```sql
SELECT * FROM oms_company_address;
```

4. Write a SQL query to fetch top 3 records from oms_company_address table

```sql
SELECT * FROM oms_company_address
LIMIT 3;
```

5. Update oms_company_address table to set all phone to 666-6666-8888

```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

6. Delete one entry from oms_company_address table

```sql
DELETE FROM oms_company_address
WHERE id = 1;
```

7. (Optional) You can also try to create other tables that listed above
