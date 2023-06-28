/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2023-06-26 13:21:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Aid` char(10) NOT NULL,
  `Aname` char(20) NOT NULL,
  `Apassword` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Aphone` char(20) NOT NULL,
  `Apermission` int(11) NOT NULL,
  PRIMARY KEY (`Aid`),
  UNIQUE KEY `Aid` (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2023479', '王建国大明', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023572', '赵红大明', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023706', '吴洋', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023708', '王琴大明', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023831', '黄鹤大明', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023884', '罗建国', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');
INSERT INTO `admin` VALUES ('2023922', '郭建国大明', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '256922335', '2');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `Bid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书编号',
  `Bname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书名称',
  `Bauthor` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书作者',
  `Bcategory` char(10) NOT NULL COMMENT '分类',
  `Bplace` char(20) NOT NULL COMMENT '图书位置',
  `Bpublisher` char(20) DEFAULT NULL COMMENT '出版社',
  `Byear` date DEFAULT NULL COMMENT '出版年份',
  `Bstatus` char(10) NOT NULL COMMENT '借阅状态',
  `Uid` char(10) DEFAULT NULL COMMENT '借阅者id',
  `Bbrodate` date DEFAULT NULL COMMENT '借阅时间',
  `Breturndate` date DEFAULT NULL COMMENT '应还日期',
  PRIMARY KEY (`Bid`),
  UNIQUE KEY `Bid` (`Bid`),
  KEY `Uid` (`Uid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`Uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2023WX0005', '雪国', '川端康成', '日本文学', '2楼西区20排B面4列1层', null, null, '已借出', '202305', '2023-06-26', '2023-07-26');
INSERT INTO `book` VALUES ('2023WX0012', '晚熟的人', '莫言', '中国文学', '2楼西区17排A面2列1层', null, null, '可借', null, null, null);
INSERT INTO `book` VALUES ('2023WX0017', '古都', '川端康成', '日本文学', '2楼西区20排B面4列2层', null, null, '已借出', '202305', '2023-04-20', '2023-06-19');
INSERT INTO `book` VALUES ('2023WX0018', '伊豆的舞女', '川端康成', '日本文学', '2楼西区20排B面4列1层', null, null, '已借出', '202305', '2023-04-21', '2023-06-20');
INSERT INTO `book` VALUES ('2023WX0023', '雪国', '川端康成', '日本文学', '2楼西区20排B面4列1层', null, null, '已借出', '2023212206', '2023-04-21', '2023-05-21');
INSERT INTO `book` VALUES ('2023WX0025', '蛙', '莫言', '中国文学', '2楼西区17排A面2列1层', null, null, '已借出', '2023212204', '2023-04-20', '2023-05-20');
INSERT INTO `book` VALUES ('2023WX0036', '蛙', '莫言', '中国文学', '2楼西区17排A面2列1层', null, null, '已借出', '202305', '2023-04-22', '2023-06-21');
INSERT INTO `book` VALUES ('2023WX0089', '古都', '川端康成', '日本文学', '2楼西区20排B面4列2层', null, null, '可借', null, null, null);
INSERT INTO `book` VALUES ('2023WX1019', '克苏鲁瑞秋魔法师', '塞拉芬娜', '剑圣文学', '3楼西区2排B面4列1层', '伊甸出版社', '2023-05-05', '已借出', '202305', '2023-05-05', '2023-06-04');
INSERT INTO `book` VALUES ('2023WX198', '狼王伊甸泰坦', '古老者', '文学', '3楼西区2排B面4列1层', '中国出版社', '2023-06-15', '已借出', '202305', '2023-06-15', '2023-07-15');
INSERT INTO `book` VALUES ('2023WX212', '黑龙麦丝玛拉巨人', '麦丝玛拉', '海怪文学', '3楼西区2排B面4列1层', '卡伊出版社', '2023-04-15', '已借出', '202305', '2023-04-15', '2023-05-15');
INSERT INTO `book` VALUES ('2023WX311', '夜魔艾薇儿魔法师', '麦丝玛拉', '黑龙文学', '3楼西区2排B面4列1层', '艾米莉亚出版社', '2023-03-14', '已借出', '202305', '2023-03-14', '2023-04-13');
INSERT INTO `book` VALUES ('2023WX440', '狮鹫伊甸猛犸', '蕾雅', '火龙文学', '3楼西区2排B面4列1层', '泰丝拉出版社', '2023-06-09', '已借出', '202305', '2023-06-09', '2023-07-09');
INSERT INTO `book` VALUES ('2023WX483', '矮人伊甸凤凰', '艾薇儿', '鸟人文学', '3楼西区2排B面4列1层', '斯蒂芬妮出版社', '2023-06-24', '已借出', '202305', '2023-06-24', '2023-07-24');
INSERT INTO `book` VALUES ('2023WX787', '凤凰卡伊狼王', '皮皮', '冰龙文学', '3楼西区2排B面4列1层', '乔伊出版社', '2023-01-21', '可借', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Uid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Uname` char(20) NOT NULL,
  `Usex` char(20) NOT NULL,
  `Uage` int(11) DEFAULT NULL,
  `Udept` char(20) NOT NULL,
  `Upassword` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Upermission` int(11) NOT NULL,
  PRIMARY KEY (`Uid`),
  UNIQUE KEY `Uid` (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('202305', '欢乐', '女', '23', '物联网', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('202307', '非农', '男', '19', '师范', '123456jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('20231400', '陈张丽华', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '4');
INSERT INTO `user` VALUES ('2023199', '希斯梁建国', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023212204', '马田', '男', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '4');
INSERT INTO `user` VALUES ('2023212206', '周国', '男', '22', '软工', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '4');
INSERT INTO `user` VALUES ('2023212208', '四流', '女', '20', '金融', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '4');
INSERT INTO `user` VALUES ('20232706', '马王建国', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('20232802', '宋罗玉', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023289', '希斯刘明', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023470', '希斯李鹤', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023491', '希斯马平', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023578', '明王明', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023617', '希斯王少华', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023642', '希斯杨芬', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023763', '天明', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023788', '希斯罗琴', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('20238775', '张郑明华', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023914', '宋琴', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('20239709', '梁何文', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
INSERT INTO `user` VALUES ('2023977', '希斯林文', '女', '21', '计算机', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', '3');
