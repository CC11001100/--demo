package org.cc.ems.dao;

import java.util.List;

import org.cc.ems.entity.Post;

public interface PostDao {

	/**
	 * 列出所有
	 */
	public List<Post> list();
	
}
