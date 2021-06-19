/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : xt_taoyiquan

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 19/06/2021 23:37:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for x_admin
-- ----------------------------
DROP TABLE IF EXISTS `x_admin`;
CREATE TABLE `x_admin`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `lastLoginTime` datetime NULL DEFAULT NULL COMMENT '最近登陆时间',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xt_role
-- ----------------------------
DROP TABLE IF EXISTS `xt_role`;
CREATE TABLE `xt_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `roleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色代码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xt_role
-- ----------------------------
INSERT INTO `xt_role` VALUES (1, '2021-06-19 23:31:58', '2021-06-19 23:32:01', '管理员', 'admin');
INSERT INTO `xt_role` VALUES (2, '2021-06-19 23:32:15', '2021-06-19 23:32:17', '用户', 'user');

-- ----------------------------
-- Table structure for xt_user
-- ----------------------------
DROP TABLE IF EXISTS `xt_user`;
CREATE TABLE `xt_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xt_user_role
-- ----------------------------
DROP TABLE IF EXISTS `xt_user_role`;
CREATE TABLE `xt_user_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `roleId` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
