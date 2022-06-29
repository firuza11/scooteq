drop database if exists `scooteq`;

create database if not exists `scooteq`;

use `scooteq`;

create table if not exists `user` (
    id INT primary key auto_increment not null,
    username varchar(255) not null,
    password_hash varchar(255) not null,
	UNIQUE (username));

INSERT INTO
    user (username, password_hash)
VALUES
    ('123', MD5('123'));