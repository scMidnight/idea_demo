/*
Navicat MySQL Data Transfer

Source Server         : MySql Local
Source Server Version : 50139
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50139
File Encoding         : 65001

Date: 2018-09-05 17:05:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_car_system`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_car_system`;
CREATE TABLE `tbl_car_system` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `brand_id` varchar(255) DEFAULT NULL COMMENT '品牌id',
  `trade_name` varchar(255) DEFAULT NULL COMMENT '厂商名称',
  `trade_id` varchar(255) DEFAULT NULL COMMENT '厂商ID',
  `car_sys_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `car_sys_id` varchar(255) DEFAULT NULL COMMENT '车系ID',
  `is_del` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_car_system
-- ----------------------------
INSERT INTO `tbl_car_system` VALUES ('01382059662F28861677591AFA95DA23', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `tbl_car_system` VALUES ('1', '玛莎拉蒂', '57', '玛莎拉蒂', '3', '总裁', '289', '0');
INSERT INTO `tbl_car_system` VALUES ('10', '长城', '77', '长城汽车', '4', '风骏5', '2462', '0');
INSERT INTO `tbl_car_system` VALUES ('100', '铃木', '53', '长安铃木', '35', '天语 SX4', '529', '0');
INSERT INTO `tbl_car_system` VALUES ('1000', '五十铃', '167', '江西五十铃', '394', 'mu-X牧游侠', '3576', '0');
INSERT INTO `tbl_car_system` VALUES ('1001', '五十铃', '167', '江西五十铃', '394', '瑞迈', '3935', '0');
INSERT INTO `tbl_car_system` VALUES ('1002', '长安轻型车', '294', '长安轻型车', '397', '神骐T20', '2923', '0');
INSERT INTO `tbl_car_system` VALUES ('1003', '长安轻型车', '294', '长安轻型车', '397', '睿行M80', '3227', '0');
INSERT INTO `tbl_car_system` VALUES ('1004', '长安轻型车', '294', '长安轻型车', '397', '睿行M90', '4011', '0');
INSERT INTO `tbl_car_system` VALUES ('1005', '长安轻型车', '294', '长安轻型车', '397', '神骐F30', '4012', '0');
INSERT INTO `tbl_car_system` VALUES ('1006', '长安轻型车', '294', '长安轻型车', '397', '睿行S50', '4132', '0');
INSERT INTO `tbl_car_system` VALUES ('1007', '长安轻型车', '294', '长安轻型车', '397', '睿行S50T', '4292', '0');
INSERT INTO `tbl_car_system` VALUES ('1008', '长安轻型车', '294', '长安轻型车', '397', '睿行M70', '4372', '0');
INSERT INTO `tbl_car_system` VALUES ('1009', '凯翼', '214', '凯翼汽车', '398', '凯翼C3R', '3581', '0');
INSERT INTO `tbl_car_system` VALUES ('101', '铃木', '53', '长安铃木', '35', '奥拓', '872', '0');
INSERT INTO `tbl_car_system` VALUES ('1010', '凯翼', '214', '凯翼汽车', '398', '凯翼C3', '3586', '0');
INSERT INTO `tbl_car_system` VALUES ('1011', '凯翼', '214', '凯翼汽车', '398', '凯翼V3', '3971', '0');
INSERT INTO `tbl_car_system` VALUES ('1012', '凯翼', '214', '凯翼汽车', '398', '凯翼X3', '3983', '0');
INSERT INTO `tbl_car_system` VALUES ('1013', '凯翼', '214', '凯翼汽车', '398', '凯翼X5', '4095', '0');
INSERT INTO `tbl_car_system` VALUES ('1014', '凯翼', '214', '凯翼汽车', '398', '凯翼E3', '4474', '0');
INSERT INTO `tbl_car_system` VALUES ('1015', '康迪全球鹰', '219', '康迪全球鹰电动汽车', '399', '全球鹰K10', '3835', '0');
INSERT INTO `tbl_car_system` VALUES ('1016', '康迪全球鹰', '219', '康迪全球鹰电动汽车', '399', '全球鹰K11', '3836', '0');
INSERT INTO `tbl_car_system` VALUES ('1017', '康迪全球鹰', '219', '康迪全球鹰电动汽车', '399', '全球鹰K17', '4160', '0');
INSERT INTO `tbl_car_system` VALUES ('1018', '康迪全球鹰', '219', '康迪全球鹰电动汽车', '399', '全球鹰K12', '4161', '0');
INSERT INTO `tbl_car_system` VALUES ('1019', '华颂', '220', '华晨华颂', '400', '华颂7', '3607', '0');
INSERT INTO `tbl_car_system` VALUES ('102', '铃木', '53', '长安铃木', '35', '启悦', '3528', '0');
INSERT INTO `tbl_car_system` VALUES ('1020', '现代', '12', '四川现代', '402', '康恩迪', '3613', '0');
INSERT INTO `tbl_car_system` VALUES ('1021', '奇瑞', '26', '奇瑞新能源', '405', '奇瑞eQ', '3648', '0');
INSERT INTO `tbl_car_system` VALUES ('1022', '奇瑞', '26', '奇瑞新能源', '405', '奇瑞eQ1', '4218', '0');
INSERT INTO `tbl_car_system` VALUES ('1023', '奇瑞', '26', '奇瑞新能源', '405', '艾瑞泽5e', '4262', '0');
INSERT INTO `tbl_car_system` VALUES ('1024', '卡升', '224', '浙江卡尔森', '406', '卡升威霆', '3655', '0');
INSERT INTO `tbl_car_system` VALUES ('1025', '卡升', '224', '浙江卡尔森', '406', '卡升C10', '3656', '0');
INSERT INTO `tbl_car_system` VALUES ('1026', '卡升', '224', '浙江卡尔森', '406', '卡升T6', '4447', '0');
INSERT INTO `tbl_car_system` VALUES ('1027', '卡升', '224', '浙江卡尔森', '406', '卡升V-Class', '4448', '0');
INSERT INTO `tbl_car_system` VALUES ('1028', '奔驰', '36', '梅赛德斯-迈巴赫', '407', '迈巴赫S级', '3665', '0');
INSERT INTO `tbl_car_system` VALUES ('1029', '金杯', '83', '华晨鑫源', '409', '海星A7', '2601', '0');
INSERT INTO `tbl_car_system` VALUES ('103', '铃木', '53', '长安铃木', '35', '维特拉', '3858', '0');
INSERT INTO `tbl_car_system` VALUES ('1030', '金杯', '83', '华晨鑫源', '409', '海星A9', '2711', '0');
INSERT INTO `tbl_car_system` VALUES ('1031', '金杯', '83', '华晨鑫源', '409', '海星T20', '2712', '0');
INSERT INTO `tbl_car_system` VALUES ('1032', '金杯', '83', '华晨鑫源', '409', '海星T22', '2837', '0');
INSERT INTO `tbl_car_system` VALUES ('1033', '金杯', '83', '华晨鑫源', '409', '小海狮X30', '3136', '0');
INSERT INTO `tbl_car_system` VALUES ('1034', '金杯', '83', '华晨鑫源', '409', '金杯T30', '3721', '0');
INSERT INTO `tbl_car_system` VALUES ('1035', '金杯', '83', '华晨鑫源', '409', '金杯T32', '3722', '0');
INSERT INTO `tbl_car_system` VALUES ('1036', '金杯', '83', '华晨鑫源', '409', '华晨金杯750', '3763', '0');
INSERT INTO `tbl_car_system` VALUES ('1037', '金杯', '83', '华晨鑫源', '409', '海狮X30L', '3955', '0');
INSERT INTO `tbl_car_system` VALUES ('1038', '金杯', '83', '华晨鑫源', '409', '金杯T50', '4311', '0');
INSERT INTO `tbl_car_system` VALUES ('1039', '金杯', '83', '华晨鑫源', '409', '金杯T52', '4312', '0');
INSERT INTO `tbl_car_system` VALUES ('104', '铃木', '53', '长安铃木', '35', '骁途', '4435', '0');
INSERT INTO `tbl_car_system` VALUES ('1040', '鑫源', '306', '华晨鑫源', '409', '好运1号', '4566', '0');
INSERT INTO `tbl_car_system` VALUES ('1041', '鑫源', '306', '华晨鑫源', '409', '鑫源X30LEV', '4567', '0');
INSERT INTO `tbl_car_system` VALUES ('1042', '鑫源', '306', '华晨鑫源', '409', '鑫源T20EV', '4568', '0');
INSERT INTO `tbl_car_system` VALUES ('1043', '雷克萨斯', '52', '雷克萨斯F', '414', '雷克萨斯RC F', '3238', '0');
INSERT INTO `tbl_car_system` VALUES ('1044', '宝沃', '231', '宝沃汽车', '415', '宝沃BX7', '3913', '0');
INSERT INTO `tbl_car_system` VALUES ('1045', '宝沃', '231', '宝沃汽车', '415', '宝沃BX5', '4046', '0');
INSERT INTO `tbl_car_system` VALUES ('1046', '御捷', '232', '御捷新能源', '416', '御捷E驰', '4508', '0');
INSERT INTO `tbl_car_system` VALUES ('1047', '御捷', '232', '御捷新能源', '416', '御捷E行', '4589', '0');
INSERT INTO `tbl_car_system` VALUES ('1048', '金杯', '83', '绵阳金杯', '417', '智尚S30', '2325', '0');
INSERT INTO `tbl_car_system` VALUES ('1049', '金杯', '83', '绵阳金杯', '417', '大力神', '2659', '0');
INSERT INTO `tbl_car_system` VALUES ('105', '雪铁龙', '72', '东风雪铁龙', '37', '爱丽舍', '98', '0');
INSERT INTO `tbl_car_system` VALUES ('1050', '金杯', '83', '绵阳金杯', '417', '金典', '2660', '0');
INSERT INTO `tbl_car_system` VALUES ('1051', '金杯', '83', '绵阳金杯', '417', '雷龙', '2665', '0');
INSERT INTO `tbl_car_system` VALUES ('1052', '金杯', '83', '绵阳金杯', '417', '金杯S70', '3515', '0');
INSERT INTO `tbl_car_system` VALUES ('1053', '金杯', '83', '绵阳金杯', '417', '西部牛仔', '3853', '0');
INSERT INTO `tbl_car_system` VALUES ('1054', '金杯', '83', '绵阳金杯', '417', '小金牛', '3868', '0');
INSERT INTO `tbl_car_system` VALUES ('1055', '金杯', '83', '绵阳金杯', '417', '智尚S35', '3898', '0');
INSERT INTO `tbl_car_system` VALUES ('1056', '金杯', '83', '绵阳金杯', '417', '大力神K5', '4076', '0');
INSERT INTO `tbl_car_system` VALUES ('1057', '斯达泰克', '238', '斯达泰克', '423', '斯达泰克-卫士', '3849', '0');
INSERT INTO `tbl_car_system` VALUES ('1058', 'LOCAL MOTORS', '241', 'LOCAL MOTORS', '426', 'RALLY FIGHTER', '3864', '0');
INSERT INTO `tbl_car_system` VALUES ('1059', '菲亚特', '11', '广汽菲克菲亚特', '427', '菲翔', '2767', '0');
INSERT INTO `tbl_car_system` VALUES ('106', '雪铁龙', '72', '东风雪铁龙', '37', '世嘉', '639', '0');
INSERT INTO `tbl_car_system` VALUES ('1060', '菲亚特', '11', '广汽菲克菲亚特', '427', '致悦', '3267', '0');
INSERT INTO `tbl_car_system` VALUES ('1061', '华凯', '245', '明君汽车', '431', '华凯皮卡', '3911', '0');
INSERT INTO `tbl_car_system` VALUES ('1062', '中兴', '74', '广汽中兴', '433', '中兴C3', '2658', '0');
INSERT INTO `tbl_car_system` VALUES ('1063', '中兴', '74', '广汽中兴', '433', '中兴GX3', '3644', '0');
INSERT INTO `tbl_car_system` VALUES ('1064', '华泰新能源', '260', '华泰新能源', '445', '华泰iEV230', '4065', '0');
INSERT INTO `tbl_car_system` VALUES ('1065', '华泰新能源', '260', '华泰新能源', '445', '华泰XEV260', '4066', '0');
INSERT INTO `tbl_car_system` VALUES ('1066', '华泰新能源', '260', '华泰新能源', '445', '华泰EV160B', '4318', '0');
INSERT INTO `tbl_car_system` VALUES ('1067', '华泰新能源', '260', '华泰新能源', '445', '华泰EV160R', '4495', '0');
INSERT INTO `tbl_car_system` VALUES ('1068', '福特', '8', '江铃福特', '447', '新世代全顺', '2524', '0');
INSERT INTO `tbl_car_system` VALUES ('1069', '福特', '8', '江铃福特', '447', '撼路者', '3518', '0');
INSERT INTO `tbl_car_system` VALUES ('107', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C5', '792', '0');
INSERT INTO `tbl_car_system` VALUES ('1070', '福特', '8', '江铃福特', '447', '途睿欧', '3814', '0');
INSERT INTO `tbl_car_system` VALUES ('1071', '福特', '8', '江铃福特', '447', '全顺', '4192', '0');
INSERT INTO `tbl_car_system` VALUES ('1072', '讴歌', '60', '广汽讴歌', '450', '讴歌CDX', '4096', '0');
INSERT INTO `tbl_car_system` VALUES ('1073', '讴歌', '60', '广汽讴歌', '450', '讴歌TLX-L', '4381', '0');
INSERT INTO `tbl_car_system` VALUES ('1074', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X7', '4130', '0');
INSERT INTO `tbl_car_system` VALUES ('1075', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X5', '4226', '0');
INSERT INTO `tbl_car_system` VALUES ('1076', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X7新能源', '4613', '0');
INSERT INTO `tbl_car_system` VALUES ('1077', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E200', '4149', '0');
INSERT INTO `tbl_car_system` VALUES ('1078', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E160', '4375', '0');
INSERT INTO `tbl_car_system` VALUES ('1079', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E200S', '4388', '0');
INSERT INTO `tbl_car_system` VALUES ('108', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C4L', '2945', '0');
INSERT INTO `tbl_car_system` VALUES ('1080', '比速汽车', '271', '比速汽车', '456', '比速T3', '4164', '0');
INSERT INTO `tbl_car_system` VALUES ('1081', '比速汽车', '271', '比速汽车', '456', '比速M3', '4173', '0');
INSERT INTO `tbl_car_system` VALUES ('1082', '比速汽车', '271', '比速汽车', '456', '比速T5', '4298', '0');
INSERT INTO `tbl_car_system` VALUES ('1083', 'ALPINA', '276', 'ALPINA', '460', 'ALPINA B4', '4212', '0');
INSERT INTO `tbl_car_system` VALUES ('1084', '领克', '279', '领克', '463', '领克01', '4221', '0');
INSERT INTO `tbl_car_system` VALUES ('1085', '蔚来', '284', '蔚来', '464', '蔚来ES8', '4427', '0');
INSERT INTO `tbl_car_system` VALUES ('1086', 'SWM斯威汽车', '269', 'SWM斯威汽车', '466', 'SWM斯威X7', '4151', '0');
INSERT INTO `tbl_car_system` VALUES ('1087', 'SWM斯威汽车', '269', 'SWM斯威汽车', '466', 'SWM斯威X3', '4336', '0');
INSERT INTO `tbl_car_system` VALUES ('1088', '启辰', '122', '东风启辰', '467', '启辰D50', '2341', '0');
INSERT INTO `tbl_car_system` VALUES ('1089', '启辰', '122', '东风启辰', '467', '启辰R50', '2867', '0');
INSERT INTO `tbl_car_system` VALUES ('109', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C3-XR', '3429', '0');
INSERT INTO `tbl_car_system` VALUES ('1090', '启辰', '122', '东风启辰', '467', '晨风', '2955', '0');
INSERT INTO `tbl_car_system` VALUES ('1091', '启辰', '122', '东风启辰', '467', '启辰R50X', '3226', '0');
INSERT INTO `tbl_car_system` VALUES ('1092', '启辰', '122', '东风启辰', '467', '启辰R30', '3475', '0');
INSERT INTO `tbl_car_system` VALUES ('1093', '启辰', '122', '东风启辰', '467', '启辰T70', '3618', '0');
INSERT INTO `tbl_car_system` VALUES ('1094', '启辰', '122', '东风启辰', '467', '启辰T70X', '3904', '0');
INSERT INTO `tbl_car_system` VALUES ('1095', '启辰', '122', '东风启辰', '467', '启辰T90', '4115', '0');
INSERT INTO `tbl_car_system` VALUES ('1096', '启辰', '122', '东风启辰', '467', '启辰M50V', '4315', '0');
INSERT INTO `tbl_car_system` VALUES ('1097', '启辰', '122', '东风启辰', '467', '启辰D60', '4490', '0');
INSERT INTO `tbl_car_system` VALUES ('1098', '云度', '286', '云度新能源', '469', '云度π1', '4320', '0');
INSERT INTO `tbl_car_system` VALUES ('1099', 'Lorinser', '118', '罗伦士', '472', 'Sprinter LS500', '4378', '0');
INSERT INTO `tbl_car_system` VALUES ('11', '哈弗', '181', '长城汽车', '4', '哈弗H2', '2615', '0');
INSERT INTO `tbl_car_system` VALUES ('110', '雪铁龙', '72', '东风雪铁龙', '37', 'C4世嘉', '3873', '0');
INSERT INTO `tbl_car_system` VALUES ('1100', 'Lorinser', '118', '罗伦士', '472', 'Metris MS500', '4379', '0');
INSERT INTO `tbl_car_system` VALUES ('1101', 'Lorinser', '118', '罗伦士', '472', 'Lorinser VS550', '4464', '0');
INSERT INTO `tbl_car_system` VALUES ('1102', 'Lorinser', '118', '罗伦士', '472', 'Lorinser GS500', '4600', '0');
INSERT INTO `tbl_car_system` VALUES ('1103', '瑞驰新能源', '296', '瑞驰新能源', '479', '瑞驰新能源EC35', '4479', '0');
INSERT INTO `tbl_car_system` VALUES ('1104', '瑞驰新能源', '296', '瑞驰新能源', '479', '瑞驰新能源EK05', '4602', '0');
INSERT INTO `tbl_car_system` VALUES ('1105', '君马汽车', '297', '君马汽车', '480', '君马S70', '4519', '0');
INSERT INTO `tbl_car_system` VALUES ('1106', '宇通客车', '298', '宇通客车', '481', '宇通T7', '4484', '0');
INSERT INTO `tbl_car_system` VALUES ('1107', '北汽道达', '301', '北汽瑞丽', '482', '道达V8', '4511', '0');
INSERT INTO `tbl_car_system` VALUES ('1108', '裕路', '307', '裕路汽车', '486', '裕路EV2', '4574', '0');
INSERT INTO `tbl_car_system` VALUES ('1109', '电咖', '280', '电咖汽车', '488', '电咖·EV10', '4238', '0');
INSERT INTO `tbl_car_system` VALUES ('111', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C6', '4043', '0');
INSERT INTO `tbl_car_system` VALUES ('1110', '国金汽车', '304', '陕西通家', '490', '国金GM3', '4556', '0');
INSERT INTO `tbl_car_system` VALUES ('1111', '广汽新能源', '313', '广汽新能源', '492', '传祺GA3S PHEV', '4255', '0');
INSERT INTO `tbl_car_system` VALUES ('1112', '广汽新能源', '313', '广汽新能源', '492', '传祺GS4新能源', '4256', '0');
INSERT INTO `tbl_car_system` VALUES ('1113', '广汽新能源', '313', '广汽新能源', '492', '传祺GE3', '4291', '0');
INSERT INTO `tbl_car_system` VALUES ('1114', '', '', '', '', '', '', '0');
INSERT INTO `tbl_car_system` VALUES ('1115', '', '', '', '', '', '', '0');
INSERT INTO `tbl_car_system` VALUES ('1116', '', '', '', '', '', '', '0');
INSERT INTO `tbl_car_system` VALUES ('1117', '', '', '', '', '', '', '0');
INSERT INTO `tbl_car_system` VALUES ('1118', '', '', '', '', '', '', '0');
INSERT INTO `tbl_car_system` VALUES ('112', '雪铁龙', '72', '东风雪铁龙', '37', '天逸 C5 AIRCROSS', '4370', '0');
INSERT INTO `tbl_car_system` VALUES ('113', '标致', '13', '东风标致', '38', '标致308', '877', '0');
INSERT INTO `tbl_car_system` VALUES ('114', '标致', '13', '东风标致', '38', '标致408', '987', '0');
INSERT INTO `tbl_car_system` VALUES ('115', '标致', '13', '东风标致', '38', '标致3008', '2619', '0');
INSERT INTO `tbl_car_system` VALUES ('116', '标致', '13', '东风标致', '38', '标致301', '3068', '0');
INSERT INTO `tbl_car_system` VALUES ('117', '标致', '13', '东风标致', '38', '标致2008', '3234', '0');
INSERT INTO `tbl_car_system` VALUES ('118', '标致', '13', '东风标致', '38', '标致308S', '3632', '0');
INSERT INTO `tbl_car_system` VALUES ('119', '标致', '13', '东风标致', '38', '标致4008', '4167', '0');
INSERT INTO `tbl_car_system` VALUES ('12', '哈弗', '181', '长城汽车', '4', '哈弗H7', '3074', '0');
INSERT INTO `tbl_car_system` VALUES ('120', '标致', '13', '东风标致', '38', '标致5008', '4271', '0');
INSERT INTO `tbl_car_system` VALUES ('121', '一汽', '110', '天津一汽', '39', '夏利N5', '878', '0');
INSERT INTO `tbl_car_system` VALUES ('122', '一汽', '110', '天津一汽', '39', '威志V5', '2716', '0');
INSERT INTO `tbl_car_system` VALUES ('123', '一汽', '110', '天津一汽', '39', '夏利N7', '2781', '0');
INSERT INTO `tbl_car_system` VALUES ('124', '一汽', '110', '天津一汽', '39', '骏派D60', '3081', '0');
INSERT INTO `tbl_car_system` VALUES ('125', '一汽', '110', '天津一汽', '39', '骏派A70', '3979', '0');
INSERT INTO `tbl_car_system` VALUES ('126', '一汽', '110', '天津一汽', '39', '骏派A70E', '4415', '0');
INSERT INTO `tbl_car_system` VALUES ('127', '丰田', '3', '一汽丰田', '40', '兰德酷路泽', '45', '0');
INSERT INTO `tbl_car_system` VALUES ('128', '丰田', '3', '一汽丰田', '40', '普拉多', '46', '0');
INSERT INTO `tbl_car_system` VALUES ('129', '丰田', '3', '一汽丰田', '40', '威驰', '111', '0');
INSERT INTO `tbl_car_system` VALUES ('13', '长城', '77', '长城汽车', '4', '风骏6', '3101', '0');
INSERT INTO `tbl_car_system` VALUES ('130', '丰田', '3', '一汽丰田', '40', '普锐斯', '371', '0');
INSERT INTO `tbl_car_system` VALUES ('131', '丰田', '3', '一汽丰田', '40', '锐志', '375', '0');
INSERT INTO `tbl_car_system` VALUES ('132', '丰田', '3', '一汽丰田', '40', '卡罗拉', '526', '0');
INSERT INTO `tbl_car_system` VALUES ('133', '丰田', '3', '一汽丰田', '40', 'RAV4荣放', '770', '0');
INSERT INTO `tbl_car_system` VALUES ('134', '丰田', '3', '一汽丰田', '40', '皇冠', '882', '0');
INSERT INTO `tbl_car_system` VALUES ('135', '丰田', '3', '一汽丰田', '40', '柯斯达', '2527', '0');
INSERT INTO `tbl_car_system` VALUES ('136', '丰田', '3', '一汽丰田', '40', '威驰FS', '4260', '0');
INSERT INTO `tbl_car_system` VALUES ('137', '福特', '8', '长安福特', '43', '蒙迪欧', '117', '0');
INSERT INTO `tbl_car_system` VALUES ('138', '福特', '8', '长安福特', '43', '福克斯', '364', '0');
INSERT INTO `tbl_car_system` VALUES ('139', '福特', '8', '长安福特', '43', '翼虎', '2863', '0');
INSERT INTO `tbl_car_system` VALUES ('14', '哈弗', '181', '长城汽车', '4', '哈弗H9', '3298', '0');
INSERT INTO `tbl_car_system` VALUES ('140', '福特', '8', '长安福特', '43', '翼搏', '2871', '0');
INSERT INTO `tbl_car_system` VALUES ('141', '福特', '8', '长安福特', '43', '福睿斯', '3347', '0');
INSERT INTO `tbl_car_system` VALUES ('142', '福特', '8', '长安福特', '43', '锐界', '3615', '0');
INSERT INTO `tbl_car_system` VALUES ('143', '福特', '8', '长安福特', '43', '金牛座', '3693', '0');
INSERT INTO `tbl_car_system` VALUES ('144', '凯迪拉克', '47', '凯迪拉克(进口)', '44', '凯雷德ESCALADE', '462', '0');
INSERT INTO `tbl_car_system` VALUES ('145', '奔驰', '36', '奔驰(进口)', '47', '奔驰A级', '52', '0');
INSERT INTO `tbl_car_system` VALUES ('146', '奔驰', '36', '奔驰(进口)', '47', '奔驰C级(进口)', '56', '0');
INSERT INTO `tbl_car_system` VALUES ('147', '奔驰', '36', '奔驰(进口)', '47', '奔驰S级', '59', '0');
INSERT INTO `tbl_car_system` VALUES ('148', '奔驰', '36', '奔驰(进口)', '47', '奔驰G级', '60', '0');
INSERT INTO `tbl_car_system` VALUES ('149', '奔驰', '36', '奔驰(进口)', '47', '奔驰SL级', '237', '0');
INSERT INTO `tbl_car_system` VALUES ('15', '哈弗', '181', '长城汽车', '4', '哈弗H1', '3454', '0');
INSERT INTO `tbl_car_system` VALUES ('150', '奔驰', '36', '奔驰(进口)', '47', '奔驰CLS级', '365', '0');
INSERT INTO `tbl_car_system` VALUES ('151', '奔驰', '36', '奔驰(进口)', '47', '奔驰B级', '398', '0');
INSERT INTO `tbl_car_system` VALUES ('152', '奔驰', '36', '奔驰(进口)', '47', '奔驰E级(进口)', '450', '0');
INSERT INTO `tbl_car_system` VALUES ('153', '奔驰', '36', '奔驰(进口)', '47', '奔驰R级', '469', '0');
INSERT INTO `tbl_car_system` VALUES ('154', '奔驰', '36', '奔驰(进口)', '47', '奔驰CLA级', '2966', '0');
INSERT INTO `tbl_car_system` VALUES ('155', '奔驰', '36', '奔驰(进口)', '47', '奔驰SLC', '3278', '0');
INSERT INTO `tbl_car_system` VALUES ('156', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLC(进口)', '3339', '0');
INSERT INTO `tbl_car_system` VALUES ('157', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLE', '3683', '0');
INSERT INTO `tbl_car_system` VALUES ('158', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLS', '3688', '0');
INSERT INTO `tbl_car_system` VALUES ('159', '奔驰', '36', '奔驰(进口)', '47', '奔驰S级新能源', '4344', '0');
INSERT INTO `tbl_car_system` VALUES ('16', '哈弗', '181', '长城汽车', '4', '哈弗H6 Coupe', '3481', '0');
INSERT INTO `tbl_car_system` VALUES ('160', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLE新能源', '4346', '0');
INSERT INTO `tbl_car_system` VALUES ('161', '路虎', '49', '路虎(进口)', '49', '揽胜', '69', '0');
INSERT INTO `tbl_car_system` VALUES ('162', '路虎', '49', '路虎(进口)', '49', '揽胜极光(进口)', '754', '0');
INSERT INTO `tbl_car_system` VALUES ('163', '路虎', '49', '路虎(进口)', '49', '发现', '802', '0');
INSERT INTO `tbl_car_system` VALUES ('164', '路虎', '49', '路虎(进口)', '49', '揽胜运动版', '850', '0');
INSERT INTO `tbl_car_system` VALUES ('165', '路虎', '49', '路虎(进口)', '49', '揽胜星脉', '4316', '0');
INSERT INTO `tbl_car_system` VALUES ('166', '路虎', '49', '路虎(进口)', '49', '揽胜运动版新能源', '4569', '0');
INSERT INTO `tbl_car_system` VALUES ('167', '大众', '1', '大众(进口)', '50', '途锐', '82', '0');
INSERT INTO `tbl_car_system` VALUES ('168', '大众', '1', '大众(进口)', '50', '夏朗', '86', '0');
INSERT INTO `tbl_car_system` VALUES ('169', '大众', '1', '大众(进口)', '50', '高尔夫(进口)', '372', '0');
INSERT INTO `tbl_car_system` VALUES ('17', '哈弗', '181', '长城汽车', '4', '哈弗H2s', '4168', '0');
INSERT INTO `tbl_car_system` VALUES ('170', '大众', '1', '大众(进口)', '50', 'Tiguan', '557', '0');
INSERT INTO `tbl_car_system` VALUES ('171', '大众', '1', '大众(进口)', '50', '迈特威', '631', '0');
INSERT INTO `tbl_car_system` VALUES ('172', '大众', '1', '大众(进口)', '50', '尚酷', '669', '0');
INSERT INTO `tbl_car_system` VALUES ('173', '大众', '1', '大众(进口)', '50', '凯路威', '3416', '0');
INSERT INTO `tbl_car_system` VALUES ('174', '大众', '1', '大众(进口)', '50', '蔚揽', '3999', '0');
INSERT INTO `tbl_car_system` VALUES ('175', '大众', '1', '大众(进口)', '50', '高尔夫新能源(进口)', '4355', '0');
INSERT INTO `tbl_car_system` VALUES ('176', '东南', '81', '东南汽车', '51', 'V3菱悦', '606', '0');
INSERT INTO `tbl_car_system` VALUES ('177', '三菱', '68', '东南汽车', '51', '翼神', '873', '0');
INSERT INTO `tbl_car_system` VALUES ('178', '东南', '81', '东南汽车', '51', 'V5菱致', '2769', '0');
INSERT INTO `tbl_car_system` VALUES ('179', '东南', '81', '东南汽车', '51', 'V6菱仕', '2776', '0');
INSERT INTO `tbl_car_system` VALUES ('18', 'WEY', '283', '长城汽车', '4', 'WEY VV7', '4252', '0');
INSERT INTO `tbl_car_system` VALUES ('180', '东南', '81', '东南汽车', '51', '东南DX7', '3634', '0');
INSERT INTO `tbl_car_system` VALUES ('181', '东南', '81', '东南汽车', '51', '东南DX3', '4086', '0');
INSERT INTO `tbl_car_system` VALUES ('182', '中华', '22', '华晨中华', '53', '中华V5', '2294', '0');
INSERT INTO `tbl_car_system` VALUES ('183', '中华', '22', '华晨中华', '53', '中华H530', '2323', '0');
INSERT INTO `tbl_car_system` VALUES ('184', '中华', '22', '华晨中华', '53', '中华H230', '2770', '0');
INSERT INTO `tbl_car_system` VALUES ('185', '中华', '22', '华晨中华', '53', '中华H330', '2998', '0');
INSERT INTO `tbl_car_system` VALUES ('186', '中华', '22', '华晨中华', '53', '中华H220', '2999', '0');
INSERT INTO `tbl_car_system` VALUES ('187', '中华', '22', '华晨中华', '53', '中华豚', '3289', '0');
INSERT INTO `tbl_car_system` VALUES ('188', '中华', '22', '华晨中华', '53', '中华V3', '3530', '0');
INSERT INTO `tbl_car_system` VALUES ('189', '中华', '22', '华晨中华', '53', '中华H3', '3878', '0');
INSERT INTO `tbl_car_system` VALUES ('19', 'WEY', '283', '长城汽车', '4', 'WEY VV5', '4253', '0');
INSERT INTO `tbl_car_system` VALUES ('190', '中华', '22', '华晨中华', '53', '中华H230EV', '4309', '0');
INSERT INTO `tbl_car_system` VALUES ('191', '中华', '22', '华晨中华', '53', '中华V6', '4498', '0');
INSERT INTO `tbl_car_system` VALUES ('192', '吉利汽车', '25', '吉利汽车', '54', '金刚', '447', '0');
INSERT INTO `tbl_car_system` VALUES ('193', '吉利汽车', '25', '吉利汽车', '54', '远景', '474', '0');
INSERT INTO `tbl_car_system` VALUES ('194', '吉利汽车', '25', '吉利汽车', '54', '帝豪GS', '3465', '0');
INSERT INTO `tbl_car_system` VALUES ('195', '吉利汽车', '25', '吉利汽车', '54', '帝豪', '3556', '0');
INSERT INTO `tbl_car_system` VALUES ('196', '吉利汽车', '25', '吉利汽车', '54', '博瑞', '3589', '0');
INSERT INTO `tbl_car_system` VALUES ('197', '吉利汽车', '25', '吉利汽车', '54', '博越', '3788', '0');
INSERT INTO `tbl_car_system` VALUES ('198', '吉利汽车', '25', '吉利汽车', '54', '远景SUV', '4133', '0');
INSERT INTO `tbl_car_system` VALUES ('199', '吉利汽车', '25', '吉利汽车', '54', '帝豪GL', '4139', '0');
INSERT INTO `tbl_car_system` VALUES ('2', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'GranTurismo', '551', '0');
INSERT INTO `tbl_car_system` VALUES ('20', '长城', '77', '长城汽车', '4', '长城C30新能源', '4341', '0');
INSERT INTO `tbl_car_system` VALUES ('200', '吉利汽车', '25', '吉利汽车', '54', '远景X1', '4293', '0');
INSERT INTO `tbl_car_system` VALUES ('201', '吉利汽车', '25', '吉利汽车', '54', '帝豪新能源', '4342', '0');
INSERT INTO `tbl_car_system` VALUES ('202', '吉利汽车', '25', '吉利汽车', '54', '远景X3', '4481', '0');
INSERT INTO `tbl_car_system` VALUES ('203', '吉利汽车', '25', '吉利汽车', '54', '远景S1', '4491', '0');
INSERT INTO `tbl_car_system` VALUES ('204', '林肯', '51', '林肯', '56', '领航员', '95', '0');
INSERT INTO `tbl_car_system` VALUES ('205', '林肯', '51', '林肯', '56', '林肯MKX', '758', '0');
INSERT INTO `tbl_car_system` VALUES ('206', '林肯', '51', '林肯', '56', '林肯MKZ', '793', '0');
INSERT INTO `tbl_car_system` VALUES ('207', '林肯', '51', '林肯', '56', '林肯MKC', '2991', '0');
INSERT INTO `tbl_car_system` VALUES ('208', '林肯', '51', '林肯', '56', '林肯大陆', '3731', '0');
INSERT INTO `tbl_car_system` VALUES ('209', '起亚', '62', '东风悦达起亚', '57', '福瑞迪', '813', '0');
INSERT INTO `tbl_car_system` VALUES ('21', '哈弗', '181', '长城汽车', '4', '哈弗M6', '4485', '0');
INSERT INTO `tbl_car_system` VALUES ('210', '起亚', '62', '东风悦达起亚', '57', '智跑', '2137', '0');
INSERT INTO `tbl_car_system` VALUES ('211', '起亚', '62', '东风悦达起亚', '57', '起亚K5', '2246', '0');
INSERT INTO `tbl_car_system` VALUES ('212', '起亚', '62', '东风悦达起亚', '57', '起亚K2', '2319', '0');
INSERT INTO `tbl_car_system` VALUES ('213', '起亚', '62', '东风悦达起亚', '57', '起亚K3', '2886', '0');
INSERT INTO `tbl_car_system` VALUES ('214', '起亚', '62', '东风悦达起亚', '57', '起亚K4', '3286', '0');
INSERT INTO `tbl_car_system` VALUES ('215', '起亚', '62', '东风悦达起亚', '57', '起亚KX3', '3664', '0');
INSERT INTO `tbl_car_system` VALUES ('216', '起亚', '62', '东风悦达起亚', '57', '起亚KX5', '3954', '0');
INSERT INTO `tbl_car_system` VALUES ('217', '华骐', '184', '东风悦达起亚', '57', '华骐300E', '4170', '0');
INSERT INTO `tbl_car_system` VALUES ('218', '起亚', '62', '东风悦达起亚', '57', '起亚KX7', '4200', '0');
INSERT INTO `tbl_car_system` VALUES ('219', '起亚', '62', '东风悦达起亚', '57', '焕驰', '4387', '0');
INSERT INTO `tbl_car_system` VALUES ('22', '大众', '1', '一汽-大众', '8', '捷达', '16', '0');
INSERT INTO `tbl_car_system` VALUES ('220', '起亚', '62', '东风悦达起亚', '57', 'KX CROSS', '4505', '0');
INSERT INTO `tbl_car_system` VALUES ('221', '起亚', '62', '东风悦达起亚', '57', '凯绅', '4523', '0');
INSERT INTO `tbl_car_system` VALUES ('222', '大众', '1', '上汽大众', '58', 'POLO', '145', '0');
INSERT INTO `tbl_car_system` VALUES ('223', '大众', '1', '上汽大众', '58', '途安', '333', '0');
INSERT INTO `tbl_car_system` VALUES ('224', '大众', '1', '上汽大众', '58', '帕萨特', '528', '0');
INSERT INTO `tbl_car_system` VALUES ('225', '大众', '1', '上汽大众', '58', '朗逸', '614', '0');
INSERT INTO `tbl_car_system` VALUES ('226', '大众', '1', '上汽大众', '58', '途观', '874', '0');
INSERT INTO `tbl_car_system` VALUES ('227', '大众', '1', '上汽大众', '58', '桑塔纳', '2922', '0');
INSERT INTO `tbl_car_system` VALUES ('228', '大众', '1', '上汽大众', '58', '朗行', '3103', '0');
INSERT INTO `tbl_car_system` VALUES ('229', '大众', '1', '上汽大众', '58', '朗境', '3197', '0');
INSERT INTO `tbl_car_system` VALUES ('23', '大众', '1', '一汽-大众', '8', '速腾', '442', '0');
INSERT INTO `tbl_car_system` VALUES ('230', '大众', '1', '上汽大众', '58', '凌渡', '3457', '0');
INSERT INTO `tbl_car_system` VALUES ('231', '大众', '1', '上汽大众', '58', '辉昂', '4045', '0');
INSERT INTO `tbl_car_system` VALUES ('232', '大众', '1', '上汽大众', '58', '途昂', '4232', '0');
INSERT INTO `tbl_car_system` VALUES ('233', '大众', '1', '上汽大众', '58', '途观L', '4274', '0');
INSERT INTO `tbl_car_system` VALUES ('234', '五菱汽车', '114', '上汽通用五菱', '59', '五菱宏光', '2139', '0');
INSERT INTO `tbl_car_system` VALUES ('235', '宝骏', '120', '上汽通用五菱', '59', '宝骏630', '2236', '0');
INSERT INTO `tbl_car_system` VALUES ('236', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光', '2451', '0');
INSERT INTO `tbl_car_system` VALUES ('237', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光', '2456', '0');
INSERT INTO `tbl_car_system` VALUES ('238', '五菱汽车', '114', '上汽通用五菱', '59', 'PN货车', '2506', '0');
INSERT INTO `tbl_car_system` VALUES ('239', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光小卡', '2855', '0');
INSERT INTO `tbl_car_system` VALUES ('24', '大众', '1', '一汽-大众', '8', '迈腾', '496', '0');
INSERT INTO `tbl_car_system` VALUES ('240', '宝骏', '120', '上汽通用五菱', '59', '宝骏610', '3343', '0');
INSERT INTO `tbl_car_system` VALUES ('241', '宝骏', '120', '上汽通用五菱', '59', '宝骏730', '3412', '0');
INSERT INTO `tbl_car_system` VALUES ('242', '五菱汽车', '114', '上汽通用五菱', '59', '五菱征程', '3570', '0');
INSERT INTO `tbl_car_system` VALUES ('243', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光V', '3657', '0');
INSERT INTO `tbl_car_system` VALUES ('244', '宝骏', '120', '上汽通用五菱', '59', '宝骏560', '3677', '0');
INSERT INTO `tbl_car_system` VALUES ('245', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光小卡', '3946', '0');
INSERT INTO `tbl_car_system` VALUES ('246', '宝骏', '120', '上汽通用五菱', '59', '宝骏E100', '3993', '0');
INSERT INTO `tbl_car_system` VALUES ('247', '宝骏', '120', '上汽通用五菱', '59', '宝骏310', '4077', '0');
INSERT INTO `tbl_car_system` VALUES ('248', '宝骏', '120', '上汽通用五菱', '59', '宝骏510', '4166', '0');
INSERT INTO `tbl_car_system` VALUES ('249', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光V', '4270', '0');
INSERT INTO `tbl_car_system` VALUES ('25', '大众', '1', '一汽-大众', '8', '宝来', '633', '0');
INSERT INTO `tbl_car_system` VALUES ('250', '宝骏', '120', '上汽通用五菱', '59', '宝骏310W', '4392', '0');
INSERT INTO `tbl_car_system` VALUES ('251', '五菱汽车', '114', '上汽通用五菱', '59', '五菱宏光S3', '4408', '0');
INSERT INTO `tbl_car_system` VALUES ('252', '福特', '8', '福特(进口)', '61', 'Mustang', '102', '0');
INSERT INTO `tbl_car_system` VALUES ('253', '福特', '8', '福特(进口)', '61', '福克斯(进口)', '704', '0');
INSERT INTO `tbl_car_system` VALUES ('254', '福特', '8', '福特(进口)', '61', '探险者', '2024', '0');
INSERT INTO `tbl_car_system` VALUES ('255', '福特', '8', '福特(进口)', '61', '福特F-150', '2353', '0');
INSERT INTO `tbl_car_system` VALUES ('256', '丰田', '3', '丰田(进口)', '63', '普瑞维亚', '107', '0');
INSERT INTO `tbl_car_system` VALUES ('257', '丰田', '3', '丰田(进口)', '63', '埃尔法', '2107', '0');
INSERT INTO `tbl_car_system` VALUES ('258', '丰田', '3', '丰田(进口)', '63', '丰田86', '2574', '0');
INSERT INTO `tbl_car_system` VALUES ('259', '丰田', '3', '丰田(进口)', '63', 'HIACE', '2607', '0');
INSERT INTO `tbl_car_system` VALUES ('26', '大众', '1', '一汽-大众', '8', '高尔夫', '871', '0');
INSERT INTO `tbl_car_system` VALUES ('260', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯GX', '112', '0');
INSERT INTO `tbl_car_system` VALUES ('261', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯IS', '201', '0');
INSERT INTO `tbl_car_system` VALUES ('262', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯GS', '261', '0');
INSERT INTO `tbl_car_system` VALUES ('263', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LS', '341', '0');
INSERT INTO `tbl_car_system` VALUES ('264', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LX', '352', '0');
INSERT INTO `tbl_car_system` VALUES ('265', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯ES', '403', '0');
INSERT INTO `tbl_car_system` VALUES ('266', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯CT', '2063', '0');
INSERT INTO `tbl_car_system` VALUES ('267', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LC', '2623', '0');
INSERT INTO `tbl_car_system` VALUES ('268', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯NX', '3442', '0');
INSERT INTO `tbl_car_system` VALUES ('269', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯RC', '3758', '0');
INSERT INTO `tbl_car_system` VALUES ('27', '大众', '1', '一汽-大众', '8', '一汽-大众CC', '905', '0');
INSERT INTO `tbl_car_system` VALUES ('270', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯RX', '3934', '0');
INSERT INTO `tbl_car_system` VALUES ('271', '克莱斯勒', '9', '克莱斯勒(进口)', '69', '克莱斯勒300C(进口)', '342', '0');
INSERT INTO `tbl_car_system` VALUES ('272', '克莱斯勒', '9', '克莱斯勒(进口)', '69', '大捷龙(进口)', '2207', '0');
INSERT INTO `tbl_car_system` VALUES ('273', 'Jeep', '46', 'Jeep(进口)', '71', '牧马人', '121', '0');
INSERT INTO `tbl_car_system` VALUES ('274', 'Jeep', '46', 'Jeep(进口)', '71', '大切诺基(进口)', '521', '0');
INSERT INTO `tbl_car_system` VALUES ('275', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q50', '2992', '0');
INSERT INTO `tbl_car_system` VALUES ('276', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX60', '3043', '0');
INSERT INTO `tbl_car_system` VALUES ('277', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q70', '3097', '0');
INSERT INTO `tbl_car_system` VALUES ('278', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX70', '3099', '0');
INSERT INTO `tbl_car_system` VALUES ('279', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX80', '3100', '0');
INSERT INTO `tbl_car_system` VALUES ('28', '大众', '1', '一汽-大众', '8', '高尔夫·嘉旅', '3964', '0');
INSERT INTO `tbl_car_system` VALUES ('280', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q60', '3201', '0');
INSERT INTO `tbl_car_system` VALUES ('281', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪ESQ', '3535', '0');
INSERT INTO `tbl_car_system` VALUES ('282', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX30', '3652', '0');
INSERT INTO `tbl_car_system` VALUES ('283', '日产', '63', '日产(进口)', '73', '途乐', '264', '0');
INSERT INTO `tbl_car_system` VALUES ('284', '日产', '63', '日产(进口)', '73', '日产GT-R', '436', '0');
INSERT INTO `tbl_car_system` VALUES ('285', '日产', '63', '日产(进口)', '73', '贵士', '438', '0');
INSERT INTO `tbl_car_system` VALUES ('286', '日产', '63', '日产(进口)', '73', '日产370Z', '702', '0');
INSERT INTO `tbl_car_system` VALUES ('287', '日产', '63', '日产(进口)', '73', '碧莲', '2578', '0');
INSERT INTO `tbl_car_system` VALUES ('288', '现代', '12', '现代(进口)', '74', '雅科仕', '255', '0');
INSERT INTO `tbl_car_system` VALUES ('289', '现代', '12', '现代(进口)', '74', '雅尊', '446', '0');
INSERT INTO `tbl_car_system` VALUES ('29', '大众', '1', '一汽-大众', '8', '蔚领', '4204', '0');
INSERT INTO `tbl_car_system` VALUES ('290', '现代', '12', '现代(进口)', '74', 'H-1辉翼', '2117', '0');
INSERT INTO `tbl_car_system` VALUES ('291', '现代', '12', '现代(进口)', '74', 'Veloster飞思', '2256', '0');
INSERT INTO `tbl_car_system` VALUES ('292', '现代', '12', '现代(进口)', '74', '格越', '3164', '0');
INSERT INTO `tbl_car_system` VALUES ('293', '现代', '12', '现代(进口)', '74', '捷恩斯', '3453', '0');
INSERT INTO `tbl_car_system` VALUES ('294', '本田', '14', '本田(进口)', '75', '本田CR-Z', '897', '0');
INSERT INTO `tbl_car_system` VALUES ('295', '双龙', '69', '双龙汽车', '76', '主席', '141', '0');
INSERT INTO `tbl_car_system` VALUES ('296', '双龙', '69', '双龙汽车', '76', '爱腾', '455', '0');
INSERT INTO `tbl_car_system` VALUES ('297', '双龙', '69', '双龙汽车', '76', '享御', '485', '0');
INSERT INTO `tbl_car_system` VALUES ('298', '双龙', '69', '双龙汽车', '76', '路帝', '516', '0');
INSERT INTO `tbl_car_system` VALUES ('299', '双龙', '69', '双龙汽车', '76', '柯兰多', '2214', '0');
INSERT INTO `tbl_car_system` VALUES ('3', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'GranCabrio', '903', '0');
INSERT INTO `tbl_car_system` VALUES ('30', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A6L', '18', '0');
INSERT INTO `tbl_car_system` VALUES ('300', '双龙', '69', '双龙汽车', '76', '雷斯特W', '3132', '0');
INSERT INTO `tbl_car_system` VALUES ('301', '双龙', '69', '双龙汽车', '76', '途凌', '3372', '0');
INSERT INTO `tbl_car_system` VALUES ('302', '双龙', '69', '双龙汽车', '76', '蒂维拉', '3406', '0');
INSERT INTO `tbl_car_system` VALUES ('303', '法拉利', '42', '法拉利', '78', 'California T', '676', '0');
INSERT INTO `tbl_car_system` VALUES ('304', '法拉利', '42', '法拉利', '78', 'F12berlinetta', '2682', '0');
INSERT INTO `tbl_car_system` VALUES ('305', '法拉利', '42', '法拉利', '78', 'LaFerrari', '3016', '0');
INSERT INTO `tbl_car_system` VALUES ('306', '法拉利', '42', '法拉利', '78', '法拉利488', '3720', '0');
INSERT INTO `tbl_car_system` VALUES ('307', '法拉利', '42', '法拉利', '78', 'GTC4Lusso', '4027', '0');
INSERT INTO `tbl_car_system` VALUES ('308', '法拉利', '42', '法拉利', '78', 'Portofino', '4524', '0');
INSERT INTO `tbl_car_system` VALUES ('309', '奥迪', '33', '奥迪(进口)', '79', '奥迪A8', '146', '0');
INSERT INTO `tbl_car_system` VALUES ('31', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A4L', '692', '0');
INSERT INTO `tbl_car_system` VALUES ('310', '奥迪', '33', '奥迪(进口)', '79', '奥迪TT', '148', '0');
INSERT INTO `tbl_car_system` VALUES ('311', '奥迪', '33', '奥迪(进口)', '79', '奥迪A3(进口)', '370', '0');
INSERT INTO `tbl_car_system` VALUES ('312', '奥迪', '33', '奥迪(进口)', '79', '奥迪Q7', '412', '0');
INSERT INTO `tbl_car_system` VALUES ('313', '奥迪', '33', '奥迪(进口)', '79', '奥迪A4(进口)', '471', '0');
INSERT INTO `tbl_car_system` VALUES ('314', '奥迪', '33', '奥迪(进口)', '79', '奥迪A6(进口)', '472', '0');
INSERT INTO `tbl_car_system` VALUES ('315', '奥迪', '33', '奥迪(进口)', '79', '奥迪A5', '538', '0');
INSERT INTO `tbl_car_system` VALUES ('316', '奥迪', '33', '奥迪(进口)', '79', '奥迪Q5(进口)', '593', '0');
INSERT INTO `tbl_car_system` VALUES ('317', '奥迪', '33', '奥迪(进口)', '79', '奥迪A1', '650', '0');
INSERT INTO `tbl_car_system` VALUES ('318', '奥迪', '33', '奥迪(进口)', '79', '奥迪A7', '740', '0');
INSERT INTO `tbl_car_system` VALUES ('319', '奥迪', '33', '奥迪(进口)', '79', '奥迪S3', '2730', '0');
INSERT INTO `tbl_car_system` VALUES ('32', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪Q5', '812', '0');
INSERT INTO `tbl_car_system` VALUES ('320', '奥迪', '33', '奥迪(进口)', '79', '奥迪S5', '2734', '0');
INSERT INTO `tbl_car_system` VALUES ('321', '奥迪', '33', '奥迪(进口)', '79', '奥迪S6', '2736', '0');
INSERT INTO `tbl_car_system` VALUES ('322', '奥迪', '33', '奥迪(进口)', '79', '奥迪S7', '2738', '0');
INSERT INTO `tbl_car_system` VALUES ('323', '奥迪', '33', '奥迪(进口)', '79', '奥迪S8', '2739', '0');
INSERT INTO `tbl_car_system` VALUES ('324', '奥迪', '33', '奥迪(进口)', '79', '奥迪TTS', '2740', '0');
INSERT INTO `tbl_car_system` VALUES ('325', '奥迪', '33', '奥迪(进口)', '79', '奥迪SQ5', '2841', '0');
INSERT INTO `tbl_car_system` VALUES ('326', '奥迪', '33', '奥迪(进口)', '79', '奥迪A3新能源(进口)', '4325', '0');
INSERT INTO `tbl_car_system` VALUES ('327', '奥迪', '33', '奥迪(进口)', '79', '奥迪Q7新能源', '4460', '0');
INSERT INTO `tbl_car_system` VALUES ('328', '宝马', '15', '宝马(进口)', '80', '宝马7系', '153', '0');
INSERT INTO `tbl_car_system` VALUES ('329', '宝马', '15', '宝马(进口)', '80', '宝马X5', '159', '0');
INSERT INTO `tbl_car_system` VALUES ('33', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪Q3', '2951', '0');
INSERT INTO `tbl_car_system` VALUES ('330', '宝马', '15', '宝马(进口)', '80', '宝马Z4', '161', '0');
INSERT INTO `tbl_car_system` VALUES ('331', '宝马', '15', '宝马(进口)', '80', '宝马5系(进口)', '202', '0');
INSERT INTO `tbl_car_system` VALUES ('332', '宝马', '15', '宝马(进口)', '80', '宝马6系', '270', '0');
INSERT INTO `tbl_car_system` VALUES ('333', '宝马', '15', '宝马(进口)', '80', '宝马X3(进口)', '271', '0');
INSERT INTO `tbl_car_system` VALUES ('334', '宝马', '15', '宝马(进口)', '80', '宝马3系(进口)', '317', '0');
INSERT INTO `tbl_car_system` VALUES ('335', '宝马', '15', '宝马(进口)', '80', '宝马1系(进口)', '373', '0');
INSERT INTO `tbl_car_system` VALUES ('336', '宝马', '15', '宝马(进口)', '80', '宝马X6', '587', '0');
INSERT INTO `tbl_car_system` VALUES ('337', '宝马', '15', '宝马(进口)', '80', '宝马i8', '2387', '0');
INSERT INTO `tbl_car_system` VALUES ('338', '宝马', '15', '宝马(进口)', '80', '宝马i3', '2388', '0');
INSERT INTO `tbl_car_system` VALUES ('339', '宝马', '15', '宝马(进口)', '80', '宝马5系GT', '2847', '0');
INSERT INTO `tbl_car_system` VALUES ('34', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A3', '3170', '0');
INSERT INTO `tbl_car_system` VALUES ('340', '宝马', '15', '宝马(进口)', '80', '宝马3系GT', '2963', '0');
INSERT INTO `tbl_car_system` VALUES ('341', '宝马', '15', '宝马(进口)', '80', '宝马4系', '2968', '0');
INSERT INTO `tbl_car_system` VALUES ('342', '宝马', '15', '宝马(进口)', '80', '宝马X4', '3053', '0');
INSERT INTO `tbl_car_system` VALUES ('343', '宝马', '15', '宝马(进口)', '80', '宝马2系', '3230', '0');
INSERT INTO `tbl_car_system` VALUES ('344', '宝马', '15', '宝马(进口)', '80', '宝马2系多功能旅行车', '3726', '0');
INSERT INTO `tbl_car_system` VALUES ('345', '宝马', '15', '宝马(进口)', '80', '宝马7系新能源', '4345', '0');
INSERT INTO `tbl_car_system` VALUES ('346', '宝马', '15', '宝马(进口)', '80', '宝马X5新能源', '4348', '0');
INSERT INTO `tbl_car_system` VALUES ('347', '宝马', '15', '宝马(进口)', '80', '宝马6系GT', '4472', '0');
INSERT INTO `tbl_car_system` VALUES ('348', '保时捷', '40', '保时捷', '81', '保时捷911', '162', '0');
INSERT INTO `tbl_car_system` VALUES ('349', '保时捷', '40', '保时捷', '81', 'Cayenne', '172', '0');
INSERT INTO `tbl_car_system` VALUES ('35', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A6L新能源', '4526', '0');
INSERT INTO `tbl_car_system` VALUES ('350', '保时捷', '40', '保时捷', '81', 'Panamera', '703', '0');
INSERT INTO `tbl_car_system` VALUES ('351', '保时捷', '40', '保时捷', '81', 'Macan', '2838', '0');
INSERT INTO `tbl_car_system` VALUES ('352', '保时捷', '40', '保时捷', '81', '保时捷718', '4175', '0');
INSERT INTO `tbl_car_system` VALUES ('353', '保时捷', '40', '保时捷', '81', 'Panamera新能源', '4322', '0');
INSERT INTO `tbl_car_system` VALUES ('354', '保时捷', '40', '保时捷', '81', 'Cayenne新能源', '4324', '0');
INSERT INTO `tbl_car_system` VALUES ('355', '雪铁龙', '72', '雪铁龙(进口)', '82', 'C4 PICASSO', '473', '0');
INSERT INTO `tbl_car_system` VALUES ('356', '雪铁龙', '72', '雪铁龙(进口)', '82', '雪铁龙C4 Aircross', '2473', '0');
INSERT INTO `tbl_car_system` VALUES ('357', '兰博基尼', '48', '兰博基尼', '83', 'Aventador', '2277', '0');
INSERT INTO `tbl_car_system` VALUES ('358', '兰博基尼', '48', '兰博基尼', '83', 'Urus', '2775', '0');
INSERT INTO `tbl_car_system` VALUES ('359', '兰博基尼', '48', '兰博基尼', '83', 'Huracan', '3277', '0');
INSERT INTO `tbl_car_system` VALUES ('36', '奔腾', '95', '一汽奔腾', '10', '奔腾B70', '466', '0');
INSERT INTO `tbl_car_system` VALUES ('360', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃XC90', '177', '0');
INSERT INTO `tbl_car_system` VALUES ('361', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃S60', '404', '0');
INSERT INTO `tbl_car_system` VALUES ('362', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V60', '2190', '0');
INSERT INTO `tbl_car_system` VALUES ('363', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V40', '2678', '0');
INSERT INTO `tbl_car_system` VALUES ('364', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V90', '4029', '0');
INSERT INTO `tbl_car_system` VALUES ('365', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃XC90新能源', '4337', '0');
INSERT INTO `tbl_car_system` VALUES ('366', '捷豹', '44', '捷豹', '85', '捷豹XJ', '178', '0');
INSERT INTO `tbl_car_system` VALUES ('367', '捷豹', '44', '捷豹', '85', '捷豹XF', '589', '0');
INSERT INTO `tbl_car_system` VALUES ('368', '捷豹', '44', '捷豹', '85', '捷豹F-TYPE', '2903', '0');
INSERT INTO `tbl_car_system` VALUES ('369', '捷豹', '44', '捷豹', '85', '捷豹F-PACE', '3209', '0');
INSERT INTO `tbl_car_system` VALUES ('37', '奔腾', '95', '一汽奔腾', '10', '奔腾B50', '632', '0');
INSERT INTO `tbl_car_system` VALUES ('370', '捷豹', '44', '捷豹', '85', '捷豹XE', '3312', '0');
INSERT INTO `tbl_car_system` VALUES ('371', '阿尔法·罗密欧', '34', '阿尔法·罗密欧', '86', 'Giulia', '3825', '0');
INSERT INTO `tbl_car_system` VALUES ('372', '阿尔法·罗密欧', '34', '阿尔法·罗密欧', '86', 'Stelvio', '4196', '0');
INSERT INTO `tbl_car_system` VALUES ('373', '雷诺', '10', '雷诺(进口)', '89', '梅甘娜', '196', '0');
INSERT INTO `tbl_car_system` VALUES ('374', '雷诺', '10', '雷诺(进口)', '89', '风朗', '908', '0');
INSERT INTO `tbl_car_system` VALUES ('375', '雷诺', '10', '雷诺(进口)', '89', 'Espace', '2029', '0');
INSERT INTO `tbl_car_system` VALUES ('376', '雷诺', '10', '雷诺(进口)', '89', '卡缤', '2268', '0');
INSERT INTO `tbl_car_system` VALUES ('377', '日产', '63', '东风日产', '92', '阳光', '64', '0');
INSERT INTO `tbl_car_system` VALUES ('378', '日产', '63', '东风日产', '92', '骐达', '425', '0');
INSERT INTO `tbl_car_system` VALUES ('379', '日产', '63', '东风日产', '92', '轩逸', '448', '0');
INSERT INTO `tbl_car_system` VALUES ('38', '奔腾', '95', '一汽奔腾', '10', '奔腾B90', '2310', '0');
INSERT INTO `tbl_car_system` VALUES ('380', '日产', '63', '东风日产', '92', '骊威', '522', '0');
INSERT INTO `tbl_car_system` VALUES ('381', '日产', '63', '东风日产', '92', '逍客', '564', '0');
INSERT INTO `tbl_car_system` VALUES ('382', '日产', '63', '东风日产', '92', '天籁', '634', '0');
INSERT INTO `tbl_car_system` VALUES ('383', '日产', '63', '东风日产', '92', '奇骏', '656', '0');
INSERT INTO `tbl_car_system` VALUES ('384', '日产', '63', '东风日产', '92', '玛驰', '2086', '0');
INSERT INTO `tbl_car_system` VALUES ('385', '日产', '63', '东风日产', '92', '楼兰', '2381', '0');
INSERT INTO `tbl_car_system` VALUES ('386', '日产', '63', '东风日产', '92', 'LANNIA 蓝鸟', '3817', '0');
INSERT INTO `tbl_car_system` VALUES ('387', '日产', '63', '东风日产', '92', '西玛', '3957', '0');
INSERT INTO `tbl_car_system` VALUES ('388', '日产', '63', '东风日产', '92', '劲客', '4305', '0');
INSERT INTO `tbl_car_system` VALUES ('389', '别克', '38', '上汽通用别克', '93', '君威', '164', '0');
INSERT INTO `tbl_car_system` VALUES ('39', '奔腾', '95', '一汽奔腾', '10', '奔腾X80', '3000', '0');
INSERT INTO `tbl_car_system` VALUES ('390', '别克', '38', '上汽通用别克', '93', '别克GL8', '166', '0');
INSERT INTO `tbl_car_system` VALUES ('391', '别克', '38', '上汽通用别克', '93', '君越', '834', '0');
INSERT INTO `tbl_car_system` VALUES ('392', '别克', '38', '上汽通用别克', '93', '英朗', '982', '0');
INSERT INTO `tbl_car_system` VALUES ('393', '别克', '38', '上汽通用别克', '93', '昂科拉', '2896', '0');
INSERT INTO `tbl_car_system` VALUES ('394', '别克', '38', '上汽通用别克', '93', '昂科威', '3554', '0');
INSERT INTO `tbl_car_system` VALUES ('395', '别克', '38', '上汽通用别克', '93', '威朗', '3751', '0');
INSERT INTO `tbl_car_system` VALUES ('396', '别克', '38', '上汽通用别克', '93', 'VELITE 5', '4239', '0');
INSERT INTO `tbl_car_system` VALUES ('397', '别克', '38', '上汽通用别克', '93', '别克GL6', '4487', '0');
INSERT INTO `tbl_car_system` VALUES ('398', '别克', '38', '上汽通用别克', '93', '阅朗', '4552', '0');
INSERT INTO `tbl_car_system` VALUES ('399', '劳斯莱斯', '54', '劳斯莱斯', '107', '幻影', '265', '0');
INSERT INTO `tbl_car_system` VALUES ('4', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'Levante', '2428', '0');
INSERT INTO `tbl_car_system` VALUES ('40', '奔腾', '95', '一汽奔腾', '10', '奔腾B30', '3695', '0');
INSERT INTO `tbl_car_system` VALUES ('400', '劳斯莱斯', '54', '劳斯莱斯', '107', '古思特', '836', '0');
INSERT INTO `tbl_car_system` VALUES ('401', '劳斯莱斯', '54', '劳斯莱斯', '107', '魅影', '3015', '0');
INSERT INTO `tbl_car_system` VALUES ('402', '劳斯莱斯', '54', '劳斯莱斯', '107', '曜影', '3838', '0');
INSERT INTO `tbl_car_system` VALUES ('403', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '阿斯顿·马丁DB9', '266', '0');
INSERT INTO `tbl_car_system` VALUES ('404', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'V8 Vantage', '385', '0');
INSERT INTO `tbl_car_system` VALUES ('405', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'Vanquish', '386', '0');
INSERT INTO `tbl_car_system` VALUES ('406', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'V12 Vantage', '822', '0');
INSERT INTO `tbl_car_system` VALUES ('407', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '拉共达Taraf', '884', '0');
INSERT INTO `tbl_car_system` VALUES ('408', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'Rapide', '923', '0');
INSERT INTO `tbl_car_system` VALUES ('409', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '阿斯顿·马丁DB11', '3891', '0');
INSERT INTO `tbl_car_system` VALUES ('41', '奔腾', '95', '一汽奔腾', '10', '奔腾X40', '4069', '0');
INSERT INTO `tbl_car_system` VALUES ('410', '路特斯', '50', '路特斯', '110', 'Elise', '272', '0');
INSERT INTO `tbl_car_system` VALUES ('411', '路特斯', '50', '路特斯', '110', 'Evora', '681', '0');
INSERT INTO `tbl_car_system` VALUES ('412', '路特斯', '50', '路特斯', '110', 'Exige', '891', '0');
INSERT INTO `tbl_car_system` VALUES ('413', '起亚', '62', '起亚(进口)', '111', '索兰托', '281', '0');
INSERT INTO `tbl_car_system` VALUES ('414', '起亚', '62', '起亚(进口)', '111', '佳乐', '453', '0');
INSERT INTO `tbl_car_system` VALUES ('415', '起亚', '62', '起亚(进口)', '111', '霸锐', '591', '0');
INSERT INTO `tbl_car_system` VALUES ('416', '起亚', '62', '起亚(进口)', '111', '斯汀格', '2420', '0');
INSERT INTO `tbl_car_system` VALUES ('417', '起亚', '62', '起亚(进口)', '111', '起亚K9', '2681', '0');
INSERT INTO `tbl_car_system` VALUES ('418', '起亚', '62', '起亚(进口)', '111', '极睿', '3198', '0');
INSERT INTO `tbl_car_system` VALUES ('419', '起亚', '62', '起亚(进口)', '111', '嘉华(进口)', '3448', '0');
INSERT INTO `tbl_car_system` VALUES ('42', '马自达', '58', '一汽马自达', '11', '阿特兹', '3154', '0');
INSERT INTO `tbl_car_system` VALUES ('420', '斯巴鲁', '65', '斯巴鲁', '116', '森林人', '285', '0');
INSERT INTO `tbl_car_system` VALUES ('421', '斯巴鲁', '65', '斯巴鲁', '116', '傲虎', '286', '0');
INSERT INTO `tbl_car_system` VALUES ('422', '斯巴鲁', '65', '斯巴鲁', '116', '力狮', '287', '0');
INSERT INTO `tbl_car_system` VALUES ('423', '斯巴鲁', '65', '斯巴鲁', '116', '斯巴鲁XV', '2417', '0');
INSERT INTO `tbl_car_system` VALUES ('424', '斯巴鲁', '65', '斯巴鲁', '116', '斯巴鲁BRZ', '2557', '0');
INSERT INTO `tbl_car_system` VALUES ('425', '华泰', '87', '华泰汽车', '117', '圣达菲经典', '477', '0');
INSERT INTO `tbl_car_system` VALUES ('426', '华泰', '87', '华泰汽车', '117', '路盛E70', '2133', '0');
INSERT INTO `tbl_car_system` VALUES ('427', '华泰', '87', '华泰汽车', '117', '宝利格', '2144', '0');
INSERT INTO `tbl_car_system` VALUES ('428', '华泰', '87', '华泰汽车', '117', '路盛E80', '3803', '0');
INSERT INTO `tbl_car_system` VALUES ('429', '华泰', '87', '华泰汽车', '117', '圣达菲', '3896', '0');
INSERT INTO `tbl_car_system` VALUES ('43', '马自达', '58', '一汽马自达', '11', '马自达CX-4', '3968', '0');
INSERT INTO `tbl_car_system` VALUES ('430', '华泰', '87', '华泰汽车', '117', '圣达菲7', '4483', '0');
INSERT INTO `tbl_car_system` VALUES ('431', '华泰', '87', '华泰汽车', '117', '圣达菲5', '4518', '0');
INSERT INTO `tbl_car_system` VALUES ('432', '马自达', '58', '马自达(进口)', '119', '马自达MX-5', '672', '0');
INSERT INTO `tbl_car_system` VALUES ('433', '马自达', '58', '马自达(进口)', '119', '马自达CX-3', '3538', '0');
INSERT INTO `tbl_car_system` VALUES ('434', '宾利', '39', '宾利', '120', '欧陆', '305', '0');
INSERT INTO `tbl_car_system` VALUES ('435', '宾利', '39', '宾利', '120', '慕尚', '901', '0');
INSERT INTO `tbl_car_system` VALUES ('436', '宾利', '39', '宾利', '120', '添越', '2685', '0');
INSERT INTO `tbl_car_system` VALUES ('437', '宾利', '39', '宾利', '120', '飞驰', '3014', '0');
INSERT INTO `tbl_car_system` VALUES ('438', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克XTS', '2949', '0');
INSERT INTO `tbl_car_system` VALUES ('439', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克ATS-L', '3207', '0');
INSERT INTO `tbl_car_system` VALUES ('44', '海马', '86', '一汽海马', '26', '福美来', '470', '0');
INSERT INTO `tbl_car_system` VALUES ('440', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克CT6', '3802', '0');
INSERT INTO `tbl_car_system` VALUES ('441', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克XT5', '3989', '0');
INSERT INTO `tbl_car_system` VALUES ('442', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克CT6 PLUG-IN', '4334', '0');
INSERT INTO `tbl_car_system` VALUES ('443', '三菱', '68', '三菱(进口)', '128', '帕杰罗(进口)', '580', '0');
INSERT INTO `tbl_car_system` VALUES ('444', '斯柯达', '67', '斯柯达(进口)', '138', '明锐(进口)', '356', '0');
INSERT INTO `tbl_car_system` VALUES ('445', '斯柯达', '67', '斯柯达(进口)', '138', '速尊', '3269', '0');
INSERT INTO `tbl_car_system` VALUES ('446', '雪佛兰', '71', '上汽通用雪佛兰', '139', '赛欧', '163', '0');
INSERT INTO `tbl_car_system` VALUES ('447', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科鲁兹', '657', '0');
INSERT INTO `tbl_car_system` VALUES ('448', '雪佛兰', '71', '上汽通用雪佛兰', '139', '迈锐宝', '2313', '0');
INSERT INTO `tbl_car_system` VALUES ('449', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科帕奇', '2583', '0');
INSERT INTO `tbl_car_system` VALUES ('45', '海马', '86', '一汽海马', '26', '海马S7', '3075', '0');
INSERT INTO `tbl_car_system` VALUES ('450', '雪佛兰', '71', '上汽通用雪佛兰', '139', '创酷', '3335', '0');
INSERT INTO `tbl_car_system` VALUES ('451', '雪佛兰', '71', '上汽通用雪佛兰', '139', '乐风RV', '3923', '0');
INSERT INTO `tbl_car_system` VALUES ('452', '雪佛兰', '71', '上汽通用雪佛兰', '139', '迈锐宝XL', '4031', '0');
INSERT INTO `tbl_car_system` VALUES ('453', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科沃兹', '4105', '0');
INSERT INTO `tbl_car_system` VALUES ('454', '雪佛兰', '71', '上汽通用雪佛兰', '139', '探界者', '4235', '0');
INSERT INTO `tbl_car_system` VALUES ('455', '帕加尼', '61', '帕加尼', '140', 'Huayra', '2263', '0');
INSERT INTO `tbl_car_system` VALUES ('456', '猎豹汽车', '78', '猎豹汽车', '141', '黑金刚', '961', '0');
INSERT INTO `tbl_car_system` VALUES ('457', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹Q6', '3150', '0');
INSERT INTO `tbl_car_system` VALUES ('458', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS10', '3472', '0');
INSERT INTO `tbl_car_system` VALUES ('459', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS9', '4111', '0');
INSERT INTO `tbl_car_system` VALUES ('46', '海马', '86', '一汽海马', '26', '福美来MPV', '4205', '0');
INSERT INTO `tbl_car_system` VALUES ('460', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CT7', '4126', '0');
INSERT INTO `tbl_car_system` VALUES ('461', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS9新能源', '4428', '0');
INSERT INTO `tbl_car_system` VALUES ('462', '雪佛兰', '71', '雪佛兰(进口)', '142', '科迈罗', '678', '0');
INSERT INTO `tbl_car_system` VALUES ('463', '雪佛兰', '71', '雪佛兰(进口)', '142', '库罗德', '2362', '0');
INSERT INTO `tbl_car_system` VALUES ('464', '雪佛兰', '71', '雪佛兰(进口)', '142', '索罗德', '2405', '0');
INSERT INTO `tbl_car_system` VALUES ('465', 'MINI', '56', 'MINI', '143', 'MINI CLUBMAN', '749', '0');
INSERT INTO `tbl_car_system` VALUES ('466', 'MINI', '56', 'MINI', '143', 'MINI COUNTRYMAN', '750', '0');
INSERT INTO `tbl_car_system` VALUES ('467', '比亚迪', '75', '比亚迪', '146', '比亚迪F3', '407', '0');
INSERT INTO `tbl_car_system` VALUES ('468', '比亚迪', '75', '比亚迪', '146', '比亚迪F0', '579', '0');
INSERT INTO `tbl_car_system` VALUES ('469', '比亚迪', '75', '比亚迪', '146', '比亚迪M6', '798', '0');
INSERT INTO `tbl_car_system` VALUES ('47', '海马', '86', '一汽海马', '26', '普力马EV', '4339', '0');
INSERT INTO `tbl_car_system` VALUES ('470', '比亚迪', '75', '比亚迪', '146', '比亚迪e6', '831', '0');
INSERT INTO `tbl_car_system` VALUES ('471', '比亚迪', '75', '比亚迪', '146', '比亚迪S6', '2088', '0');
INSERT INTO `tbl_car_system` VALUES ('472', '比亚迪', '75', '比亚迪', '146', '秦', '2761', '0');
INSERT INTO `tbl_car_system` VALUES ('473', '比亚迪', '75', '比亚迪', '146', '速锐', '2806', '0');
INSERT INTO `tbl_car_system` VALUES ('474', '比亚迪', '75', '比亚迪', '146', '比亚迪S7', '3059', '0');
INSERT INTO `tbl_car_system` VALUES ('475', '比亚迪', '75', '比亚迪', '146', '比亚迪G5', '3283', '0');
INSERT INTO `tbl_car_system` VALUES ('476', '比亚迪', '75', '比亚迪', '146', '唐', '4802', '0');
INSERT INTO `tbl_car_system` VALUES ('477', '比亚迪', '75', '比亚迪', '146', '唐新能源', '3430', '0');
INSERT INTO `tbl_car_system` VALUES ('478', '比亚迪', '75', '比亚迪', '146', '宋', '3780', '0');
INSERT INTO `tbl_car_system` VALUES ('479', '比亚迪', '75', '比亚迪', '146', '元', '3781', '0');
INSERT INTO `tbl_car_system` VALUES ('48', '海马', '86', '一汽海马', '26', '福美来F7', '4525', '0');
INSERT INTO `tbl_car_system` VALUES ('480', '比亚迪', '75', '比亚迪', '146', '比亚迪e5', '4073', '0');
INSERT INTO `tbl_car_system` VALUES ('481', '比亚迪', '75', '比亚迪', '146', '宋MAX', '4279', '0');
INSERT INTO `tbl_car_system` VALUES ('482', '比亚迪', '75', '比亚迪', '146', '元新能源', '4353', '0');
INSERT INTO `tbl_car_system` VALUES ('483', '比亚迪', '75', '比亚迪', '146', '宋新能源', '4394', '0');
INSERT INTO `tbl_car_system` VALUES ('484', '永源', '93', '永源汽车', '150', '永源五星', '2828', '0');
INSERT INTO `tbl_car_system` VALUES ('485', '本田', '14', '东风本田', '151', '思域', '135', '0');
INSERT INTO `tbl_car_system` VALUES ('486', '本田', '14', '东风本田', '151', '本田CR-V', '314', '0');
INSERT INTO `tbl_car_system` VALUES ('487', '本田', '14', '东风本田', '151', '思铂睿', '859', '0');
INSERT INTO `tbl_car_system` VALUES ('488', '本田', '14', '东风本田', '151', '艾力绅', '2565', '0');
INSERT INTO `tbl_car_system` VALUES ('489', '思铭', '162', '东风本田', '151', '思铭', '2751', '0');
INSERT INTO `tbl_car_system` VALUES ('49', '现代', '12', '北京现代', '27', '途胜', '358', '0');
INSERT INTO `tbl_car_system` VALUES ('490', '本田', '14', '东风本田', '151', '杰德', '3104', '0');
INSERT INTO `tbl_car_system` VALUES ('491', '本田', '14', '东风本田', '151', '本田XR-V', '3582', '0');
INSERT INTO `tbl_car_system` VALUES ('492', '本田', '14', '东风本田', '151', '哥瑞', '3859', '0');
INSERT INTO `tbl_car_system` VALUES ('493', '本田', '14', '东风本田', '151', '竞瑞', '4179', '0');
INSERT INTO `tbl_car_system` VALUES ('494', '本田', '14', '东风本田', '151', '本田UR-V', '4304', '0');
INSERT INTO `tbl_car_system` VALUES ('495', '奔驰', '36', '北京奔驰', '152', '奔驰E级', '197', '0');
INSERT INTO `tbl_car_system` VALUES ('496', '奔驰', '36', '北京奔驰', '152', '奔驰C级', '588', '0');
INSERT INTO `tbl_car_system` VALUES ('497', '奔驰', '36', '北京奔驰', '152', '奔驰GLA', '3248', '0');
INSERT INTO `tbl_car_system` VALUES ('498', '奔驰', '36', '北京奔驰', '152', '奔驰GLC', '3862', '0');
INSERT INTO `tbl_car_system` VALUES ('499', '力帆汽车', '80', '力帆汽车', '154', '力帆X60', '2134', '0');
INSERT INTO `tbl_car_system` VALUES ('5', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'Ghibli', '3060', '0');
INSERT INTO `tbl_car_system` VALUES ('50', '现代', '12', '北京现代', '27', '悦动', '586', '0');
INSERT INTO `tbl_car_system` VALUES ('500', '力帆汽车', '80', '力帆汽车', '154', '兴顺', '2502', '0');
INSERT INTO `tbl_car_system` VALUES ('501', '力帆汽车', '80', '力帆汽车', '154', '丰顺', '2503', '0');
INSERT INTO `tbl_car_system` VALUES ('502', '力帆汽车', '80', '力帆汽车', '154', '福顺', '2800', '0');
INSERT INTO `tbl_car_system` VALUES ('503', '力帆汽车', '80', '力帆汽车', '154', '力帆X50', '3220', '0');
INSERT INTO `tbl_car_system` VALUES ('504', '力帆汽车', '80', '力帆汽车', '154', '力帆T11', '3228', '0');
INSERT INTO `tbl_car_system` VALUES ('505', '力帆汽车', '80', '力帆汽车', '154', '力帆T21', '3229', '0');
INSERT INTO `tbl_car_system` VALUES ('506', '力帆汽车', '80', '力帆汽车', '154', '力帆820', '3326', '0');
INSERT INTO `tbl_car_system` VALUES ('507', '力帆汽车', '80', '力帆汽车', '154', '乐途', '3631', '0');
INSERT INTO `tbl_car_system` VALUES ('508', '力帆汽车', '80', '力帆汽车', '154', '力帆X80', '3759', '0');
INSERT INTO `tbl_car_system` VALUES ('509', '力帆汽车', '80', '力帆汽车', '154', '迈威', '3987', '0');
INSERT INTO `tbl_car_system` VALUES ('51', '现代', '12', '北京现代', '27', '北京现代ix35', '1007', '0');
INSERT INTO `tbl_car_system` VALUES ('510', '力帆汽车', '80', '力帆汽车', '154', '轩朗', '4194', '0');
INSERT INTO `tbl_car_system` VALUES ('511', '力帆汽车', '80', '力帆汽车', '154', '力帆620EV', '4329', '0');
INSERT INTO `tbl_car_system` VALUES ('512', '力帆汽车', '80', '力帆汽车', '154', '力帆330EV', '4332', '0');
INSERT INTO `tbl_car_system` VALUES ('513', '丰田', '3', '广汽丰田', '155', '凯美瑞', '110', '0');
INSERT INTO `tbl_car_system` VALUES ('514', '丰田', '3', '广汽丰田', '155', '汉兰达', '771', '0');
INSERT INTO `tbl_car_system` VALUES ('515', '丰田', '3', '广汽丰田', '155', '逸致', '2237', '0');
INSERT INTO `tbl_car_system` VALUES ('516', '丰田', '3', '广汽丰田', '155', 'YARiS L 致炫', '3126', '0');
INSERT INTO `tbl_car_system` VALUES ('517', '丰田', '3', '广汽丰田', '155', '雷凌', '3462', '0');
INSERT INTO `tbl_car_system` VALUES ('518', '丰田', '3', '广汽丰田', '155', 'YARiS L 致享', '4259', '0');
INSERT INTO `tbl_car_system` VALUES ('519', '讴歌', '60', '讴歌(进口)', '157', '讴歌MDX', '524', '0');
INSERT INTO `tbl_car_system` VALUES ('52', '现代', '12', '北京现代', '27', '瑞纳', '2115', '0');
INSERT INTO `tbl_car_system` VALUES ('520', '讴歌', '60', '讴歌(进口)', '157', '讴歌ZDX', '806', '0');
INSERT INTO `tbl_car_system` VALUES ('521', '讴歌', '60', '讴歌(进口)', '157', '讴歌RDX', '888', '0');
INSERT INTO `tbl_car_system` VALUES ('522', '讴歌', '60', '讴歌(进口)', '157', '讴歌NSX', '2641', '0');
INSERT INTO `tbl_car_system` VALUES ('523', '陆风', '88', '陆风汽车', '158', '陆风X8', '833', '0');
INSERT INTO `tbl_car_system` VALUES ('524', '陆风', '88', '陆风汽车', '158', '陆风X5', '2883', '0');
INSERT INTO `tbl_car_system` VALUES ('525', '陆风', '88', '陆风汽车', '158', '陆风X7', '3413', '0');
INSERT INTO `tbl_car_system` VALUES ('526', '陆风', '88', '陆风汽车', '158', '逍遥', '4233', '0');
INSERT INTO `tbl_car_system` VALUES ('527', '陆风', '88', '陆风汽车', '158', '陆风X2', '4302', '0');
INSERT INTO `tbl_car_system` VALUES ('528', '荣威', '19', '上汽集团', '159', '荣威550', '537', '0');
INSERT INTO `tbl_car_system` VALUES ('529', '名爵', '20', '上汽集团', '159', '名爵3SW', '555', '0');
INSERT INTO `tbl_car_system` VALUES ('53', '现代', '12', '北京现代', '27', '朗动', '2764', '0');
INSERT INTO `tbl_car_system` VALUES ('530', '名爵', '20', '上汽集团', '159', '名爵6', '835', '0');
INSERT INTO `tbl_car_system` VALUES ('531', '荣威', '19', '上汽集团', '159', '荣威350', '2062', '0');
INSERT INTO `tbl_car_system` VALUES ('532', '名爵', '20', '上汽集团', '159', '名爵3', '2147', '0');
INSERT INTO `tbl_car_system` VALUES ('533', '荣威', '19', '上汽集团', '159', '荣威W5', '2297', '0');
INSERT INTO `tbl_car_system` VALUES ('534', '荣威', '19', '上汽集团', '159', '荣威950', '2743', '0');
INSERT INTO `tbl_car_system` VALUES ('535', '荣威', '19', '上汽集团', '159', '荣威e50', '2779', '0');
INSERT INTO `tbl_car_system` VALUES ('536', '名爵', '20', '上汽集团', '159', '锐腾', '3065', '0');
INSERT INTO `tbl_car_system` VALUES ('537', '名爵', '20', '上汽集团', '159', '锐行', '3547', '0');
INSERT INTO `tbl_car_system` VALUES ('538', '荣威', '19', '上汽集团', '159', '荣威360', '3857', '0');
INSERT INTO `tbl_car_system` VALUES ('539', '荣威', '19', '上汽集团', '159', '荣威e950', '3977', '0');
INSERT INTO `tbl_car_system` VALUES ('54', '现代', '12', '北京现代', '27', '全新胜达', '2927', '0');
INSERT INTO `tbl_car_system` VALUES ('540', '荣威', '19', '上汽集团', '159', '荣威e550', '3978', '0');
INSERT INTO `tbl_car_system` VALUES ('541', '荣威', '19', '上汽集团', '159', '荣威RX5', '4080', '0');
INSERT INTO `tbl_car_system` VALUES ('542', '荣威', '19', '上汽集团', '159', '荣威RX5新能源', '4240', '0');
INSERT INTO `tbl_car_system` VALUES ('543', '荣威', '19', '上汽集团', '159', '荣威i6', '4246', '0');
INSERT INTO `tbl_car_system` VALUES ('544', '名爵', '20', '上汽集团', '159', '名爵ZS', '4247', '0');
INSERT INTO `tbl_car_system` VALUES ('545', '荣威', '19', '上汽集团', '159', '荣威ei6', '4263', '0');
INSERT INTO `tbl_car_system` VALUES ('546', '荣威', '19', '上汽集团', '159', '荣威RX3', '4473', '0');
INSERT INTO `tbl_car_system` VALUES ('547', '长安', '76', '长安汽车', '160', '逸动', '2429', '0');
INSERT INTO `tbl_car_system` VALUES ('548', '长安欧尚', '163', '长安汽车', '160', '金牛星', '2505', '0');
INSERT INTO `tbl_car_system` VALUES ('549', '长安欧尚', '163', '长安汽车', '160', '欧诺', '2566', '0');
INSERT INTO `tbl_car_system` VALUES ('55', '现代', '12', '北京现代', '27', '名图', '3073', '0');
INSERT INTO `tbl_car_system` VALUES ('550', '长安', '76', '长安汽车', '160', '悦翔V3', '2567', '0');
INSERT INTO `tbl_car_system` VALUES ('551', '长安欧尚', '163', '长安汽车', '160', '长安之星', '2600', '0');
INSERT INTO `tbl_car_system` VALUES ('552', '长安欧尚', '163', '长安汽车', '160', '长安之星2', '2605', '0');
INSERT INTO `tbl_car_system` VALUES ('553', '长安', '76', '长安汽车', '160', '长安CS35', '2778', '0');
INSERT INTO `tbl_car_system` VALUES ('554', '长安', '76', '长安汽车', '160', '睿骋', '2785', '0');
INSERT INTO `tbl_car_system` VALUES ('555', '长安', '76', '长安汽车', '160', '悦翔V5', '2788', '0');
INSERT INTO `tbl_car_system` VALUES ('556', '长安欧尚', '163', '长安汽车', '160', '欧力威', '2954', '0');
INSERT INTO `tbl_car_system` VALUES ('557', '长安', '76', '长安汽车', '160', '长安CS95', '3121', '0');
INSERT INTO `tbl_car_system` VALUES ('558', '长安欧尚', '163', '长安汽车', '160', '长安星卡', '3155', '0');
INSERT INTO `tbl_car_system` VALUES ('559', '长安', '76', '长安汽车', '160', '长安CS75', '3204', '0');
INSERT INTO `tbl_car_system` VALUES ('56', '现代', '12', '北京现代', '27', '北京现代ix25', '3292', '0');
INSERT INTO `tbl_car_system` VALUES ('560', '长安', '76', '长安汽车', '160', '奔奔', '3217', '0');
INSERT INTO `tbl_car_system` VALUES ('561', '长安', '76', '长安汽车', '160', '悦翔V7', '3422', '0');
INSERT INTO `tbl_car_system` VALUES ('562', '长安欧尚', '163', '长安汽车', '160', '长安之星7', '3514', '0');
INSERT INTO `tbl_car_system` VALUES ('563', '长安欧尚', '163', '长安汽车', '160', '长安之星3', '3526', '0');
INSERT INTO `tbl_car_system` VALUES ('564', '长安欧尚', '163', '长安汽车', '160', '长安之星9', '3685', '0');
INSERT INTO `tbl_car_system` VALUES ('565', '长安欧尚', '163', '长安汽车', '160', '欧尚', '3783', '0');
INSERT INTO `tbl_car_system` VALUES ('566', '长安', '76', '长安汽车', '160', '睿骋CC', '3811', '0');
INSERT INTO `tbl_car_system` VALUES ('567', '长安欧尚', '163', '长安汽车', '160', '长安CX70', '3893', '0');
INSERT INTO `tbl_car_system` VALUES ('568', '长安', '76', '长安汽车', '160', '长安CS15', '3924', '0');
INSERT INTO `tbl_car_system` VALUES ('569', '长安', '76', '长安汽车', '160', '凌轩', '4242', '0');
INSERT INTO `tbl_car_system` VALUES ('57', '现代', '12', '北京现代', '27', '瑞奕', '3415', '0');
INSERT INTO `tbl_car_system` VALUES ('570', '长安', '76', '长安汽车', '160', '长安CS55', '4269', '0');
INSERT INTO `tbl_car_system` VALUES ('571', '长安', '76', '长安汽车', '160', '逸动新能源', '4343', '0');
INSERT INTO `tbl_car_system` VALUES ('572', '长安欧尚', '163', '长安汽车', '160', '欧尚A800', '4376', '0');
INSERT INTO `tbl_car_system` VALUES ('573', '长安', '76', '长安汽车', '160', '奔奔EV', '4380', '0');
INSERT INTO `tbl_car_system` VALUES ('574', '长安', '76', '长安汽车', '160', '长安CS15EV', '4445', '0');
INSERT INTO `tbl_car_system` VALUES ('575', '长安欧尚', '163', '长安汽车', '160', '奔奔mini-e', '4480', '0');
INSERT INTO `tbl_car_system` VALUES ('576', '长安欧尚', '163', '长安汽车', '160', '欧力威EV', '4499', '0');
INSERT INTO `tbl_car_system` VALUES ('577', '长安欧尚', '163', '长安汽车', '160', '欧尚X70A', '4517', '0');
INSERT INTO `tbl_car_system` VALUES ('578', '铃木', '53', '铃木(进口)', '161', '超级维特拉', '500', '0');
INSERT INTO `tbl_car_system` VALUES ('579', '铃木', '53', '铃木(进口)', '161', '吉姆尼(进口)', '508', '0');
INSERT INTO `tbl_car_system` VALUES ('58', '现代', '12', '北京现代', '27', '索纳塔九', '3672', '0');
INSERT INTO `tbl_car_system` VALUES ('580', '铃木', '53', '铃木(进口)', '161', '英格尼斯', '3926', '0');
INSERT INTO `tbl_car_system` VALUES ('581', '斯柯达', '67', '上汽斯柯达', '162', '晶锐', '382', '0');
INSERT INTO `tbl_car_system` VALUES ('582', '斯柯达', '67', '上汽斯柯达', '162', '明锐', '519', '0');
INSERT INTO `tbl_car_system` VALUES ('583', '斯柯达', '67', '上汽斯柯达', '162', '昕锐', '2962', '0');
INSERT INTO `tbl_car_system` VALUES ('584', '斯柯达', '67', '上汽斯柯达', '162', 'Yeti', '3013', '0');
INSERT INTO `tbl_car_system` VALUES ('585', '斯柯达', '67', '上汽斯柯达', '162', '速派', '3171', '0');
INSERT INTO `tbl_car_system` VALUES ('586', '斯柯达', '67', '上汽斯柯达', '162', '昕动', '3290', '0');
INSERT INTO `tbl_car_system` VALUES ('587', '斯柯达', '67', '上汽斯柯达', '162', '柯迪亚克', '4217', '0');
INSERT INTO `tbl_car_system` VALUES ('588', '东风风行', '165', '东风风行', '164', '菱智', '2540', '0');
INSERT INTO `tbl_car_system` VALUES ('589', '东风风行', '165', '东风风行', '164', '风行CM7', '2990', '0');
INSERT INTO `tbl_car_system` VALUES ('59', '现代', '12', '北京现代', '27', '领动', '3959', '0');
INSERT INTO `tbl_car_system` VALUES ('590', '东风风行', '165', '东风风行', '164', '景逸X5', '3128', '0');
INSERT INTO `tbl_car_system` VALUES ('591', '东风风行', '165', '东风风行', '164', '景逸S50', '3301', '0');
INSERT INTO `tbl_car_system` VALUES ('592', '东风风行', '165', '东风风行', '164', '景逸X3', '3414', '0');
INSERT INTO `tbl_car_system` VALUES ('593', '东风风行', '165', '东风风行', '164', '景逸XV', '3785', '0');
INSERT INTO `tbl_car_system` VALUES ('594', '东风风行', '165', '东风风行', '164', '风行S500', '3789', '0');
INSERT INTO `tbl_car_system` VALUES ('595', '东风风行', '165', '东风风行', '164', '风行F600', '3792', '0');
INSERT INTO `tbl_car_system` VALUES ('596', '东风风行', '165', '东风风行', '164', '风行SX6', '3970', '0');
INSERT INTO `tbl_car_system` VALUES ('597', '东风风行', '165', '东风风行', '164', '菱智M5EV', '4418', '0');
INSERT INTO `tbl_car_system` VALUES ('598', '东风风行', '165', '东风风行', '164', '景逸X6', '4423', '0');
INSERT INTO `tbl_car_system` VALUES ('599', '东风风行', '165', '东风风行', '164', '景逸S50EV', '4614', '0');
INSERT INTO `tbl_car_system` VALUES ('6', '哈弗', '181', '长城汽车', '4', '哈弗H5', '2027', '0');
INSERT INTO `tbl_car_system` VALUES ('60', '现代', '12', '北京现代', '27', '悦纳', '4107', '0');
INSERT INTO `tbl_car_system` VALUES ('600', '菲亚特', '11', '菲亚特(进口)', '165', '菲亚特500', '601', '0');
INSERT INTO `tbl_car_system` VALUES ('601', '菲亚特', '11', '菲亚特(进口)', '165', '菲跃', '2262', '0');
INSERT INTO `tbl_car_system` VALUES ('602', '一汽', '110', '一汽吉林', '166', '佳宝T57', '2465', '0');
INSERT INTO `tbl_car_system` VALUES ('603', '一汽', '110', '一汽吉林', '166', '佳宝V55', '2468', '0');
INSERT INTO `tbl_car_system` VALUES ('604', '一汽', '110', '一汽吉林', '166', '佳宝V52', '2469', '0');
INSERT INTO `tbl_car_system` VALUES ('605', '一汽', '110', '一汽吉林', '166', '佳宝T51', '2525', '0');
INSERT INTO `tbl_car_system` VALUES ('606', '一汽', '110', '一汽吉林', '166', '佳宝T50', '2526', '0');
INSERT INTO `tbl_car_system` VALUES ('607', '一汽', '110', '一汽吉林', '166', '佳宝V80', '3052', '0');
INSERT INTO `tbl_car_system` VALUES ('608', '一汽', '110', '一汽吉林', '166', '解放T80', '3459', '0');
INSERT INTO `tbl_car_system` VALUES ('609', '一汽', '110', '一汽吉林', '166', '佳宝V75', '3775', '0');
INSERT INTO `tbl_car_system` VALUES ('61', '现代', '12', '北京现代', '27', '悦纳RV', '4222', '0');
INSERT INTO `tbl_car_system` VALUES ('610', '一汽', '110', '一汽吉林', '166', '佳宝V77', '3776', '0');
INSERT INTO `tbl_car_system` VALUES ('611', '一汽', '110', '一汽吉林', '166', '森雅R7', '3824', '0');
INSERT INTO `tbl_car_system` VALUES ('612', '金杯', '83', '华晨金杯', '169', '阁瑞斯', '2537', '0');
INSERT INTO `tbl_car_system` VALUES ('613', '金杯', '83', '华晨金杯', '169', '金杯大海狮', '2545', '0');
INSERT INTO `tbl_car_system` VALUES ('614', '金杯', '83', '华晨金杯', '169', '金杯海狮', '2810', '0');
INSERT INTO `tbl_car_system` VALUES ('615', '金杯', '83', '华晨金杯', '169', '金杯快运', '4237', '0');
INSERT INTO `tbl_car_system` VALUES ('616', '金杯', '83', '华晨金杯', '169', '金杯F50', '4294', '0');
INSERT INTO `tbl_car_system` VALUES ('617', '江淮', '84', '江淮汽车', '170', '和悦', '616', '0');
INSERT INTO `tbl_car_system` VALUES ('618', '江淮', '84', '江淮汽车', '170', '瑞风', '2541', '0');
INSERT INTO `tbl_car_system` VALUES ('619', '江淮', '84', '江淮汽车', '170', '瑞风M5', '2543', '0');
INSERT INTO `tbl_car_system` VALUES ('62', '现代', '12', '北京现代', '27', '伊兰特EV', '4496', '0');
INSERT INTO `tbl_car_system` VALUES ('620', '江淮', '84', '江淮汽车', '170', '星锐', '2569', '0');
INSERT INTO `tbl_car_system` VALUES ('621', '江淮', '84', '江淮汽车', '170', '瑞铃', '2581', '0');
INSERT INTO `tbl_car_system` VALUES ('622', '江淮', '84', '江淮汽车', '170', '瑞风S5', '2752', '0');
INSERT INTO `tbl_car_system` VALUES ('623', '江淮', '84', '江淮汽车', '170', '瑞风M6', '3061', '0');
INSERT INTO `tbl_car_system` VALUES ('624', '江淮', '84', '江淮汽车', '170', '瑞风S3', '3080', '0');
INSERT INTO `tbl_car_system` VALUES ('625', '江淮', '84', '江淮汽车', '170', '瑞风M3', '3351', '0');
INSERT INTO `tbl_car_system` VALUES ('626', '江淮', '84', '江淮汽车', '170', '瑞风A60', '3363', '0');
INSERT INTO `tbl_car_system` VALUES ('627', '江淮', '84', '江淮汽车', '170', '江淮iEV', '3395', '0');
INSERT INTO `tbl_car_system` VALUES ('628', '江淮', '84', '江淮汽车', '170', '凌铃', '3490', '0');
INSERT INTO `tbl_car_system` VALUES ('629', '江淮', '84', '江淮汽车', '170', '瑞风S2', '3545', '0');
INSERT INTO `tbl_car_system` VALUES ('63', '宝马', '15', '华晨宝马', '29', '宝马5系', '65', '0');
INSERT INTO `tbl_car_system` VALUES ('630', '江淮', '84', '江淮汽车', '170', '帅铃T6', '3546', '0');
INSERT INTO `tbl_car_system` VALUES ('631', '江淮', '84', '江淮汽车', '170', '瑞风S2mini', '4087', '0');
INSERT INTO `tbl_car_system` VALUES ('632', '江淮', '84', '江淮汽车', '170', '江淮iEV6E', '4088', '0');
INSERT INTO `tbl_car_system` VALUES ('633', '江淮', '84', '江淮汽车', '170', '瑞风M4', '4090', '0');
INSERT INTO `tbl_car_system` VALUES ('634', '江淮', '84', '江淮汽车', '170', '瑞风S7', '4234', '0');
INSERT INTO `tbl_car_system` VALUES ('635', '江淮', '84', '江淮汽车', '170', '江淮iEV7S', '4444', '0');
INSERT INTO `tbl_car_system` VALUES ('636', '众泰', '94', '众泰汽车', '171', '众泰T300', '2333', '0');
INSERT INTO `tbl_car_system` VALUES ('637', '众泰', '94', '众泰汽车', '171', '众泰T600', '2334', '0');
INSERT INTO `tbl_car_system` VALUES ('638', '众泰', '94', '众泰汽车', '171', '众泰V10', '2480', '0');
INSERT INTO `tbl_car_system` VALUES ('639', '众泰', '94', '众泰汽车', '171', '众泰E200', '3529', '0');
INSERT INTO `tbl_car_system` VALUES ('64', '宝马', '15', '华晨宝马', '29', '宝马3系', '66', '0');
INSERT INTO `tbl_car_system` VALUES ('640', '众泰', '94', '众泰汽车', '171', '云100', '3575', '0');
INSERT INTO `tbl_car_system` VALUES ('641', '众泰', '94', '众泰汽车', '171', '众泰Z700', '3627', '0');
INSERT INTO `tbl_car_system` VALUES ('642', '众泰', '94', '众泰汽车', '171', '芝麻', '3779', '0');
INSERT INTO `tbl_car_system` VALUES ('643', '众泰', '94', '众泰汽车', '171', '大迈X5', '3793', '0');
INSERT INTO `tbl_car_system` VALUES ('644', '众泰', '94', '众泰汽车', '171', '众泰T700', '3852', '0');
INSERT INTO `tbl_car_system` VALUES ('645', '众泰', '94', '众泰汽车', '171', '众泰SR7', '3899', '0');
INSERT INTO `tbl_car_system` VALUES ('646', '众泰', '94', '众泰汽车', '171', '众泰SR9', '4070', '0');
INSERT INTO `tbl_car_system` VALUES ('647', '众泰', '94', '众泰汽车', '171', '大迈X7', '4092', '0');
INSERT INTO `tbl_car_system` VALUES ('648', '众泰', '94', '众泰汽车', '171', '众泰Z560', '4317', '0');
INSERT INTO `tbl_car_system` VALUES ('649', '众泰', '94', '众泰汽车', '171', '众泰Z500EV', '4327', '0');
INSERT INTO `tbl_car_system` VALUES ('65', '宝马', '15', '华晨宝马', '29', '宝马X1', '2561', '0');
INSERT INTO `tbl_car_system` VALUES ('650', '众泰', '94', '众泰汽车', '171', '众泰Z360', '4371', '0');
INSERT INTO `tbl_car_system` VALUES ('651', '众泰', '94', '众泰汽车', '171', '众泰T600 Coupe', '4385', '0');
INSERT INTO `tbl_car_system` VALUES ('652', '东风', '32', '东风汽车', '172', '御风', '2839', '0');
INSERT INTO `tbl_car_system` VALUES ('653', '东风', '32', '东风汽车', '172', '虎视', '3166', '0');
INSERT INTO `tbl_car_system` VALUES ('654', '东风', '32', '东风汽车', '172', '东风皮卡', '3716', '0');
INSERT INTO `tbl_car_system` VALUES ('655', '东风', '32', '东风汽车', '172', '御风EV', '4278', '0');
INSERT INTO `tbl_car_system` VALUES ('656', '东风', '32', '东风汽车', '172', '御风P16', '4486', '0');
INSERT INTO `tbl_car_system` VALUES ('657', '东风', '32', '东风汽车', '172', '御风S16', '4560', '0');
INSERT INTO `tbl_car_system` VALUES ('658', '日产', '63', '郑州日产', '173', '帕拉丁', '53', '0');
INSERT INTO `tbl_car_system` VALUES ('659', '东风', '32', '郑州日产', '173', '帅客', '951', '0');
INSERT INTO `tbl_car_system` VALUES ('66', '宝马', '15', '华晨宝马', '29', '宝马2系旅行车', '3941', '0');
INSERT INTO `tbl_car_system` VALUES ('660', '日产', '63', '郑州日产', '173', '日产NV200', '2113', '0');
INSERT INTO `tbl_car_system` VALUES ('661', '日产', '63', '郑州日产', '173', '日产D22', '2466', '0');
INSERT INTO `tbl_car_system` VALUES ('662', '东风', '32', '郑州日产', '173', '锐骐皮卡', '2510', '0');
INSERT INTO `tbl_car_system` VALUES ('663', '东风', '32', '郑州日产', '173', '锐骐多功能车', '2512', '0');
INSERT INTO `tbl_car_system` VALUES ('664', '日产', '63', '郑州日产', '173', '日产ZN厢式车', '2853', '0');
INSERT INTO `tbl_car_system` VALUES ('665', '东风', '32', '郑州日产', '173', '俊风', '3279', '0');
INSERT INTO `tbl_car_system` VALUES ('666', '东风风度', '187', '郑州日产', '173', '东风风度MX6', '3637', '0');
INSERT INTO `tbl_car_system` VALUES ('667', '东风风度', '187', '郑州日产', '173', '东风风度MX5', '3984', '0');
INSERT INTO `tbl_car_system` VALUES ('668', '日产', '63', '郑州日产', '173', '纳瓦拉', '4307', '0');
INSERT INTO `tbl_car_system` VALUES ('669', '道奇', '41', '道奇(进口)', '175', '酷威', '602', '0');
INSERT INTO `tbl_car_system` VALUES ('67', '之诺', '182', '华晨宝马', '29', '之诺60H', '4146', '0');
INSERT INTO `tbl_car_system` VALUES ('670', '马自达', '58', '长安马自达', '176', '马自达CX-5', '2987', '0');
INSERT INTO `tbl_car_system` VALUES ('671', '马自达', '58', '长安马自达', '176', '马自达3 Axela昂克赛拉', '3294', '0');
INSERT INTO `tbl_car_system` VALUES ('672', '昌河', '79', '昌河汽车', '177', '福瑞达', '2478', '0');
INSERT INTO `tbl_car_system` VALUES ('673', '昌河', '79', '昌河汽车', '177', '福运', '3058', '0');
INSERT INTO `tbl_car_system` VALUES ('674', '昌河', '79', '昌河汽车', '177', '昌河M50', '3640', '0');
INSERT INTO `tbl_car_system` VALUES ('675', '昌河', '79', '昌河汽车', '177', '昌河Q25', '3922', '0');
INSERT INTO `tbl_car_system` VALUES ('676', '昌河', '79', '昌河汽车', '177', '昌河Q35', '3980', '0');
INSERT INTO `tbl_car_system` VALUES ('677', '昌河', '79', '昌河汽车', '177', '福瑞达K21', '4141', '0');
INSERT INTO `tbl_car_system` VALUES ('678', '昌河', '79', '昌河汽车', '177', '福瑞达K22', '4142', '0');
INSERT INTO `tbl_car_system` VALUES ('679', '昌河', '79', '昌河汽车', '177', '昌河M70', '4208', '0');
INSERT INTO `tbl_car_system` VALUES ('68', '宝马', '15', '华晨宝马', '29', '宝马1系', '4171', '0');
INSERT INTO `tbl_car_system` VALUES ('680', '昌河', '79', '昌河汽车', '177', '北斗星X5E', '4488', '0');
INSERT INTO `tbl_car_system` VALUES ('681', '别克', '38', '别克(进口)', '182', '昂科雷', '592', '0');
INSERT INTO `tbl_car_system` VALUES ('682', '北汽制造', '154', '北京汽车制造厂', '185', '勇士', '622', '0');
INSERT INTO `tbl_car_system` VALUES ('683', '北汽制造', '154', '北京汽车制造厂', '185', '战旗', '965', '0');
INSERT INTO `tbl_car_system` VALUES ('684', '北汽制造', '154', '北京汽车制造厂', '185', '陆霸', '966', '0');
INSERT INTO `tbl_car_system` VALUES ('685', '北汽制造', '154', '北京汽车制造厂', '185', '北京BW007', '2126', '0');
INSERT INTO `tbl_car_system` VALUES ('686', '北汽制造', '154', '北京汽车制造厂', '185', '锐铃', '2915', '0');
INSERT INTO `tbl_car_system` VALUES ('687', '北汽制造', '154', '北京汽车制造厂', '185', '越铃', '2960', '0');
INSERT INTO `tbl_car_system` VALUES ('688', '北汽制造', '154', '北京汽车制造厂', '185', 'BJ 212', '3035', '0');
INSERT INTO `tbl_car_system` VALUES ('689', '北汽制造', '154', '北京汽车制造厂', '185', '战旗皮卡', '3221', '0');
INSERT INTO `tbl_car_system` VALUES ('69', '宝马', '15', '华晨宝马', '29', '宝马5系新能源', '4350', '0');
INSERT INTO `tbl_car_system` VALUES ('690', '北汽威旺', '143', '北京汽车制造厂', '185', '北汽007', '3712', '0');
INSERT INTO `tbl_car_system` VALUES ('691', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA3', '3069', '0');
INSERT INTO `tbl_car_system` VALUES ('692', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA6', '3349', '0');
INSERT INTO `tbl_car_system` VALUES ('693', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS3', '3495', '0');
INSERT INTO `tbl_car_system` VALUES ('694', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA3S视界', '3524', '0');
INSERT INTO `tbl_car_system` VALUES ('695', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS5 Super', '3574', '0');
INSERT INTO `tbl_car_system` VALUES ('696', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS4', '3691', '0');
INSERT INTO `tbl_car_system` VALUES ('697', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA8', '3782', '0');
INSERT INTO `tbl_car_system` VALUES ('698', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS8', '4094', '0');
INSERT INTO `tbl_car_system` VALUES ('699', '广汽传祺', '82', '广汽乘用车', '186', '传祺GM8', '4174', '0');
INSERT INTO `tbl_car_system` VALUES ('7', '长城', '77', '长城汽车', '4', '长城C30', '2090', '0');
INSERT INTO `tbl_car_system` VALUES ('70', '宝马', '15', '华晨宝马', '29', '宝马X1新能源', '4356', '0');
INSERT INTO `tbl_car_system` VALUES ('700', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS7', '4230', '0');
INSERT INTO `tbl_car_system` VALUES ('701', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA5新能源', '4340', '0');
INSERT INTO `tbl_car_system` VALUES ('702', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA4', '4630', '0');
INSERT INTO `tbl_car_system` VALUES ('703', 'smart', '45', 'smart', '187', 'smart fortwo', '620', '0');
INSERT INTO `tbl_car_system` VALUES ('704', 'smart', '45', 'smart', '187', 'smart forfour', '1004', '0');
INSERT INTO `tbl_car_system` VALUES ('705', '福田', '96', '福田汽车', '188', '福田风景', '2535', '0');
INSERT INTO `tbl_car_system` VALUES ('706', '福田', '96', '福田汽车', '188', '蒙派克E', '2542', '0');
INSERT INTO `tbl_car_system` VALUES ('707', '福田乘用车', '282', '福田汽车', '188', '拓陆者', '2577', '0');
INSERT INTO `tbl_car_system` VALUES ('708', '福田', '96', '福田汽车', '188', '萨普', '2579', '0');
INSERT INTO `tbl_car_system` VALUES ('709', '福田', '96', '福田汽车', '188', '蒙派克S', '3089', '0');
INSERT INTO `tbl_car_system` VALUES ('71', '哈飞', '24', '哈飞汽车', '30', '骏意', '2485', '0');
INSERT INTO `tbl_car_system` VALUES ('710', '福田乘用车', '282', '福田汽车', '188', '萨瓦纳', '3307', '0');
INSERT INTO `tbl_car_system` VALUES ('711', '福田', '96', '福田汽车', '188', '风景G7', '3440', '0');
INSERT INTO `tbl_car_system` VALUES ('712', '福田', '96', '福田汽车', '188', '风景V3', '3676', '0');
INSERT INTO `tbl_car_system` VALUES ('713', '福田', '96', '福田汽车', '188', '图雅诺', '3735', '0');
INSERT INTO `tbl_car_system` VALUES ('714', '福田', '96', '福田汽车', '188', '风景V5', '3821', '0');
INSERT INTO `tbl_car_system` VALUES ('715', '福田乘用车', '282', '福田汽车', '188', '伽途ix7', '3990', '0');
INSERT INTO `tbl_car_system` VALUES ('716', '福田乘用车', '282', '福田汽车', '188', '伽途ix5', '3991', '0');
INSERT INTO `tbl_car_system` VALUES ('717', '福田', '96', '福田汽车', '188', '风景G9', '4035', '0');
INSERT INTO `tbl_car_system` VALUES ('718', '福田乘用车', '282', '福田汽车', '188', '伽途im6', '4227', '0');
INSERT INTO `tbl_car_system` VALUES ('719', '福田乘用车', '282', '福田汽车', '188', '伽途im8', '4228', '0');
INSERT INTO `tbl_car_system` VALUES ('72', '哈飞', '24', '哈飞汽车', '30', '民意', '2486', '0');
INSERT INTO `tbl_car_system` VALUES ('720', '福田', '96', '福田汽车', '188', '图雅诺EV', '4612', '0');
INSERT INTO `tbl_car_system` VALUES ('721', '中兴', '74', '中兴汽车', '189', '威虎', '2519', '0');
INSERT INTO `tbl_car_system` VALUES ('722', '中兴', '74', '中兴汽车', '189', '小老虎', '3881', '0');
INSERT INTO `tbl_car_system` VALUES ('723', '中兴', '74', '中兴汽车', '189', '领主', '4178', '0');
INSERT INTO `tbl_car_system` VALUES ('724', '红旗', '91', '一汽红旗', '190', '红旗H7', '2771', '0');
INSERT INTO `tbl_car_system` VALUES ('725', '黄海', '97', '曙光汽车', '191', '旗胜V3', '2160', '0');
INSERT INTO `tbl_car_system` VALUES ('726', '黄海', '97', '曙光汽车', '191', '大柴神', '2515', '0');
INSERT INTO `tbl_car_system` VALUES ('727', '黄海', '97', '曙光汽车', '191', '小柴神', '2516', '0');
INSERT INTO `tbl_car_system` VALUES ('728', '黄海', '97', '曙光汽车', '191', '傲骏', '2517', '0');
INSERT INTO `tbl_car_system` VALUES ('729', '黄海', '97', '曙光汽车', '191', '黄海N1', '3455', '0');
INSERT INTO `tbl_car_system` VALUES ('73', '哈飞', '24', '哈飞汽车', '30', '哈飞小霸王', '2487', '0');
INSERT INTO `tbl_car_system` VALUES ('730', '黄海', '97', '曙光汽车', '191', '黄海N2', '3846', '0');
INSERT INTO `tbl_car_system` VALUES ('731', '黄海', '97', '曙光汽车', '191', '瑞途', '4162', '0');
INSERT INTO `tbl_car_system` VALUES ('732', '黄海', '97', '曙光汽车', '191', '黄海N3', '4436', '0');
INSERT INTO `tbl_car_system` VALUES ('733', '广汽吉奥', '108', '广汽吉奥', '203', '星旺', '2488', '0');
INSERT INTO `tbl_car_system` VALUES ('734', '广汽吉奥', '108', '广汽吉奥', '203', '财运500', '2568', '0');
INSERT INTO `tbl_car_system` VALUES ('735', '广汽吉奥', '108', '广汽吉奥', '203', '财运300', '2571', '0');
INSERT INTO `tbl_car_system` VALUES ('736', '广汽吉奥', '108', '广汽吉奥', '203', '财运100', '2599', '0');
INSERT INTO `tbl_car_system` VALUES ('737', '广汽吉奥', '108', '广汽吉奥', '203', '星旺CL', '2885', '0');
INSERT INTO `tbl_car_system` VALUES ('738', '广汽吉奥', '108', '广汽吉奥', '203', '星旺M1', '3139', '0');
INSERT INTO `tbl_car_system` VALUES ('739', '广汽吉奥', '108', '广汽吉奥', '203', '星旺M2', '3140', '0');
INSERT INTO `tbl_car_system` VALUES ('74', '哈飞', '24', '哈飞汽车', '30', '中意V5', '3038', '0');
INSERT INTO `tbl_car_system` VALUES ('740', '广汽吉奥', '108', '广汽吉奥', '203', '星旺L', '3159', '0');
INSERT INTO `tbl_car_system` VALUES ('741', '广汽吉奥', '108', '广汽吉奥', '203', '广汽吉奥GP150', '3480', '0');
INSERT INTO `tbl_car_system` VALUES ('742', 'KTM', '109', 'KTM', '204', 'X-BOW', '911', '0');
INSERT INTO `tbl_car_system` VALUES ('743', '野马汽车', '111', '野马汽车', '206', '野马T70', '2888', '0');
INSERT INTO `tbl_car_system` VALUES ('744', '野马汽车', '111', '野马汽车', '206', '野马T80', '3765', '0');
INSERT INTO `tbl_car_system` VALUES ('745', '野马汽车', '111', '野马汽车', '206', '野马U能E350', '3906', '0');
INSERT INTO `tbl_car_system` VALUES ('746', '野马汽车', '111', '野马汽车', '206', '野马EC30', '4510', '0');
INSERT INTO `tbl_car_system` VALUES ('747', 'GMC', '112', 'GMC', '207', 'YUKON', '947', '0');
INSERT INTO `tbl_car_system` VALUES ('748', 'GMC', '112', 'GMC', '207', 'SAVANA', '980', '0');
INSERT INTO `tbl_car_system` VALUES ('749', 'GMC', '112', 'GMC', '207', 'SIERRA', '2355', '0');
INSERT INTO `tbl_car_system` VALUES ('75', '哈飞', '24', '哈飞汽车', '30', '民意微卡', '3840', '0');
INSERT INTO `tbl_car_system` VALUES ('750', '开瑞', '101', '开瑞汽车', '208', '优优', '2476', '0');
INSERT INTO `tbl_car_system` VALUES ('751', '开瑞', '101', '开瑞汽车', '208', '优劲', '2496', '0');
INSERT INTO `tbl_car_system` VALUES ('752', '开瑞', '101', '开瑞汽车', '208', '优优2代', '3017', '0');
INSERT INTO `tbl_car_system` VALUES ('753', '开瑞', '101', '开瑞汽车', '208', '开瑞K50', '3384', '0');
INSERT INTO `tbl_car_system` VALUES ('754', '开瑞', '101', '开瑞汽车', '208', '开瑞K60', '4039', '0');
INSERT INTO `tbl_car_system` VALUES ('755', '东风风神', '113', '东风乘用车', '210', '东风风神A60', '2556', '0');
INSERT INTO `tbl_car_system` VALUES ('756', '东风风神', '113', '东风乘用车', '210', '东风风神E30', '3119', '0');
INSERT INTO `tbl_car_system` VALUES ('757', '东风风神', '113', '东风乘用车', '210', '东风风神AX7', '3341', '0');
INSERT INTO `tbl_car_system` VALUES ('758', '东风风神', '113', '东风乘用车', '210', '东风风神L60', '3461', '0');
INSERT INTO `tbl_car_system` VALUES ('759', '东风风神', '113', '东风乘用车', '210', '东风A9', '3463', '0');
INSERT INTO `tbl_car_system` VALUES ('76', '铃木', '53', '昌河铃木', '31', '北斗星', '75', '0');
INSERT INTO `tbl_car_system` VALUES ('760', '东风风神', '113', '东风乘用车', '210', '东风风神A30', '3493', '0');
INSERT INTO `tbl_car_system` VALUES ('761', '东风风神', '113', '东风乘用车', '210', '东风风神AX3', '3786', '0');
INSERT INTO `tbl_car_system` VALUES ('762', '东风风神', '113', '东风乘用车', '210', '东风风神AX5', '4097', '0');
INSERT INTO `tbl_car_system` VALUES ('763', '东风风神', '113', '东风乘用车', '210', '东风风神AX4', '4383', '0');
INSERT INTO `tbl_car_system` VALUES ('764', '东风风神', '113', '东风乘用车', '210', '东风风神E70', '4421', '0');
INSERT INTO `tbl_car_system` VALUES ('765', '奔驰', '36', '福建奔驰', '301', '威霆', '2084', '0');
INSERT INTO `tbl_car_system` VALUES ('766', '奔驰', '36', '福建奔驰', '301', '凌特', '2564', '0');
INSERT INTO `tbl_car_system` VALUES ('767', '奔驰', '36', '福建奔驰', '301', '奔驰V级', '3823', '0');
INSERT INTO `tbl_car_system` VALUES ('768', 'AC Schnitzer', '117', 'AC Schnitzer', '305', 'AC Schnitzer X5', '2097', '0');
INSERT INTO `tbl_car_system` VALUES ('769', 'AC Schnitzer', '117', 'AC Schnitzer', '305', 'AC Schnitzer M3', '3895', '0');
INSERT INTO `tbl_car_system` VALUES ('77', '铃木', '53', '昌河铃木', '31', '利亚纳A6', '3112', '0');
INSERT INTO `tbl_car_system` VALUES ('770', '驭胜', '263', '江铃汽车', '307', '驭胜S350', '2228', '0');
INSERT INTO `tbl_car_system` VALUES ('771', '江铃', '119', '江铃汽车', '307', '宝典', '2514', '0');
INSERT INTO `tbl_car_system` VALUES ('772', '江铃', '119', '江铃汽车', '307', '域虎', '2860', '0');
INSERT INTO `tbl_car_system` VALUES ('773', '驭胜', '263', '江铃汽车', '307', '驭胜S330', '3777', '0');
INSERT INTO `tbl_car_system` VALUES ('774', '江铃', '119', '江铃汽车', '307', '特顺', '4209', '0');
INSERT INTO `tbl_car_system` VALUES ('775', '北京', '27', '北京汽车', '312', '北京BJ40', '623', '0');
INSERT INTO `tbl_car_system` VALUES ('776', '北汽威旺', '143', '北京汽车', '312', '北汽威旺306', '2482', '0');
INSERT INTO `tbl_car_system` VALUES ('777', '北汽绅宝', '173', '北京汽车', '312', '绅宝D50', '2791', '0');
INSERT INTO `tbl_car_system` VALUES ('778', '北京', '27', '北京汽车', '312', '北京BJ80', '2852', '0');
INSERT INTO `tbl_car_system` VALUES ('779', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M20', '3191', '0');
INSERT INTO `tbl_car_system` VALUES ('78', '铃木', '53', '昌河铃木', '31', '北斗星X5', '3216', '0');
INSERT INTO `tbl_car_system` VALUES ('780', '北汽威旺', '143', '北京汽车', '312', '北汽威旺307', '3231', '0');
INSERT INTO `tbl_car_system` VALUES ('781', '北汽绅宝', '173', '北京汽车', '312', '绅宝X65', '3417', '0');
INSERT INTO `tbl_car_system` VALUES ('782', '北汽威旺', '143', '北京汽车', '312', '北汽威旺T205-D', '3428', '0');
INSERT INTO `tbl_car_system` VALUES ('783', '北汽绅宝', '173', '北京汽车', '312', '绅宝D20', '3557', '0');
INSERT INTO `tbl_car_system` VALUES ('784', '北汽绅宝', '173', '北京汽车', '312', '绅宝CC', '3794', '0');
INSERT INTO `tbl_car_system` VALUES ('785', '北汽绅宝', '173', '北京汽车', '312', '绅宝X55', '3795', '0');
INSERT INTO `tbl_car_system` VALUES ('786', '北京', '27', '北京汽车', '312', '北京(BJ)20', '3800', '0');
INSERT INTO `tbl_car_system` VALUES ('787', '北汽绅宝', '173', '北京汽车', '312', '绅宝X25', '3839', '0');
INSERT INTO `tbl_car_system` VALUES ('788', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M30', '3916', '0');
INSERT INTO `tbl_car_system` VALUES ('789', '北汽绅宝', '173', '北京汽车', '312', '绅宝X35', '3928', '0');
INSERT INTO `tbl_car_system` VALUES ('79', '本田', '14', '广汽本田', '32', '雅阁', '78', '0');
INSERT INTO `tbl_car_system` VALUES ('790', '北汽威旺', '143', '北京汽车', '312', '北汽威旺S50', '4009', '0');
INSERT INTO `tbl_car_system` VALUES ('791', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M35', '4061', '0');
INSERT INTO `tbl_car_system` VALUES ('792', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M50F', '4154', '0');
INSERT INTO `tbl_car_system` VALUES ('793', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M60', '4553', '0');
INSERT INTO `tbl_car_system` VALUES ('794', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦P1', '2902', '0');
INSERT INTO `tbl_car_system` VALUES ('795', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦650S', '3382', '0');
INSERT INTO `tbl_car_system` VALUES ('796', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦625C', '3620', '0');
INSERT INTO `tbl_car_system` VALUES ('797', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦675LT', '3733', '0');
INSERT INTO `tbl_car_system` VALUES ('798', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦570S', '3767', '0');
INSERT INTO `tbl_car_system` VALUES ('799', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦540C', '3809', '0');
INSERT INTO `tbl_car_system` VALUES ('8', '哈弗', '181', '长城汽车', '4', '哈弗H6', '2123', '0');
INSERT INTO `tbl_car_system` VALUES ('80', '本田', '14', '广汽本田', '32', '飞度', '81', '0');
INSERT INTO `tbl_car_system` VALUES ('800', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦570GT', '4040', '0');
INSERT INTO `tbl_car_system` VALUES ('801', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦720S', '4366', '0');
INSERT INTO `tbl_car_system` VALUES ('802', '纳智捷', '130', '东风裕隆', '315', '大7 SUV', '2295', '0');
INSERT INTO `tbl_car_system` VALUES ('803', '纳智捷', '130', '东风裕隆', '315', 'MASTER CEO', '2296', '0');
INSERT INTO `tbl_car_system` VALUES ('804', '纳智捷', '130', '东风裕隆', '315', '纳5', '2988', '0');
INSERT INTO `tbl_car_system` VALUES ('805', '纳智捷', '130', '东风裕隆', '315', '大7 MPV', '3040', '0');
INSERT INTO `tbl_car_system` VALUES ('806', '纳智捷', '130', '东风裕隆', '315', '优6 SUV', '3293', '0');
INSERT INTO `tbl_car_system` VALUES ('807', '纳智捷', '130', '东风裕隆', '315', '锐3', '3939', '0');
INSERT INTO `tbl_car_system` VALUES ('808', '纳智捷', '130', '东风裕隆', '315', 'U5 SUV', '4497', '0');
INSERT INTO `tbl_car_system` VALUES ('809', '特斯拉', '133', '特斯拉', '318', 'MODEL S', '2357', '0');
INSERT INTO `tbl_car_system` VALUES ('81', '本田', '14', '广汽本田', '32', '奥德赛', '880', '0');
INSERT INTO `tbl_car_system` VALUES ('810', '特斯拉', '133', '特斯拉', '318', 'MODEL X', '2664', '0');
INSERT INTO `tbl_car_system` VALUES ('811', 'Jeep', '46', '广汽菲克Jeep', '319', '指南者', '3845', '0');
INSERT INTO `tbl_car_system` VALUES ('812', 'Jeep', '46', '广汽菲克Jeep', '319', '自由光', '3872', '0');
INSERT INTO `tbl_car_system` VALUES ('813', 'Jeep', '46', '广汽菲克Jeep', '319', '自由侠', '4072', '0');
INSERT INTO `tbl_car_system` VALUES ('814', '巴博斯', '140', '巴博斯', '326', '巴博斯 SLK级', '2446', '0');
INSERT INTO `tbl_car_system` VALUES ('815', '巴博斯', '140', '巴博斯', '326', '巴博斯 smart fortwo', '2683', '0');
INSERT INTO `tbl_car_system` VALUES ('816', '巴博斯', '140', '巴博斯', '326', '巴博斯 smart forfour', '4261', '0');
INSERT INTO `tbl_car_system` VALUES ('817', '东风小康', '142', '东风小康', '327', '东风小康K01', '2452', '0');
INSERT INTO `tbl_car_system` VALUES ('818', '东风小康', '142', '东风小康', '327', '东风小康K02', '2497', '0');
INSERT INTO `tbl_car_system` VALUES ('819', '东风小康', '142', '东风小康', '327', '东风小康C37', '2865', '0');
INSERT INTO `tbl_car_system` VALUES ('82', '理念', '124', '广汽本田', '32', '理念S1', '2248', '0');
INSERT INTO `tbl_car_system` VALUES ('820', '东风小康', '142', '东风小康', '327', '东风小康C36', '3502', '0');
INSERT INTO `tbl_car_system` VALUES ('821', '东风小康', '142', '东风小康', '327', '东风小康K07S', '3697', '0');
INSERT INTO `tbl_car_system` VALUES ('822', '东风小康', '142', '东风小康', '327', '东风小康C31', '3698', '0');
INSERT INTO `tbl_car_system` VALUES ('823', '东风小康', '142', '东风小康', '327', '东风小康C32', '3699', '0');
INSERT INTO `tbl_car_system` VALUES ('824', '东风风光', '259', '东风小康', '327', '东风风光360', '3828', '0');
INSERT INTO `tbl_car_system` VALUES ('825', '东风风光', '259', '东风小康', '327', '东风风光330', '3829', '0');
INSERT INTO `tbl_car_system` VALUES ('826', '东风风光', '259', '东风小康', '327', '东风风光370', '3925', '0');
INSERT INTO `tbl_car_system` VALUES ('827', '东风风光', '259', '东风小康', '327', '东风风光580', '4023', '0');
INSERT INTO `tbl_car_system` VALUES ('828', '东风小康', '142', '东风小康', '327', '东风小康K05S', '4299', '0');
INSERT INTO `tbl_car_system` VALUES ('829', '东风小康', '142', '东风小康', '327', '东风小康EC36', '4461', '0');
INSERT INTO `tbl_car_system` VALUES ('83', '本田', '14', '广汽本田', '32', '凌派', '3085', '0');
INSERT INTO `tbl_car_system` VALUES ('830', '东风风光', '259', '东风小康', '327', '东风风光S560', '4468', '0');
INSERT INTO `tbl_car_system` VALUES ('831', '福迪', '141', '福迪汽车', '328', '小超人', '2475', '0');
INSERT INTO `tbl_car_system` VALUES ('832', '福迪', '141', '福迪汽车', '328', '雄狮', '2894', '0');
INSERT INTO `tbl_car_system` VALUES ('833', '福迪', '141', '福迪汽车', '328', '雄师F16', '2895', '0');
INSERT INTO `tbl_car_system` VALUES ('834', '福迪', '141', '福迪汽车', '328', '揽福', '3633', '0');
INSERT INTO `tbl_car_system` VALUES ('835', '福迪', '141', '福迪汽车', '328', '雄师F22', '3754', '0');
INSERT INTO `tbl_car_system` VALUES ('836', '依维柯', '144', '南京依维柯', '329', '依维柯得意', '2532', '0');
INSERT INTO `tbl_car_system` VALUES ('837', '依维柯', '144', '南京依维柯', '329', '依维柯Power Daily', '2533', '0');
INSERT INTO `tbl_car_system` VALUES ('838', '依维柯', '144', '南京依维柯', '329', '依维柯Ouba', '4266', '0');
INSERT INTO `tbl_car_system` VALUES ('839', '依维柯', '144', '南京依维柯', '329', '依维柯Venice', '4267', '0');
INSERT INTO `tbl_car_system` VALUES ('84', '本田', '14', '广汽本田', '32', '缤智', '3460', '0');
INSERT INTO `tbl_car_system` VALUES ('840', '依维柯', '144', '南京依维柯', '329', '依维柯Daily(欧胜)', '4580', '0');
INSERT INTO `tbl_car_system` VALUES ('841', '金龙', '145', '厦门金龙', '330', '凯歌', '2985', '0');
INSERT INTO `tbl_car_system` VALUES ('842', '金龙', '145', '厦门金龙', '330', '金威', '2986', '0');
INSERT INTO `tbl_car_system` VALUES ('843', '金龙', '145', '厦门金龙', '330', '凯特', '3549', '0');
INSERT INTO `tbl_car_system` VALUES ('844', '陕汽通家', '149', '陕汽通家', '333', '福家', '2570', '0');
INSERT INTO `tbl_car_system` VALUES ('845', '陕汽通家', '149', '陕汽通家', '333', '龙锐', '3244', '0');
INSERT INTO `tbl_car_system` VALUES ('846', '海格', '150', '苏州金龙', '334', '海格H5C', '2572', '0');
INSERT INTO `tbl_car_system` VALUES ('847', '海格', '150', '苏州金龙', '334', '御骏', '2673', '0');
INSERT INTO `tbl_car_system` VALUES ('848', '海格', '150', '苏州金龙', '334', '龙威', '3149', '0');
INSERT INTO `tbl_car_system` VALUES ('849', '海格', '150', '苏州金龙', '334', '海格H7V', '3235', '0');
INSERT INTO `tbl_car_system` VALUES ('85', '本田', '14', '广汽本田', '32', '锋范', '3876', '0');
INSERT INTO `tbl_car_system` VALUES ('850', '海格', '150', '苏州金龙', '334', '海格H5V', '3243', '0');
INSERT INTO `tbl_car_system` VALUES ('851', '海格', '150', '苏州金龙', '334', '海格H6C', '3636', '0');
INSERT INTO `tbl_car_system` VALUES ('852', '海格', '150', '苏州金龙', '334', '海格H6V', '3638', '0');
INSERT INTO `tbl_car_system` VALUES ('853', '海格', '150', '苏州金龙', '334', '海格H4E', '4131', '0');
INSERT INTO `tbl_car_system` VALUES ('854', '九龙', '151', '九龙汽车', '335', '九龙A5', '2573', '0');
INSERT INTO `tbl_car_system` VALUES ('855', '九龙', '151', '九龙汽车', '335', '九龙A6', '2576', '0');
INSERT INTO `tbl_car_system` VALUES ('856', '九龙', '151', '九龙汽车', '335', '考斯特', '3194', '0');
INSERT INTO `tbl_car_system` VALUES ('857', '九龙', '151', '九龙汽车', '335', '艾菲', '3320', '0');
INSERT INTO `tbl_car_system` VALUES ('858', '九龙', '151', '九龙汽车', '335', '九龙A4', '3628', '0');
INSERT INTO `tbl_car_system` VALUES ('859', '观致', '152', '观致汽车', '336', '观致3', '2974', '0');
INSERT INTO `tbl_car_system` VALUES ('86', '本田', '14', '广汽本田', '32', '冠道', '4102', '0');
INSERT INTO `tbl_car_system` VALUES ('860', '观致', '152', '观致汽车', '336', '观致5', '3662', '0');
INSERT INTO `tbl_car_system` VALUES ('861', '一汽', '110', '一汽通用', '338', '坤程', '2603', '0');
INSERT INTO `tbl_car_system` VALUES ('862', '海马', '86', '海马汽车', '341', '海马M3', '2941', '0');
INSERT INTO `tbl_car_system` VALUES ('863', '海马', '86', '海马汽车', '341', '海马M6', '3006', '0');
INSERT INTO `tbl_car_system` VALUES ('864', '海马', '86', '海马汽车', '341', '福仕达腾达', '3162', '0');
INSERT INTO `tbl_car_system` VALUES ('865', '海马', '86', '海马汽车', '341', '福仕达福卡', '3163', '0');
INSERT INTO `tbl_car_system` VALUES ('866', '海马', '86', '海马汽车', '341', '海马S5', '3214', '0');
INSERT INTO `tbl_car_system` VALUES ('867', '海马', '86', '海马汽车', '341', '海马@3', '4156', '0');
INSERT INTO `tbl_car_system` VALUES ('868', '海马', '86', '海马汽车', '341', '海马S5青春版', '4169', '0');
INSERT INTO `tbl_car_system` VALUES ('869', '海马', '86', '海马汽车', '341', '海马爱尚EV', '4459', '0');
INSERT INTO `tbl_car_system` VALUES ('87', '奇瑞', '26', '奇瑞汽车', '33', '风云2', '837', '0');
INSERT INTO `tbl_car_system` VALUES ('870', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰S级AMG', '2197', '0');
INSERT INTO `tbl_car_system` VALUES ('871', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰C级AMG', '2717', '0');
INSERT INTO `tbl_car_system` VALUES ('872', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰E级AMG', '2718', '0');
INSERT INTO `tbl_car_system` VALUES ('873', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰CLS级AMG', '2719', '0');
INSERT INTO `tbl_car_system` VALUES ('874', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰G级AMG', '2723', '0');
INSERT INTO `tbl_car_system` VALUES ('875', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰A级AMG', '2842', '0');
INSERT INTO `tbl_car_system` VALUES ('876', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰CLA级AMG', '2967', '0');
INSERT INTO `tbl_car_system` VALUES ('877', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLA AMG', '3264', '0');
INSERT INTO `tbl_car_system` VALUES ('878', '奔驰', '36', '梅赛德斯-AMG', '344', 'AMG GT', '3451', '0');
INSERT INTO `tbl_car_system` VALUES ('879', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLE AMG', '3704', '0');
INSERT INTO `tbl_car_system` VALUES ('88', '奇瑞', '26', '奇瑞汽车', '33', '奇瑞E5', '2324', '0');
INSERT INTO `tbl_car_system` VALUES ('880', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLS AMG', '3901', '0');
INSERT INTO `tbl_car_system` VALUES ('881', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLC AMG', '4074', '0');
INSERT INTO `tbl_car_system` VALUES ('882', '宝马', '15', '宝马M', '345', '宝马M3', '2196', '0');
INSERT INTO `tbl_car_system` VALUES ('883', '宝马', '15', '宝马M', '345', '宝马M5', '2726', '0');
INSERT INTO `tbl_car_system` VALUES ('884', '宝马', '15', '宝马M', '345', '宝马M6', '2727', '0');
INSERT INTO `tbl_car_system` VALUES ('885', '宝马', '15', '宝马M', '345', '宝马X5 M', '2728', '0');
INSERT INTO `tbl_car_system` VALUES ('886', '宝马', '15', '宝马M', '345', '宝马X6 M', '2729', '0');
INSERT INTO `tbl_car_system` VALUES ('887', '宝马', '15', '宝马M', '345', '宝马M4', '3189', '0');
INSERT INTO `tbl_car_system` VALUES ('888', '宝马', '15', '宝马M', '345', '宝马M2', '3357', '0');
INSERT INTO `tbl_car_system` VALUES ('889', '奥迪', '33', 'Audi Sport', '346', '奥迪R8', '511', '0');
INSERT INTO `tbl_car_system` VALUES ('89', '奇瑞', '26', '奇瑞汽车', '33', '爱卡', '2914', '0');
INSERT INTO `tbl_car_system` VALUES ('890', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 3', '2731', '0');
INSERT INTO `tbl_car_system` VALUES ('891', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 6', '2737', '0');
INSERT INTO `tbl_car_system` VALUES ('892', '奥迪', '33', 'Audi Sport', '346', '奥迪TT RS', '2741', '0');
INSERT INTO `tbl_car_system` VALUES ('893', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 7', '2994', '0');
INSERT INTO `tbl_car_system` VALUES ('894', '腾势', '161', '腾势汽车', '347', '腾势', '2805', '0');
INSERT INTO `tbl_car_system` VALUES ('895', '恒天', '164', '恒天汽车', '349', '途腾T1', '2754', '0');
INSERT INTO `tbl_car_system` VALUES ('896', '恒天', '164', '恒天汽车', '349', '途腾T2', '2755', '0');
INSERT INTO `tbl_car_system` VALUES ('897', '恒天', '164', '恒天汽车', '349', '途腾T3', '2973', '0');
INSERT INTO `tbl_car_system` VALUES ('898', '五十铃', '167', '庆铃汽车', '350', '五十铃皮卡', '2834', '0');
INSERT INTO `tbl_car_system` VALUES ('899', '五十铃', '167', '庆铃汽车', '350', '竞技者', '4198', '0');
INSERT INTO `tbl_car_system` VALUES ('9', '哈弗', '181', '长城汽车', '4', '哈弗H8', '2124', '0');
INSERT INTO `tbl_car_system` VALUES ('90', '奇瑞', '26', '奇瑞汽车', '33', '艾瑞泽7', '2980', '0');
INSERT INTO `tbl_car_system` VALUES ('900', '庆铃汽车', '312', '庆铃汽车', '350', '庆铃TAGA', '4656', '0');
INSERT INTO `tbl_car_system` VALUES ('901', '摩根', '168', '摩根', '351', '摩根Aero', '2835', '0');
INSERT INTO `tbl_car_system` VALUES ('902', '摩根', '168', '摩根', '351', '摩根Plus 8', '2836', '0');
INSERT INTO `tbl_car_system` VALUES ('903', '摩根', '168', '摩根', '351', '摩根Roadster', '3151', '0');
INSERT INTO `tbl_car_system` VALUES ('904', '摩根', '168', '摩根', '351', '摩根Plus 4', '3152', '0');
INSERT INTO `tbl_car_system` VALUES ('905', '摩根', '168', '摩根', '351', '摩根4-4', '3153', '0');
INSERT INTO `tbl_car_system` VALUES ('906', '摩根', '168', '摩根', '351', '3 Wheeler', '3491', '0');
INSERT INTO `tbl_car_system` VALUES ('907', '摩根', '168', '摩根', '351', '摩根Aero 8', '3736', '0');
INSERT INTO `tbl_car_system` VALUES ('908', '三菱', '68', '广汽三菱', '355', '劲炫ASX', '2768', '0');
INSERT INTO `tbl_car_system` VALUES ('909', '三菱', '68', '广汽三菱', '355', '帕杰罗·劲畅', '3008', '0');
INSERT INTO `tbl_car_system` VALUES ('91', '奇瑞', '26', '奇瑞汽车', '33', '奇瑞QQ', '2989', '0');
INSERT INTO `tbl_car_system` VALUES ('910', '三菱', '68', '广汽三菱', '355', '欧蓝德', '4147', '0');
INSERT INTO `tbl_car_system` VALUES ('911', '祺智', '289', '广汽三菱', '355', '祺智PHEV', '4431', '0');
INSERT INTO `tbl_car_system` VALUES ('912', '上汽大通', '155', '上汽大通', '356', '上汽大通V80', '2608', '0');
INSERT INTO `tbl_car_system` VALUES ('913', '上汽大通', '155', '上汽大通', '356', '上汽大通G10', '3064', '0');
INSERT INTO `tbl_car_system` VALUES ('914', '上汽大通', '155', '上汽大通', '356', '上汽大通D90', '4120', '0');
INSERT INTO `tbl_car_system` VALUES ('915', '上汽大通', '155', '上汽大通', '356', '上汽大通T60', '4241', '0');
INSERT INTO `tbl_car_system` VALUES ('916', '上汽大通', '155', '上汽大通', '356', '上汽大通EG10', '4338', '0');
INSERT INTO `tbl_car_system` VALUES ('917', 'DS', '169', '长安标致雪铁龙', '357', 'DS 5', '2952', '0');
INSERT INTO `tbl_car_system` VALUES ('918', 'DS', '169', '长安标致雪铁龙', '357', 'DS 5LS', '3309', '0');
INSERT INTO `tbl_car_system` VALUES ('919', 'DS', '169', '长安标致雪铁龙', '357', 'DS 6', '3324', '0');
INSERT INTO `tbl_car_system` VALUES ('92', '奇瑞', '26', '奇瑞汽车', '33', '艾瑞泽3', '3157', '0');
INSERT INTO `tbl_car_system` VALUES ('920', 'DS', '169', '长安标致雪铁龙', '357', 'DS 4S', '3963', '0');
INSERT INTO `tbl_car_system` VALUES ('921', '如虎', '174', '如虎', '358', '如虎 CTR 3', '2970', '0');
INSERT INTO `tbl_car_system` VALUES ('922', '如虎', '174', '如虎', '358', '如虎 XL', '2972', '0');
INSERT INTO `tbl_car_system` VALUES ('923', '金旅', '175', '厦门金旅', '359', '金旅海狮', '2976', '0');
INSERT INTO `tbl_car_system` VALUES ('924', '金旅', '175', '厦门金旅', '359', '金旅大海狮新能源', '3885', '0');
INSERT INTO `tbl_car_system` VALUES ('925', '金旅', '175', '厦门金旅', '359', '金旅大海狮', '3886', '0');
INSERT INTO `tbl_car_system` VALUES ('926', '金旅', '175', '厦门金旅', '359', '金旅海狮新能源', '4601', '0');
INSERT INTO `tbl_car_system` VALUES ('927', 'Jeep', '46', 'SRT', '363', '大切诺基 SRT', '3048', '0');
INSERT INTO `tbl_car_system` VALUES ('928', '新凯', '185', '新凯汽车', '364', '新凯威霆', '3702', '0');
INSERT INTO `tbl_car_system` VALUES ('929', '新凯', '185', '新凯汽车', '364', '新凯凌特', '3703', '0');
INSERT INTO `tbl_car_system` VALUES ('93', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎5', '3195', '0');
INSERT INTO `tbl_car_system` VALUES ('930', '新凯', '185', '新凯汽车', '364', '新凯V-Class', '4351', '0');
INSERT INTO `tbl_car_system` VALUES ('931', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S60L', '3158', '0');
INSERT INTO `tbl_car_system` VALUES ('932', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃XC60', '3411', '0');
INSERT INTO `tbl_car_system` VALUES ('933', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S90', '4206', '0');
INSERT INTO `tbl_car_system` VALUES ('934', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S60L新能源', '4335', '0');
INSERT INTO `tbl_car_system` VALUES ('935', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃XC60新能源', '4609', '0');
INSERT INTO `tbl_car_system` VALUES ('936', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW', '3178', '0');
INSERT INTO `tbl_car_system` VALUES ('937', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW CLUBMAN', '3179', '0');
INSERT INTO `tbl_car_system` VALUES ('938', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW COUNTRYMAN', '3181', '0');
INSERT INTO `tbl_car_system` VALUES ('939', '潍柴英致', '192', '潍柴汽车', '372', '英致G3', '3306', '0');
INSERT INTO `tbl_car_system` VALUES ('94', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎3', '3397', '0');
INSERT INTO `tbl_car_system` VALUES ('940', '潍柴英致', '192', '潍柴汽车', '372', '英致737', '3653', '0');
INSERT INTO `tbl_car_system` VALUES ('941', '潍柴英致', '192', '潍柴汽车', '372', '英致G5', '3882', '0');
INSERT INTO `tbl_car_system` VALUES ('942', '潍柴英致', '192', '潍柴汽车', '372', '英致727', '3969', '0');
INSERT INTO `tbl_car_system` VALUES ('943', '长安跨越', '299', '长安跨越', '373', '长安V5', '3311', '0');
INSERT INTO `tbl_car_system` VALUES ('944', '长安跨越', '299', '长安跨越', '373', '长安V3', '4181', '0');
INSERT INTO `tbl_car_system` VALUES ('945', '长安跨越', '299', '长安跨越', '373', '新豹MINI', '4182', '0');
INSERT INTO `tbl_car_system` VALUES ('946', '长安跨越', '299', '长安跨越', '373', '跨越王', '4319', '0');
INSERT INTO `tbl_car_system` VALUES ('947', '雷诺', '10', '东风雷诺', '375', '科雷嘉', '3870', '0');
INSERT INTO `tbl_car_system` VALUES ('948', '雷诺', '10', '东风雷诺', '375', '科雷傲', '4098', '0');
INSERT INTO `tbl_car_system` VALUES ('949', '路虎', '49', '奇瑞捷豹路虎', '376', '揽胜极光', '3521', '0');
INSERT INTO `tbl_car_system` VALUES ('95', '奇瑞', '26', '奇瑞汽车', '33', '艾瑞泽5', '3405', '0');
INSERT INTO `tbl_car_system` VALUES ('950', '路虎', '49', '奇瑞捷豹路虎', '376', '发现神行', '3871', '0');
INSERT INTO `tbl_car_system` VALUES ('951', '捷豹', '44', '奇瑞捷豹路虎', '376', '捷豹XFL', '4083', '0');
INSERT INTO `tbl_car_system` VALUES ('952', '捷豹', '44', '奇瑞捷豹路虎', '376', '捷豹XEL', '4462', '0');
INSERT INTO `tbl_car_system` VALUES ('953', '成功汽车', '196', '成功汽车', '377', '成功V1', '3504', '0');
INSERT INTO `tbl_car_system` VALUES ('954', '成功汽车', '196', '成功汽车', '377', '成功V2', '3505', '0');
INSERT INTO `tbl_car_system` VALUES ('955', '成功汽车', '196', '成功汽车', '377', '成功K1', '3506', '0');
INSERT INTO `tbl_car_system` VALUES ('956', '成功汽车', '196', '成功汽车', '377', '成功K2', '3507', '0');
INSERT INTO `tbl_car_system` VALUES ('957', '成功汽车', '196', '成功汽车', '377', '成功X1', '3508', '0');
INSERT INTO `tbl_car_system` VALUES ('958', '成功汽车', '196', '成功汽车', '377', '成功V2E', '4533', '0');
INSERT INTO `tbl_car_system` VALUES ('959', '福汽启腾', '197', '福汽新龙马', '378', '启腾M70', '3346', '0');
INSERT INTO `tbl_car_system` VALUES ('96', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎7', '3766', '0');
INSERT INTO `tbl_car_system` VALUES ('960', '福汽启腾', '197', '福汽新龙马', '378', '启腾EX80', '3877', '0');
INSERT INTO `tbl_car_system` VALUES ('961', '福汽启腾', '197', '福汽新龙马', '378', '启腾V60', '3992', '0');
INSERT INTO `tbl_car_system` VALUES ('962', '福汽启腾', '197', '福汽新龙马', '378', '启腾M70EV', '4530', '0');
INSERT INTO `tbl_car_system` VALUES ('963', '卡威', '199', '卡威汽车', '380', '卡威K1', '3360', '0');
INSERT INTO `tbl_car_system` VALUES ('964', '卡威', '199', '卡威汽车', '380', '卡威W1', '3511', '0');
INSERT INTO `tbl_car_system` VALUES ('965', '卡威', '199', '卡威汽车', '380', '卡威K150', '4172', '0');
INSERT INTO `tbl_car_system` VALUES ('966', '卡威', '199', '卡威汽车', '380', '卡威W1新能源', '4482', '0');
INSERT INTO `tbl_car_system` VALUES ('967', '卡威', '199', '卡威汽车', '380', '卡威K150GT', '4557', '0');
INSERT INTO `tbl_car_system` VALUES ('968', '卡威', '199', '卡威汽车', '380', '路易斯', '4563', '0');
INSERT INTO `tbl_car_system` VALUES ('969', '泰卡特', '202', '泰卡特', '382', '泰卡特 T9', '3393', '0');
INSERT INTO `tbl_car_system` VALUES ('97', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎3x', '4099', '0');
INSERT INTO `tbl_car_system` VALUES ('970', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S2', '3284', '0');
INSERT INTO `tbl_car_system` VALUES ('971', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S3', '3361', '0');
INSERT INTO `tbl_car_system` VALUES ('972', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S6', '3426', '0');
INSERT INTO `tbl_car_system` VALUES ('973', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H2', '3661', '0');
INSERT INTO `tbl_car_system` VALUES ('974', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H6', '3714', '0');
INSERT INTO `tbl_car_system` VALUES ('975', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H3', '3874', '0');
INSERT INTO `tbl_car_system` VALUES ('976', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H2V', '4137', '0');
INSERT INTO `tbl_car_system` VALUES ('977', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S5', '4276', '0');
INSERT INTO `tbl_car_system` VALUES ('978', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S7', '4502', '0');
INSERT INTO `tbl_car_system` VALUES ('979', '南京金龙', '213', '南京金龙', '384', '开沃D11', '3432', '0');
INSERT INTO `tbl_car_system` VALUES ('98', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎5x', '4531', '0');
INSERT INTO `tbl_car_system` VALUES ('980', '南京金龙', '213', '南京金龙', '384', '开沃D07', '4639', '0');
INSERT INTO `tbl_car_system` VALUES ('981', '南京金龙', '213', '南京金龙', '384', '开沃D08', '4640', '0');
INSERT INTO `tbl_car_system` VALUES ('982', '南京金龙', '213', '南京金龙', '384', '开沃D09', '4641', '0');
INSERT INTO `tbl_car_system` VALUES ('983', '南京金龙', '213', '南京金龙', '384', '开沃D10', '4642', '0');
INSERT INTO `tbl_car_system` VALUES ('984', '陆地方舟', '204', '陆地方舟', '385', '威途X35', '4509', '0');
INSERT INTO `tbl_car_system` VALUES ('985', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T5', '3466', '0');
INSERT INTO `tbl_car_system` VALUES ('986', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T7', '3639', '0');
INSERT INTO `tbl_car_system` VALUES ('987', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T3', '3981', '0');
INSERT INTO `tbl_car_system` VALUES ('988', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T100', '4493', '0');
INSERT INTO `tbl_car_system` VALUES ('989', '知豆', '206', '知豆电动车', '388', '知豆D1', '3706', '0');
INSERT INTO `tbl_car_system` VALUES ('99', '铃木', '53', '长安铃木', '35', '雨燕', '362', '0');
INSERT INTO `tbl_car_system` VALUES ('990', '知豆', '206', '知豆电动车', '388', '知豆D2', '3827', '0');
INSERT INTO `tbl_car_system` VALUES ('991', '北汽新能源', '208', '北汽新能源', '390', 'EV系列', '3533', '0');
INSERT INTO `tbl_car_system` VALUES ('992', '北汽新能源', '208', '北汽新能源', '390', 'EU系列', '3884', '0');
INSERT INTO `tbl_car_system` VALUES ('993', '北汽新能源', '208', '北汽新能源', '390', 'EX系列', '4015', '0');
INSERT INTO `tbl_car_system` VALUES ('994', '北汽新能源', '208', '北汽新能源', '390', 'EH系列', '4104', '0');
INSERT INTO `tbl_car_system` VALUES ('995', '北汽新能源', '208', '北汽新能源', '390', 'EC系列', '4264', '0');
INSERT INTO `tbl_car_system` VALUES ('996', 'ARCFOX', '272', '北汽新能源', '390', 'LITE', '4522', '0');
INSERT INTO `tbl_car_system` VALUES ('997', '英菲尼迪', '73', '东风英菲尼迪', '392', '英菲尼迪Q50L', '3553', '0');
INSERT INTO `tbl_car_system` VALUES ('998', '英菲尼迪', '73', '东风英菲尼迪', '392', '英菲尼迪QX50', '3591', '0');
INSERT INTO `tbl_car_system` VALUES ('999', '五十铃', '167', '江西五十铃', '394', 'D-MAX', '3562', '0');
INSERT INTO `tbl_car_system` VALUES ('CB7E8F8AF0D85BDBD51CDB760E4A2A6C', '2', '2', '2', '2', '2', '2', '0');
INSERT INTO `tbl_car_system` VALUES ('D2D2A7234B375F305AB4EE038EFC2AC3', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `tbl_car_system` VALUES ('DA2F8E83963B2C951CC45C9DA14A26F4', '1', '1', '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for `tbl_file`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `file_name` varchar(255) DEFAULT NULL COMMENT '附件名称',
  `FILE_NAME_BAK` varchar(255) DEFAULT NULL COMMENT '附件原名称',
  `FILE_PATH` varchar(255) DEFAULT NULL COMMENT '附件路径',
  `UPLOAD_DATE` datetime DEFAULT NULL COMMENT '上传时间',
  `STATUS` varchar(1) DEFAULT '0' COMMENT '状态：状态：0 待整理，1 已整理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_file
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_file_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file_detail`;
CREATE TABLE `tbl_file_detail` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `file_id` varchar(35) NOT NULL COMMENT '文件表ID',
  `package_name` varchar(255) DEFAULT NULL COMMENT '包名',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `task_id` varchar(255) DEFAULT NULL COMMENT '任务ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `area` varchar(255) DEFAULT NULL COMMENT '地区',
  `car_sys` varchar(255) DEFAULT NULL COMMENT '车系',
  `status` varchar(255) DEFAULT NULL COMMENT '状态：0 正常，1 大库重复，2 任务重复，3 车系重复，4 黑名单命中，5 号段错误，6 ID转失败',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_file_detail
-- ----------------------------

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
INSERT INTO `tbl_function` VALUES ('F001001', '上传数据', '上传数据', '2', '/car/uploader');
INSERT INTO `tbl_function` VALUES ('F001002', '数据列表', '数据列表', '2', '/car/list');
INSERT INTO `tbl_function` VALUES ('F002', '数据统计', '数据统计', '1', '#');
INSERT INTO `tbl_function` VALUES ('F002001', '数据统计', '数据统计', '2', '/test');
INSERT INTO `tbl_function` VALUES ('F003', '检测预警', '检测预警', '1', '#');
INSERT INTO `tbl_function` VALUES ('F004', '批量导出', '批量导出', '1', '#');
INSERT INTO `tbl_function` VALUES ('F005', '黑名单管理', '黑名单管理', '1', '/blackList');
INSERT INTO `tbl_function` VALUES ('F006', '车系管理', '车系管理', '1', '#');
INSERT INTO `tbl_function` VALUES ('F006001', '车系列表', '车系列表', '2', '/carSystem/info');

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
  `is_black` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否开启黑名单1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'test@qq.com', '测试', '1');

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
