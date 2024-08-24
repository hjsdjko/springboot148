package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjingdianxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjingdianxinxiView;


/**
 * 景点信息评论表
 *
 * @author 
 * @email 
 * @date 2024-02-03 21:52:10
 */
public interface DiscussjingdianxinxiService extends IService<DiscussjingdianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjingdianxinxiView> selectListView(Wrapper<DiscussjingdianxinxiEntity> wrapper);
   	
   	DiscussjingdianxinxiView selectView(@Param("ew") Wrapper<DiscussjingdianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjingdianxinxiEntity> wrapper);
   	

}

