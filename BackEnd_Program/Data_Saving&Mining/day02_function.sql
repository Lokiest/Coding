1. 단일행 함수
2. 그룹 함수
3. 기타 함수

#단일행 함수 
1.. 문자형 함수
2.. 숫자형 함수
3.. 날짜형 함수

# 문자형 함수
select lower('HAPPY BIRTHDAY'), upper('happy birthday') from dual;

--select * from dual;
--1행1열 갖는 더미 테이블

select 9*7 from dept;

#inintcap() : 첫 문자만 대문자로 변환
select deptno, dname, initcap(dname), initcap(loc) from dept;

#concat(1,2) : 2개 이상의 문자 결합
select concat('abc','1234') from dual;

--[문제] 사원 테이블에서 SCOTT의 사번,이름,담당업무(소문자로),부서번호를
--		출력하세요.
select empno, ename,lower(job),deptno from emp
where ename = 'SCOTT';
--	 상품 테이블에서 판매가를 화면에 보여줄 때 금액의 단위를 함께 
--	 붙여서 출력하세요.
select products_name, concat(output_price,'원') price from products;
--	 
--	 고객테이블에서 고객 이름과 나이를 하나의 컬럼으로 만들어 결과값을 화면에
--	       보여주세요.
select concat(name,age) from member;

#substr(변수,i,len) : 문자 i 인덱스로 시작한 len 문자 길이만큼의 변수를 변환함
# i 양수일 경우 앞에서부터 인덱스 찾고 음수일 경우 뒤에서부터 찾음

select substr('ABCDEFG',3,4) from dual;
select substr('991010-1111111', -7,7) from dual;
select length('991010-1111111') from dual;

--[문제]
--	사원 테이블에서 첫글자가 'K'보다 크고 'Y'보다 작은 사원의
--	  사번,이름,업무,급여를 출력하세요. 단 이름순으로 정렬하세요.
select empno,ename,job,sal from emp
where substr(ename,1,1) >= 'K' and substr(ename,1,1) <= 'Y';

--	사원테이블에서 부서가 20번인 사원의 사번,이름,이름자릿수,
--	급여,급여의 자릿수를 출력하세요.
select empno,ename,length(ename),sal,length(sal) from emp
where deptno = 20;
	
--	사원테이블의 사원이름 중 6자리 이상을 차지하는 사원의이름과 
--	이름자릿수를 보여주세요.
select ename, length(ename) from emp
where length(ename) >= 6;

#lpad, rpad
lpad(컬럼, 변수1, 변수2) : 문자값을 왼쪽부터 채움
rpad(컬럼, 변수1, 변수2) : 문자값을 오른쪽부터 채움
select ename, lpad(ename,15,'*'), sal,rpad(sal,10,'*') from emp
where deptno=10;

#trim
ltrim/rtrim(변수1, 변수2) : 변수1의 값 중 변수2와 같은 단어가 있으면 그 문자를 삭제한 나머지값 반환
select ltrim('TTTHELLO TEST', 'T') from dual;
select rtrim('TTTHELLO TEST', 'T') from dual;

#replace(컬럼, 변수1, 변수2) : 컬럼값 중 변수1에 해당하는 문자를 변수2로 대체
select replace('oracle test','test','racleO') from dual;

--사원테이블에서 담당업무 중 좌측에 'A'를 삭제하고
--급여중 좌측의 1을 삭제하여 출력하세요.
select ltrim(job, 'A'), ltrim(sal,1) from emp;
--사원테이블에서 10번 부서의 사원에 대해 담당업무 중 우측에'T'를
--	삭제하고 급여중 우측의 0을 삭제하여 출력하세요.
select rtrim(job,'T'), rtrim(sal,0) from emp;
--사원테이블 JOB에서 'A'를 '$'로 바꾸어 출력하세요.
select replace(job,'A','$') from emp;

--고객 테이블의 직업에 해당하는 컬럼에서 직업 정보가 학생인 정보를 모두
--	 대학생으로 변경해 출력되게 하세요.
select job, replace(job,'학생','대학생') from member;
update member set addr = replace(addr,'서울시','서울특별시');
rollback;

# 숫자형 함수
#round : 반올림 함수
select round(4456.56), round(4456.44), round(4456.5633,2), round(4456.4455,-2) from dual;

#trunc : 절삭
select trunc(4456.56), trunc(4456.56, 2), trunc(4456.56,-2) from dual;

#mod(값1,값2) : 나머지값 반환
select mod(4456.56,10) from dual;

--고객 테이블에서 회원이름, 마일리지,나이, 마일리지를 나이로 나눈값을 반올림하여 출력하세요
select name,mileage,age,mileage/age,round(mileage/age) from member;
--상품 테이블의 상품 정보가운데 백원 단위까지 버린 배송비를 비교하여 출력하세요.
select products_name, trans_cost, trunc(trans_cost,-3) from products;
--사원테이블에서 부서번호가 10인 사원의 급여를 	30으로 나눈 나머지를 출력하세요.
select deptno,ename,sal,mod(sal,30) from emp
where deptno=10;

#chr, ascii
select chr(65), ascii('A') from dual;

#abs
select abs(-30) from dual;

#ceil, floor
select ceil(45.45), floor(45.45) from dual;

#power, sqrt, sign
select power(2,7), sqrt(64),sqrt(111) from dual;
select age-40, sign(age-40) from member;

# 날짜형 함수
select sysdate, systimestamp from dual;
--사원테이블에서 현재까지의 근무 일수가 몇 주 몇일인가를 출력하세요.
--	단 근무일수가 많은 사람순으로 출려하세요.

#months_between : 두 날짜 사이의 월수를 계산
select months_between(sysdate, to_date('22-07-01','YY-MM-DD')) from emp;

#add_months : 날짜에 n개월 더하기 빼기
select add_months(sysdate, 3) from dual;

#last_day(d) : 월의 마지막 날짜 반환
select last_day('2022-02-01') from dual;

--고객 테이블이 두 달의 기간을 가진 유료 회원이라는 가정하에 등록일을 기준으로
--	   유료 회원인 고객의 정보를 보여주세요.
select name,reg_date,add_months(reg_date,2) "서비스 만기일" from member;

select to_char(sysdate,'CC YEAR-MONTH-DD DAY') from dual;

#변환 함수
to_char()
to_date()
to_number()

select to_char(sysdate), to_char(sysdate, 'YY-MM-DD HH12:MI:SS') from dual;

--고객테이블의 등록일자를 0000-00-00 의 형태로 출력하세요.
select name,to_char(reg_date, 'YY-MM-DD') from member;
--	 고객테이블에 있는 고객 정보 중 등록연도가 2003년인 
--	 고객의 정보를 보여주세요.
select * from member where to_char(reg_date,'YYYY') = '2013';
--	 고객테이블에 있는 고객 정보 중 등록일자가 2003년 5월1일보다 
--	 늦은 정보를 출력하세요. 
--	 단, 고객등록 정보는 년, 월만 보이도록 합니다.
select name, to_char(reg_date,'YYYY-MM') from member
where to_char(reg_date, 'YYYY-MM-DD') > '2013-05-01';

#to_char(n, 출력형식
select to_char(100000, '999,999'), to_char(100000,'$999G999') from dual;

--상품 테이블에서 상품의 공급 금액을 가격 표시 방법으로 표시하세요.
--천자리 마다 , 를 표시합니다.
select products_name,input_price,to_char(input_price,'999,999,999') "공급가" from products;
--상품 테이블에서 상품의 판매가를 출력하되 주화를 표시할 때 사용하는 방법을
--사용하여 출력하세요.[예: \10,000]
select products_name,output_price, to_char(output_price,'L999G999G999') from products;

#to_date(str, 출력형식)
select to_date('20221111','YYYY-MM-DD') from dual;

select * from member
where reg_date > to_date('20130601','YYYYMMDD');

select to_char(-23,'999S'), to_char(-23,'99D99') from dual;
select to_char(-23,'99.99'), to_char(-23,'99.99EEEE') from dual;








