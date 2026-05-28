-- MySQL dump 10.13  Distrib 9.6.0, for macos26.3 (arm64)
--
-- Host: localhost    Database: kendoughs
-- ------------------------------------------------------
-- Server version	9.6.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '9a9b3a94-4f04-11f1-a87c-1361ac3e3343:1-125';

--
-- Table structure for table `drink`
--

DROP TABLE IF EXISTS `drink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `flavor` enum('APPLE_JUICE','COFFEE','CRANBERRY_JUICE','LEMONADE','MILK','OJ') DEFAULT NULL,
  `is_available` bit(1) NOT NULL,
  `size` enum('LARGE','MEDIUM','SMALL') DEFAULT NULL,
  `stock_count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink`
--

LOCK TABLES `drink` WRITE;
/*!40000 ALTER TABLE `drink` DISABLE KEYS */;
INSERT INTO `drink` VALUES (1,'Coffee - Small',2,'COFFEE',_binary '','SMALL',20),(2,'Coffee - Medium',2.5,'COFFEE',_binary '','MEDIUM',20),(3,'Coffee - Large',3,'COFFEE',_binary '','LARGE',20),(4,'Orange Juice - Small',2,'OJ',_binary '','SMALL',20),(5,'Orange Juice - Medium',2.5,'OJ',_binary '','MEDIUM',20),(6,'Orange Juice - Large',3,'OJ',_binary '','LARGE',16),(7,'Milk - Small',2,'MILK',_binary '','SMALL',20),(8,'Milk - Medium',2.5,'MILK',_binary '','MEDIUM',20),(9,'Milk - Large',3,'MILK',_binary '','LARGE',20),(10,'Lemonade - Small',2,'LEMONADE',_binary '','SMALL',20),(11,'Lemonade - Medium',2.5,'LEMONADE',_binary '','MEDIUM',20),(12,'Lemonade - Large',3,'LEMONADE',_binary '','LARGE',20),(13,'Apple Juice - Small',2,'APPLE_JUICE',_binary '','SMALL',20),(14,'Apple Juice - Medium',2.5,'APPLE_JUICE',_binary '','MEDIUM',20),(15,'Apple Juice - Large',3,'APPLE_JUICE',_binary '','LARGE',20),(16,'Cranberry Juice - Small',2,'CRANBERRY_JUICE',_binary '','SMALL',20),(17,'Cranberry Juice - Medium',2.5,'CRANBERRY_JUICE',_binary '','MEDIUM',20),(18,'Cranberry Juice - Large',3,'CRANBERRY_JUICE',_binary '','LARGE',20);
/*!40000 ALTER TABLE `drink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink_seq`
--

DROP TABLE IF EXISTS `drink_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_seq`
--

LOCK TABLES `drink_seq` WRITE;
/*!40000 ALTER TABLE `drink_seq` DISABLE KEYS */;
INSERT INTO `drink_seq` VALUES (1);
/*!40000 ALTER TABLE `drink_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premium_topping`
--

DROP TABLE IF EXISTS `premium_topping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premium_topping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) NOT NULL,
  `name` enum('BACON_CRUMBLES','BUTTER','CARAMEL_DRIZZLE','CINNAMON','COOKIE_BUTTER','FRESH_BLUEBERRIES','FRESH_STRAWBERRIES','ICE_CREAM','MAPLE_SYRUP','NUTELLA','POWDERED_SUGAR','WHIPPED_CREAM') DEFAULT NULL,
  `price` double NOT NULL,
  `stock_count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premium_topping`
--

LOCK TABLES `premium_topping` WRITE;
/*!40000 ALTER TABLE `premium_topping` DISABLE KEYS */;
/*!40000 ALTER TABLE `premium_topping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regular_topping`
--

DROP TABLE IF EXISTS `regular_topping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regular_topping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) NOT NULL,
  `name` enum('BACON_CRUMBLES','BUTTER','CARAMEL_DRIZZLE','CINNAMON','COOKIE_BUTTER','FRESH_BLUEBERRIES','FRESH_STRAWBERRIES','ICE_CREAM','MAPLE_SYRUP','NUTELLA','POWDERED_SUGAR','WHIPPED_CREAM') DEFAULT NULL,
  `price` double NOT NULL,
  `stock_count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regular_topping`
--

LOCK TABLES `regular_topping` WRITE;
/*!40000 ALTER TABLE `regular_topping` DISABLE KEYS */;
/*!40000 ALTER TABLE `regular_topping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `side`
--

DROP TABLE IF EXISTS `side`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `side` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `is_available` bit(1) NOT NULL,
  `stock_count` int NOT NULL,
  `type` enum('BACON','FRUIT_CUP','HASH_BROWNS','WAFFLE_FRIES') DEFAULT NULL,
  `side_type` enum('BACON','FRUIT_CUP','HASH_BROWNS','WAFFLE_FRIES') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `side`
--

LOCK TABLES `side` WRITE;
/*!40000 ALTER TABLE `side` DISABLE KEYS */;
INSERT INTO `side` VALUES (1,'Hash Browns',1.5,_binary '',18,NULL,'HASH_BROWNS'),(2,'Waffle Fries',1.5,_binary '',20,NULL,'WAFFLE_FRIES'),(3,'Bacon',2,_binary '',18,NULL,'BACON'),(4,'Fruit Cup',2,_binary '',16,NULL,'FRUIT_CUP');
/*!40000 ALTER TABLE `side` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `side_seq`
--

DROP TABLE IF EXISTS `side_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `side_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `side_seq`
--

LOCK TABLES `side_seq` WRITE;
/*!40000 ALTER TABLE `side_seq` DISABLE KEYS */;
INSERT INTO `side_seq` VALUES (1);
/*!40000 ALTER TABLE `side_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toppings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) NOT NULL,
  `name` enum('BACON_CRUMBLES','BUTTER','CARAMEL_DRIZZLE','CINNAMON','COOKIE_BUTTER','FRESH_BLUEBERRIES','FRESH_STRAWBERRIES','ICE_CREAM','MAPLE_SYRUP','NUTELLA','POWDERED_SUGAR','WHIPPED_CREAM') DEFAULT NULL,
  `price` double NOT NULL,
  `stock_count` int NOT NULL,
  `topping_type` varchar(31) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=355 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (1,_binary '','WHIPPED_CREAM',0,16,'REGULAR'),(2,_binary '','POWDERED_SUGAR',0,16,'REGULAR'),(3,_binary '','MAPLE_SYRUP',0,15,'REGULAR'),(4,_binary '','CINNAMON',0,19,'REGULAR'),(5,_binary '','BUTTER',0,19,'REGULAR'),(6,_binary '','CARAMEL_DRIZZLE',0,20,'REGULAR'),(7,_binary '','NUTELLA',1,19,'PREMIUM'),(8,_binary '','FRESH_STRAWBERRIES',1,19,'PREMIUM'),(9,_binary '','BACON_CRUMBLES',1,20,'PREMIUM'),(10,_binary '','ICE_CREAM',1,20,'PREMIUM'),(11,_binary '','FRESH_BLUEBERRIES',1,20,'PREMIUM'),(12,_binary '','COOKIE_BUTTER',1,20,'PREMIUM');
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toppings_seq`
--

DROP TABLE IF EXISTS `toppings_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toppings_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings_seq`
--

LOCK TABLES `toppings_seq` WRITE;
/*!40000 ALTER TABLE `toppings_seq` DISABLE KEYS */;
INSERT INTO `toppings_seq` VALUES (451);
/*!40000 ALTER TABLE `toppings_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waffle_size_entity`
--

DROP TABLE IF EXISTS `waffle_size_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waffle_size_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) NOT NULL,
  `stock_count` int NOT NULL,
  `waffle_size` enum('LARGE','MINI','REGULAR') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waffle_size_entity`
--

LOCK TABLES `waffle_size_entity` WRITE;
/*!40000 ALTER TABLE `waffle_size_entity` DISABLE KEYS */;
INSERT INTO `waffle_size_entity` VALUES (1,_binary '',50,'MINI'),(2,_binary '',50,'REGULAR'),(3,_binary '',50,'LARGE');
/*!40000 ALTER TABLE `waffle_size_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waffle_size_entity_seq`
--

DROP TABLE IF EXISTS `waffle_size_entity_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waffle_size_entity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waffle_size_entity_seq`
--

LOCK TABLES `waffle_size_entity_seq` WRITE;
/*!40000 ALTER TABLE `waffle_size_entity_seq` DISABLE KEYS */;
INSERT INTO `waffle_size_entity_seq` VALUES (1);
/*!40000 ALTER TABLE `waffle_size_entity_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waffle_type_entity`
--

DROP TABLE IF EXISTS `waffle_type_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waffle_type_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_available` bit(1) NOT NULL,
  `stock_count` int NOT NULL,
  `waffle_type` enum('BELGIAN','BUTTER_MILK','CHURRO','LIEGE','RED_VELVET') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waffle_type_entity`
--

LOCK TABLES `waffle_type_entity` WRITE;
/*!40000 ALTER TABLE `waffle_type_entity` DISABLE KEYS */;
INSERT INTO `waffle_type_entity` VALUES (1,_binary '\0',50,'BUTTER_MILK'),(2,_binary '',50,'BELGIAN'),(3,_binary '',50,'LIEGE'),(4,_binary '',50,'CHURRO'),(5,_binary '',50,'RED_VELVET');
/*!40000 ALTER TABLE `waffle_type_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waffle_type_entity_seq`
--

DROP TABLE IF EXISTS `waffle_type_entity_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waffle_type_entity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waffle_type_entity_seq`
--

LOCK TABLES `waffle_type_entity_seq` WRITE;
/*!40000 ALTER TABLE `waffle_type_entity_seq` DISABLE KEYS */;
INSERT INTO `waffle_type_entity_seq` VALUES (1);
/*!40000 ALTER TABLE `waffle_type_entity_seq` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-28 12:11:59
