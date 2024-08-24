package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingdianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianxinxiView;


/**
 * 景点信息
 *
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
public interface JingdianxinxiService extends IService<JingdianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianxinxiView> selectListView(Wrapper<JingdianxinxiEntity> wrapper);
   	
   	JingdianxinxiView selectView(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianxinxiEntity> wrapper);
   	

}

