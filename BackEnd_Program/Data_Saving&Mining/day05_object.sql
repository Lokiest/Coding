--CREATE SEQUENCE 시퀀스명
--[INCREMENT BY n] 증가치
--[START WITH n] 시작값
--[{MAXVALUE n | NOMAXVALE}] 최대값
--[{MINVALUE n | NOMINVALUE}] 최소값
--[{CYCLE | NOCYCLE}] 최대, 최소에 도달한 후 계속 값을 생성할지 여부를 지정,nocycle이 기본 
--[{CACHE n | NOCACHE}] 메모리 캐시 디폴트 사이즈 20

select max(deptno) from dept2;

create sequence dept2_seq
start with 50
increment by 5
maxvalue 95
cache 20
nocycle;

--데이터 사전에서 시퀀스 조회
select * from user_sequences;

--시퀀스 사용
-- nextval : 시퀀스 다음 값
-- currval : 시퀀스 현재 값
-- nextval이 호출되지 않은 상태에서 currval이 사용되면 에러 발생

select dept2_seq.currval from dual; >> error

select dept2_seq.nextval from dual;

select dept2_seq.currval from dual;

insert into dept2(deptno,dname,loc)
values (dept2_seq.nextval, 'SALES', 'SEOUL');
-- 95이상으로 넣을 경우 에러 발생 (max: 95)

select * from dept2;

create sequence temp_seq
start with 100
increment by -5
minvalue 0
maxvalue 100
nocache
cycle;

select * from user_sequences;

select temp_seq.nextval from dual;

drop sequence temp_seq;

--시퀀스 수정 : 시작값 수정 불가, 시작값 수정하려면 drop하고 다시 create
alter sequence 시퀀스명
increment by n
maxvalue n
minvalue n
cycle | nocycle
cache n | nocache;

alter sequence dept2_seq
increment by 1
maxvalue 1000;
--cycle | nocycle
--cache n | nocache;

insert into dept2 values(dept2_seq.nextval, 'TEST', 'TEST');
select * from dept2;

# view
--view 생성하려면 create view 권한을 가져야

create view emp20_view
as
select * from emp where deptno=20;
select * from emp20_view;
grant create view to scott;

--# view 삭제
--drop view
--
--#view 수정

create or replace view member_19
as select * from member where age>=19;
select * from member_19;

create or replace view emp30_view
as select empno enp_no, ename name, sal salary from emp
where deptno=30;
select * from emp30_view;

create or replace view emp30_view(eno,name,salary,dno)
as select empno, ename, sal, deptno from emp
where deptno=30;

update emp set deptno=20 where empno=7499;
select * from emp;

select * from emp30_view;

create or replace view emp_dept_view
as
select *
from dept d join emp e
using(deptno);

-- 본 테이블 수정하면 관련된 뷰도 수정
-- 뷰를 수정하면 본 테이블은 수정 x
select * from emp_dept_view;

select * from emp30_view;

update emp30_view set dno=10 where eno=7521;

select * from emp;

--# with read only option : 뷰에 DML 문장 수행 불가
create or replace view emp10_view
as select empno, ename, job, deptno from emp where deptno=10
with read only;

select * from emp10_view;

--update emp10_view set job = 'SALESMAN' where empno=7782; [x]
--"cannot perform a DML operation on a read-only view"

--#with check option
--where절 엄격학 ㅔ체크, where절에 위배되는 값이 삽입되거나 업데이트되는 것을 방지
create or replace view emp_sales_view
as select * from emp where job='SALESMAN'
with check option;

select * from emp_sales_view;

update emp_sales_view set deptno=10 where empno=7499;
-->> 수정가능

--update emp_sales_view set job='MANAGER' where ename='WARD'; [x]
--view WITH CHECK OPTION where-clause violation

--#inline view : from 절에서 사용된 서브쿼리

create view emp_old_view
as select * from emp order by hiredate;

select * from emp_old_view;

select rownum, empno, ename, hiredate from emp_old_view where rownum < 4;

select * from(
select rownum rn, A.* from
(select * from emp order by hiredate) A)
where rn > 1 and rn < 4;

#index
-- 자동생성되는 경우 : primary key or unique 제약조건을 주면 자동으로 생성
-- 명시적으로 생성하는 경우 : 사용자가 특정 컬럼을 지정해서 unique index or non-unique
--                         인덱스 생성 가능
-- 인덱스는 not null 인 컬럼에만 사용 가능

create index emp_ename_idx on emp(ename);

select * from emp where ename='SCOTT';

--인덱스 지정하면 내부적으로 해당 컬럼을 읽어서 오름차순 정렬
--rowid와 ename을 저장하기 위한 저장공간을 할당한 후 값 저장

select * from user_objects where object_type = 'INDEX';

select * from user_objects where object_type = 'VIEW';

select * from user_indexes;

select * from user_ind_columns
where index_name='EMP_ENAME_IDX';

select * from user_ind_columns
where table_name='emp';

create index products_category_fk_idx on products (category_fk);
create index products_ep_code_fk_idx on products (ep_code_fk);

select * from user_indexes where table_name='products';

select c.category_code, category_name, pnum, products_name, output_price,
ep_code_fk, ep_name
from category c right outer join products p
on c.category_code = p.category_fk
left outer join supply_comp s
on
p.ep_code_fk = s.ep_code;

--#drop index
drop index emp_ename_idx;

select * from user_indexes where table_name='emp';

--#synonym : 동의어
grant create synonym to SCOTT;

select * from user_objects
where object_type='SYNONYM';

drop synonym note;

select * from emp;

insert into emp
values(8000,'SNS','CLERK',null,null,1000,null,20);
commit;
update emp set job = '~~',deptno=30,sal=1000 where empno=20;
