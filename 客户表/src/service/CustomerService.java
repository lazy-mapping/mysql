package service;

import java.util.List;

import dao.CustomerDao;
import domain.Customer;

/**
 * 业务层
 * @author cxf
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	/**
	 * 添加客户
	 * @param c
	 */
	public void add(Customer c) {
		customerDao.add(c);
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	/**
	 * 加载客户
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		return customerDao.load(cid);
	}

	/**
	 * 编辑客户
	 * @param c
	 */
	public void edit(Customer c) {
		customerDao.edit(c);
	}

	/**
	 * 多条件组合查询
	 * @param criteria
	 * @return
	 */
	public List<Customer> query(Customer criteria) {
		return customerDao.query(criteria);
	}
}
