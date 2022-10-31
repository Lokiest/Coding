create table emp_10
as
select * from emp where 1<>1;

select * from emp_10;

insert into emp_10(empno,job,ename,hiredate,mgr,sal,comm,deptno)
values(1000,'manager','jh',sysdate,null,2000,null,10);
commit;

--alter table emp_10 add constraint emp_10_ename_nn not null(ename); [x]

--컬럼 수정하면서 not null 추가
alter table emp_10 modify ename varchar2(20) not null;

insert into emp_10(empno,ename,job,mgr,sal)
values(1001,'hj','salesman',1000,3000);

--subquery
insert into emp_10
select * from emp where deptno=10;
--insert절의 컬럼 개수와 서브쿼리의 컬럼 개수가 좌측에서부터 1:1로 대응해야하며
--자료형과 크기가 같아야 함
select * from emp_10;

--update
--emp테이블 카피하여 emp2테이블 만들되, 데이터와 구조를 모두 복사
create table emp2
as
select * from emp;
select * from emp2;
--emp2에서 사번이 7788인 사원의 부서번호 10번 부서로 수정
update emp2 set deptno=10 where empno=7788;
--emp2 사번이 7369인 사원의 부서를 30번 부서로 수정
update emp2 set deptno=30 where empno=7369;

rollback;

create table member2
as select * from member;
select * from member2;
--2] 등록된 고객 정보 중 고객의 나이를 현재 나이에서 모두 5를 더한 값으로 
----	      수정하세요.
update member2 set age=age+5;
--	 2_1] 고객 중 13/09/01이후 등록한 고객들의 마일리지를 350점씩 올려주세요.
update member2 set mileage=mileage+350 where reg_date>'13/09/01';
--3] 등록되어 있는 고객 정보 중 이름에 '김'자가 들어있는 모든 이름을 '김' 대신
--	     '최'로 변경하세요.
update member2 set name=replace(name,'김','최') where name like '김%';
rollback;
commit;

--update할 때 무결성제약조건을 신경써야
create table dept2
as select * from dept;
select * from dept2;

--DEPT2테이블의 DEPTNO에 대해 PRIMARY KEY 제약조건을 추가하세요
alter table dept2 add constraint dept2_pk primary key (deptno);
--EMP2 테이블의 DEPTNO에 대해 FOREIGN KEY 제약조건을 추가하되 DEPT2의 DEPTNO를 외래키로 참조하도록 하세요
alter table emp2 add constraint emp2_fk foreign key (deptno)
REFERENCES dept2 (deptno);
update emp2 set deptno=10 where deptno=20;
select * from emp2;

update emp2 set deptno=50 where deptno=20;

#delete

-- EMP2테이블에서 사원번호가 7499인 사원의 정보를 삭제하라.
delete from emp2 where empno=7499;
select * from emp2;
rollback;
--- EMP2테이블의 자료 중 부서명이 'SALES'인 사원의 정보를 삭제하라.
delete from emp2 where deptno = (select deptno from dept2 where dname='SALES');
---- PRODUCTS2 를 만들어서 테스트하기
create table products2 as select * from products;
select * from products2;
--1] 상품 테이블에 있는 상품 중 상품의 판매 가격이 10000원 이하인 상품을 모두 
--	      삭제하세요.
delete from products2 where output_price <=10000;
rollback;
--	2] 상품 테이블에 있는 상품 중 상품의 대분류가 도서인 상품을 삭제하세요.
delete from products2 where category_fk = 
(select category_code from category where category_name like '%도서%'
and mod(category_code,100)= 0);

delete from products2;
rollback;

#TCL : commit, rollback, savepoint

update emp2 set ename='CHARSE' where empno=7788;
update emp2 set deptno=30 where empno=7788;
select * from emp2;

savepoint point1;
update emp2 set job='MANAGER';
rollback to savepoint point1;
commit;
