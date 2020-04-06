drop database blog;
create database blog;
show databases;
use blog;
create table user(
    id int(11) not null auto_increment,
    username varchar(100) not null default '',
    password varchar(200) not null default '',
    phone varchar(100) not null default '',
    email varchar(100) not null default '',
    gender varchar(100) not null default '',
    birthday varchar(100) not null default '',
    personal_brief_intro varchar(255) default '',
    avatar_img_url varchar(255) not null default '',
    last_login_date varchar(255) not null default '',
    account_expired tinyint(1) not null default 0,
    account_locked tinyint(1) not null default 0,
    primary key(id)
);
insert into user(username, password, phone, email, gender, birthday, personal_brief_intro, avatar_img_url,
                 last_login_date, account_expired, account_locked) values ('test','123456','13012341234','test@test',
                                                                           'male','2020-02-22','no info','','',0,0);
select * from user;

create table persistent_logins(
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);