/*
Navicat MySQL Data Transfer

Source Server         : 天浩国际
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : fixed

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-04-06 17:04:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'D51C7138-7E79-43DC-8012-46C18CAB6ABC', '2014');
INSERT INTO `account` VALUES ('2', '2D6A9FE2-F170-4F87-9F69-5D0D46E22795', '2015');

-- ----------------------------
-- Table structure for fixed_net_asset
-- ----------------------------
DROP TABLE IF EXISTS `fixed_net_asset`;
CREATE TABLE `fixed_net_asset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `total` char(15) DEFAULT NULL,
  `page` char(15) DEFAULT NULL,
  `code` char(40) DEFAULT NULL,
  `name` char(70) DEFAULT NULL,
  `ssize` char(40) DEFAULT NULL,
  `units` char(20) DEFAULT NULL,
  `life` bigint(20) DEFAULT NULL,
  `salvage` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `year` double DEFAULT NULL,
  `month` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fixed_net_asset
-- ----------------------------
INSERT INTO `fixed_net_asset` VALUES ('7', 'A2586453-B503-44E2-A100-088645913915', '', '', '', '', '', '', '1', null, null, null, '1212', '2014-04-01 00:00:00');

-- ----------------------------
-- Table structure for fixed_rate_detail
-- ----------------------------
DROP TABLE IF EXISTS `fixed_rate_detail`;
CREATE TABLE `fixed_rate_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `yearproff_month` int(11) DEFAULT NULL,
  `yearproff_day` int(11) DEFAULT NULL,
  `yearproff_type` char(10) DEFAULT NULL,
  `yearproff_num` char(20) DEFAULT NULL,
  `remark` char(30) DEFAULT NULL,
  `fixed_add_num` bigint(20) DEFAULT NULL,
  `fixed_add_price` double DEFAULT NULL,
  `fixed_add_total` double DEFAULT NULL,
  `fixed_reduce_num` bigint(20) DEFAULT NULL,
  `fixed_reduce_price` double DEFAULT NULL,
  `fixed_balance_num` bigint(20) DEFAULT NULL,
  `fixed_balance_price` double DEFAULT NULL,
  `sum_depreciation_currentmonth` double DEFAULT NULL,
  `sum_depreciation_total` double DEFAULT NULL,
  `fixed_net_worth` double DEFAULT NULL,
  `pid` char(64) DEFAULT NULL,
  `year` char(10) DEFAULT NULL,
  `manage_fee` double DEFAULT NULL,
  `made_fee` double DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT '0',
  `name` char(40) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fixed_rate_detail
-- ----------------------------
INSERT INTO `fixed_rate_detail` VALUES ('168', '15E11AE4-F624-4CC5-B0D2-38FB59440133', '5', '31', null, null, '折旧', null, null, null, null, null, null, null, '1212', '1212', '2120000', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('166', '2C0DB3CF-1FC0-4339-BFA6-F402F0104740', null, null, null, null, '', null, null, null, null, null, null, '2121212', null, null, null, 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('173', '81A3AB76-8A12-4389-989C-801650975539', '10', '31', null, null, '折旧', null, null, null, null, null, null, null, '1212', '7272', '2113940', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('167', '8B503D7C-DC3C-4135-B388-E488C602FD0B', '4', '30', null, null, '折旧', null, null, null, null, null, null, null, '1212', '0', '2121212', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('175', '9B040621-7515-408E-BF7A-869352C6ED72', '12', '31', null, null, '折旧', null, null, null, null, null, null, null, '1212', '9696', '2111516', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('170', 'C310B718-6435-4A17-BFE1-1BB1BF60D559', '7', '31', null, null, '折旧', null, null, null, null, null, null, null, '1212', '3636', '2117576', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('169', 'C696B6D9-AD97-45BB-BAF7-076F35D024BA', '6', '30', null, null, '折旧', null, null, null, null, null, null, null, '1212', '2424', '2118788', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('174', 'E45C799E-1835-4556-8925-4A0B6506E43E', '11', '30', null, null, '折旧', null, null, null, null, null, null, null, '1212', '8484', '2112728', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('172', 'F3AE1BB3-D03C-42B7-BEC8-AA6435D4532B', '9', '30', null, null, '折旧', null, null, null, null, null, null, null, '1212', '6060', '2115152', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');
INSERT INTO `fixed_rate_detail` VALUES ('171', 'F421D624-8BE8-4E45-9911-F0A881E5BBD1', '8', '31', null, null, '折旧', null, null, null, null, null, null, null, '1212', '4848', '2116364', 'A2586453-B503-44E2-A100-088645913915', '2014', '1212', null, '0', '');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `type` int(11) DEFAULT '0',
  `name` char(50) DEFAULT NULL,
  `sign` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'DE6F017A-66A6-403C-BF4C-328BE4A05CF3', '2', '业务管理', 'business');
INSERT INTO `menu` VALUES ('2', '815FA52A-C57C-43A9-AD78-32B20C70A918', '1', '系统管理', 'system');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `permission_name` char(32) DEFAULT NULL,
  `permission_sign` char(128) DEFAULT NULL,
  `description` char(255) DEFAULT NULL,
  `url` char(255) DEFAULT NULL,
  `menu_type` int(4) NOT NULL DEFAULT '0',
  `menu_name` char(50) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('21', '13FE1CDC-DBC7-48CB-B092-A6D09CF39EDB', '用户管理', 'user', '', '/fixednetassets/user/index.do?page=1', '1', '系统管理');
INSERT INTO `permission` VALUES ('19', '38FB08AA-EDE7-49FA-BFA2-F5BA80493D1C', '角色权限管理', 'rolepermission', '', '/fixednetassets/rolepermission/index.do?page=1', '1', '系统管理');
INSERT INTO `permission` VALUES ('18', '4EFFBBA9-9F50-4BAB-B8A3-007F2EE5EC2D', '角色管理', 'role', '管理角色', '/fixednetassets/role/index.do?page=1', '1', '系统管理');
INSERT INTO `permission` VALUES ('17', '5E22E309-7273-4C4B-82B0-A30859CEF21F', '菜单管理', 'menu', '管理菜单项', '/fixednetassets/menu/index.do?page=1', '1', '系统管理');
INSERT INTO `permission` VALUES ('23', 'C109B6F6-F1BB-4C17-A48C-F4C6CEFB1428', '固定资产管理', 'fixednetassets', '', '/fixednetassets/fixednetassets/index.do?page=1', '2', '业务管理');
INSERT INTO `permission` VALUES ('20', 'C52C7C76-523B-46E5-8C6A-F893393AE8B1', '权限管理', 'permission', '', '/fixednetassets/permission/index.do?page=1', '1', '系统管理');
INSERT INTO `permission` VALUES ('24', 'E3817A11-101E-49D6-A8CB-F30E90EDFDE0', '固定资产原值及折旧汇总表', 'ratetotale', '', '/fixednetassets/ratetotal/index.do?page=1', '2', '业务管理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `role_name` char(32) DEFAULT NULL,
  `role_sign` char(128) DEFAULT NULL,
  `description` char(255) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('7', '3F40D57D-2247-4377-B607-EC309E953956', '超级管理员', 'super', '');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `rid` char(64) DEFAULT NULL,
  `pid` char(64) DEFAULT NULL,
  `rolename` char(40) DEFAULT NULL,
  `permissionname` char(40) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`),
  KEY `FK_Reference_5` (`rid`),
  KEY `FK_Reference_6` (`pid`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`rid`) REFERENCES `role` (`guid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`pid`) REFERENCES `permission` (`guid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('23', '140459B6-B2B9-4A68-8B7E-2A31004B8F3F', '3F40D57D-2247-4377-B607-EC309E953956', 'C109B6F6-F1BB-4C17-A48C-F4C6CEFB1428', '超级管理员', '固定资产管理');
INSERT INTO `role_permission` VALUES ('24', '482B9BB8-8A00-4F0D-B8D2-642FFCAD4042', '3F40D57D-2247-4377-B607-EC309E953956', 'E3817A11-101E-49D6-A8CB-F30E90EDFDE0', '超级管理员', '固定资产原值及折旧汇总表');
INSERT INTO `role_permission` VALUES ('2', '5559D602-A423-4F52-906E-C05F9A7C6E00', '3F40D57D-2247-4377-B607-EC309E953956', '38FB08AA-EDE7-49FA-BFA2-F5BA80493D1C', '超级管理员', '角色权限管理');
INSERT INTO `role_permission` VALUES ('22', 'B3DACAB9-3FBB-4C1E-A517-A842B53C0CA0', '3F40D57D-2247-4377-B607-EC309E953956', 'C52C7C76-523B-46E5-8C6A-F893393AE8B1', '超级管理员', '权限管理');
INSERT INTO `role_permission` VALUES ('19', 'E018CAFA-4D5B-4038-B00D-FF7864F0ED71', '3F40D57D-2247-4377-B607-EC309E953956', '13FE1CDC-DBC7-48CB-B092-A6D09CF39EDB', '超级管理员', '用户管理');
INSERT INTO `role_permission` VALUES ('21', 'E0695CFF-2EE4-4A1D-BA0A-CD1FA325DB3F', '3F40D57D-2247-4377-B607-EC309E953956', '5E22E309-7273-4C4B-82B0-A30859CEF21F', '超级管理员', '菜单管理');
INSERT INTO `role_permission` VALUES ('20', 'EC67AEFE-0F95-4121-B168-640CB9ABBA6F', '3F40D57D-2247-4377-B607-EC309E953956', '4EFFBBA9-9F50-4BAB-B8A3-007F2EE5EC2D', '超级管理员', '角色管理');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `name` char(50) DEFAULT NULL,
  `pass` char(64) DEFAULT NULL,
  `tel` char(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(10) DEFAULT NULL,
  `ip_address` char(40) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '00000000-0000-0000-0000-000000000000', 'admin', '8bcdddf39073efb844b769d699535241', null, null, '上线状态', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `guid` char(64) NOT NULL,
  `uid` char(64) DEFAULT NULL,
  `rid` char(64) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  KEY `AK_unique` (`id`),
  KEY `FK_Reference_2` (`uid`),
  KEY `FK_Reference_4` (`rid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`uid`) REFERENCES `user` (`guid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`rid`) REFERENCES `role` (`guid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2', '8DF2F2F0-EA89-460D-BECC-812FDBE1345A', '00000000-0000-0000-0000-000000000000', '3F40D57D-2247-4377-B607-EC309E953956');

-- ----------------------------
-- View structure for fixed_rate_total_month
-- ----------------------------
DROP VIEW IF EXISTS `fixed_rate_total_month`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fixed_rate_total_month` AS select `fixed_net_asset`.`life` AS `life`,`fixed_rate_detail`.`fixed_balance_num` AS `balance_num`,`fixed_rate_detail`.`fixed_balance_price` AS `balance_price`,`fixed_net_asset`.`salvage` AS `salvage`,`fixed_rate_detail`.`manage_fee` AS `manage_fee`,`fixed_rate_detail`.`made_fee` AS `made_fee`,`fixed_rate_detail`.`sum_depreciation_currentmonth` AS `sum_depreciation_currentmonth`,`fixed_rate_detail`.`sum_depreciation_total` AS `sum_depreciation_total`,`fixed_rate_detail`.`fixed_net_worth` AS `fixed_net_worth`,`fixed_rate_detail`.`yearproff_day` AS `time_day`,`fixed_rate_detail`.`yearproff_month` AS `time_month`,`fixed_rate_detail`.`year` AS `time_year`,`fixed_net_asset`.`name` AS `name` from (`fixed_net_asset` join `fixed_rate_detail`) where (`fixed_net_asset`.`guid` = `fixed_rate_detail`.`pid`) ;
