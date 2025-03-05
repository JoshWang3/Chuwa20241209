// 1. Create test DB
use test;

// 2. Create oms_company_address collection (method: createCollection() )
db.createCollection("oms_company_address");

// 3. Insert few random entries to oms_company_address collection (method: insert() )
db.oms_company_address.insertMany([
    { id: 1, address_name: "Address1", send_status: 1, receive_status: 1, name: "Name1", phone: "1111", province: "province1", city: "city1", region: "region1", detail_address: "da1" },
    { id: 2, address_name: "Addres2", send_status: 0, receive_status: 1, name: "Name2", phone: "2222", province: "province2", city: "city2", region: "region2", detail_address: "da2" },
    { id: 3, address_name: "Addres3", send_status: 1, receive_status: 0, name: "Name3", phone: "3333", province: "province3", city: "city3", region: "region3", detail_address: "da3" }
]);

// 4. Read one entry from oms_company_address collection (method: find() )
db.oms_company_address.findOne({ id: 1 });

// 5. Read all entries from oms_company_address collection (method: find() )
db.oms_company_address.find().pretty();

// 6. Update one entry from oms_company_address collection (method: update() or save() )
db.oms_company_address.updateOne(
    { id: 1 },
    { $set: { phone: "666-666-8888" } }
);

// 7. Remove one entry from oms_company_address collection (method: remove() )
db.oms_company_address.deleteOne({ id: 2 });
