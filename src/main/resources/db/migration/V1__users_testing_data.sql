-- roles
INSERT INTO user_role (id, role_name) VALUES(1, 'ROLE_STUDENT');
INSERT INTO user_role (id, role_name) VALUES(2, 'ROLE_INSTRUCTOR');
INSERT INTO user_role (id, role_name) VALUES(3, 'ROLE_ADMIN');

-- students
INSERT INTO `user` (address, arabic_name, email, english_name, password, telephone, `type`, role_id)
VALUES('Egypt', 'محمد', 'mohamed@mail.com', 'mohamed', '{bcrypt}$2a$10$FDUB8VYLNsmOLTkzz1swXuBkfZNn2/RT2oukD.wu4e7SHjVCf1K0y', '201129896433', 'STUDENT', 1);
INSERT INTO `user` (address, arabic_name, email, english_name, password, telephone, `type`, role_id)
VALUES('Kuwait', 'زين', 'zein@mail.com', 'zein', '{bcrypt}$2a$10$yBYj4nErwMuRyEse7mFvoOGp6TSPtyzX9V6Gnd7Sttx.0/DwJODD.', '9651234567890', 'STUDENT', 1);

-- admin
INSERT INTO `user` (address, arabic_name, email, english_name, password, telephone, `type`, role_id)
VALUES('Egypt', 'أدمن', 'admin@mail.com', 'admin', '{bcrypt}$2a$10$YWxnUeJYNC08GvGlMj0wNewx5V3JMYuIZeLUnuFTFBOvB7R.x.oZ2', '9651234567890', 'ADMIN', 3);

-- instructors
INSERT INTO `user` (address, arabic_name, email, english_name, password, telephone, `type`, role_id)
VALUES('USA', 'أليكس', 'alex@mail.com', 'alex', '{bcrypt}$2a$10$2FrXbmLU4PSG7yPIPiqcB.FlePvpjxOYSKB37eUA4DcCuF3VUK/Cy', '01017182222222', 'INSTRUCTOR', 2);
INSERT INTO `user` (address, arabic_name, email, english_name, password, telephone, `type`, role_id)
VALUES('Egypt', 'علي', 'ali@mail.com', 'ali', '{bcrypt}$2a$10$yeR9VG1Scb1ppVB9LqG11.9jIh/uge5BU45EUyVAvx/oMz2YSR5jC', '201028896439', 'INSTRUCTOR', 2);
