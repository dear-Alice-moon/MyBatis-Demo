
#创建数据库
CREATE SCHEMA `mybatis_plus` DEFAULT CHARACTER SET utf8;

#创建用户表
CREATE TABLE user (
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键',
    name VARCHAR(30) DEFAULT NULL COMMENT '姓名',
    age INT(11) DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    manager_id BIGINT(20) DEFAULT NULL COMMENT '直属上级id',
    create_time DATETIME DEFAULT NULL COMMENT '创建时间',
    CONSTRAINT manager_fk FOREIGN KEY (manager_id) REFERENCES user (id)
)  ENGINE=INNODB CHARSET=UTF8;



#初始化数据：
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1087982257332887553', '大boss', '40', 'boss@baomidou.com', NULL, '2019-01-11 14:20:20');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088248166370830001', '张三', '21', 'zs2020@baomidou.com', '1087982257332887553', '2019-02-05 11:12:22');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088248166370830002', '李四', '20', 'ls@baomidou.com', '1088248166370830001', '2019-05-05 11:12:22');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088248166370830003', '王五', '20', 'ww@baomidou.com', '1088248166370830001', '2019-04-05 11:12:22');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088248166370830004', '赵柳', '20', 'zl@baomidou.com', '1088248166370830002', '2019-11-05 11:12:22');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088248166370832385', '王天风', '25', 'wtf@baomidou.com', '1087982257332887553', '2019-02-05 11:12:22');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1088250446457389058', '李艺伟', '34', 'lyw-2020@baomidou.com', '1088248166370832385', '2019-02-14 08:31:16');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1094590409767661570', '张雨琪', '31', 'zjq@baomidou.com', '1088248166370832385', '2019-01-14 09:15:15');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1094592041087729001', '刘江', '32', 'lj@baomidou.com', '1088248166370832385', '2020-07-03 11:41:13');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1094592041087729002', '王雄', '28', 'wx@baomidou.com', '1088248166370832385', '2019-08-15 15:18:07');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1094592041087729003', '上官云', '16', 'sgy@baomidou.com', '1088248166370832385', '2020-03-18 18:14:56');
INSERT INTO user (`id`, `name`, `age`, `email`, `manager_id`, `create_time`) VALUES ('1094592041087729666', '刘红雨', '32', 'lhm@baomidou.com', '1088248166370832385', '2019-01-14 09:48:16');


