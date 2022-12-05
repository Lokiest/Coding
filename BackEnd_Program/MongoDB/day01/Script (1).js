db

// mydb 데이터베이스 생성하기
use mydb
db
show dbs
//mydb에 collection 생성하기
db.createCollection("employees", {capped:true, size:10000})
//capped:true >> 저장공간이 차면 기존 공간 재사용
db
show collections
show dbs

db.employees.find()
db.employees.isCapped()
db.employees.stats()

db.employees.renameCollection("emp")
show collections

//컬렉션 삭제 db.컬렉션명.drop()
db.emp.drop()
show collections

//capped option
db.createCollection("cappedCollection",{capped:true, size:10000})

show collections
db.cappedCollection.find()
db.cappedCollection.stats()

//도큐먼트(rows)를 size를 초과하도록 반복문 이용해서 넣기
for(i=0;i<1000;i++) {
    db.cappedCollection.insertOne({x:i})   
}
db.cappedCollection.find().count()
db.cappedCollection.isCapped()

//CRUD
use mydb
db.createCollection('member')
show collections

db.member.find()
db.getCollection('member')
db.member.insertOne({
    name : 'Messi',
    userid : 'Goat',
    tel : '010 1010 1010',
    age : 34
})

/*
id field가 자동으로 생성, document의 유일성 보장하는 키
    전체 : 12bytes 중
    4bytes : current timestamp >> 문서 생성 시점
    3bytes : machine id
    2bytes : 몽고디비 프로세스 id
    3bytes : 일련번호
*/

db.member.insertOne({ //수동으로 생성하는 방법 >> 비권장
    _id : 1,
    name : "Son",
    userid : "Picture",
    tel : "010-777-7777",
    age : 27
})
db.member.find()

//document를 bson으로 변환하여 몽고디비에 저장
//_id : 자동으로 인덱스 생성 >> 검색 효율이 높음
db.member.insertMany([
    {name : 'Malky', userid:'brazil', age : 33},
    {name : 'Hwang', userid:'Korea', age : 26},
    {name : 'Ronald', userid:'Portugal', age : 37}
])
db.member.insertOne({name:"Umbape", userid:"France", passwd:"12345"})

db.user.insertMany([
    {_id:1, name:'Kim', userid:'Korea', passwd:'123'},
    {_id:2, name:'Choi', userid:'USA', passwd:'12333'}
])
db.user.find()
db.user.insertMany([
    {_id:3, name:'Revan', userid:'Poland', passwd:'12344'},
    {_id:4, name:'DoWan', userid:'Germany', passwd:'12366'},
    {_id:4, name:'Queen', userid:'USA', passwd:'12366'}
], {ordered:false})
//ordered : default > true : 순서대로 insert할지 여부 지정
//        false >> 순서대로 입력 x >>> 에러 나와도 그 이후의 데이터를 삽입함

/*
[실습1]---------------------------------------------------------------------
1. boardDB생성
2. board 컬렉션 생성
3. board 컬렉션에 name 필드값으로 "자유게시판"을 넣어본다
4. article 컬렉션을 만들어 document들을 삽입하되,
   bid필드에 3에서 만든 board컬렉션 자유게시판의 _id값이 참조되도록 처리해보자.

5. 똑같은 방법으로 "공지사항게시판"을 만들고 그 안에 공지사항 글을 작성하자.
--------------------------------------------------------------------------
*/
use boardDB
db
freeboard_res=db.board.insertOne({name:'자유게시판'})
//변수에 자유게시판 document의 _id값이 삽입
freeboard_id=freeboard_res.insertedId

db.article.insertMany([
    {bid:freeboard_id, title:'first', content:'Hi', writer:'nogada'},
    {bid:freeboard_id, title:'second', content:'Hell', writer:'madsurfingMan'},
    {bid:freeboard_id, title:'third', content:'Sht', writer:'Bangi'}
])
db.article.find()

notice_res = db.board.insertOne({name : '공지사항게시판'})
notice_id = notice_res.insertedId
db.notice.insertMany([
    {bid:notice_id, title:'first notice', content:'HiHleo', writer:'Baran'},
    {bid:notice_id, title:'second notice', content:'HellHi', writer:'KDB'}
])
db.notice.find()
db.article.find()

/*
    read : find
*/
use mydb
db
db.member.find({})
arr=db.member.find().toArray() //모든 문서 배열로 반환 (효율적이진않음)
arr[0]
db.member.find()
//member에서 특정 column 조회
db.member.find({}, {name:true, tel:true})
db.member.find({}, {name:true, tel:true, _id:false})
db.member.find({}, {name:1, age:1, _id:0})

db.member.find({age:34},{})
db.member.find({age:34},{name:1, userid:1,age:1})
db.member.find({userid:'Picture', age:27}, {})
db.member.find({$or:[{age:34},{userid:'Picture'}]}, {})

//<1> userid가 'Choi'인 회원의 name,userid, tel 만 가져오기
///<2> age가 21세 이거나 userid가 'Lee'인 회원정보 가져오기
//<3> 이름이 이민수 이면서 나이가 23세인 회원정보 가져오기
db.member.find()
db.member.find({userid:'brazil'},{name:1,userid:1,tel:1})
db.member.find({$or:[{age:34},{userid:'Korea'}]}, {})
db.member.find({$and:[{age:34},{userid:'Goat'}]}, {})

//논리연산자
// $or, $and, $nor

/*
[실습2]
1. emp Collection 생성 {capped:true, size:100000} Capped Collection, size는 100000 으로 생성
2. scott계정의 emp레코드를 mydb의 emp Document 데이터로 넣기 
  => insertOne()으로 3개 문서 삽입, 
     insertMany로 나머지 문서 삽입해보기
*/
db
use mydb
db.emp.find()
db.createCollection("emp", {capped:true, size:10000})
db.emp.insertOne({
    empno:7499, ename:'allen', job:'salesman', mgr:'7698',hiredate:'81/02/20',sal:'1760', comm:'300', dept:10
})
db.emp.insertMany([
    {empno:7369, ename:'smith', job:'clerk', mgr:'7902',hiredate:'80/12/17',sal:'800', comm:null, dept:20},
    {empno:7521, ename:'ward', job:'salesman', mgr:'7698',hiredate:'81/02/22',sal:'1375', comm:'500', dept:10}
])

db.emp.insertMany([
    {empno:7566, ename:'jones', job:'manager', mgr:'7839',hiredate:'81/04/02',sal:'2975', comm:null, dept:20},
    {empno:7654, ename:'martin', job:'salesman', mgr:'7698',hiredate:'81/09/28',sal:'1250', comm:'1400', dept:30},
    {empno:7698, ename:'blake', job:'manager', mgr:'7839',hiredate:'81/09/28',sal:'1250', comm:null, dept:30},
    {empno:7782, ename:'clark', job:'manager', mgr:'7839',hiredate:'81/06/09',sal:'2695', comm:null, dept:10},
    {empno:7788, ename:'scott', job:'analyst', mgr:'7566',hiredate:'82/12/09',sal:'3300', comm:null, dept:20},
    {empno:7839, ename:'king', job:'president', mgr:null,hiredate:'81/11/17',sal:'5500', comm:'0', dept:10},
    {empno:7844, ename:'turner', job:'salesman', mgr:'7698',hiredate:'81/09/08',sal:'1500', comm:null, dept:30},
    {empno:7876, ename:'adams', job:'clerk', mgr:'7788',hiredate:'83/01/12',sal:'1100', comm:null, dept:20},
    {empno:7900, ename:'james', job:'clerk', mgr:'7698',hiredate:'81/12/03',sal:'950', comm:null, dept:30},
    {empno:7902, ename:'ford', job:'analyst', mgr:'7566',hiredate:'81/12/03',sal:'3000', comm:null, dept:20},
    {empno:7934, ename:'miller', job:'clerk', mgr:'7782',hiredate:'82/01/23',sal:'1430', comm:null, dept:10},
    {empno:8000, ename:'sns', job:'manager', mgr:null,hiredate:null,sal:'10000', comm:null, dept:30},
    {empno:8001, ename:'susan', job:'clerk', mgr:null,hiredate:null,sal:null, comm:null, dept:20},
    {empno:9010, ename:'tom', job:null, mgr:null,hiredate:null,sal:'3300', comm:null, dept:20}
])