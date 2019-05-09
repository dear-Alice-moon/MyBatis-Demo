
-- 创建 country表      2019/01/13 16:58  @moon                                          
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键, id值',
  `country_name` varchar(255) DEFAULT NULL COMMENT '国家名',
  `country_code` varchar(255) DEFAULT NULL COMMENT '国家编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '国家表';

-- 插入5条数据                
INSERT country(country_name, country_code) 
VALUES ('中国','CN'), ('美国','US'), ('俄罗斯','RU'), ('英国','GB'), ('法国','FR')                




