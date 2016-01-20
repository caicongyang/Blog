/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : ccy

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-06-04 15:33:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mail` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `rePassword` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'ccy', '13774598865', null, 'ccy', 'ccy', null);
