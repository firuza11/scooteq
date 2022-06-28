drop database if exists `scooteq`;

create database if not exists `scooteq`;

use `scooteq`;

create table if not exists `user` (id INT primary key auto_increment NOT NULL,
username varchar(255),
password_hash varchar(255));