package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MenpiaogoumaiDao;
import com.cl.entity.MenpiaogoumaiEntity;
import com.cl.service.MenpiaogoumaiService;
import com.cl.entity.view.MenpiaogoumaiView;

@Service("menpiaogoumaiService")
public class MenpiaogoumaiServiceImpl extends ServiceImpl<MenpiaogoumaiDao, MenpiaogoumaiEntity> implements MenpiaogoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenpiaogoumaiEntity> page = this.selectPage(
                new Query<MenpiaogoumaiEntity>(params).getPage(),
                new EntityWrapper<MenpiaogoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MenpiaogoumaiEntity> wrapper) {
		  Page<MenpiaogoumaiView> page =new Query<MenpiaogoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MenpiaogoumaiView> selectListView(Wrapper<MenpiaogoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MenpiaogoumaiView selectView(Wrapper<MenpiaogoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
