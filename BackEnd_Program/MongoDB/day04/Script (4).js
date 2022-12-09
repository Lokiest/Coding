use boardDB
use mydb
/*
# 도큐먼트를 집계하는 방법은 3가지가 있다
[1] db의 모든 정보를 가져와 애플리케이션 단계에서 집계하는 방법
[2] 몽고디비의 맵리듀스 기능을 이용하는 방법
[3] 몽고디비의 집계 파이프라인 기능을 이용하는 방법
- 이 중에 파이프라인기능을 이용하는 방법이 처리 속도도 빠르고 램메모리 소요도 적게쓴다. 
   다만 자유도는 나쁜 편(주어진 연산자로만 가져오는데 때로 원하는 결과를 얻지 못할 수 있음)
- 집계 명령은 수많은 데이터를 처리해서 작은 양의 정보를 애플리케이션에 전달하는 특징이 있다.
  정보를 최대한 작게 만든후 앱으로 작아진 정보를 전송하는 것이 더 효율적임
- 많은양의 정보를 몽고디비 내부에서 처리한다면 많은 양의 램메모리가 필요하지 않게된다.
- 집계 파이프라인 명령어는 도큐먼트를 순차적으로 받아서 집계 처리를 몽고디비 내부에서 한다.
  맵리듀스 방식은 자바스크립트 엔진과 정보교환을 위해 램을 사용하는데 이때 대량의 메모리가 필요하게 된다.
  집계 파이프라인을 사용하는 것이 가장 합리적으로 보이지만,
  하지만 상황에 따라 맵리듀스로 처리해야 한다던지 애플리케이션에서 집계처리해야 할때도 있다.
*/

//#  집계 파이프라인 명령어
/*
$project : select절
$match: where절
$group: group by 절
$sort: order by 절
$limit
$unwind
*/

db.articles.insertMany([
    { "author" : "john", "score" : 80, "views" : 100 },
    { "author" : "john", "score" : 85, "views" : 521 },
    { "author" : "ahn", "score" : 60, "views" : 1000 },
    { "author" : "li", "score" : 55, "views" : 5000 },
    { "author" : "annT", "score" : 60, "views" : 50 },
    { "author" : "li", "score" : 94, "views" : 999 },
    { "author" : "ty", "score" : 95, "views" : 1000 }
])
db.articles.find()

db.articles.aggregate([{$project:{_id:0, author:1, score:1}}])

db.articles.aggregate([{$match:{score:{$gt:80}}}])
db.articles.aggregate([{$match:{author:'li', score:{$gte:60}}}])
db.articles.aggregate([{
    $group:{_id:'$author', total:{$sum:'$score'}}
}])
db.articles.find()

db.articles.aggregate([{$group:{_id:'$author', total:{$sum:'$score'}}},{$match:{total:{$gt:100}}}])
