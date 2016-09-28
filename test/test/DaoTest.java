package test;

import java.util.List;

import org.cc.ems.dao.EmployeeDao;
import org.cc.ems.dao.EmployeeDaoImpl4Mysql;
import org.cc.ems.dao.PostDao;
import org.cc.ems.dao.PostDao4Mysql;
import org.cc.ems.entity.Employee;
import org.cc.ems.entity.Post;
import org.junit.Ignore;
import org.junit.Test;

public class DaoTest {

	@Ignore
	@Test
	public void test_001(){
		
		EmployeeDao dao=new EmployeeDaoImpl4Mysql();
		
		List<Employee> list=dao.load("李",1000);
		
		for(Employee e:list) System.out.println(e);
		
		
	}
	
	@Test
	public void test_002(){
		
		PostDao dao=new PostDao4Mysql();
		List<Post> list=dao.list();
		
		for(Post e:list) System.out.println(e);
	}
	
}
