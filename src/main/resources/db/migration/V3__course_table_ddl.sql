CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(38,2) NOT NULL,
  `instructor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_UN` (`name`,`instructor_id`),
  KEY `FKc0xls9e7uqc9o08ae0t2ywr6n` (`instructor_id`),
  CONSTRAINT `FKc0xls9e7uqc9o08ae0t2ywr6n` FOREIGN KEY (`instructor_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;