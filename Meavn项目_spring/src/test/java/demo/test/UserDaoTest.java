package demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;/*eclipse不会自动引入此类，傻子*/

import demo.AppConfigDao;
import demo.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfigDao.class)
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao ;
	 
	@Test//普通单元测试
	public void testPlay() {
		userDao.add();
	}
}
