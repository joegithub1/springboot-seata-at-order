/*
 Navicat Premium Data Transfer

 Source Server         : 本机127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 127.0.0.1:3306
 Source Schema         : seata_at_order

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 23/07/2023 15:47:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `good_id` bigint NULL DEFAULT NULL COMMENT '商品ID',
  `good_num` bigint NULL DEFAULT NULL COMMENT '购买数量',
  `status` int NULL DEFAULT 0 COMMENT '状态',
  `order_amount` double NULL DEFAULT NULL COMMENT '订单总金额',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (68581738157400, 1, 2, 1, 1, 200, NULL, NULL);
INSERT INTO `t_order` VALUES (68623852363400, 1, 2, 2, 1, 400, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
