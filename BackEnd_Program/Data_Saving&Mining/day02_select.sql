select * from tab;

select * from emp;

select * from dept;

select * from salgrade;

select empno, ename, sal, sal + 500 as plusSal , comm,
sal*12 + comm as annual, sal*12+NVL(comm,0) as annual2 from emp;

select empno, ename, mgr, nvl2(mgr,'관리자있음', '관리자없음') as yesorno from emp;

--문자열 결합 : ||
select ename|| ' is a ' || job as "employee info" from emp;

select ename|| ' : 1 YEAR SALARY = ' || sal*12 as annual from emp;

--distinct : 중복행 제거
select job from emp;

select distinct job from emp;

select deptno, job from emp order by deptno asc;

select distinct deptno, job from emp order by deptno;

--[문제]
--	 1] EMP테이블에서 중복되지 않는 부서번호를 출력하세요.
--	 2] MEMBER테이블에서 회원의 이름과 나이 직업을 보여주세요.
--	 3] CATEGORY 테이블에 저장된 모든 내용을 보여주세요.
--	 4] MEMBER테이블에서 회원의 이름과 적립된 마일리지를 보여주되,
--	      마일리지에 13을 곱한 결과를 "MILE_UP"이라는 별칭으로
--	      함께 보여주세요.
select distinct deptno from emp;
select name,age,job from member;
select * from category;
select * from member;
select name, mileage, mileage*13 as "MILE_UP" from member;

--EMP에서 급여가 3000이상인 사원의 사번,이름,업무, 급여를 출력하세요.
select * from emp;
select ename, empno,job,sal from emp
where sal >=3000;

--EMP테이블에서 담당업무가 MANAGER인 사원의
--정보를 사원번호,이름,업무,급여,부서번호로 출력하세요.
--
--EMP테이블에서 1982년 1월1일 이후에 입사한 사원의 
--사원번호,성명,업무,급여,입사일자를 출력하세요
select empno,ename,job,sal,deptno from emp
where job = 'MANAGER';

select empno,ename,job,sal,hiredate from emp
where hiredate >= '82/01/01';

--emp테이블에서 급여가 1300에서 1500사이의 사원의 이름,업무,급여,
--	부서번호를 출력하세요.
select empno,ename,job,sal,deptno from emp
where sal between 1300 and 1500;

--emp테이블에서 사원번호가 7902,7788,7566인 사원의 사원번호,
--	이름,업무,급여,입사일자를 출력하세요.
select empno,ename,job,sal,hiredate from emp
where empno in(7902,7788,7566);

--10번 부서가 아닌 사원의 이름,업무,부서번호를 출력하세요
select ename,job,deptno from emp
where deptno not in(10);

select * from emp where comm is null;

select * from emp where ename like '%S';
select * from emp where ename like '%S%';
select * from emp where ename like 'S%';

-- EMP테이블에서 입사일자가 82년도에 입사한 사원의 사번,이름,업무
--	   입사일자를 출력하세요.
-- 고객 테이블 가운데 성이 김씨인 사람의 정보를 보여주세요.
-- 고객 테이블 가운데 '강북'이 포함된 정보를 보여주세요.
-- 카테고리 테이블 가운데 category_code가 0000로 끝는 상품정보를 보여주세요.
select * from emp;
select empno,ename,job,hiredate from emp
where hiredate like '82%';

alter session set nls_date_format = 'yyyy-mm-dd';
alter session set nls_date_format = 'yy/mm/dd';
select hiredate from emp;

select * from member;
select * from member where name like '김%';
select * from member where addr like '%강북%';
select * from category;
select * from category where category_code like '%0000';

--EMP테이블에서 급여가 1100이상이고 JOB이 MANAGER인 사원의
--	사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp
where sal >= 1100 and job = 'MANAMGER';

--- EMP테이블에서 급여가 1100이상이거나 JOB이 MANAGER인 사원의
--	사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp
where sal >= 1100 or job = 'MANAMGER';
	
--	- EMP테이블에서 JOB이 MANAGER,CLERK,ANALYST가 아닌
--	  사원의 사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp
where job not in('MANAGER','CLERK','ANALYST');

--- EMP테이블에서 급여가 1000이상 1500이하가 아닌 사원의
--  EMP테이블에서 이름에 'S'자가 들어가지 않은 사람의 이름을 모두
--	  출력하세요.
--
--	- 사원테이블에서 업무가 PRESIDENT이고 급여가 1500이상이거나
--	   업무가 SALESMAN인 사원의 사번,이름,업무,급여를 출력하세요.
--
--	- 고객 테이블에서 이름이 홍길동이면서 직업이 학생이 정보를 
--	    모두 보여주세요.
--
--	- 고객 테이블에서 이름이 홍길동이거나 직업이 학생이 정보를 
--	모두 보여주세요.


select * from emp where sal between 1000 and 1500;

select * from emp where ename not like '%S%';

select empno,ename,job,sal from emp
where job = 'PRESIDENT' and sal >= 1500 or job = 'SALESMAN';

select * from member;
select * from member
where name = '홍길동' and job = '학생';

select * from member
where name = '홍길동' or job = '학생';

--사원테이블에서 입사일자 순으로 정렬하여 사번,이름,업무,급여,입사일자를 출력하세요.
select empno,ename,job,sal,hiredate
from emp order by hiredate;

select empno,ename,job,sal, sal*12 from emp order by sal*12 desc;

select empno,ename,job,sal, sal*12 y from emp order by y desc;
select empno,ename,job,sal, sal*12 from emp order by 2;

--사원 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우
--	급여가 많은 순으로 정렬하여 사번,이름,업무,부서번호,급여를
--	출력하세요.
select empno,ename,job,deptno,sal from emp
order by deptno, sal desc;

--	사원 테이블에서 첫번째 정렬은 부서번호로, 두번째 정렬은
--	업무로, 세번째 정렬은 급여가 많은 순으로 정렬하여
--	사번,이름,입사일자,부서번호,업무,급여를 출력하세요.
select empno,ename,hiredate,deptno,job,sal from emp
order by deptno, job, sal desc;

--1] 상품 테이블에서 판매 가격이 저렴한 순서대로 상품을 정렬해서 
--    보여주세요.
select * from products;
select * from products
order by output_price;
--2] 고객 테이블의 정보를 이름의 가나다 순으로 정렬해서 보여주세요.
--      단, 이름이 같을 경우에는 나이가 많은 순서대로 보여주세요.
select * from member order by name, age desc;
--3] 상품 테이블에서 배송비의 내림차순으로 정렬하되, 
--	    같은 배송비가 있는 경우에는
--		마일리지의 내림차순으로 정렬하여 보여주세요.
select * from products order by trans_cost desc, mileage desc;
--4]사원테이블이서 입사일이 1981 2월20일 ~ 1981 5월1일 사이에
--	    입사한 사원의 이름,업무 입사일을 출력하되, 입사일 순으로 출력하세요.
select * from emp;
select ename, job,  hiredate from emp
where hiredate between '1981-02-20' and '1981-05-01'
order by hiredate;
--5] 사원테이블에서 부서번호가 10,20인 사원의 이름,부서번호,업무를 출력하되
--	    이름 순으로 정렬하시오.
select ename, deptno, job from emp
where deptno in (10,20)
order by ename;

--6] 사원테이블에서 보너스가 급여보다 10%가 많은 사원의 이름,급여,보너스
--    를 출력하세요.
select ename, sal, comm from emp
where comm > sal* 1.1;
--7] 사원테이블에서 업무가 CLERK이거나 ANALYST이고
--     급여가 1000,3000,5000이 아닌 모든 사원의 정보를 
select * from emp
where job = 'CLERK' or job = 'ANALYST' and sal not in(1000,3000,5000);
--8] 사원테이블에서 이름에 L이 두자가 있고 부서가 30이거나
--    또는 관리자가 7782번인 사원의 정보를 출력하세요.
select * from emp
where ename like '%LL%' and deptno = 30 or mgr = 7782;








