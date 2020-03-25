package com.bjsxt.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
@WebServlet("/page")
public class ShowPageServlet extends HttpServlet{
		
	//面向接口编程
	private	PeopleService peopleService=new com.bjsxt.serviceimpl.PeopleServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		
		//第一次访问的验证 如果没有传递参数 设置默认值
		String  pageSizeStr = req.getParameter("pageSize");
		int pageSize=2;  //一页显示几个
		if(pageSizeStr!=null&&!pageSizeStr.equals(""))
		{
			pageSize = Integer.parseInt(pageSizeStr);     //获取两个参数
		}
		
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1; //显示第几页
		if(pageNumberStr!=null&&!pageNumberStr.equals(""))
		{
			pageNumber = Integer.parseInt(pageNumberStr);  //获取两个参数
		}
		
		PageInfo pi=peopleService.showPage(pageSize, pageNumber);   //分页展示效果给了pageinfo实体类
		
		//  传过去
			req.setAttribute("PageInfo", pi);
		
		//  请求转发
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	
	}
	
}
