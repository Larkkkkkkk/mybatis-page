package com.bjsxt.service;
import java.io.IOException;

import com.bjsxt.pojo.PageInfo;
public interface PeopleService {
	//实现分页展示  传入两个参数
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
