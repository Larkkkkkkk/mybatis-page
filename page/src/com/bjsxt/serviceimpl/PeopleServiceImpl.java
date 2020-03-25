package com.bjsxt.serviceimpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.PeopleService;
public class PeopleServiceImpl implements PeopleService {
	
	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		
		//获取配置资源
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
		
		//使用构建者模式(加快工厂实例化)和工厂模式生产session
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
				SqlSession session = factory.openSession();
	
		//创建对象
		    PageInfo pi=new PageInfo(); 
				pi.setPageNumber(pageNumber);
				pi.setPageSize(pageSize);
		
		//新建map对象  
		Map<String,Object> map=new HashMap<>();
			map.put("pageStart",pageSize*(pageNumber-1));  //设置好每一页开始的那个数字
			map.put("pageSize",pageSize);  //设置好每一页有几个
			pi.setList(session.selectList("com.bjsxt.mapper.PeopleMapper.selByPage",map));  //要设置返回结果  第二个参数是传入两个key值
		 
		//总条数
			long count=session.selectOne("com.bjsxt.mapper.PeopleMapper.selCount");  //获取查询总条数
			
			pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);  //要设置总共几页  总数/每一页  
		
		return pi;
	}

}
