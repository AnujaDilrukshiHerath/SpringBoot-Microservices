-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartId` int NOT NULL,
  `subTotal` int DEFAULT NULL,
  `user_userId` int NOT NULL,
  PRIMARY KEY (`cartId`),
  KEY `fk_cart_user_idx` (`user_userId`),
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`user_userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,0,1),(2,0,2),(3,0,3);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_has_product`
--

DROP TABLE IF EXISTS `cart_has_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_has_product` (
  `cart_cartId` int NOT NULL,
  `product_productId` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `cartHasProductId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cartHasProductId`),
  KEY `fk_cart_has_product_product1_idx` (`product_productId`),
  KEY `fk_cart_has_product_cart1_idx` (`cart_cartId`),
  CONSTRAINT `fk_cart_has_product_cart1` FOREIGN KEY (`cart_cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `fk_cart_has_product_product1` FOREIGN KEY (`product_productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_has_product`
--

LOCK TABLES `cart_has_product` WRITE;
/*!40000 ALTER TABLE `cart_has_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_has_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn`
--

DROP TABLE IF EXISTS `grn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn` (
  `grnId` int NOT NULL,
  `totalQuentity` varchar(45) DEFAULT NULL,
  `totalGrnAmount` varchar(45) DEFAULT NULL,
  `grnDate` date DEFAULT NULL,
  PRIMARY KEY (`grnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn`
--

LOCK TABLES `grn` WRITE;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grn_has_product`
--

DROP TABLE IF EXISTS `grn_has_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grn_has_product` (
  `grn_grnId` int NOT NULL,
  `product_productId` int NOT NULL,
  `grn_has_productId` int NOT NULL AUTO_INCREMENT,
  `productQuentity` int DEFAULT NULL,
  PRIMARY KEY (`grn_has_productId`),
  KEY `fk_grn_has_product_product1_idx` (`product_productId`),
  KEY `fk_grn_has_product_grn1_idx` (`grn_grnId`),
  CONSTRAINT `fk_grn_has_product_grn1` FOREIGN KEY (`grn_grnId`) REFERENCES `grn` (`grnId`),
  CONSTRAINT `fk_grn_has_product_product1` FOREIGN KEY (`product_productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grn_has_product`
--

LOCK TABLES `grn_has_product` WRITE;
/*!40000 ALTER TABLE `grn_has_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `grn_has_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int NOT NULL,
  `productName` varchar(45) DEFAULT NULL,
  `productPrice` int DEFAULT NULL,
  `productExpiryDate` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `minQuantity` int DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Milk',50,'2021-09-23',1,NULL),(2,'Chocolate',80,'2023-01-15',NULL,NULL),(3,'Tooth Paste',100,'2022-08-17',NULL,NULL),(4,'Soap',50,'2022-06-28',NULL,NULL),(5,'Vim',300,'2024-04-08',NULL,NULL),(6,'Badam',200,'2022-12-09',NULL,NULL),(7,'Tea',150,'2022-09-29',NULL,NULL),(8,'Rise',200,'2022-12-19',NULL,NULL),(9,'KitKat',250,'2023-09-26',NULL,NULL),(10,'Biscuit',100,'2022-07-23',NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `userPhoneNumber` int DEFAULT NULL,
  `userAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Rashfa',7576868,'Kandy'),(2,'Eranga',7565674,'Colombo'),(3,'Manoj',7588323,'Galle');
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

-- Dump completed on 2021-09-02 14:16:51
