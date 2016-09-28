package org.cc.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cc.ems.entity.Post;
import org.cc.ems.utils.DbUtil;

public class PostDao4Mysql implements PostDao {

	@Override
	public List<Post> list() {
		String sql="SELECT post_id, post_name, post_desc FROM post ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<Post> list=new ArrayList<Post>();
		
		try {
			conn=DbUtil.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Post p=new Post();
				p.setId(rs.getInt("post_id"));
				p.setName(rs.getString("post_name"));
				p.setDesc(rs.getString("post_desc"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.getInstance().close(conn,pstmt,rs);
		}
		
		return list;
	}

}
