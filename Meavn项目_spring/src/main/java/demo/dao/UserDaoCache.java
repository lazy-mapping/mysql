package demo.dao;

public class UserDaoCache implements UserDao {
	public void add() {
		System.out.println("添加用户到缓存中。。。");
	}
}
