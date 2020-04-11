drop database blog;
create database blog;
show databases;
use blog;

-- ----------------------------
-- tb_user
-- ----------------------------
drop table if exists tb_user;
create table tb_user (
                         id int(11) not null auto_increment,
                         username varchar(100) not null,
                         password varchar(200) not null,
                         phone varchar(100) not null,
                         email varchar(100) not null,
                         gender varchar(100) not null,
                         birthday varchar(100),
                         introduce varchar(255),
                         avatar varchar(255) not null,
                         last_login_date bigint(20) not null,
                         account_expired tinyint(1) not null default 0,
                         account_locked tinyint(1) not null default 0,
                         primary key(id)
);
begin;
insert into tb_user(username, password, phone, email, gender, birthday, introduce, avatar,
                 last_login_date, account_expired, account_locked) values ('test','123456','13012341234','test@test',
                                                                           'male','2020-02-22','no info','',11111111,
                                                                           0,0);
commit;

-- ----------------------------
-- spring security
-- ----------------------------
drop table if exists persistent_logins;
create table persistent_logins(
                                  username varchar(64) not null,
                                  series varchar(64) primary key,
                                  token varchar(64) not null,
                                  last_used timestamp not null
);

-- ----------------------------
-- tb_login_log
-- ----------------------------
drop table if exists tb_login_log;
create table tb_login_log (
                                id bigint(20) not null auto_increment,
                                username varchar(100) not null,
                                ip varchar(20) not null,
                                location varchar(255),
                                login_time bigint(20),
                                device varchar(255),
                                primary key (id)
);
begin;
insert into tb_login_log (username, ip, location, login_time, device) values ('test','127.0.0.1','local',
                                                                              4523523523525,'Unknown');
commit;

-- ----------------------------
-- tb_article
-- ----------------------------
drop table if exists tb_article;
create table tb_article(
                           id int(11) not null auto_increment,
                           title varchar(400) not null,
                           cover varchar(400) not null,
                           author varchar(100) not null,
                           type int(1) default 0,
                           origin varchar(255),
                           content mediumtext,
                           content_md mediumtext,
                           status varchar(100) NOT NULL,
                           create_time bigint(20) not null,
                           publish_time bigint(20),
                           last_edit_time bigint(20),
                           primary key (id)
);
begin;
insert into tb_article (title, cover, author, type, origin, content, content_md, status, create_time, publish_time,
                        last_edit_time) VALUES ('How to write an article?', 'test-img-url',
'test',0,'article-url', '<h1>test content</h1>','#test content','created',32432423442,3234234234234,null);
commit;

-- ----------------------------
-- tb_category
-- ----------------------------
drop table if exists tb_category;
create table tb_category(
                            id int(11) not null auto_increment,
                            name varchar(100) not null ,
                            primary key (id)
);
begin;
insert into tb_category(name) values ('springboot');
commit;

-- ----------------------------
-- tb_article_category
-- ----------------------------
drop table if exists tb_article_category;
create table tb_article_category(
                                    id bigint(20) not null auto_increment,
                                    article_id int(11) not null ,
                                    category_id int(11) not null ,
                                    primary key (id)
);
begin;
insert into tb_article_category (article_id, category_id) values (1,1);
commit;

-- ----------------------------
-- tb_tag
-- ----------------------------
drop table if exists tb_tag;
create table tb_tag(
                            id int(11) not null auto_increment,
                            name varchar(100) not null ,
                            primary key (id)
);
begin;
insert into tb_tag(name) values ('test tag');
commit;

-- ----------------------------
-- tb_article_tag
-- ----------------------------
drop table if exists tb_article_tag;
create table tb_article_tag(
                                    id bigint(20) not null auto_increment,
                                    article_id int(11) not null ,
                                    tag_id int(11) not null ,
                                    primary key (id)
);
begin;
insert into tb_article_tag (article_id, tag_id) values (1,1);
commit;

-- ----------------------------
-- tb_article_info
-- ----------------------------
drop table if exists tb_article_info;
create table tb_article_info(
                               id bigint(11) not null auto_increment,
                               article_id int(11) not null,
                               read_number int(11) not null default 0,
                               like_number int(11) not null default 0,
                               primary key (id)
);
begin;
insert into tb_article_info (article_id, read_number, like_number) values (1,10,5);
commit;

-- ----------------------------
-- tb_article_log
-- ----------------------------
drop table if exists tb_article_log;
create table tb_article_log(
                               id bigint(20) not null auto_increment,
                               username varchar(100),
                               operation varchar(25),
                               time bigint(20),
                               method varchar(255),
                               params varchar(255),
                               ip varchar(20),
                               create_time bigint(20),
                               location varchar(255),
                               primary key (id)
);
begin;
insert into tb_article_log(username, operation, time, method, params, ip, create_time, location) values ('test',
                                                                                                         'delete
article',234,'un.haarf.blog.service.UserService.delete()','User[user info to string]','127.0.0.1',2342134123444,
                                                                                                         'Unknown');
commit;

-- ----------------------------
-- tb_link
-- ----------------------------
drop table if exists link;
create table link(
                     id bigint(20) not null auto_increment,
                     name varchar(100),
                     url varchar(255),
                     primary key (id)
);

-- ----------------------------
-- tb_comment
-- ----------------------------
drop table if exists tb_comment;
create table tb_comment(
                           id bigint(20) not null auto_increment,
                           p_id bigint(20),
                           c_id bigint(20),
                           article_id int(11),
                           article_title varchar(400),
                           name varchar(100),
                           reply_name varchar(100),
                           create_time bigint(20),
                           content text,
                           email varchar(100),
                           url varchar(255),
                           ip varchar(20),
                           device varchar(266),
                           address varchar(100),
                           primary key (id)
);



