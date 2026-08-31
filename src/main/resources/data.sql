-- Insert sample data without IDs
INSERT INTO users (username, password) VALUES 
	('lei', '$2a$10$xLLYi.shPST0OVFK87J2/OyukOBiIG2J0N2CTa.OhBCr9c8QZRrDS'),    -- password: lei
	('admin', '$2a$10$OAomGXmKR1ef9GmAJm5aV.QZHxJ1JDWyiPTWF6ICpxLStPKqiNszW');  -- password: admin

INSERT INTO roles (name) VALUES 
	('USER'),
	('ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES 
	(1, 1),
	(2, 2);
