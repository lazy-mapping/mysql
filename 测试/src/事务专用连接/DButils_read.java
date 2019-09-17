package 事务专用连接;
public class DButils_read {
}
/*
 * QueryRunner类
 * 简单化了SQL查询，它与ResultSetHandler组合在一起使用可以完成大部分的数据库操作，能够大大减少编码量。
lQueryRunner类提供了两个构造方法：
1. 默认的构造方法需要一个 javax.sql.DataSource 来作参数的构造方法。
2. 大文本操作QueryRunner类的主要方法：

.1 public Object query(Connection conn, String sql, Object[] params, ResultSetHandler rsh) throws SQLException：
执行一个查询操作，对象数组中的每个元素值被用来作为查询语句的置换参数。
该方法会自行处理PreparedStatement和 ResultSet的创建和关闭。

.2 public Object query(String sql, Object[] params, ResultSetHandler rsh) throws SQLException:　
几乎与第一种方法一样；唯一的不同在于它不将数据库连接提供给方法，
并且它是从提供给构造方法的数据源(DataSource) 或使用的setDataSource 方法中重新获得Connection。

.3 public Object query(Connection conn, String sql, ResultSetHandler rsh) throws SQLException:
执行一个不需要置换参数的查询操作。

.4 public int update(Connection conn, String sql, Object[] params) throws SQLException:
用来执行一个更新（插入、更新或删除）操作。

.5 public int update(Connection conn, String sql) throws SQLException：
用来执行一个不需要置换参数的更新操作。

该接口用于处理java.sql.ResultSet，将数据按要求转换为另一种形式。
ResultSetHandler 接口提供了一个单独的方法：Object handle (java.sql.ResultSet .rs)
ArrayHandler：把结果集中的第一行数据转成对象数组。
ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
ColumnListHandler：将结果集中某一列的数据存放到List中。
KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map<列名,列值>里
MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
 */

