SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for x_admin
-- ----------------------------
DROP TABLE IF EXISTS `x_admin`;
CREATE TABLE `x_admin`
(
    `id`            bigint NOT NULL COMMENT '主键id',
    `createTime`    datetime NULL DEFAULT NULL COMMENT '创建时间',
    `modifyTime`    datetime NULL DEFAULT NULL COMMENT '修改时间',
    `lastLoginTime` datetime NULL DEFAULT NULL COMMENT '最近登陆时间',
    `account`       varchar(255) NULL DEFAULT NULL COMMENT '登录账号',
    `userName`      varchar(255) NULL DEFAULT NULL COMMENT '用户名',
    `password`      varchar(255) NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of x_admin
-- ----------------------------
INSERT INTO `x_admin`
VALUES (123, '2024-05-17 00:41:52', '2024-05-17 00:41:54', '2024-05-17 14:43:13', 'test', 'test',
        '$2a$10$2N3WoKxR8LB6Q.kH3Wo2xOi85TBfjTY0rwMZtsxxGRYN6pBU2zgZS');

-- ----------------------------
-- Table structure for x_role
-- ----------------------------
DROP TABLE IF EXISTS `x_role`;
CREATE TABLE `x_role`
(
    `id`         bigint NOT NULL COMMENT '主键id',
    `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
    `roleName`   varchar(255) NULL DEFAULT NULL COMMENT '角色名',
    `roleCode`   varchar(255) NULL DEFAULT NULL COMMENT '角色代码',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of x_role
-- ----------------------------
INSERT INTO `x_role`
VALUES (1, '2021-06-19 23:31:58', '2021-06-19 23:32:01', '管理员', 'admin');
INSERT INTO `x_role`
VALUES (2, '2021-06-19 23:32:15', '2021-06-19 23:32:17', '用户', 'user');

-- ----------------------------
-- Table structure for x_user
-- ----------------------------
DROP TABLE IF EXISTS `x_user`;
CREATE TABLE `x_user`
(
    `id`         bigint NOT NULL COMMENT '主键id',
    `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
    `account`    varchar(255) NULL DEFAULT NULL COMMENT '登录账号',
    `userName`   varchar(255) NULL DEFAULT NULL COMMENT '用户名',
    `password`   varchar(255) NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of x_user
-- ----------------------------
INSERT INTO `x_user`
VALUES (1, '2024-05-14 23:04:12', '2024-05-14 23:04:14', 'test', 'test',
        '$2a$10$2N3WoKxR8LB6Q.kH3Wo2xOi85TBfjTY0rwMZtsxxGRYN6pBU2zgZS');
INSERT INTO `x_user`
VALUES (2, '2024-05-14 23:04:12', '2024-05-14 23:04:14', 'admin', 'admin',
        '$2a$10$2N3WoKxR8LB6Q.kH3Wo2xOi85TBfjTY0rwMZtsxxGRYN6pBU2zgZS');

-- ----------------------------
-- Table structure for x_user_role
-- ----------------------------
DROP TABLE IF EXISTS `x_user_role`;
CREATE TABLE `x_user_role`
(
    `id`         bigint NOT NULL COMMENT '主键id',
    `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `modifyTime` datetime NULL DEFAULT NULL COMMENT '修改时间',
    `userId`     bigint NULL DEFAULT NULL COMMENT '用户id',
    `roleId`     bigint NULL DEFAULT NULL COMMENT '角色id',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '管理员和用户的角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of x_user_role
-- ----------------------------
INSERT INTO `x_user_role`
VALUES (1, '2024-05-14 23:37:45', '2024-05-14 23:37:50', 1, 2);
INSERT INTO `x_user_role`
VALUES (2, '2024-05-17 00:36:27', '2024-05-17 00:36:29', 2, 1);
INSERT INTO `x_user_role`
VALUES (3, '2024-05-17 00:42:59', '2024-05-17 00:43:03', 123, 1);

SET
FOREIGN_KEY_CHECKS = 1;
