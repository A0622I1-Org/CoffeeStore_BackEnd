
-- ALTER TABLE `cost_management_master` DROP FOREIGN KEY `cost_management_master_ibfk_1`;
-- ALTER TABLE `cost_management_master` DROP FOREIGN KEY `cost_management_master_ibfk_2`;
-- ALTER TABLE `cost_management_master` DROP FOREIGN KEY `cost_management_master_ibfk_3`;
-- ALTER TABLE `cost_management_master` DROP FOREIGN KEY `cost_management_master_ibfk_4`;
DROP TABLE IF EXISTS `material_cost`;
CREATE TABLE `material_cost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `material_id` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `date` varchar(23) DEFAULT NULL, 
  PRIMARY KEY (`id`),
  KEY `material_id` (`material_id`),
  CONSTRAINT `material_ibfk_2` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `fixed_expenses`;
CREATE TABLE `fixed_expenses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `depreciation_period` double DEFAULT NULL,
  `date` varchar(23) DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `salary_expenses`;
CREATE TABLE `salary_expenses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `monthly_salary` double DEFAULT NULL,
  `date` varchar(23) DEFAULT NULL, 
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `other_expenses`;
CREATE TABLE `other_expenses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `depreciation_period` double DEFAULT NULL,
  `date` varchar(23) DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- DROP TABLE IF EXISTS `cost_management_master`;
-- CREATE TABLE `cost_management_master` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `material_cost_id` int DEFAULT NULL,
--   `fixed_expenses_id` int DEFAULT NULL,
--   `salary_expenses_id` int DEFAULT NULL,
--   `other_expenses_id` int DEFAULT NULL,
--   `date` varchar(23) DEFAULT NULL, 
--   PRIMARY KEY (`id`),
--   KEY `material_cost_id` (`material_cost_id`),
--   KEY `fixed_expenses_id` (`fixed_expenses_id`),
--   KEY `salary_expenses_id` (`salary_expenses_id`),
--   KEY `other_expenses_id` (`other_expenses_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ALTER TABLE `cost_management_master` ADD CONSTRAINT `cost_management_master_ibfk_1` FOREIGN KEY (`material_cost_id`) REFERENCES `material_cost` (`id`);
-- ALTER TABLE `cost_management_master` ADD CONSTRAINT `cost_management_master_ibfk_2` FOREIGN KEY (`fixed_expenses_id`) REFERENCES `fixed_expenses` (`id`);
-- ALTER TABLE `cost_management_master` ADD CONSTRAINT `cost_management_master_ibfk_3` FOREIGN KEY (`salary_expenses_id`) REFERENCES `salary_expenses` (`id`);
-- ALTER TABLE `cost_management_master` ADD CONSTRAINT `cost_management_master_ibfk_4` FOREIGN KEY (`other_expenses_id`) REFERENCES `other_expenses` (`id`);

INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('1','1','no description', '1000', '0.25', '2024-03-24 16:35:00');
INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('2','1','no description', '2000', '0.2', '2024-03-25 16:35:00');
INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('3','2','no description', '1000', '0.5', '2024-03-24 16:35:00');
INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('4','2','no description', '2000', '0.6', '2024-03-25 16:35:00');
INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('5','3','no description', '1000', '1.3', '2024-03-24 16:35:00');
INSERT INTO `a0622i1_coffee`.`material_cost` (`id`,`material_id`,`description`, `quantity`, `unit_price`, `date`) VALUES ('6','3','no description', '2000', '1.1', '2024-03-25 16:35:00');
INSERT INTO `a0622i1_coffee`.`fixed_expenses` (`id`,`name`,  `description`, `unit`, `quantity`, `unit_price`, `depreciation_period`, `date`) VALUES ('1', 'bàn 1','bàn 1', 'cái', '20', '50000', '36', '2024-03-24 16:35:00');
INSERT INTO `a0622i1_coffee`.`fixed_expenses` (`id`,`name`,  `description`, `unit`, `quantity`, `unit_price`, `depreciation_period`, `date`) VALUES ('2', 'ghế 1','ghế 1', 'cái', '60', '15000', '36', '2024-03-24 16:35:00');