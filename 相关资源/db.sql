
-- 创建数据库
drop database if exists handson ;
create database handson charset utf8 ;
use handson;

-- 创建数据库用户
DROP USER  EMPSYS@localhost ;
CREATE USER EMPSYS@localhost IDENTIFIED BY "EMPSYS";
GRANT ALL ON handson.* TO EMPSYS@localhost;

-- 多次测试需删除之前的
drop table if exists employee;
drop table if exists post;

-- 创建职位表
create table post(
	post_id int(4) primary key , -- 职位编号
	post_name varchar(50) not null , -- 职位名称
	post_desc varchar(100) not null  -- 职位描述
) charset utf8;

-- 创建雇员表
create table employee(
	emp_id int(4) primary key , -- 雇员编号
	post_id int(4) not null , -- 职位编号
	emp_name varchar(100) , -- 雇员姓名
	emp_sex int(4) , -- 雇员性别，1男2女
	emp_age int(4) , -- 雇员年龄 
	emp_depart varchar(50) , -- 所属部门
	emp_year int(4), -- 雇员年龄
	constraint emp_post_fk foreign key (post_id) references post(post_id)
) charset utf8 ;


-- 插入职位表测试数据
insert into post(post_id,post_name,post_desc) values 
(1000,"行政助理","行政辅助人员"),
(1001,"行政主管","行政负责人"),
(1002,"业务经理","业务处主管"),
(1003,"总经理","公司负责人");
-- 插入雇员表测试数据
insert into employee(emp_id,post_id,emp_name,emp_sex,emp_age,emp_depart,emp_year) values 
(1,1000,"李晓明",1,25,"行政部",2),
(2,1000,"杨伟林",1,29,"行政部",5),
(3,1002,"尤志苗",2,33,"业务部",9),
(4,1003,"牛晓飞",1,40,"集团",10),
(5,1000,"李白",1,20,"业务部",9),
(6,1001,"曹操",1,60,"集团",20),
(7,1002,"刘备",1,50,"集团",10),
(8,1003,"诸葛亮",1,25,"行政部",3),
(9,1002,"孙权",1,30,"集团",10),
(10,1003,"周瑜",1,28,"行政部",5),
(11,1001,"诸葛瑾",1,30,"业务部",6),
(12,1002,"司马懿",1,32,"业务部",9),
(13,1003,"大乔",2,19,"行政部",2),
(14,1000,"小乔",2,18,"行政部",1);


