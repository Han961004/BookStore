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
insert into members value ('mem2', '2345', '박하하', '10');
insert into members value ('mem3', '2345', '이하하', '20');
insert into members value ('mem4', '2345', '최하하', '30');
insert into members value ('mem5', '2345', '박가가', '10');
insert into members value ('mem6', '2345', '박나나', '10');
insert into members value ('mem7', '2345', '박다다', '20');
insert into members value ('mem8', '2345', '김나나', '30');
insert into members value ('mem9', '2345', '김치치', '40');
insert into members value ('mem10', '2345', '아아아', '20');


create table books(
	bnum varchar(20) not null,					/*책의 종류 a로 시작은 교육, b로 시작은 참고서 등등...*/
    bname varchar(20),
    author varchar(20),
    publisher varchar(20),
    price int,
    stock int(2),
    primary key(bnum)
    );
    
    /*a는 교보재 c는 참고서 f는 외국어 b는 자격증 s는 소셜대중책 // 번호 제목 저자 출판사 가격 현재고*/
insert into books value ('a001', '쉽게배우는자바프로그래밍', '우종정', '한빛아카데미', '29000', '03');
insert into books value ('a002', 'RedHat Fedora 리눅스서버', '우재남', '한빛미디어', '28000', '01');
insert into books value ('f003', '해커스 토익', '해커스', '해커스 어학연구소', '11900', '10');
INSERT INTO  books value ('b001', '정보처리산업기사 실기','김가가','폴리텍','15000','04');					
INSERT INTO  books value ('b004', '정보처리산업기사 필기','김나가','폴리텍','18000','04');
INSERT INTO  books value ('a003', '정보통신개론','김가다','폴리텍','30000','05');
INSERT INTO  books value ('a002', 'R코딩','이가가','폴리텍','9000','05');
INSERT INTO  books value ('a020', 'PHP프로그래밍','김이가','폴리텍','16000','05');
INSERT INTO  books value ('a004', '데이터베이스','박가가','폴리텍','20000','05');
INSERT INTO  books value ('a005', '아두이노','하가가','폴리텍','5000','05');
INSERT INTO  books value ('a006', '컴퓨터개론','김가나','폴리텍','15000','05');
INSERT INTO  books value ('b007', '리눅스마스터2급','바바가','폴리텍','20000','05');
INSERT INTO  books value ('b008', '리눅스마스터1급','김나나','폴리텍','30000','05');
INSERT INTO  books value ('a009', '안드로이드 프로그래밍','구하하','폴리텍','40000','05');
INSERT INTO  books value ('a010', '인공지능개론','구나나','폴리텍','13000','05');
INSERT INTO  books value ('a011', 'JAVA프로그래밍','최나나','폴리텍','20000','05');
INSERT INTO  books value ('f001', 'JLPT한권으로끝내기','최최이','폴리텍','20000','05');
INSERT INTO books value('a012', '컴퓨팅사고with파이썬','최최이','폴리텍','10000','05');
INSERT INTO books value('a013', '프로그래밍C','최최이','폴리텍','40000','05');
INSERT INTO books value('a014', 'C++','최최이','폴리텍','30000','05');
INSERT INTO books value('a015', 'C#','최최이','폴리텍','20000','05');
INSERT INTO books value('a016', '정보통신의 이해','최최이','폴리텍','30000','05');
INSERT INTO books value('a017', '모두의 데이터분석','최최이','폴리텍','50000','05');
INSERT INTO books value('a018', '데이터베이스 개론','최최이','폴리텍','20000','05');
INSERT INTO books value('a019', 'JAVA200제','최최이','폴리텍','30000','05');
INSERT INTO books value('f002', 'HSK6급','최최이','폴리텍','20000','05');
INSERT INTO books value('f004', 'HSK5급','최최이','폴리텍','10000','05');
INSERT INTO books value('f005', '스페인어 마스터','최최이','폴리텍','10000','05');
INSERT INTO books value ('s001', '작별인사', '김영하','최최이','30000','05');

INSERT INTO books value ('f006', '일본어 문법 사전', '김호연', '나무옆의자', '12600','10');
INSERT INTO books value ('f007', '중국어 문법 사전', '김호연', '나무옆의자', '12600','10');
INSERT INTO books value ('f008', '한권으로 끝내기 중국어', '김호연', '나무옆의자', '12600','03');
INSERT INTO books value ('f009', '한권으로 끝내기 일본어', '김호연', '나무옆의자', '12600','03');
INSERT INTO books value ('f001', '한권으로 끝내기 영어', '김호연', '나무옆의자', '12600','03');

INSERT INTO books value ('s003', '나로서 충분히 괜찮은 사람', '김재식', '북로망스', '14400','05');
INSERT INTO books value ('s004', '기분을 관리하면 인생이 관리된다', '김다슬', '클라우디아', '15840','07');
INSERT INTO books value ('s005', '변화하는 세계 질서', '송이루', '한빛비즈', '34200','06');
INSERT INTO books value ('s006', '컬러애 물들다', '최진선', '리드리드출판', '15120','05');
INSERT INTO books value ('s007', '이웃집 백만장자', '홍정희', '리드리드출판', '16900','04');
INSERT INTO books value ('s008', '돈그릇을 키우는 6가지 방법', '김승현', '앤페이지', '13500','03');

INSERT INTO books value ('c001', '수학의 정석', '교육부', '교육부', '10000','03');
INSERT INTO books value ('c002', '국어의 정석', '교육부', '교육부', '9000','03');
INSERT INTO books value ('c003', '수학의 정석2', '교육부', '교육부', '12000','03');
INSERT INTO books value ('c004', '수학의 정석3', '교육부', '교육부', '13000','03');
INSERT INTO books value ('c005', '물리의 정석', '교육부', '교육부', '11000','03');
INSERT INTO books value ('c006', '화학의 정석', '교육부', '교육부', '9000','03');
INSERT INTO books value ('c007', '사회의 정석', '교육부', '교육부', '8000','03');

    /*a는 교보재 c는 참고서 f는 외국어 b는 자격증 s는 소셜대중책 // 번호 제목 저자 출판사 가격 현재고*/





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

	total int NULL,
	bname VARCHAR(45) NULL,
	dates DATE NULL DEFAULT (current_date),		/*이상없음*/


    primary key(onum)
    );
    
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a014', 'mem1', '김하하', '01012341234', '1', '서울시 서대문구 홍은동 123-123 (단독주택)', '30000', 'C++', '2022-01-26');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a014', 'mem1', '김나나', '01023452345', '1', '서울시 강남구 테헤란로 304-23', '30000', 'C++', '2022-02-26');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a014', 'mem1', '박다다', '01034563456', '1', '부산시 해운대구 203-30', '30000', 'C++', '2022-03-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a015','mem2','하하하',	'01012352432','1','','20000','C#','2022-04-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('s001','mem2','나나나',	'01049492839','1','','30000','','2022-05-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('s001','mem3','거거거','01012345678','1','','30000','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('s003','mem4','김히하','01043214321','1','','14400','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('s001','mem3','수수수','01076547654','1','','30000','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c001','mem2','수수수','01065436543','1','','10000','','2022-02-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c002','mem1','수수수','01043214321','1','','9000','','2022-02-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c001','mem4','김김김','01023452345','1','','10000','','2022-02-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c001','mem6','김김김','01009870987','1','','10000','','2022-03-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c002','mem7','김김김','01098769876','1','','9000','','2022-03-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c003','mem8','김김김','01087658765','1','','12000','','2022-04-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('c002','mem9','박박박','01087658765','1','','9000','','2022-04-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a002','mem9','박박박','01076547648','1','','28000','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('a002','mem8','박박박','01065436543','1','','28000','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('b001','mem7','박박박','01054325432','1','','15000','','2022-01-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('b001','mem5','최최최','01054325432','1','','15000','','2022-02-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('b001','mem3','최최최','01054326323','1','','15000','','2022-02-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('f001','mem2','최최최','01012346543','1','','20000','','2022-05-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('f001','mem1','이이이','01054325432','1','','20000','','2022-05-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('f004','mem1','이이이','01012341234','1','','10000','','2022-05-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('f004','mem7','이이이','01054325432','1','','10000','','2022-05-21');
INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`, `total`, `bname`,`dates`) VALUES ('f001','mem8','이이이','01065346543','1','','20000','','2022-05-21');


						/* now() 는 오늘 날짜 */