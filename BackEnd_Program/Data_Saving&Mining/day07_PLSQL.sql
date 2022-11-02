--in out parameter : 프로시저가 읽고 쓰는 작업을 동시에 할 수 있는 파라미터
create or replace procedure inout_test(
    a1 in number,
    a2 in varchar2,
    a3 in out varchar2,
    a4 out varchar2
)
is
    msg varchar2(30) := '';
begin
    dbms_output.put_line('----------------------------------');
    dbms_output.put_line('BEFORE PROCEDURE START');
    dbms_output.put_line('----------------------------------');
    dbms_output.put_line('A1 : '||a1);
    dbms_output.put_line('A2 : '||a2);
    dbms_output.put_line('A3 : '||a3);
    dbms_output.put_line('A4 : '||a4);
    a3 := '프로시저 외부에서 값받기 가능/불가능';
    msg := 'SUCCESS';
    a4 := msg;
    dbms_output.put_line('----------------------------------');
    dbms_output.put_line('AFTER PROCEDURE START');
    dbms_output.put_line('----------------------------------');
    dbms_output.put_line('A1 : '||a1);
    dbms_output.put_line('A2 : '||a2);
    dbms_output.put_line('A3 : '||a3);
    dbms_output.put_line('A4 : '||a4);
    
end;
/

VARIABLE c varchar2(100);
VARIABLE d varchar2(100);

exec inout_test(1000,'ewr',:c,:d);

print d;
print c;

--#제어문
--if then
--elsif then
--...
--else
--end if;

--사번을 인파라미터로 전달하면 사원의 부서번호에 따라 소속된 부서명을 문자열로 출력하기
create or replace procedure dept_find(pno in emp.empno%type)
is
    vdno emp.deptno%type;
    vename emp.ename%type;
    vdname varchar2(20);
begin
    select ename, deptno into vename, vdno
    from emp where empno = pno;
    if vdno=10 then vdname:='회계';
    elsif vdno=20 then vdname:='연구';
    elsif vdno=30 then vdname:='영업';
    elsif vdno=40 then vdname:='운영';
    else vdname:='부서배정x';
    end if;
    
    dbms_output.put_line(vename||' 은 '||vdno||' 번 '||vdname||' 부서에 존재');
end;
/
exec dept_find(7369);

--사원명을 인파라미터로 전달하면
--해당 사원의 연봉을 계산해서 출력하는 프로시저를 작성하되,
--연봉은 COMM이 NULL인 경우와 NULL아 아닌경우를 나눠서 계산하세요
--출력문
--사원명  월급여  보너스 연봉 
--출력하세요
create or replace procedure emp_sal(
pname in emp.ename%type)
is
    vsal emp.sal%type;
    vcomm emp.comm%type;
    total number(10);
begin
    select sal, comm into vsal, vcomm
    from emp where ename=upper(pname);
    if vcomm is null then total := vsal * 12;
    else total:= vsal * 12 + vcomm;
    end if;
    dbms_output.put_line(pname||'==============');
    dbms_output.put_line('급여 : '||vsal);
    dbms_output.put_line('보너스 : '||vcomm);
    dbms_output.put_line('총 금액 : '||total);
exception
    when no_data_fount then
    dbms_output.put_line('no data');
    when too_many_rows then
    dbms_output.put_line('more than 2');
end;
/
exec emp_sal('SCOTT');
exec emp_sal('ALLEN');

-- for loop
--for i in 시작값..종료값 loop
--    실행문
--end loop;

declare
    vsum number(4) := 0;
begin
    for i in 1..10 loop
        dbms_output.put_line(i);
        vsum := vsum + i;
    end loop;
    dbms_output.put_line('까지의 합 : '||vsum);
end;
/

--JOB을 인파라미터로 전달하면 해당 업무를 수행하는 사원들의 정보
--사번, 사원명, 부서번호, 부서명, 업무를 출력하세요
--FOR LOOP를 이용해서 풀되 서브쿼리를 이용하세요
create or replace procedure emp_job(
pjob in emp.job%type)
is
begin
    for e in (select empno, ename, deptno, job,
                (select dname from dept where deptno = emp.deptno) dname
                from emp
                where job = pjob) loop
        dbms_output.put_line(e.empno||lpad(e.ename,10,' ')||lpad(e.deptno,8,' ')||lpad(e.job,12,' '));
    end loop;
end;
/

exec emp_job('MANAGER');

--1~100 중 짝수만 출력
--exit when 조건
--continue when 조건

declare
begin
    for k in 1..100 loop
        continue when mod(k,2)=1;
        dbms_output.put_line(k);
    end loop;
end;
/

--# loop문
--loop
--    실행문장;
--exit [when 조건]
--end loop;

--EMP테이블에 사원정보를 등록하되 LOOP문 이용해서 등록해봅시다.
--'NONAME1'
declare
    vcnt number(3) := 100;
begin
    loop
        insert into emp(empno, ename, hiredate)
        values(vcnt+ 8100, 'NONAME'||vcnt, sysdate);
    vcnt := vcnt + 1;
    exit when vcnt > 105;
    end loop;
    dbms_output.put_line(vcnt-100||' 건의 데이터 입력');
end;
/

select * from emp;
rollback;

--#while loop문
--while 조건 loop
--    실행문
--    exit then 조건
--end loop;

declare
    vcount number(3) := 0;
begin
    while vcount < 10 loop
        dbms_output.put_line(vcount);
        vcount := vcount + 2;
    end loop;
end;
/

declare
    vcount number(3) := 0;
begin
    while vcount < 10 loop
        vcount := vcount + 2;
        continue when vcount =4;
        dbms_output.put_line(vcount);
    end loop;
end;
/

--case문
--case 비교기준
--    when 값1 then ~;
--      ...
--      else
--      실행문
--end case

--평균점수를 인파라미터로 전달하면
--학점을 출력하는 프로시저를 작성하세요
--프로시저명: GRADE_AVG
--100~90 : A
--81 => B
--77 => C
--60점대 => D
--나머지 => F

create or replace procedure grade_avg(score in number)
is
    hak char(1) :='F';
begin
    case
    when score>=90 then hak:='A';
    when score>=80 then hak:='B';
    when score>=70 then hak:='C';
    when score>=60 then hak:='D';
    else hak:='F';
    end case;
    
    dbms_output.put_line(score ||' : '||hak);
end;
/

exec grade_avg(100);
exec grade_avg(75);
exec grade_avg(55);

CREATE OR REPLACE PROCEDURE GRADE_AVG (SCORE IN NUMBER)
IS
BEGIN
    CASE FLOOR(SCORE/10)
        WHEN 10 THEN DBMS_OUTPUT.PUT_LINE('A');
        WHEN 9 THEN DBMS_OUTPUT.PUT_LINE('A');
        WHEN 8 THEN DBMS_OUTPUT.PUT_LINE('B');
        WHEN 7 THEN DBMS_OUTPUT.PUT_LINE('C');
        WHEN 6 THEN DBMS_OUTPUT.PUT_LINE('D');
        ELSE 
        DBMS_OUTPUT.PUT_LINE('F');
    END CASE;
END;
/

--# 암시적 커서
create or replace procedure implicit_cursor(pno in emp.empno%type)
is
    vsal emp.sal%type;
    update_row number;
begin
    select sal into vsal
    from emp where empno = pno;
    --검색된 데이터가 존재한다면
    if sql%found then --암시적 커서의 속성을 이용
        DBMS_OUTPUT.PUT_LINE(pno||' 번 사원의 월급여는 '||vsal||' 입니다. 인상 예정');
    end if;
    update emp set sal=sal*1.1 where empno=pno;
    update_row:=sql%rowcount;
    DBMS_OUTPUT.PUT_LINE(update_row||'명의 사원 급여 인상');
    select sal into vsal
    from emp where empno = pno;
    --검색된 데이터가 존재한다면
    if sql%found then
        DBMS_OUTPUT.PUT_LINE(pno||' 번 사원의 월급여는 '||vsal||' 입니다.');
    end if;
end;
/

exec implicit_cursor(7788);

--# 명시적 커서
--커서 선언
--커서 오픈
--반복문 돌면서 커서에서 fetch
--커서 클로즈

create or replace procedure emp_all
is
    vno emp.empno%type;
    vname emp.ename%type;
    vdate emp.hiredate%type;
-- declare cursor
cursor emp_cr is
    select empno, ename, hiredate
    from emp order by 1;
begin
--cursor open
open emp_cr;
loop
    fetch emp_cr into vno, vname, vdate;
exit when emp_cr%notfound;
    DBMS_OUTPUT.PUT_LINE(vno||Lpad(vname,12,' ')||lpad(vdate,12,' '));
end loop;
close emp_cr;
end;
/

execute emp_all;

--[실습] 부서별 사원수, 평균급여, 최대급여, 최소급여를 가져와 출력하는
--      프로시저를 작성하세요.

select deptno, count(empno) cnt, avg(sal) avg_sal, max(sal) max_sal, min(sal) min_sal
from emp group by deptno order by 1;

create or replace procedure dept_stat
is
    vdno emp.deptno%type;
    vcount number;
    vavg number;
    vmax number;
    vmin number;
    cursor cr is
        select deptno, count(empno) cnt, avg(sal) avg_sal, max(sal) max_sal, min(sal) min_sal
        from emp group by deptno order by 1;
begin
    --for loop에서 커서 이용하면 별도로 open, fetch, close할 필요 없음 >> 자동으로 관리
    for k in cr loop
        dbms_output.put_line(k.deptno||lpad(k.cnt,10,' ')||lpad(k.avg_sal,10,' ')||
        lpad(k.max_sal,10,' ')||lpad(k.min_sal,10,' '));
    end loop;
end;
/

exec dept_stat;

--#subquery
--부서테이블의 모든 정보를 가져와 출력하는 프로시저를 작성하되 FOR LOOP이용하기
create or replace procedure detp_all
is
begin
    for k in (select * from dept order by deptno) loop
        dbms_output.put_line(k.deptno||lpad(k.dname,12,' ')||lpad(k.loc,12,' '));
    end loop;
end;
/

exec detp_all;

--미리 정의된 예외 ㅓ리
select * from member;
--MEMBER 테이블의 USERID 컬럼에 UNIQUE 제약조건을 추가하되 제약조건 이름 주어 추가하세요
alter table member add constraint memever_userid_uk unique(userid);

create sequence member_seq
start with 11
increment by 1
nocache;

--MEMBER테이블에 새로운 레코드를 추가하는 프로시저를 작성하되
--인파라미터로 회원명, 아이디, 비밀번호, 나이, 직업, 주소
--를 주고 해당 데이터를 INSERT하는 프로시저를 작성하세요
create or replace procedure member_add(
    pname in member.name%type,
    pid in member.userid%type,
    pwd in member.passwd%type,
    page in number,
    pjob in member.job%type,
    paddr in member.addr%type
)
is
    vname member.name%type;
    vuid member.userid%type;
begin
    insert into member(num,userid,name,passwd,age,job,addr,reg_date)
    values(member_seq.nextval,pid,pname,pwd,page,pjob,paddr, SYSDATE);
    if sql%rowcount > 0 then
        dbms_output.put_line('가입 완료');
    end if;
    select name, userid into vname, vuid
    from member where name=pname;
    dbms_output.put_line(pname||'  '||vuid);
    
    exception
    when dup_val_on_index then
    dbms_output.put_line('이미 등록');
    when too_many_rows then
    dbms_output.put_line(pname || '2개 이상');
    when others then
    dbms_output.put_line('예상치 못한 예외 발생 : '||sqlerrm||sqlcode);
end;
/

exec member_add('ewrewr','ee','123',22,'stu','seoul');

--#사용자 정의 예외 만들고 발생시키기
select count(*) from emp
group by deptno;

--부서 인원이 6명 미만이면 사용자정의 예외를 만들어 발생시키자
create or replace procedure user_except
(pdno in dept.deptno%type)
is
-- 예외 선언
    my_define_error exception;
    vcount number;
    
begin
    select count(empno) into vcount
    from emp where deptno=pdno;
    --예외발생시키기
    if vcount < 5 then
        raise my_define_error;
    end if;
    --예외처리
    exception
        when my_define_error then
            raise_application_error(-20001,'안돼요 안돼');
end;
/

exec user_except(40);

--#function
--실행환경에 반드시 하나의 값을 return해야 함
--사원명을 입력하면 해당 사원이 소속된 부서명을 반환하는 함수를 작성하세요
create or replace function get_ddname(
pname in emp.ename%type)
--반환해줄 데이터 유형 지정
return varchar2
is
    vdno emp.deptno%type;
    vdname dept.dname%type;
begin
    select deptno into vdno from emp
    where ename = pname;
    select dname into vdname from dept
    where deptno=vdno;
    return vdname;
    
    exception
    when no_data_found then
    dbms_output.put_line(pname || '없음');
    return sqlerrm;
    when too_many_rows then
    dbms_output.put_line(pname || '2개 이상');
    return sqlerrm;
end;
/

var gname varchar2;
exec :gname := get_ddname('STORM')
print gname

--#모든 메모 목록 가져오는 프로시저 작성해서 자바와 연동
create or replace procedure memo_all(
mycr out sys_refcursor)
is
begin
    open mycr for
    select idx, name, msg, wdate from memo
    order by idx desc;
end;
/

create or replace procedure emp_forjava(
    pdno in emp.deptno%type,
    mycr out sys_refcursor)
is
begin
    OPEN mycr for
    select ename,job,hiredate,dname,loc from
    (select * from emp where emp.deptno=pdno) A join dept D
    on A.deptno = D.deptno;
end;
/
