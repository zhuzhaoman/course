drop table if exists `test`;
create table `test` (
	`id` int(12) not null default '' comment 'id',
	`name` varchar(255) comment '名称',
	primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='测试';

insert into `test` (`id`, `name`) values (4, '赵六');


drop table if exists `chapter`;
create table `chapter` (
    `id` varchar(255) not null comment 'ID',
    `course_id` varchar(255) comment '课程ID',
    `name` varchar(255) comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';

insert into `chapter` (id, course_id, name) values('0001', '0001', '测试大章01');
insert into `chapter` (id, course_id, name) values('0002', '0002', '测试大章02');
insert into `chapter` (id, course_id, name) values('0003', '0003', '测试大章03');
insert into `chapter` (id, course_id, name) values('0004', '0004', '测试大章04');
insert into `chapter` (id, course_id, name) values('0005', '0005', '测试大章05');
insert into `chapter` (id, course_id, name) values('0006', '0006', '测试大章06');
insert into `chapter` (id, course_id, name) values('0007', '0007', '测试大章07');
insert into `chapter` (id, course_id, name) values('0008', '0008', '测试大章08');
insert into `chapter` (id, course_id, name) values('0009', '0009', '测试大章09');
insert into `chapter` (id, course_id, name) values('0010', '0010', '测试大章10');
insert into `chapter` (id, course_id, name) values('0011', '0011', '测试大章11');
insert into `chapter` (id, course_id, name) values('0012', '0012', '测试大章12');
insert into `chapter` (id, course_id, name) values('0013', '0013', '测试大章13');
insert into `chapter` (id, course_id, name) values('0014', '0014', '测试大章14');
insert into `chapter` (id, course_id, name) values('0015', '0015', '测试大章15');
insert into `chapter` (id, course_id, name) values('0016', '0016', '测试大章16');
insert into `chapter` (id, course_id, name) values('0017', '0017', '测试大章17');
insert into `chapter` (id, course_id, name) values('0018', '0018', '测试大章18');
insert into `chapter` (id, course_id, name) values('0019', '0019', '测试大章19');
insert into `chapter` (id, course_id, name) values('0020', '0020', '测试大章20');
insert into `chapter` (id, course_id, name) values('0021', '0021', '测试大章21');
insert into `chapter` (id, course_id, name) values('0022', '0022', '测试大章22');