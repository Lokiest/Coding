--#패키지
--여러 개의 프로시저, 함수, 커서 등을 하나의 패캐지로 묶어서 관리하기
--- 선언부
--- 본문

--선언부
create or replace package empinfo as
procedure allemp;
procedure allsal;
end empinfo;

--본문
create or replace package body empinfo as
    procedure allemp
    is
    cursor empcr is
    select empno, ename, hiredate from emp order by 3;
    begin
    for k in empcr loop
        dbms_output.put_line(k.empno||lpad(k.ename,12,' ')||lpad(k.hiredate,12,' '));
    end loop;
    exception
        when others then
        dbms_output.put_line(sqlerrm||' ERROR');
    end allemp;
    
    procedure allsal
    is
    begin
        dbms_output.put_line('총합'||lpad('사원수',12,' ')||lpad('평균',12,' ')||lpad('최대',12,' ')||
            lpad('최소',12,' '));
        for k in (select sum(sal) sm, count(empno) cnt, round(avg(sal)) avg_sal,
        max(sal) mx, min(sal) mn from emp) loop 
            dbms_output.put_line(k.sm||lpad(k.cnt,12,' ')||lpad(k.avg_sal,12,' ')||lpad(k.mx,12,' ')||
            lpad(k.mn,12,' '));
        end loop;
    exception
        when others then
        dbms_output.put_line(sqlerrm||' ERROR');
    end allsal;
end empinfo;
/

set serveroutput on;

exec empinfo.allemp;
exec empinfo.allsal;

--#trigger
--insert, update, delete 문이 실행될 때 묵시적으로 수행되는 일종의 프로시저

create or replace trigger trg_dept
before
update on dept
for each row
begin
    dbms_output.put_line('변경 전 : '|| :old.dname);
    dbms_output.put_line('변경 후 : '|| :new.dname);
end;
/

select * from dept;
update dept set dname='ewrwer' where deptno=40;
rollback;

--트리거 비활성화
alter trigger trg_dept disable;
--트리거 활성화
alter trigger trg_dept enable;

drop trigger trg_dept;

--EMP 테이블에 데이터가 INSERT되거나 UPDATE될 경우 (BEFORE)
--전체 사원들의 평균급여를 출력하는 트리거를 작성하세요.
create or replace trigger trg_emp_avg
before insert or update on emp
--for each row
--when :new.empno > 0
declare
    avg_sal number(10);
begin
    select round(avg(sal),2) into avg_sal
    from emp;
    dbms_output.put_line('avg sal : '||avg_sal);
end;
/
rollback;

select avg(sal) from emp;

insert into emp(empno,ename,deptno,sal)
values(9000,'PETER',30,6000);

update emp set sal=sal*1.5 where empno=7788;


create table myproduct (
    pcode char(6) primary key,
    pname varchar2(20) not null,
    pcompany varchar2(20),
    price number(8),
    PQTY number default 0
);
desc myproduct;

create sequence myproduct_seq
start with 1
increment by 1
nocache;

select * from myproduct;

insert into myproduct values('A00'||myproduct_seq.nextval, '노트북', 'Apple',1500000,10);
insert into myproduct values('A00'||myproduct_seq.nextval, '노트북', 'Sam',1300000,10);
insert into myproduct values('A00'||myproduct_seq.nextval, '핸드폰', 'Apple',1550000,6);
insert into myproduct values('A00'||myproduct_seq.nextval, '노트북', 'Apple',1200000,20);
insert into myproduct values('A00'||myproduct_seq.nextval, '이어폰', 'Apple',300000,100);
commit;

--입고 table
create table myinput(
    incode number primary key,
    pcode_fk char(6) references myproduct (pcode),
    indate date default sysdate,
    inqty number(6),
    inprice number(8)
);

select * from myinput;

create sequence myinput_seq nocache;

--입고 테이블에 상품이 들어오면
--상품 테이블의 보유수량을 변경하는 트리거를 작성하세요
create or replace trigger trg_input_product
after
    insert on myinput
for each row
declare
    cnt number := :new.inqty;
    code char(6) := :new.pcode_fk;
begin
    update myproduct set pqty = pqty + cnt where pcode = code;
end;
/
rollback;
select * from myproduct;
insert into myinput values(myinput_seq.nextval, 'A002', sysdate, 8, 100000);

--입고 테이블의 수량이 변경될 경우-UPDATE문이 실행될 때
--상품 테이블의 수량을 수정하는 트리거를 작성하세요
create or replace trigger trg_input_product2
after update on myinput
for each row
declare
    gap number;
begin
    gap := :new.inqty - :old.inqty;
    update myproduct set pqty = pqty + gap where pcode = :new.pcode_fk;
    dbms_output.put_line('new : '||:new.inqty||' , old : '||:old.inqty||' , gap : '||gap);
end;
/

select * from myproduct;
select * from myinput;
update myinput set inqty=5 where incode=3;

select * from user_triggers;

--[트리거 실습2] - 문장 트리거
--EMP 테이블에 신입사원이 들어오면(INSERT) 로그 기록을 남기자
--어떤 DML문장을 실행했는지, DML이 수행된 시점의 시간, USER 데이터를
--EMP_LOG테이블에 기록하자.
create table emp_log(
    log_code number primary key,
    user_id varchar2(30),
    log_date date default sysdate,
    behavior varchar2(20)
);

create sequence emp_log_seq nocache;

create or replace trigger trg_emp_log
before insert on emp
begin
    if (to_char(sysdate,'DY') in ('FRI','SAT','SUN')) then
        raise_application_error(-20001,'금토일 사용 불가');
    else
        insert into emp_log values(emp_log_seq.nextval, user,sysdate,'INSERT');
    end if;
end;
/

insert into emp(empno,ename,sal,deptno)
values(9010,'TOM',3300,20);

select * from emp_log;
