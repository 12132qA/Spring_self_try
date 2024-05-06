-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: data
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `course`
--

--
-- Table structure for table `new_car`
-- Table structure for table `new_car`
--
create  database if not exists data ;
use data;
DROP TABLE IF EXISTS `new_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_car` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '默认自增',
  `price` int DEFAULT NULL COMMENT '价格',
  `name` varchar(100) DEFAULT NULL,
  `sale` int DEFAULT NULL COMMENT '销量',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `electric` int DEFAULT NULL COMMENT '每公里耗电量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_car`
--

LOCK TABLES `new_car` WRITE;
/*!40000 ALTER TABLE `new_car` DISABLE KEYS */;
INSERT INTO `new_car` VALUES (9,12,'man',120,'oop',200),(10,12,'lao',190,'po',12),(11,112,'oi',120,'lpop',1290),(12,121,'lop',190,'ren',122);
/*!40000 ALTER TABLE `new_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_car`
--

DROP TABLE IF EXISTS `order_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_car` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '默认自增',
  `price` int DEFAULT NULL COMMENT '价格',
  `name` varchar(100) DEFAULT NULL,
  `sale` int DEFAULT NULL COMMENT '销量',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌',
  `oil` text COMMENT '每公里耗油量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_car`
--

LOCK TABLES `order_car` WRITE;
/*!40000 ALTER TABLE `order_car` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--
-- Table structure for table `t`
--