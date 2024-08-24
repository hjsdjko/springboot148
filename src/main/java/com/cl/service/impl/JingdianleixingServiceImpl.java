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


import com.cl.dao.JingdianleixingDao;
import com.cl.entity.JingdianleixingEntity;
import com.cl.service.JingdianleixingService;
import com.cl.entity.view.JingdianleixingView;

@Service("jingdianleixingService")
public class JingdianleixingServiceImpl extends ServiceImpl<JingdianleixingDao, JingdianleixingEntity> implements JingdianleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingdianleixingEntity> page = this.selectPage(
                new Query<JingdianleixingEntity>(params).getPage(),
                new EntityWrapper<JingdianleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingdianleixingEntity> wrapper) {
		  Page<JingdianleixingView> page =new Query<JingdianleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingdianleixingView> selectListView(Wrapper<JingdianleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingdianleixingView selectView(Wrapper<JingdianleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
