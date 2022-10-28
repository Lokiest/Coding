create table [스키마.] 테이블명 (
    컬럼명 자료형 default 기본값 constraint 제야조건이름 제약조건 유형,
    ...
);

create table Test_Tab1 (
    no number(2) constraint Test_Tab1_NO_PK primary key,
    name varchar(20)
);

select * from Test_Tab1;

# 데이터사전에서 조회
select *
from user_constraints where table_name = 'Test_Tab2';

insert into Test_Tab1
values (2,null);

commit;

-- # 테이블 수준에서 pk제약
create table Test_Tab2 (
    no number(2),
    name varchar(20),
    constraint Test_Tab2_no_pk primary key(no)
);

select * from Test_Tab2;

# 제약조건 삭제

--alter table 테이블명 drop constraint 제약조건명

alter table Test_Tab2 drop constraint Test_Tab2_no_pk;

# 제약조건 추가
--alter table 테이블명 add contraint 제약조건명 제약조건유형 (컬럼명)
alter table Test_Tab2 add constraint Test_Tab2_pk primary key(no);

# 제약조건명 변경
--alter table 테이블명 rename constraint 예전명 to 새로운명;
alter table Test_Tab2 rename constraint Test_Tab2_pk to Test_Tab2_no_pk;

#fk 제약조건
부모테이블의 pk를 자식테이블에서 fk로 참조
컬럼 자료형이 일치해야하고 크기는 일치하지 않아도 상관은 없음
on delete cascade 옵션을 주면 마스터 테이블의 레코드가 삭제될 때 detail 테이블 레코드도 같이 삭제

create table dept_tab(
    deptno number(2),
    dname varchar(15),
    loc varchar(15),
    constraint dept_tab_deptno_pk primary key(deptno)
);
select * from dept_tab;

create table emp_tab(
    empno number(4),
    ename varchar(20),
    job varchar(10),
    mgr number(4) constraint emp_tab_mgr_fk references emp_tab(empno),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2),
    constraint emp_tab_no_fk foreign key (deptno)
    references dept_tab (deptno),
    constraint emp_tab_empno_pk primary key (empno)
);
select * from emp_tab;

insert into dept_tab
values(10, '기획부', '서울');
insert into dept_tab
values(20, '인사부', '인천');
commit;

insert into emp_tab(empno,ename,job,mgr,deptno)
values (1000,'박','기획',null,10);
insert into emp_tab(empno,ename,job,mgr,deptno)
values (1001,'김','인사',null,20);
insert into emp_tab(empno,ename,job,mgr,deptno)
values (1002,'이','인사',null,20);
insert into emp_tab(empno,ename,job,mgr,deptno)
values (1003,'나','회계',1002,20);
insert into emp_tab(empno,ename,job,mgr,deptno)
values (1004,'최','재무',1001,20);

update emp_tab set deptno=20 where ename = '박';
delete from dept_tab where deptno=10;

create table board_tab(
    no number(8) primary key,
    userid varchar2(20) not null,
    title varchar(100),
    content varchar(1000),
    wdate date default sysdate
);
select * from board_tab;
create table reply_tab(
    rno number(8) primary key,
    content varchar2(300),
    userid varchar2(20) not null,
    no_fk number(8) references board_tab(no) on delete cascade
);

select * from user_constraints where table_name = 'reply_tab';

insert into board_tab values(1,'111','ewr','ewr',sysdate);
insert into board_tab values(2,'222','qwe','qwe',sysdate);
commit;

insert into reply_tab values(1,'댓글1','Lee',2);
insert into reply_tab values(2,'댓글2','Lee',2);
insert into reply_tab values(3,'댓글3','park',1);

select b.no, b.title, b.userid, b.wdate, r.content, r.userid
from board_tab b join reply_tab r
on b.no = r.no_fk;

delete from board_tab where no=2;

# unique key
create table uni_tab1 (
    deptno number(2) constraint uni_tab1_deptno_uk unique,
    dname char(20),
    loc char(10)
);
select * from uni_tab1;

insert into uni_tab1 values(10,'111','111');
insert into uni_tab1 values(20,'111','111');
insert into uni_tab1 values(null,'111','111');
commit;

create table uni_tab2 (
    deptno number(2),
    dname char(20),
    loc char(10),
    constraint uni_tab2_deptno_uk unique (deptno)
);

#not null 제약조건 : 컬럼수준에서만 제약 가능

#check 제약조건 : 행이 만족해야하는 조건을 정의

create table ck_tab2(
    deptno number(2),
    dname char(20),
    loc char(10),
    primary key(deptno),
    check (loc in ('서울','수원'))
);
commit;

create table zipcode (
    post1 char(3),
    post2 char(3),
    addr varchar(60) constraint zipcode_addr_nn not null,
    constraint zipcode_post_pk primary key (post1, post2)
);
select * from zipcode;
desc zipcode;

create table member_tab (
    id number(4),
    name varchar2(10) constraint member_tab_name_nn not null,
    gender char(1),
    jumin1 char(6),
    jumin2 char(7),
    tel varchar2(15),
    post1 char(3),
    post2 char(3),
    addr varchar2(60),
    constraint member_tab_id_pk primary key (id),
    constraint member_tab_gender_ck check (gender in ('F','M')),
    constraint member_tab_jumin_uk unique (jumin1, jumin2),
    constraint member_tab_post_fk foreign key (post1, post2)
    references zipcode(post1,post2)
);
select * from member_tab;

#subquery 이용한 테이블 생성
--사원 테이블에서 30번 부서에 근무하는 사원의 정보만 추출하여 EMP_30 테이블을 생성하여라. 
--단 열은 사번,이름,업무,입사일자,급여,보너스를 포함한다.

create table emp_30(eno, ename, job, hdate, sal, comm)
as
select empno, ename, job, hiredate, sal, comm
from emp where deptno=30;
select * from emp_30;

--[문제1]
--    EMP테이블에서 부서별로 인원수,평균 급여, 급여의 합, 최소 급여,
--    최대 급여를 포함하는 EMP_DEPTNO 테이블을 생성하라.
create table emp_deptno
as
select deptno, count(empno) cnt, round(avg(sal)) avg, sum(sal) sum, min(sal) min, max(sal) max
from emp group by deptno;
select * from emp_deptno;
drop table emp_deptno;

--[문제2]	EMP테이블에서 사번,이름,업무,입사일자,부서번호만 포함하는
--    EMP_TEMP 테이블을 생성하는데 자료는 포함하지 않고 구조만
--    생성하여라
create table emp_temp
as
select empno, ename, job, hiredate, deptno
from emp where 1=2;
select * from emp_temp;

#DDL
create table temp(
    no number(4)
);
desc temp;

alter table temp add name varchar2(20) not null;
alter table temp add indate date default sysdate;

alter table products add prod_desc varchar2(100);
select * from products;
rollback;

alter table temp modify no char(4);
desc temp;

alter table temp rename column no to num;

alter table temp drop column indate;

alter table temp add constraint temp_num_pk primary key(num);

insert into temp values(1,'AAA');

#제약조건 비활성화
alter table temp disable constraint temp_num_pk;
select * from temp;

#제약조건 활성화
alter table temp enable constraint temp_num_pk;

#객체 이름 변경
rename temp to test2;

select * from tab;

#테이블 삭제
drop table test2 cascade constraint;

--drop table a purge; 테이블 모든 구조와 데이터 삭제

select * from memo;

select idx, name, msg, wdate from memo order by idx desc;
