package org.cc.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cc.ems.entity.Employee;
import org.cc.ems.entity.Post;
import org.cc.ems.utils.DbUtil;

/**
 * Emp dao mysql实现
 * @author CC11001100
 *
 */
public class EmployeeDaoImpl4Mysql implements EmployeeDao {

	//把全都会用到的头部提取到这儿来了
	private String baseSql="SELECT emp_id, emp_name, emp_sex, emp_age, emp_depart, emp_year, t2.post_id AS pid, post_name, post_desc FROM employee as t1 JOIN post as t2 ON t1.post_id=t2.post_id ";
	
	@Override
	public List<Employee> load(String name) {
		String sql=baseSql+" WHERE emp_name LIKE ?";
		return query(sql,String.format("%%%s%%",name));
	}

	@Override
	public List<Employee> load(int postId) {
		String sql=baseSql+" WHERE t2.post_id=?";
		return query(sql,postId);
	}

	@Override
	public List<Employee> load(String name, int postId) {
		String sql=baseSql+" WHERE emp_name LIKE ? and t2.post_id=?";
		return query(sql,String.format("%%%s%%",name),postId);
	}

	@Override
	public List<Employee> list() {
		return query(baseSql);
	}

	/**
	 * 内部查询方法
	 * @param sql
	 * @return
	 */
	private List<Employee> query(String sql,Object ...param){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Employee> list=new ArrayList<Employee>();
		
		try {
			conn=DbUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				pstmt.setObject(i+1,param[i]);
			}
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Employee emp=new Employee();
				
				emp.setId(rs.getInt("emp_id"));
				emp.setAge(rs.getInt("emp_age"));
				emp.setDepary(rs.getString("emp_depart"));
				emp.setEmpYear(rs.getInt("emp_year"));
				
				emp.setName(rs.getString("emp_name"));
				emp.setSex(rs.getInt("emp_sex")==1?"男":"女");
				
				Post post=new Post();
				post.setId(rs.getInt("pid"));
				post.setName(rs.getString("post_name"));
				post.setDesc(rs.getString("post_desc"));
				
				emp.setPost(post);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.getInstance().close(conn,pstmt,rs);
		}
		
		return list;
	}
	
}
