CREATE TABLE `notebook` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noteCount` int NOT NULL,
  `notebookName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
