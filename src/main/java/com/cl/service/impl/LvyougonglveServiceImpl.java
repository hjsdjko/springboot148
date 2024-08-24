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


import com.cl.dao.LvyougonglveDao;
import com.cl.entity.LvyougonglveEntity;
import com.cl.service.LvyougonglveService;
import com.cl.entity.view.LvyougonglveView;

@Service("lvyougonglveService")
public class LvyougonglveServiceImpl extends ServiceImpl<LvyougonglveDao, LvyougonglveEntity> implements LvyougonglveService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LvyougonglveEntity> page = this.selectPage(
                new Query<LvyougonglveEntity>(params).getPage(),
                new EntityWrapper<LvyougonglveEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LvyougonglveEntity> wrapper) {
		  Page<LvyougonglveView> page =new Query<LvyougonglveView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LvyougonglveView> selectListView(Wrapper<LvyougonglveEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LvyougonglveView selectView(Wrapper<LvyougonglveEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
