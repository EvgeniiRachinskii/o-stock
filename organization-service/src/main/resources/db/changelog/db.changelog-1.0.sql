--liquibase formatted sql
--changeset  Eugene:1
CREATE TABLE IF NOT EXISTS organizations (
                               id VARCHAR(200) NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               contact_name VARCHAR(255),
                               contact_email VARCHAR(255),
                               contact_phone VARCHAR(255),
                               PRIMARY KEY (id)
);
INSERT INTO organizations (id, name, contact_name, contact_email, contact_phone)
VALUES ('1', 'Acme Inc.', 'John Doe', 'john.doe@acme.com', '+1-555-123-4567');

INSERT INTO organizations (id, name, contact_name, contact_email, contact_phone)
VALUES ('2', 'ABC Inc.', 'Jane Smith', 'jane.smith@abc.com', '+1-555-987-6543');

INSERT INTO organizations (id, name, contact_name, contact_email, contact_phone)
VALUES ('3', 'XYZ Corp.', 'Bob Johnson', 'bob.johnson@xyz.com', '+1-555-555-1212');


INSERT INTO organizations (id, name, contact_name, contact_email, contact_phone)
VALUES ('4', 'GHI Ltd.', 'Alice Brown', 'alice.brown@ghi.com', '+1-555-246-8240');


INSERT INTO organizations (id, name, contact_name, contact_email, contact_phone)
VALUES ('5', 'MNO LLC', 'Sam Lee', 'sam.lee@mno.com', '+1-555-999-0000');

