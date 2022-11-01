--#프로시저 익명블럭
--- 선언부
--- 실행부
--- 예외처리부

-- declare
-- 선언부에서는 변수 선언 가능
-- I_msg varchar2(100);

-- begin
-- 실행부에는 SQL or PL/SQL문 올 수 있음
--I_msg := "Hello Oracle"(대입연산자)
-- = >> 비교연산자
-- end; 로 끝나야함
-- /

declare
    I_msg varchar2(100);

begin
    I_msg := 'Hello Oracle';
    dbms_output.put_line(I_msg);
end;
/

set serveroutput on

-- [2] 이름을 갖는 프로시저
create or REPLACE PROCEDURE print_time
is
--선언부
    vtime1 timestamp;
    vtime2 timestamp;
begin
    --실행부 날짜 + 숫자 : 일수를 더함, 날짜 + 숫자/24 : 시간을 더함
    select systimestamp - 1/24 into vtime1 from dual;
    select systimestamp - 2/24 into vtime2 from dual;
    dbms_output.put_line('한 시간 전 : '||vtime1);
    dbms_output.put_line('두 시간 전 : '||vtime2);
end;
/

--프로시저 실행방법
execute print_time;

--사번을 인파라미터로 전달하면 사번, 이름, 부서명, 담당업무 가져와 출력하는 프로시저 작성
create or replace procedure emp_info (pno in number)
is
    vno number(4); --스칼라타입
    vname emp.ename%type; --emp 테이블의 ename 컬럼과 같은 자료형으로 하겠다
    vdname dept.dname%type;
    vjob emp.job%type;
    vdno emp.deptno%type;
begin
    select ename,job,deptno into vname, vjob, vdno
    from emp where empno=pno;
    select dname into vdname
    from dept where deptno=vdno;
    dbms_output.put_line(pno||' 번 사원 정보');
    dbms_output.put_line('사원명 : '||vname);
    dbms_output.put_line('담당업무 : '||vjob);
    dbms_output.put_line('부서명 : '||vdname);
    
exception
    when no_data_found then
    dbms_output.put_line(pno||' 는 존재하지않음');
end;
/

execute emp_info(8449);

--부서번호를 인파라미터로 주면 해당 부서의 부서명과 근무지를 출력하는 프로시저를 작성합시다
--%type : reference 타입
--%rowtype : composite타입, 테이블의 행과 같은 타입

create or replace procedure rtype (pdno in dept.deptno%type)
is
    vdept dept%rowtype;
    
begin
    select dname, loc into vdept.dname, vdept.loc
    from dept where deptno=pdno;
    dbms_output.put_line('부서번호 : '||pdno);
    dbms_output.put_line('부 서 명 : '||vdept.dname);
    dbms_output.put_line('부서위치 : '||vdept.loc);

exception
    when no_data_found then
    dbms_output.put_line(pdno||' 는 존재하지않음');
end;
/
execute rtype(30);

-- #table type : composite type 복합데이터 타입 >> 배열과 비슷
-- 테이블 타입에 접근하기 위한 인덱스가 존재 >> binary_integer 데이터 형의 인덱스 이용 가능

create or replace PROCEDURE table_type(pdno in emp.deptno%type)
is
-- 테이블 선언
    type ename_table is table of emp.ename%type
    index by binary_integer;
-- 테이블 타입의 변수 선언
    ename_tab ename_table;
    i binary_integer := 0;
begin
    for k in (select ename from emp where deptno=pdno) loop
    i := i+1;
    -- 테이블 변수에 가져온 값들 저장
        ename_tab(i) := k.ename;
    end loop;
    
    -- 테이블 타입에 저장된 값 출력
    for j in 1..i loop
        dbms_output.put_line(ename_tab(j));
    end loop;
end;
/
execute table_type(20);

--사원들의 업무 정보를 담을 테이블 타입의 변수 선언하고 사원들의 업무 정보를 저장하기

create or replace PROCEDURE table_type(pdno in emp.deptno%type)
is
-- 테이블 선언
    type ename_table is table of emp.ename%type
    index by binary_integer;
    
    type job_table is table of emp.job%type
    index by binary_integer;
    
-- 테이블 타입의 변수 선언
    ename_tab ename_table;
    i binary_integer := 0;
    
    job_tab job_table;
    
begin
    for k in (select ename, job from emp where deptno=pdno) loop
    i := i+1;
    -- 테이블 변수에 가져온 값들 저장
        ename_tab(i) := k.ename;
        job_tab(i) := k.job;
    end loop;
    
    -- 테이블 타입에 저장된 값 출력
    for j in 1..i loop
        dbms_output.put_line(ename_tab(j) || ' : ' || job_tab(j));
    end loop;
end;
/
execute table_type(20);

-- # record type
-- 상품번호를 입력하면 해당 상품의 상품명, 판매가, 제조사 출력하는 프로시저 작성

accept pnum prompt '조회할 상품번호 입력'
--pnum을 사용할 때는 &pnum

declare
    type prod_record_type is record(
        vpname products.products_name%type,
        vprice products.output_price%type,
        vcomp products.company%type
    );
    
    --레코드 타입 변수 선언
    prod_rec prod_record_type;
    vpnum number :='&pnum';
begin
    select products_name, output_price, company into prod_rec from products
    where pnum = vpnum;
    
    dbms_output.put_line(&pnum||'번 상품 정보');
    dbms_output.put_line('상품명 : '||prod_rec.vpname);
    dbms_output.put_line('제조사 : '||prod_rec.vprice);
    dbms_output.put_line('가 격 : '||prod_rec.vcomp);
end;
/


-- 바인드 변수 - NON-PL/SQL 변수
-- 프로시저 내부에서 바인드 변수를 참조하려면 바인드 변수 앞에 콜론을 참조 접두어로 기술
declare
begin
    :myvar := 700;
end;
/

print myvar

--# 프로시저 파라미터 종류
--[1] in parameter
--[2] out parameter
--[3] int out parameter

create or replace procedure memo_add(pname in varchar2 default 'ewr',
pmsg in memo.msg%type)
is
begin
    insert into memo(idx, name, msg, wdate)
    values(memo_seq.nextval, pname, pmsg, sysdate);
    commit;
end;
/

exec memo_add('qwe','zcxzxc');

select * from memo order by idx desc;
exec memo_add(pmsg=>'hi');

-- out parameter : 프로시저가 사용자에게 넘겨주는 값
-- [주의] : 디폴트값 설정 불가

--사번을 인 파라미터로 전달하면 해당 사원의 이름을 아웃 파라미터로 내보내는 프로시저를 작성하세요
create or replace procedure emp_find(pno in emp.empno%type, oname out emp.ename%type)
is
begin
    select ename into oname from emp
    where empno = pno;
end;
/
-- 실행방법
-- 바인드 변수 선언, 프로시저 실행할 때 바인드 변수를 아웃파라미터의 매개변수로 전달
-- 바인드 변수 값을 출력

var gname varchar2(20);
exec emp_find(7788, :gname);
print gname;

--부서번호를 인파라미터로 받고, 급연 인상률도 인파라미터로 받아서
--EMP테이블의 특정 부서 직원들의 급여를 인상해주고
--그런뒤 해당 부서의 평균급여를 아웃파라미터로 전달하는 프로시저를
--작성한 뒤
--해당 부서의 평균급여를 출력하세요
create or replace procedure sal_up
(dno in dept.deptno%type, upsal in number, avgsal out number)
is
begin
    update emp set sal = sal * upsal where deptno = dno;
    
    select avg(sal) into avgsal
    from emp
    group by deptno
    having deptno = dno;
end;
/

var avgsal number;
exec sal_up(10,1.1,:avgsal);

print avgsal;

--MEMO_EDIT 프로시저를 작성하세요
--인파라미터 3개 받아서(글번호, 작성자, 메시지)
--UPDATE문을 수행하는 프로시저
create or replace procedure memo_edit(
pidx in memo.idx%type,
pname in memo.name%type,
pmsg in memo.msg%type
)
is
begin
    update memo set name=pname, msg=pmsg where idx=pidx;
end;
/

select * from memo order by idx desc;

update memo set name = 'ewrewr' where idx = 15;

delete from memo where idx = 24;

commit;
