-- 단문 주석
/* 복문
    여러줄
    주석
*/
-- 학사관리 프로그램

--create table 테이블명 (
--컬럼명1 자료형(크기) 제약조건,
--컬럼명 2...
--);

create table student(
    no NUMBER(4) PRIMARY KEY,
    name varchar(10) not null,
    tel VARCHAR2(20) NOT NULL,
    adr VARCHAR2(100),
    indate DATE DEFAULT SYSDATE,
    sclass VARCHAR2(50),
    sroom NUMBER(3)
);
desc student;
select * from student;

--insert into 테이블명 (컬렴명1, ...
--values (값1, 값2 ...
--commit


insert into student(no, name, tel, adr, sclass, sroom)
values (1, 'ew', '010-222-2222', '서울', 'java', 101);

select * from student;

insert into student(no, name, tel, adr)
values (2, 'qw', '010-111-1111', '경기');
commit;

insert into student
values (3, 'er', '010-333-3333', '인천', sysdate, 'bigdata', 201);
rollback;

commit;
--자바반 2명 추가, 빅데이터반 2명 추가
insert into student(no, name, tel, adr, sclass, sroom)
values (4, 'rt', '010-444-4444', '울산', 'java', 101);
insert into student(no, name, tel, adr, sclass, sroom)
values (5, 'ty', '010-555-5555', '대구', 'java', 101);
insert into student
values (6, 'as', '010-666-6666', '대전', sysdate, 'bigdata', 201);
insert into student
values (7, 'sd', '010-777-7777', '부산', sysdate, 'bigdata', 201);

select * from student
where sclass = 'java';

select * from student order by no asc;

--테이블 삭제
drop table sclass;

create TABLE sclass (
    sno NUMBER(4) primary key,
    sname varchar2(30) not null,
    sroom NUMBER(3)
);
select * from sclass;

commit;

rollback;

insert into sclass
values (10, '백엔드', 101);

insert into sclass
values (20, '빅데이터', 201);

insert into sclass
values (30, '복합', 301);

--update 테이블명 set 컬럼명 = 값
--where
update sclass set sname = 'backend'
where sname = '백엔드';

create table student(
    no number(4) primary key,
    name varchar2(30) not null,
    tel varchar2(15) not null,
    adr varchar2(100),
    indate date DEFAULT sysdate,
    sno_fk NUMBER(4) REFERENCES sclass (sno) --외래키 설정
);

select * from student;

--일련번호 생성해주는 객체 : sequence
create sequence student_seq
start with 1
increment by 1
nocache;

insert into student(no,name,tel,adr,sno_fk)
values(student_seq.nextval, 'ewr', '111', '서울', 10);

insert into student
values(student_seq.nextval, 'wer', '222', '경기', sysdate, 20);

insert into student(no,name,tel,adr,sno_fk)
values(student_seq.nextval, 'ret', '333', '서울', 10);

insert into student(no,name,tel,adr,sno_fk)
values(student_seq.nextval, 'fdg', '444', '서울', 10);

insert into student
values(student_seq.nextval, 'zxc', '555', '울산', sysdate, 20);
insert into student
values(student_seq.nextval, 'cxz', '666', '대전', sysdate, 20);

insert into student
values(student_seq.nextval, 'try', '777', '대구', sysdate, 30);

select * from student order by sno_fk;

delete from student
where no = 3;

select * from student;
select * from sclass;

commit;

--테이블 2개 하나로 합쳐서 보여주기 - join
select student.no, name, tel, indate, sname, sroom
from sclass join student on sclass.sno = student.sno_fk order by sname;

update sclass set sroom = 401 where sno = 20;

--학급별 인원 수 알아내기
select count(*) from student;
select sno_fk, count(*) from student 
group by sno_fk order by sno_fk;

select * from emp;

select empno, ename, sal + 500 as sal_up from emp;
-- as >> 별칭

select empno, ename, sal, comm, job from emp;

select empno, ename, sal, comm, job, sal*12 + nvl(comm,0) as "연봉" from emp;
--nvl(컬럼명, 값) : 컬럼 값이 null인 경우 값으로 치환하여 반환








