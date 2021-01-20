
CREATE TABLE `item_inventory` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_num` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4

INSERT INTO `item_inventory` (`item_id`, `item_num`) VALUES ('1', '10');
