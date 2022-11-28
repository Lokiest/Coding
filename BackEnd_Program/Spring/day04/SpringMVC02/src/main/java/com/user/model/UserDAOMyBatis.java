package com.user.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
//Persistence Layer
@Repository
public class UserDAOMyBatis implements UserDAO {
	
	private final String NS="user.model.UserMapper";
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;

	@Override
	public int createUser(UserVO user) {
		return session.insert(NS+".insertUser", user);
	}

	@Override
	public int getUserCount(PagingVO pvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> listUser(PagingVO pvo) {		
		return session.selectList(NS+".listUser", pvo);
	}

	@Override
	public UserVO getUser(Integer midx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer idCheck(String userid) {		
		return session.selectOne(NS+".idCheck", userid);
	}

	@Override
	public UserVO findUser(UserVO findUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(Integer midx) {
		return session.delete(NS+".deleteUser", midx);
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
