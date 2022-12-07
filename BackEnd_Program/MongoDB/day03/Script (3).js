use mydb
show collections
db.inventory.find()
db.inventory.find({tags:'blank'})
db.inventory.find({tags:['blank', 'red']})
db.inventory.find({tags:{$all:['blank','red']}})
db.inventory.find({tags:{$size:1}})

//dim_cm 중 인덱스가 1번째인 값이 25보다 큰 상품들을 조회해서 출력
db.inventory.find({'dim_cm.1':{$gt:25}})

//Update
// updateOne() : 특정 필드값을 변경하거나 증가 감소시킬 때, updateMany(), replaceOne({조건절}{대체문서}{옵션})
db.user.find()
db.user.replaceOne({userid:'Korea'},{name:'Park', userid:'S--N',passwd:'12345'})
db.user.replaceOne({userid:'France'}, {name:'Bape', userid:'France',passwd:'1234'}, {upsert:true})
//upsert : 조건에 해당한느 문서가 있으면 수정, 없으면 삽입

db.user.updateOne({userid:'USA'},{$set:{passwd:'abcd'}})
db.user.replaceOne({userid:'USA'}, {passwd:'1234'}, {upsert:true}) //쓸거면 다 써야 (안쓰면 지워짐)
db.user.find()

db.user.updateOne({passwd:'1234'},{$set:{userid:'Italy', name:'PEPE'}})

/* 도큐먼트 수정 연산자
    $set : 필드값 수정값으로 설정
    $inc : 필드값 증가시키거나 감소시키기
    $mul : 필드값에 곱하기 수행
    $min : 필드값이 주어진 값보다 클 경우 새 값으로 교체
    $max : 필드값이 주어진 값보다 작을 경우 새 값으로 교체
    $currentDate : 필드값을 현재 날짜로 수정
    $unset : 해당 필드를 제거
    $rename : 필드명 변경
*/


db.member.find()
db.member.updateOne({userid:'Korea'},{$inc:{age:1}})
db.member.updateOne({userid:'Korea'},{$inc:{age:-1}})

db.member.updateMany({}, {$set:{grade:'A'}})

//member에서 나이가 34세 이상인 회원의 등급을 'B'등급으로 수정하세요
db.member.updateMany({age:{$gte:34}},{$set:{grade:'B'}})
db.member.find()

db.member.updateMany({grade:'A'}, {$mul:{age:2}})
db.member.updateMany({grade:'A'}, {$min:{age:30}})

db.member.updateOne({userid:'Picture'},{$max:{age:40}})
db.member.updateMany({}, {$currentDate:{indate:true}})
db.member.updateMany({}, {$currentDate:{indate2:{$type:'timestamp'}}})

db.member.find()
//member 컬렉션에서 indate2 제거
db.member.updateMany({},{$unset:{indate2:''}})

db.member.updateMany({}, {$rename:{tel:'phone'}})

// 배열 수정
/*
    db.collection.updateMany({선택조건},
		{<update연산자>:{"<array>.$[<identifier>]":value}},
		{arrayFilters:[{<identifier>:<condition>}]}
		);
*/

db.inventory.find()
db.inventory.find({item:'paper'})
db.inventory.updateMany({item:'paper'}, {$set:{"tags.$[tagE]":'blue'}}, {arrayFilters:[{tagE:'blank'}]})
db.inventory.updateMany({item:'postcard'},{$set:{"dim_cm.$[dimE]":12}},{arrayFilters:[{dimE:10.0}]})

// 배열 수정 연산자
// $addToSet : 배열에 해당요소 없으면 추가, 있으면 아무것도 안함
// $pop : 맨앞 또는 맨뒤에서 꺼내기, shift + pop
// $pull : 조건 만족하는 특정 요소 하나 제거, pullAll
// $push : 요소 추가

db.inventory.find()
db.inventory.updateMany({item:'journal'}, {$addToSet:{tags:'gold'}})
db.inventory.updateMany({item:'journal'}, {$pop:{tags:-1}})
db.inventory.updateMany({item:'journal'}, {$pop:{tags:1}})

db.inventory.updateMany({item:'paper'},{$pull:{tags:'blue'}})

db.inventory.updateMany({item:'paper'}, {$push:{tags:'skyblue'}})

db.inventory.updateMany({item:'paper'}, {$pullAll:{tags:['red','skyblue']}})

db.inventory.updateMany({item:'paper'}, {$push:{tags:['yellow','pink']}})
db.inventory.find({item:'paper'})

db.inventory.updateMany({item:'journal'}, {$push:{tags:{$each:['yellow', 'pink']}}})

// delete
db.member.find()
db.member.find({age:30}).count()
db.member.deleteMany({age:30})
db.member.deleteOne({grade:'A'})

db.inventory.find()
db.inventory.deleteMany({qty:{$lt:30}})

use boardDB
