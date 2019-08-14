-- Dumping database structure for hr-portal
DROP DATABASE IF EXISTS `hr-portal`;
CREATE DATABASE IF NOT EXISTS `hr-portal`;
USE `hr-portal`;

 
-- Dumping structure for table hr-portal.profile
DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`username`),
  UNIQUE (`email`)
);

 
-- Alert Table
CREATE TABLE IF NOT EXISTS `alert` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `subject` varchar(80) NOT NULL,
    `description` varchar(200) NOT NULL,
    `create_date` datetime NOT NULL,
    `last_modified_date` datetime,
    `is_active` bool NOT NULL,
    `delete_date` datetime,
    PRIMARY KEY (`id`)   
);

-- Announcement Table
CREATE TABLE IF NOT EXISTS `announcement`(
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `subject` VARCHAR(80) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `color` ENUM('PURPLE','ORANGE','BLUE') NULL,
    `link` VARCHAR(100) NULL,
    `is_active` BOOLEAN NOT NULL,
    `create_date` DATETIME NOT NULL,
    `last_modified_date` DATETIME NULL,
    `delete_date` DATETIME NULL,
    PRIMARY KEY (`id`)
);

-- Add Config Specification Table
CREATE TABLE config_specification(
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    data_type ENUM('STRING','INTEGER','BOOLEAN','LIST_STRING') NOT NULL,
    default_value VARCHAR(2000) NOT NULL,
    PRIMARY KEY (ID),
    UNIQUE (name)
);


-- Add message table
CREATE TABLE IF NOT EXISTS message (
    id INT(11) NOT NULL AUTO_INCREMENT,
    subject VARCHAR(50) NOT NULL,
    message VARCHAR(500) NOT NULL,
    date_sent DATETIME NOT NULL,
    PRIMARY KEY (id)
);
