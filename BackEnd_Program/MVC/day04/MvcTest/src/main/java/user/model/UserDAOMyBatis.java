package user.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAOMyBatis {
	
	String resource = "common/config/mybatis-config.xml";
	private final String NS = "user.model.UserMapper";
	private SqlSession ses;
	
	public SqlSessionFactory getSessionFactory() {
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			return factory;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int insertUser(UserVO user) {
		try {
			ses = this.getSessionFactory().openSession(true);
			int n = ses.insert(NS + ".insertUser", user);
			return n;
		} finally {
			close();
		}
	}
	
	public void close() {
		if(ses!=null) ses.close();
	}

	public boolean idCheck(String userid) {
		try {
			ses = this.getSessionFactory().openSession();
			
			Integer idx = ses.selectOne(NS + ".idCheck", userid);
			if(idx==null) {
				return true;
			}
			return false;
		} finally {
			close();
		}
	}

	public UserVO loginCheck(String userid, String pwd) throws NotUserException {

		UserVO user = this.selectUserByUserid(userid);
		if(user==null) {
			throw new NotUserException(userid + " 아이디 없음");
		}
		String dbPwd = user.getPwd();
		if(!dbPwd.equals(pwd)) {
			throw new NotUserException("비밀번호 틀림");
		}
		
		return user;
	}

	public UserVO selectUserByUserid(String userid) {
		try {
			ses = this.getSessionFactory().openSession(true);
			UserVO user = ses.selectOne(NS + ".selectUserByUserid", userid);
			return user;
		} finally {
			close();
		}
	}
	
}
