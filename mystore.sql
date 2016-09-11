/*
Navicat MySQL Data Transfer

Source Server         : me
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : estore

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-01-15 01:36:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(32) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '进口纯牛奶');
INSERT INTO `category` VALUES ('2', '饼干');
INSERT INTO `category` VALUES ('3', '糖果');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` varchar(32) NOT NULL,
  `money` double(10,2) NOT NULL,
  `recipients` varchar(32) DEFAULT NULL,
  `tel` varchar(16) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(32) NOT NULL,
  `pid` varchar(32) NOT NULL,
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_sss` (`oid`),
  KEY `fk_oss` (`pid`),
  CONSTRAINT `fk_oss` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_sss` FOREIGN KEY (`oid`) REFERENCES `order` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` varchar(100) NOT NULL,
  `pname` varchar(200) NOT NULL,
  `estoreprice` double(10,2) DEFAULT NULL,
  `markprice` double(10,2) NOT NULL,
  `pnum` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk_cid` (`cid`),
  CONSTRAINT `fk_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1001', '德亚Weidendorf', '79.00', '60.00', '123', '1', '01.jpg', '德国进口牛奶 德亚Weidendorf全脂牛奶200mlx30_箱			\r\n');
INSERT INTO `product` VALUES ('1002', '欧德堡全脂纯牛奶', '64.00', '50.00', '152', '1', '02.jpg', '德国进口欧德堡超高温灭菌3.5%全脂纯牛奶 200ml*24			\r\n');
INSERT INTO `product` VALUES ('1003', '安佳全脂纯牛奶', '149.00', '120.00', '145', '1', '03.jpg', '安佳 新西兰进口超高温灭菌100%全脂纯牛奶 1L*12盒			\r\n');
INSERT INTO `product` VALUES ('1004', '皇冠丹麦曲奇饼干', '45.90', '40.00', '145', '2', '04.jpg', '印尼进口皇冠丹麦曲奇饼干454g/罐 零食 饼干			\r\n');
INSERT INTO `product` VALUES ('1005', '奥利奥饼干 巧克力口味', '12.90', '10.00', '145', '2', '05.jpg', '亿滋 奥利奥饼干 巧克力口味 390g 3包独立装			\r\n');
INSERT INTO `product` VALUES ('1006', '蔓越莓曲奇饼干', '7.90', '5.00', '145', '2', '06.jpg', '卜珂 蔓越莓曲奇饼干200g/袋饼干糕点制作休闲零食			\r\n');
INSERT INTO `product` VALUES ('1007', '德芙巧克力礼盒M豆', '28.90', '20.00', '145', '3', '07.jpg', '德芙巧克力礼盒M豆 花生牛奶混合大包装270g 零食			\r\n');
INSERT INTO `product` VALUES ('1008', 'X-5花生牛奶夹心巧克力棒', '12.90', '10.00', '145', '3', '08.jpg', '韩国进口X-5花生牛奶夹心巧克力棒36g*4原味盒装			\r\n');
INSERT INTO `product` VALUES ('1009', '甜甜乐星球杯', '18.90', '15.00', '145', '3', '09.jpg', '甜甜乐星球杯390g巧克力怀旧零食小吃（代可可脂）			\r\n');

-- ----------------------------
-- Table structure for `shoppingcar`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `fk_s_uid` (`uid`),
  CONSTRAINT `fk_s_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `shoppingitem`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingitem`;
CREATE TABLE `shoppingitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `pid` varchar(32) NOT NULL,
  `snum` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_ss_sid` (`sid`),
  CONSTRAINT `fk_ss_sid` FOREIGN KEY (`sid`) REFERENCES `shoppingcar` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `nickname` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `headicon` varchar(255) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '123', '123@123.com', '2016-01-11 20:34:16', null, '2016-01-11 20:34:16');
