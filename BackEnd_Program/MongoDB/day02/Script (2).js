show dbs

use mydb
db.emp.drop()
var empArr=[
        {
                "empno" : "7499",
                "ename" : "ALLEN",
                "job" : "SALESMAN",
                "mgr" : "7698",
                "hiredate" : "1981-02-20",
                "sal" : "1600.00",
                "comm" : "300.00",
                "deptno" : "30"
        },
        {
                "empno" : "7521",
                "ename" : "WARD",
                "job" : "SALESMAN",
                "mgr" : "7698",
                "hiredate" : "1981-02-22",
                "sal" : "1250.00",
                "comm" : "500.00",
                "deptno" : "30"
        },
        {
                "empno" : "7654",
                "ename" : "MARTIN",
                "job" : "SALESMAN",
                "mgr" : "7698",
                "hiredate" : "1981-09-28",
                "sal" : "1250.00",
                "comm" : "1400.00",
                "deptno" : "30"
        },
        {
                "empno" : "7844",
                "ename" : "TURNER",
                "job" : "SALESMAN",
                "mgr" : "7698",
                "hiredate" : "1981-09-08",
                "sal" : "1500.00",
                "comm" : "0.00",
                "deptno" : "30"
              },

{"empno":7369, "ename":"SMITH","job":"CLERK",mgr:7902,"hiredate" : "1980-12-17","sal":800.0, "comm" : "0.00","deptno":20},
{"empno":7566, "ename":"JONES","job":"MANAGER",mgr:7839,"hiredate" : "1981-04-02","sal":2975.0, "comm" : "0.00","deptno":20.0},
{"empno":7782,"ename":"CLARK","job":"MANAGER",mgr:7839,"hiredate" : "1981-09-08","sal":2450.0, "comm" : "0.00","deptno":10.0},
{"empno":7934,"ename":"MILLER","job":"CLERK",mgr:7782,"hiredate" : "1981-09-08","sal":1300.0, "comm" : "0.00","deptno":10.0},
{"empno":7788,"ename":"SCOTT","job":"ANALYST",mgr:7566,"hiredate" : "1982-12-09","sal":3000.0, "comm" : "0.00","deptno":10.0},
{"empno":7839,"ename":"KING","job":"PRESIDENT","hiredate" : "1981-11-17","sal":5000.0, "comm" : "0.00","deptno":10.0},
{"empno":7876,"ename":"ADAMS","job":"CLERK",mgr:7788,"hiredate" : "1983-01-12","sal":1100.0, "comm" : "0.00","deptno":20.0},
{"empno":7902,"ename":"FORD","job":"ANALYST",mgr:7566,"hiredate" : "1981-12-03","sal":3000.0, "comm" : "0.00","deptno":20.0},
{"empno":7934,"ename":"MILLER","job":"CLERK",mgr:7782,"hiredate" : "1982-01-23","sal":1300.0, "comm" : "0.00","deptno":10.0}
]
db.emp.insertMany(empArr)

var deptArr=[{
                "deptno" : "10",
                "dname" : "ACCOUNTING",
                "loc" : "NEW YORK"
        },
        {
                "deptno" : "20",
                "dname" : "RESEARCH",
                "loc" : "DALLAS"
        },
        {
                "deptno" : "30",
                "dname" : "SALES",
                "loc" : "CHICAGO"
        },
        {
                "deptno" : "40",
                "dname" : "OPERATIONS",
                "loc" : "BOSTON"
        }
  ]
db.dept.insertMany(deptArr)

db.emp.find()
db.dept.find()

db.emp.find({empno:7788},{ename:1,empno:1,job:1})
//emp 사원의 이름과 급여 가져오기
db.emp.find({},{ename:1, sal:1})
//emp job이 salesman or 급여 3000
db.emp.find({$or:[{job:'SALESMAN'},{sal:3000}]},{})
db.emp.find({$nor:[{job:'SALESMAN'},{sal:3000}]},{})

//$gt     >    
//$gte    >=   
//$in          목록 중의 어느 하나라도 있는지 여부를 체크
//$lt     <    
//$lte    <=   
//$ne     !=   not equal
//$nin         $in의 반대. not in
//member age >20
db.member.find({age:{$gt:20}},{name:1, age:1})

//emp에서 sal>=3000
db.emp.find({sal:{$gte:3000}},{empno:1, ename:1, job:1, sal:1})
//emp 1300<=sal<=2000
db.emp.find({$and:[{sal:{$gte:1300}},{sal:{$lte:2700}}]},{ename:1, job:1, sal:1, deptno:1})

//emp에서 담당 업무가 'MANAGER'인 사원의 사번,이름,업무를 보여주세요
db.emp.find({job:'MANAGER'},{empno:1, ename:1, job:1})
//emp에서 사원번호가 7369,7654,7934인 사원의 사원번호,
//	이름,업무,급여를 출력하세요.
db.emp.find({empno:{$in:[7369,7654,7934]}},{empno:1, ename:1, job:1, sal:1})
//20번 부서인 사원의 이름,업무,부서번호를 출력하세요
db.emp.find({deptno:20},{ename:1, job:1, deptno:1})

db.emp.find({deptno:{$ne:20}},{})
db.emp.find({$or:[{job:'CLERK'},{job:'ANALYST'}]}, {})
db.emp.find({$nor:[{job:'CLERK'},{job:'ANALYST'}]}, {})

db.emp.find({ename:{$regex:/KING/}})
db.emp.find({ename:/^S/}) //^ : 시작문자
db.emp.find({ename:/S$/}) //$ : 끝나는 문자
db.emp.find({ename:/S/}) // 슬래쉬 사이 : S갖고있는
db.member.find({userid:/o/})

//order by
db.member.find().sort({age:1})
db.member.find().sort({age:-1})

/*
<1>member에서 회원의 나이를 내림차순으로 정렬하고, 
  같은 나이일 때는 이름 가나다순으로 정렬해서 출력하세요*/
db.member.find().sort({age:-1, name:1})
/*<2> emp에서 부서번호로 정렬한 후 부서번호가 같을 경우
	급여가 많은 순으로 정렬하여 사번,이름,부서번호,급여를 출력하세요*/
db.emp.find({},{empno:1, ename:1,deptno:1, sal:1}).sort({deptno:1,sal:-1})
/*<3> emp에서 부서번호가 10,20인 사원의 이름,부서번호,업무를 출력하되
    이름 순으로 정렬하시오*/
db.emp.find({deptno:{$in:[10,20]}}, {ename:1, deptno:1, job:1}).sort({ename:1})

db.emp.find().count()

db.member.find({tel:{$exists:1}})
db.member.find({tel:{$exists:1}}).count()
db.member.find({tel:{$exists:0}})

db.member.find({age:{$gte:23}}).count()

db.emp.distinct("deptno")
db.emp.distinct("deptno").length

use mydb
db.products.find({size:{h:8.5, w:11, com:'in'}})
db.products.insertMany([
	{item:'journal', qty:25, size:{h:14, w:21, uom:'cm'}, status:'A'},
	{item:'notebook', qty:50, size:{h:8.5, w:11, uom:'in'}, status:'A'},
	{item:'paper', qty:100, size:{h:10, w:13, uom:'in'}, status:'D'},
	{item:'planner', qty:75, size:{h:22.85, w:30, uom:'cm'}, status:'C'},
	{item:'postcard', qty:45, size:{h:10, w:15.25, uom:'cm'}, status:'B'},
])

db.products.find({size:{h:{$gte:10}}}) // x
db.products.find({'size.h':{$gte:10}}) // o

//단위가 cm인 상품 출력
db.products.find({'size.uom':'cm'})

//size.h가 10미만이고 status가 A인 것들만 가져오기
db.products.find({'size.h':{$lt:10}, status:'A'})

//배열값 조회
db.inventory.insertMany([
	{ item: 'journal', qty: 25, tags: ["blank", "red"], dim_cm: [ 14, 21 ] },
	 { item: 'notebook', qty: 50, tags: ["red", "blank"], dim_cm: [ 14, 21 ] },
	 { item: 'paper', qty: 100, tags: ["red", "blank", "plain"], dim_cm: [ 14, 21 ] },
	 { item: 'planner', qty: 75, tags: ["blank", "red"], dim_cm: [ 22.85, 30 ] },
	 { item: 'postcard', qty: 45, tags: ["blue"], dim_cm: [ 10, 15.25 ] } 
	 ]);

/*
배열 선택자
$all: 주어진 조건의 모든 요소를 포함하는 배열
$elemMatch: 주어진 조건의 모든 요소와 일치하는 배열
$size: 주어진 크기 조건과 일치하는 배열
*/

//tags 필드에 red blank 값 배열 가지고 있는 상품 조회
db.inventory.find({tags:['red', 'blank']})

//배열값을 지니고 있는 모든 값을 가져오는 경우
db.inventory.find({tags:{$all:['red','blank']}})

db.inventory.find({tags:'red'})

//dim_cm 필드에 25이상의 값이 포함된 상품을 가져와 출력하세요
db.inventory.find({dim_cm:{$gte:25}})
db.inventory.find({'dim_cm.0':{$gte:20}}) //인덱스 번호가 0인 요소를 기준으로 조회

//tags 중 배열 크기가 2인 상품 조회
db.inventory.find({tags:{$size:2}})

//find() 로 조회한 결과는 cursor 형태의 객체로 return
var mycr = db.emp.find() // 변수에 할당되는 것이 cursor
while(micro.hasNext()) {
	printjson(mycr.next())
}

//부서번호 20인 부서의 사원정보를 커서 이용해서 출력하기
var cr = db.emp.find({deptno:20})

//forEach() function
cr.forEach(printjson)

//emp 급여가 높은 순으로 정렬해서 출력 3명만
db.emp.find({}).sort({sal:-1}).limit(3)


