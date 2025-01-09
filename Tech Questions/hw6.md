-- SQL Exercise

-- 1. Create `oms_company_address` table
CREATE TABLE oms_company_address (
id BIGINT PRIMARY KEY,
address_name VARCHAR(200),
send_status TINYINT(1),
receive_status TINYINT(1),
name VARCHAR(64),
phone VARCHAR(64),
province VARCHAR(64),
city VARCHAR(64),
region VARCHAR(64),
detail_address VARCHAR(200)
);

-- 2. Insert some random data into `oms_company_address` table
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
(1, 'Warehouse A', 1, 0, 'John Doe', '123-456-7890', 'California', 'Los Angeles', 'Central', '123 Main St.'),
(2, 'Warehouse B', 0, 1, 'Jane Smith', '987-654-3210', 'New York', 'New York City', 'Manhattan', '456 Broadway'),
(3, 'Office HQ', 1, 1, 'Alice Johnson', '555-123-4567', 'Texas', 'Austin', 'Downtown', '789 Elm St.');

-- 3. Fetch all data from `oms_company_address` table
SELECT * FROM oms_company_address;

-- 4. Fetch top 3 records from `oms_company_address` table
SELECT * FROM oms_company_address LIMIT 3;

-- 5. Update `oms_company_address` table to set all `phone` to '666-6666-8888'
UPDATE oms_company_address SET phone = '666-6666-8888';

-- 6. Delete one entry from `oms_company_address` table
DELETE FROM oms_company_address WHERE id = 1;

-- MongoDB Exercise

// 1. Create test DB
use test_db;

// 2. Create `oms_company_address` collection
db.createCollection("oms_company_address");

// 3. Insert few random entries to `oms_company_address` collection
db.oms_company_address.insert([
{ id: 1, address_name: "Warehouse A", send_status: 1, receive_status: 0, name: "John Doe", phone: "123-456-7890", province: "California", city: "Los Angeles", region: "Central", detail_address: "123 Main St." },
{ id: 2, address_name: "Warehouse B", send_status: 0, receive_status: 1, name: "Jane Smith", phone: "987-654-3210", province: "New York", city: "New York City", region: "Manhattan", detail_address: "456 Broadway" },
{ id: 3, address_name: "Office HQ", send_status: 1, receive_status: 1, name: "Alice Johnson", phone: "555-123-4567", province: "Texas", city: "Austin", region: "Downtown", detail_address: "789 Elm St." }
]);

// 4. Read one entry from `oms_company_address` collection
db.oms_company_address.findOne();

// 5. Read all entries from `oms_company_address` collection
db.oms_company_address.find();

// 6. Update one entry from `oms_company_address` collection
db.oms_company_address.update(
{ id: 1 },
{ $set: { phone: "666-6666-8888" } }
);

// 7. Remove one entry from `oms_company_address` collection
db.oms_company_address.remove({ id: 1 });
