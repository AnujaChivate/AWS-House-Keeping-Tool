-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2017 at 12:39 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hktool`
--
CREATE DATABASE IF NOT EXISTS `hktool` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hktool`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `account_user_association`
--

CREATE TABLE IF NOT EXISTS `account_user_association` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(11) unsigned NOT NULL,
  `is_active` bit(1) NOT NULL,
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE IF NOT EXISTS `budget` (
  `budget_id` int(11) NOT NULL,
  `budget_start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `budget_end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `budget_amount` double NOT NULL,
  `budget_description` varchar(45) DEFAULT NULL,
  `budget_conditional_operator` varchar(20) DEFAULT NULL,
  `account_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`budget_id`),
  UNIQUE KEY `budget_id_UNIQUE` (`budget_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role` int(11) NOT NULL COMMENT 'Role_ID',
  `role_name` varchar(40) NOT NULL COMMENT 'Role_Name',
  `active` int(11) NOT NULL COMMENT '1=active 0=inactive',
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role`, `role_name`, `active`) VALUES
(1, 'Super_Admin', 1),
(2, 'Admin', 1),
(3, 'User', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID of user',
  `user_name` varchar(40) NOT NULL COMMENT 'Username',
  `first_name` varchar(40) DEFAULT NULL COMMENT 'First name of user',
  `last_name` varchar(40) DEFAULT NULL COMMENT 'Last name of user',
  `password` varchar(40) NOT NULL COMMENT 'Password',
  `email` varchar(40) NOT NULL COMMENT 'Email of user',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date of creation',
  `role` int(11) NOT NULL COMMENT 'Role of user',
  `is_active` bit(1) NOT NULL COMMENT '1=active 0=inactive',
  `created_by` varchar(40) DEFAULT NULL,
  `updated_by` varchar(40) DEFAULT NULL,
  `updated_on` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username_UNIQUE` (`user_name`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  KEY `role_idx` (`role`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `user_name`, `first_name`, `last_name`, `password`, `email`, `created_on`, `role`, `is_active`, `created_by`, `updated_by`, `updated_on`) VALUES
(1, 'pavan', 'pavan', 'pawar', 'password', 'pavanpawar4591@gmail.com', '2016-12-31 18:30:01', 1, b'1', 'sa', 's', '2007-12-31 18:30:01'),
(2, 'pp', NULL, NULL, '', '', '2017-02-10 18:30:00', 1, b'1', ' ', '', '2017-02-10 18:30:00'),
(7, 'aaaa', NULL, NULL, '', '', '2017-02-10 18:30:00', 1, b'1', ' ', '', '2017-02-10 18:30:00');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_user_association`
--
ALTER TABLE `account_user_association`
  ADD CONSTRAINT `account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_id` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `budget`
--
ALTER TABLE `budget`
  ADD CONSTRAINT `account_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `role_fk` FOREIGN KEY (`role`) REFERENCES `role` (`role`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
