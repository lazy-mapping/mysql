package demo.dao;

import org.springframework.stereotype.Repository;

//@Component
@Repository//代替Component
public class UserDaoNormal implements UserDao{
	@Override
	public void add() {
		System.out.println("添加用户到数据库中。。。");
	}
}
