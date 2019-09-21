package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Customer;

/**
 * 持久层
 * 
 * @author cxf
 * 
 */
public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加客户
	 * 
	 * @param c
	 */
	public void add(Customer c) {
		try {
			String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
			Object[] params = { c.getCid(), c.getCname(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getDescription()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll() {
		try {
			String sql = "select * from t_customer";
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载客户
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		try {
			String sql = "select * from t_customer where cid=?";
			return qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 编辑客户
	 * @param c
	 */
	public void edit(Customer c) {
		try {
			String sql = "update t_customer set cname=?,gender=?,birthday=?," +
					"cellphone=?,email=?,description=? where cid=?";
			Object[] params = {c.getCname(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getDescription(), c.getCid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 多条件组合查询
	 * @param criteria
	 * @return
	 */
	public List<Customer> query(Customer criteria) {
		try {
			/*
			 * 1. 给出sql模板
			 * 2. 给出参数
			 * 3. 调用query方法，使用结果集处理器：BeanListHandler
			 */
			/*
			 * 一、　给出sql模板
			 * 二、　给出参数！
			 */
			/*
			 * 1. 给出一个sql语句前半部
			 */
			StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
			/*
			 * 2. 判断条件，完成向sql中追加where子句
			 */
			/*
			 * 3. 创建一个ArrayList，用来装载参数值
			 */
			List<Object> params = new ArrayList<Object>();
			String cname = criteria.getCname();
			if(cname != null && !cname.trim().isEmpty()) {
				sql.append(" and cname like ?");
				params.add("%" + cname + "%");
			}
			
			String gender = criteria.getGender();
			if(gender != null && !gender.trim().isEmpty()) {
				sql.append(" and gender=?");
				params.add(gender);
			}
			
			String cellphone = criteria.getCellphone();
			if(cellphone != null && !cellphone.trim().isEmpty()) {
				sql.append(" and cellphone like ?");
				params.add("%" + cellphone + "%");
			}
			
			String email = criteria.getEmail();
			if(email != null && !email.trim().isEmpty()) {
				sql.append(" and email like ?");
				params.add("%" + email + "%");
			}
			
			/*
			 * 三、执行query
			 */
			return qr.query(sql.toString(), 
					new BeanListHandler<Customer>(Customer.class), 
					params.toArray());
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
