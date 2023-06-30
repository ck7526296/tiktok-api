/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : tiktok

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 01/07/2023 01:23:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for live
-- ----------------------------
DROP TABLE IF EXISTS `live`;
CREATE TABLE `live`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '直播间名字',
  `link` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '直播间链接',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '直播间' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of live
-- ----------------------------
INSERT INTO `live` VALUES (2, 'fgged', 'https://www.tiktok.com/@fgged/live', '2023-03-02 17:42:19', '美国');
INSERT INTO `live` VALUES (324, 'awfawe3gfwa', 'https://www.tiktok.com/@awfawe3gfwa/live', '2023-03-02 17:41:59', '英国');
INSERT INTO `live` VALUES (1631230211579564033, 'fasfwfwa', 'https://www.tiktok.com/@fasfwfwa/live', '2023-03-02 17:49:24', '美国');

-- ----------------------------
-- Table structure for live_warrant
-- ----------------------------
DROP TABLE IF EXISTS `live_warrant`;
CREATE TABLE `live_warrant`  (
  `id` bigint NOT NULL COMMENT '主键',
  `live_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '直播间id',
  `device` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '设备id',
  `expiration_date` datetime NOT NULL COMMENT '到期时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注',
  `warrant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '授权码',
  `status` bigint NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `live_id`(`live_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of live_warrant
-- ----------------------------
INSERT INTO `live_warrant` VALUES (1636434073923936258, 'hiroshima_tssnews', '0025468a1ace806b2465b1ce238af00d', '2023-03-17 02:27:41', '2023-03-17 02:27:41', 'asd', 'asd', 0);
INSERT INTO `live_warrant` VALUES (1636705579811803137, 'asfgas', '', '2023-03-17 20:26:33', '2023-03-17 20:26:33', 'asfasfwasf', 'f767c2eb4e7a1dd3796b5cce53570ae2', 1);
INSERT INTO `live_warrant` VALUES (1668649068707147777, 'kristywuuu', '0025468a1ace806b2465b1ce238af00d', '2023-06-13 23:58:35', '2023-06-13 23:58:35', 'asd', '3425b915e6d256e45d71f88af4453bda', 1);
INSERT INTO `live_warrant` VALUES (1668652291916525570, 'epic___420__', '0025468a1ace806b2465b1ce238af00d', '2023-06-14 00:11:23', '2023-06-14 00:11:23', 'asd', '5a6652aa76ee992386f2086b44819314', 1);
INSERT INTO `live_warrant` VALUES (1668653184451833857, 'painappuru_hosuneta', '0025468a1ace806b2465b1ce238af00d', '2023-06-14 00:14:56', '2023-06-14 00:14:56', '', 'd31df4c2fb31c0117f3e8f5b3f1e31fb', 1);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` bigint NOT NULL COMMENT 'id',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1636714988487147522, 'admin', '58588985bc2efc331777a7d3e9b0c856');
INSERT INTO `manager` VALUES (1668661432290631681, 'admin', '58588985bc2efc331777a7d3e9b0c856');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `live_id` bigint NOT NULL COMMENT '直播间id',
  `create_time` datetime NOT NULL COMMENT '发消息时间',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `download` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '已下载',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1630911161922015233, '243', 324, '2023-03-01 20:41:37', 'asfsaf', '0');
INSERT INTO `user` VALUES (1630969824552513537, 'userd192q514pg', 2, '2023-03-02 00:34:43', 'София', '0');
INSERT INTO `user` VALUES (1630969892533792769, 'gigielamoroso', 2, '2023-03-02 00:34:59', 'Gigi el amoroso 🎭🎥', '0');
INSERT INTO `user` VALUES (1630969909264871426, 'sekkalaaaa', 2, '2023-03-02 00:35:03', '??', '0');
INSERT INTO `user` VALUES (1630969966592618498, 'jennyjenn0606', 2, '2023-03-02 00:35:17', 'jennyjenn0606', '0');
INSERT INTO `user` VALUES (1630970064483479554, 'matias_niolas2012952', 2, '2023-03-02 00:35:40', 'matiasnicolasro13', '0');
INSERT INTO `user` VALUES (1630970155587956737, 'ro_or2309', 2, '2023-03-02 00:36:02', 'Rodri Go', '0');
INSERT INTO `user` VALUES (1630970316905082881, 'dexysexyoriginal', 2, '2023-03-02 00:36:40', 'DexySexy', '0');
INSERT INTO `user` VALUES (1630970394482929666, 'samuelthundet', 2, '2023-03-02 00:36:59', 'huh 2', '0');
INSERT INTO `user` VALUES (1630970525466849282, 'n.z.h.ak47', 2, '2023-03-02 00:37:30', 'N.Z.H.ak47', '0');
INSERT INTO `user` VALUES (1630970684082843650, 'tatar_232345', 2, '2023-03-02 00:38:08', 'ต้ารามอินทรา', '0');
INSERT INTO `user` VALUES (1630970810058764289, 'user8174726061819', 2, '2023-03-02 00:38:38', 'user8174726061819', '0');
INSERT INTO `user` VALUES (1630971113290166273, 'nynskolientje', 2, '2023-03-02 00:39:50', 'Nynkje', '0');

SET FOREIGN_KEY_CHECKS = 1;
