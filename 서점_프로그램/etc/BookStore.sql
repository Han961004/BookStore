drop schema if exists project;
create schema project;

use project;

create table members(
	id varchar(20) not null,
    pw varchar(20),
	uname varchar(20),
    age varchar(20),
    tel varchar(20),
    address varchar(20),
    primary key(id)
    );

insert into members value ('mem1', '1234', '김하하', '30', '010-2222-3333', '서울시');
insert into members value ('mem2', '2345', '박하하', '40', '010-3333-4444', '부산시');


create table books(
	bnum varchar(20) not null,
    bname varchar(20),
    author varchar(20),
    publisher varchar(20),
    price varchar(20),
    stock varchar(20),
    primary key(bnum)
    );
insert into books value ('a001', '쉽게배우는자바프로그래밍', '우종정', '한빛아카데미', '29000', '3');
insert into books value ('a002', 'RedHat Fedora 리눅스서버', '우재남', '한빛미디어', '28000', '1');
insert into books value ('b003', '해커스 토익', '해커스', '해커스 어학연구소', '11900', '10');

    
create table orders(
	onum varchar(20) not null,
	bnum varchar(20),
    id varchar(20),
    FOREIGN KEY (bnum) REFERENCES books(bnum),
	FOREIGN KEY (id) REFERENCES members(id),
    
    uname varchar(20),
    address varchar(20),
    count varchar(20),
    
    primary key(onum)
    );
INSERT INTO `project`.`orders` (`onum`, `bnum`, `id`, `uname`, `address`, `count`) VALUES ('o001', 'a001', 'mem1', '김하하', '서울시', '2');
INSERT INTO `project`.`orders` (`onum`, `bnum`, `id`, `uname`, `address`, `count`) VALUES ('o002', 'a002', 'mem1', '김하하', '서울시', '2');
INSERT INTO `project`.`orders` (`onum`, `bnum`, `id`, `uname`, `address`, `count`) VALUES ('o003', 'a001', 'mem2', '박하하', '부산시', '1');

create table admins(
	id varchar(20) not null,
    pw varchar(20),
    primary key(id)
    );
    
insert into admins value ('admin', '1234');