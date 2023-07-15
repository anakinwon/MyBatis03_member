DROP TABLE mybatis_member ;
CREATE TABLE mybatis_member (
	id        varchar2(20) not null primary key,
	pwd       varchar2(20) not null,
	name      varchar2(50) not null,
	tel       varchar2(13) not null,
	email     varchar2(50) not NULL,
	join_date varchar2(14) NULL
);