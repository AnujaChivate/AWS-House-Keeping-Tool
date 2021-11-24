-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: usermanagement
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Account_ID',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date of creation',
  `created_by` varchar(40) NOT NULL COMMENT 'Created_by',
  `updated_on` timestamp NULL DEFAULT NULL COMMENT 'Updated_on',
  `updated_by` varchar(40) DEFAULT NULL COMMENT 'updated_by',
  `hsps_id` varchar(50) DEFAULT NULL COMMENT 'HSPS ID',
  `project_expire_date` timestamp NULL DEFAULT NULL COMMENT 'Project_expire_date',
  `free_trial_expire_date` timestamp NULL DEFAULT NULL COMMENT 'Free_trial_expire_date',
  `AWS_account_owner_name` varchar(50) DEFAULT NULL COMMENT 'AWS_Account_Owner_name',
  `hsps_expire_date` timestamp NULL DEFAULT NULL COMMENT 'HSPS_expire_date',
  `email_id_of_owner` varchar(50) NOT NULL COMMENT 'Email_ID_of_Owner_Account',
  `project_name` varchar(100) DEFAULT NULL COMMENT 'Project_name',
  `project_id` varchar(50) DEFAULT NULL COMMENT 'Project_ID',
  `account_type` varchar(20) NOT NULL COMMENT 'Account_Type',
  `hsps_description` varchar(250) DEFAULT NULL COMMENT 'HSPS_description',
  `business_unit` varchar(20) DEFAULT NULL COMMENT 'Business_Unit',
  `AWS_account_number` varchar(20) NOT NULL COMMENT 'AWS_Account_Number',
  `AWS_account_alias` varchar(40) DEFAULT NULL COMMENT 'AWS_Account_Alias',
  `AWS_access_key` varchar(100) DEFAULT NULL COMMENT 'AWS_Access_Key',
  `AWS_secret_key` varchar(100) DEFAULT NULL COMMENT 'AWS_Secret_Key',
  `AWS_access_key_XXXX` varchar(45) DEFAULT NULL,
  `AWS_secret_key_XXXX` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-05 17:41:45
