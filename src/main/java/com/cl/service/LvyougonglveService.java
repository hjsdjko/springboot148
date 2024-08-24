package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LvyougonglveEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LvyougonglveView;


/**
 * 旅游攻略
 *
 * @author 
 * @email 
 * @date 2024-02-03 21:52:10
 */
public interface LvyougonglveService extends IService<LvyougonglveEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LvyougonglveView> selectListView(Wrapper<LvyougonglveEntity> wrapper);
   	
   	LvyougonglveView selectView(@Param("ew") Wrapper<LvyougonglveEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LvyougonglveEntity> wrapper);
   	

}

