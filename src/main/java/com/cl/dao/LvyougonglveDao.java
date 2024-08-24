package com.cl.dao;

import com.cl.entity.LvyougonglveEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LvyougonglveView;


/**
 * 旅游攻略
 * 
 * @author 
 * @email 
 * @date 2024-02-03 21:52:10
 */
public interface LvyougonglveDao extends BaseMapper<LvyougonglveEntity> {
	
	List<LvyougonglveView> selectListView(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);

	List<LvyougonglveView> selectListView(Pagination page,@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
	
	LvyougonglveView selectView(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
	

}
