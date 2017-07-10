-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: docente
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_endereco` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `LOGRADOURO` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
INSERT INTO `tb_endereco` VALUES (1,'MATRIZ','556000000','VITORIA DE SANTO ANTAO',NULL,16,'RUA DA FONTE','15'),(2,'livramento','56000-000','VITORIA DE SANTO ANTAO',NULL,16,'RUA DA FONTE','99'),(3,'matriz','556000000','VITORIA DE SANTO ANTAO',NULL,16,'rua juarez candido carneiro','15'),(4,'matriz','5-5600000','VITORIA DE SANTO ANTAO',NULL,16,'RUA DA FONTE','54'),(5,'MATRIZ','5-5600000','VITORIA DE SANTO ANTAO',NULL,16,'rua joaquim lira','10'),(6,'maues','5-5600000','VITORIA DE SANTO ANTAO',NULL,16,'tua sena','78'),(7,'matriz','56000-000','VITORIA DE SANTO ANTAO',NULL,16,'rua juarez candido carneiro','15'),(8,'maues','55600-000','VITORIA DE SANTO ANTAO',NULL,16,'tua sena','78'),(9,'matriz','55600-000','VITORIA DE SANTO ANTAO',NULL,16,'RUA DA FONTE','54'),(10,'matriz','56000-000','VITORIA DE SANTO ANTAO',NULL,16,'rua juarez candido carneiro','15');
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 22:34:24
