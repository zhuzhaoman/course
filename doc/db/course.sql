drop table if exists `test`;
create table `test` (
	`id` int(12) not null default '' comment 'id',
	`name` varchar(255) comment '名称',
	primary key (`id`)
) engine=innodb default charset=utf-8 comment='测试'

insert into `test` (`id`, `name`) values (1, '测试');