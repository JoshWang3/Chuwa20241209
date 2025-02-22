## hw21 - Cassandra

### 1,Answer https://forms.gle/DZck8a91igbYgb596
```
Done.
```
###2,Install Cassandra DB  on your computer,
```
Used docker image.
```
#### (1),create a new keyspace "chuwa"
```
CREATE KEYSPACE chuwa
WITH replication = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
};

DESCRIBE KEYSPACES;

USE chuwa;
```
#### (2),create a new table "trainee_information" with necessary columns, setup multiple partition keys, 
```
CREATE TABLE trainee_information (
    trainee_id uuid,
    department_id uuid,
    first_name text,
    last_name text,
    email text,
    join_date timestamp,
    PRIMARY KEY ((trainee_id, department_id), join_date)
) WITH CLUSTERING ORDER BY (join_date DESC);

DESCRIBE TABLE trainee_information;
```
#### (3),setup a clustering key column using timestamp data type,
```
) WITH CLUSTERING ORDER BY (join_date DESC);
```
#### (4),Insert multiple rows for above table.

```
INSERT INTO trainee_information (trainee_id, department_id, first_name, last_name, email, join_date)
VALUES (uuid(), uuid(), 'John', 'Doe', 'john.doe@email.com', '2024-01-13 07:00:00');

INSERT INTO trainee_information (trainee_id, department_id, first_name, last_name, email, join_date)
VALUES (uuid(), uuid(), 'Barry', 'Smith', 'barry.smith@example.com', '2024-10-02T09:00:00Z');

INSERT INTO trainee_information (trainee_id, department_id, first_name, last_name, email, join_date)
VALUES (uuid(), uuid(), 'Alice', 'Johnson', 'alice.johnson@example.com', '2024-12-03T11:00:00Z');
```

#### (5),Use proper data types for other columns,
```
trainee_id and department_id : UUID
first_name, last_name, and email: TEXT
join_date:	TIMESTAMP
```
#### (6),Come up with queries to prove that Cassandra supports "flexible schema"
```
SELECT * FROM trainee_information;

Add a New Column:
	ALTER TABLE trainee_information ADD phone_number text;

Insert Data with the New Column:
	INSERT INTO trainee_information (trainee_id, department_id, first_name, last_name, email, join_date, phone_number)
VALUES (uuid(), uuid(), 'Mike', 'Lee', 'mike.lee@example.com', '2025-01-04T13:00:00Z', '901-456-7890');

Query the Table:
	SELECT * FROM trainee_information;
```
#### (7),Explain why Cassandra has a "Query-first design" with CQL query examples
```
The schema is optimized for specific queries.

Example:
	SELECT * FROM trainee_information
	WHERE trainee_id = <trainee_id> AND department_id = <department_id>
	ORDER BY join_date DESC;
```
#### (8),Explain Cassandra consistency levels.

```
Cassandra provides tunable consistency levels for both reads and writes. 
Consistency levels determine how many replicas must acknowledge a read or write operation before it is considered successful.

Common Consistency Levels:
	ONE: Only one replica must acknowledge the operation.
	QUORUM: A majority of replicas (calculated as (replication_factor / 2) + 1) must acknowledge the operation.
	ALL: All replicas must acknowledge the operation.

Write with QUORUM:
CONSISTENCY QUORUM; -- Set Consistency Level
INSERT INTO trainee_information (trainee_id, department_id, first_name, last_name, email, join_date)
VALUES (uuid(), uuid(), 'Charlie', 'Davis', 'charlie.davis@example.com', '2023-10-05T14:00:00Z');

Read with QUORUM:
CONSISTENCY QUORUM;
SELECT * FROM trainee_information
WHERE trainee_id = 4eb698c3-ca27-4bb6-a85f-896ca79e7332 AND department_id = 1136a6c1-1379-4d01-8291-61b17a8d638f;

```
#### (9),Attached code and screenshots for above questions.

```
See the screenshots under /Tech Questions/hw21Cassandra
```