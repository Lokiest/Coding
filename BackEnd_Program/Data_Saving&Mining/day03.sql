#count
select count(empno) from emp;
select count(comm) from emp;
--count는 null값 무시하고 카운트

select count(distinct mgr) from emp; 

select count(*) from emp;
-- *은 null 포함한 모든 행 카운트

create table test(a number, b number, c number);
insert into test values(null,null,null);
commit;
select * from test;
select count(a) from test;
select count(*) from test;

select count(deptno) from dept;

#avg, max, min, sum

--emp테이블에서 모든 SALESMAN에 대하여 급여의 평균,
--		 최고액,최저액,합계를 구하여 출력하세요.
select avg(sal), max(sal), min(sal), sum(sal), count(empno)
from emp where job = 'SALESMAN';
--EMP테이블에 등록되어 있는 인원수, 보너스에 NULL이 아닌 인원수,
--		보너스의 평균,등록되어 있는 부서의 수를 구하여 출력하세요.
select count(empno), count(comm),avg(comm),count(distinct deptno) from emp;

#그룹함수는 group by절과 함께 사용
#group by절을 이용할때는 group by절에서 사용한 컬럼과 그룹함수만 select 가능

select count(empno) from emp
group by job;

--17] 고객 테이블에서 직업의 종류, 각 직업에 속한 최대 마일리지 정보를 보여주세요.
select job, max(mileage) from member group by job;
--18] 상품 테이블에서 각 상품카테고리별로 총 몇 개의 상품이 있는지 보여주세요.
--    또한 최대 판매가와 최소 판매가를 함께 보여주세요.
select category_fk, count(pnum), max(output_price), min(output_price)
from products group by category_fk order by 1;
--19] 상품 테이블에서 각 공급업체 코드별로 공급한 상품의 평균입고가를 보여주세요.
select ep_code_fk, round(avg(input_price)) from products
group by ep_code_fk;

--문제1] 사원 테이블에서 입사한 년도별로 사원 수를 보여주세요.
select hiredate, count(empno) from emp group by hiredate;
select to_char(hiredate,'YY'), count(empno)
from emp group by to_char(hiredate,'YY') order by 1;
--문제2] 사원 테이블에서 해당년도 각 월별로 입사한 사원수를 보여주세요.
select to_char(hiredate,'YY-MM'), count(empno)
from emp group by to_char(hiredate,'YY-MM') order by 1;
--문제3] 사원 테이블에서 업무별 최대 연봉, 최소 연봉을 출력하세요.
select max(sal), min(sal) from emp
group by job;

#having 절 - group by의 결과에 조건을 주어 제한할 때 사용
--20] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수가 2명 이상인 직업군의 정보를 보여주시오.
select job, count(num) from member
group by job having count(num) >=2;

--21] 고객 테이블에서 직업의 종류와 각 직업에 속한 최대 마일리지 정보를 보여주세요.
--	      단, 직업군의 최대 마일리지가 0인 경우는 제외시킵시다.
select job, max(mileage) from member
group by job having max(mileage) <> 0;
--문제1] 상품 테이블에서 각 카테고리별로 상품을 묶은 경우, 해당 카테고리의 상품이 2개인 
--	      상품군의 정보를 보여주세요.
select category_fk, count(pnum)
from products group by category_fk having count(pnum)=2;
--문제2] 상품 테이블에서 각 공급업체 코드별로 상품 판매가의 평균값 중 단위가 100단위로 떨어
--	     지는 항목의 정보를 보여주세요.
select ep_code_fk, avg(output_price) from products
group by ep_code_fk having mod(avg(output_price), 100) =0
order by 2;

#join
select dept.deptno, dept.dname, emp.ename, job, sal
from dept, emp where dept.deptno = emp.deptno;

select d.deptno, dname, e.ename, job, sal
from dept d, emp e where d.deptno = e.deptno;

select d.*, e.*
from dept d, emp e where d.deptno = e.deptno order by d.deptno;

--SALESMAN의 사원번호,이름,급여,부서명,근무지를 출력하여라.
select empno, ename, sal, job, dname, loc
from emp e, dept d
where e.deptno = d.deptno and e.job = 'SALESMAN';

select empno, ename, sal, job, dname, loc
from emp e join dept d
on e.deptno = d.deptno
where e.job = 'SALESMAN';

--서로 연관이 있는 카테고리 테이블과 상품 테이블을 이용하여 각 상품별로 카테고리
--	      이름과 상품 이름을 함께 보여주세요.

--카테고리 테이블과 상품 테이블을 조인하여 화면에 출력하되 상품의 정보 중
--	      제조업체가 삼성인 상품의 정보만 추출하여 카테고리 이름과 상품이름, 상품가격
--	      제조사 등의 정보를 화면에 보여주세요.
select category_name, products_name, output_price,company
from category c join products p
on c.category_code = p.category_fk and p.company='삼성';
--각 상품별로 카테고리 및 상품명, 가격을 출력하세요. 단 카테고리가 'TV'인 것은 
--	      제외하고 나머지 정보는 상품의 가격이 저렴한 순으로 정렬하세요
select category_name, products_name, output_price
from category c join products p
on c.category_code = p.category_fk and c.category_name != 'TV'
order by 3;

# non-equijoin 조인조건이 = 이 아닌 다른 연산기호로 만들어지는 경우
select empno, ename, sal, grade, losal, hisal
from emp e join salgrade s
on e.sal between s.losal and s.hisal;

--97] 공급업체 테이블과 상품 테이블을 조인하여 공급업체 이름, 상품명,
--		공급가를 표시하되 상품의 공급가가 100000원 이상의 상품 정보
--		만 표시하세요. 단, 여기서는 공급업체A와 공급업체B가 모두 표시
--		되도록 해야 합니다.
select ep_name, products_name, input_price
from supply_comp s join products p
on s.ep_name='공급업체A' or s.ep_name='공급업체B' and p.input_price >=100000;

#cartisian
select d.*, e.*
from dept d, emp e;

#outer join = 조건에 만족하지 않는 데이터가 있더라도 null로 설정하여 출력
select d.deptno, dname, ename,job
from dept d, emp e
where d.deptno = e.deptno(+) order by 1;

#left, right, full outer join
select distinct(e.deptno), d.deptno
from dept d left outer join emp e
on d.deptno = e.deptno order by 2;

select distinct(e.deptno), d.deptno
from dept d right outer join emp e
on d.deptno = e.deptno order by 2;

select distinct(e.deptno), d.deptno
from dept d full outer join emp e
on d.deptno = e.deptno order by 2;

--문제98] 상품테이블의 모든 상품을 공급업체, 공급업체코드, 상품이름, 
--          상품공급가, 상품 판매가 순서로 출력하되 공급업체가 없는
--          상품도 출력하세요(상품을 기준으로).
select s.ep_code, ep_name, products_name, input_price, output_price
from supply_comp s right outer join products p
on s.ep_code = p.ep_code_fk;
--문제99] 상품테이블의 모든 상품을 공급업체, 카테고리명, 상품명, 상품판매가
--        순서로 출력하세요. 단, 공급업체나 상품 카테고리가 없는 상품도
--		출력합니다.
select sc.ep_code, ep_name, products_name, input_price, output_price
from supply_comp sc full outer join products p
on sc.ep_code = p.ep_code_fk;

select ep_name, category_name, products_name, output_price
from supply_comp s right outer join products p
on s.ep_code = p.ep_code_fk
left outer join category c
on p.category_fk = c.category_code;

#self join 자신의 테이블과 조인하는 경우
--각 사원의 정보를 출력하되 사원들의 관리자 이름도 함께 보여주세요
select e.empno, e.ename, m.ename "manager"
from emp e join emp m
on e.mgr = m.empno;

--[문제] emp테이블에서 "누구의 관리자는 누구이다"는 내용을 출력하세요.
select e.ename||'의 관리자는 '||m.ename||'이다'
from emp e join emp m
on e.mgr = m.empno;

#union
SELECT deptno from dept union
select deptno from emp;

#union all
SELECT deptno from dept union all
select deptno from emp;

#intersect
SELECT deptno from dept
intersect select deptno from emp;

#minus

--1. emp테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 
--   문장을 작성하세요.

--2. emp테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,
--    부서명을 출력하는 SELECT문을 작성하세요.
select ename, job, sal, dname, loc
from emp e join dept d
on e.deptno = d.deptno and d.loc = 'NEW YORK';
--3. EMP테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력하는
--    SELECT문을 작성하세요.
select ename, job, loc, comm
from emp e join dept d
on e.deptno = d.deptno and comm is not null;

5. 아래의 결과를 출력하는 문장을 작성하에요(관리자가 없는 King을 포함하여
	모든 사원을 출력)

	---------------------------------------------
	Emplyee		Emp#		Manager	Mgr#
	---------------------------------------------
	KING		7839
	BLAKE		7698		KING		7839
	CKARK		7782		KING		7839
	.....
	---------------------------------------------
select e.ename employee, e.empno "Emp#",
m.ename manager, m.empno "Mgr#"
from emp e left outer join emp m
on e.mgr = m.empno order by 3 desc;

