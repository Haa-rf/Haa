drop database blog;
create database blog;
show databases;
use blog;

-- ----------------------------
-- tb_user
-- ----------------------------
drop table if exists tb_user;
CREATE TABLE tb_user (
                         id int(11) not null auto_increment,
                         username varchar(100) not null,
                         password varchar(200) not null,
                         phone varchar(100) not null,
                         email varchar(100) not null,
                         gender varchar(100) not null,
                         birthday varchar(100),
                         personal_brief_intro varchar(255),
                         avatar_img_url varchar(255) not null,
                         last_login_date bigint(15) not null,
                         account_expired tinyint(1) not null default 0,
                         account_locked tinyint(1) not null default 0,
                         primary key(id)
);
begin;
insert into tb_user(username, password, phone, email, gender, birthday, personal_brief_intro, avatar_img_url,
                 last_login_date, account_expired, account_locked) values ('test','123456','13012341234','test@test',
                                                                           'male','2020-02-22','no info','',11111111,
                                                                           0,0);
commit;

-- ----------------------------
-- spring security
-- ----------------------------
create table persistent_logins(
                                  username varchar(64) not null,
                                  series varchar(64) primary key,
                                  token varchar(64) not null,
                                  last_used timestamp not null
);