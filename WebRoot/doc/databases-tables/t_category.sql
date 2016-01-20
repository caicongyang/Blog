/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : ccy

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-06-04 15:35:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
