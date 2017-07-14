/*
Navicat MySQL Data Transfer

Source Server         : phoneshop
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : phoneshop

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-03-24 09:40:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `colortype` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '颜色分类',
  `productname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品',
  `price` decimal(16,2) NOT NULL COMMENT '价格',
  `num` int(10) NOT NULL DEFAULT '1' COMMENT '数量',
  `picture` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '照片',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户注册登陆表';

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('088057e9-b9ce-45cd-a9f0-fd61f5e2a485', '1@qq.com', '颜色:null / 内存:null', '三星i9200', '2000.00', '1', '../images/20170317154736product-6.jpg', '1');
INSERT INTO `t_cart` VALUES ('1', '1@qq.com', '颜色：黑色内存：32g', 'Samsung Galaxy S5', '2166.66', '1', '../images/sale-1.jpg', '1');
INSERT INTO `t_cart` VALUES ('14560d42-c5d0-4a1a-99a1-2e8f2e990114', '2@qq.com', '颜色:黑色 / 内存:32g', 'HUAWEI Mate9', '4499.00', '1', '../images/huawei-mate9.jpg', '1');
INSERT INTO `t_cart` VALUES ('1487fcaf-91d7-436a-b2e7-626c6d086f84', '1@qq.com', '颜色:黑色 / 内存:64g', '小米5s', '2499.00', '2', '../images/xiaomi5s.jpg', '1');
INSERT INTO `t_cart` VALUES ('2', '1@qq.com', '颜色：金色/内存：128g', 'HUAWEI Mate9', '4499.00', '1', '../images/leading-4.jpg', '1');
INSERT INTO `t_cart` VALUES ('230623ab-e983-445d-864a-8e5d9f943b88', '1@qq.com', '颜色:黑色 / 内存:64g', 'LG Leon 2015', '2300.00', '1', '../images/20170317153847sale-3.jpg', '1');
INSERT INTO `t_cart` VALUES ('26206f1b-86df-44c0-a796-ae9c792a4a60', '1@qq.com', '颜色:黑色 / 内存:64g', 'Samsung Galaxy S5', '2166.66', '1', '../images/sale-1.jpg', null);
INSERT INTO `t_cart` VALUES ('285c4cf0-cf87-4f3b-9e3e-1bbeb2c7a345', '2@qq.com', '颜色:黑色 / 内存:64g', 'LG Leon 2015', '2300.00', '1', '../images/20170317153847sale-3.jpg', '1');
INSERT INTO `t_cart` VALUES ('2db57ddc-f3d5-414e-b279-c5892bdb2c80', '2@qq.com', '颜色:白色 / 内存:64g', 'Apple/苹果 iPhone6', '4633.00', '2', '../images/sale-5.jpg', '1');
INSERT INTO `t_cart` VALUES ('348a8fc9-c483-47cd-a470-40623c0ac260', '2@qq.com', '颜色:黑色 / 内存:64g', '小米5s', '2499.00', '3', '../images/xiaomi5s.jpg', '1');
INSERT INTO `t_cart` VALUES ('36760970-9449-4987-aae0-0e155036c2e9', '1@qq.com', '颜色:白色 / 内存:64g', '小米5s', '2499.00', '4', '../images/xiaomi5s.jpg', '1');
INSERT INTO `t_cart` VALUES ('3a527a0f-bc52-4235-b906-2843dcf7f560', '1@qq.com', '颜色:亮黑色 / 内存:128g', '苹果/Apple iphone7', '6566.00', '1', '../images/leading-1.jpg', '1');
INSERT INTO `t_cart` VALUES ('3cc7d151-c654-4caa-b3f6-a85874e3ab8c', '2@qq.com', '颜色:金色 / 内存:64g', 'HUAWEI Mate9', '4799.00', '1', '../images/huawei-mate9.jpg', '1');
INSERT INTO `t_cart` VALUES ('3fe93db6-d698-4b1c-98c8-7450686311ca', '2@qq.com', '颜色:白色 / 内存:64g', 'Samsung Galaxy S5', '2466.00', '2', '../images/sale-1.jpg', null);
INSERT INTO `t_cart` VALUES ('45f3a904-d3f0-406d-b039-2877fa451814', '2@qq.com', '颜色:黑色 / 内存:64g', 'Apple/苹果 iPhone6', '4633.00', '2', '../images/sale-5.jpg', null);
INSERT INTO `t_cart` VALUES ('485f82f2-a4a5-415b-b9fb-4bcb637d94ea', '2@qq.com', '颜色:黑色 / 内存:64g', 'LG Leon 2015', '2300.00', '1', '../images/20170317153847sale-3.jpg', '');
INSERT INTO `t_cart` VALUES ('56a76a3e-a89d-433a-bbbd-67c0a24e0942', '1@qq.com', '颜色:黑色 / 内存:64g', 'LG Leon 2015', '2000.00', '1', '../images/sale-3.jpg', '');
INSERT INTO `t_cart` VALUES ('60fc5d70-f6bc-478e-b310-9242cfc646d7', '1@qq.com', '颜色:null / 内存:null', '三星i9200', '2000.00', '1', '../images/20170317154736product-6.jpg', '');
INSERT INTO `t_cart` VALUES ('6cd39853-c879-491b-8263-64e2a152d287', '1@qq.com', '颜色:白色 / 内存:64g', 'MEIZU/魅蓝 魅蓝X', '1966.00', '1', '../images/20170317153607meilan-x.jpg', '1');
INSERT INTO `t_cart` VALUES ('6cdc15f4-653d-491b-ba5c-47adec8d2d2e', '2@qq.com', '颜色:白色 / 内存:64g', '华为P9全网通4G', '2288.00', '1', '../images/20170317154141huawei-p9.jpg', '1');
INSERT INTO `t_cart` VALUES ('821655ab-52ae-420d-8a0a-6ae8b5ac80bf', '1@qq.com', '颜色:黑色 / 内存:64g', 'HUAWEI Mate9', '4799.00', '4', '../images/huawei-mate9.jpg', '1');
INSERT INTO `t_cart` VALUES ('85a82df5-e1ec-40de-88a0-c71c56db617b', '2@qq.com', '颜色:白色 / 内存:64g', 'Apple/苹果 iPhone6', '4633.00', '1', '../images/sale-5.jpg', '1');
INSERT INTO `t_cart` VALUES ('8982ca8c-e66b-4c05-88b7-f79041c235be', '2@qq.com', '颜色:白色 / 内存:64g', 'OPPO R9S', '3099.00', '1', '../images/20170317154447leading-3.jpg', '1');
INSERT INTO `t_cart` VALUES ('8e4f368e-bf8b-45f1-a2f0-2407e25e169d', '1@qq.com', '颜色:黑色 / 内存:64g', 'MEIZU/魅蓝 魅蓝X', '1666.66', '1', '../images/sale-2.jpg', null);
INSERT INTO `t_cart` VALUES ('91fd83d6-96b0-46c7-8cb9-cf9ec36e6bcd', '2@qq.com', '颜色:亮黑色 / 内存:128g', '苹果/Apple iphone7', '6566.00', '2', '../images/leading-1.jpg', null);
INSERT INTO `t_cart` VALUES ('983d7e9a-15ec-4018-8f04-81c87518dc6f', '1@qq.com', '颜色:白色 / 内存:64g', 'OPPO R9S', '3099.00', '1', '../images/20170317154447leading-3.jpg', '1');
INSERT INTO `t_cart` VALUES ('9d673358-b929-41c9-96b7-dc2a2394b0a6', '2@qq.com', '颜色:金色 / 内存:64g', 'Samsung Galaxy S5', '2466.00', '1', '../images/sale-1.jpg', '1');
INSERT INTO `t_cart` VALUES ('9f455b24-0bb4-4b59-a477-cec3b3b9c214', '2@qq.com', '颜色:玫瑰金 / 内存:64g', 'Samsung S7 edge', '4966.00', '1', '../images/leading-2.jpg', '1');
INSERT INTO `t_cart` VALUES ('a2fe0f7b-0456-4d9f-8b06-7e11379ad98d', '2@qq.com', '颜色:白色 / 内存:64g', '华为P9全网通4G', '2288.00', '2', '../images/20170317154141huawei-p9.jpg', '1');
INSERT INTO `t_cart` VALUES ('b546b595-2587-4987-b585-31ee20c501fa', '2@qq.com', '颜色:黑色 / 内存:64g', 'HUAWEI Mate9', '4799.00', '1', '../images/huawei-mate9.jpg', '1');
INSERT INTO `t_cart` VALUES ('b5f58a8e-fd44-48b4-97c3-cd813de415bf', '1@qq.com', '颜色:白色 / 内存:32g', 'MEIZU/魅蓝 魅蓝X', '1666.00', '2', '../images/20170317153607meilan-x.jpg', '1');
INSERT INTO `t_cart` VALUES ('b8fecf7e-d232-48e8-8a98-65c27e017909', '2@qq.com', '颜色:玫瑰金 / 内存:64g', 'OPPO R9S', '3099.00', '2', '../images/20170317154447leading-3.jpg', '1');
INSERT INTO `t_cart` VALUES ('b9029f8e-9623-42d8-9aae-d17afc4c23e3', '1@qq.com', '颜色:null / 内存:null', 'HUAWEI Mate9', '4499.00', '1', '../images/huawei-mate9.jpg', null);
INSERT INTO `t_cart` VALUES ('c4ff8742-efae-4156-adf2-d5436897037b', '2@qq.com', '颜色:白色 / 内存:64g', 'MEIZU/魅蓝 魅蓝X', '1966.00', '1', '../images/20170317153607meilan-x.jpg', '1');
INSERT INTO `t_cart` VALUES ('d4c3b304-45cf-4f49-8885-922e74ab72db', '2@qq.com', '颜色:白色 / 内存:64g', '华为P9全网通4G', '2288.00', '1', '../images/20170317154141huawei-p9.jpg', '1');
INSERT INTO `t_cart` VALUES ('e0e1c741-bee3-4624-9fe7-33cba65c156c', '2@qq.com', '颜色:白色 / 内存:64g', 'MEIZU/魅蓝 魅蓝X', '1966.00', '2', '../images/20170317153607meilan-x.jpg', '1');
INSERT INTO `t_cart` VALUES ('e9200935-d740-42af-b5d5-82ba0b5d9249', '1@qq.com', '颜色:黑色 / 内存:32g', 'MEIZU/魅蓝 魅蓝X', '1666.00', '1', '../images/20170317153607meilan-x.jpg', '1');

-- ----------------------------
-- Table structure for `t_personal`
-- ----------------------------
DROP TABLE IF EXISTS `t_personal`;
CREATE TABLE `t_personal` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `nick` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `sex` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性别',
  `truename` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
  `picture` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `brithday` date NOT NULL COMMENT '生日',
  `attr1` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '空' COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户个人信息表';

-- ----------------------------
-- Records of t_personal
-- ----------------------------

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `productid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品分类号',
  `productname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品名称',
  `attr1` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '空' COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品分类表';

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '0001', '苹果', '空');
INSERT INTO `t_product` VALUES ('2', '0002', '三星', '空');
INSERT INTO `t_product` VALUES ('3', '0003', '小米', '空');
INSERT INTO `t_product` VALUES ('4', '0004', '华为', '空');
INSERT INTO `t_product` VALUES ('5', '0005', '魅族', '空');
INSERT INTO `t_product` VALUES ('6', '0006', 'OPPO', '空');
INSERT INTO `t_product` VALUES ('7', '0007', 'VIVO', '空');
INSERT INTO `t_product` VALUES ('8', '0008', 'LG', '空');

-- ----------------------------
-- Table structure for `t_productcolor`
-- ----------------------------
DROP TABLE IF EXISTS `t_productcolor`;
CREATE TABLE `t_productcolor` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名',
  `color` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '颜色分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品颜色表';

-- ----------------------------
-- Records of t_productcolor
-- ----------------------------
INSERT INTO `t_productcolor` VALUES ('031b5274-6749-4fc4-8a5c-6f385b047100', 'LG Leon 2015', '黑色');
INSERT INTO `t_productcolor` VALUES ('09aa562b-94e4-4a00-8eab-d90e5ca21647', '53245', '玫瑰金');
INSERT INTO `t_productcolor` VALUES ('0e18c7ea-fe35-4534-b71c-4ca9c687c196', 'Apple/苹果 iPhone6', '白色');
INSERT INTO `t_productcolor` VALUES ('2dbb4e46-f706-4a33-bf9e-1df2bcb9f551', '苹果/Apple iphone7', '金色');
INSERT INTO `t_productcolor` VALUES ('4960c316-8c15-4020-b501-c656a75c76ff', '华为P9全网通4G', '金色');
INSERT INTO `t_productcolor` VALUES ('4b421f8c-1558-4a47-a743-35962ee75fde', 'MEIZU/魅蓝 魅蓝X', '白色');
INSERT INTO `t_productcolor` VALUES ('4c8334a6-300a-45b7-9e7c-64befa698e3f', '华为P9全网通4G', '白色');
INSERT INTO `t_productcolor` VALUES ('5012994f-902e-40aa-9fc7-f6a31beba306', '小米8', '黑色');
INSERT INTO `t_productcolor` VALUES ('57df5a8b-8d1e-4e63-9e73-a224eae8b7b1', '华为P9全网通4G', '黑色');
INSERT INTO `t_productcolor` VALUES ('58b6687d-b4f1-466e-9971-f2042e926614', 'Samsung Galaxy S5', '金色');
INSERT INTO `t_productcolor` VALUES ('59ff96cf-15f0-4179-8196-06a3bf5ebdd0', 'MEIZU/魅蓝 魅蓝X', '黑色');
INSERT INTO `t_productcolor` VALUES ('64a06586-df1d-4e4b-b7d1-b03428c9aceb', '小米5s', '黑色');
INSERT INTO `t_productcolor` VALUES ('6f5feb3d-466f-4920-a026-9927b50ffd52', '小米5s', '白色');
INSERT INTO `t_productcolor` VALUES ('7a28f316-323c-438a-860c-cc2642ed34b4', 'OPPO R9S', '白色');
INSERT INTO `t_productcolor` VALUES ('83d45917-910f-4302-a11b-bd0a5534d979', '苹果/Apple iphone7', '亮黑色');
INSERT INTO `t_productcolor` VALUES ('8c3a5a73-6261-4b42-a445-6ad4f01b966a', '小米5s', '金色');
INSERT INTO `t_productcolor` VALUES ('90b7451c-a64f-4c5b-99ce-0900b0dc19a6', '小米8', '玫瑰金');
INSERT INTO `t_productcolor` VALUES ('90eba667-6099-40df-9977-5223e162d7b2', '三星i9200', '黑色');
INSERT INTO `t_productcolor` VALUES ('93ef0fff-1cfc-41ec-9ee1-d76c4c7cde3c', 'Apple/苹果 iPhone6', '黑色');
INSERT INTO `t_productcolor` VALUES ('951d4fde-fc7f-4886-aaed-1a4062f345d6', 'OPPO R9S', '玫瑰金');
INSERT INTO `t_productcolor` VALUES ('96519c56-6bcf-4547-9b1f-4cdfcf73bf6a', 'Samsung S7 edge', '金色');
INSERT INTO `t_productcolor` VALUES ('9669b4e9-b585-472e-bdf0-abd3c260ec92', 'Samsung Galaxy S5', '白色');
INSERT INTO `t_productcolor` VALUES ('98f6ba8b-7b35-4875-98bf-fb8287160bab', 'HUAWEI Mate9', '金色');
INSERT INTO `t_productcolor` VALUES ('a6f5f853-63a6-49d5-836b-1b4c1f6878e4', 'HUAWEI Mate9', '黑色');
INSERT INTO `t_productcolor` VALUES ('a70c16bc-4c6d-4929-9f7a-c95229a4e515', '小米8', '金色');
INSERT INTO `t_productcolor` VALUES ('b6c29ec1-d650-4f90-981f-7100caf763c3', 'Samsung S7 edge', '玫瑰金');
INSERT INTO `t_productcolor` VALUES ('b72fb2ae-2093-41ca-86fb-c8ac91b182a5', 'Apple/苹果 iPhone6', '金色');
INSERT INTO `t_productcolor` VALUES ('ba470715-6c35-48fd-8bda-4619b1fc5c00', 'Samsung Galaxy S5', '黑色');
INSERT INTO `t_productcolor` VALUES ('c48f7540-37c6-43c0-8ad2-00ff54178dc2', '苹果/Apple iphone7', '白色');
INSERT INTO `t_productcolor` VALUES ('d450f292-e67f-4379-a8d7-b49eb5218003', 'Samsung S7 edge', '白色');
INSERT INTO `t_productcolor` VALUES ('e5060bdd-e92e-4bdf-9ef1-b0204d115f1b', '53245', '黑色');
INSERT INTO `t_productcolor` VALUES ('f5b10b43-0ae9-469c-82ff-50c56bce6e46', 'HUAWEI Mate9', '白色');
INSERT INTO `t_productcolor` VALUES ('f7de1324-79ff-4ca8-a763-9de6038648fb', 'OPPO R9S', '黑色');
INSERT INTO `t_productcolor` VALUES ('f8f29c54-e0ad-476e-b28c-f7e96c5d9677', 'OPPO R9S', '金色');

-- ----------------------------
-- Table structure for `t_productmenu`
-- ----------------------------
DROP TABLE IF EXISTS `t_productmenu`;
CREATE TABLE `t_productmenu` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `productid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品分类号',
  `type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '型号',
  `color` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '颜色',
  `price` decimal(16,2) DEFAULT NULL COMMENT '价格',
  `picture` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `sales` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '促销',
  `num` int(10) NOT NULL DEFAULT '1' COMMENT '库存',
  `miaoshu` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '空' COMMENT '商品名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品分类表';

-- ----------------------------
-- Records of t_productmenu
-- ----------------------------
INSERT INTO `t_productmenu` VALUES ('053b8455-b6e0-44d3-a591-3bb78ada3eba', '0004', '1', null, '1988.00', '../images/20170317154141huawei-p9.jpg', '特价商品', '300', null, '华为P9全网通4G');
INSERT INTO `t_productmenu` VALUES ('0a39a4ce-859b-4864-aebf-97f4e23a99ce', '0002', '1', null, '2166.00', '../images/sale-1.jpg', '特价商品', '9999', null, 'Samsung Galaxy S5');
INSERT INTO `t_productmenu` VALUES ('25c5faf2-b00b-4715-a90c-0eeb579e7a32', '0002', '1', null, '2000.00', '../images/20170317154736product-6.jpg', '特价商品', '99', null, '三星i9200');
INSERT INTO `t_productmenu` VALUES ('44bff74c-0718-492f-bf49-58fe71e75d2d', '0006', '1', null, '2799.00', '../images/20170317154447leading-3.jpg', '主打商品', '99999', null, 'OPPO R9S');
INSERT INTO `t_productmenu` VALUES ('5d5c2c0f-fb5b-4d2b-93dc-8deba1b1ab3a', '0004', '1', null, '4499.00', '../images/huawei-mate9.jpg', '主打商品', '9999', null, 'HUAWEI Mate9');
INSERT INTO `t_productmenu` VALUES ('6a7e8a00-cd21-4a81-b2c3-2a583421f7b2', '0008', '1', null, '2000.00', '../images/20170317153847sale-3.jpg', '特价商品', '100', null, 'LG Leon 2015');
INSERT INTO `t_productmenu` VALUES ('761c9b76-c17f-426e-855e-23e297a14668', '0003', '1', null, '3333.00', '../images/201703211704322.jpg', '主打商品', '1111', null, '小米8');
INSERT INTO `t_productmenu` VALUES ('8884b6d3-ce19-4cde-8f58-6d161b4b45cd', '0003', null, null, '2199.00', '../images/xiaomi5s.jpg', '主打商品', '9999', null, '小米5s');
INSERT INTO `t_productmenu` VALUES ('ba0f032c-a81f-439d-a04c-6645c02349ef', '0005', null, null, '1666.00', '../images/20170317153607meilan-x.jpg', '特价商品', '100', null, 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_productmenu` VALUES ('c4452642-c642-47de-a130-f6cd9e30be82', '0002', null, null, '4666.00', '../images/leading-2.jpg', '主打商品', '9999', null, 'Samsung S7 edge');
INSERT INTO `t_productmenu` VALUES ('c8d6e102-c309-4007-b94b-4d4c83d7246c', '0001', null, null, '8989.00', '', '主打商品', '60', null, '53245');
INSERT INTO `t_productmenu` VALUES ('e20779a2-4656-41eb-ba80-f9faaefd36c1', '0001', null, null, '5666.00', '../images/leading-1.jpg', '主打商品', '9999', null, '苹果/Apple iphone7');
INSERT INTO `t_productmenu` VALUES ('f11228a2-8e86-4e5d-998b-95ea0f2fae87', '0001', null, null, '4333.00', '../images/sale-5.jpg', '特价商品', '3333', null, 'Apple/苹果 iPhone6');

-- ----------------------------
-- Table structure for `t_producttype`
-- ----------------------------
DROP TABLE IF EXISTS `t_producttype`;
CREATE TABLE `t_producttype` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名',
  `type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内存分类',
  `price` decimal(16,2) NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品颜色表';

-- ----------------------------
-- Records of t_producttype
-- ----------------------------
INSERT INTO `t_producttype` VALUES ('01294865-e34f-4125-98b4-df2ab111477b', '华为P9全网通4G', '32g', '1988.00');
INSERT INTO `t_producttype` VALUES ('130c6c29-aaa3-4b5b-a011-0f6e348e3d93', '华为P9全网通4G', '64g', '2288.00');
INSERT INTO `t_producttype` VALUES ('16dc99d2-1e07-44ea-a1e1-19dd025e3ec3', 'Samsung Galaxy S5', '32g', '2166.00');
INSERT INTO `t_producttype` VALUES ('1cc2b22e-345b-40b6-af1f-7f11cf316a68', 'HUAWEI Mate9', '64g', '4799.00');
INSERT INTO `t_producttype` VALUES ('2327c349-99af-41d7-8b71-a6c2a14bb17f', 'HUAWEI Mate9', '32g', '4499.00');
INSERT INTO `t_producttype` VALUES ('29c222ca-90e1-42bd-abfd-13a425c53d6a', 'MEIZU/魅蓝 魅蓝X', '32g', '1666.00');
INSERT INTO `t_producttype` VALUES ('2d4f4747-a321-4609-82f0-71db5bbb6b0c', 'Samsung S7 edge', '32g', '4666.00');
INSERT INTO `t_producttype` VALUES ('30e19417-939e-44a6-856e-ea8ac150417f', 'OPPO R9S', '64g', '3099.00');
INSERT INTO `t_producttype` VALUES ('347e6667-4598-43d3-a88a-971967e5a1b0', '小米8', '64g', '3633.00');
INSERT INTO `t_producttype` VALUES ('3ddeccad-b9a5-463d-af20-10532d5aa771', '三星i9200', '32g', '2000.00');
INSERT INTO `t_producttype` VALUES ('5b4a6f57-f311-46ae-9def-70b19e4c3f54', 'LG Leon 2015', '64g', '2300.00');
INSERT INTO `t_producttype` VALUES ('5d52cffa-c070-43dc-be7d-58a3907e8e45', 'Apple/苹果 iPhone6', '64g', '4633.00');
INSERT INTO `t_producttype` VALUES ('678880a0-f831-4088-8e6c-4e0c44578e9a', 'Samsung S7 edge', '64g', '4966.00');
INSERT INTO `t_producttype` VALUES ('8293320a-a2f0-4365-9f24-74ea8561ac28', '小米8', '32g', '3333.00');
INSERT INTO `t_producttype` VALUES ('94b3316a-7d21-473c-b2fd-aae9de8980c2', '苹果/Apple iphone7', '16g', '5666.00');
INSERT INTO `t_producttype` VALUES ('99e0ee2f-69c4-48f7-bc0d-23c47eafb7b0', '小米5s', '32g', '2199.00');
INSERT INTO `t_producttype` VALUES ('9ecf0cc5-5480-47ff-a5f6-a0556b1d08e4', 'LG Leon 2015', '32g', '2000.00');
INSERT INTO `t_producttype` VALUES ('b08a5136-5e9d-443b-8970-d3f6b73314f9', 'Apple/苹果 iPhone6', '16g', '4333.00');
INSERT INTO `t_producttype` VALUES ('c9814970-4e78-4948-83ad-a9f44e179d44', 'OPPO R9S', '32g', '2799.00');
INSERT INTO `t_producttype` VALUES ('c99617a9-636a-4bc9-ba04-c71644a2c2ac', 'MEIZU/魅蓝 魅蓝X', '64g', '1966.00');
INSERT INTO `t_producttype` VALUES ('c9dd21d8-7287-4d6b-927e-5ccd4394f761', 'Samsung Galaxy S5', '64g', '2466.00');
INSERT INTO `t_producttype` VALUES ('d1ddb45e-60c5-47db-b705-8d810b052065', '53245', '32g', '8989.00');
INSERT INTO `t_producttype` VALUES ('d21bcaca-c2a6-4a33-be6f-c44c5ebd54ec', '三星i9200', '64g', '2300.00');
INSERT INTO `t_producttype` VALUES ('d3bcd39f-2c61-4478-9dbd-2a390f924b02', '苹果/Apple iphone7', '64g', '6266.00');
INSERT INTO `t_producttype` VALUES ('e169f070-8d2b-42d7-90a2-efc34b68af4f', '小米5s', '64g', '2499.00');
INSERT INTO `t_producttype` VALUES ('e25daf5f-75b4-4b4d-a369-bc6caa59f6d9', '苹果/Apple iphone7', '128g', '6566.00');
INSERT INTO `t_producttype` VALUES ('eb5e7da5-8ef8-4e42-9414-8b073102fe31', '苹果/Apple iphone7', '32g', '5966.00');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `nick` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `picture` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `sex` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `truename` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户注册登陆表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('4e762d0a-ae51-4c3e-b2eb-2bca70d867a4', 'a@aa.com', '111111', 'csdfa', '空', '男', 'afa', '2017-03-16');
INSERT INTO `t_user` VALUES ('87b39ce6-099c-44d5-b7f8-efe3c5a1a7c4', '3@qdasd.c', '111111', 'ksdkdldslsd121', '空', '男', 'dasdas', '2017-03-31');
INSERT INTO `t_user` VALUES ('b98041a8-038b-4f5b-94b9-01b2dc2090e9', '2@qq.com', '111111', 'das', '空', '男', 'das', '2017-03-30');
INSERT INTO `t_user` VALUES ('c4e7ad7a-e015-4b8b-b192-b2a41aeedfbe', '1@qq.com', '1234567', '1234567', '空', '女', '11111', '2017-03-17');
INSERT INTO `t_user` VALUES ('cf750587-0bb7-4a80-9473-491e80ec3e46', 'das@qq.com', '111111', 'dsad', '空', '男', 'daa', '2017-03-09');
INSERT INTO `t_user` VALUES ('f55c77c1-5872-4ab4-a2bd-59f352497087', 'f@qq.com', '1111111', 'das', '空', '男', 'dsdas', '2017-03-16');

-- ----------------------------
-- Table structure for `t_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_address`;
CREATE TABLE `t_user_address` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `city` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所在城市',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址',
  `yb` char(7) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮编',
  `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人姓名',
  `phone` char(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `attr1` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT '空' COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单信息表';

-- ----------------------------
-- Records of t_user_address
-- ----------------------------
INSERT INTO `t_user_address` VALUES ('0388ff6b-88c2-4b4d-94fb-ad1e61efaad3', 'a@aa.com', '河南省', 'd', null, '1', '13333333333', null);
INSERT INTO `t_user_address` VALUES ('31701b38-b774-433d-a68e-b760078d280d', '1@qq.com', '黑龙江省大庆市大同区', 'gtgtrgtggtr', '111111', '11111111', '13111111111', null);
INSERT INTO `t_user_address` VALUES ('3f528ad4-d1db-4fc1-9943-8f63be62c819', '2@qq.com', '河北省秦皇岛市山海关区', 'gtvfhgghghjghj', '731000', 'gt', '13111111111', null);
INSERT INTO `t_user_address` VALUES ('728decbb-a651-43b3-96cb-9ded70b2c82a', '1@qq.com', '天津市', '1111', '111111', '111', '15774445444', null);
INSERT INTO `t_user_address` VALUES ('ded59bac-9776-4b2e-8a12-692f4be2fa9a', '1@qq.com', '天津市', 'qqqqq', '111111', 'qqqq', '15664343433', null);
INSERT INTO `t_user_address` VALUES ('f338339c-b197-4b17-9b9e-7b6a7eda84c5', '1@qq.com', '内蒙古自治区', 'ghjhkjk', null, 'fds', '13333333333', null);
INSERT INTO `t_user_address` VALUES ('fa9856dd-3850-4fc8-90ca-833cb4bb38f8', '1@qq.com', '吉林省辽源市东辽县', 'asdas', null, 'sad', '13333333333', null);

-- ----------------------------
-- Table structure for `t_user_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `orderid` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单号',
  `productType` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '型号',
  `price` decimal(16,2) DEFAULT '0.00' COMMENT '单价',
  `num` int(10) NOT NULL COMMENT '数量',
  `count` decimal(16,2) DEFAULT '0.00' COMMENT '总价格',
  `ordertime` datetime DEFAULT NULL COMMENT '订单时间',
  `status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货地址',
  `picture` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '空' COMMENT '备用字段',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单信息表';

-- ----------------------------
-- Records of t_user_order
-- ----------------------------
INSERT INTO `t_user_order` VALUES ('0bdd2361-b48e-4679-ac23-872c42ad08f8', '1@qq.com', '1490155388124', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 12:03:08', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('0c0d20bb-2faf-441d-a6e2-bf36e47bd656', '2@qq.com', '1490152431268', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 11:13:51', '0', '', '../images/leading-2.jpg', 'Samsung S7 edge');
INSERT INTO `t_user_order` VALUES ('11', '111', '111', '11111', null, '1111', null, '2017-03-10 16:55:31', '1', '111', null, null);
INSERT INTO `t_user_order` VALUES ('12', '123', '222', '11111', '1123.11', '111', '0.00', '2017-03-14 15:08:52', '1', '111', '空111', null);
INSERT INTO `t_user_order` VALUES ('13', '111', '111', '1231232', '0.00', '3333', '0.00', '2017-03-15 15:09:24', '2', '111', '空321', null);
INSERT INTO `t_user_order` VALUES ('1579d2d6-df72-4724-8e97-99a1bc4240b9', '2@qq.com', '1490155234838', '颜色:玫瑰金 / 内存:64g', '3099.00', '2', '6198.00', '2017-03-22 12:00:34', '0', '', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('1e0ab0f1-6bd6-4461-89e7-e151ae66e118', '1@qq.com', '1490163446874', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 14:17:26', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('21f3e27f-fb10-4cb4-a17e-e79050d3883d', '1@qq.com', '1490163197565', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 14:13:17', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('27cd8c60-1bb4-4e78-9747-fcae2083888f', '2@qq.com', '1490232587794', '颜色:白色 / 内存:64g', '2288.00', '2', '4576.00', '2017-03-23 09:29:47', '1', '河北省秦皇岛市山海关区gtvfhgghghjghj', '../images/20170317154141huawei-p9.jpg', '华为P9全网通4G');
INSERT INTO `t_user_order` VALUES ('280de63c-d27d-459e-b7f7-6bbf231d8cd6', '2@qq.com', '1490171642194', '颜色:黑色 / 内存:64g', '4799.00', '1', '4799.00', '2017-03-22 16:34:02', '0', '', '../images/huawei-mate9.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('2e2c23c8-65be-44f7-990b-c48c20f82c43', '1@qq.com', '1490163550607', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 14:19:10', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('304f860c-fef2-425c-bfea-a6f0684ab440', '2@qq.com', '1490064655661', '颜色:金色 / 内存:64g', '4633.00', '2', '9266.00', '2017-03-21 10:50:55', '0', '地址', '../images/sale-5.jpg', 'Apple/苹果 iPhone6');
INSERT INTO `t_user_order` VALUES ('33868462-8109-4c13-b9c8-910f7afb157c', '2@qq.com', '1490146402239', '颜色:金色 / 内存:32g', '5966.00', '1', '5966.00', '2017-03-22 09:33:21', '0', '地址', '../images/leading-1.jpg', '苹果/Apple iphone7');
INSERT INTO `t_user_order` VALUES ('3dfbf304-f365-4a7a-877a-f49e69d4011e', '1@qq.com', '1490173428066', '颜色:白色 / 内存:64g', '3099.00', '1', '3099.00', '2017-03-22 17:03:48', '1', '吉林省辽源市东辽县asdas', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('4094bd55-5c96-4534-a17d-3a6755a3e9d4', '1@qq.com', '1490170005065', '颜色:亮黑色 / 内存:128g', '6566.00', '1', '6566.00', '2017-03-22 16:06:45', '1', '', '../images/leading-1.jpg', '苹果/Apple iphone7');
INSERT INTO `t_user_order` VALUES ('412258f3-4be1-46ba-adb4-7ad1b5181718', '1@qq.com', '1490170340892', '颜色:黑色 / 内存:64g', '2499.00', '2', '4998.00', '2017-03-22 16:12:20', '0', '', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('461cb79b-fcaa-4dbc-badf-9ddbda9c0afd', '1@qq.com', '1490232914409', '颜色:白色 / 内存:64g', '2499.00', '4', '9996.00', '2017-03-23 09:35:14', '1', '黑龙江省大庆市大同区gtgtrgtggtr', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('49847617-0771-4479-b260-317e442a6f1d', '2@qq.com', '1490155026538', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 11:57:06', '0', '', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('4abcb1c9-a9b4-4c6e-8377-20ab482ed246', '2@qq.com', '1490164620779', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 14:37:00', '0', '', '../images/leading-2.jpg', 'Samsung S7 edge');
INSERT INTO `t_user_order` VALUES ('51eb284e-8280-4ae8-b8e0-ac90237b2b63', '1@qq.com', '1490163873318', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 14:24:33', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('54577b1b-213e-4d8f-b476-ff60a511bdf4', '2@qq.com', '1490164620779', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 14:37:00', '0', '', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('5713df41-3222-4a28-80f2-22fe0736c33d', '2@qq.com', '1490151773391', '颜色:玫瑰金 / 内存:64g', '3099.00', '2', '6198.00', '2017-03-22 11:02:53', '0', '', '../images/20170317154447leading-3.jpg', null);
INSERT INTO `t_user_order` VALUES ('5da1d7b8-c66d-47d8-9dee-e932e1a156b9', '2@qq.com', '1490155234838', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 12:00:34', '0', '', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('6109e552-c0b1-421f-ba68-75dc4f125a99', '1@qq.com', '1490155465452', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 12:04:25', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('62e294ac-6b7c-4000-9e8f-f9a59a3f7d35', '2@qq.com', '1490152431268', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 11:13:51', '0', '', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('63fc47eb-5286-498f-9ccd-a0768b69784a', '1@qq.com', '1490163873318', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 14:24:33', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('640ae954-ef4e-4647-b0d2-2e67e130be8e', '2@qq.com', '1490171333950', '颜色:白色 / 内存:64g', '2288.00', '1', '2288.00', '2017-03-22 16:28:53', '0', '', '../images/20170317154141huawei-p9.jpg', '华为P9全网通4G');
INSERT INTO `t_user_order` VALUES ('659f794c-38ac-4349-96b7-d8ac3c050f3c', '1@qq.com', '1490155688546', '颜色:黑色 / 内存:64g', '2300.00', '1', '2300.00', '2017-03-22 12:08:08', '0', '', '../images/20170317153847sale-3.jpg', 'LG Leon 2015');
INSERT INTO `t_user_order` VALUES ('65dc4dbe-4e45-4561-be25-8a79b5a31487', '2@qq.com', '1490171642194', '颜色:白色 / 内存:64g', '4633.00', '1', '4633.00', '2017-03-22 16:34:02', '0', '', '../images/sale-5.jpg', 'Apple/苹果 iPhone6');
INSERT INTO `t_user_order` VALUES ('67904ab2-9243-4dad-acf3-c0228b8b8f93', '2@qq.com', '1490152488383', '颜色:玫瑰金 / 内存:64g', '3099.00', '2', '6198.00', '2017-03-22 11:14:48', '1', '111', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('6a110efc-ab9a-4962-9e7b-1bf0cf335e54', '2@qq.com', '1490151773391', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 11:02:53', '0', '', '../images/xiaomi5s.jpg', null);
INSERT INTO `t_user_order` VALUES ('6d45be6f-b637-4db3-a1d8-3d78bcd79d8f', '1@qq.com', '1490163550607', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 14:19:10', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('705f2378-bf3a-4152-a030-dbd6bbf9dc2e', '2@qq.com', '1490232615279', '颜色:黑色 / 内存:64g', '4633.00', '1', '4633.00', '2017-03-23 09:30:15', '0', '地址', '../images/sale-5.jpg', 'Apple/苹果 iPhone6');
INSERT INTO `t_user_order` VALUES ('721ead05-43fa-4c46-ae53-a1ba67feec1e', '2@qq.com', '1490171448159', '颜色:白色 / 内存:64g', '2288.00', '1', '2288.00', '2017-03-22 16:30:48', '0', '', '../images/20170317154141huawei-p9.jpg', '华为P9全网通4G');
INSERT INTO `t_user_order` VALUES ('74606bf2-040b-4d5c-b5c3-2ba7b3aff9f8', '2@qq.com', '1490170588545', '颜色:白色 / 内存:64g', '4633.00', '2', '9266.00', '2017-03-22 16:16:28', '0', '', '../images/sale-5.jpg', 'Apple/苹果 iPhone6');
INSERT INTO `t_user_order` VALUES ('764a8343-9fd9-4ee4-b6aa-0eeae501ef4f', '2@qq.com', '1490170588545', '颜色:金色 / 内存:64g', '4799.00', '1', '4799.00', '2017-03-22 16:16:28', '0', '', '../images/huawei-mate9.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('7ce1c951-3fb5-4c21-829f-9ef8c82b5e5e', '1@qq.com', '1490155688546', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 12:08:08', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('8d9c432b-883d-4a81-baea-9e9b4d014f33', '1@qq.com', '1490233128909', '颜色:金色 / 内存:64g', '2499.00', '7', '17493.00', '2017-03-23 09:38:48', '1', '黑龙江省大庆市大同区gtgtrgtggtr', '../images/xiaomi5s.jpg', '小米5s');
INSERT INTO `t_user_order` VALUES ('a05034d6-90e4-4b66-8585-0bc34b19fcf2', '2@qq.com', '1490152431268', '颜色:玫瑰金 / 内存:64g', '3099.00', '2', '6198.00', '2017-03-22 11:13:51', '0', '', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('a1edca1a-43d2-438d-bc14-65e306414899', '1@qq.com', '1490155628248', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 12:07:08', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('a226d95a-8f6f-4b75-b399-acfc12ba6e91', '1@qq.com', '1490163197565', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 14:13:17', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('a2754a8f-a145-4e7f-b01b-9d958be727dc', '2@qq.com', '1490151761467', '颜色:黑色 / 内存:64g', '2499.00', '3', '7497.00', '2017-03-22 11:02:41', '0', '', '../images/xiaomi5s.jpg', null);
INSERT INTO `t_user_order` VALUES ('a4ca6979-9f01-4a91-8ba1-cce56c3fb286', '1@qq.com', '1490155688546', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 12:08:08', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('ab819258-134c-43da-a1ff-ad7203825d79', '2@qq.com', '1490152488383', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 11:14:48', '1', '111', '../images/leading-2.jpg', 'Samsung S7 edge');
INSERT INTO `t_user_order` VALUES ('b086458d-da80-4ad1-9050-2ed5eb345410', '2@qq.com', '1490232587794', '颜色:白色 / 内存:64g', '1966.00', '2', '3932.00', '2017-03-23 09:29:47', '1', '河北省秦皇岛市山海关区gtvfhgghghjghj', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('b63d6ce9-4a6a-4e70-99cf-d55a479d5614', '1@qq.com', '1490166413489', '颜色:黑色 / 内存:32g', '1666.00', '1', '1666.00', '2017-03-22 15:06:53', '0', '', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('b998b89a-0f7b-4c25-ba72-314dd77b5f4d', '2@qq.com', '1490169790027', '颜色:玫瑰金 / 内存:64g', '3099.00', '2', '6198.00', '2017-03-22 16:03:10', '0', '', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('ba1971d3-9834-46c2-98eb-b2b87638a57b', '2@qq.com', '1490171448159', '颜色:白色 / 内存:64g', '1966.00', '1', '1966.00', '2017-03-22 16:30:48', '0', '', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('ba46a414-04d8-4b45-879c-878053e4d4df', '1@qq.com', '1490155688546', '颜色:黑色 / 内存:32g', '1666.00', '1', '1666.00', '2017-03-22 12:08:08', '0', '', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('bdd5a318-9de9-4ebc-9c0a-f9be7a542ad2', '1@qq.com', '1490232914409', '颜色:黑色 / 内存:64g', '4799.00', '4', '19196.00', '2017-03-23 09:35:14', '1', '黑龙江省大庆市大同区gtgtrgtggtr', '../images/huawei-mate9.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('c2f62875-dcb0-4022-88a9-754dc0f8d53c', '1@qq.com', '1490155465452', '颜色:黑色 / 内存:64g', '2300.00', '1', '2300.00', '2017-03-22 12:04:25', '0', '', '../images/20170317153847sale-3.jpg', 'LG Leon 2015');
INSERT INTO `t_user_order` VALUES ('c9160298-bc3b-4b8d-9e15-4cc09aa1888c', '2@qq.com', '1490170824099', '颜色:金色 / 内存:64g', '2466.00', '1', '2466.00', '2017-03-22 16:20:24', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('c963ff97-cef4-4d64-a553-1cc91caaeba4', '1@qq.com', '1490155628248', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 12:07:08', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('cb1b712d-d1d3-492d-96f8-314d07ca39e2', '2@qq.com', '1490155026538', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 11:57:06', '0', '', '../images/leading-2.jpg', 'Samsung S7 edge');
INSERT INTO `t_user_order` VALUES ('cc0e8cda-66b9-40cf-8610-5b984417ea25', '1@qq.com', '1490173428066', '颜色:白色 / 内存:64g', '1966.00', '1', '1966.00', '2017-03-22 17:03:48', '1', '吉林省辽源市东辽县asdas', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('d57d12b5-b9b8-4f73-991c-9eaa5008b8a0', '2@qq.com', '1490151773391', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 11:02:53', '0', '', '../images/leading-2.jpg', null);
INSERT INTO `t_user_order` VALUES ('d6008685-5992-44f5-8e73-d2cc0221b0fc', '2@qq.com', '1490170824099', '颜色:黑色 / 内存:64g', '2300.00', '1', '2300.00', '2017-03-22 16:20:24', '0', '', '../images/20170317153847sale-3.jpg', 'LG Leon 2015');
INSERT INTO `t_user_order` VALUES ('daf2e943-564c-4ee8-b84d-e14829008353', '1@qq.com', '1490163218307', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 14:13:38', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('dc650cf8-7c19-4818-8e42-8c2cd03540d6', '2@qq.com', '1490155234838', '颜色:玫瑰金 / 内存:64g', '4966.00', '1', '4966.00', '2017-03-22 12:00:34', '0', '', '../images/leading-2.jpg', 'Samsung S7 edge');
INSERT INTO `t_user_order` VALUES ('e4f2ca37-16b9-401d-adaa-d7e2a5a632f8', '1@qq.com', '1490155388124', '颜色：金色/内存：128g', '4499.00', '1', '4499.00', '2017-03-22 12:03:08', '0', '', '../images/leading-4.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('e83bc895-f9f8-46d4-9aad-64f6daf7d9fb', '1@qq.com', '1490170340892', '颜色:白色 / 内存:32g', '1666.00', '2', '3332.00', '2017-03-22 16:12:20', '0', '', '../images/20170317153607meilan-x.jpg', 'MEIZU/魅蓝 魅蓝X');
INSERT INTO `t_user_order` VALUES ('eaa5236f-2a10-48fc-a6f5-90b08e7f0617', '1@qq.com', '1490163218307', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 14:13:38', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('edd5c745-9bbb-408b-bca5-a1746ca3fe0d', '2@qq.com', '1490075190484', '颜色:黑色 / 内存:64g', '2300.00', '2', '4600.00', '2017-03-21 13:46:30', '0', '地址', '../images/20170317153847sale-3.jpg', 'LG Leon 2015');
INSERT INTO `t_user_order` VALUES ('f24133cd-2994-4bf8-9977-1439df4d51af', '2@qq.com', '1490170442142', '颜色:白色 / 内存:64g', '3099.00', '1', '3099.00', '2017-03-22 16:14:02', '1', '河北省秦皇岛市山海关区gtvfhgghghjghj', '../images/20170317154447leading-3.jpg', 'OPPO R9S');
INSERT INTO `t_user_order` VALUES ('f87a4cff-7c45-429e-ac5a-cbc8cb5f6852', '1@qq.com', '1490163446874', '颜色：黑色内存：32g', '2166.66', '1', '2166.66', '2017-03-22 14:17:26', '0', '', '../images/sale-1.jpg', 'Samsung Galaxy S5');
INSERT INTO `t_user_order` VALUES ('f8eb5187-7611-4eaa-9b16-ef34cfff9956', '2@qq.com', '1490171333950', '颜色:黑色 / 内存:32g', '4499.00', '1', '4499.00', '2017-03-22 16:28:53', '0', '', '../images/huawei-mate9.jpg', 'HUAWEI Mate9');
INSERT INTO `t_user_order` VALUES ('fa1cde7a-44c4-45a8-8237-ceabbeaaa545', '1@qq.com', '1490165412290', '颜色:黑色 / 内存:64g', '2300.00', '1', '2300.00', '2017-03-22 14:50:12', '0', '', '../images/20170317153847sale-3.jpg', 'LG Leon 2015');
