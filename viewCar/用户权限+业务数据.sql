/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-24 00:37:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_ad_pro_manage
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ad_pro_manage`;
CREATE TABLE `tbl_ad_pro_manage` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `insert_date` varchar(1000) DEFAULT NULL COMMENT '载入时间',
  `pro_id` varchar(1000) DEFAULT NULL COMMENT '项目id',
  `pro_name` varchar(1000) DEFAULT NULL COMMENT '项目名称',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `trade_name` varchar(255) DEFAULT NULL COMMENT '厂商名称',
  `car_sys_name` varchar(255) DEFAULT NULL COMMENT '车系名称',
  `status` varchar(255) DEFAULT NULL COMMENT '投放状态 0投放中，1投放暂停，2投放结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_ad_pro_manage
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_area
-- ----------------------------
DROP TABLE IF EXISTS `tbl_area`;
CREATE TABLE `tbl_area` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `area_code` varchar(35) DEFAULT NULL COMMENT '城市编码',
  `city_name` varchar(100) DEFAULT NULL COMMENT '城市名称',
  `prov_name` varchar(100) DEFAULT NULL COMMENT '省',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_area
-- ----------------------------
INSERT INTO `tbl_area` VALUES ('110100', '110100', '北京市', '北京');
INSERT INTO `tbl_area` VALUES ('120100', '120100', '天津市', '天津');
INSERT INTO `tbl_area` VALUES ('130100', '130100', '石家庄市', '河北省');
INSERT INTO `tbl_area` VALUES ('130200', '130200', '唐山市', '河北省');
INSERT INTO `tbl_area` VALUES ('130300', '130300', '秦皇岛市', '河北省');
INSERT INTO `tbl_area` VALUES ('130400', '130400', '邯郸市', '河北省');
INSERT INTO `tbl_area` VALUES ('130500', '130500', '邢台市', '河北省');
INSERT INTO `tbl_area` VALUES ('130600', '130600', '保定市', '河北省');
INSERT INTO `tbl_area` VALUES ('130700', '130700', '张家口市', '河北省');
INSERT INTO `tbl_area` VALUES ('130800', '130800', '承德市', '河北省');
INSERT INTO `tbl_area` VALUES ('130900', '130900', '沧州市', '河北省');
INSERT INTO `tbl_area` VALUES ('131000', '131000', '廊坊市', '河北省');
INSERT INTO `tbl_area` VALUES ('131100', '131100', '衡水市', '河北省');
INSERT INTO `tbl_area` VALUES ('139900', '139900', '其他地区', '河北省');
INSERT INTO `tbl_area` VALUES ('140100', '140100', '太原市', '山西省');
INSERT INTO `tbl_area` VALUES ('140200', '140200', '大同市', '山西省');
INSERT INTO `tbl_area` VALUES ('140300', '140300', '阳泉市', '山西省');
INSERT INTO `tbl_area` VALUES ('140400', '140400', '长治市', '山西省');
INSERT INTO `tbl_area` VALUES ('140500', '140500', '晋城市', '山西省');
INSERT INTO `tbl_area` VALUES ('140600', '140600', '朔州市', '山西省');
INSERT INTO `tbl_area` VALUES ('140700', '140700', '晋中市', '山西省');
INSERT INTO `tbl_area` VALUES ('140800', '140800', '运城市', '山西省');
INSERT INTO `tbl_area` VALUES ('140900', '140900', '忻州市', '山西省');
INSERT INTO `tbl_area` VALUES ('141000', '141000', '临汾市', '山西省');
INSERT INTO `tbl_area` VALUES ('141100', '141100', '吕梁市', '山西省');
INSERT INTO `tbl_area` VALUES ('149900', '149900', '其他地区', '山西省');
INSERT INTO `tbl_area` VALUES ('150100', '150100', '呼和浩特市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150200', '150200', '包头市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150300', '150300', '乌海市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150400', '150400', '赤峰市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150500', '150500', '通辽市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150600', '150600', '鄂尔多斯市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150700', '150700', '呼伦贝尔市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150800', '150800', '巴彦淖尔市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('150900', '150900', '乌兰察布市', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('152200', '152200', '兴安盟', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('152500', '152500', '锡林郭勒盟', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('152900', '152900', '阿拉善盟', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('159900', '159900', '其他地区', '内蒙古自治区');
INSERT INTO `tbl_area` VALUES ('210100', '210100', '沈阳市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210200', '210200', '大连市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210300', '210300', '鞍山市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210400', '210400', '抚顺市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210500', '210500', '本溪市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210600', '210600', '丹东市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210700', '210700', '锦州市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210800', '210800', '营口市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('210900', '210900', '阜新市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('211000', '211000', '辽阳市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('211100', '211100', '盘锦市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('211200', '211200', '铁岭市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('211300', '211300', '朝阳市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('211400', '211400', '葫芦岛市', '辽宁省');
INSERT INTO `tbl_area` VALUES ('219900', '219900', '其他地区', '辽宁省');
INSERT INTO `tbl_area` VALUES ('220100', '220100', '长春市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220200', '220200', '吉林市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220300', '220300', '四平市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220400', '220400', '辽源市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220500', '220500', '通化市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220600', '220600', '白山市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220700', '220700', '松原市', '吉林省');
INSERT INTO `tbl_area` VALUES ('220800', '220800', '白城市', '吉林省');
INSERT INTO `tbl_area` VALUES ('222400', '222400', '延边朝鲜族自治州', '吉林省');
INSERT INTO `tbl_area` VALUES ('229900', '229900', '其他地区', '吉林省');
INSERT INTO `tbl_area` VALUES ('230100', '230100', '哈尔滨市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230200', '230200', '齐齐哈尔市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230300', '230300', '鸡西市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230400', '230400', '鹤岗市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230500', '230500', '双鸭山市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230600', '230600', '大庆市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230700', '230700', '伊春市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230800', '230800', '佳木斯市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('230900', '230900', '七台河市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('231000', '231000', '牡丹江市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('231100', '231100', '黑河市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('231200', '231200', '绥化市', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('232700', '232700', '大兴安岭地区', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('239900', '239900', '其他地区', '黑龙江省');
INSERT INTO `tbl_area` VALUES ('310100', '310100', '上海市', '上海');
INSERT INTO `tbl_area` VALUES ('320100', '320100', '南京市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320200', '320200', '无锡市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320300', '320300', '徐州市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320400', '320400', '常州市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320500', '320500', '苏州市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320600', '320600', '南通市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320700', '320700', '连云港市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320800', '320800', '淮安市', '江苏省');
INSERT INTO `tbl_area` VALUES ('320900', '320900', '盐城市', '江苏省');
INSERT INTO `tbl_area` VALUES ('321000', '321000', '扬州市', '江苏省');
INSERT INTO `tbl_area` VALUES ('321100', '321100', '镇江市', '江苏省');
INSERT INTO `tbl_area` VALUES ('321200', '321200', '泰州市', '江苏省');
INSERT INTO `tbl_area` VALUES ('321300', '321300', '宿迁市', '江苏省');
INSERT INTO `tbl_area` VALUES ('329900', '329900', '其他地区', '江苏省');
INSERT INTO `tbl_area` VALUES ('330100', '330100', '杭州市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330200', '330200', '宁波市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330300', '330300', '温州市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330400', '330400', '嘉兴市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330500', '330500', '湖州市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330600', '330600', '绍兴市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330700', '330700', '金华市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330800', '330800', '衢州市', '浙江省');
INSERT INTO `tbl_area` VALUES ('330900', '330900', '舟山市', '浙江省');
INSERT INTO `tbl_area` VALUES ('331000', '331000', '台州市', '浙江省');
INSERT INTO `tbl_area` VALUES ('331100', '331100', '丽水市', '浙江省');
INSERT INTO `tbl_area` VALUES ('331200', '331200', '舟山群岛新区', '浙江省');
INSERT INTO `tbl_area` VALUES ('339900', '339900', '其他地区', '浙江省');
INSERT INTO `tbl_area` VALUES ('340100', '340100', '合肥市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340200', '340200', '芜湖市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340300', '340300', '蚌埠市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340400', '340400', '淮南市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340500', '340500', '马鞍山市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340600', '340600', '淮北市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340700', '340700', '铜陵市', '安徽省');
INSERT INTO `tbl_area` VALUES ('340800', '340800', '安庆市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341000', '341000', '黄山市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341100', '341100', '滁州市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341200', '341200', '阜阳市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341300', '341300', '宿州市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341500', '341500', '六安市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341600', '341600', '亳州市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341700', '341700', '池州市', '安徽省');
INSERT INTO `tbl_area` VALUES ('341800', '341800', '宣城市', '安徽省');
INSERT INTO `tbl_area` VALUES ('349900', '349900', '其他地区', '安徽省');
INSERT INTO `tbl_area` VALUES ('350100', '350100', '福州市', '福建省');
INSERT INTO `tbl_area` VALUES ('350200', '350200', '厦门市', '福建省');
INSERT INTO `tbl_area` VALUES ('350300', '350300', '莆田市', '福建省');
INSERT INTO `tbl_area` VALUES ('350400', '350400', '三明市', '福建省');
INSERT INTO `tbl_area` VALUES ('350500', '350500', '泉州市', '福建省');
INSERT INTO `tbl_area` VALUES ('350600', '350600', '漳州市', '福建省');
INSERT INTO `tbl_area` VALUES ('350700', '350700', '南平市', '福建省');
INSERT INTO `tbl_area` VALUES ('350800', '350800', '龙岩市', '福建省');
INSERT INTO `tbl_area` VALUES ('350900', '350900', '宁德市', '福建省');
INSERT INTO `tbl_area` VALUES ('359900', '359900', '其他地区', '福建省');
INSERT INTO `tbl_area` VALUES ('360100', '360100', '南昌市', '江西省');
INSERT INTO `tbl_area` VALUES ('360200', '360200', '景德镇市', '江西省');
INSERT INTO `tbl_area` VALUES ('360300', '360300', '萍乡市', '江西省');
INSERT INTO `tbl_area` VALUES ('360400', '360400', '九江市', '江西省');
INSERT INTO `tbl_area` VALUES ('360500', '360500', '新余市', '江西省');
INSERT INTO `tbl_area` VALUES ('360600', '360600', '鹰潭市', '江西省');
INSERT INTO `tbl_area` VALUES ('360700', '360700', '赣州市', '江西省');
INSERT INTO `tbl_area` VALUES ('360800', '360800', '吉安市', '江西省');
INSERT INTO `tbl_area` VALUES ('360900', '360900', '宜春市', '江西省');
INSERT INTO `tbl_area` VALUES ('361000', '361000', '抚州市', '江西省');
INSERT INTO `tbl_area` VALUES ('361100', '361100', '上饶市', '江西省');
INSERT INTO `tbl_area` VALUES ('369900', '369900', '其他地区', '江西省');
INSERT INTO `tbl_area` VALUES ('370100', '370100', '济南市', '山东省');
INSERT INTO `tbl_area` VALUES ('370200', '370200', '青岛市', '山东省');
INSERT INTO `tbl_area` VALUES ('370300', '370300', '淄博市', '山东省');
INSERT INTO `tbl_area` VALUES ('370400', '370400', '枣庄市', '山东省');
INSERT INTO `tbl_area` VALUES ('370500', '370500', '东营市', '山东省');
INSERT INTO `tbl_area` VALUES ('370600', '370600', '烟台市', '山东省');
INSERT INTO `tbl_area` VALUES ('370700', '370700', '潍坊市', '山东省');
INSERT INTO `tbl_area` VALUES ('370800', '370800', '济宁市', '山东省');
INSERT INTO `tbl_area` VALUES ('370900', '370900', '泰安市', '山东省');
INSERT INTO `tbl_area` VALUES ('371000', '371000', '威海市', '山东省');
INSERT INTO `tbl_area` VALUES ('371100', '371100', '日照市', '山东省');
INSERT INTO `tbl_area` VALUES ('371200', '371200', '莱芜市', '山东省');
INSERT INTO `tbl_area` VALUES ('371300', '371300', '临沂市', '山东省');
INSERT INTO `tbl_area` VALUES ('371400', '371400', '德州市', '山东省');
INSERT INTO `tbl_area` VALUES ('371500', '371500', '聊城市', '山东省');
INSERT INTO `tbl_area` VALUES ('371600', '371600', '滨州市', '山东省');
INSERT INTO `tbl_area` VALUES ('371700', '371700', '菏泽市', '山东省');
INSERT INTO `tbl_area` VALUES ('379900', '379900', '其他地区', '山东省');
INSERT INTO `tbl_area` VALUES ('410100', '410100', '郑州市', '河南省');
INSERT INTO `tbl_area` VALUES ('410200', '410200', '开封市', '河南省');
INSERT INTO `tbl_area` VALUES ('410300', '410300', '洛阳市', '河南省');
INSERT INTO `tbl_area` VALUES ('410400', '410400', '平顶山市', '河南省');
INSERT INTO `tbl_area` VALUES ('410500', '410500', '安阳市', '河南省');
INSERT INTO `tbl_area` VALUES ('410600', '410600', '鹤壁市', '河南省');
INSERT INTO `tbl_area` VALUES ('410700', '410700', '新乡市', '河南省');
INSERT INTO `tbl_area` VALUES ('410800', '410800', '焦作市', '河南省');
INSERT INTO `tbl_area` VALUES ('410900', '410900', '濮阳市', '河南省');
INSERT INTO `tbl_area` VALUES ('411000', '411000', '许昌市', '河南省');
INSERT INTO `tbl_area` VALUES ('411100', '411100', '漯河市', '河南省');
INSERT INTO `tbl_area` VALUES ('411200', '411200', '三门峡市', '河南省');
INSERT INTO `tbl_area` VALUES ('411300', '411300', '南阳市', '河南省');
INSERT INTO `tbl_area` VALUES ('411400', '411400', '商丘市', '河南省');
INSERT INTO `tbl_area` VALUES ('411500', '411500', '信阳市', '河南省');
INSERT INTO `tbl_area` VALUES ('411600', '411600', '周口市', '河南省');
INSERT INTO `tbl_area` VALUES ('411700', '411700', '驻马店市', '河南省');
INSERT INTO `tbl_area` VALUES ('419001', '419001', '济源市', '河南省');
INSERT INTO `tbl_area` VALUES ('419900', '419900', '其他地区', '河南省');
INSERT INTO `tbl_area` VALUES ('420100', '420100', '武汉市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420200', '420200', '黄石市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420300', '420300', '十堰市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420500', '420500', '宜昌市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420600', '420600', '襄阳市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420700', '420700', '鄂州市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420800', '420800', '荆门市', '湖北省');
INSERT INTO `tbl_area` VALUES ('420900', '420900', '孝感市', '湖北省');
INSERT INTO `tbl_area` VALUES ('421000', '421000', '荆州市', '湖北省');
INSERT INTO `tbl_area` VALUES ('421100', '421100', '黄冈市', '湖北省');
INSERT INTO `tbl_area` VALUES ('421200', '421200', '咸宁市', '湖北省');
INSERT INTO `tbl_area` VALUES ('421300', '421300', '随州市', '湖北省');
INSERT INTO `tbl_area` VALUES ('422800', '422800', '恩施土家族苗族自治州', '湖北省');
INSERT INTO `tbl_area` VALUES ('429004', '429004', '仙桃市', '湖北省');
INSERT INTO `tbl_area` VALUES ('429005', '429005', '潜江市', '湖北省');
INSERT INTO `tbl_area` VALUES ('429006', '429006', '天门市', '湖北省');
INSERT INTO `tbl_area` VALUES ('429021', '429021', '神农架林区', '湖北省');
INSERT INTO `tbl_area` VALUES ('429900', '429900', '其他地区', '湖北省');
INSERT INTO `tbl_area` VALUES ('430100', '430100', '长沙市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430200', '430200', '株洲市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430300', '430300', '湘潭市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430400', '430400', '衡阳市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430500', '430500', '邵阳市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430600', '430600', '岳阳市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430700', '430700', '常德市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430800', '430800', '张家界市', '湖南省');
INSERT INTO `tbl_area` VALUES ('430900', '430900', '益阳市', '湖南省');
INSERT INTO `tbl_area` VALUES ('431000', '431000', '郴州市', '湖南省');
INSERT INTO `tbl_area` VALUES ('431100', '431100', '永州市', '湖南省');
INSERT INTO `tbl_area` VALUES ('431200', '431200', '怀化市', '湖南省');
INSERT INTO `tbl_area` VALUES ('431300', '431300', '娄底市', '湖南省');
INSERT INTO `tbl_area` VALUES ('433100', '433100', '湘西土家族苗族自治州', '湖南省');
INSERT INTO `tbl_area` VALUES ('439900', '439900', '其他地区', '湖南省');
INSERT INTO `tbl_area` VALUES ('440100', '440100', '广州市', '广东省');
INSERT INTO `tbl_area` VALUES ('440200', '440200', '韶关市', '广东省');
INSERT INTO `tbl_area` VALUES ('440300', '440300', '深圳市', '广东省');
INSERT INTO `tbl_area` VALUES ('440400', '440400', '珠海市', '广东省');
INSERT INTO `tbl_area` VALUES ('440500', '440500', '汕头市', '广东省');
INSERT INTO `tbl_area` VALUES ('440600', '440600', '佛山市', '广东省');
INSERT INTO `tbl_area` VALUES ('440700', '440700', '江门市', '广东省');
INSERT INTO `tbl_area` VALUES ('440800', '440800', '湛江市', '广东省');
INSERT INTO `tbl_area` VALUES ('440900', '440900', '茂名市', '广东省');
INSERT INTO `tbl_area` VALUES ('441200', '441200', '肇庆市', '广东省');
INSERT INTO `tbl_area` VALUES ('441300', '441300', '惠州市', '广东省');
INSERT INTO `tbl_area` VALUES ('441400', '441400', '梅州市', '广东省');
INSERT INTO `tbl_area` VALUES ('441500', '441500', '汕尾市', '广东省');
INSERT INTO `tbl_area` VALUES ('441600', '441600', '河源市', '广东省');
INSERT INTO `tbl_area` VALUES ('441700', '441700', '阳江市', '广东省');
INSERT INTO `tbl_area` VALUES ('441800', '441800', '清远市', '广东省');
INSERT INTO `tbl_area` VALUES ('441900', '441900', '东莞市', '广东省');
INSERT INTO `tbl_area` VALUES ('442000', '442000', '中山市', '广东省');
INSERT INTO `tbl_area` VALUES ('445100', '445100', '潮州市', '广东省');
INSERT INTO `tbl_area` VALUES ('445200', '445200', '揭阳市', '广东省');
INSERT INTO `tbl_area` VALUES ('445300', '445300', '云浮市', '广东省');
INSERT INTO `tbl_area` VALUES ('449900', '449900', '其他地区', '广东省');
INSERT INTO `tbl_area` VALUES ('450100', '450100', '南宁市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450200', '450200', '柳州市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450300', '450300', '桂林市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450400', '450400', '梧州市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450500', '450500', '北海市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450600', '450600', '防城港市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450700', '450700', '钦州市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450800', '450800', '贵港市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('450900', '450900', '玉林市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('451000', '451000', '百色市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('451100', '451100', '贺州市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('451200', '451200', '河池市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('451300', '451300', '来宾市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('451400', '451400', '崇左市', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('459900', '459900', '其他地区', '广西壮族自治区');
INSERT INTO `tbl_area` VALUES ('460100', '460100', '海口市', '海南省');
INSERT INTO `tbl_area` VALUES ('460200', '460200', '三亚市', '海南省');
INSERT INTO `tbl_area` VALUES ('460300', '460300', '三沙市', '海南省');
INSERT INTO `tbl_area` VALUES ('460400', '460400', '儋州市', '海南省');
INSERT INTO `tbl_area` VALUES ('469001', '469001', '五指山市', '海南省');
INSERT INTO `tbl_area` VALUES ('469002', '469002', '琼海市', '海南省');
INSERT INTO `tbl_area` VALUES ('469005', '469005', '文昌市', '海南省');
INSERT INTO `tbl_area` VALUES ('469006', '469006', '万宁市', '海南省');
INSERT INTO `tbl_area` VALUES ('469007', '469007', '东方市', '海南省');
INSERT INTO `tbl_area` VALUES ('469021', '469021', '定安县', '海南省');
INSERT INTO `tbl_area` VALUES ('469022', '469022', '屯昌县', '海南省');
INSERT INTO `tbl_area` VALUES ('469023', '469023', '澄迈县', '海南省');
INSERT INTO `tbl_area` VALUES ('469024', '469024', '临高县', '海南省');
INSERT INTO `tbl_area` VALUES ('469025', '469025', '白沙黎族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469026', '469026', '昌江黎族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469027', '469027', '乐东黎族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469028', '469028', '陵水黎族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469029', '469029', '保亭黎族苗族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469030', '469030', '琼中黎族苗族自治县', '海南省');
INSERT INTO `tbl_area` VALUES ('469900', '469900', '其他地区', '海南省');
INSERT INTO `tbl_area` VALUES ('500100', '500100', '重庆市', '重庆');
INSERT INTO `tbl_area` VALUES ('510100', '510100', '成都市', '四川省');
INSERT INTO `tbl_area` VALUES ('510300', '510300', '自贡市', '四川省');
INSERT INTO `tbl_area` VALUES ('510400', '510400', '攀枝花市', '四川省');
INSERT INTO `tbl_area` VALUES ('510500', '510500', '泸州市', '四川省');
INSERT INTO `tbl_area` VALUES ('510600', '510600', '德阳市', '四川省');
INSERT INTO `tbl_area` VALUES ('510700', '510700', '绵阳市', '四川省');
INSERT INTO `tbl_area` VALUES ('510800', '510800', '广元市', '四川省');
INSERT INTO `tbl_area` VALUES ('510900', '510900', '遂宁市', '四川省');
INSERT INTO `tbl_area` VALUES ('511000', '511000', '内江市', '四川省');
INSERT INTO `tbl_area` VALUES ('511100', '511100', '乐山市', '四川省');
INSERT INTO `tbl_area` VALUES ('511300', '511300', '南充市', '四川省');
INSERT INTO `tbl_area` VALUES ('511400', '511400', '眉山市', '四川省');
INSERT INTO `tbl_area` VALUES ('511500', '511500', '宜宾市', '四川省');
INSERT INTO `tbl_area` VALUES ('511600', '511600', '广安市', '四川省');
INSERT INTO `tbl_area` VALUES ('511700', '511700', '达州市', '四川省');
INSERT INTO `tbl_area` VALUES ('511800', '511800', '雅安市', '四川省');
INSERT INTO `tbl_area` VALUES ('511900', '511900', '巴中市', '四川省');
INSERT INTO `tbl_area` VALUES ('512000', '512000', '资阳市', '四川省');
INSERT INTO `tbl_area` VALUES ('513200', '513200', '阿坝藏族羌族自治州', '四川省');
INSERT INTO `tbl_area` VALUES ('513300', '513300', '甘孜藏族自治州', '四川省');
INSERT INTO `tbl_area` VALUES ('513400', '513400', '凉山彝族自治州', '四川省');
INSERT INTO `tbl_area` VALUES ('519900', '519900', '其他地区', '四川省');
INSERT INTO `tbl_area` VALUES ('520100', '520100', '贵阳市', '贵州省');
INSERT INTO `tbl_area` VALUES ('520200', '520200', '六盘水市', '贵州省');
INSERT INTO `tbl_area` VALUES ('520300', '520300', '遵义市', '贵州省');
INSERT INTO `tbl_area` VALUES ('520400', '520400', '安顺市', '贵州省');
INSERT INTO `tbl_area` VALUES ('520500', '520500', '毕节市', '贵州省');
INSERT INTO `tbl_area` VALUES ('520600', '520600', '铜仁市', '贵州省');
INSERT INTO `tbl_area` VALUES ('522300', '522300', '黔西南布依族苗族自治州', '贵州省');
INSERT INTO `tbl_area` VALUES ('522600', '522600', '黔东南苗族侗族自治州', '贵州省');
INSERT INTO `tbl_area` VALUES ('522700', '522700', '黔南布依族苗族自治州', '贵州省');
INSERT INTO `tbl_area` VALUES ('529900', '529900', '其他地区', '贵州省');
INSERT INTO `tbl_area` VALUES ('530100', '530100', '昆明市', '云南省');
INSERT INTO `tbl_area` VALUES ('530300', '530300', '曲靖市', '云南省');
INSERT INTO `tbl_area` VALUES ('530400', '530400', '玉溪市', '云南省');
INSERT INTO `tbl_area` VALUES ('530500', '530500', '保山市', '云南省');
INSERT INTO `tbl_area` VALUES ('530600', '530600', '昭通市', '云南省');
INSERT INTO `tbl_area` VALUES ('530700', '530700', '丽江市', '云南省');
INSERT INTO `tbl_area` VALUES ('530800', '530800', '普洱市', '云南省');
INSERT INTO `tbl_area` VALUES ('530900', '530900', '临沧市', '云南省');
INSERT INTO `tbl_area` VALUES ('532300', '532300', '楚雄彝族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('532500', '532500', '红河哈尼族彝族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('532600', '532600', '文山壮族苗族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('532800', '532800', '西双版纳傣族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('532900', '532900', '大理白族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('533100', '533100', '德宏傣族景颇族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('533300', '533300', '怒江傈僳族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('533400', '533400', '迪庆藏族自治州', '云南省');
INSERT INTO `tbl_area` VALUES ('539900', '539900', '其他地区', '云南省');
INSERT INTO `tbl_area` VALUES ('540100', '540100', '拉萨市', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('540200', '540200', '日喀则市', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('540300', '540300', '昌都市', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('540400', '540400', '林芝市', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('540500', '540500', '山南市', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('542400', '542400', '那曲地区', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('542500', '542500', '阿里地区', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('549900', '549900', '其他地区', '西藏自治区');
INSERT INTO `tbl_area` VALUES ('610100', '610100', '西安市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610200', '610200', '铜川市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610300', '610300', '宝鸡市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610400', '610400', '咸阳市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610500', '610500', '渭南市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610600', '610600', '延安市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610700', '610700', '汉中市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610800', '610800', '榆林市', '陕西省');
INSERT INTO `tbl_area` VALUES ('610900', '610900', '安康市', '陕西省');
INSERT INTO `tbl_area` VALUES ('611000', '611000', '商洛市', '陕西省');
INSERT INTO `tbl_area` VALUES ('611100', '611100', '西咸新区', '陕西省');
INSERT INTO `tbl_area` VALUES ('619900', '619900', '其他地区', '陕西省');
INSERT INTO `tbl_area` VALUES ('620100', '620100', '兰州市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620200', '620200', '嘉峪关市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620300', '620300', '金昌市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620400', '620400', '白银市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620500', '620500', '天水市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620600', '620600', '武威市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620700', '620700', '张掖市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620800', '620800', '平凉市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('620900', '620900', '酒泉市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('621000', '621000', '庆阳市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('621100', '621100', '定西市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('621200', '621200', '陇南市', '甘肃省');
INSERT INTO `tbl_area` VALUES ('622900', '622900', '临夏回族自治州', '甘肃省');
INSERT INTO `tbl_area` VALUES ('623000', '623000', '甘南藏族自治州', '甘肃省');
INSERT INTO `tbl_area` VALUES ('629900', '629900', '其他地区', '甘肃省');
INSERT INTO `tbl_area` VALUES ('630100', '630100', '西宁市', '青海省');
INSERT INTO `tbl_area` VALUES ('630200', '630200', '海东市', '青海省');
INSERT INTO `tbl_area` VALUES ('632200', '632200', '海北藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('632300', '632300', '黄南藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('632500', '632500', '海南藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('632600', '632600', '果洛藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('632700', '632700', '玉树藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('632800', '632800', '海西蒙古族藏族自治州', '青海省');
INSERT INTO `tbl_area` VALUES ('639900', '639900', '其他地区', '青海省');
INSERT INTO `tbl_area` VALUES ('640100', '640100', '银川市', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('640200', '640200', '石嘴山市', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('640300', '640300', '吴忠市', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('640400', '640400', '固原市', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('640500', '640500', '中卫市', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('649900', '649900', '其他地区', '宁夏回族自治区');
INSERT INTO `tbl_area` VALUES ('650100', '650100', '乌鲁木齐市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('650200', '650200', '克拉玛依市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('650400', '650400', '吐鲁番市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('650500', '650500', '哈密市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('652300', '652300', '昌吉回族自治州', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('652700', '652700', '博尔塔拉蒙古自治州', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('652800', '652800', '巴音郭楞蒙古自治州', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('652900', '652900', '阿克苏地区', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('653000', '653000', '克孜勒苏柯尔克孜自治州', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('653100', '653100', '喀什地区', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('653200', '653200', '和田地区', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('654000', '654000', '伊犁哈萨克自治州', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('654200', '654200', '塔城地区', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('654300', '654300', '阿勒泰地区', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659001', '659001', '石河子市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659002', '659002', '阿拉尔市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659003', '659003', '图木舒克市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659004', '659004', '五家渠市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659005', '659005', '北屯市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659006', '659006', '铁门关市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659007', '659007', '双河市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659008', '659008', '可克达拉市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659009', '659009', '昆玉市', '新疆维吾尔自治区');
INSERT INTO `tbl_area` VALUES ('659900', '659900', '其他地区', '新疆维吾尔自治区');

-- ----------------------------
-- Table structure for tbl_car_system
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
  `insert_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_car_system
-- ----------------------------
INSERT INTO `tbl_car_system` VALUES ('1', '大众', '1', '一汽-大众', '8', '捷达', '16', '0', '2019-03-22 19:06:24');
INSERT INTO `tbl_car_system` VALUES ('10', '宝马', '15', '华晨宝马', '29', '宝马3系', '66', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('100', '丰田', '3', '一汽丰田', '40', '卡罗拉', '526', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('1000', '依维柯', '144', '南京依维柯', '329', '依维柯Daily(欧胜)', '4580', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('101', '大众', '1', '上汽大众', '58', '帕萨特', '528', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('102', '铃木', '53', '长安铃木', '35', '天语 SX4', '529', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('103', '奥迪', '33', '奥迪(进口)', '79', '奥迪A5', '538', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('104', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'GranTurismo', '551', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('105', '名爵', '20', '上汽集团', '159', '名爵3SW', '555', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('106', '大众', '1', '大众(进口)', '50', 'Tiguan', '557', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('107', '日产', '63', '东风日产', '92', '逍客', '564', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('108', '比亚迪', '75', '比亚迪', '146', '比亚迪F0', '579', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('109', '三菱', '68', '三菱(进口)', '128', '帕杰罗(进口)', '580', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('11', '路虎', '49', '路虎(进口)', '49', '揽胜', '69', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('110', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '阿斯顿·马丁DBS', '582', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('111', '现代', '12', '北京现代', '27', '悦动', '586', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('112', '宝马', '15', '宝马(进口)', '80', '宝马X6', '587', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('113', '奔驰', '36', '北京奔驰', '152', '奔驰C级', '588', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('114', '捷豹', '44', '捷豹', '85', '捷豹XF', '589', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('115', '起亚', '62', '起亚(进口)', '111', '霸锐', '591', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('116', '道奇', '41', '道奇(进口)', '175', '酷威', '602', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('117', '东南', '81', '东南汽车', '51', 'V3菱悦', '606', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('118', '大众', '1', '上汽大众', '58', '朗逸', '614', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('119', 'smart', '45', 'smart', '187', 'smart fortwo', '620', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('12', '铃木', '53', '昌河铃木', '31', '北斗星', '75', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('120', '北汽制造', '154', '北京汽车制造厂', '185', '勇士', '622', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('121', '北京', '27', '北京汽车', '312', '北京BJ40', '623', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('122', '大众', '1', '大众(进口)', '50', '迈特威', '631', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('123', '奔腾', '95', '一汽奔腾', '10', '奔腾B50', '632', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('124', '大众', '1', '一汽-大众', '8', '宝来', '633', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('125', '日产', '63', '东风日产', '92', '天籁', '634', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('126', '日产', '63', '东风日产', '92', '奇骏', '656', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('127', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科鲁兹', '657', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('128', '马自达', '58', '马自达(进口)', '119', '马自达MX-5', '672', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('129', '雪佛兰', '71', '雪佛兰(进口)', '142', '科迈罗', '678', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('13', '本田', '14', '广汽本田', '32', '雅阁', '78', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('130', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A4L', '692', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('131', '日产', '63', '日产(进口)', '73', '日产370Z', '702', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('132', '保时捷', '40', '保时捷', '81', 'Panamera', '703', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('133', '福特', '8', '福特(进口)', '61', '福克斯(进口)', '704', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('134', '长安', '76', '长安汽车', '160', '悦翔', '705', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('135', '奥迪', '33', '奥迪(进口)', '79', '奥迪A7', '740', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('136', 'MINI', '56', 'MINI', '143', 'MINI CLUBMAN', '749', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('137', 'MINI', '56', 'MINI', '143', 'MINI COUNTRYMAN', '750', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('138', '路虎', '49', '路虎(进口)', '49', '揽胜极光(进口)', '754', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('139', '林肯', '51', '林肯', '56', '林肯MKX', '758', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('14', '本田', '14', '广汽本田', '32', '飞度', '81', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('140', '丰田', '3', '一汽丰田', '40', 'RAV4荣放', '770', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('141', '丰田', '3', '广汽丰田', '155', '汉兰达', '771', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('142', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C5', '792', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('143', '林肯', '51', '林肯', '56', '林肯MKZ', '793', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('144', '比亚迪', '75', '比亚迪', '146', '比亚迪M6', '798', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('145', '路虎', '49', '路虎(进口)', '49', '发现', '802', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('146', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪Q5', '812', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('147', '起亚', '62', '东风悦达起亚', '57', '福瑞迪', '813', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('148', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'V12 Vantage', '822', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('149', '比亚迪', '75', '比亚迪', '146', '比亚迪e6', '831', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('15', '大众', '1', '大众(进口)', '50', '途锐', '82', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('150', '陆风', '88', '陆风汽车', '158', '陆风X8', '833', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('151', '别克', '38', '上汽通用别克', '93', '君越', '834', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('152', '名爵', '20', '上汽集团', '159', '名爵6', '835', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('153', '劳斯莱斯', '54', '劳斯莱斯', '107', '古思特', '836', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('154', '路虎', '49', '路虎(进口)', '49', '揽胜运动版', '850', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('155', '本田', '14', '东风本田', '151', '思铂睿', '859', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('156', '大众', '1', '一汽-大众', '8', '高尔夫', '871', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('157', '铃木', '53', '长安铃木', '35', '奥拓', '872', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('158', '大众', '1', '上汽大众', '58', '途观', '874', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('159', '别克', '38', '上汽通用别克', '93', '凯越', '875', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('16', '大众', '1', '大众(进口)', '50', '夏朗', '86', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('160', '标致', '13', '东风标致', '38', '标致308', '877', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('161', '一汽', '110', '天津一汽', '39', '夏利N5', '878', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('162', '本田', '14', '广汽本田', '32', '奥德赛', '880', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('163', '丰田', '3', '一汽丰田', '40', '皇冠', '882', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('164', '讴歌', '60', '讴歌(进口)', '157', '讴歌RDX(进口)', '888', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('165', '宾利', '39', '宾利', '120', '慕尚', '901', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('166', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'GranCabrio', '903', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('167', '大众', '1', '一汽-大众', '8', '一汽-大众CC', '905', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('168', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'Rapide', '923', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('169', 'GMC', '112', 'GMC', '207', 'YUKON', '947', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('17', '林肯', '51', '林肯', '56', '领航员', '95', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('170', '东风', '32', '郑州日产', '173', '帅客', '951', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('171', '北汽制造', '154', '北京汽车制造厂', '185', '战旗', '965', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('172', '北汽制造', '154', '北京汽车制造厂', '185', '陆霸', '966', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('173', 'GMC', '112', 'GMC', '207', 'SAVANA', '980', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('174', '别克', '38', '上汽通用别克', '93', '英朗', '982', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('175', '标致', '13', '东风标致', '38', '标致408', '987', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('176', 'smart', '45', 'smart', '187', 'smart forfour', '1004', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('177', '现代', '12', '北京现代', '27', '北京现代ix35', '1007', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('178', '福特', '8', '福特(进口)', '61', '探险者', '2024', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('179', '哈弗', '181', '长城汽车', '4', '哈弗H5', '2027', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('18', '雪铁龙', '72', '东风雪铁龙', '37', '爱丽舍', '98', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('180', '雷诺', '10', '雷诺(进口)', '89', 'Espace', '2029', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('181', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯CT', '2063', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('182', '奔驰', '36', '福建奔驰', '301', '威霆', '2084', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('183', '日产', '63', '东风日产', '92', '玛驰', '2086', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('184', '丰田', '3', '丰田(进口)', '63', '埃尔法', '2107', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('185', '日产', '63', '郑州日产', '173', '日产NV200', '2113', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('186', '现代', '12', '北京现代', '27', '瑞纳', '2115', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('187', '现代', '12', '现代(进口)', '74', 'H-1辉翼', '2117', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('188', '哈弗', '181', '长城汽车', '4', '哈弗H6', '2123', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('189', '哈弗', '181', '长城汽车', '4', '哈弗H8', '2124', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('19', '福特', '8', '福特(进口)', '61', 'Mustang', '102', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('190', '北汽制造', '154', '北京汽车制造厂', '185', '北京BW007', '2126', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('191', '力帆汽车', '80', '力帆汽车', '154', '力帆X60', '2134', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('192', '起亚', '62', '东风悦达起亚', '57', '智跑', '2137', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('193', '五菱汽车', '114', '上汽通用五菱', '59', '五菱宏光', '2139', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('194', '华泰', '87', '华泰汽车', '117', '宝利格', '2144', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('195', '名爵', '20', '上汽集团', '159', '名爵3', '2147', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('196', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V60', '2190', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('197', '宝马', '15', '宝马M', '345', '宝马M3', '2196', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('198', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰S级AMG', '2197', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('199', '克莱斯勒', '9', '克莱斯勒(进口)', '69', '大捷龙(进口)', '2207', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('2', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A6L', '18', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('20', '丰田', '3', '丰田(进口)', '63', '普瑞维亚', '107', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('200', '驭胜', '263', '江铃汽车', '307', '驭胜S350', '2228', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('201', '起亚', '62', '东风悦达起亚', '57', '起亚K5', '2246', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('202', '现代', '12', '现代(进口)', '74', 'Veloster飞思', '2256', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('203', '帕加尼', '61', '帕加尼', '140', 'Huayra', '2263', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('204', '雷诺', '10', '雷诺(进口)', '89', '卡缤', '2268', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('205', '兰博基尼', '48', '兰博基尼', '83', 'Aventador', '2277', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('206', '中华', '22', '华晨中华', '53', '中华V5', '2294', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('207', '标致', '13', '东风标致', '38', '标致508', '2299', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('208', '奔腾', '95', '一汽奔腾', '10', '奔腾B90', '2310', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('209', '雪佛兰', '71', '上汽通用雪佛兰', '139', '迈锐宝', '2313', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('21', '丰田', '3', '广汽丰田', '155', '凯美瑞', '110', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('210', '起亚', '62', '东风悦达起亚', '57', '起亚K2', '2319', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('211', '中华', '22', '华晨中华', '53', '中华H530', '2323', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('212', '众泰', '94', '众泰汽车', '171', '众泰T300', '2333', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('213', '众泰', '94', '众泰汽车', '171', '众泰T600', '2334', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('214', '福特', '8', '福特(进口)', '61', '福特F-150', '2353', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('215', 'GMC', '112', 'GMC', '207', 'SIERRA', '2355', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('216', '特斯拉', '133', '特斯拉', '318', 'Model S', '2357', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('217', '雪佛兰', '71', '雪佛兰(进口)', '142', '库罗德', '2362', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('218', '日产', '63', '东风日产', '92', '楼兰', '2381', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('219', '宝马', '15', '宝马(进口)', '80', '宝马i8', '2387', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('22', '丰田', '3', '一汽丰田', '40', '威驰', '111', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('220', '宝马', '15', '宝马(进口)', '80', '宝马i3', '2388', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('221', '雪佛兰', '71', '雪佛兰(进口)', '142', '索罗德', '2405', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('222', '斯巴鲁', '65', '斯巴鲁', '116', '斯巴鲁XV', '2417', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('223', '起亚', '62', '起亚(进口)', '111', '斯汀格', '2420', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('224', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'Levante', '2428', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('225', '长安', '76', '长安汽车', '160', '逸动', '2429', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('226', '巴博斯', '140', '巴博斯', '326', '巴博斯 SLK级', '2446', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('227', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光', '2451', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('228', '东风小康', '142', '东风小康', '327', '东风小康K01', '2452', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('229', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光', '2456', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('23', '福特', '8', '长安福特', '43', '蒙迪欧', '117', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('230', '长城', '77', '长城汽车', '4', '风骏5', '2462', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('231', '一汽', '110', '一汽吉林', '166', '佳宝T57', '2465', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('232', '日产', '63', '郑州日产', '173', '日产D22', '2466', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('233', '一汽', '110', '一汽吉林', '166', '佳宝V55', '2468', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('234', '一汽', '110', '一汽吉林', '166', '佳宝V52', '2469', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('235', '开瑞', '101', '开瑞汽车', '208', '优优', '2476', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('236', '众泰', '94', '众泰汽车', '171', '众泰V10', '2480', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('237', '北汽威旺', '143', '北京汽车', '312', '北汽威旺306', '2482', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('238', '广汽吉奥', '108', '广汽吉奥', '203', '星旺', '2488', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('239', '开瑞', '101', '开瑞汽车', '208', '优劲', '2496', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('24', 'Jeep', '46', 'Jeep(进口)', '71', '牧马人', '121', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('240', '东风小康', '142', '东风小康', '327', '东风小康K02', '2497', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('241', '力帆汽车', '80', '力帆汽车', '154', '兴顺', '2502', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('242', '力帆汽车', '80', '力帆汽车', '154', '丰顺', '2503', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('243', '五菱汽车', '114', '上汽通用五菱', '59', 'PN货车', '2506', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('244', '东风', '32', '郑州日产', '173', '锐骐皮卡', '2510', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('245', '东风', '32', '郑州日产', '173', '锐骐多功能车', '2512', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('246', '江铃', '119', '江铃汽车', '307', '宝典', '2514', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('247', '黄海', '97', '曙光汽车', '191', '大柴神', '2515', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('248', '黄海', '97', '曙光汽车', '191', '小柴神', '2516', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('249', '黄海', '97', '曙光汽车', '191', '傲骏', '2517', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('25', '本田', '14', '东风本田', '151', '思域', '135', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('250', '中兴', '74', '中兴汽车', '189', '威虎', '2519', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('251', '福特', '8', '江铃福特', '447', '新世代全顺', '2524', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('252', '一汽', '110', '一汽吉林', '166', '佳宝T51', '2525', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('253', '一汽', '110', '一汽吉林', '166', '佳宝T50', '2526', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('254', '丰田', '3', '一汽丰田', '40', '柯斯达', '2527', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('255', '依维柯', '144', '南京依维柯', '329', '依维柯得意', '2532', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('256', '依维柯', '144', '南京依维柯', '329', '依维柯褒迪Power Daily', '2533', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('257', '福田', '96', '福田汽车', '188', '福田风景', '2535', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('258', '金杯', '83', '华晨雷诺', '169', '阁瑞斯', '2537', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('259', '威麟', '102', '奇瑞万达客车', '502', '威麟H5', '2539', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('26', '双龙', '69', '双龙汽车', '76', '雷斯特', '139', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('260', '东风风行', '165', '东风风行', '164', '菱智', '2540', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('261', '江淮', '84', '江淮汽车', '170', '瑞风', '2541', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('262', '福田', '96', '福田汽车', '188', '蒙派克E', '2542', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('263', '江淮', '84', '江淮汽车', '170', '瑞风M5', '2543', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('264', '金杯', '83', '华晨雷诺', '169', '金杯大海狮', '2545', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('265', '东风风神', '113', '东风乘用车', '210', '东风风神A60', '2556', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('266', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS5', '2560', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('267', '宝马', '15', '华晨宝马', '29', '宝马X1', '2561', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('268', '奔驰', '36', '福建奔驰', '301', '凌特', '2564', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('269', '本田', '14', '东风本田', '151', '艾力绅', '2565', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('27', '大众', '1', '上汽大众', '58', 'Polo', '145', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('270', '长安欧尚', '163', '长安汽车', '160', '欧诺', '2566', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('271', '长安', '76', '长安汽车', '160', '悦翔V3', '2567', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('272', '广汽吉奥', '108', '广汽吉奥', '203', '财运500', '2568', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('273', '江淮', '84', '江淮汽车', '170', '星锐', '2569', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('274', '陕汽通家', '149', '陕汽通家', '333', '福家', '2570', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('275', '广汽吉奥', '108', '广汽吉奥', '203', '财运300', '2571', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('276', '海格', '150', '苏州金龙', '334', '海格H5C', '2572', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('277', '九龙', '151', '九龙汽车', '335', '九龙A5', '2573', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('278', '九龙', '151', '九龙汽车', '335', '九龙A6', '2576', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('279', '福田', '96', '福田汽车', '188', '拓陆者', '2577', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('28', '奥迪', '33', '奥迪(进口)', '79', '奥迪A8', '146', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('280', '日产', '63', '日产(进口)', '73', '碧莲', '2578', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('281', '福田', '96', '福田汽车', '188', '萨普', '2579', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('282', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科帕奇', '2583', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('283', '广汽吉奥', '108', '广汽吉奥', '203', '财运100', '2599', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('284', '一汽', '110', '一汽通用', '338', '坤程', '2603', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('285', '丰田', '3', '丰田(进口)', '63', 'HIACE', '2607', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('286', '上汽大通', '155', '上汽大通', '356', '上汽大通V80', '2608', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('287', '卡尔森', '156', '卡尔森', '339', '卡尔森 S级', '2611', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('288', '哈弗', '181', '长城汽车', '4', '哈弗H2', '2615', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('289', '标致', '13', '东风标致', '38', '标致3008', '2619', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('29', '奥迪', '33', '奥迪(进口)', '79', '奥迪TT', '148', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('290', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LC', '2623', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('291', '讴歌', '60', '讴歌(进口)', '157', '讴歌NSX', '2641', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('292', '金杯', '83', '绵阳金杯', '417', '大力神', '2659', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('293', '金杯', '83', '绵阳金杯', '417', '金典', '2660', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('294', '特斯拉', '133', '特斯拉', '318', 'Model X', '2664', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('295', '海格', '150', '苏州金龙', '334', '御骏', '2673', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('296', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V40', '2678', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('297', '法拉利', '42', '法拉利', '78', 'F12berlinetta', '2682', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('298', '巴博斯', '140', '巴博斯', '326', '巴博斯 smart fortwo', '2683', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('299', '宾利', '39', '宾利', '120', '添越', '2685', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('3', '丰田', '3', '一汽丰田', '40', '普拉多', '46', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('30', '宝马', '15', '宝马(进口)', '80', '宝马7系', '153', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('300', '福特', '8', '福特(进口)', '61', 'Ranger', '2707', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('301', '金杯', '83', '华晨鑫源', '409', '海星T20', '2712', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('302', '一汽', '110', '天津一汽', '39', '威志V5', '2716', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('303', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰C级AMG', '2717', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('304', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰E级AMG', '2718', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('305', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰CLS级AMG', '2719', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('306', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰G级AMG', '2723', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('307', '宝马', '15', '宝马M', '345', '宝马M5', '2726', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('308', '宝马', '15', '宝马M', '345', '宝马M6', '2727', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('309', '宝马', '15', '宝马M', '345', '宝马X5 M', '2728', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('31', '宝马', '15', '宝马(进口)', '80', '宝马X5', '159', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('310', '宝马', '15', '宝马M', '345', '宝马X6 M', '2729', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('311', '奥迪', '33', '奥迪(进口)', '79', '奥迪S3', '2730', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('312', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 3', '2731', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('313', '奥迪', '33', '奥迪(进口)', '79', '奥迪S4', '2732', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('314', '奥迪', '33', '奥迪(进口)', '79', '奥迪S5', '2734', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('315', '奥迪', '33', '奥迪(进口)', '79', '奥迪S6', '2736', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('316', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 6', '2737', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('317', '奥迪', '33', '奥迪(进口)', '79', '奥迪S7', '2738', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('318', '奥迪', '33', '奥迪(进口)', '79', '奥迪TTS', '2740', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('319', '奥迪', '33', 'Audi Sport', '346', '奥迪TT RS', '2741', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('32', '保时捷', '40', '保时捷', '81', '保时捷911', '162', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('320', '荣威', '19', '上汽集团', '159', '荣威950', '2743', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('321', '江淮', '84', '江淮汽车', '170', '瑞风S5', '2752', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('322', '恒天', '164', '恒天汽车', '349', '途腾T1', '2754', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('323', '恒天', '164', '恒天汽车', '349', '途腾T2', '2755', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('324', '比亚迪', '75', '比亚迪', '146', '秦', '2761', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('325', '现代', '12', '北京现代', '27', '朗动', '2764', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('326', '海马', '86', '一汽海马', '26', '海马M8', '2766', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('327', '菲亚特', '11', '广汽菲克菲亚特', '427', '菲翔', '2767', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('328', '三菱', '68', '广汽三菱', '355', '劲炫ASX', '2768', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('329', '东南', '81', '东南汽车', '51', 'V5菱致', '2769', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('33', '雪佛兰', '71', '上汽通用雪佛兰', '139', '赛欧', '163', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('330', '红旗', '91', '一汽红旗', '190', '红旗H7', '2771', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('331', '兰博基尼', '48', '兰博基尼', '83', 'Urus', '2775', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('332', '长安', '76', '长安汽车', '160', '长安CS35', '2778', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('333', '一汽', '110', '天津一汽', '39', '夏利N7', '2781', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('334', '长安', '76', '长安汽车', '160', '睿骋', '2785', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('335', '北汽绅宝', '173', '北京汽车', '312', '绅宝D70', '2787', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('336', '北汽绅宝', '173', '北京汽车', '312', '绅宝D50', '2791', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('337', '力帆汽车', '80', '力帆汽车', '154', '福顺', '2800', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('338', '腾势', '161', '腾势汽车', '347', '腾势', '2805', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('339', '比亚迪', '75', '比亚迪', '146', '速锐', '2806', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('34', '别克', '38', '上汽通用别克', '93', '君威', '164', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('340', '金杯', '83', '华晨雷诺', '169', '金杯海狮', '2810', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('341', '永源', '93', '永源汽车', '150', '永源五星', '2828', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('342', '五十铃', '167', '庆铃汽车', '350', '五十铃皮卡', '2834', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('343', '摩根', '168', '摩根', '351', '摩根Aero', '2835', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('344', '摩根', '168', '摩根', '351', '摩根Plus 8', '2836', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('345', '金杯', '83', '华晨鑫源', '409', '海星T22', '2837', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('346', '保时捷', '40', '保时捷', '81', 'Macan', '2838', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('347', '东风', '32', '东风汽车', '172', '御风', '2839', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('348', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰A级AMG', '2842', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('349', '北京', '27', '北京汽车', '312', '北京BJ80', '2852', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('35', '别克', '38', '上汽通用别克', '93', '别克GL8', '166', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('350', '日产', '63', '郑州日产', '173', '日产ZN厢式车', '2853', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('351', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光小卡', '2855', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('352', '江铃', '119', '江铃汽车', '307', '域虎7', '2860', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('353', '福特', '8', '长安福特', '43', '翼虎', '2863', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('354', '东风小康', '142', '东风小康', '327', '东风小康C37', '2865', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('355', '福特', '8', '长安福特', '43', '翼搏', '2871', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('356', '陆风', '88', '陆风汽车', '158', '陆风X5', '2883', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('357', '广汽吉奥', '108', '广汽吉奥', '203', '星旺CL', '2885', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('358', '起亚', '62', '东风悦达起亚', '57', '起亚K3', '2886', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('359', '野马汽车', '111', '野马汽车', '206', '野马T70', '2888', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('36', '保时捷', '40', '保时捷', '81', 'Cayenne', '172', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('360', '福迪', '141', '福迪汽车', '328', '雄师F16', '2895', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('361', '别克', '38', '上汽通用别克', '93', '昂科拉', '2896', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('362', '捷豹', '44', '捷豹', '85', '捷豹F-TYPE', '2903', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('363', '北汽制造', '154', '北京汽车制造厂', '185', '锐铃', '2915', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('364', '大众', '1', '上汽大众', '58', '桑塔纳', '2922', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('365', '长安轻型车', '294', '长安轻型车', '397', '神骐T20', '2923', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('366', '现代', '12', '北京现代', '27', '胜达', '2927', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('367', '海马', '86', '海马汽车', '341', '海马M3', '2941', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('368', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C4L', '2945', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('369', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克XTS', '2949', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('37', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃XC90', '177', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('370', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪Q3', '2951', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('371', 'DS', '169', '长安标致雪铁龙', '357', 'DS 5', '2952', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('372', '北汽制造', '154', '北京汽车制造厂', '185', '越铃', '2960', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('373', '斯柯达', '67', '上汽斯柯达', '162', '昕锐', '2962', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('374', '宝马', '15', '宝马(进口)', '80', '宝马3系GT', '2963', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('375', '奔驰', '36', '奔驰(进口)', '47', '奔驰CLA级', '2966', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('376', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰CLA级AMG', '2967', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('377', '宝马', '15', '宝马(进口)', '80', '宝马4系', '2968', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('378', '如虎', '174', '如虎', '358', '如虎 CTR 3', '2970', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('379', '如虎', '174', '如虎', '358', '如虎 XL', '2972', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('38', '捷豹', '44', '捷豹', '85', '捷豹XJ', '178', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('380', '恒天', '164', '恒天汽车', '349', '途腾T3', '2973', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('381', '观致', '152', '观致汽车', '336', '观致3', '2974', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('382', '金旅', '175', '厦门金旅', '359', '金旅海狮', '2976', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('383', '奇瑞', '26', '奇瑞汽车', '33', '艾瑞泽7', '2980', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('384', '金龙', '145', '厦门金龙', '330', '凯歌', '2985', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('385', '金龙', '145', '厦门金龙', '330', '金威', '2986', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('386', '马自达', '58', '长安马自达', '176', '马自达CX-5', '2987', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('387', '纳智捷', '130', '东风裕隆', '315', '纳5', '2988', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('388', '奇瑞', '26', '奇瑞汽车', '33', '奇瑞QQ', '2989', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('389', '东风风行', '165', '东风风行', '164', '风行CM7', '2990', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('39', '奔驰', '36', '北京奔驰', '152', '奔驰E级', '197', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('390', '林肯', '51', '林肯', '56', '林肯MKC', '2991', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('391', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q50', '2992', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('392', '奥迪', '33', 'Audi Sport', '346', '奥迪RS 7', '2994', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('393', '奔腾', '95', '一汽奔腾', '10', '奔腾X80', '3000', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('394', '海马', '86', '海马汽车', '341', '海马M6', '3006', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('395', '三菱', '68', '广汽三菱', '355', '帕杰罗·劲畅', '3008', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('396', '宾利', '39', '宾利', '120', '飞驰', '3014', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('397', '劳斯莱斯', '54', '劳斯莱斯', '107', '魅影', '3015', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('398', '开瑞', '101', '开瑞汽车', '208', '优优2代', '3017', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('399', '北汽制造', '154', '北京汽车制造厂', '185', 'BJ 212', '3035', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('4', '奔驰', '36', '奔驰(进口)', '47', '奔驰A级(进口)', '52', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('40', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯IS', '201', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('400', '纳智捷', '130', '东风裕隆', '315', '大7 MPV', '3040', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('401', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX60', '3043', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('402', 'Jeep', '46', 'SRT', '363', '大切诺基 SRT', '3048', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('403', '一汽', '110', '一汽吉林', '166', '佳宝V80', '3052', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('404', '宝马', '15', '宝马(进口)', '80', '宝马X4', '3053', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('405', '比亚迪', '75', '比亚迪', '146', '比亚迪S7', '3059', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('406', '玛莎拉蒂', '57', '玛莎拉蒂', '3', 'Ghibli', '3060', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('407', '江淮', '84', '江淮汽车', '170', '瑞风M6', '3061', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('408', '上汽大通', '155', '上汽大通', '356', '上汽大通G10', '3064', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('409', '名爵', '20', '上汽集团', '159', '锐腾', '3065', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('41', '宝马', '15', '宝马(进口)', '80', '宝马5系(进口)', '202', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('410', '标致', '13', '东风标致', '38', '标致301', '3068', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('411', '现代', '12', '北京现代', '27', '名图', '3073', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('412', '哈弗', '181', '长城汽车', '4', '哈弗H7', '3074', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('413', '海马', '86', '一汽海马', '26', '海马S7', '3075', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('414', '江淮', '84', '江淮汽车', '170', '瑞风S3', '3080', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('415', '一汽', '110', '天津一汽', '39', '骏派D60', '3081', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('416', '本田', '14', '广汽本田', '32', '凌派', '3085', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('417', '福田', '96', '福田汽车', '188', '蒙派克S', '3089', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('418', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q70', '3097', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('419', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX70', '3099', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('42', 'MINI', '56', 'MINI', '143', 'MINI', '209', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('420', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX80', '3100', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('421', '长城', '77', '长城汽车', '4', '风骏6', '3101', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('422', '大众', '1', '上汽大众', '58', '朗行', '3103', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('423', '本田', '14', '东风本田', '151', '杰德', '3104', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('424', '铃木', '53', '昌河铃木', '31', '利亚纳A6', '3112', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('425', '长安', '76', '长安汽车', '160', '长安CS95', '3121', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('426', '丰田', '3', '广汽丰田', '155', 'YARiS L 致炫', '3126', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('427', '东风风行', '165', '东风风行', '164', '景逸X5', '3128', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('428', '金杯', '83', '华晨鑫源', '409', '小海狮X30', '3136', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('429', '广汽吉奥', '108', '广汽吉奥', '203', '星旺M1', '3139', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('43', '大众', '1', '大众(进口)', '50', '甲壳虫', '210', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('430', '广汽吉奥', '108', '广汽吉奥', '203', '星旺M2', '3140', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('431', '海格', '150', '苏州金龙', '334', '龙威', '3149', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('432', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹Q6', '3150', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('433', '摩根', '168', '摩根', '351', '摩根Roadster', '3151', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('434', '摩根', '168', '摩根', '351', '摩根Plus 4', '3152', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('435', '摩根', '168', '摩根', '351', '摩根4-4', '3153', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('436', '马自达', '58', '一汽马自达', '11', '阿特兹', '3154', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('437', '长安欧尚', '163', '长安汽车', '160', '长安星卡', '3155', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('438', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S60L', '3158', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('439', '广汽吉奥', '108', '广汽吉奥', '203', '星旺L', '3159', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('44', '奔驰', '36', '奔驰(进口)', '47', '奔驰SL级', '237', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('440', '海马', '86', '海马汽车', '341', '福仕达腾达', '3162', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('441', '海马', '86', '海马汽车', '341', '福仕达福卡', '3163', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('442', '现代', '12', '现代(进口)', '74', '格越', '3164', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('443', '东风', '32', '东风汽车', '172', '虎视', '3166', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('444', '奥迪', '33', '一汽-大众奥迪', '9', '奥迪A3', '3170', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('445', '斯柯达', '67', '上汽斯柯达', '162', '速派', '3171', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('446', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW', '3178', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('447', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW CLUBMAN', '3179', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('448', 'MINI', '56', 'MINI JCW', '369', 'MINI JCW COUNTRYMAN', '3181', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('449', '宝马', '15', '宝马M', '345', '宝马M4', '3189', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('45', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯GS', '261', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('450', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M20', '3191', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('451', '九龙', '151', '九龙汽车', '335', '考斯特', '3194', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('452', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎5', '3195', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('453', '大众', '1', '上汽大众', '58', '朗境', '3197', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('454', '起亚', '62', '起亚(进口)', '111', '极睿', '3198', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('455', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪Q60', '3201', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('456', '长安', '76', '长安汽车', '160', '长安CS75', '3204', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('457', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克ATS-L', '3207', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('458', '捷豹', '44', '捷豹', '85', '捷豹F-PACE', '3209', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('459', '海马', '86', '海马汽车', '341', '海马S5', '3214', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('46', '日产', '63', '日产(进口)', '73', '途乐', '264', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('460', '铃木', '53', '昌河铃木', '31', '北斗星X5', '3216', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('461', '长安', '76', '长安汽车', '160', '奔奔', '3217', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('462', '力帆汽车', '80', '力帆汽车', '154', '力帆X50', '3220', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('463', '北汽制造', '154', '北京汽车制造厂', '185', '战旗皮卡', '3221', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('464', '长安轻型车', '294', '长安轻型车', '397', '睿行M80', '3227', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('465', '力帆汽车', '80', '力帆汽车', '154', '力帆T11', '3228', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('466', '力帆汽车', '80', '力帆汽车', '154', '力帆T21', '3229', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('467', '宝马', '15', '宝马(进口)', '80', '宝马2系', '3230', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('468', '北汽威旺', '143', '北京汽车', '312', '北汽威旺307', '3231', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('469', '标致', '13', '东风标致', '38', '标致2008', '3234', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('47', '劳斯莱斯', '54', '劳斯莱斯', '107', '幻影', '265', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('470', '海格', '150', '苏州金龙', '334', '海格H7V', '3235', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('471', '雷克萨斯', '52', '雷克萨斯F', '414', '雷克萨斯RC F', '3238', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('472', '海格', '150', '苏州金龙', '334', '海格H5V', '3243', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('473', '陕汽通家', '149', '陕汽通家', '333', '龙锐', '3244', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('474', '奔驰', '36', '北京奔驰', '152', '奔驰GLA', '3248', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('475', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLA AMG', '3264', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('476', '菲亚特', '11', '广汽菲克菲亚特', '427', '致悦', '3267', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('477', '兰博基尼', '48', '兰博基尼', '83', 'Huracán', '3277', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('478', '奔驰', '36', '奔驰(进口)', '47', '奔驰SLC级', '3278', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('479', '东风', '32', '郑州日产', '173', '俊风', '3279', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('48', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '阿斯顿·马丁DB9', '266', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('480', '比亚迪', '75', '比亚迪', '146', '比亚迪G5', '3283', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('481', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S2', '3284', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('482', '斯柯达', '67', '上汽斯柯达', '162', '昕动', '3290', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('483', '现代', '12', '北京现代', '27', '北京现代ix25', '3292', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('484', '纳智捷', '130', '东风裕隆', '315', '优6 SUV', '3293', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('485', '马自达', '58', '长安马自达', '176', '马自达3 Axela昂克赛拉', '3294', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('486', '哈弗', '181', '长城汽车', '4', '哈弗H9', '3298', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('487', '东风风行', '165', '东风风行', '164', '景逸S50', '3301', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('488', '潍柴英致', '192', '潍柴汽车', '372', '英致G3', '3306', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('489', '福田乘用车', '282', '福田汽车', '188', '萨瓦纳', '3307', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('49', '宝马', '15', '宝马(进口)', '80', '宝马6系', '270', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('490', 'DS', '169', '长安标致雪铁龙', '357', 'DS 5LS', '3309', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('491', '长安跨越', '299', '长安跨越', '373', '长安V5', '3311', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('492', '捷豹', '44', '捷豹', '85', '捷豹XE', '3312', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('493', '九龙', '151', '九龙汽车', '335', '艾菲', '3320', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('494', 'DS', '169', '长安标致雪铁龙', '357', 'DS 6', '3324', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('495', '力帆汽车', '80', '力帆汽车', '154', '力帆820', '3326', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('496', '雪佛兰', '71', '上汽通用雪佛兰', '139', '创酷', '3335', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('497', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLC(进口)', '3339', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('498', '东风风神', '113', '东风乘用车', '210', '东风风神AX7', '3341', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('499', '福汽启腾', '197', '福汽新龙马', '378', '启腾M70', '3346', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('5', '奔驰', '36', '奔驰(进口)', '47', '奔驰C级(进口)', '56', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('50', '宝马', '15', '宝马(进口)', '80', '宝马X3(进口)', '271', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('500', '福特', '8', '长安福特', '43', '福睿斯', '3347', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('501', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA6', '3349', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('502', '江淮', '84', '江淮汽车', '170', '瑞风M3', '3351', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('503', '宝马', '15', '宝马M', '345', '宝马M2', '3357', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('504', '卡威', '199', '卡威汽车', '380', '卡威K1', '3360', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('505', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S3', '3361', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('506', '江淮', '84', '江淮汽车', '170', '瑞风A60', '3363', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('507', '双龙', '69', '双龙汽车', '76', '途凌', '3372', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('508', '开瑞', '101', '开瑞汽车', '208', '开瑞K50', '3384', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('509', '宝马', '15', '宝马(进口)', '80', '宝马X2', '3386', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('51', '起亚', '62', '起亚(进口)', '111', '索兰托', '281', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('510', '泰卡特', '202', '泰卡特', '382', '泰卡特 T9', '3393', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('511', '江淮', '84', '江淮汽车', '170', '江淮iEV', '3395', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('512', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎3', '3397', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('513', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃XC60', '3411', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('514', '宝骏', '120', '上汽通用五菱', '59', '宝骏730', '3412', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('515', '陆风', '88', '陆风汽车', '158', '陆风X7', '3413', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('516', '东风风行', '165', '东风风行', '164', '景逸X3', '3414', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('517', '现代', '12', '北京现代', '27', '瑞奕', '3415', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('518', '大众', '1', '大众(进口)', '50', '凯路威', '3416', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('519', '北汽绅宝', '173', '北京汽车', '312', '绅宝X65', '3417', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('52', '斯巴鲁', '65', '斯巴鲁', '116', '森林人', '285', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('520', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S6', '3426', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('521', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C3-XR', '3429', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('522', '比亚迪', '75', '比亚迪', '146', '唐新能源', '3430', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('523', '南京金龙', '213', '南京金龙', '384', '开沃D11', '3432', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('524', '福田', '96', '福田汽车', '188', '风景G7', '3440', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('525', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯NX', '3442', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('526', '起亚', '62', '起亚(进口)', '111', '嘉华(进口)', '3448', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('527', '奔驰', '36', '梅赛德斯-AMG', '344', 'AMG GT', '3451', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('528', '哈弗', '181', '长城汽车', '4', '哈弗H1', '3454', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('529', '黄海', '97', '曙光汽车', '191', '黄海N1', '3455', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('53', '斯巴鲁', '65', '斯巴鲁', '116', '傲虎', '286', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('530', '大众', '1', '上汽大众', '58', '凌渡', '3457', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('531', '一汽', '110', '一汽吉林', '166', '解放T80', '3459', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('532', '本田', '14', '广汽本田', '32', '缤智', '3460', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('533', '东风风神', '113', '东风乘用车', '210', '东风风神L60', '3461', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('534', '丰田', '3', '广汽丰田', '155', '雷凌', '3462', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('535', '东风风神', '113', '东风乘用车', '210', '东风A9', '3463', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('536', '吉利汽车', '25', '吉利汽车', '54', '帝豪GS', '3465', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('537', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T5', '3466', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('538', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS10', '3472', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('539', '广汽吉奥', '108', '广汽吉奥', '203', '广汽吉奥GP150', '3480', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('54', '斯巴鲁', '65', '斯巴鲁', '116', '力狮', '287', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('540', '哈弗', '181', '长城汽车', '4', '哈弗H6 Coupe', '3481', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('541', '江淮', '84', '江淮汽车', '170', '凌铃', '3490', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('542', '东风风神', '113', '东风乘用车', '210', '东风风神A30', '3493', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('543', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS3', '3495', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('544', '东风小康', '142', '东风小康', '327', '东风小康C36', '3502', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('545', '成功汽车', '196', '成功汽车', '377', '成功V1', '3504', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('546', '成功汽车', '196', '成功汽车', '377', '成功V2', '3505', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('547', '成功汽车', '196', '成功汽车', '377', '成功K1', '3506', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('548', '成功汽车', '196', '成功汽车', '377', '成功K2', '3507', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('549', '成功汽车', '196', '成功汽车', '377', '成功X1', '3508', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('55', '玛莎拉蒂', '57', '玛莎拉蒂', '3', '总裁', '289', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('550', '金杯', '83', '绵阳金杯', '417', '金杯S70', '3515', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('551', '福特', '8', '江铃福特', '447', '撼路者', '3518', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('552', '路虎', '49', '奇瑞捷豹路虎', '376', '揽胜极光', '3521', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('553', '长安欧尚', '163', '长安汽车', '160', '长安之星3', '3526', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('554', '铃木', '53', '长安铃木', '35', '启悦', '3528', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('555', '众泰', '94', '众泰汽车', '171', '众泰E200', '3529', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('556', '中华', '22', '华晨中华', '53', '中华V3', '3530', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('557', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪ESQ', '3535', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('558', '马自达', '58', '马自达(进口)', '119', '马自达CX-3', '3538', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('559', '江淮', '84', '江淮汽车', '170', '瑞风S2', '3545', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('56', '宾利', '39', '宾利', '120', '欧陆', '305', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('560', '江淮', '84', '江淮汽车', '170', '帅铃T6', '3546', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('561', '名爵', '20', '上汽集团', '159', '锐行', '3547', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('562', '金龙', '145', '厦门金龙', '330', '凯特', '3549', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('563', '英菲尼迪', '73', '东风英菲尼迪', '392', '英菲尼迪Q50L', '3553', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('564', '别克', '38', '上汽通用别克', '93', '昂科威', '3554', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('565', '吉利汽车', '25', '吉利汽车', '54', '帝豪', '3556', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('566', '五十铃', '167', '江西五十铃', '394', 'D-MAX', '3562', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('567', '众泰', '94', '众泰汽车', '171', '云100', '3575', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('568', '五十铃', '167', '江西五十铃', '394', 'mu-X牧游侠', '3576', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('569', '本田', '14', '东风本田', '151', '本田XR-V', '3582', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('57', '本田', '14', '东风本田', '151', '本田CR-V', '314', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('570', '吉利汽车', '25', '吉利汽车', '54', '博瑞', '3589', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('571', '英菲尼迪', '73', '东风英菲尼迪', '392', '英菲尼迪QX50', '3591', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('572', '华颂', '220', '华晨华颂', '400', '华颂7', '3607', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('573', '现代', '12', '四川现代', '402', '康恩迪', '3613', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('574', '福特', '8', '长安福特', '43', '锐界', '3615', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('575', '启辰', '122', '东风启辰', '467', '启辰T70', '3618', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('576', '乔治·巴顿', '222', '乔治·巴顿', '403', '战车', '3621', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('577', '众泰', '94', '众泰汽车', '171', '众泰Z700', '3627', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('578', '九龙', '151', '九龙汽车', '335', '九龙A4', '3628', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('579', '力帆汽车', '80', '力帆汽车', '154', '乐途', '3631', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('58', '大众', '1', '上汽大众', '58', '途安', '333', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('580', '福迪', '141', '福迪汽车', '328', '揽福', '3633', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('581', '东南', '81', '东南汽车', '51', '东南DX7', '3634', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('582', '海格', '150', '苏州金龙', '334', '海格H6C', '3636', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('583', '东风风度', '187', '郑州日产', '173', '东风风度MX6', '3637', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('584', '海格', '150', '苏州金龙', '334', '海格H6V', '3638', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('585', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T7', '3639', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('586', '北汽昌河', '79', '北汽昌河', '177', '北汽昌河M50', '3640', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('587', '英菲尼迪', '73', '英菲尼迪(进口)', '72', '英菲尼迪QX30', '3652', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('588', '潍柴英致', '192', '潍柴汽车', '372', '英致737', '3653', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('589', '卡升', '224', '浙江卡尔森', '406', '卡升威霆', '3655', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('59', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LS', '341', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('590', '卡升', '224', '浙江卡尔森', '406', '卡升C10', '3656', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('591', '五菱汽车', '114', '上汽通用五菱', '59', '五菱荣光V', '3657', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('592', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H2', '3661', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('593', '观致', '152', '观致汽车', '336', '观致5', '3662', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('594', '起亚', '62', '东风悦达起亚', '57', '起亚KX3', '3664', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('595', '奔驰', '36', '梅赛德斯-迈巴赫', '407', '迈巴赫S级', '3665', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('596', '现代', '12', '北京现代', '27', '索纳塔九', '3672', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('597', '福田', '96', '福田汽车', '188', '风景V3', '3676', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('598', '宝骏', '120', '上汽通用五菱', '59', '宝骏560', '3677', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('599', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E100B', '3681', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('6', '奔驰', '36', '奔驰(进口)', '47', '奔驰S级', '59', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('60', '克莱斯勒', '9', '克莱斯勒(进口)', '69', '克莱斯勒300C(进口)', '342', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('600', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLE', '3683', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('601', '长安欧尚', '163', '长安汽车', '160', '长安之星9', '3685', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('602', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLS', '3688', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('603', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃XC40', '3689', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('604', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS4', '3691', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('605', '福特', '8', '长安福特', '43', '金牛座', '3693', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('606', '奔腾', '95', '一汽奔腾', '10', '奔腾B30', '3695', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('607', '东风小康', '142', '东风小康', '327', '东风小康K07S', '3697', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('608', '东风小康', '142', '东风小康', '327', '东风小康C31', '3698', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('609', '东风小康', '142', '东风小康', '327', '东风小康C32', '3699', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('61', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯LX', '352', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('610', '新凯', '185', '新凯汽车', '364', '新凯威霆', '3702', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('611', '新凯', '185', '新凯汽车', '364', '新凯凌特', '3703', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('612', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLE AMG', '3704', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('613', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H6', '3714', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('614', '东风', '32', '东风汽车', '172', '东风皮卡', '3716', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('615', '法拉利', '42', '法拉利', '78', '法拉利488', '3720', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('616', '金杯', '83', '华晨鑫源', '409', '金杯T30', '3721', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('617', '金杯', '83', '华晨鑫源', '409', '金杯T32', '3722', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('618', '宝马', '15', '宝马(进口)', '80', '宝马2系多功能旅行车', '3726', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('619', '林肯', '51', '林肯', '56', '林肯大陆', '3731', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('62', '现代', '12', '北京现代', '27', '途胜', '358', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('620', '福田', '96', '福田汽车', '188', '图雅诺', '3735', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('621', '摩根', '168', '摩根', '351', '摩根Aero 8', '3736', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('622', '别克', '38', '上汽通用别克', '93', '威朗', '3751', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('623', '福迪', '141', '福迪汽车', '328', '雄师F22', '3754', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('624', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯RC', '3758', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('625', '力帆汽车', '80', '力帆汽车', '154', '力帆X80', '3759', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('626', '金杯', '83', '华晨鑫源', '409', '华晨金杯750', '3763', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('627', '野马汽车', '111', '野马汽车', '206', '野马T80', '3765', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('628', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎7', '3766', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('629', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦570', '3767', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('63', '铃木', '53', '长安铃木', '35', '雨燕', '362', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('630', '一汽', '110', '一汽吉林', '166', '佳宝V75', '3775', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('631', '一汽', '110', '一汽吉林', '166', '佳宝V77', '3776', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('632', '众泰', '94', '众泰汽车', '171', '芝麻', '3779', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('633', '比亚迪', '75', '比亚迪', '146', '宋', '3780', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('634', '比亚迪', '75', '比亚迪', '146', '元', '3781', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('635', '广汽传祺', '82', '广汽乘用车', '186', '传祺GA8', '3782', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('636', '长安欧尚', '163', '长安汽车', '160', '欧尚A600', '3783', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('637', '东风风神', '113', '东风乘用车', '210', '东风风神AX3', '3786', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('638', '吉利汽车', '25', '吉利汽车', '54', '博越', '3788', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('639', '东风风行', '165', '东风风行', '164', '风行S500', '3789', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('64', '福特', '8', '长安福特', '43', '福克斯', '364', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('640', '东风风行', '165', '东风风行', '164', '风行F600', '3792', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('641', '众泰', '94', '众泰汽车', '171', '大迈X5', '3793', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('642', '北汽绅宝', '173', '北京汽车', '312', '绅宝X55', '3795', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('643', '北京', '27', '北京汽车', '312', '北京(BJ)20', '3800', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('644', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克CT6', '3802', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('645', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦540C', '3809', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('646', '长安', '76', '长安汽车', '160', '睿骋CC', '3811', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('647', '福特', '8', '江铃福特', '447', '途睿欧', '3814', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('648', '日产', '63', '东风日产', '92', 'LANNIA 蓝鸟', '3817', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('649', '前途', '235', '前途汽车', '420', '前途K50', '3820', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('65', '奔驰', '36', '奔驰(进口)', '47', '奔驰CLS级', '365', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('650', '福田', '96', '福田汽车', '188', '风景V5', '3821', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('651', '奔驰', '36', '福建奔驰', '301', '奔驰V级', '3823', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('652', '一汽', '110', '一汽吉林', '166', '森雅R7', '3824', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('653', '阿尔法·罗密欧', '34', '阿尔法·罗密欧', '86', 'Giulia', '3825', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('654', '知豆', '206', '知豆电动车', '388', '知豆D2', '3827', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('655', '东风风光', '259', '东风小康', '327', '东风风光330', '3829', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('656', '全球鹰', '219', '康迪电动汽车集团', '399', '全球鹰K10', '3835', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('657', '全球鹰', '219', '康迪电动汽车集团', '399', '全球鹰K11', '3836', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('658', '劳斯莱斯', '54', '劳斯莱斯', '107', '曜影', '3838', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('659', '北汽绅宝', '173', '北京汽车', '312', '绅宝X25', '3839', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('66', '奥迪', '33', '奥迪(进口)', '79', '奥迪A3(进口)', '370', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('660', 'Jeep', '46', '广汽菲克Jeep', '319', '指南者', '3845', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('661', '黄海', '97', '曙光汽车', '191', '黄海N2', '3846', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('662', '斯达泰克', '238', '斯达泰克', '423', '斯达泰克-卫士', '3849', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('663', '众泰', '94', '众泰汽车', '171', '众泰T700', '3852', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('664', '金杯', '83', '绵阳金杯', '417', '西部牛仔', '3853', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('665', '荣威', '19', '上汽集团', '159', '荣威360', '3857', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('666', '铃木', '53', '长安铃木', '35', '维特拉', '3858', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('667', '本田', '14', '东风本田', '151', '哥瑞', '3859', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('668', '奔驰', '36', '北京奔驰', '152', '奔驰GLC', '3862', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('669', '金杯', '83', '绵阳金杯', '417', '小金牛', '3868', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('67', '大众', '1', '大众(进口)', '50', '高尔夫(进口)', '372', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('670', '雷诺', '10', '东风雷诺', '375', '科雷嘉', '3870', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('671', '路虎', '49', '奇瑞捷豹路虎', '376', '发现神行', '3871', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('672', 'Jeep', '46', '广汽菲克Jeep', '319', '自由光', '3872', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('673', '雪铁龙', '72', '东风雪铁龙', '37', 'C4世嘉', '3873', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('674', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H3', '3874', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('675', '本田', '14', '广汽本田', '32', '锋范', '3876', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('676', '福汽启腾', '197', '福汽新龙马', '378', '启腾EX80', '3877', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('677', '中华', '22', '华晨中华', '53', '中华H3', '3878', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('678', '中兴', '74', '中兴汽车', '189', '小老虎', '3881', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('679', '潍柴英致', '192', '潍柴汽车', '372', '英致G5', '3882', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('68', '宝马', '15', '宝马(进口)', '80', '宝马1系(进口)', '373', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('680', '北汽新能源', '208', '北汽新能源', '390', 'EU系列', '3884', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('681', '金旅', '175', '厦门金旅', '359', '金旅大海狮新能源', '3885', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('682', '金旅', '175', '厦门金旅', '359', '金旅大海狮', '3886', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('683', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', '阿斯顿·马丁DB11', '3891', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('684', '长安欧尚', '163', '长安汽车', '160', '欧尚CX70', '3893', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('685', '华泰', '87', '华泰汽车', '117', '圣达菲', '3896', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('686', '金杯', '83', '绵阳金杯', '417', '智尚S35', '3898', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('687', '众泰', '94', '众泰汽车', '171', '众泰SR7', '3899', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('688', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLS AMG', '3901', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('689', '野马汽车', '111', '野马汽车', '206', '野马EC70', '3906', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('69', '斯柯达', '67', '上汽斯柯达', '162', '晶锐', '382', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('690', '华凯', '245', '明君汽车', '431', '华凯皮卡', '3911', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('691', '宝沃', '231', '宝沃汽车', '415', '宝沃BX7', '3913', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('692', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M30', '3916', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('693', '北汽昌河', '79', '北汽昌河', '177', '北汽昌河Q25', '3922', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('694', '雪佛兰', '71', '上汽通用雪佛兰', '139', '乐风RV', '3923', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('695', '长安', '76', '长安汽车', '160', '长安CS15', '3924', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('696', '东风风光', '259', '东风小康', '327', '东风风光370', '3925', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('697', '铃木', '53', '铃木(进口)', '161', '英格尼斯', '3926', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('698', '北汽绅宝', '173', '北京汽车', '312', '绅宝X35', '3928', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('699', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯RX', '3934', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('7', '奔驰', '36', '奔驰(进口)', '47', '奔驰G级', '60', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('70', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'V8 Vantage', '385', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('700', '五十铃', '167', '江西五十铃', '394', '瑞迈', '3935', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('701', '纳智捷', '130', '东风裕隆', '315', '锐3', '3939', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('702', '宝马', '15', '华晨宝马', '29', '宝马2系旅行车', '3941', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('703', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光小卡', '3946', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('704', '起亚', '62', '东风悦达起亚', '57', '起亚KX5', '3954', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('705', '金杯', '83', '华晨鑫源', '409', '海狮X30L', '3955', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('706', '日产', '63', '东风日产', '92', '西玛', '3957', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('707', '现代', '12', '北京现代', '27', '领动', '3959', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('708', 'DS', '169', '长安标致雪铁龙', '357', 'DS 4S', '3963', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('709', '大众', '1', '一汽-大众', '8', '高尔夫·嘉旅', '3964', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('71', '阿斯顿·马丁', '35', '阿斯顿·马丁', '108', 'Vanquish', '386', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('710', '乔治·巴顿', '222', '乔治·巴顿', '403', '战剑', '3967', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('711', '马自达', '58', '一汽马自达', '11', '马自达CX-4', '3968', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('712', '潍柴英致', '192', '潍柴汽车', '372', '英致727', '3969', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('713', '东风风行', '165', '东风风行', '164', '风行SX6', '3970', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('714', '凯翼', '214', '凯翼汽车', '398', '凯翼V3', '3971', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('715', '荣威', '19', '上汽集团', '159', '荣威e950', '3977', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('716', '一汽', '110', '天津一汽', '39', '骏派A70', '3979', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('717', '北汽昌河', '79', '北汽昌河', '177', '北汽昌河Q35', '3980', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('718', '凯翼', '214', '凯翼汽车', '398', '凯翼X3', '3983', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('719', '力帆汽车', '80', '力帆汽车', '154', '迈威', '3987', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('72', '奔驰', '36', '奔驰(进口)', '47', '奔驰B级', '398', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('720', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克XT5', '3989', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('721', '福田乘用车', '282', '福田汽车', '188', '伽途ix7', '3990', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('722', '福田乘用车', '282', '福田汽车', '188', '伽途ix5', '3991', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('723', '福汽启腾', '197', '福汽新龙马', '378', '启腾V60', '3992', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('724', '宝骏', '120', '上汽通用五菱', '59', '宝骏E100', '3993', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('725', '海马', '86', '一汽海马', '26', '海马V70', '3994', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('726', '大众', '1', '大众(进口)', '50', '蔚揽', '3999', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('727', '北汽威旺', '143', '北京汽车', '312', '北汽威旺S50', '4009', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('728', '长安轻型车', '294', '长安轻型车', '397', '睿行M90', '4011', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('729', '长安轻型车', '294', '长安轻型车', '397', '神骐F30', '4012', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('73', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯ES', '403', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('730', '北汽新能源', '208', '北汽新能源', '390', 'EX系列', '4015', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('731', '东风风光', '259', '东风小康', '327', '东风风光580', '4023', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('732', '法拉利', '42', '法拉利', '78', 'GTC4Lusso', '4027', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('733', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃V90', '4029', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('734', '雪佛兰', '71', '上汽通用雪佛兰', '139', '迈锐宝XL', '4031', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('735', '福田', '96', '福田汽车', '188', '风景G9', '4035', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('736', '开瑞', '101', '开瑞汽车', '208', '开瑞K60', '4039', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('737', '雪铁龙', '72', '东风雪铁龙', '37', '雪铁龙C6', '4043', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('738', '大众', '1', '上汽大众', '58', '辉昂', '4045', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('739', '宝沃', '231', '宝沃汽车', '415', '宝沃BX5', '4046', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('74', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃S60', '404', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('740', '华泰新能源', '260', '华泰新能源', '445', '华泰iEV230', '4065', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('741', '华泰新能源', '260', '华泰新能源', '445', '华泰XEV260', '4066', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('742', '奔腾', '95', '一汽奔腾', '10', '奔腾X40', '4069', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('743', '众泰', '94', '众泰汽车', '171', '众泰SR9', '4070', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('744', 'Jeep', '46', '广汽菲克Jeep', '319', '自由侠', '4072', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('745', '比亚迪', '75', '比亚迪', '146', '比亚迪e5', '4073', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('746', '奔驰', '36', '梅赛德斯-AMG', '344', '奔驰GLC AMG', '4074', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('747', '金杯', '83', '绵阳金杯', '417', '大力神K5', '4076', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('748', '宝骏', '120', '上汽通用五菱', '59', '宝骏310', '4077', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('749', '特斯拉', '133', '特斯拉', '318', 'Model 3', '4078', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('75', '比亚迪', '75', '比亚迪', '146', '比亚迪F3', '407', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('750', '荣威', '19', '上汽集团', '159', '荣威RX5', '4080', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('751', '捷豹', '44', '奇瑞捷豹路虎', '376', '捷豹XFL', '4083', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('752', '东南', '81', '东南汽车', '51', '东南DX3', '4086', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('753', '江淮', '84', '江淮汽车', '170', '江淮iEV6E', '4088', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('754', '江淮', '84', '江淮汽车', '170', '瑞风M4', '4090', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('755', '众泰', '94', '众泰汽车', '171', '大迈X7', '4092', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('756', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS8', '4094', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('757', '凯翼', '214', '凯翼汽车', '398', '凯翼X5', '4095', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('758', '讴歌', '60', '广汽讴歌', '450', '讴歌CDX', '4096', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('759', '东风风神', '113', '东风乘用车', '210', '东风风神AX5', '4097', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('76', '奥迪', '33', '奥迪(进口)', '79', '奥迪Q7', '412', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('760', '雷诺', '10', '东风雷诺', '375', '科雷傲', '4098', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('761', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎3x', '4099', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('762', '本田', '14', '广汽本田', '32', '冠道', '4102', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('763', '雪佛兰', '71', '上汽通用雪佛兰', '139', '科沃兹', '4105', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('764', '现代', '12', '北京现代', '27', '悦纳', '4107', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('765', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS9', '4111', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('766', '启辰', '122', '东风启辰', '467', '启辰T90', '4115', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('767', '上汽大通', '155', '上汽大通', '356', '上汽大通D90', '4120', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('768', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CT7', '4126', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('769', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X7', '4130', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('77', '日产', '63', '东风日产', '92', '骐达', '425', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('770', '海格', '150', '苏州金龙', '334', '海格H4E', '4131', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('771', '长安轻型车', '294', '长安轻型车', '397', '睿行S50', '4132', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('772', '吉利汽车', '25', '吉利汽车', '54', '远景SUV', '4133', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('773', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H2V', '4137', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('774', '吉利汽车', '25', '吉利汽车', '54', '帝豪GL', '4139', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('775', '北汽昌河', '79', '北汽昌河', '177', '福瑞达K21', '4141', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('776', '北汽昌河', '79', '北汽昌河', '177', '福瑞达K22', '4142', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('777', '之诺', '182', '华晨宝马', '29', '之诺60H', '4146', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('778', '三菱', '68', '广汽三菱', '355', '欧蓝德', '4147', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('779', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E200L', '4149', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('78', '日产', '63', '日产(进口)', '73', '日产GT-R', '436', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('780', 'SWM斯威汽车', '269', 'SWM斯威汽车', '466', 'SWM斯威X7', '4151', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('781', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M50F', '4154', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('782', '海马', '86', '海马汽车', '341', '海马E3', '4156', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('783', '全球鹰', '219', '康迪电动汽车集团', '399', '全球鹰K17', '4160', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('784', '全球鹰', '219', '康迪电动汽车集团', '399', '全球鹰K12', '4161', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('785', '黄海', '97', '曙光汽车', '191', '瑞途', '4162', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('786', '比速汽车', '271', '比速汽车', '456', '比速T3', '4164', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('787', '福田', '96', '福田汽车', '188', '祥菱V', '4165', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('788', '宝骏', '120', '上汽通用五菱', '59', '宝骏510', '4166', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('789', '标致', '13', '东风标致', '38', '标致4008', '4167', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('79', '日产', '63', '日产(进口)', '73', '贵士', '438', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('790', '哈弗', '181', '长城汽车', '4', '哈弗H2s', '4168', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('791', '海马', '86', '海马汽车', '341', '海马S5青春版', '4169', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('792', '华骐', '184', '东风悦达起亚', '57', '华骐300E', '4170', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('793', '宝马', '15', '华晨宝马', '29', '宝马1系', '4171', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('794', '比速汽车', '271', '比速汽车', '456', '比速M3', '4173', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('795', '广汽传祺', '82', '广汽乘用车', '186', '传祺GM8', '4174', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('796', '保时捷', '40', '保时捷', '81', '保时捷718', '4175', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('797', '中兴', '74', '中兴汽车', '189', '领主', '4178', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('798', '本田', '14', '东风本田', '151', '竞瑞', '4179', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('799', '长安跨越', '299', '长安跨越', '373', '长安V3', '4181', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('8', '日产', '63', '东风日产', '92', '阳光', '64', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('80', '大众', '1', '一汽-大众', '8', '速腾', '442', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('800', '长安跨越', '299', '长安跨越', '373', '新豹MINI', '4182', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('801', '福特', '8', '江铃福特', '447', '全顺', '4192', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('802', '力帆汽车', '80', '力帆汽车', '154', '轩朗', '4194', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('803', '阿尔法·罗密欧', '34', '阿尔法·罗密欧', '86', 'Stelvio', '4196', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('804', '雷克萨斯', '52', '雷克萨斯', '65', '雷克萨斯UX', '4197', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('805', '起亚', '62', '东风悦达起亚', '57', '起亚KX7', '4200', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('806', '大众', '1', '一汽-大众', '8', 'C-TREK蔚领', '4204', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('807', '海马', '86', '一汽海马', '26', '福美来MPV', '4205', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('808', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S90', '4206', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('809', '北汽昌河', '79', '北汽昌河', '177', '北汽昌河M70', '4208', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('81', '吉利汽车', '25', '吉利汽车', '54', '金刚', '447', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('810', '江铃', '119', '江铃汽车', '307', '特顺', '4209', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('811', 'ALPINA', '276', 'ALPINA', '460', 'ALPINA B4', '4212', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('812', '斯柯达', '67', '上汽斯柯达', '162', '柯迪亚克', '4217', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('813', '奇瑞', '26', '奇瑞新能源', '405', '奇瑞eQ1', '4218', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('814', '领克', '279', '领克', '463', '领克01', '4221', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('815', '现代', '12', '北京现代', '27', '悦纳RV', '4222', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('816', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X5', '4226', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('817', '福田乘用车', '282', '福田汽车', '188', '伽途im6', '4227', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('818', '福田乘用车', '282', '福田汽车', '188', '伽途im8', '4228', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('819', '广汽传祺', '82', '广汽乘用车', '186', '传祺GS7', '4230', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('82', '日产', '63', '东风日产', '92', '轩逸', '448', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('820', '大众', '1', '上汽大众', '58', '途昂', '4232', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('821', '陆风', '88', '陆风汽车', '158', '陆风逍遥', '4233', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('822', '江淮', '84', '江淮汽车', '170', '瑞风S7', '4234', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('823', '雪佛兰', '71', '上汽通用雪佛兰', '139', '探界者', '4235', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('824', '金杯', '83', '华晨雷诺', '169', '金杯快运', '4237', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('825', '电咖', '280', '电咖汽车', '488', '电咖·EV10', '4238', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('826', '别克', '38', '上汽通用别克', '93', 'VELITE 5', '4239', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('827', '荣威', '19', '上汽集团', '159', '荣威RX5新能源', '4240', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('828', '上汽大通', '155', '上汽大通', '356', '上汽大通T60', '4241', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('829', '长安', '76', '长安汽车', '160', '凌轩', '4242', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('83', '奔驰', '36', '奔驰(进口)', '47', '奔驰E级(进口)', '450', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('830', '荣威', '19', '上汽集团', '159', '荣威i6', '4246', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('831', '名爵', '20', '上汽集团', '159', '名爵ZS', '4247', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('832', '捷豹', '44', '捷豹', '85', '捷豹I-PACE', '4251', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('833', 'WEY', '283', '长城汽车', '4', 'WEY VV7', '4252', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('834', 'WEY', '283', '长城汽车', '4', 'WEY VV5', '4253', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('835', '广汽新能源', '313', '广汽新能源', '492', '传祺GA3S PHEV', '4255', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('836', '广汽新能源', '313', '广汽新能源', '492', '传祺GS4新能源', '4256', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('837', '丰田', '3', '广汽丰田', '155', 'YARiS L 致享', '4259', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('838', '丰田', '3', '一汽丰田', '40', '威驰FS', '4260', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('839', '巴博斯', '140', '巴博斯', '326', '巴博斯 smart forfour', '4261', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('84', '凯迪拉克', '47', '凯迪拉克(进口)', '44', '凯雷德ESCALADE', '462', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('840', '奇瑞', '26', '奇瑞新能源', '405', '艾瑞泽5e', '4262', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('841', '荣威', '19', '上汽集团', '159', '荣威ei6', '4263', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('842', '北汽新能源', '208', '北汽新能源', '390', 'EC系列', '4264', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('843', '依维柯', '144', '南京依维柯', '329', '依维柯Ouba', '4266', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('844', '依维柯', '144', '南京依维柯', '329', '依维柯Venice', '4267', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('845', '长安', '76', '长安汽车', '160', '长安CS55', '4269', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('846', '五菱汽车', '114', '上汽通用五菱', '59', '五菱之光V', '4270', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('847', '标致', '13', '东风标致', '38', '标致5008', '4271', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('848', '大众', '1', '上汽大众', '58', '途观L', '4274', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('849', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S5', '4276', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('85', '奔腾', '95', '一汽奔腾', '10', '奔腾B70', '466', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('850', '东风', '32', '东风汽车', '172', '御风EV', '4278', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('851', '比亚迪', '75', '比亚迪', '146', '宋MAX', '4279', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('852', '广汽新能源', '313', '广汽新能源', '492', '传祺GE3', '4291', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('853', '长安轻型车', '294', '长安轻型车', '397', '睿行S50T', '4292', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('854', '吉利汽车', '25', '吉利汽车', '54', '远景X1', '4293', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('855', '金杯', '83', '华晨雷诺', '169', '金杯F50', '4294', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('856', '比速汽车', '271', '比速汽车', '456', '比速T5', '4298', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('857', '东风小康', '142', '东风小康', '327', '东风小康K05S', '4299', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('858', '陆风', '88', '陆风汽车', '158', '陆风X2', '4302', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('859', '本田', '14', '东风本田', '151', '本田UR-V', '4304', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('86', '奔驰', '36', '奔驰(进口)', '47', '奔驰R级', '469', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('860', '日产', '63', '东风日产', '92', '劲客', '4305', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('861', '日产', '63', '郑州日产', '173', '纳瓦拉', '4307', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('862', '中华', '22', '华晨中华', '53', '中华H230EV', '4309', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('863', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速H5', '4310', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('864', '金杯', '83', '华晨鑫源', '409', '金杯T50', '4311', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('865', '金杯', '83', '华晨鑫源', '409', '金杯T52', '4312', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('866', '法拉利', '42', '法拉利', '78', '812 Superfast', '4314', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('867', '启辰', '122', '东风启辰', '467', '启辰M50V', '4315', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('868', '路虎', '49', '路虎(进口)', '49', '揽胜星脉', '4316', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('869', '众泰', '94', '众泰汽车', '171', '众泰Z560', '4317', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('87', '海马', '86', '一汽海马', '26', '福美来', '470', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('870', '华泰新能源', '260', '华泰新能源', '445', '华泰EV160B', '4318', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('871', '长安跨越', '299', '长安跨越', '373', '跨越王', '4319', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('872', '云度', '286', '云度新能源', '469', '云度π1', '4320', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('873', '云度', '286', '云度新能源', '469', '云度π3', '4321', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('874', '保时捷', '40', '保时捷', '81', 'Panamera新能源', '4322', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('875', '保时捷', '40', '保时捷', '81', 'Cayenne新能源', '4324', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('876', '奥迪', '33', '奥迪(进口)', '79', '奥迪A3新能源(进口)', '4325', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('877', '众泰', '94', '众泰汽车', '171', '众泰Z500EV', '4327', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('878', '凯迪拉克', '47', '上汽通用凯迪拉克', '122', '凯迪拉克CT6 PLUG-IN', '4334', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('879', '沃尔沃', '70', '沃尔沃亚太', '367', '沃尔沃S60L新能源', '4335', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('88', '奥迪', '33', '奥迪(进口)', '79', '奥迪A4(进口)', '471', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('880', 'SWM斯威汽车', '269', 'SWM斯威汽车', '466', 'SWM斯威X3', '4336', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('881', '沃尔沃', '70', '沃尔沃(进口)', '84', '沃尔沃XC90新能源', '4337', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('882', '上汽大通', '155', '上汽大通', '356', '上汽大通EG10', '4338', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('883', '海马', '86', '一汽海马', '26', '普力马EV', '4339', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('884', '长城', '77', '长城汽车', '4', '长城C30新能源', '4341', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('885', '吉利汽车', '25', '吉利汽车', '54', '帝豪新能源', '4342', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('886', '长安', '76', '长安汽车', '160', '逸动新能源', '4343', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('887', '奔驰', '36', '奔驰(进口)', '47', '奔驰S级新能源', '4344', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('888', '宝马', '15', '宝马(进口)', '80', '宝马7系新能源', '4345', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('889', '奔驰', '36', '奔驰(进口)', '47', '奔驰GLE新能源', '4346', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('89', '奥迪', '33', '奥迪(进口)', '79', '奥迪A6(进口)', '472', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('890', '宝马', '15', '宝马(进口)', '80', '宝马X5新能源', '4348', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('891', '宝马', '15', '华晨宝马', '29', '宝马5系新能源', '4350', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('892', '新凯', '185', '新凯汽车', '364', '新凯V-Class', '4351', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('893', '比亚迪', '75', '比亚迪', '146', '元新能源', '4353', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('894', '大众', '1', '大众(进口)', '50', '高尔夫新能源(进口)', '4355', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('895', '宝马', '15', '华晨宝马', '29', '宝马X1新能源', '4356', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('896', '迈凯伦', '129', '迈凯伦', '314', '迈凯伦720S', '4366', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('897', '雪铁龙', '72', '东风雪铁龙', '37', '天逸 C5 AIRCROSS', '4370', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('898', '众泰', '94', '众泰汽车', '171', '众泰Z360', '4371', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('899', '长安轻型车', '294', '长安轻型车', '397', '睿行M70', '4372', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('9', '宝马', '15', '华晨宝马', '29', '宝马5系', '65', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('90', '雪铁龙', '72', '雪铁龙(进口)', '82', 'C4 PICASSO', '473', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('900', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E160', '4375', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('901', '长安欧尚', '163', '长安汽车', '160', '欧尚A800', '4376', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('902', 'Lorinser', '118', '罗伦士', '472', 'Sprinter LS500', '4378', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('903', 'Lorinser', '118', '罗伦士', '472', 'Metris MS500', '4379', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('904', '长安', '76', '长安汽车', '160', '奔奔EV', '4380', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('905', '讴歌', '60', '广汽讴歌', '450', '讴歌TLX-L', '4381', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('906', '东风风神', '113', '东风乘用车', '210', '东风风神AX4', '4383', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('907', '众泰', '94', '众泰汽车', '171', '众泰T600 Coupe', '4385', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('908', '福特', '8', '长安福特', '43', '蒙迪欧新能源', '4386', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('909', '起亚', '62', '东风悦达起亚', '57', '焕驰', '4387', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('91', '吉利汽车', '25', '吉利汽车', '54', '远景', '474', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('910', '江铃集团新能源', '270', '江铃集团新能源', '455', '江铃E200N', '4388', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('911', '宝骏', '120', '上汽通用五菱', '59', '宝骏310W', '4392', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('912', '比亚迪', '75', '比亚迪', '146', '宋新能源', '4394', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('913', '吉利汽车', '25', '吉利汽车', '54', '嘉际', '4396', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('914', '领克', '279', '领克', '463', '领克03', '4402', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('915', '宝沃', '231', '宝沃汽车', '415', '宝沃BXi7', '4403', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('916', '一汽', '110', '天津一汽', '39', '骏派A50', '4404', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('917', '一汽', '110', '天津一汽', '39', '骏派CX65', '4405', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('918', '五菱汽车', '114', '上汽通用五菱', '59', '五菱宏光S3', '4408', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('919', '红旗', '91', '一汽红旗', '190', '红旗H5', '4410', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('92', '大众', '1', '一汽-大众', '8', '迈腾', '496', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('920', '一汽', '110', '天津一汽', '39', '骏派A70E', '4415', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('921', '众泰', '94', '众泰汽车', '171', '众泰T500', '4417', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('922', '东风风行', '165', '东风风行', '164', '菱智M5EV', '4418', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('923', '汉腾汽车', '267', '汉腾汽车', '453', '汉腾X5新能源', '4419', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('924', '东风风神', '113', '东风乘用车', '210', '东风风神E70', '4421', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('925', '东风风行', '165', '东风风行', '164', '景逸X6', '4423', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('926', '野马汽车', '111', '野马汽车', '206', '斯派卡', '4425', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('927', '蔚来', '284', '蔚来', '464', '蔚来ES8', '4427', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('928', '猎豹汽车', '78', '猎豹汽车', '141', '猎豹CS9新能源', '4428', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('929', '广汽集团', '329', '广汽三菱', '355', '祺智PHEV', '4431', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('93', '铃木', '53', '铃木(进口)', '161', '超级维特拉', '500', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('930', '铃木', '53', '长安铃木', '35', '骁途', '4435', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('931', '黄海', '97', '曙光汽车', '191', '黄海N3', '4436', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('932', 'WEY', '283', '长城汽车', '4', 'WEY P8', '4441', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('933', '江淮', '84', '江淮汽车', '170', '江淮iEV7S', '4444', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('934', '长安', '76', '长安汽车', '160', '长安CS15EV', '4445', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('935', '卡升', '224', '浙江卡尔森', '406', '卡升T6', '4447', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('936', '卡升', '224', '浙江卡尔森', '406', '卡升V-Class', '4448', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('937', '斯柯达', '67', '上汽斯柯达', '162', '柯珞克', '4453', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('938', '海马', '86', '海马汽车', '341', '海马爱尚EV', '4459', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('939', '奥迪', '33', '奥迪(进口)', '79', '奥迪Q7新能源', '4460', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('94', '铃木', '53', '铃木(进口)', '161', '吉姆尼(进口)', '508', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('940', '东风小康', '142', '东风小康', '327', '东风小康EC36', '4461', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('941', '捷豹', '44', '奇瑞捷豹路虎', '376', '捷豹XEL', '4462', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('942', 'Lorinser', '118', '罗伦士', '472', 'Lorinser VS系列', '4464', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('943', '东风风光', '259', '东风小康', '327', '东风风光S560', '4468', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('944', '宝马', '15', '宝马(进口)', '80', '宝马6系GT', '4472', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('945', '荣威', '19', '上汽集团', '159', '荣威RX3', '4473', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('946', '凯翼', '214', '凯翼汽车', '398', '凯翼E3', '4474', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('947', '开瑞', '101', '开瑞汽车', '208', '优优EV', '4477', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('948', '开瑞', '101', '开瑞汽车', '208', '开瑞K50EV', '4478', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('949', '瑞驰新能源', '296', '瑞驰新能源', '479', '瑞驰新能源EC35', '4479', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('95', '奥迪', '33', 'Audi Sport', '346', '奥迪R8', '511', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('950', '长安欧尚', '163', '长安汽车', '160', '奔奔mini-e', '4480', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('951', '吉利汽车', '25', '吉利汽车', '54', '远景X3', '4481', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('952', '卡威', '199', '卡威汽车', '380', '卡威W1新能源', '4482', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('953', '华泰', '87', '华泰汽车', '117', '圣达菲7', '4483', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('954', '宇通客车', '298', '宇通客车', '481', '宇通T7', '4484', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('955', '哈弗', '181', '长城汽车', '4', '哈弗M6', '4485', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('956', '东风', '32', '东风汽车', '172', '御风P16', '4486', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('957', '别克', '38', '上汽通用别克', '93', '别克GL6', '4487', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('958', '北汽昌河', '79', '北汽昌河', '177', '北斗星X5E', '4488', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('959', '小鹏汽车', '275', '小鹏汽车', '459', '小鹏汽车G3', '4489', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('96', '斯柯达', '67', '上汽斯柯达', '162', '明锐', '519', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('960', '启辰', '122', '东风启辰', '467', '启辰D60', '4490', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('961', '吉利汽车', '25', '吉利汽车', '54', '远景S1', '4491', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('962', '江铃集团轻汽', '210', '江铃集团轻汽', '386', '骐铃T100', '4493', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('963', '华泰新能源', '260', '华泰新能源', '445', '华泰EV160R', '4495', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('964', '现代', '12', '北京现代', '27', '伊兰特EV', '4496', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('965', '纳智捷', '130', '东风裕隆', '315', 'U5 SUV', '4497', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('966', '中华', '22', '华晨中华', '53', '中华V6', '4498', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('967', '长安欧尚', '163', '长安汽车', '160', '欧力威EV', '4499', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('968', '北汽幻速', '203', '北汽银翔', '383', '北汽幻速S7', '4502', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('969', '中华', '22', '华晨中华', '53', '中华V7', '4503', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('97', 'Jeep', '46', 'Jeep(进口)', '71', '大切诺基(进口)', '521', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('970', '起亚', '62', '东风悦达起亚', '57', 'KX CROSS', '4505', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('971', '北汽昌河', '79', '北汽昌河', '177', '北汽昌河A6', '4506', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('972', '陆地方舟', '204', '陆地方舟', '385', '威途X35', '4509', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('973', '野马汽车', '111', '野马汽车', '206', '野马EC30', '4510', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('974', '北汽道达', '301', '北汽瑞丽', '482', '道达V8', '4511', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('975', '长安欧尚', '163', '长安汽车', '160', '欧尚X70A', '4517', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('976', '华泰', '87', '华泰汽车', '117', '圣达菲5', '4518', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('977', '君马汽车', '297', '君马汽车', '480', '君马S70', '4519', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('978', '宝沃', '231', '宝沃汽车', '415', '宝沃BX6', '4520', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('979', 'LITE', '335', '北汽新能源', '390', 'LITE', '4522', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('98', '日产', '63', '东风日产', '92', '骊威', '522', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('980', '起亚', '62', '东风悦达起亚', '57', '凯绅', '4523', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('981', '法拉利', '42', '法拉利', '78', 'Portofino', '4524', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('982', '海马', '86', '一汽海马', '26', '福美来F7', '4525', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('983', '福汽启腾', '197', '福汽新龙马', '378', '启腾M70EV', '4530', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('984', '奇瑞', '26', '奇瑞汽车', '33', '瑞虎5x', '4531', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('985', '成功汽车', '196', '成功汽车', '377', '成功V2E', '4533', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('986', '别克', '38', '上汽通用别克', '93', '阅朗', '4552', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('987', '北汽威旺', '143', '北京汽车', '312', '北汽威旺M60', '4553', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('988', '荣威', '19', '上汽集团', '159', '荣威Ei5', '4554', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('989', '君马汽车', '297', '君马汽车', '480', '君马MEET 3(美图3)', '4555', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('99', '讴歌', '60', '讴歌(进口)', '157', '讴歌MDX', '524', '0', '2019-03-22 19:06:26');
INSERT INTO `tbl_car_system` VALUES ('990', '国金汽车', '304', '陕西通家', '490', '国金GM3', '4556', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('991', '卡威', '199', '卡威汽车', '380', '卡威K150GT', '4557', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('992', '东风', '32', '东风汽车', '172', '御风S16', '4560', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('993', '卡威', '199', '卡威汽车', '380', '路易斯', '4563', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('994', 'SRM鑫源', '306', '华晨鑫源', '409', '好运1号', '4566', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('995', 'SRM鑫源', '306', '华晨鑫源', '409', '鑫源X30LEV', '4567', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('996', 'SRM鑫源', '306', '华晨鑫源', '409', '鑫源T20EV', '4568', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('997', '路虎', '49', '路虎(进口)', '49', '揽胜运动版新能源', '4569', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('998', '裕路', '307', '裕路汽车', '486', '裕路EV2', '4574', '0', '2019-03-22 19:06:27');
INSERT INTO `tbl_car_system` VALUES ('999', '路虎', '49', '路虎(进口)', '49', '揽胜新能源', '4579', '0', '2019-03-22 19:06:27');

-- ----------------------------
-- Table structure for tbl_file
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `file_name` varchar(255) DEFAULT NULL COMMENT '附件名称',
  `FILE_NAME_BAK` varchar(255) DEFAULT NULL COMMENT '附件原名称',
  `FILE_PATH` varchar(255) DEFAULT NULL COMMENT '附件路径',
  `UPLOAD_DATE` datetime DEFAULT NULL COMMENT '上传时间',
  `STATUS` varchar(1) DEFAULT '0' COMMENT '状态：状态：0 待整理，1 已整理',
  `file_count` varchar(255) DEFAULT '0' COMMENT '文件总数',
  `sum_count` varchar(255) DEFAULT '0' COMMENT '合计条数',
  `problem_count` varchar(255) DEFAULT '0' COMMENT '问题条数',
  `task_repeat_count` varchar(255) DEFAULT '0' COMMENT '任务重复条数',
  `carsys_repeat_count` varchar(255) DEFAULT '0' COMMENT '车系重复条数',
  `biglib_repeat_count` varchar(255) DEFAULT '0' COMMENT '大库重复条数',
  `black_hit_count` varchar(255) DEFAULT '0' COMMENT '黑名单命中条数',
  `number_err_count` varchar(255) DEFAULT '0' COMMENT '号段错误条数',
  `id_failed_count` varchar(255) DEFAULT '0' COMMENT 'id转失败条数',
  `trade_count` varchar(255) DEFAULT '0' COMMENT '厂商重复次数',
  `brand_count` varchar(255) DEFAULT '0' COMMENT '品牌重复次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_file
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_file_detail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file_detail`;
CREATE TABLE `tbl_file_detail` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `file_id` varchar(35) NOT NULL COMMENT '文件表ID',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `task_id` varchar(255) DEFAULT NULL COMMENT '任务ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `area` varchar(255) DEFAULT NULL COMMENT '地区',
  `car_sys` varchar(255) DEFAULT NULL COMMENT '车系',
  `status` varchar(255) DEFAULT NULL COMMENT '状态：0 正常，1 大库重复，2 任务重复，3 车系重复，4 黑名单命中，5 号段错误，6 ID转失败',
  `err_info` varchar(255) DEFAULT NULL COMMENT '错误描述，用来生成错误txt文件',
  `UPLOAD_DATE` datetime DEFAULT NULL,
  `ORDER_NUM` varchar(10) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `trade` varchar(255) DEFAULT NULL COMMENT '厂商',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `file_detail_file_id_index` (`file_id`) USING BTREE,
  KEY `file_detail_file_name_index` (`file_name`) USING BTREE,
  KEY `file_detail_task_id_index` (`task_id`) USING BTREE,
  KEY `file_detail_phone_index` (`phone`) USING BTREE,
  KEY `file_detail_area_index` (`area`) USING BTREE,
  KEY `file_detail_car_sys_index` (`car_sys`) USING BTREE,
  KEY `file_detail_status_index` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_file_detail
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_flow_analysis
-- ----------------------------
DROP TABLE IF EXISTS `tbl_flow_analysis`;
CREATE TABLE `tbl_flow_analysis` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `insert_date` date DEFAULT NULL COMMENT '载入时间',
  `insert_month` varchar(1000) DEFAULT NULL COMMENT '插入月份',
  `module_name` varchar(1000) DEFAULT NULL COMMENT '模块名称',
  `title_name` varchar(1000) DEFAULT NULL COMMENT '标题名称',
  `exposure_num` varchar(1000) DEFAULT NULL COMMENT '曝光次数',
  `click_num` varchar(1000) DEFAULT NULL COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流量分析';

-- ----------------------------
-- Records of tbl_flow_analysis
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_function
-- ----------------------------
DROP TABLE IF EXISTS `tbl_function`;
CREATE TABLE `tbl_function` (
  `id` varchar(35) NOT NULL,
  `function_name` varchar(50) NOT NULL DEFAULT '',
  `function_description` varchar(50) NOT NULL DEFAULT '',
  `function_level` varchar(1) NOT NULL DEFAULT '',
  `function_url` varchar(500) NOT NULL,
  `function_type` varchar(500) NOT NULL COMMENT '1:线上广告管理，2:线下潜客筛选，3:车金融潜客挖掘，4:线索优化管理，5:账号管理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_function
-- ----------------------------
INSERT INTO `tbl_function` VALUES ('F001', '数据管理', '数据管理', '1', '#', '4');
INSERT INTO `tbl_function` VALUES ('F001001', '上传数据', '上传数据', '2', '/car/uploader', '4');
INSERT INTO `tbl_function` VALUES ('F001002', '数据列表', '数据列表', '2', '/car/list', '4');
INSERT INTO `tbl_function` VALUES ('F002', '数据统计', '数据统计', '1', '#', '4');
INSERT INTO `tbl_function` VALUES ('F002001', '数据统计', '数据统计', '2', '/car/dataStatistics', '4');
INSERT INTO `tbl_function` VALUES ('F003', '检测预警', '检测预警', '1', '/car/warning', '4');
INSERT INTO `tbl_function` VALUES ('F004', '批量导出', '批量导出', '1', '/car/batchExport', '4');
INSERT INTO `tbl_function` VALUES ('F005', '黑名单管理', '黑名单管理', '1', '/blackList', '4');
INSERT INTO `tbl_function` VALUES ('F006', '车系管理', '车系管理', '1', '#', '4');
INSERT INTO `tbl_function` VALUES ('F006001', '车系列表', '车系列表', '2', '/carSystem/info', '4');
INSERT INTO `tbl_function` VALUES ('F007', '\r\n友道汽车流量分析', '\r\n友道汽车流量分析', '1', '/flowAnalysis/list', '1');
INSERT INTO `tbl_function` VALUES ('F008', '广告投放创建', '广告投放创建', '1', '/adServing', '1');
INSERT INTO `tbl_function` VALUES ('F009', '广告项目管理', '广告项目管理', '1', '/adProManage', '1');
INSERT INTO `tbl_function` VALUES ('F010', '\r\n线下流量分析', '\r\n线下流量分析', '1', '/offLine', '2');
INSERT INTO `tbl_function` VALUES ('F011', '目标潜客筛选', '目标潜客筛选', '1', '/filter', '2');
INSERT INTO `tbl_function` VALUES ('F012', '意向客户采集', '意向客户采集', '1', '/intentClient', '3');
INSERT INTO `tbl_function` VALUES ('F013', '转化数据上传', '转化数据上传', '1', 'javascript:layer.msg(\'功能正在开发中...\');', '3');
INSERT INTO `tbl_function` VALUES ('F014', '账号管理', '账号管理', '1', '/accountManage', '5');
INSERT INTO `tbl_function` VALUES ('F015', '账号资料设置', '账号资料设置', '1', 'javascript:layer.msg(\'功能正在开发中...\');', '5');
INSERT INTO `tbl_function` VALUES ('F016', '账号操作记录', '账号操作记录', '1', 'javascript:layer.msg(\'功能正在开发中...\');', '5');

-- ----------------------------
-- Table structure for tbl_intent_client
-- ----------------------------
DROP TABLE IF EXISTS `tbl_intent_client`;
CREATE TABLE `tbl_intent_client` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `insert_date` date DEFAULT NULL COMMENT '采集时间',
  `user_name` varchar(1000) DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(1000) DEFAULT NULL COMMENT '手机',
  `age` varchar(1000) DEFAULT NULL COMMENT '年龄',
  `brand_name` varchar(1000) DEFAULT NULL COMMENT '意向品牌',
  `car_sys` varchar(1000) DEFAULT NULL COMMENT '意向车系',
  `car_product` varchar(1000) DEFAULT NULL COMMENT '意向车系金融产品',
  `stage` varchar(1000) DEFAULT NULL COMMENT '所处阶段',
  `source` varchar(1000) DEFAULT NULL COMMENT '来源经销商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_intent_client
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_offline_filter
-- ----------------------------
DROP TABLE IF EXISTS `tbl_offline_filter`;
CREATE TABLE `tbl_offline_filter` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `insert_date` date DEFAULT NULL COMMENT '载入时间',
  `source` varchar(1000) DEFAULT NULL COMMENT '时刻来源（经销商）',
  `city` varchar(1000) DEFAULT NULL COMMENT '所在城市',
  `brand_name` varchar(1000) DEFAULT NULL COMMENT '所属品牌',
  `offline_flow` varchar(1000) DEFAULT NULL COMMENT '线下流量',
  `stay_date` varchar(1000) DEFAULT NULL COMMENT '平均停留时间',
  `insert_month` varchar(1000) DEFAULT NULL COMMENT '插入月份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_offline_filter
-- ----------------------------
INSERT INTO `tbl_offline_filter` VALUES ('057E9025218F49466630BC60BE58C678', '2018-01-25', '南京致远汽车', '南京', '上汽大众', '13', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('0DDFBD8BE6F97320614F4F38D2B7AE25', '2018-01-01', '广汽京通', '北京', '传祺', '23', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('139900A10F39038C4A5057FC0B812A9C', '2018-01-27', '广汽本田安大店', '长沙', '广汽本田', '24', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('15E268EB24ED589B739E6B75055E7F67', '2018-01-07', '厦门信达丰田', '厦门', '广汽丰田', '34', '1.1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('1D38CB8349E5025222B5D33D4127EBF9', '2018-01-19', '青岛德宝佳', '青岛', '宝马', '34', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('20045D51F22C4BC3A8F06C0A2F8EDEB9', '2018-01-20', '浙江星杭汽车', '杭州', '奔驰', '21', '1.2', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('2FFC4B14CF4CD1D921BA4B315987B1AB', '2018-01-24', '南京天众汽车', '南京', '上汽大众', '17', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('318C80903AEBA0334FFB395E6F9D345C', '2018-01-18', '广汽本田瑞冠店', '青岛', '广汽本田', '5', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('32D214365E010BBA2164E7F43A797B71', '2018-01-14', '广汽本田成邦店', '长春', '广汽本田', '2', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('437C5A997AB1E641852BEA49806C4748', '2018-01-06', '厦门国贸通达', '厦门', '上汽通用别克', '67', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('45B4E386B3106C6BEA8F7612387A409A', '2018-01-09', '河南瑞丰汽车', '郑州', '长城', '39', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('55542E309E9F63E4AE8184DAB8355ADF', '2018-01-26', '湖南有道长城', '长沙', '长城', '12', '0.8', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('5D06758666E7CC5BCB6D615ABD237541', '2018-01-13', '吉林吉刚', '长春', '一汽大众', '13', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('5D22F81084C7A4B13D5F756D4DEED0B9', '2018-01-28', '重庆长俊', '重庆', '广汽本田', '12', '0.8', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('69B423F1248F44057D869204F939AE28', '2018-01-04', '永达奥迪中环店', '上海', '奥迪', '12', '0.8', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('893FE750EAC8C111661ABCD56718A3D4', '2018-01-12', '石家庄裕华丰田', '石家庄', '一汽丰田', '21', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('8C7C83678537D1C90F56E9754B89A03E', '2018-01-11', '信创和平东路店', '石家庄', '广汽丰田', '86', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('A38302327730625F6FC8284C1E75DEE3', '2018-01-23', '鼎杰专营店', '呼和浩特', '东风日产', '16', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('AC5A67A2419D88579353CDEE7F3B84E3', '2018-01-21', '浙江众美', '杭州', '上汽大众', '25', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('B0DED2B156A6A24D4BDA54BC2B4ABAF6', '2018-01-05', '上海绿地徐盛', '上海', '东风本田', '23', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('B4C9C35D0BF5AE37857AAA688FE0DB88', '2018-01-03', '深圳宝泰行宝马', '深圳', '宝马', '32', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('C870FB831997D6EB87A2D07CB1C0C9BA', '2018-01-15', '沈阳铁西华通', '沈阳', '一汽丰田', '12', '0.8', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('C8BEF9AE1A923E6A749C6E46FE4CE1FE', '2018-01-10', '广汽丰田花园路店', '郑州', '广汽丰田', '24', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('CE6584A9E31652FE0D0802C9CE764E78', '2018-01-16', '辽宁天合汽车', '沈阳', '上汽通用别克', '73', '0.5', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('D674E59D3F178616030BB75AD550A117', '2018-01-02', '宝安大兴大众', '深圳', '大众', '45', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('E65168CB6B97DF8D0F0DC93681A91913', '2018-01-22', '呼和浩特金川丰田', '呼和浩特', '一汽丰田', '21', '0.8', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('EA49178CFBDBB6BE8A78A147BDD927F2', '2018-01-17', '沈阳德驰东本', '沈阳', '东风本田', '34', '1', '2018-01');
INSERT INTO `tbl_offline_filter` VALUES ('F5D64245F316ED79ADA0ADDBF487D77E', '2018-01-08', '国贸广本海沧店', '厦门', '东风本田', '24', '1', '2018-01');

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` varchar(35) NOT NULL,
  `role_name` varchar(50) NOT NULL DEFAULT '',
  `role_description` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('1', '管理员', '管理员');

-- ----------------------------
-- Table structure for tbl_rolefunction
-- ----------------------------
DROP TABLE IF EXISTS `tbl_rolefunction`;
CREATE TABLE `tbl_rolefunction` (
  `role_id` varchar(35) NOT NULL,
  `function_id` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F007');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F009');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F010');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F011');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F012');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F013');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F014');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F015');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F008');
INSERT INTO `tbl_rolefunction` VALUES ('1', 'F016');

-- ----------------------------
-- Table structure for tbl_show
-- ----------------------------
DROP TABLE IF EXISTS `tbl_show`;
CREATE TABLE `tbl_show` (
  `id` varchar(35) NOT NULL COMMENT '主键',
  `source` varchar(1000) DEFAULT NULL COMMENT '来源',
  `intention_person` varchar(1000) DEFAULT NULL COMMENT '意向人',
  `city_orientation` varchar(1000) DEFAULT NULL COMMENT '城市定向',
  `intention_brand` varchar(1000) DEFAULT NULL COMMENT '意向品牌',
  `intention_trade` varchar(1000) DEFAULT NULL COMMENT '意向厂商',
  `intention_model` varchar(1000) DEFAULT NULL COMMENT '意向车型',
  `phone` varchar(1000) DEFAULT NULL COMMENT '手机号',
  `network_num` varchar(1000) DEFAULT NULL COMMENT '网络跟踪频次',
  `analysis` varchar(1000) DEFAULT NULL COMMENT '购车意向分析',
  `car_month` varchar(1000) DEFAULT NULL COMMENT '欲购车月份',
  `insert_date` varchar(1000) DEFAULT NULL COMMENT '载入时间',
  PRIMARY KEY (`id`),
  KEY `show_source_index` (`source`(255)) USING BTREE,
  KEY `show_intention_person_index` (`intention_person`(255)) USING BTREE,
  KEY `show_city_orientation_index` (`city_orientation`(255)) USING BTREE,
  KEY `show_intention_brand_index` (`intention_brand`(255)) USING BTREE,
  KEY `show_intention_trade_index` (`intention_trade`(255)) USING BTREE,
  KEY `show_intention_model_index` (`intention_model`(255)) USING BTREE,
  KEY `show_phone_index` (`phone`(255)) USING BTREE,
  KEY `show_network_num_index` (`network_num`(255)) USING BTREE,
  KEY `show_analysis_index` (`analysis`(255)) USING BTREE,
  KEY `show_car_month_index` (`car_month`(255)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_show
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` varchar(35) NOT NULL,
  `usercode` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `username` varchar(50) DEFAULT NULL,
  `is_black` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否开启黑名单1是0否',
  `is_brand` varchar(1) DEFAULT '0' COMMENT '是否开启品牌检查开关1是0否',
  `is_trade` varchar(1) DEFAULT '0' COMMENT '是否开启厂商开关1是0否',
  `is_phone` varchar(1) DEFAULT '0' COMMENT '是否开启号段检查1是0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'test@qq.com', '测试', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for tbl_userrole
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userrole`;
CREATE TABLE `tbl_userrole` (
  `user_id` varchar(35) NOT NULL,
  `role_id` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tbl_userrole
-- ----------------------------
INSERT INTO `tbl_userrole` VALUES ('1', '1');
