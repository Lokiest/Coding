package com.memo.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
//영속성 계층 (Persistence Layer): @Repository
//컨크롤러: @Controller
@Repository
public class MemoDAOMyBatis implements MemoDAO {
	
	private final String NS="com.memo.model.MemoMapper";
	
	//리소스 이름으로 주입
	//id가 sqlSessionTemplate인 객체[datasource-context.xml]를 찾아서 주입한다
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;

	@Override
	public int insertMemo(MemoVO memo) {		
		return session.insert(NS+".insertMemo", memo);
	}

	@Override
	public List<MemoVO> listMemo() {
		return session.selectList(NS+".listMemo");
	}

	@Override
	public int deleteMemo(int idx) {	
		return session.delete(NS+".deleteMemo", idx);
	}

	@Override
	public int updateMemo(MemoVO memo) {
		return session.update(NS+".updateMemo", memo);
	}

	@Override
	public int getTotalCount() {
		return session.selectOne(NS+".getTotalCount");
	}

	@Override
	public MemoVO getMemo(int idx) {
		return session.selectOne(NS+".getMemo", idx);
	}

}
