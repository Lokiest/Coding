create table pizza_user(
	idx number(8) primary key,
	name varchar2(30),
	phone varchar2(15) not null,
	addr varchar2(100) not null
);
create sequence pizza_user_idx
start with 1
increment by 1
nocache;

insert into pizza_user(idx,name,phone,addr)
values(pizza_user_idx.nextval,'홍길동','111-1111',
'서울 구로구 구로동');

insert into pizza_user(idx,name,phone,addr)
values(pizza_user_idx.nextval,'김철수','222-2222',
'서울 마포구 서교동');
commit;
