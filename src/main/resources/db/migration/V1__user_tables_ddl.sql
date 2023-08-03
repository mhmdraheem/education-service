CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` enum('ROLE_ADMIN','ROLE_INSTRUCTOR','ROLE_STUDENT') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jyy1ia186jxs085pd7ry00blj` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `arabic_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `english_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `type` enum('ADMIN','INSTRUCTOR','STUDENT') NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FKn4pb12f3y8ktduy8fnc2xlln1` (`role_id`),
  CONSTRAINT `FKn4pb12f3y8ktduy8fnc2xlln1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;