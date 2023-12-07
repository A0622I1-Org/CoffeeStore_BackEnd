-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: a0622i1_coffee
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `verification_code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `enable_flag` bit(1) DEFAULT NULL,
  `change_password_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'sysadmin','$2a$12$VhLXHyr9FoMGu1GfiwgIQ.EVIVPSYiUR4fceAF9jnTvYGTeZMxtyO',NULL,'giatufutoi@gmail.com',_binary '','2023-07-16'),(2,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(3,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(4,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(5,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(6,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(7,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(8,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(9,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(10,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(11,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(12,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(13,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(14,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(15,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(16,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(17,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(18,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(19,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(20,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(21,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(22,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(23,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(24,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(25,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(26,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(27,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(28,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(29,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(30,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(31,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(32,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(33,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(34,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(35,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(36,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(37,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(38,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(39,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(40,'user','$2a$12$...x8LSscg/0YIm4SHTg/.HI9aFoi0jabLd1C.kr0s7u1lYVghbCq','sdqsdqd121d1wdw1','viethale@gmail.com',_binary '','2023-07-03'),(43,'giatufutoi','$2a$12$u01GsCOulrgcOVlKq/tUquJjpFJ1Rkl94T6emPlY1SY.zPys1yjdC',NULL,'giatu321@gmail.com',_binary '','2023-07-03'),(44,'giatufutoi111','$2a$12$fv1vXU.m42NyEILuLYJi6u/cdHX/EkOtYFoINKb12qXiXECDYRPom',NULL,'giatu321111@gmail.com',_binary '','2023-07-07'),(45,'giatufutoi11155','$2a$12$8daJ8yRzx1nUx33mi9J9EecRDeztcB2URQLsYq0l4I7DNJH5hwJhy',NULL,'giatu3211151@gmail.com',_binary '','2023-07-07'),(46,'test123','$2a$12$kUc.XxGtsuzzW/WzHmHmkeGEwImgwzoUsc0QIYD/jMMAVgbBQYDkK',NULL,'giatufutoi1@gmail.com',_binary '','2023-07-10'),(47,'okama1','$2a$12$wC6cWb5.JZJrZ7x6UQweEOOIVVkX1y4qomSHznAd9p13gRVfjdJzS',NULL,'giatu3221@gmail.com',_binary '','2023-07-10'),(48,'okama12','$2a$12$5gtMJltvfMA5fMI5crxka.kykczOBV7np5V/my8JRderGSa21gFVq',NULL,'giatu322q1@gmail.com',_binary '','2023-07-10'),(49,'okama121','$2a$12$pAMqCjNSUD5otTcIpsQzJOd5cWdkBnFtaMH15vdnWkE9gcGS.vSu.',NULL,'giatu3221q1@gmail.com',_binary '','2023-07-10'),(50,'okama1123','$2a$12$Hn.7a/c/aYVKLaPNKb/mcOFF9LkRf6iZoBwcJcmr/9Ug2s7NgQrC.',NULL,'giatufuto111@gmail.com',_binary '','2023-07-10'),(51,'okama1123132','$2a$12$3qdDwSIb5F6jZqbO3xU3GeNHmwbpNaWBvyfrijZ8B1/1GnONULRKi',NULL,'giatufutoi1111@gmail.com',_binary '','2023-07-10'),(52,'giatufutoi111222','$2a$12$n0hrz1sVSaHwIrmz2vbmUOe8T.e5TBd0zH2QHtx8s7lgCCcOU9VqK',NULL,'giatu32111111@gmail.com',_binary '','2023-07-12'),(53,'giatufutoi123123123','$2a$12$f.T4vQN/5sMTRzfk6LzaFeq34A/Wn1NoIg4/dotrHurxn2bAXxLrW',NULL,'giatu321231@gmail.com',_binary '','2023-07-12'),(54,'okama1123132123123','$2a$12$4Cda7NFoA74daPHE038KQujj1IMLpGxEGV4yE.98LgumIKeexBnc2',NULL,'giatufutoi213123@gmail.com',_binary '','2023-12-03'),(55,'giatufutoi11112','$2a$12$iCf06gpdra4PibmAwg3Y3.AzWsUvCh.Y6LvCbTHcpyX.iLpI50oM.',NULL,'giatufutoi21321@gmail.com',_binary '','2023-12-03'),(56,'giatufutoi1111231','$2a$12$eviKqczL8sPonubYBBLlkOMdHanOE/Z/CMIG4cMZxpJJXj9kNkwY2',NULL,'giatufutoi2312312@gmail.com',_binary '','2023-12-03'),(57,'giatufutoi1111231123','$2a$12$Su9t9oq/ryaxOZO/QZO5xu.jiK.WWGO0o5YnjaFexZFaNU0WJdAw2',NULL,'giatufutoi231222312@gmail.com',_binary '','2023-12-03'),(58,'giatugiatu12323','$2a$12$WifCYRTp2oGnK8lDtw6EIeHfi29aek33MSA5V9FQlgNVBlbeDKT9S',NULL,'giatufutoi23232@gmail.com',_binary '','2023-12-05');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `account_role_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `account_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,1,1),(2,3,3),(3,3,1),(4,4,3),(5,5,1),(6,6,3),(7,7,1),(8,8,3),(9,9,1),(10,10,3),(11,11,1),(12,13,3),(13,13,1),(14,14,3),(15,15,1),(16,16,3),(17,17,1),(18,18,3),(19,19,1),(20,30,3),(21,31,1),(22,33,3),(23,33,1),(24,34,3),(25,35,1),(26,36,3),(27,37,1),(28,38,3),(29,39,1),(30,30,3),(31,31,1),(32,33,3),(33,33,1),(34,34,3),(35,35,1),(36,36,3),(37,37,1),(38,38,3),(39,39,1),(40,40,3),(41,49,1),(42,50,1),(43,51,2),(44,52,2),(45,53,2),(46,54,2),(47,55,2),(48,56,2),(49,57,2),(50,58,2);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `table_id` int DEFAULT NULL,
  `payment_status` bit(1) DEFAULT NULL,
  `payment_time` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `tabke_order_user_id` int DEFAULT NULL,
  `take_payment_user_id` int DEFAULT NULL,
  `take_order_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `table_id` (`table_id`),
  KEY `FK2m93gqkiudrtm2aeyggaakxt` (`tabke_order_user_id`),
  KEY `FKtmq3cosc49coogua0444cyht5` (`take_payment_user_id`),
  KEY `FK5xrakd6psc87rtft2i5qeyrt6` (`take_order_user_id`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`table_id`) REFERENCES `table` (`id`),
  CONSTRAINT `FK2m93gqkiudrtm2aeyggaakxt` FOREIGN KEY (`tabke_order_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK5xrakd6psc87rtft2i5qeyrt6` FOREIGN KEY (`take_order_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtmq3cosc49coogua0444cyht5` FOREIGN KEY (`take_payment_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'2023-07-06 11:16:58',1,1,_binary '','2023-12-07 10:41:38',1,1,1),(2,'2023-07-07 19:04:19',1,2,_binary '','2023-12-07 10:14:48',2,2,2),(3,'2023-07-07 20:06:47',1,6,_binary '','2023-07-07 20:08:40',2,3,2),(4,'2023-07-07 20:08:08',1,6,_binary '','2023-07-07 20:08:40',2,2,2),(5,'2023-07-07 20:27:31',1,5,_binary '','2023-12-07 10:50:03',1,2,3),(6,'2023-07-07 20:44:49',1,4,_binary '','2023-12-07 10:31:07',1,4,2),(7,'2023-07-12 19:19:32',1,1,_binary '','2023-12-07 10:41:38',2,2,2),(8,'2023-07-12 19:41:27',1,5,_binary '','2023-12-07 10:50:03',3,2,1),(9,'2023-07-13 21:06:24',1,9,_binary '','2023-07-18 21:35:35',2,4,3),(10,'2023-07-13 21:06:58',1,7,_binary '','2023-07-15 10:29:51',4,4,2),(11,'2023-07-16 16:33:15',1,9,_binary '','2023-07-18 21:35:35',NULL,NULL,NULL),(12,'2023-07-18 21:17:42',1,1,_binary '','2023-12-07 10:41:38',NULL,NULL,NULL),(13,'2023-07-18 21:32:17',1,9,_binary '','2023-07-18 21:35:35',NULL,NULL,NULL),(14,'2023-12-02 13:46:48',1,1,_binary '','2023-12-07 10:41:38',NULL,NULL,NULL),(15,'2023-12-02 15:15:03',1,1,_binary '','2023-12-07 10:41:38',NULL,NULL,NULL),(16,'2023-12-05 16:31:25',1,2,_binary '','2023-12-07 10:14:48',NULL,NULL,NULL),(17,'2023-12-07 10:13:47',1,3,_binary '','2023-12-07 10:26:12',NULL,NULL,NULL),(18,'2023-12-07 10:14:38',1,2,_binary '','2023-12-07 10:14:48',NULL,NULL,NULL),(19,'2023-12-07 10:26:00',1,3,_binary '','2023-12-07 10:26:12',NULL,NULL,NULL),(20,'2023-12-07 10:30:59',1,4,_binary '','2023-12-07 10:31:07',NULL,NULL,NULL),(21,'2023-12-07 10:33:07',1,5,_binary '','2023-12-07 10:50:03',NULL,NULL,NULL),(22,'2023-12-07 10:40:29',1,5,_binary '','2023-12-07 10:50:03',NULL,NULL,NULL),(23,'2023-12-07 10:41:30',1,1,_binary '','2023-12-07 10:41:38',NULL,NULL,NULL),(24,'2023-12-07 10:43:00',1,5,_binary '','2023-12-07 10:50:03',NULL,NULL,NULL),(25,'2023-12-07 10:49:54',1,5,_binary '','2023-12-07 10:50:03',NULL,NULL,NULL);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bill_id` (`bill_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `bill_detail_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `bill_detail_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` VALUES (1,1,2,2,50000),(2,1,1,2,55000),(3,2,9,10,45000),(4,3,8,5,45000),(5,3,9,2,45000),(6,3,2,1,50000),(7,4,9,5,45000),(8,4,12,4,35000),(9,5,3,3,55000),(10,5,1,2,55000),(11,5,2,3,50000),(12,5,2,3,50000),(13,5,1,3,55000),(14,6,2,4,50000),(15,6,3,3,55000),(16,6,2,2,50000),(17,7,9,4,45000),(18,8,2,5,50000),(19,9,14,1,35000),(20,9,15,1,35000),(21,10,2,4,50000),(22,7,1,4,55000),(23,11,5,1,45000),(24,11,18,1,29000),(25,11,4,1,59000),(26,11,3,1,55000),(27,11,1,1,55000),(28,11,2,1,50000),(29,11,16,1,29000),(30,11,17,1,29000),(31,11,15,1,35000),(32,11,14,1,35000),(33,11,13,1,35000),(34,11,12,1,35000),(35,11,11,1,35000),(36,11,9,1,45000),(37,11,10,1,35000),(38,11,7,1,45000),(39,11,8,1,45000),(40,11,6,1,45000),(41,12,12,1,35000),(42,12,11,2,35000),(43,13,1,2,55000),(44,13,2,1,50000),(45,14,2,1,50000),(46,14,3,1,55000),(47,15,3,5,55000),(48,16,19,1,2323),(49,17,2,5,50000),(50,17,3,7,55000),(51,18,19,2,2323),(52,19,1,2,55000),(53,19,2,2,50000),(54,20,19,6,15000),(55,21,2,4,50000),(56,22,1,1,55000),(57,23,19,11,15000),(58,24,20,11,50001),(59,25,21,12,200000);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fb_id` varchar(9) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `date` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `rate` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bill_id` (`bill_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `feedback_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'FB_00001',234,'Nguyễn Ngọc Đông','dongNG@gmail.com','2022-06-01','Great drink, love it!',2,'5'),(2,'FB_00002',876,'Trần Thị Hương','huongtran@gmail.com','2022-06-03','Awesome service!',1,'5'),(3,'FB_00003',321,'Lê Văn An','anlevan@gmail.com','2022-06-05','Delicious and refreshing',3,'3'),(4,'FB_00004',789,'Phạm Thị Mai','maipham@gmail.com','2022-06-07','Best drink ever!',2,'2'),(5,'FB_00005',567,'Trương Minh Quân','quantruongminh@gmail.com','2022-06-07','Excellent taste!',1,'1'),(6,'FB_00006',123,'Hoàng Thị Thu Hà','hathuhoang@gmail.com','2022-06-11','Refreshing and satisfying',3,'4'),(7,'FB_00007',987,'Vũ Xuân Tuấn','tuanvuxuan@gmail.com','2022-06-13','Smooth and creamy',2,'4'),(8,'FB_00008',456,'Nguyễn Thị Lan Anh','anhlannguyen@gmail.com','2022-06-15','Great variety of flavors',1,'4'),(9,'FB_00009',654,'Đặng Minh Quang','quangdangminh@gmail.com','2022-06-17','Fantastic presentation',3,'4'),(10,'FB_00010',987,'Bùi Thị Trang','trangbuithi@gmail.com','2022-06-19','Amazing quality',2,'4'),(11,'FB_00011',543,'Trần Minh Hiếu','hieutranminh@gmail.com','2022-06-21','Perfect balance',1,'4'),(12,'FB_00012',111,'Nguyễn Văn A','nguyenvana@gmail.com','2022-06-23','Nice experience',2,'4'),(13,'FB_00013',222,'Trần Thị B','tranthib@gmail.com','2022-06-25','Great customer service',1,'5'),(14,'FB_00014',333,'Lê Văn C','levanc@gmail.com','2022-06-27','Highly recommended',3,'4'),(15,'FB_00015',444,'Phạm Thị D','phamthid@gmail.com','2022-06-29','Wonderful ambiance',2,'5'),(16,'FB_00016',555,'Trương Văn E','truongvane@gmail.com','2022-07-01','Excellent quality',1,'4'),(17,'FB_00017',666,'Hoàng Thị F','hoangthif@gmail.com','2022-07-03','Amazing flavors',3,'3'),(18,'FB_00018',777,'Vũ Văn G','vuvang@gmail.com','2022-07-05','Impressive menu',2,'4'),(19,'FB_00019',888,'Nguyễn Thị H','nguyenthih@gmail.com','2022-07-07','Delightful presentation',1,'5'),(20,'FB_00020',999,'Đặng Văn I','dangvani@gmail.com','2022-07-09','Outstanding service',3,'4'),(21,'FB_00021',123,'Bùi Thị K','buithik@gmail.com','2022-07-11','Great value for money',2,'5'),(22,'FB_00022',234,'Trần Văn L','tranvanl@gmail.com','2022-07-13','Excellent staff',1,'4'),(23,'FB_00023',345,'Phạm Thị M','phamthim@gmail.com','2022-07-15','Tasty and satisfying',3,'3'),(24,'FB_00024',456,'Trương Văn N','truongvann@gmail.com','2022-07-17','Friendly atmosphere',2,'4'),(25,'FB_00025',567,'Lê Thị O','lethio@gmail.com','2022-07-19','Amazing cocktails',1,'5'),(26,'FB_00026',678,'Hoàng Văn P','hoangvanp@gmail.com','2022-07-21','Perfect service',3,'4'),(27,'FB_00027',789,'Vũ Thị Q','vuthiq@gmail.com','2022-07-23','Delicious food',2,'5'),(28,'FB_00028',890,'Nguyễn Văn R','nguyenvanr@gmail.com','2022-07-25','Excellent presentation',1,'4'),(29,'FB_00029',901,'Bùi Thị S','buithis@gmail.com','2022-07-27','Great ambiance',3,'3'),(30,'FB_00030',345,'Trần Văn T','tranvant@gmail.com','2022-07-29','Friendly staff',2,'4'),(31,'FB_00031',678,'Phạm Thị U','phamthiu@gmail.com','2022-07-31','Outstanding flavors',1,'5'),(32,'FB_00032',912,'Lê Văn V','levanv@gmail.com','2022-08-02','Wonderful service',3,'4'),(33,'FB_00033',543,'Trương Thị X','truongthix@gmail.com','2022-08-04','Excellent experience',2,'5'),(34,'FB_00034',876,'Hoàng Văn Y','hoangvany@gmail.com','2022-08-06','Fantastic ambiance',1,'4'),(35,'FB_00035',321,'Vũ Thị Z','vuthiz@gmail.com','2022-08-08','Great attention to detail',3,'3'),(36,'FB_00036',654,'Nguyễn Văn A1','nguyenvana1@gmail.com','2022-08-10','Highly satisfying',2,'4'),(37,'FB_00037',987,'Trần Thị B1','tranthib1@gmail.com','2022-08-12','Exceptional service',1,'5'),(38,'FB_00038',234,'Lê Văn C1','levanc1@gmail.com','2022-08-14','Great menu selection',3,'4'),(39,'FB_00039',789,'Phạm Thị D1','phamthid1@gmail.com','2022-08-16','Amazing atmosphere',2,'5'),(40,'FB_00040',567,'Trương Văn E1','truongvane1@gmail.com','2022-08-18','Delicious and satisfying',1,'4'),(41,'FB_00041',123,'Hoàng Thị F1','hoangthif1@gmail.com','2022-08-20','Outstanding menu',3,'3'),(42,'FB_00042',987,'Vũ Văn G1','vuvang1@gmail.com','2022-08-22','Great recommendations',2,'4'),(43,'FB_00043',456,'Nguyễn Thị H1','nguyenthih1@gmail.com','2022-08-24','Excellent variety',1,'5'),(44,'FB_00044',654,'Đặng Văn I1','dangvani1@gmail.com','2022-08-26','Fantastic experience',3,'4'),(45,'FB_00045',987,'Bùi Thị K1','buithik1@gmail.com','2022-08-28','Amazing presentation',2,'5'),(46,'FB_00046',543,'Trần Minh Hiếu1','hieutranminh1@gmail.com','2022-08-30','Perfectly cooked',1,'4'),(47,'FB_00047',876,'Nguyễn Ngọc Đông1','dongng1@gmail.com','2022-09-01','Great service',3,'3'),(48,'FB_00048',321,'Trần Thị Hương1','huongtran1@gmail.com','2022-09-03','Wonderful taste',2,'4'),(49,'FB_00049',789,'Lê Văn An1','anlevan1@gmail.com','2022-09-05','Delicious flavors',1,'5'),(50,'FB_00050',567,'Phạm Thị Mai1','maipham1@gmail.com','2022-09-07','Excellent service',3,'4'),(113,'FB0051',NULL,'Nguyễn Than Nhânádasdsad','giatu321231211@gmail.com','12-07-2023','qưqewqewqweqwe',1,'1');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_img`
--

DROP TABLE IF EXISTS `feedback_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_img` (
  `id` int NOT NULL AUTO_INCREMENT,
  `feedback_id` int DEFAULT NULL,
  `imgUrl` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `feedback_id` (`feedback_id`),
  CONSTRAINT `feedback_img_ibfk_1` FOREIGN KEY (`feedback_id`) REFERENCES `feedback` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_img`
--

LOCK TABLES `feedback_img` WRITE;
/*!40000 ALTER TABLE `feedback_img` DISABLE KEYS */;
INSERT INTO `feedback_img` VALUES (1,1,'https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/service-img%2FGranita-Avatarpsd4.png?alt=media&token=4b00cbb3-dabf-479e-bfbd-b7bc61c27b73',NULL),(2,2,'https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/service-img%2FGranita-Avatarpsd4.png?alt=media&token=4b00cbb3-dabf-479e-bfbd-b7bc61c27b73',NULL),(3,2,'https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/service-img%2FGranita-Avatarpsd4.png?alt=media&token=4b00cbb3-dabf-479e-bfbd-b7bc61c27b73',NULL),(4,2,'https://images.pexels.com/photos/16053051/pexels-photo-16053051/free-photo-of-mon-an-ca-phe-may-nh-u-ng.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(5,2,'https://images.pexels.com/photos/16064371/pexels-photo-16064371/free-photo-of-mon-an-dia-dan-ba-tay.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(6,2,'https://images.pexels.com/photos/16050226/pexels-photo-16050226/free-photo-of-mon-an-dia-rau-xa-lach-ca-phe.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(7,3,'https://images.pexels.com/photos/16043312/pexels-photo-16043312/free-photo-of-dia-c-c-u-ng-tra.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(8,3,'https://images.pexels.com/photos/16043282/pexels-photo-16043282/free-photo-of-dia-c-c-tay-u-ng.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(9,4,'https://images.pexels.com/photos/16050230/pexels-photo-16050230/free-photo-of-mon-an-dia-b-a-an-ly.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(10,5,'https://images.pexels.com/photos/16050227/pexels-photo-16050227/free-photo-of-mon-an-ca-phe-c-c-tao.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(11,6,'https://images.pexels.com/photos/16979638/pexels-photo-16979638/free-photo-of-dia-ca-phe-c-c-u-ng.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(12,7,'https://images.pexels.com/photos/16074688/pexels-photo-16074688/free-photo-of-dia-u-ng-ban-m-a.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(13,7,'https://images.pexels.com/photos/42322/tea-tea-time-person-summer-42322.jpeg?auto=compress&cs=tinysrgb&h=566.525&fit=crop&w=633.175&dpr=1',NULL),(14,7,'https://images.pexels.com/photos/16053051/pexels-photo-16053051/free-photo-of-mon-an-ca-phe-may-nh-u-ng.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(15,8,'https://images.pexels.com/photos/16064371/pexels-photo-16064371/free-photo-of-mon-an-dia-dan-ba-tay.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(16,8,'https://images.pexels.com/photos/16050226/pexels-photo-16050226/free-photo-of-mon-an-dia-rau-xa-lach-ca-phe.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(17,8,'https://images.pexels.com/photos/16043312/pexels-photo-16043312/free-photo-of-dia-c-c-u-ng-tra.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(18,8,'https://images.pexels.com/photos/16043282/pexels-photo-16043282/free-photo-of-dia-c-c-tay-u-ng.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(19,9,'https://images.pexels.com/photos/16050230/pexels-photo-16050230/free-photo-of-mon-an-dia-b-a-an-ly.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(20,10,'https://images.pexels.com/photos/16050227/pexels-photo-16050227/free-photo-of-mon-an-ca-phe-c-c-tao.jpeg?auto=compress&cs=tinysrgb&w=1600',NULL),(21,105,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/07-07-2023081445PMbarcode%201499.png?alt=media&token=9959a391-5f6a-4b60-ad18-355d8bdedfd4',NULL),(22,105,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/07-07-2023081445PMEER_A0622I1coffeStore.png?alt=media&token=b3901f06-b15d-462b-94a2-50134ec1dbff',NULL),(23,107,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/17-06-2023065218PMWhite%20Simple%20Trendy%20Coffee%20Line%20Art%20Logo%20(2).png?alt=media&token=0150e9d2-061d-45fb-a883-97156b904b16',NULL),(24,107,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/17-06-2023065218PMWhite%20Simple%20Trendy%20Coffee%20Line%20Art%20Logo%20(2).png?alt=media&token=0150e9d2-061d-45fb-a883-97156b904b16',NULL),(25,109,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023071813PMHLC_New_logo_5.1_Products__FREEZE_TRA_XANH.jpg?alt=media&token=1a5818cd-02a1-43b2-ad5b-a085e8d79a89',NULL),(26,110,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023071948PMCARAMELPHOMAI.jpg?alt=media&token=8baad96f-60a6-4c6b-8f4a-785eaa68ca8c',NULL),(27,111,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023072114PMHLC_New_logo_5.1_Products__FREEZE_TRA_XANH.jpg?alt=media&token=c2305bf5-6353-484c-bea0-7faf65567c36',NULL),(28,112,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023072158PMHLC__PHIN_SUA_NONG.jpg?alt=media&token=e5089722-9bbe-4806-bf6c-9a14a7c8f51a',NULL),(29,112,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023072158PMGranita-Avatarpsd4.png?alt=media&token=31035404-daa3-4617-9c00-b303dcc38964',NULL),(30,113,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023074215PMHLC__PHIN_SUA_NONG.jpg?alt=media&token=a647212a-fd01-4cc3-b4fb-c23805da3814',NULL),(31,113,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023074215PMHLC_New_logo_5.1_Products__TRA_THANH_DAO-08.jpg?alt=media&token=752de0a0-5501-4cff-af59-7da5bd325d71',NULL),(32,113,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023074215PMHLC_New_logo_5.1_Products__FREEZE_TRA_XANH.jpg?alt=media&token=16bfa105-59a4-4ed0-aa10-fc9fbeb2c7d6',NULL);
/*!40000 ALTER TABLE `feedback_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_type`
--

DROP TABLE IF EXISTS `feedback_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_type`
--

LOCK TABLES `feedback_type` WRITE;
/*!40000 ALTER TABLE `feedback_type` DISABLE KEYS */;
INSERT INTO `feedback_type` VALUES (1,'Đồ ăn'),(2,'Đồ uống'),(3,'Khác');
/*!40000 ALTER TABLE `feedback_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Chủ tịch'),(2,'Vợ chủ tịch'),(3,'nhân viên');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `enable_flag` int DEFAULT NULL,
  `imgUrl` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `created_date` varchar(30) DEFAULT NULL,
  `img_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `service_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'FREEZE SÔ-CÔ-LA',55000,2,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__CARAMEL_FREEZE_PHINDI.jpg'),(2,'FREEZE TRÀ XANH',50000,2,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__FREEZE_TRA_XANH.jpg'),(3,'COOKIES & CREAM',55000,2,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg'),(4,'TRÀ TUYẾT PHÚC BỒN TỬ',59000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/05_2023/Granita-Avatarpsd4.png'),(5,'TRÀ THẠCH VẢI',45000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__TRA_TACH_VAI.jpg'),(6,'TRÀ THẠCH ĐÀO',45000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__TRA_THANH_DAO-09.jpg'),(7,'TRÀ XANH ĐẬU ĐỎ',45000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__TRA_XANH_DAU_DO.jpg'),(8,'TRÀ THANH ĐÀO',45000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__TRA_THANH_DAO-08.jpg'),(9,'TRÀ SEN VÀNG (SEN)',45000,3,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/HLC_New_logo_5.1_Products__TSV.jpg'),(10,'BÁNH MOUSSE CACAO',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/MOUSSECACAO.png'),(11,'BÁNH TIRAMISU',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/TIRAMISU.jpg'),(12,'BÁNH SÔ-CÔ-LA HIGHLANDS',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/SOCOLAHL.png'),(13,'BÁNH CARAMEL PHÔ MAI',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/CARAMELPHOMAI.jpg'),(14,'BÁNH PHÔ MAI CHANH DÂY',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/PHOMAICHANHDAY.jpg'),(15,'BÁNH PHÔ MAI TRÀ XANH',35000,4,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/03_2018/PHOMAITRAXANH.jpg'),(16,'BẠC XỈU ĐÁ',29000,1,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/04_2023/New_product/HLC_New_logo_5.1_Products__BAC_XIU.jpg'),(17,'PHIN SỮA ĐÁ',29000,1,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/04_2023/New_product/HLC_New_logo_5.1_Products__PHIN_SUADA.jpg'),(18,'PHIN SỮA NÓNG',29000,1,1,NULL,'2023-12-07 10:46:59','https://www.highlandscoffee.com.vn/vnt_upload/product/11_2022/BR_Drink/HLC__PHIN_SUA_NONG.jpg'),(19,'CAFFEE SỮA',15000,2,1,NULL,'2023-12-07 10:46:59','https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/05-12-2023042351PMHLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg?alt=media&token=aee1f876-c4d0-4d10-8dc5-b0e1153a1613'),(20,'BANHNGOT',50001,4,1,NULL,'2023-12-07 10:46:59','https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/07-12-2023104247AMCARAMELPHOMAI.jpg?alt=media&token=bddd2075-0fac-47c8-ade6-a778b230da59'),(21,'TIRAMISUUUUUU',200000,4,1,NULL,'2023-12-07 10:49:08','https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/07-12-2023104907AMTIRAMISU.jpg?alt=media&token=f8d5cf07-4d5a-4dec-bb22-11bf3ea079a9');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Cà phê'),(2,'FREEZE'),(3,'Trà'),(4,'Bánh ngọt');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table`
--

DROP TABLE IF EXISTS `table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `enable_flag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table`
--

LOCK TABLES `table` WRITE;
/*!40000 ALTER TABLE `table` DISABLE KEYS */;
INSERT INTO `table` VALUES (1,'Bàn số 1','Tốt',_binary '\0'),(2,'Bàn số 2','Tốt',_binary '\0'),(3,'Bàn số 3','Tốt',_binary '\0'),(4,'Bàn số 4','Tốt',_binary '\0'),(5,'Bàn số 5','Tốt',_binary '\0'),(6,'Bàn số 6','Tốt',_binary '\0'),(7,'Bàn số 7','Tốt',_binary '\0'),(8,'Bàn số 8','Tốt',_binary '\0'),(9,'Bàn số 9','Tốt',_binary '\0'),(10,'Bàn số 10','Tốt',_binary '\0');
/*!40000 ALTER TABLE `table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone_number` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `birthday` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  `enable_flag` bit(1) DEFAULT NULL,
  `imgUrl` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `img_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `position_id` (`position_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Lê Gia Tú tú','Quảng Trị, việt nam','0367827574','1992-05-10',1,10000000,1,1,_binary '','url_img1','https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/03-12-2023071925PMDALL%C2%B7E%202023-12-02%2022.14.48%20-%20Create%20a%20cute%20chibi%20single-line%20drawing%20of%20a%20couple%2C%20a%20boy%20and%20a%20girl%2C%20both%20wearing%20glasses%20and%20holding%20a%20coffee%20cup.%20The%20boy%20is%20holding%20the%20girl\'s%20ha.png?alt=media&token=f76c9918-0eb5-40fb-9560-7b9fe3e23608'),(2,'Lê Thị Việt Hà','Quảng Trị','0367827532','1994-01-01',0,10000000,2,2,_binary '','url_img1','https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/18-07-2023092130PMHLC_New_logo_5.1_Products__COOKIES_FREEZE.jpg?alt=media&token=fc651a78-526e-4fab-9b93-630131481a7b'),(3,'Huỳnh Minh Cường','Đà Nẵng','0123456789','1985-03-15',1,12000000,3,3,_binary '\0','url_img2',NULL),(4,'Lê Văn An','Quảng Nam','0123456789','1987-11-25',0,13000000,3,4,_binary '\0','url_img3',NULL),(5,'Trần Sĩ Tiến','Huế','0123456789','1986-08-03',1,14000000,3,5,_binary '\0','url_img4',NULL),(6,'Nguyễn Thị Hương','Hà Nội','0123456789','1984-07-12',0,15000000,3,6,_binary '\0','url_img5',NULL),(7,'Phạm Văn Đức','Hồ Chí Minh','0123456789','1982-09-20',1,16000000,3,7,_binary '\0','url_img6',NULL),(8,'Trần Thị Hạnh','Đà Nẵng','0123456789','1989-12-05',0,17000000,3,8,_binary '\0','url_img7',NULL),(9,'Lê Văn Hùng','Quảng Nam','0123456789','1988-06-28',1,18000000,3,9,_binary '','url_img8',NULL),(10,'Nguyễn Thị Thúy','Huế','0123456789','1983-10-18',0,19000000,3,10,_binary '','url_img9',NULL),(11,'Trần Văn Hiệp','Hà Nội','0123456789','1981-04-08',1,20000000,3,11,_binary '','url_img10',NULL),(12,'Lê Thị Ngọc','Hồ Chí Minh','0123456789','1980-02-16',0,21000000,3,12,_binary '','url_img11',NULL),(13,'Nguyễn Văn Tuấn','Đà Nẵng','0123456789','1978-09-30',1,22000000,3,13,_binary '','url_img12',NULL),(14,'Trần Thị Mai','Quảng Nam','0123456789','1976-11-09',0,23000000,3,14,_binary '','url_img13',NULL),(15,'Lê Văn Long','Huế','0123456789','1974-08-17',1,24000000,3,15,_binary '\0','url_img14',NULL),(16,'Nguyễn Thị Thanh','Hà Nội','0123456789','1973-03-25',0,25000000,3,16,_binary '\0','url_img15',NULL),(17,'Trần Văn Quân','Hồ Chí Minh','0123456789','1971-12-01',1,26000000,3,17,_binary '','url_img16',NULL),(18,'Lê Thị Lan','Đà Nẵng','0123456789','1969-07-07',0,27000000,3,18,_binary '','url_img17',NULL),(19,'Nguyễn Văn Đại','Quảng Nam','0123456789','1967-04-13',1,28000000,3,19,_binary '','url_img18',NULL),(20,'Trần Thị Minh','Huế','0123456789','1965-10-28',0,29000000,3,20,_binary '','url_img19',NULL),(21,'Nguyễn Văn Tài','Hà Nội','0123456789','1963-08-09',1,30000000,3,21,_binary '','url_img20',NULL),(22,'Trần Thị Nga','Hồ Chí Minh','0123456789','1961-02-20',0,31000000,3,22,_binary '','url_img21',NULL),(23,'Lê Văn Dũng','Đà Nẵng','0123456789','1959-11-30',1,32000000,3,23,_binary '','url_img22',NULL),(24,'Nguyễn Thị Quỳnh','Quảng Nam','0123456789','1957-07-05',0,33000000,3,24,_binary '','url_img23',NULL),(25,'Trần Văn Hoàng','Huế','0123456789','1955-04-11',1,34000000,3,25,_binary '','url_img24',NULL),(26,'Lê Thị Tuyết','Hà Nội','0123456789','1953-09-25',0,35000000,3,26,_binary '','url_img25',NULL),(27,'Nguyễn Văn Thành','Hồ Chí Minh','0123456789','1951-06-05',1,36000000,3,27,_binary '','url_img26',NULL),(28,'Trần Thị Phượng','Đà Nẵng','0123456789','1949-03-15',0,37000000,3,28,_binary '','url_img27',NULL),(29,'Lê Văn Hải','Quảng Nam','0123456789','1947-10-25',1,38000000,3,29,_binary '','url_img28',NULL),(30,'Nguyễn Thị Ánh','Huế','0123456789','1945-12-05',0,39000000,3,30,_binary '','url_img29',NULL),(31,'Trần Văn Minh','Hà Nội','0123456789','1943-07-12',1,40000000,3,31,_binary '','url_img30',NULL),(32,'Lê Thị Lan','Hồ Chí Minh','0123456789','1941-04-22',0,41000000,3,32,_binary '','url_img31',NULL),(33,'Nguyễn Văn Hưng','Đà Nẵng','0123456789','1939-09-02',1,42000000,3,33,_binary '','url_img32',NULL),(34,'Trần Thị Linh','Quảng Nam','0123456789','1937-06-14',0,43000000,3,34,_binary '','url_img33',NULL),(35,'Lê Văn Thắng','Huế','0123456789','1935-03-27',1,44000000,3,35,_binary '','url_img34',NULL),(36,'Nguyễn Thị Hạnh','Hà Nội','0123456789','1933-11-08',0,45000000,3,36,_binary '','url_img35',NULL),(37,'Trần Văn Dương','Hồ Chí Minh','0123456789','1931-08-19',1,46000000,3,37,_binary '','url_img36',NULL),(38,'Lê Thị Thu','Đà Nẵng','0123456789','1929-05-31',0,47000000,3,38,_binary '','url_img37',NULL),(39,'Nguyễn Văn Quang','Quảng Nam','0123456789','1927-03-12',1,48000000,3,39,_binary '','url_img38',NULL),(40,'Trần Thị Bình','Huế','0123456789','1925-10-23',0,49000000,3,40,_binary '','url_img39',NULL),(41,'okama ha','6 Hoa Khanh, Dong Nai','0367827578','2000-01-01',1,1000000,2,49,_binary '\0',NULL,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/10-07-2023072154PM1_2.jpg?alt=media&token=595cf784-7de4-4f72-ba03-bef9f608afac'),(42,'Nguyễn Than Nhânádasdsad','6 Hoa Khanh, Dong Nai','0919516511','2000-11-11',1,1000000,1,50,_binary '\0',NULL,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/10-07-2023075111PM1_2.jpg?alt=media&token=8b419221-dfcf-4c06-8e9f-27c866c17d8e'),(43,'ádasdasdsad','6 Hoa Khanh, Dong Nai','0919516522','2000-11-11',1,1000000,1,51,_binary '',NULL,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/10-07-2023081230PM1_2.jpg?alt=media&token=6bda77f9-99de-4c8f-ace1-e8cee5cfbb73'),(44,'lkjasdlkjaksdj d alsjdlajsldjalsdja','6 Hoa Khanh, Dong Nai','0367827511','2000-01-01',2,1000000,2,52,_binary '',NULL,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023072426PMHLC__PHIN_SUA_NONG.jpg?alt=media&token=c706a5c4-e475-4feb-bc14-6dd55ed50c43'),(45,'Nguyễn Than Nhânádasdsad','6 Hoa Khanh, Dong Nai','0367827577','2000-01-01',1,1000000,1,53,_binary '',NULL,'https://firebasestorage.googleapis.com/v0/b/a0622i1.appspot.com/o/12-07-2023075352PMTIRAMISU.jpg?alt=media&token=8bb9eb8b-cb00-4715-80e7-5ffe69fb44cc'),(46,'qsdqsdqsd','Quảng Trị, việt nam','0367823373','2000-11-11',1,10000001,3,57,_binary '',NULL,'https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/03-12-2023071347PMDALL%C2%B7E%202023-12-02%2022.14.45%20-%20Create%20a%20cute%20chibi%20single-line%20drawing%20of%20a%20couple%2C%20a%20boy%20and%20a%20girl%2C%20both%20wearing%20glasses%20and%20holding%20a%20coffee%20cup.%20The%20boy%20is%20holding%20the%20girl\'s%20ha.png?alt=media&token=51f29202-c939-40e5-9802-80587b9447d4'),(47,'qsdqsdqsdsadsasd','12312312412','0367827572','2000-11-11',1,10000000,3,58,_binary '',NULL,'https://firebasestorage.googleapis.com/v0/b/coffeproject-tuha.appspot.com/o/05-12-2023034509PMHLC_New_logo_5.1_Products__TSV.jpg?alt=media&token=2004d4a7-3d32-455e-a304-2fddb6e6f9f5');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-07 10:57:25
