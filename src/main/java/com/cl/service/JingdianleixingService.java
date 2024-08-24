package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingdianleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianleixingView;


/**
 * 景点类型
 *
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
public interface JingdianleixingService extends IService<JingdianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianleixingView> selectListView(Wrapper<JingdianleixingEntity> wrapper);
   	
   	JingdianleixingView selectView(@Param("ew") Wrapper<JingdianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianleixingEntity> wrapper);
   	

}

