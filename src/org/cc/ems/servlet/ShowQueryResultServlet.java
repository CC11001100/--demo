package org.cc.ems.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cc.ems.dao.EmployeeDao;
import org.cc.ems.dao.EmployeeDaoImpl4Mysql;
import org.cc.ems.entity.Employee;
import org.cc.ems.service.EmployeeService;
import org.cc.ems.service.EmployeeServiceImpl;

@WebServlet(urlPatterns={"/showQueryResultServlet"})
public class ShowQueryResultServlet extends HttpServlet {

	private EmployeeService employeeService;
	
	public ShowQueryResultServlet() {
		employeeService=new EmployeeServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		process(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name=new String(req.getParameter("empName").getBytes("GB2312"));
		String name=req.getParameter("empName");
		String jobId=req.getParameter("jobName");
		if("-1".equals(jobId)){
			//检查是否选择了职位信息
			req.setAttribute("errorMessage","必须选择一个职位");
			req.getRequestDispatcher("/showQueryPageServlet").forward(req,resp);
			return;
		}else {
			try {
				//检查非法输入
				Integer.parseInt(jobId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				req.setAttribute("errorMessage","职位信息错误");
				req.getRequestDispatcher("/showQueryPageServlet").forward(req,resp);
				return;
			}
		}
		
		//根据不同的传入选择不同的查询方式
		List<Employee> list = new ArrayList<Employee>();
		if("-2".equals(jobId)){
			//只根据名字查询
			list=employeeService.load(name);
		}else if(!"".equals(name)){
			//根据姓名查询和职位查询
			list=employeeService.load(name,Integer.parseInt(jobId));
		}else{
			//根据职位查询
			list=employeeService.load(Integer.parseInt(jobId));
		}
		//排下序，等下显示出来美观一点
		Collections.sort(list);
		
		//跳转到显示页面
		req.setAttribute("resultSet",list);
		req.getRequestDispatcher("/result.jsp").forward(req,resp);
	}
	
}
