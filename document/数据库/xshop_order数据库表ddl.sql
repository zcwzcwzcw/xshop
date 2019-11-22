-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 192.168.111.129    Database: xshop_order
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
-- Table structure for table `tb_category_report`
--

DROP TABLE IF EXISTS `tb_category_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_category_report` (
  `category_id1` int(11) NOT NULL COMMENT '1级分类',
  `category_id2` int(11) NOT NULL COMMENT '2级分类',
  `category_id3` int(11) NOT NULL COMMENT '3级分类',
  `count_date` date NOT NULL COMMENT '统计日期',
  `num` int(11) DEFAULT NULL COMMENT '销售数量',
  `money` int(11) DEFAULT NULL COMMENT '销售额',
  PRIMARY KEY (`category_id1`,`category_id2`,`category_id3`,`count_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_order`
--

DROP TABLE IF EXISTS `tb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_order` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '订单id',
  `total_num` int(11) DEFAULT NULL COMMENT '数量合计',
  `total_money` int(11) DEFAULT NULL COMMENT '金额合计',
  `pre_money` int(11) DEFAULT NULL COMMENT '优惠金额',
  `post_fee` int(11) DEFAULT NULL COMMENT '邮费',
  `pay_money` int(11) DEFAULT NULL COMMENT '实付金额',
  `pay_type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '支付类型，1、在线支付、0 货到付款',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单更新时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `shipping_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流单号',
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名称',
  `buyer_message` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '买家留言',
  `buyer_rate` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否评价',
  `receiver_contact` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `receiver_mobile` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人手机',
  `receiver_address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人地址',
  `source_type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面',
  `transaction_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '交易流水号',
  `order_status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '订单状态',
  `pay_status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '支付状态',
  `consign_status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '发货状态',
  `is_delete` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`),
  KEY `status` (`order_status`),
  KEY `payment_type` (`pay_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_order_config`
--

DROP TABLE IF EXISTS `tb_order_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_order_config` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `order_timeout` int(11) DEFAULT NULL COMMENT '正常订单超时时间（分）',
  `seckill_timeout` int(11) DEFAULT NULL COMMENT '秒杀订单超时时间（分）',
  `take_timeout` int(11) DEFAULT NULL COMMENT '自动收货（天）',
  `service_timeout` int(11) DEFAULT NULL COMMENT '售后期限',
  `comment_timeout` int(11) DEFAULT NULL COMMENT '自动五星好评',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_order_item`
--

DROP TABLE IF EXISTS `tb_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_order_item` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'ID',
  `category_id1` int(11) DEFAULT NULL COMMENT '1级分类',
  `category_id2` int(11) DEFAULT NULL COMMENT '2级分类',
  `category_id3` int(11) DEFAULT NULL COMMENT '3级分类',
  `spu_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'SPU_ID',
  `sku_id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'SKU_ID',
  `order_id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '订单ID',
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `price` int(20) DEFAULT NULL COMMENT '单价',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `money` int(20) DEFAULT NULL COMMENT '总金额',
  `pay_money` int(11) DEFAULT NULL COMMENT '实付金额',
  `image` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `weight` int(11) DEFAULT NULL COMMENT '重量',
  `post_fee` int(11) DEFAULT NULL COMMENT '运费',
  `is_return` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '是否退货',
  PRIMARY KEY (`id`),
  KEY `item_id` (`sku_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_order_log`
--

DROP TABLE IF EXISTS `tb_order_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_order_log` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `operater` varchar(50) DEFAULT NULL COMMENT '操作员',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `order_id` varchar(20) DEFAULT NULL COMMENT '订单ID',
  `order_status` char(1) DEFAULT NULL COMMENT '订单状态',
  `pay_status` char(1) DEFAULT NULL COMMENT '付款状态',
  `consign_status` char(1) DEFAULT NULL COMMENT '发货状态',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_preferential`
--

DROP TABLE IF EXISTS `tb_preferential`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_preferential` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `buy_money` int(11) DEFAULT NULL COMMENT '消费金额',
  `pre_money` int(11) DEFAULT NULL COMMENT '优惠金额',
  `category_id` int(20) DEFAULT NULL COMMENT '品类ID',
  `start_time` date DEFAULT NULL COMMENT '活动开始日期',
  `end_time` date DEFAULT NULL COMMENT '活动截至日期',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `type` varchar(1) DEFAULT NULL COMMENT '类型1不翻倍 2翻倍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_return_cause`
--

DROP TABLE IF EXISTS `tb_return_cause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_return_cause` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cause` varchar(100) DEFAULT NULL COMMENT '原因',
  `seq` int(11) DEFAULT '1' COMMENT '排序',
  `status` char(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_return_order`
--

DROP TABLE IF EXISTS `tb_return_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_return_order` (
  `id` bigint(20) NOT NULL COMMENT '服务单号',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单号',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_account` varchar(11) DEFAULT NULL COMMENT '用户账号',
  `linkman` varchar(20) DEFAULT NULL COMMENT '联系人',
  `linkman_mobile` varchar(11) DEFAULT NULL COMMENT '联系人手机',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `return_money` int(11) DEFAULT NULL COMMENT '退款金额',
  `is_return_freight` char(1) DEFAULT NULL COMMENT '是否退运费',
  `status` char(1) DEFAULT NULL COMMENT '申请状态',
  `dispose_time` datetime DEFAULT NULL COMMENT '处理时间',
  `return_cause` int(11) DEFAULT NULL COMMENT '退货退款原因',
  `evidence` varchar(1000) DEFAULT NULL COMMENT '凭证图片',
  `description` varchar(1000) DEFAULT NULL COMMENT '问题描述',
  `remark` varchar(1000) DEFAULT NULL COMMENT '处理备注',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_return_order_item`
--

DROP TABLE IF EXISTS `tb_return_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_return_order_item` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `spu_id` bigint(20) DEFAULT NULL COMMENT 'SPU_ID',
  `sku_id` bigint(20) NOT NULL COMMENT 'SKU_ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `order_item_id` bigint(20) DEFAULT NULL COMMENT '订单明细ID',
  `return_order_id` bigint(20) NOT NULL COMMENT '退货订单ID',
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `price` int(20) DEFAULT NULL COMMENT '单价',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `money` int(20) DEFAULT NULL COMMENT '总金额',
  `pay_money` int(20) DEFAULT NULL COMMENT '支付金额',
  `image` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `weight` int(11) DEFAULT NULL COMMENT '重量',
  PRIMARY KEY (`id`),
  KEY `item_id` (`sku_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `v_category1`
--

DROP TABLE IF EXISTS `v_category1`;
/*!50001 DROP VIEW IF EXISTS `v_category1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_category1` AS SELECT 
 1 AS `id`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_category1`
--

/*!50001 DROP VIEW IF EXISTS `v_category1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_category1` AS select `xshop_goods`.`tb_category`.`id` AS `id`,`xshop_goods`.`tb_category`.`name` AS `name` from `xshop_goods`.`tb_category` where (`xshop_goods`.`tb_category`.`parent_id` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-23  1:22:37
