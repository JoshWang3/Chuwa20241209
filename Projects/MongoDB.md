1. Create testDB

```js
use testDB;
```

2. Create oms_company_address collection (method: createCollection() )

```js
db.createCollection("oms_company_address");
```

3. Insert few random entries to oms_company_address collection (method: insert() )

```js
db.oms_company_address.insertMany([
  {
    address_name: "仓库A",
    send_status: 1,
    receive_status: 0,
    name: "张三",
    phone: "13800000001",
    province: "广东省",
    city: "广州市",
    region: "天河区",
    detail_address: "天河路123号",
  },
  {
    address_name: "仓库B",
    send_status: 0,
    receive_status: 1,
    name: "李四",
    phone: "13800000002",
    province: "北京市",
    city: "北京市",
    region: "朝阳区",
    detail_address: "朝阳路456号",
  },
  {
    address_name: "门店C",
    send_status: 0,
    receive_status: 0,
    name: "王五",
    phone: "13800000003",
    province: "上海市",
    city: "上海市",
    region: "黄浦区",
    detail_address: "外滩789号",
  },
]);
```

4. Read one entry from oms_company_address collection (method: find() )

```js
db.oms_company_address.findOne();
```

5. Read all entries from oms_company_address collection (method: find() )

```js
db.oms_company_address.find();
```

6. Update one entry from oms_company_address collection (method: update() or save() )

```js
db.oms_company_address.update(
  { name: "张三" },
  { $set: { phone: "666-6666-8888" } }
);
```

7. Remove one entry from oms_company_address collection (method: remove() )

```js
db.oms_company_address.deleteOne({ name: "李四" });
```

8. (Optional) You can also try to create other tables that listed above
