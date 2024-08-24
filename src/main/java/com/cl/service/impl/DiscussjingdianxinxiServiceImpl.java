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


import com.cl.dao.DiscussjingdianxinxiDao;
import com.cl.entity.DiscussjingdianxinxiEntity;
import com.cl.service.DiscussjingdianxinxiService;
import com.cl.entity.view.DiscussjingdianxinxiView;

@Service("discussjingdianxinxiService")
public class DiscussjingdianxinxiServiceImpl extends ServiceImpl<DiscussjingdianxinxiDao, DiscussjingdianxinxiEntity> implements DiscussjingdianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjingdianxinxiEntity> page = this.selectPage(
                new Query<DiscussjingdianxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussjingdianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjingdianxinxiEntity> wrapper) {
		  Page<DiscussjingdianxinxiView> page =new Query<DiscussjingdianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjingdianxinxiView> selectListView(Wrapper<DiscussjingdianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjingdianxinxiView selectView(Wrapper<DiscussjingdianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
