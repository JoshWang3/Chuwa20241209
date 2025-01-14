CREATE SCHEMA `oms` DEFAULT CHARACTER SET utf8;

DROP TABLE if exists `oms`.`oms_order`;
CREATE TABLE `oms`.`oms_order` (
    `id` 					 bigint					comment	'	订单id  ',
    `member_id` 			 bigint 				comment	'	会员id ',
    `order_sn` 				 varchar(64)			comment	'	订单编号',
    `create_time` 			 DATETIME               comment '    ⽀付时间',
    `member_username` 		 varchar(64)            comment '    ⽤户帐号',
    `total_amount` 			 decimal(10,2)			comment	'订单总⾦额',
    `pay_amount` 			 decimal(10,2)			comment	'应付⾦额（实际⽀付⾦额） ',
    `freight_amount` 		 decimal(10,2)			comment	'运费⾦额',
    `pay_type` 				 int(1)					comment	'⽀付⽅式：0->未⽀付；1->⽀付宝；2->微信',
    `source_type` 			 int(1)					comment	'订单来源：0->PC订单；1->app订单',
    `status` 				 int(1)					comment	'订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->⽆效订单',
    `order_type` 			 int(1)					comment	'订单类型：0->正常订单；1->秒杀订单',
    `delivery_company` 		 varchar(64)			comment	'	物流公司(配送⽅式) ',
    `delivery_sn` 			 varchar(64)			comment	'	物流单号',
    `auto_confirm_day` 		 INT                    comment '    ⾃动确认时间（天） ',
    `bill_type` 			 int(1)					comment	'发票类型：0->不开发票；1->电⼦发票；2->纸质发票',
    `receiver_name` 		 varchar(100)			comment	'	收货⼈姓名',
    `receiver_phone` 		 VARCHAR(32)			comment	'	收货⼈电话',
    `receiver_post_code` 	 VARCHAR(32)			comment	'	收货⼈邮编',
    `receiver_province` 	 VARCHAR(32)			comment	'	省份/直辖市',
    `receiver_city` 		 VARCHAR(32)			comment	'	城市',
    `receiver_region` 		 VARCHAR(32)			comment	'区',
    `receiver_detail_address` varchar(200)  		comment	'	详细地址',
    `note` 					 varchar(500)			comment	'订单备注',
    `confirm_status` 		 int(1)					comment	'	确认收货状态：0->未确认；1->已确认',
    `delete_status` 		 int(1)					comment	'删除状态：0->未删除；1->已删除',
    `payment_time` 			 DATETIME               comment '   ⽀付时间',
    `delivery_time` 		 DATETIME               comment '   发货时间',
    `receive_time` 			 DATETIME               comment '   确认收货时间',
    `comment_time` 			 DATETIME               comment '   评价时间',
    `modify_time` 			 DATETIME               comment '   修改时间',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE if exists `oms`.`oms_order_item`;
CREATE TABLE `oms`.`oms_order_item` (
    `id` 					bigint 					comment 'id ',
    `order_id` 				bigint                  comment '订单id ',
    `order_sn` 				varchar(64)             comment '订单编号',
    `product_id` 			bigint                  comment '商品id ',
    `product_pic` 			varchar(500)            comment '商品图⽚',
    `product_name` 			varchar(200)            comment '商品名称',
    `product_brand` 		varchar(200)            comment '商品品牌',
    `product_sn` 			varchar(64)             comment '商品条码',
    `product_price` 		decimal(10,2)           comment '销售价格',
    `product_quantity` 		INT                     comment '购买数量',
    `product_sku_id` 		bigint                  comment '商品sku编号',
    `product_sku_code` 		varchar(50)             comment '商品sku条码',
    `product_category_id` 	bigint                  comment '商品分类id ',
    `sp1` 					varchar(100)            comment '商品的销售属性1 ',
    `sp2` 					varchar(100)            comment '商品的销售属性2 ',
    `sp3` 					varchar(100)            comment '商品的销售属性3 ',
    `product_attr` 			varchar(500)            comment '商品销售属性:[{key:颜⾊',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单中所包含的商品';

DROP TABLE if exists `oms`.`oms_order_operate_history`;
CREATE TABLE `oms`.`oms_order_operate_history`
(
    `id` 			bigint            comment 'id',
    `order_id` 		bigint			  comment '订单id',
    `operate_man` 	varchar(100)      comment '操作⼈：⽤户；系统；后台管理员',
    `create_time` 	DATETIME		  comment '操作时间',
    `order_status` 	int(1)			  comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->⽆效订单',
    `note` 			varchar(500)      comment '备注',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单操作记录表';

DROP TABLE if exists `oms`.`oms_order_setting`;
CREATE TABLE `oms`.`oms_order_setting`
(
    `id` 			bigint            comment 'id',
    `normal_order_overtime` INT			  comment '正常订单超时时间(分)',
    `confirm_overtime` 	INT      comment '发货后⾃动确认收货时间（天）',
    `finish_overtime` 	INT		  comment '⾃动完成交易时间',
    `comment_overtime` 	INT			  comment '订单完成后⾃动好评时间（天）',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单设置表';

DROP TABLE if exists `oms`.`oms_order_return_apply`;
CREATE TABLE `oms`.`oms_order_return_apply`
(
    `id` 					bigint          comment 'id',
    `order_id` 				bigint          comment '订单id ',
    `company_address_id` 	bigint          comment '收货地址表id ',
    `product_id` 			bigint          comment '退货商品id ',
    `order_sn` 				varchar(64)     comment '订单编号',
    `create_time` 			DATETIME        comment '申请时间',
    `member_username` 		varchar(64)     comment '会员⽤户名',
    `return_amount` 		decimal(10,2)   comment '退款⾦额',
    `return_name` 			varchar(100)    comment '退货⼈姓名',
    `return_phone` 			varchar(100)    comment '退货⼈电话',
    `status` 				int(1)          comment '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝 ',
    `handle_time` 			DATETIME        comment '处理时间',
    `product_pic` 			varchar(500)    comment '商品图⽚',
    `product_name` 			varchar(200)    comment '商品名称',
    `product_brand` 		varchar(200)    comment '商品品牌',
    `product_attr` 			varchar(500)    comment '商品销售属性：颜⾊：红⾊；尺码：xl ',
    `product_count` 		INT             comment '退货数量',
    `product_price` 		decimal(10,2)   comment '商品单价',
    `product_real_price` 	decimal(10,2)   comment '商品实际⽀付单价 ',
    `reason` 				varchar(200)    comment '原因',
    `description`		 	varchar(500)    comment '描述',
    `proof_pics` 			varchar(1000)   comment '凭证图⽚',
    `handle_note` 			varchar(500)    comment '处理备注',
    `handle_man` 			varchar(100)    comment '处理⼈员',
    `receive_man` 			varchar(100)    comment '收货⼈',
    `receive_time` 			DATETIME        comment '收货时间',
    `receive_note` 			varchar(500)    comment '收货备注',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单退货申请';

DROP TABLE if exists `oms`.`oms_company_address`;
CREATE TABLE `oms`.`oms_company_address`
(
    `id` 					bigint 			comment 'id',
    `address_name` 			varchar(200)    comment '地址名称',
    `send_status` 			int(1)          comment '默认发货地址：0->否；1->是',
    `receive_status` 		int(1)          comment '是否默认收货地址：0->否；1->是',
    `name` 					varchar(64)     comment '收发货⼈姓名',
    `phone` 				varchar(64)     comment '收货⼈电话',
    `province` 				varchar(64)     comment '省/直辖市',
    `city` 					varchar(64)     comment '市',
    `region` 				varchar(64)     comment '区',
    `detail_address` 		varchar(200)    comment '详细地址',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='公司收发货地址表';

DROP TABLE if exists `oms`.`oms_order_return_reason`;
CREATE TABLE `oms`.`oms_order_return_reason`
(
    `id` 					bigint 			comment 'id',
    `name` 			        varchar(100)    comment '退货类型',
    `sort` 			        INT             comment 'sort',
    `status` 		        int(1)          comment '状态：0->不启⽤；1->启用',
    `create_time` 			DATETIME        comment '添加时间',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='退货原因表';

DROP TABLE if exists `oms`.`oms_cart_item`;
CREATE TABLE `oms`.`oms_cart_item`
(
    `id` 				bigint			comment 'id',
    `product_id` 		bigint			comment '商品的id',
    `product_sku_id` 	bigint			comment '商品sku的id',
    `member_id` 		bigint			comment '会员id',
    `quantity` 			INT			    comment '购买数量',
    `price` 			decimal(10,2)	comment '添加到购物⻋的价格',
    `sp1` 				varchar(200)	comment '销售属性1',
    `sp2` 				varchar(200)	comment '销售属性2',
    `sp3` 				varchar(200)	comment '销售属性3',
    `product_pic` 		varchar(1000)	comment '商品主图',
    `product_name` 		varchar(500)	comment '商品名称',
    `product_brand` 	varchar(200)	comment '商品品牌',
    `product_sn` 		varchar(200)	comment '商品的条码',
    `product_sub_title` varchar(500)	comment '商品副标题（卖点）',
    `product_sku_code` 	varchar(200)	comment '商品sku条码',
    `member_nickname` 	varchar(500)	comment '会员昵称',
    `create_date` 		DATETIME		comment '创建时间',
    `modify_date` 		DATETIME		comment '修改时间',
    `delete_status` 	int(1)			comment '是否删除',
    `product_category_id` bigint		comment '商品的分类',
    `product_attr` 		varchar(500)	comment '商品销售属性:[{key:颜⾊',
    primary key (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='购物⻋表';