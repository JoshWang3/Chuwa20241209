-- 1. Create oms_company_address table
CREATE TABLE oms_company_address (
                                     id BIGINT PRIMARY KEY,
                                     address_name VARCHAR(200),
                                     send_status INT(1),
                                     receive_status INT(1),
                                     name VARCHAR(64),
                                     phone VARCHAR(64),
                                     province VARCHAR(64),
                                     city VARCHAR(64),
                                     region VARCHAR(64),
                                     detail_address VARCHAR(200)
);

-- 2. Insert some random data to oms_company_address table
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
    (1, 'Address 1', 1, 1, 'Name1', '1111', 'Province1', 'City1', 'Region1', 'DA1'),
    (2, 'Address 2', 0, 1, 'Name2', '2222', 'Province2', 'City2', 'Region2', 'DA2'),
    (3, 'Address 3', 1, 0, 'Name3', '3333', 'Province3', 'City3', 'Region3', 'DA3');

-- 3. Write a SQL query to fetch all data from oms_company_address `table
SELECT * FROM oms_company_address;

-- 4. Write a SQL query to fetch top 3 records from oms_company_address table
SELECT * FROM oms_company_address LIMIT 3;

-- 5. Update oms_company_address table to set all phone to 666-6666-8888
UPDATE oms_company_address SET phone = '666-666-8888';

-- 6. Delete one entry from oms_company_address table
DELETE FROM oms_company_address WHERE id = 2;
