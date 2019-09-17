package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo1 {
	/**
	 * ClassNotFoundException：
	 * > 没导驱动包
	 * SQLException：
	 * > 检查3个参数：url、username、password是否正确
	 * > 检查是否开启了mysql服务器！
	 */
	@Test
	public void fun() {
		//定义引用
		Connection con=null;//连接对象
	 	Statement stmt=null;//语句发送器
		ResultSet rs=null;//结果集，不可滚动光标forward_only,不敏感，不更新
	 	//四大参数
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb1";
		String username="root";
		String password="1234";
	try {
		Class.forName(driverClassName);//加载驱动类（注册驱动）
	    con = DriverManager.getConnection(url,username,password);	
	    System.out.println(con+"测试连接是否成功");
	    
	    stmt=con.createStatement();
	    String sql="update students set sno='11' where sname='11'"; 
		/*
		 * String sql="insert into students values('10','11')";
		 * String sql="delete from students where sname='2'";
		 *  alter table t_user add column age int not null;增加一列
		 */
		int r=stmt.executeUpdate(sql);//create,insert,update,delete,alter,drop操作方法
		System.out.println("测试影响"+r+"行\n");
	
		String sqls="select * from ar_account";
		rs = stmt.executeQuery(sqls);//查询方法，返回表格
		int count =rs.getMetaData().getColumnCount();//获得元数据，列数
		while(rs.next()) {
			for(int i=1; i<count; i++) {//遍历所有列
				System.out.print(rs.getObject(i)+"  ");
				/*不通用，遍历指定的列
				* int id=rs.getInt(1); String name=rs.getString(2); Object money = rs.getObject(3);
				*System.out.println(id+" ,"+name + "," +money);
				*/
			}
			System.out.println();//换行
		}
		rs.last();//光标移动到最后
		String columnName=rs.getMetaData().getColumnName(2);//获得元数据，列名
		System.out.println("查到表格共 "+rs.getRow()+" 行 "+count+" 列 ;"+"第2列的名称"+columnName);
	} catch(Exception e){
			throw new RuntimeException(e);//ClassNotFoundException,SQLException
	} finally{
		//倒着关闭资源
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();//使用完必须关
		} catch(SQLException e) {
			System.out.println(e+"可能是空指针异常！"); 
		  } 
	  }
	}
}