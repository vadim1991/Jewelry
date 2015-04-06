/*
Navicat MySQL Data Transfer

Source Server         : DB1
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2015-03-23 21:10:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tilte` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Ring with diamond');
INSERT INTO `category` VALUES ('2', 'Ring without insert');
INSERT INTO `category` VALUES ('3', 'Ring with emerald');
INSERT INTO `category` VALUES ('4', 'Ring with fianit');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `url` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for `insert`
-- ----------------------------
DROP TABLE IF EXISTS `insert`;
CREATE TABLE `insert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insert
-- ----------------------------
INSERT INTO `insert` VALUES ('1', 'diamond');
INSERT INTO `insert` VALUES ('2', 'emerald');
INSERT INTO `insert` VALUES ('3', 'ruby');
INSERT INTO `insert` VALUES ('4', 'fianit');
INSERT INTO `insert` VALUES ('5', 'circon');
INSERT INTO `insert` VALUES ('6', 'sapphire');

-- ----------------------------
-- Table structure for `materials`
-- ----------------------------
DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of materials
-- ----------------------------
INSERT INTO `materials` VALUES ('1', 'red gold');
INSERT INTO `materials` VALUES ('2', 'white gold');
INSERT INTO `materials` VALUES ('3', 'platinum');
INSERT INTO `materials` VALUES ('4', 'silver');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `description` char(255) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `weight` double NOT NULL,
  `insert_id` int(11) DEFAULT NULL,
  `material` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `size` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `material_id` (`material`),
  KEY `image_id` (`image_id`),
  KEY `category_id` (`category`),
  KEY `insert_id` (`insert_id`),
  CONSTRAINT `insert_id` FOREIGN KEY (`insert_id`) REFERENCES `insert` (`id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `image_id` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  CONSTRAINT `material_id` FOREIGN KEY (`material`) REFERENCES `materials` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
