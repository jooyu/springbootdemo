package com.zy.test.mapper;

import java.util.List;

import com.zy.test.domain.NewsInfo;

public interface NewsMapper {

	/**
	 * findAll
	 * @param pageNo
	 */
	List<NewsInfo> findAll(int pageNo);
	
	/**
	 * 查询一条记录
	 * @param id
	 * @return
	 */
	NewsInfo findOne(int id);
	
	/**
	 * save
	 * @param info
	 */
	void save(NewsInfo info);
	
	/**
	 * findCount
	 */
	int findCount();
}
