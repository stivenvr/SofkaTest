-- MariaDB dump 10.19  Distrib 10.8.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Spacecrafts
-- ------------------------------------------------------
-- Server version	10.8.6-MariaDB-1:10.8.6+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `spacecraft`
--

DROP TABLE IF EXISTS `spacecraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spacecraft` (
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `fuel` varchar(50) NOT NULL,
  `thrust` int(10) NOT NULL,
  `weight` int(10) NOT NULL,
  `heigt` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spacecraft`
--

LOCK TABLES `spacecraft` WRITE;
/*!40000 ALTER TABLE `spacecraft` DISABLE KEYS */;
INSERT INTO `spacecraft` VALUES
('Saturn V','Rocket Launcher','solid chemical',3500,2900,100),
('Energy','Rocket Launcher','refined petroleum and liquid oxygen',3060,2400,60),
('Ariane V','Rocket Launcher','liquid O, liquid N and Solid',1450,777,59),
('sonda Cassini-Huygens','Unmanned Spacecraft','MMH and nitrogen tetroxide',45,20,10),
('Pionero XI','Unmanned Spacecraft','MMH and nitrogen tetroxide',26,258,10),
('sonda Mensajero','Unmanned Spacecraft','MMH and nitrogen tetroxide',1593,1093,30),
('Skylab','Manned Spacecraft','MMH and nitrogen tetroxide',100,77,50),
('Salyut','Manned Spacecraft','Refined pretroleum and Liquid O',150,20,40),
('Estación Espacial Internacional','Manned Spacecraft','Refined pretroleum and Liquid O',563,420,200),
('Saturn III','Manned Spacecraft','Liquid N',1000,123,89),
('Mars III','Unmanned Spacecraft','Liquid O',1222,234,40),
('Jupiter','Manned Spacecraft','Solid Nitrogen',1234,321,23);
/*!40000 ALTER TABLE `spacecraft` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-14 15:21:22
