/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : auction

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-12-28 16:17:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auctionuc
-- ----------------------------
DROP TABLE IF EXISTS `auctionuc`;
CREATE TABLE `auctionuc` (
  `aId` int(11) NOT NULL AUTO_INCREMENT COMMENT '竞拍id',
  `uId` int(11) NOT NULL COMMENT '用户id',
  `cId` int(11) NOT NULL COMMENT '电脑id',
  `auctionPri` int(11) DEFAULT NULL COMMENT '竞拍价格',
  `auctionDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '竞拍时间',
  PRIMARY KEY (`aId`),
  KEY `acId` (`cId`),
  KEY `auId` (`uId`),
  CONSTRAINT `acId` FOREIGN KEY (`cId`) REFERENCES `computer` (`cId`),
  CONSTRAINT `auId` FOREIGN KEY (`uId`) REFERENCES `user` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auctionuc
-- ----------------------------
INSERT INTO `auctionuc` VALUES ('1', '1', '1', '300', '2020-12-28 15:08:58');
INSERT INTO `auctionuc` VALUES ('2', '2', '1', '300', '2020-12-28 15:09:43');

-- ----------------------------
-- Table structure for computer
-- ----------------------------
DROP TABLE IF EXISTS `computer`;
CREATE TABLE `computer` (
  `cId` int(11) NOT NULL AUTO_INCREMENT COMMENT '电脑ID',
  `cName` varchar(20) NOT NULL COMMENT '名称',
  `startDate` date NOT NULL COMMENT '购入时间',
  `startPrice` int(11) NOT NULL COMMENT '起购价格',
  `remark` varchar(500) NOT NULL COMMENT '描述',
  `isAuction` int(2) NOT NULL COMMENT '是否可竞拍',
  `imgUrl` varchar(100) DEFAULT NULL,
  `cutOffDate` date NOT NULL COMMENT '截止日期',
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of computer
-- ----------------------------
INSERT INTO `computer` VALUES ('1', '电脑1', '2020-12-28', '200', 'xxx', '1', null, '2020-12-30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码.',
  `cardNum` varchar(30) DEFAULT NULL COMMENT '工号',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaohong', '123456', '11', null);
INSERT INTO `user` VALUES ('2', 'xiaozhanh', '123456', '12', null);
