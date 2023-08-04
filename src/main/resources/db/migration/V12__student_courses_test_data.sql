-- roles
INSERT INTO user_role (id, role_name) VALUES(1, 'ROLE_STUDENT');

-- students
INSERT INTO `user` (id, address, arabic_name, email, english_name, password, telephone, role_id)
VALUES(1, 'Egypt', 'محمد', 'mohamed@mail.com', 'mohamed', '$2a$10$FDUB8VYLNsmOLTkzz1swXuBkfZNn2/RT2oukD.wu4e7SHjVCf1K0y', '201129896433', 1);

INSERT INTO `user` (id, address, arabic_name, email, english_name, password, telephone, role_id)
VALUES(2, 'Kuwait', 'زين', 'zein@mail.com', 'zein', '$2a$10$yBYj4nErwMuRyEse7mFvoOGp6TSPtyzX9V6Gnd7Sttx.0/DwJODD.', '9651234567890', 1);

-- courses
INSERT INTO course (id, description, name, price)
VALUES(1, 'This course is about algorithms and data structures', 'algorithms and data structures', 30.00);

INSERT INTO course (id, description, name, price)
VALUES(2, 'This course is about software engineering fundamentals', 'software engineering fundamentals', 50.00);

INSERT INTO course (id, description, name, price)
VALUES(3, '', 'computer graphics', 50.00);

INSERT INTO course (id, description, name, price)
VALUES(4, 'This course is about image processing', 'image processing', 15.00);

INSERT INTO course (id, description, name, price)
VALUES(5, 'This course is about microservices', 'microservices', 990.00);

INSERT INTO course (id, description, name, price)
VALUES(6, 'This course is about java 8', 'java 8', 10.00);

INSERT INTO course (id, description, name, price)
VALUES(7, 'This course is about spring boot', 'spring boot', 100.00);

-- students courses
INSERT INTO user_course(course_id, user_id) VALUES(1, 1);
INSERT INTO user_course(course_id, user_id) VALUES(2, 1);
INSERT INTO user_course(course_id, user_id) VALUES(3, 1);
INSERT INTO user_course(course_id, user_id) VALUES(4, 1);
INSERT INTO user_course(course_id, user_id) VALUES(5, 1);

INSERT INTO user_course(course_id, user_id) VALUES(4, 2);
INSERT INTO user_course(course_id, user_id) VALUES(5, 2);
INSERT INTO user_course(course_id, user_id) VALUES(6, 2);
INSERT INTO user_course(course_id, user_id) VALUES(7, 2);
