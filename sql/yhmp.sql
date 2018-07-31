/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : yhmp

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-31 16:33:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_project_id` int(11) DEFAULT NULL,
  `planSchedule` int(11) DEFAULT NULL COMMENT '计划进度',
  `declareProject` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `responsibilityName` varchar(255) DEFAULT NULL COMMENT '项目负责人',
  `projectPlan` int(11) DEFAULT NULL COMMENT '各阶段',
  `projectContent` varchar(255) DEFAULT NULL COMMENT '项目计划内容',
  `finishTime` varchar(255) DEFAULT NULL COMMENT '项目计划完成时间',
  `personLiable` varchar(255) DEFAULT NULL COMMENT '项目成员',
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `projectPlan` (`projectPlan`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('198', '21', '0', '33', 'test3', '1', '未填写', '2018-7-30', '111');
INSERT INTO `plan` VALUES ('199', '20', '0', '22', 'test2', '1', '未填写', '2018-7-30', '未填写');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pk_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `declareProject` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `declareNumber` varchar(255) DEFAULT NULL COMMENT '项目编号',
  `declareFraction` varchar(255) DEFAULT NULL COMMENT '项目标准分',
  `declareScale` varchar(255) DEFAULT NULL COMMENT '项目规模',
  `declareArrange` varchar(255) DEFAULT NULL COMMENT '项目类型：整理',
  `declareAssess` varchar(255) DEFAULT NULL COMMENT '项目类型 ：评估',
  `declareSurveying` varchar(255) DEFAULT NULL COMMENT '项目类型：测绘',
  `declarePlan` varchar(255) DEFAULT NULL COMMENT '项目类型：规划',
  `contract` int(3) DEFAULT NULL COMMENT '合同签订情况：1为签订，0为未签订',
  `declareCompany` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `declareName` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `declarePhone` varchar(255) DEFAULT NULL COMMENT '联系人电话',
  `finishTime` varchar(255) DEFAULT NULL COMMENT '项目完成时间',
  `quality` int(10) DEFAULT NULL COMMENT '项目质量要求：1为优秀，2为良好，3为合格',
  `Bid` int(10) DEFAULT NULL COMMENT '是否需要招投标：1为需要，2为不需要，3为不确定',
  `responsibilityName` varchar(255) DEFAULT NULL COMMENT '负责人姓名',
  `responsibilityPhone` varchar(255) DEFAULT NULL COMMENT '负责人电话',
  `all_planSchedule` int(5) DEFAULT '0' COMMENT '项目总进度',
  `if_preservation` int(10) DEFAULT '0' COMMENT '是否已经提交归档：1为提交，0为未提交',
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `user_name` (`responsibilityName`) USING BTREE,
  CONSTRAINT `user_name` FOREIGN KEY (`responsibilityName`) REFERENCES `user` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('19', '11', '11', '11', '11', '11', '11', '11', '11', '0', '11', '11', '11', '2018-07-07', '3', '2', '我叫略略略', '111', '0', '0');
INSERT INTO `project` VALUES ('20', '22', '22', '22', '22', '22', '22', '22', '22', '0', '22', '22', '22', '2018-07-16', '3', '2', 'test2', '22', '100', '1');
INSERT INTO `project` VALUES ('21', '33', '33', '33', '334', '33', '33', '33', '33', '0', '33', '33', '33', '2018-07-14', '3', '1', 'test3', '33', '100', '1');

-- ----------------------------
-- Table structure for `project_preservation`
-- ----------------------------
DROP TABLE IF EXISTS `project_preservation`;
CREATE TABLE `project_preservation` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_project_id` int(11) DEFAULT NULL COMMENT 'project表主键，外键',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `collect_data` varchar(255) DEFAULT NULL COMMENT '项目搜集资料',
  `field_work` varchar(255) DEFAULT NULL COMMENT '外业调查资料',
  `review_data` varchar(255) DEFAULT NULL COMMENT '项目评审资料',
  `collect_data_file` varchar(255) DEFAULT NULL COMMENT '项目搜集资料_上传文件字段',
  `field_work_file` varchar(255) DEFAULT NULL COMMENT '外业调查资料_上传文件字段',
  `review_data_file` varchar(255) DEFAULT NULL COMMENT '项目评审资料_上传文件字段',
  `achievement_type` varchar(255) DEFAULT NULL COMMENT '项目成果资料',
  `if_auditing` int(3) DEFAULT NULL COMMENT '项目是否审核：0为未审核，1为已审核',
  `project_agreement` int(3) DEFAULT NULL COMMENT '项目协议书：0为未具备，1未已具备',
  `project_number` varchar(255) DEFAULT NULL COMMENT '协议书编号',
  `other_data` varchar(255) DEFAULT NULL COMMENT '其他资料',
  `other_data_file` varchar(255) DEFAULT NULL COMMENT '其他资料_上传字段',
  `preservation_date` varchar(255) DEFAULT NULL COMMENT '归档日期',
  `sendee` varchar(255) DEFAULT NULL COMMENT '接受人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `project_id` (`fk_project_id`) USING BTREE,
  CONSTRAINT `project_preservation_ibfk_1` FOREIGN KEY (`fk_project_id`) REFERENCES `project` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of project_preservation
-- ----------------------------
INSERT INTO `project_preservation` VALUES ('10', '21', '33', '111', '222', '333', null, null, null, '报告,预算书', '0', '1', '444', '555', null, '2018-07-20', '777', '666');
INSERT INTO `project_preservation` VALUES ('11', '20', '22', '111', '222', '12341234', null, null, null, '报告', '1', '1', '444', '23452345', null, '2018-07-13', '777', '2345');

-- ----------------------------
-- Table structure for `project_summary`
-- ----------------------------
DROP TABLE IF EXISTS `project_summary`;
CREATE TABLE `project_summary` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_project_id` int(11) DEFAULT NULL,
  `reviewSuggestion` varchar(255) DEFAULT NULL,
  `technicalSummary` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `otherSummary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `id` (`fk_project_id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`fk_project_id`) REFERENCES `project` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of project_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `true_plan`
-- ----------------------------
DROP TABLE IF EXISTS `true_plan`;
CREATE TABLE `true_plan` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `fk_project_id` int(11) DEFAULT NULL COMMENT '外键',
  `planSchedule` int(11) DEFAULT NULL,
  `projectPlan` int(11) NOT NULL,
  `projectContent` varchar(255) DEFAULT NULL COMMENT '项目计划内容',
  `finishTime` varchar(255) DEFAULT NULL COMMENT '项目计划完成时间',
  `timeAdjustment` varchar(255) DEFAULT NULL COMMENT '项目成员',
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `projectPlan` (`projectPlan`) USING BTREE,
  KEY `fk_id` (`fk_project_id`) USING BTREE,
  CONSTRAINT `fk_id` FOREIGN KEY (`fk_project_id`) REFERENCES `project` (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of true_plan
-- ----------------------------
INSERT INTO `true_plan` VALUES ('162', '21', '0', '1', '未填写', '2018-7-30', '未填写');
INSERT INTO `true_plan` VALUES ('163', '20', '0', '1', '未填写', '2018-7-30', '未填写');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `pk_id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '000000',
  `job` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `hiredate` varchar(25) DEFAULT '',
  `phone` varchar(30) DEFAULT NULL,
  `status` int(3) NOT NULL,
  `domicile` varchar(255) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  `authority` varchar(255) DEFAULT '0' COMMENT '用户权限',
  `jobAge` int(90) DEFAULT '0' COMMENT '工龄',
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('-1', 'admin', 'admin', '管理员', '1', '2018-04-09', '1122334455', '0', '山东省', '1', '18', '0,1,2,21,22,23,24,4,41,42,43,44,6,61,62,63,64,65,7', null);
INSERT INTO `user` VALUES ('17', '我叫略略略', '000000', '测绘师', '一部', '2018-07-21', '18855585855', '0', '山东', '1', '25', '0,1,2,23', null);
INSERT INTO `user` VALUES ('18', 'test2', '000000', '测绘师', '一部', '2018-07-21', '18855585855', '0', '山东', '1', '25', '0', null);
INSERT INTO `user` VALUES ('19', 'test3', '000000', '测绘师', '一部', '2018-07-21', '18855585855', '0', '山东', '1', '25', '0', null);
INSERT INTO `user` VALUES ('20', 'test3', '000000', '测绘师', '一部', '2018-07-21', '18855585855', '0', '山东', '1', '25', '0', null);

-- ----------------------------
-- Table structure for `user_logs`
-- ----------------------------
DROP TABLE IF EXISTS `user_logs`;
CREATE TABLE `user_logs` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  `operate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE,
  KEY `fk_user_id` (`fk_user_id`) USING BTREE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_logs
-- ----------------------------

-- ----------------------------
-- View structure for `select_all_preservation_project`
-- ----------------------------
DROP VIEW IF EXISTS `select_all_preservation_project`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `select_all_preservation_project` AS select `project`.`pk_id` AS `pk_id`,`project`.`declareProject` AS `declareProject`,`project`.`declareNumber` AS `declareNumber`,`project`.`declareScale` AS `declareScale`,`project`.`finishTime` AS `finishTime`,`project_preservation`.`preservation_date` AS `preservation_date`,`project_preservation`.`remarks` AS `remarks`,`project_preservation`.`achievement_type` AS `achievement_type`,`project`.`contract` AS `contract`,`project`.`if_preservation` AS `if_preservation`,`project`.`responsibilityName` AS `responsibilityName` from (`project` join `project_preservation` on((`project_preservation`.`fk_project_id` = `project`.`pk_id`))) ;
DROP TRIGGER IF EXISTS `update_preservation`;
DELIMITER ;;
CREATE TRIGGER `update_preservation` AFTER INSERT ON `project_preservation` FOR EACH ROW UPDATE project 
SET if_preservation = 1
WHERE pk_id = (
	SELECT fk_project_id 
	FROM project_preservation
	WHERE pk_id = (
		SELECT MAX(pk_id)
		FROM project_preservation
	)
)
;
;;
DELIMITER ;
