CREATE TABLE `user_course` (
  `course_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `FKpv8tt3252hb6kyej8p7e7pokl` (`user_id`),
  CONSTRAINT `FKka18m18kpimodvy8yg2icu083` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKpv8tt3252hb6kyej8p7e7pokl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;