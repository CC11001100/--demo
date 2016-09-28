package org.cc.ems.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cc.ems.entity.Post;
import org.cc.ems.service.PostService;
import org.cc.ems.service.PostServiceImpl;

@WebServlet(urlPatterns={"/showQueryPageServlet"})
public class ShowQueryPageServlet extends HttpServlet {
	
	private PostService postService;
	
	public ShowQueryPageServlet() {
		postService=new PostServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//查询出来职位信息设置到request中
		List<Post> list=postService.list();
		req.setAttribute("jobs",list);
		req.getRequestDispatcher("/queryPage.jsp").forward(req,resp);
	}
	
}
