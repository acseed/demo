
CREATE DATABASE IF NOT EXISTS mybatis DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
use mybatis;
create table `country` (
    `id` int not null auto_increment,
    `country_name` varchar(255) null,
    `country_code` varchar(255) null,
    primary key (`id`)
) engine=InnoDB default charset utf8mb4;

insert into country(`country_name`, `country_code`)
values ('中国', 'CN'),
       ('美国', 'US'),
       ('俄罗斯', 'RU'),
       ('英国', 'GB'),
       ('法国', 'FR');
