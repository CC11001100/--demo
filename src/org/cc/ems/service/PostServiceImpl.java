package org.cc.ems.service;

import java.util.List;

import org.cc.ems.dao.PostDao;
import org.cc.ems.dao.PostDao4Mysql;
import org.cc.ems.entity.Post;

public class PostServiceImpl implements PostService {

	private PostDao dao;
	
	public PostServiceImpl() {
		dao=new PostDao4Mysql();
	}
	
	@Override
	public List<Post> list() {
		return dao.list();
	}

}
