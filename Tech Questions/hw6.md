# HW6

---

### Relational Database

1. Create `oms_company_address` table

````sql
-- 1. Create `oms_company_address` table
CREATE TABLE oms_company_address (
    id INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(100),
    address_line VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    country VARCHAR(100)
);




2. Insert some random data to `oms_company_address` table

INSERT INTO oms_company_address (company_name, address_line, city, state, zip_code, country)
VALUES
('TechNova', '123 Silicon Ave', 'San Jose', 'CA', '95112', 'USA'),
('DataSpark', '456 Cloud Blvd', 'Austin', 'TX', '73301', 'USA'),
('InnoSoft', '789 AI Street', 'Boston', 'MA', '02108', 'USA'),
('EcoSys', '321 Green Ln', 'Seattle', 'WA', '98101', 'USA'),
('SkyCore', '101 Sky Tower', 'New York', 'NY', '10001', 'USA');

3. Write a SQL query to fetch all data from `oms_company_address` table
```SQL
SELECT * FROM oms_company_address;
```

4. Write a SQL query to fetch top 3 records from `oms_company_address` table

```SQL
-- SELECT TOP 3 * FROM oms_company_address;
```

5. Update `oms_company_address` table to set all `phone` to 666-6666-8888

```SQL
UPDATE oms_company_address
SET phone = '666-6666-8888';
```



6. Delete one entry from `oms_company_address` table

```SQL
DELETE FROM oms_company_address
WHERE company_name = 'EcoSys';
```
````
