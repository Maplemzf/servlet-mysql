/*
Navicat MySQL Data Transfer

Source Server         : mzf
Source Server Version : 50719
Source Host           : localhost:3307
Source Database       : usermanager

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-10 23:17:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `usertable`
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `userid` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户账号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `userpass` varchar(20) NOT NULL COMMENT '用户密码',
  `usersex` varchar(3) DEFAULT NULL COMMENT '用户性别',
  `age` int(8) DEFAULT NULL COMMENT '用户年龄',
  `type` varchar(10) DEFAULT NULL COMMENT '用户类别',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('4', 'admin', 'admin', '男', '1', '管理员');
INSERT INTO `usertable` VALUES ('7', 'mzf', '123456', '男', '1', '普通成员');
INSERT INTO `usertable` VALUES ('8', '江小男', '123456', '男', '17', '管理员');
