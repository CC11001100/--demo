package org.cc.ems.service;

import java.util.List;

import org.cc.ems.dao.EmployeeDao;
import org.cc.ems.dao.EmployeeDaoImpl4Mysql;
import org.cc.ems.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao empDao;
	
	public EmployeeServiceImpl() {
		empDao=new EmployeeDaoImpl4Mysql();
	}
	
	@Override
	public List<Employee> load(String name) {
		return empDao.load(name);
	}

	@Override
	public List<Employee> load(int postId) {
		return empDao.load(postId);
	}

	@Override
	public List<Employee> load(String name, int postId) {
		return empDao.load(name,postId);
	}

	@Override
	public List<Employee> list() {
		return empDao.list();
	}

}
