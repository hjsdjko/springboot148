package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MenpiaogoumaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenpiaogoumaiView;


/**
 * 门票购买
 *
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
public interface MenpiaogoumaiService extends IService<MenpiaogoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenpiaogoumaiView> selectListView(Wrapper<MenpiaogoumaiEntity> wrapper);
   	
   	MenpiaogoumaiView selectView(@Param("ew") Wrapper<MenpiaogoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenpiaogoumaiEntity> wrapper);
   	

}

