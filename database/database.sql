
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

CREATE DATABASE IF NOT EXISTS `hktool` DEFAULT CHARACTER SET utf8;

USE `hktool`;
--
-- Database: `prontodb`
--


DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `Account_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Account_ID',
  `created_on` date NOT NULL COMMENT 'Date of creation',
  `created_by` varchar(40) NOT NULL COMMENT 'Created_by',
  `updated_on` date DEFAULT NULL COMMENT 'Updated_on',
  `updated_by` varchar(40) DEFAULT NULL COMMENT 'updated_by',
  `hsps_id` int(11) DEFAULT NULL COMMENT 'HSPS ID',
  `project_expire_date` date DEFAULT NULL COMMENT 'Project_expire_date',
  `free_trial_expire_date` date DEFAULT NULL COMMENT 'Free_trial_expire_date',
  `awsAccount_Owner_name` varchar(40) DEFAULT NULL COMMENT 'AWS_Account_Owner_name',
  `hsps_expire_date` date DEFAULT NULL COMMENT 'HSPS_expire_date',
  `email_id_of_owner` varchar(40) NOT NULL COMMENT 'Email_ID_of_Owner_Account',
  `project_name` varchar(40) DEFAULT NULL COMMENT 'Project_name',
  `project_id` int(11) DEFAULT NULL COMMENT 'Project_ID',
  `account_type` enum('client','internal') NOT NULL COMMENT 'Account_Type',
  `hsps_description` varchar(40) DEFAULT NULL COMMENT 'HSPS_description',
  `business_unit` int(20) DEFAULT NULL COMMENT 'Business_Unit',
  `AWS_Account_Number` int(24) NOT NULL COMMENT 'AWS_Account_Number',
  `AWS_Account_Alias` varchar(40) DEFAULT NULL COMMENT 'AWS_Account_Alias',
  `AWS_Access_Key` int(40) NOT NULL COMMENT 'AWS_Access_Key',
  `AWS_Secret_Key` int(40) NOT NULL COMMENT 'AWS_Secret_Key',
  PRIMARY KEY (`Account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accountuserassociation`
--

DROP TABLE IF EXISTS `accountuserassociation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountuserassociation` (
  `budget_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Budget_ID',
  `budget_start_date` date NOT NULL COMMENT 'Budget_Start_Date',
  `budget_end_date` date NOT NULL COMMENT 'Budget_End_Date',
  `budget_amount` int(11) NOT NULL COMMENT 'Budget_Amount',
  `budget_description` varchar(40) DEFAULT NULL COMMENT 'Budget_Description',
  `budget_conditional_operator` enum('is equal','less than','greater than','not equal') DEFAULT NULL,
  `uid` int(11) unsigned NOT NULL COMMENT 'UID',
  `Account_id` int(11) unsigned NOT NULL COMMENT 'Account_id',
  PRIMARY KEY (`budget_id`),
  KEY `uid` (`uid`),
  KEY `Account_id` (`Account_id`),
  CONSTRAINT `accountuserassociation_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `accountuserassociation_ibfk_2` FOREIGN KEY (`Account_id`) REFERENCES `account` (`Account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountuserassociation`
--

LOCK TABLES `accountuserassociation` WRITE;
/*!40000 ALTER TABLE `accountuserassociation` DISABLE KEYS */;
/*!40000 ALTER TABLE `accountuserassociation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) unsigned NOT NULL COMMENT 'Role_ID',
  `role_name` varchar(40) NOT NULL COMMENT 'Role_Name',
  `active` int(11) NOT NULL COMMENT '1=active 0=inactive',
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID of user',
  `username` varchar(40) DEFAULT NULL COMMENT 'Username',
  `firstname` varchar(40) DEFAULT NULL COMMENT 'First name of user',
  `lastname` varchar(40) DEFAULT NULL COMMENT 'Last name of user',
  `password` varchar(40) NOT NULL COMMENT 'Password',
  `email` varchar(40) NOT NULL COMMENT 'Email of user',
  `createon` date NOT NULL COMMENT 'Date of creation',
  `role` varchar(20) NOT NULL COMMENT 'Role of user',
  `active` int(11) NOT NULL COMMENT '1=active 0=inactive',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2017-01-28 20:41:43
