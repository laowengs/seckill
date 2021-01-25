CREATE DATABASE seckilldb;
CREATE USER 'seckill'@'%' IDENTIFIED BY 'seckill.1qaz';


DROP TABLE item_inventory;
CREATE TABLE `item_inventory` (
                                  `item_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `item_num` int(11) NOT NULL DEFAULT '0',
                                  `create_date` date NOT NULL DEFAULT '1990-01-01' COMMENT '创建时间',
                                  `status_date` date NOT NULL DEFAULT '1990-01-01' COMMENT '创建时间',
                                  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT INTO `item_inventory` (`item_id`, `item_num`,`create_date`,`status_date`) VALUES ('1', '999',NOW(),NOW());