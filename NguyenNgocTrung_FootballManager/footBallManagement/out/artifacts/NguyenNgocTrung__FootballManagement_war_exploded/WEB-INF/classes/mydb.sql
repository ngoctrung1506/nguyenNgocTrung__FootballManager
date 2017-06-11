- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `goal_scrored`
--

DROP TABLE IF EXISTS `goal_scrored`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goal_scrored` (
  `id` int(11) NOT NULL,
  `time` int(11) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_id_idx` (`player_id`),
  KEY `fixture_id_idx` (`match_id`),
  CONSTRAINT `fixture_id` FOREIGN KEY (`match_id`) REFERENCES `match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal_scrored`
--

LOCK TABLES `goal_scrored` WRITE;
/*!40000 ALTER TABLE `goal_scrored` DISABLE KEYS */;
/*!40000 ALTER TABLE `goal_scrored` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leage`
--

DROP TABLE IF EXISTS `leage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leage` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `logo` varchar(45) DEFAULT NULL,
  `prize` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leage`
--

LOCK TABLES `leage` WRITE;
/*!40000 ALTER TABLE `leage` DISABLE KEYS */;
/*!40000 ALTER TABLE `leage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `team1_score` int(11) DEFAULT NULL,
  `team2_score` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `team1_id` int(11) NOT NULL,
  `team2_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fixture_team1_idx` (`team1_id`),
  KEY `fk_fixture_team2_idx` (`team2_id`),
  CONSTRAINT `fk_fixture_team1` FOREIGN KEY (`team1_id`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fixture_team2` FOREIGN KEY (`team2_id`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `goal` int(11) DEFAULT NULL,
  `photo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `team_id_idx` (`team_id`),
  CONSTRAINT `team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_match`
--

DROP TABLE IF EXISTS `player_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_match` (
  `min_played` int(11) NOT NULL,
  `yellow_card` int(11) DEFAULT NULL,
  `red_card` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`min_played`,`id`),
  KEY `player_id_idx` (`player_id`),
  KEY `match_id_idx` (`match_id`),
  KEY `fk player_id_idx` (`player_id`),
  KEY `fk match_id_idx` (`match_id`),
  CONSTRAINT `fk1 match_id` FOREIGN KEY (`match_id`) REFERENCES `match` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk1 player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_match`
--

LOCK TABLES `player_match` WRITE;
/*!40000 ALTER TABLE `player_match` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `name` varchar(45) NOT NULL,
  `numberOfWin` int(11) DEFAULT NULL,
  `numberOfLost` int(11) DEFAULT NULL,
  `numberOfDraw` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `logo` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leage_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team_leage1_idx` (`leage_id`),
  CONSTRAINT `fk_team_leage1` FOREIGN KEY (`leage_id`) REFERENCES `leage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-03  0:38:36