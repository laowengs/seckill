CREATE DATABASE seckilldb;
CREATE USER 'seckill'@'%' IDENTIFIED BY 'seckill.1qaz';


DROP TABLE item_inventory;
CREATE TABLE `item_inventory` (
                                  `item_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `item_num` int(11) NOT NULL DEFAULT '0',
                                  `create_date` date NOT NULL DEFAULT '1990-01-01' COMMENT '创建时间',
                                  `status_date` date NOT NULL DEFAULT '1990-01-01' COMMENT '状态时间',
                                  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


-- 初始测试数据
INSERT INTO `item_inventory` (`item_id`, `item_num`,`create_date`,`status_date`) VALUES ('1', '999',NOW(),NOW());

-- 增加状态
ALTER TABLE item_inventory ADD COLUMN status_code INT NOT NULL DEFAULT 0 COMMENT '商品状态 0 初始 1 已预热';

-- 修改表时间字段类型
alter table item_inventory MODIFY status_date datetime DEFAULT  now();
alter table item_inventory MODIFY create_date datetime DEFAULT  now();