drop schema if exists project;
create schema project;

use project;

    
create table admins(
	id varchar(20) not null,
    pw varchar(20),
    primary key(id)
    );
    
insert into admins value ('admin', '1234');
insert into admins value ('', '');


create table members(
	id varchar(20) not null,
    pw varchar(20),
	uname varchar(20),
    age int,
    primary key(id)
    );

insert into members value ('mem1', '1234', '김하하', '30');
insert into members value ('mem2', '2345', '박하하', '40');


create table books(
	bnum varchar(20) not null,					/*책의 종류 a로 시작은 교육, b로 시작은 참고서 등등...*/
    bname varchar(20),
    author varchar(20),
    publisher varchar(20),
    price int,
    stock int(2),
    primary key(bnum)
    );
insert into books value ('a001', '쉽게배우는자바프로그래밍', '우종정', '한빛아카데미', '29000', '03');
insert into books value ('a002', 'RedHat Fedora 리눅스서버', '우재남', '한빛미디어', '28000', '01');
insert into books value ('b003', '해커스 토익', '해커스', '해커스 어학연구소', '11900', '10');
INSERT INTO  books value ('c001', '정보처리산업기사 실기','김가가','폴리텍','15000','04');					
INSERT INTO  books value ('c004', '정보처리산업기사 필기','김나가','폴리텍','18000','04');
INSERT INTO  books value ('h003', '정보통신개론','김가다','폴리텍','30000','05');
INSERT INTO  books value ('h002', 'R코딩','이가가','폴리텍','9000','05');
INSERT INTO  books value ('h001', 'PHP프로그래밍','김이가','폴리텍','16000','05');
INSERT INTO  books value ('h004', '데이터베이스','박가가','폴리텍','20000','05');
INSERT INTO  books value ('h005', '아두이노','하가가','폴리텍','5000','05');
INSERT INTO  books value ('h006', '컴퓨터개론','김가나','폴리텍','15000','05');
INSERT INTO  books value ('h007', '리눅스마스터2급','바바가','폴리텍','20000','05');
INSERT INTO  books value ('h008', '리눅스마스터1급','김나나','폴리텍','30000','05');
INSERT INTO  books value ('h009', '안드로이드 프로그래밍','구하하','폴리텍','50000','05');
INSERT INTO  books value ('h010', '인공지능개론','구나나','폴리텍','13000','05');
INSERT INTO  books value ('h011', 'JAVA프로그래밍','최나나','폴리텍','20000','05');
INSERT INTO  books value ('b001', 'JLPT한권으로끝내기','최최이','폴리텍','20000','05');
INSERT INTO books value('h012', '컴퓨팅사고with파이썬','최최이','폴리텍','10000','05');
INSERT INTO books value('h013', '프로그래밍C','최최이','폴리텍','40000','05');
INSERT INTO books value('h014', 'C++','최최이','폴리텍','30000','05');
INSERT INTO books value('h015', 'C#','최최이','폴리텍','20000','05');
INSERT INTO books value('h016', '정보통신의 이해','최최이','폴리텍','30000','05');
INSERT INTO books value('h017', '모두의 데이터분석','최최이','폴리텍','50000','05');
INSERT INTO books value('h018', '데이터베이스 개론','최최이','폴리텍','20000','05');
INSERT INTO books value('h019', 'JAVA200제','최최이','폴리텍','30000','05');
INSERT INTO books value('b002', 'HSK6급','최최이','폴리텍','20000','05');
INSERT INTO books value('b004', 'HSK5급','최최이','폴리텍','10000','05');
INSERT INTO books value('b005', '스페인어 마스터','최최이','폴리텍','10000','05');
INSERT INTO books value ('d001', '작별인사', '김영하','최최이','30000','05');
INSERT INTO books value ('d002', '불편한 편의점', '김호연', '나무옆의자', '12600','03');

create table orders(
	onum int not null AUTO_INCREMENT,
	bnum varchar(20),
    id varchar(20),
    FOREIGN KEY (bnum) REFERENCES books(bnum),
	FOREIGN KEY (id) REFERENCES members(id),
    
    person varchar(20),
    tel varchar(11),
    count int,

    address varchar(40),
    
    primary key(onum)
    );
    
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`) VALUES ('a002', 'mem1', '김하하', '01012341234', '1', '서울시 서대문구 홍은동 123-123 (단독주택)');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`) VALUES ('a001', 'mem1', '김나나', '01023452345', '1', '서울시 강남구 테헤란로 304-23');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`) VALUES ('a002', 'mem1', '박다다', '01034563456', '1', '부산시 해운대구 203-30');


CREATE TABLE sale (	
  salenum varchar(10) NOt null,
  counts int NULL,
  total int NULL,
  bname VARCHAR(45) NULL,
  dates DATE NULL DEFAULT (current_date),				/*이상없음*/
  PRIMARY KEY (salenum)
  );
  
INSERT INTO sale value ('o001', 2, 50000,'C++','2022-05-03');		/* now() 는 오늘 날짜 */
INSERT INTO sale value ('o002', 3, 40000,'C#','2022-04-02');
INSERT INTO sale value ('o003', 1, 133000,'정보통신개론','2022-01-05');
INSERT INTO sale value ('o004', 2, 140000,'C#','2022-02-02');
INSERT INTO sale value ('o005', 8, 600000,'정보통신개론','2022-03-05');
INSERT INTO sale value ('o006', 7, 900000,'C#','2022-04-02');
INSERT INTO sale value ('o007', 6, 30000,'정보통신개론','2021-03-05');
INSERT INTO sale value ('o008', 5, 40000,'C#','2021-04-02');
INSERT INTO sale value ('o009', 10, 30000,'정보통신개론','2021-03-05');


    
    


