
DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL auto_increment,
  `student_name` varchar(15) NOT NULL COMMENT '学生姓名',
  `teacher_name` varchar(15) DEFAULT NULL COMMENT '教师姓名',
  `question` varchar(200) NOT NULL COMMENT '提问',
  `answer` varchar(200) default '未答复' COMMENT '答复',
  `request_time` datetime DEFAULT NULL COMMENT '提问时间',
  `response_time` datetime DEFAULT NULL COMMENT '回答时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `message`(`student_name`,`teacher_name`,`question`,`answer`,`request_time`,`response_time`) values ('张三','王老师','老师，这题题目有问题','感谢提问,这题没问题呢,你再仔细看看题目','2019-02-27 17:47:08','2019-02-27 17:47:08'),('川普','叶老师','Fake News,what''s your problem','you should see a doctor, son','2019-02-28 20:50:08','2019-02-28 20:50:08');

insert  into `message`(`student_name`,`question`,`request_time`) values ('刘邦','我的江山啊','2019-10-27 14:00:08'),('吕布','我的貂蝉在哪里','2020-1-27 08:00:08');

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `sno` varchar(20) DEFAULT NULL COMMENT '学生用学号加密码登录',
  `teacher_phone` varchar(20) DEFAULT NULL COMMENT '教师用手机号加密码登录',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `user`(`username`,`password`,`sno`,`teacher_phone`) values ('叶小兮','b91af46dddd12a947a86469e2be8631a','','15629968857'),('王老师','laowang123456','','13865240466');

insert  into `user`(`username`,`password`,`sno`,`teacher_phone`) values ('高老师','GQ123456','','GS2020');

insert  into `user`(`username`,`password`,`sno`,`teacher_phone`) values ('高强','0e31173e010c9cb47b30b7f85a568b51','','GQ2020'),('Scarlett','cf8835d1a9f85539eff99e7e3df029f2','','ZYC2020'),('赵丽丽','0084cc2682f371fa43adbf2dc1a785a0','','ZLL2020')
,('徐圣男','1cbc9c83e08d10fd5b4d02c85bf3c947','','XSN2020'),('燕铃','a7dc7a28bebe48d3cf62f07811a57b1a','','YL2020');

select username,sno,password from user;

DROP TABLE IF EXISTS `statistics`;

CREATE TABLE `statistics` (
  `id` int(11) NOT NULL auto_increment,
  `year` varchar(10) NOT NULL COMMENT '年份',
  `month` varchar(5) NOT NULL COMMENT '月份',
  `visitornumber` varchar(10) DEFAULT NULL COMMENT '访客人数',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `statistics` (`year`,`month` ,`visitornumber`) values ('2020','1','906'),('2020','2','1265'),('2020','3','1225'),('2020','4','222'),('2020','5','1265'),('2020','6','1335'),('2020','7','265'),('2020','8','126'),('2020','9','0'),('2020','10','0'),('2020','11','0'),('2020','12','0');

DROP TABLE IF EXISTS `studentreportcard`;

CREATE TABLE `studentreportcard` (
  `id` int(11) NOT NULL auto_increment,
  `sno` varchar(30) NOT NULL COMMENT '学号',
  `examstatus` varchar(2) DEFAULT '2' COMMENT '考试提交状态',
  `examgrade` varchar(10) DEFAULT '-1' COMMENT '考试成绩',
  `spendtime` varchar(10) DEFAULT '-1' COMMENT '考试用时',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `studentreportcard` (`sno`,`examstatus`,`examgrade`,`spendtime`) values ('10001','1','70','76'),('10002','1','61','70'),('10003','1','81','65'),('10004','1','99','66'),('10005','1','30','89'),('10006','1','46','88');

insert  into `studentreportcard` (`sno`) values ('10007');

insert  into `studentreportcard` (`sno`,`examstatus`,`examgrade`,`spendtime`) values ('10008','2','-1','-1');
