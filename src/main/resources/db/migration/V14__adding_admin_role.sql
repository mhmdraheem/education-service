ALTER TABLE user_role MODIFY COLUMN role_name enum('ROLE_ADMIN', 'ROLE_STUDENT')
CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;

INSERT INTO user_role (id, role_name) VALUES(2, 'ROLE_ADMIN');

INSERT INTO `user` (id, address, arabic_name, email, english_name, password, telephone, role_id)
VALUES(3, 'Egypt', 'admin', 'admin@mail.com', 'admin', '$2a$10$fOfI14pU7H.NX8GHDLAK2OhOXpDzWPRoebHVjXTGBdAObHR9yA5z.', '201128996433', 2);