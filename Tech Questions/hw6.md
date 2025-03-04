1. CREATE TABLE oms_company_address (
   id BIGINT PRIMARY KEY,
   address_name VARCHAR(200) NOT NULL,
   send_status INT(1) DEFAULT 0,
   receive_status INT(1) DEFAULT 0,
   name VARCHAR(64) NOT NULL,
   phone VARCHAR(64),
   province VARCHAR(64),
   city VARCHAR(64),
   region VARCHAR(64),
   detail_address VARCHAR(200)
   );
2. INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
   VALUES
   (1, 'Main Office', 1, 0, 'John Doe', '123-456-7890', 'California', 'Los Angeles', 'West', '1234 Elm Street'),
   (2, 'Warehouse', 0, 1, 'Jane Smith', '987-654-3210', 'New York', 'New York City', 'North', '5678 Maple Avenue');
3. SELECT * FROM oms_company_address;
4. SELECT * FROM oms_company_address LIMIT 3;
5. UPDATE oms_company_address
   SET phone = '666-6666-8888';
6. DELETE FROM oms_company_address
   WHERE id = 1;

2. Document doc1 = new Document("id", 1)
   .append("address_name", "Main Office")
   .append("send_status", 1)
   .append("receive_status", 0)
   .append("name", "John Doe")
   .append("phone", "123-456-7890")
   .append("province", "California")
   .append("city", "Los Angeles")
   .append("region", "West")
   .append("detail_address", "1234 Elm Street");

Document doc2 = new Document("id", 2)
.append("address_name", "Warehouse")
.append("send_status", 0)
.append("receive_status", 1)
.append("name", "Jane Smith")
.append("phone", "987-654-3210")
.append("province", "New York")
.append("city", "New York City")
.append("region", "North")
.append("detail_address", "5678 Maple Avenue");

collection.insertMany(Arrays.asList(doc1, doc2));

System.out.println("Data inserted successfully!");

2. Document doc = collection.find().first();
   System.out.println(doc.toJson());
3. FindIterable<Document> docs = collection.find();
   for (Document doc : docs) {
   System.out.println(doc.toJson());
   }
4. collection.updateOne(
   new Document("id", 1),
   new Document("$set", new Document("phone", "666-6666-8888"))
   );

System.out.println("Data updated successfully!");
5. collection.deleteOne(new Document("id", 1));

System.out.println("Data deleted successfully!");