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
-- Table structure for table `tb_plano_ensino`
--

DROP TABLE IF EXISTS `tb_plano_ensino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_plano_ensino` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BIBLIOGRAFIA_USADA` varchar(250) NOT NULL,
  `CH_PRATICA` int(11) DEFAULT NULL,
  `CH_TEORICA` int(11) DEFAULT NULL,
  `EMENTA` varchar(250) NOT NULL,
  `METODO_AVALIACAO` varchar(250) NOT NULL,
  `METODO_APRENDIZAGEM` varchar(250) NOT NULL,
  `OBJETIVOS` varchar(250) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_plano_ensino`
--

LOCK TABLES `tb_plano_ensino` WRITE;
/*!40000 ALTER TABLE `tb_plano_ensino` DISABLE KEYS */;
INSERT INTO `tb_plano_ensino` VALUES (1,'TEORIA DA INFORMACAO TEORIA DA INFORMACAO TEORIA DA INFORMACAO',40,40,' TEORIA DA INFORMACAOTEORIA DA INFORMACAOTEORIA DA INFORMACAO','prova e entrega de projetosTEORIA DA INFORMACAOTEORIA DA INFORMACAO','teorico e pratico teorico e pratico teorico e pratico teorico e pratico ','TEORIA DA INFORMACAO TEORIA DA INFORMACAO TEORIA DA INFORMACAO'),(2,'APRENDER A DESENVOLVER EM JAVA APRENDER A DESENVOLVER EM JAVA APRENDER A DESENVOLVER EM JAVA',40,40,'APRENDER A DESENVOLVER EM JAVA APRENDER A DESENVOLVER EM JAVA APRENDER A DESENVOLVER EM JAVA','prova e entrega de projetos APRENDER A DESENVOLVER EM JAVA ','teorico e pratico teorico e pratico teorico e pratico teorico e pratico ','APRENDER A DESENVOLVER EM JAVA APRENDER A DESENVOLVER EM JAVA');
/*!40000 ALTER TABLE `tb_plano_ensino` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 22:34:27
