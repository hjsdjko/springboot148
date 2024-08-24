package com.cl.dao;

import com.cl.entity.MenpiaogoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenpiaogoumaiView;


/**
 * 门票购买
 * 
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
public interface MenpiaogoumaiDao extends BaseMapper<MenpiaogoumaiEntity> {
	
	List<MenpiaogoumaiView> selectListView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);

	List<MenpiaogoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
	
	MenpiaogoumaiView selectView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
	

}
