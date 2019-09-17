package jdbc小工具;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
/**
 * 利用泛型QR,写出具体实现类
 * @author 王少彬。。。。
 *
 */
public class QRTest {
	
	/**
	 * 这个类的测试：简单、没有多余信息，降低代码耦合
	 */
	@Test
	public void fun1() {
		Students s = new Students(1001, "zhangSan", 99, "male");
		addStu(s);
		
		Students s1 = load(1001);
		System.out.println(s1);
	}
	
	/**
	 * 增删改方法，更改sql模板
	 * @param stu
	 */
	@SuppressWarnings("rawtypes")
	public void addStu(Students stu) {
		QR qr = new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sql = "insert into students values(?,?,?,?)";//给出sql模板
		// 给出参数
		Object[] params = {stu.getSid(), stu.getSname(), stu.getAge(), stu.getGender()};
		// 调用update执行增、删、改！
		qr.update(sql, params);
	}
	/**
	 * 查询方法
	 * @param sid
	 * @return  Students
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Students load(int sid) {
		QR qr = new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sql = "select * from students where sid=?";//给出sql模板
		Object[] params = {sid};
		
		//表格的封装-->实现要自己写
		RsHandler<Students> rh = new RsHandler<Students>() {
			public Students handle(ResultSet rs) throws SQLException {
				if(!rs.next()) return null;
				Students stu = new Students();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setAge(rs.getInt("age"));
				stu.setGender(rs.getString("gender"));
				return stu;
			}
		};
		return (Students) qr.query(sql, rh, params);
	}
}
