-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 192.168.111.129    Database: xshop_user
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_address`
--

DROP TABLE IF EXISTS `tb_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `provinceid` varchar(20) DEFAULT NULL COMMENT '省',
  `cityid` varchar(20) DEFAULT NULL COMMENT '市',
  `areaid` varchar(20) DEFAULT NULL COMMENT '县/区',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `is_default` varchar(1) DEFAULT NULL COMMENT '是否是默认 1默认 0否',
  `alias` varchar(50) DEFAULT NULL COMMENT '别名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_areas`
--

DROP TABLE IF EXISTS `tb_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_areas` (
  `areaid` varchar(20) NOT NULL COMMENT '区域ID',
  `area` varchar(50) NOT NULL COMMENT '区域名称',
  `cityid` varchar(20) NOT NULL COMMENT '城市ID',
  PRIMARY KEY (`areaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区域县区信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_cities`
--

DROP TABLE IF EXISTS `tb_cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cities` (
  `cityid` varchar(20) NOT NULL COMMENT '城市ID',
  `city` varchar(50) NOT NULL COMMENT '城市名称',
  `provinceid` varchar(20) NOT NULL COMMENT '省份ID',
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区域地州市信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_provinces`
--

DROP TABLE IF EXISTS `tb_provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_provinces` (
  `provinceid` varchar(20) NOT NULL COMMENT '省份ID',
  `province` varchar(50) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`provinceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '修改时间',
  `source_type` varchar(1) DEFAULT NULL COMMENT '会员来源：1:PC，2：H5，3：Android，4：IOS',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(1) DEFAULT NULL COMMENT '使用状态（1正常 0非正常）',
  `head_pic` varchar(150) DEFAULT NULL COMMENT '头像地址',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
  `is_mobile_check` varchar(1) DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `is_email_check` varchar(1) DEFAULT '0' COMMENT '邮箱是否检测（0否  1是）',
  `sex` varchar(1) DEFAULT '1' COMMENT '性别，1男，0女',
  `user_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `experience_value` int(11) DEFAULT NULL COMMENT '经验值',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-23  1:23:38
