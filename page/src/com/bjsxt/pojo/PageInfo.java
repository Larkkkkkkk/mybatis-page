package com.bjsxt.pojo;
import java.util.List;
public class PageInfo {

	private int pageSize;  //一页分布几个
	private int pageNumber;  //是第几页 方便于去找每一页的开始的那个元素
	private long total;   //总页数
	private List<?> list;   //当前页显示的数据 
		
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
}
