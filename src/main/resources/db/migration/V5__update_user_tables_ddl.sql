DELETE FROM `user` WHERE `type` != 'STUDENT';
ALTER TABLE `user` DROP COLUMN `type`;

DELETE FROM `user_role` WHERE `role_name` != 'ROLE_STUDENT';

ALTER TABLE course DROP FOREIGN KEY FKc0xls9e7uqc9o08ae0t2ywr6n;
ALTER TABLE course DROP KEY course_UN;
ALTER TABLE course DROP COLUMN `instructor_id`;
-- delete duplicate courses
DELETE FROM course where name='microservices';
ALTER TABLE course ADD CONSTRAINT course_UN UNIQUE KEY (name);
