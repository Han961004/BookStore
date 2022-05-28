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
insert into books value ('a001', '쉽게배우는자바프로그래밍', '우종정', '한빛아카데미', '29000', '03');
insert into books value ('a002', 'RedHat Fedora 리눅스서버', '우재남', '한빛미디어', '28000', '01');
insert into books value ('b003', '해커스 토익', '해커스', '해커스 어학연구소', '11900', '10');
INSERT INTO  books values ('c001', '정보처리산업기사 실기','김가가','','','04');
INSERT INTO  books value ('c004', '정보처리산업기사 필기','김나가','','','04');
INSERT INTO  books value ('h003', '정보통신개론','김가다','','','05');
INSERT INTO  books value ('h002', 'R코딩','이가가','','','05');
INSERT INTO  books value ('h001', 'PHP프로그래밍','김이가','','','05');
INSERT INTO  books value ('h004', '데이터베이스','박가가','','','05');
INSERT INTO  books value ('h005', '아두이노','하가가','','','05');
INSERT INTO  books value ('h006', '컴퓨터개론','김가나','','','05');
INSERT INTO  books value ('h007', '리눅스마스터2급','바바가','','','05');
INSERT INTO  books value ('h008', '리눅스마스터1급','김나나','','','05');
INSERT INTO  books value ('h009', '안드로이드 프로그래밍','구하하','','','05');
INSERT INTO  books value ('h010', '인공지능개론','구나나','','','05');
INSERT INTO  books value ('h011', 'JAVA프로그래밍','최나나','','','05');
INSERT INTO  books value ('b001', 'JLPT한권으로끝내기','최최이','','','05');


INSERT INTO books value('h012', '컴퓨팅사고with파이썬','최최이','','','05');
INSERT INTO books value('h013', '프로그래밍C','최최이','','','05');
INSERT INTO books value('h014', 'C++','최최이','','','05');
INSERT INTO books value('h015', 'C#','최최이','','','05');
INSERT INTO books value('h016', '정보통신의 이해','최최이','','','05');
INSERT INTO books value('h017', '모두의 데이터분석','최최이','','','05');
INSERT INTO books value('h018', '데이터베이스 개론','최최이','','','05');
INSERT INTO books value('h019', 'JAVA200제','최최이','','','05');
INSERT INTO books value('b002', 'HSK6급','최최이','','','05');
INSERT INTO books value('b004', 'HSK5급','최최이','','','05');
INSERT INTO books value('b005', '스페인어 마스터','최최이','','','05');
INSERT INTO books value ('d001', '작별인사', '김영하','최최이','','05');
INSERT INTO books value ('d002', '불편한 편의점', '김호연', '나무옆의자', '12600','03');




CREATE TABLE sale (	
  salenum varchar(10) NOt null,
  years VARCHAR(4) NOT NULL,
  months VARCHAR(2) NULL,
  days VARCHAR(2) NULL,
  counts VARCHAR(2) NULL,
  total varchar(10) NULL,
  bname VARCHAR(45) NULL,
  
  PRIMARY KEY (salenum)
  );
  
INSERT INTO sale value ('o001','2022', '04', '01', '02', '50000','C++');
INSERT INTO sale value ('o002','2022', '04', '02', '03', '40000','C#');
INSERT INTO sale value ('o003','2022', '05', '01', '05', '30000','정보통신개론');

create table orders(
	onum varchar(20) not null,
	bnum varchar(20),
    id varchar(20),
    FOREIGN KEY (bnum) REFERENCES books(bnum),
	FOREIGN KEY (id) REFERENCES members(id),
    
    
    
    person varchar(20),
    address varchar(20),
    tel varchar(20),
    count varchar(20),
    
    primary key(onum)
    );
    
    
    
    
    
    
    
create table admins(
	id varchar(20) not null,
    pw varchar(20),
    primary key(id)
    );
    
insert into admins value ('admin', '1234');


