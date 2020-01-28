CREATE DATABASE  IF NOT EXISTS `dronalia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dronalia`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: dronalia
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `dron`
--

DROP TABLE IF EXISTS `dron`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dron` (
  `dron_id` int(11) NOT NULL,
  `dron_name` varchar(45) NOT NULL,
  `dron_axis` varchar(45) DEFAULT NULL,
  `dron_measure` varchar(45) DEFAULT NULL,
  `dron_weight` varchar(45) DEFAULT NULL,
  `dron_colour` varchar(45) DEFAULT NULL,
  `dron_price` varchar(45) DEFAULT NULL,
  `dron_skin_id` int(11) DEFAULT NULL,
  `dron_fac_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dron_id`),
  KEY `dron_skin_id_idx` (`dron_skin_id`),
  KEY `dron_fac_id_idx` (`dron_fac_id`),
  CONSTRAINT `dron_fac_id` FOREIGN KEY (`dron_fac_id`) REFERENCES `facture` (`fac_id`),
  CONSTRAINT `dron_skin_id` FOREIGN KEY (`dron_skin_id`) REFERENCES `skin` (`skin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dron`
--

LOCK TABLES `dron` WRITE;
/*!40000 ALTER TABLE `dron` DISABLE KEYS */;
/*!40000 ALTER TABLE `dron` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facture` (
  `fac_id` int(11) NOT NULL,
  `fac_date` date DEFAULT NULL,
  `fac_import` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

LOCK TABLES `facture` WRITE;
/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `per_dni` int(11) NOT NULL,
  `per_name` varchar(45) NOT NULL,
  `per_surname` varchar(45) DEFAULT NULL,
  `per_telephone` varchar(45) DEFAULT NULL,
  `per_email` varchar(45) DEFAULT NULL,
  `per_direction` varchar(45) DEFAULT NULL,
  `per_fac_id` int(11) DEFAULT NULL,
  `per_genre` enum('Male','Female','Other') DEFAULT NULL,
  PRIMARY KEY (`per_dni`),
  KEY `per_fac_id_idx` (`per_fac_id`),
  CONSTRAINT `per_fac_id` FOREIGN KEY (`per_fac_id`) REFERENCES `facture` (`fac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skin`
--

DROP TABLE IF EXISTS `skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skin` (
  `skin_id` int(11) NOT NULL,
  `skin_type` enum('snow','night','urban','sand','black','green','red','blue','white','spider','pink','ocean') DEFAULT NULL,
  `skin_cover` varchar(45) DEFAULT NULL,
  `skin_price` varchar(45) DEFAULT NULL,
  `skin_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`skin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skin`
--

LOCK TABLES `skin` WRITE;
/*!40000 ALTER TABLE `skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `skin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-27 17:35:39
