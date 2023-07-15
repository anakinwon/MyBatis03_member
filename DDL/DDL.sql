--//ormDemo 

DROP TABLE mybatis_bbs ;
CREATE TABLE mybatis_bbs (
	bId      number(4) not null primary key,
	bName    varchar2(20) ,
	bContent varchar2(300)
);

CREATE sequence seq_mybatis_bbs;



--//myBatisDemo 

DROP TABLE departments ;
CREATE TABLE departments (
	department_id   number(4) not null primary key,
	department_name varchar2(20) ,
	manager_id      varchar2(20) ,
	location_id     varchar2(300)
);

INSERT INTO departments values(100, '총무과', 'anakin', '12345');
INSERT INTO departments values(200, '인사과', 'padme' , '12346');
INSERT INTO departments values(300, '재무과', 'obiwan' , '12347');


--//myBatisDemo_02 

DROP TABLE mybatis_member ;
CREATE TABLE mybatis_member (
	id        varchar2(20) not null primary key,
	pwd       varchar2(20) not null,
	name      varchar2(50) not null,
	tel       varchar2(13) not null,
	email     varchar2(50) not NULL,
	join_date varchar2(14) NULL
);