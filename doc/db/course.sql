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

insert into `chapter` (id, course_id, name) values('0001', '00001', '测试大章一');
insert into `chapter` (id, course_id, name) values('0002', '00002', '测试大章二');