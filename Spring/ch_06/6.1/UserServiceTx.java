//UserServiceTx
package springbook.user.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import springbook.user.domain.User;

public class UserServiceTx implements UserService {
	UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	} //UserService를 구현한 다른 오브젝트를 DI

	public void add(User user) {
		this.userService.add(user);
	}

	public void upgradeLevels() {
        userService.upgradeLevels();
	} //DI 받은 UserService 오브젝트에 모든 기능을 위임
}
