package mysql_web.dao;

import mysql_web.domain.User;

// UserDao接口

public interface UserDao {
	public void addUser(User form);
	public User findByUsername(String username);
}
