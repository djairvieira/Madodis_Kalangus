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
-- Table structure for table `tb_professor`
--

DROP TABLE IF EXISTS `tb_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_professor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(14) NOT NULL,
  `DATA_NASCIMENTO` varchar(10) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `MATRICULA` varchar(10) NOT NULL,
  `NACIONALIDADE` varchar(100) NOT NULL,
  `NATURALIDADE` varchar(100) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `NOME_MAE` varchar(100) NOT NULL,
  `NOME_PAI` varchar(100) NOT NULL,
  `RG` varchar(20) NOT NULL,
  `RG_ORGAO_EXPEDIDOR` varchar(10) NOT NULL,
  `SENHA` varchar(100) NOT NULL,
  `SEXO` int(11) DEFAULT NULL,
  `TITULO_ELEITORAL` varchar(12) NOT NULL,
  `CTPS_DATA_EXPEDICAO` varchar(15) NOT NULL,
  `CTPS_NUMERO` varchar(20) NOT NULL,
  `TITULACAO` int(11) NOT NULL,
  `endereco_ID` int(11) DEFAULT NULL,
  `instituicao_ID` int(11) DEFAULT NULL,
  `telefone_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKFA7739BEB647D3BC` (`endereco_ID`),
  KEY `FKFA7739BE59D3F41C` (`telefone_ID`),
  KEY `FKFA7739BE6D696C58` (`instituicao_ID`),
  CONSTRAINT `FKFA7739BE59D3F41C` FOREIGN KEY (`telefone_ID`) REFERENCES `tb_telefone` (`ID`),
  CONSTRAINT `FKFA7739BE6D696C58` FOREIGN KEY (`instituicao_ID`) REFERENCES `tb_instituicao` (`ID`),
  CONSTRAINT `FKFA7739BEB647D3BC` FOREIGN KEY (`endereco_ID`) REFERENCES `tb_endereco` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_professor`
--

LOCK TABLES `tb_professor` WRITE;
/*!40000 ALTER TABLE `tb_professor` DISABLE KEYS */;
INSERT INTO `tb_professor` VALUES (1,'564.654.654-64','1970-01-01','profe@gmail.com','profe','brasileira','recife','jose simoes fereira','maria da silva','manuel jose','5.454.656','sds','profe',0,'111111111144','1990-02-01','5452121212',2,10,1,10);
/*!40000 ALTER TABLE `tb_professor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 22:34:25
