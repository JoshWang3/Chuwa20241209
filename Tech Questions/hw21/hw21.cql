CREATE KEYSPACE chuwa WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE chuwa;

-- Create Table
CREATE TABLE trainee_information (
    trainee_id UUID,
    first_name text,
    last_name text,
    department text,
    "batch" text,
    email text,
    phone text,
    join_date timestamp,
    -- Composite Partition Key: ((department, batch)) ensures data is partitioned based on both department and batch.
    -- Clustering Key: join_date (timestamp) orders rows within each partition, and adding trainee_id ensures uniqueness.
    PRIMARY KEY ((department, "batch"), join_date, trainee_id)
);

-- Insert Data
INSERT INTO trainee_information (
    trainee_id, first_name, last_name, department, "batch", email, phone, join_date
) VALUES (
    uuid(), 'Alice', 'Smith', 'Engineering', '2025A', 'alice@example.com', '1234567890', toTimestamp(now())
);

INSERT INTO trainee_information (
    trainee_id, first_name, last_name, department, "batch", email, phone, join_date
) VALUES (
    uuid(), 'Bob', 'Johnson', 'Engineering', '2025A', 'bob@example.com', '9876543210', toTimestamp(now())
);

INSERT INTO trainee_information (
    trainee_id, first_name, last_name, department, "batch", email, phone, join_date
) VALUES (
    uuid(), 'Charlie', 'Brown', 'Marketing', '2025B', 'charlie@example.com', '5551234567', toTimestamp(now())
);

-- Altering the Table to Add a New Column
ALTER TABLE trainee_information ADD address text;

-- Insert Data
INSERT INTO trainee_information (
    trainee_id, first_name, last_name, department, "batch", email, phone, join_date, address
) VALUES (
    uuid(), 'Diana', 'Prince', 'Marketing', '2025B', 'diana@example.com', '5559876543', toTimestamp(now()), '456 Wonder Way'
);

-- Query
SELECT trainee_id, first_name, last_name, address FROM trainee_information;

SELECT * FROM trainee_information WHERE department = 'Engineering' AND "batch" = '2025A';
SELECT * FROM trainee_information WHERE department = 'Engineering' AND "batch" = '2025A' AND join_date > '2025-02-01';

-- Set Consistency Levels
CONSISTENCY QUORUM;

-- Insert Data
INSERT INTO trainee_information (
    trainee_id, first_name, last_name, department, "batch", email, phone, join_date
) VALUES (uuid(), 'Eve', 'Adams', 'Engineering', '2025A', 'eve@example.com', '1112223333', toTimestamp(now()));