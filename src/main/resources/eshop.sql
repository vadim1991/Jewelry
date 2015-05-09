/*
Navicat MySQL Data Transfer

Source Server         : data
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : eshop

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2015-05-01 18:51:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'ring');
INSERT INTO `category` VALUES ('2', 'earrings');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', 'image', 'image\\rings.png');
INSERT INTO `image` VALUES ('2', 'кув', 'image\\rings.png');
INSERT INTO `image` VALUES ('3', 'ring3', 'images\\jewel\\rings\\ringEm1.jpg');
INSERT INTO `image` VALUES ('4', 'ring4', 'images\\jewel\\rings\\ringEm4.png');
INSERT INTO `image` VALUES ('5', 'ring5', 'images\\jewel\\rings\\ringEm3.jpg');
INSERT INTO `image` VALUES ('6', 'ring6 ', 'images\\jewel\\rings\\ringEm4.png');
INSERT INTO `image` VALUES ('7', 'ring1', 'images\\jewel\\rings\\ringEm5.png');
INSERT INTO `image` VALUES ('8', 'ring2', 'images\\jewel\\rings\\ringEm6.png');
INSERT INTO `image` VALUES ('9', 'ring7', 'images\\jewel\\rings\\ringEm7.png');
INSERT INTO `image` VALUES ('10', 'ring8', 'images\\jewel\\rings\\ringEm8.png');
INSERT INTO `image` VALUES ('11', 'ring9', 'images\\jewel\\rings\\ringEm9.png');
INSERT INTO `image` VALUES ('12', 'ring10', 'images\\jewel\\rings\\ringEm10.png');
INSERT INTO `image` VALUES ('13', 'ear1', 'images\\jewel\\earrings\\ear1.png');
INSERT INTO `image` VALUES ('14', 'ear2', 'images\\jewel\\earrings\\ear2.png');
INSERT INTO `image` VALUES ('15', 'ear3', 'images\\jewel\\earrings\\ear3.png');
INSERT INTO `image` VALUES ('16', 'ear4', 'images\\jewel\\earrings\\ear4.png');
INSERT INTO `image` VALUES ('17', 'earD1', 'images\\jewel\\earrings\\earD1.jpg');
INSERT INTO `image` VALUES ('18', 'earD2', 'images\\jewel\\earrings\\earD2.jpg');
INSERT INTO `image` VALUES ('19', 'earF1', 'images\\jewel\\earrings\\earF1.jpg');
INSERT INTO `image` VALUES ('20', 'earF2', 'images\\jewel\\earrings\\earF2.jpg');
INSERT INTO `image` VALUES ('21', 'earF3', 'images\\jewel\\earrings\\earF3.jpg');
INSERT INTO `image` VALUES ('22', 'earF4', 'images\\jewel\\earrings\\earF4.jpg');
INSERT INTO `image` VALUES ('23', 'earD3', 'images\\jewel\\earrings\\earD3.png');
INSERT INTO `image` VALUES ('24', 'earD4', 'images\\jewel\\earrings\\earD4.png');
INSERT INTO `image` VALUES ('25', 'earD5', 'images\\jewel\\earrings\\earD5.png');
INSERT INTO `image` VALUES ('35', 'avatar', '\\images\\avatar\\955c9138-0df1-41cf-b6fd-d8357213ca51.jpg');
INSERT INTO `image` VALUES ('36', 'avatar', '\\images\\avatar\\abff521f-1f11-435f-8d38-8cb809b87925.jpg');
INSERT INTO `image` VALUES ('37', 'avatar', '\\images\\avatar\\unknown-person.png');
INSERT INTO `image` VALUES ('38', 'avatar', '\\images\\avatar\\a4df34c5-5ac1-47ff-8077-449ff087f4d2.jpg');

-- ----------------------------
-- Table structure for `inserts`
-- ----------------------------
DROP TABLE IF EXISTS `inserts`;
CREATE TABLE `inserts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inserts
-- ----------------------------
INSERT INTO `inserts` VALUES ('1', 'diamond');
INSERT INTO `inserts` VALUES ('2', 'emerald');
INSERT INTO `inserts` VALUES ('3', 'ruby');
INSERT INTO `inserts` VALUES ('4', 'fianit');
INSERT INTO `inserts` VALUES ('5', 'circon');
INSERT INTO `inserts` VALUES ('6', 'sapphire');
INSERT INTO `inserts` VALUES ('7', 'none');

-- ----------------------------
-- Table structure for `materials`
-- ----------------------------
DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of materials
-- ----------------------------
INSERT INTO `materials` VALUES ('1', 'red gold');
INSERT INTO `materials` VALUES ('2', 'white gold');
INSERT INTO `materials` VALUES ('3', 'platinum');
INSERT INTO `materials` VALUES ('4', 'silver');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status_id` int(11) DEFAULT NULL,
  `order_info` char(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id` (`status_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `status_id` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2', 'bla-bla-bla', '18', '2015-04-28', '28090');
INSERT INTO `orders` VALUES ('2', '2', 'bla-bla-bla', '19', '2015-04-28', '9000');
INSERT INTO `orders` VALUES ('3', '2', 'bla-bla-bla', '21', '2015-04-29', '78000');
INSERT INTO `orders` VALUES ('4', '2', 'bla-bla-bla', '19', '2015-04-30', '18790');

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('4', '7', '9000', '1', '5');
INSERT INTO `order_info` VALUES ('5', '7', '9000', '5', '6');
INSERT INTO `order_info` VALUES ('6', '11', '8790', '1', '1');
INSERT INTO `order_info` VALUES ('7', '10', '10000', '1', '1');
INSERT INTO `order_info` VALUES ('8', '12', '9300', '1', '1');
INSERT INTO `order_info` VALUES ('9', '7', '9000', '1', '2');
INSERT INTO `order_info` VALUES ('10', '13', '7800', '10', '3');
INSERT INTO `order_info` VALUES ('11', '11', '8790', '1', '4');
INSERT INTO `order_info` VALUES ('12', '10', '10000', '1', '4');

-- ----------------------------
-- Table structure for `order_status`
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_status
-- ----------------------------
INSERT INTO `order_status` VALUES ('1', 'CONFIRMED');
INSERT INTO `order_status` VALUES ('2', 'SENT');
INSERT INTO `order_status` VALUES ('3', 'RECEIVED');
INSERT INTO `order_status` VALUES ('4', 'DONE');
INSERT INTO `order_status` VALUES ('5', 'CANCELED');

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
  CONSTRAINT `category_id` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `image_id` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  CONSTRAINT `insert_id` FOREIGN KEY (`insert_id`) REFERENCES `inserts` (`id`),
  CONSTRAINT `material_id` FOREIGN KEY (`material`) REFERENCES `materials` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'Ring', '2000', 'Pure Ring', '1', '2.21', '1', '1', '1', '17');
INSERT INTO `products` VALUES ('6', 'Кольцо с изумрудом', '7800', 'Красивое кольцо', '3', '2.01', '2', '2', '1', '16');
INSERT INTO `products` VALUES ('7', 'Кольцо с изумрудом', '9000', 'Красивое', '4', '1.99', '2', '2', '1', '17.5');
INSERT INTO `products` VALUES ('8', 'Кольцо с изумрудом', '6500', 'Красивое', '5', '2.11', '2', '2', '1', '17');
INSERT INTO `products` VALUES ('9', 'Кольцо', '6700', 'Безумное', '6', '1.77', '2', '2', '1', '17');
INSERT INTO `products` VALUES ('10', 'Серьги с бриллиантом', '10000', 'Прекрасные серьги', '13', '3.23', '2', '2', '2', null);
INSERT INTO `products` VALUES ('11', 'Серьги с изумрудом', '8790', 'Очаровательные серьги', '14', '3.11', '2', '2', '2', null);
INSERT INTO `products` VALUES ('12', 'Серьги с изумрудом', '9300', 'Красивые серьги', '15', '2.88', '2', '2', '2', null);
INSERT INTO `products` VALUES ('13', 'Серьги с изумрудом', '7800', 'Красивые серьги', '16', '2.77', '2', '2', '2', null);
INSERT INTO `products` VALUES ('14', 'Серьги с бриллиантами', '11300', 'Чистый бриллиант', '17', '3.01', '1', '2', '2', null);
INSERT INTO `products` VALUES ('15', 'Серьги с бриллиантами', '13210', 'Красивые серьги', '18', '2.98', '1', '2', '2', null);
INSERT INTO `products` VALUES ('16', 'Серьги с бриллиантами', '10110', 'Красивые серьги', '24', '3.11', '1', '2', '2', null);

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'admin');
INSERT INTO `roles` VALUES ('2', 'client');
INSERT INTO `roles` VALUES ('3', 'manager');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `image_id` int(11) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `loginFailAmount` int(11) DEFAULT NULL,
  `lastLoginDate` timestamp NULL DEFAULT NULL,
  `unblockTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_role` (`role`),
  KEY `id_image` (`image_id`),
  CONSTRAINT `id_image` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  CONSTRAINT `id_role` FOREIGN KEY (`role`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('18', 'Vadim', 'Vlasenko', '23', 'vadim_vlasenko@bk.ru', 'qwe123', 'qweqwe', '35', '2', '0', '2015-04-29 15:12:36', '2015-04-29 15:12:36');
INSERT INTO `users` VALUES ('19', 'Vadim', 'Vlasenko', '23', 'vadim_vlasenko@bk.ru', 'qwe123', 'vadim1991', '36', '2', '0', '2015-04-30 12:44:41', '2015-04-30 12:44:41');
INSERT INTO `users` VALUES ('20', 'qwe', 'qwe', '23', 'vadim_vlasenko@bk.ru', 'qwe123', 'qwe123', '37', '2', '0', '2015-04-29 15:12:27', '2015-04-29 15:12:27');
INSERT INTO `users` VALUES ('21', 'Name', 'asdasd', '23', 'Kmytsykov@yandex.ua', 'qwe123', 'login', '38', '2', '0', '2015-04-29 18:10:46', '2015-04-29 18:10:46');
