-- Insert sample data without IDs
INSERT INTO users (username, password) VALUES ('lei', '$2a$10$DowJonesIndexExampleHashxxxxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO users (username, password) VALUES ('admin', '$2a$10$DowJonesIndexExampleHashxxxxxxxxxxxxxxxxxxxxxxx0');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
