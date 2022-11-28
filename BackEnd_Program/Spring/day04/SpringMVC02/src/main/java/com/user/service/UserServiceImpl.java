package com.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.user.model.NotUserException;
import com.user.model.PagingVO;
import com.user.model.UserDAO;
import com.user.model.UserVO;
//서비스 계층에는 @Service를 붙인다.
@Service("userService")
public class UserServiceImpl implements UserService {
	
	//by Type으로 주입한다. @Autowired와 동일함
	@Inject
	private UserDAO userDao;

	@Override
	public int createUser(UserVO user) {
		
		return userDao.createUser(user);
	}

	@Override
	public int getUserCount(PagingVO pvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> listUser(PagingVO pvo) {
		return userDao.listUser(pvo);
	}

	@Override
	public boolean idCheck(String userid) {		
		Integer n=userDao.idCheck(userid);
		if(n==null) {
			return true;
		}
		return false;
	}

	@Override
	public int deleteUser(Integer midx) {		
		return userDao.deleteUser(midx);
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO getUser(Integer midx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findUser(UserVO findUser) throws NotUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO loginCheck(String userid, String pwd) throws NotUserException {
		// TODO Auto-generated method stub
		return null;
	}

}
