-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 192.168.111.129    Database: xshop_goods
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
-- Table structure for table `tb_album`
--

DROP TABLE IF EXISTS `tb_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) DEFAULT NULL COMMENT '相册名称',
  `image` varchar(100) DEFAULT NULL COMMENT '相册封面',
  `image_items` text COMMENT '图片列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_brand`
--

DROP TABLE IF EXISTS `tb_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `image` varchar(1000) DEFAULT '' COMMENT '品牌图片地址',
  `letter` char(1) DEFAULT '' COMMENT '品牌的首字母',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=325419 DEFAULT CHARSET=utf8 COMMENT='品牌表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `goods_num` int(11) DEFAULT '0' COMMENT '商品数量',
  `is_show` char(1) DEFAULT NULL COMMENT '是否显示',
  `is_menu` char(1) DEFAULT NULL COMMENT '是否导航',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `parent_id` int(20) DEFAULT NULL COMMENT '上级ID',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1218 DEFAULT CHARSET=utf8 COMMENT='商品类目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_category_brand`
--

DROP TABLE IF EXISTS `tb_category_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_category_brand` (
  `category_id` int(11) NOT NULL COMMENT '分类ID',
  `brand_id` int(11) NOT NULL COMMENT '品牌ID',
  PRIMARY KEY (`category_id`,`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_para`
--

DROP TABLE IF EXISTS `tb_para`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_para` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '选项',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_pref`
--

DROP TABLE IF EXISTS `tb_pref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cate_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `buy_money` int(11) DEFAULT NULL COMMENT '消费金额',
  `pre_money` int(11) DEFAULT NULL COMMENT '优惠金额',
  `start_time` date DEFAULT NULL COMMENT '活动开始日期',
  `end_time` date DEFAULT NULL COMMENT '活动截至日期',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `state` char(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_sku`
--

DROP TABLE IF EXISTS `tb_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sku` (
  `id` varchar(20) NOT NULL COMMENT '商品id',
  `sn` varchar(100) NOT NULL COMMENT '商品条码',
  `name` varchar(200) NOT NULL COMMENT 'SKU名称',
  `price` int(20) NOT NULL COMMENT '价格（分）',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `alert_num` int(11) DEFAULT NULL COMMENT '库存预警数量',
  `image` varchar(200) DEFAULT NULL COMMENT '商品图片',
  `images` varchar(2000) DEFAULT NULL COMMENT '商品图片列表',
  `weight` int(11) DEFAULT NULL COMMENT '重量（克）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `spu_id` varchar(20) DEFAULT NULL COMMENT 'SPUID',
  `category_id` int(10) DEFAULT NULL COMMENT '类目ID',
  `category_name` varchar(200) DEFAULT NULL COMMENT '类目名称',
  `brand_name` varchar(100) DEFAULT NULL COMMENT '品牌名称',
  `spec` varchar(200) DEFAULT NULL COMMENT '规格',
  `sale_num` int(11) DEFAULT '0' COMMENT '销量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `status` char(1) DEFAULT '1' COMMENT '商品状态 1-正常，2-下架，3-删除',
  PRIMARY KEY (`id`),
  KEY `cid` (`category_id`),
  KEY `status` (`status`),
  KEY `updated` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_spec`
--

DROP TABLE IF EXISTS `tb_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '规格选项',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_spu`
--

DROP TABLE IF EXISTS `tb_spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_spu` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `sn` varchar(60) DEFAULT NULL COMMENT '货号',
  `name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `category1_id` int(20) DEFAULT NULL COMMENT '一级分类',
  `category2_id` int(10) DEFAULT NULL COMMENT '二级分类',
  `category3_id` int(10) DEFAULT NULL COMMENT '三级分类',
  `template_id` int(20) DEFAULT NULL COMMENT '模板ID',
  `freight_id` int(11) DEFAULT NULL COMMENT '运费模板id',
  `image` varchar(100) DEFAULT NULL COMMENT '图片',
  `images` varchar(1000) DEFAULT NULL COMMENT '图片列表',
  `sale_service` varchar(50) DEFAULT NULL COMMENT '售后服务',
  `introduction` text COMMENT '介绍',
  `spec_items` varchar(3000) DEFAULT NULL COMMENT '规格列表',
  `para_items` varchar(3000) DEFAULT NULL COMMENT '参数列表',
  `sale_num` int(11) DEFAULT '0' COMMENT '销量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `is_marketable` char(1) DEFAULT '0' COMMENT '是否上架',
  `is_enable_spec` char(1) DEFAULT '1' COMMENT '是否启用规格',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除',
  `status` char(1) DEFAULT '0' COMMENT '审核状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_stock_back`
--

DROP TABLE IF EXISTS `tb_stock_back`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_stock_back` (
  `order_id` varchar(20) NOT NULL COMMENT '订单id',
  `sku_id` varchar(20) NOT NULL COMMENT 'SKU的id',
  `num` int(11) DEFAULT NULL COMMENT '回滚数量',
  `status` char(1) DEFAULT NULL COMMENT '回滚状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `back_time` datetime DEFAULT NULL COMMENT '回滚时间',
  PRIMARY KEY (`order_id`,`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_template`
--

DROP TABLE IF EXISTS `tb_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `spec_num` int(11) DEFAULT '0' COMMENT '规格数量',
  `para_num` int(11) DEFAULT '0' COMMENT '参数数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-23  1:22:10
