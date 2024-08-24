package com.cl.dao;

import com.cl.entity.JingdianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianxinxiView;


/**
 * 景点信息
 * 
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
public interface JingdianxinxiDao extends BaseMapper<JingdianxinxiEntity> {
	
	List<JingdianxinxiView> selectListView(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);

	List<JingdianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
	
	JingdianxinxiView selectView(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
	

}
