/*
Navicat MySQL Data Transfer

Source Server         : MySql Local
Source Server Version : 50139
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50139
File Encoding         : 65001

Date: 2018-08-26 13:25:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_function`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_function`;
CREATE TABLE `tbl_function` (
  `id` varchar(35) NOT NULL,
  `function_name` varchar(50) NOT NULL DEFAULT '',
  `function_description` varchar(50) NOT NULL DEFAULT '',
  `function_level` varchar(1) NOT NULL DEFAULT '',
  `function_url` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_function
-- ----------------------------
INSERT INTO `tbl_function` VALUES ('F001', '数据管理', '数据管理', '1', '#');
INSERT INTO `tbl_function` VALUES ('F001001', '上传数据', '上传数据', '2', '/test');
INSERT INTO `tbl_function` VALUES ('F001002', '数据列表', '数据列表', '2', '/test');
INSERT INTO `tbl_function` VALUES ('F002', '数据统计', '数据统计', '1', '#');
INSERT INTO `tbl_function` VALUES ('F002001', '数据统计', '数据统计', '2', '/test');
INSERT INTO `tbl_function` VALUES ('F003', '检测预警', '检测预警', '1', '#');
INSERT INTO `tbl_function` VALUES ('F004', '批量导出', '批量导出', '1', '#');
INSERT INTO `tbl_function` VALUES ('F005', '黑名单管理', '黑名单管理', '1', '#');
INSERT INTO `tbl_function` VALUES ('F006', '车系管理', '车系管理', '1', '#');
INSERT INTO `tbl_function` VALUES ('F006001', '车系列表', '车系列表', '2', '#');

-- ----------------------------
-- Table structure for `tbl_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` varchar(35) NOT NULL,
  `role_name` varchar(50) NOT NULL DEFAULT '',
  `role_description` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('1', '管理员', '管理员');

-- ----------------------------
-- Table structure for `tbl_rolefunction`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_rolefunction`;
CREATE TABLE `tbl_rolefunction` (
  `role_id` varchar(35) NOT NULL,
  `function_id` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_rolefunction
-- ----------------------------
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F001');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F001001');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F001002');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F002');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F002001');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F003');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F004');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F005');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F006');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F006001');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(35) NOT NULL,
  `usercode` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'test@qq.com', '测试');

-- ----------------------------
-- Table structure for `tbl_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userrole`;
CREATE TABLE `tbl_userrole` (
  `user_id` varchar(35) NOT NULL,
  `role_id` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_userrole
-- ----------------------------
INSERT INTO `tbl_userrole` VALUES ('1', '1');
