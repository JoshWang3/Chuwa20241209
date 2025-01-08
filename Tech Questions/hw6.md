** Using Mysql

use chuwa;

1. Create `oms_company_address` table
DROP TABLE IF EXISTS `oms_company_address`;
CREATE TABLE `oms_company_address`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Address Name',
  `send_status` int(1) NULL DEFAULT NULL COMMENT 'Send Status：0 = No；1 = Yes',
  `receive_status` int(1) NULL DEFAULT NULL COMMENT 'Receive Status：0 = No；1 = Yes',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Name',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Phone',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Province',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'City',
  `region` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Region',
  `detail_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Detail Address',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Company Address' ROW_FORMAT = DYNAMIC;

2. Insert some random data to `oms_company_address` table
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
('Headquarters', 1, 1, 'John Doe', '123-456-7890', 'California', 'San Francisco', 'Bay Area', '123 Market St'),
('Warehouse 1', 0, 1, 'Jane Smith', '987-654-3210', 'Texas', 'Houston', 'Gulf Coast', '456 Industrial Rd'),
('Branch Office 1', 1, 0, 'Alice Johnson', '555-555-5555', 'New York', 'Buffalo', 'North Region', '789 Maple Ave'),
('Branch Office 2', 1, 1, 'Bob Brown', '222-333-4444', 'Florida', 'Miami', 'South Region', '101 Ocean Dr'),
('Warehouse 2', 0, 1, 'Charlie Davis', '333-444-5555', 'Illinois', 'Chicago', 'Midwest', '202 Windy Ln'),
('Distribution Center', 1, 0, 'Diana Evans', '444-555-6666', 'Georgia', 'Atlanta', 'Southeast', '303 Peach St'),
('Support Center', 1, 1, 'Eve Foster', '666-777-8888', 'Washington', 'Seattle', 'Pacific Northwest', '404 Pine St'),
('Retail Store', 0, 1, 'Frank Green', '777-888-9999', 'Nevada', 'Las Vegas', 'Southwest', '505 Strip Blvd'),
('Regional Office', 1, 0, 'Grace Hall', '888-999-0000', 'Colorado', 'Denver', 'Mountain Region', '606 Rocky Rd'),
('Service Center', 1, 1, 'Hank Irving', '999-000-1111', 'Arizona', 'Phoenix', 'Desert Region', '707 Sun Valley Rd');

3. Write a SQL query to fetch all data from `oms_company_address` table
SELECT * FROM oms_company_address;

4. Write a SQL query to fetch top 3 records from `oms_company_address` table
SELECT * FROM oms_company_address
LIMIT 3;

5. Update `oms_company_address` table to set all phone to 666-6666-8888
UPDATE oms_company_address
SET phone = '666-6666-8888';

6. Delete one entry from `oms_company_address` table
DELETE FROM oms_company_address
WHERE id = 11;

** Using MongoDB

1. Create test DB
use test;

2. Create oms _company_address collection (method: createCollection() )
db.createCollection("oms_company_address");

3. Insert few random entries to oms _company_address collection (method: insert() )
db.oms_company_address.insertMany([
    {
        address_name: "Headquarters",
        send_status: 1,
        receive_status: 1,
        name: "John Doe",
        phone: "123-456-7890",
        province: "California",
        city: "San Francisco",
        region: "Bay Area",
        detail_address: "123 Market St"
    },
    {
        address_name: "Warehouse 1",
        send_status: 0,
        receive_status: 1,
        name: "Jane Smith",
        phone: "987-654-3210",
        province: "Texas",
        city: "Houston",
        region: "Gulf Coast",
        detail_address: "456 Industrial Rd"
    },
    {
        address_name: "Branch Office 1",
        send_status: 1,
        receive_status: 0,
        name: "Alice Johnson",
        phone: "555-555-5555",
        province: "New York",
        city: "Buffalo",
        region: "North Region",
        detail_address: "789 Maple Ave"
    }
]);

4. Read one entry from oms _company_address collection (method: find() )
db.oms_company_address.findOne();

5. Read all entries from oms_company_address collection (method: find() )
db.oms_company_address.find().pretty();

6. Update one entry from oms _company_address collection (method: update() or save() )
db.oms_company_address.updateOne(
    { name: "John Doe" }, // Filter
    { $set: { phone: "666-6666-8888" } } // Update
);

7. Remove one entry from oms_company_address collection (method: remove() )
db.oms_company_address.deleteOne({ name: "Alice Johnson" });
