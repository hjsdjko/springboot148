package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JingdianxinxiEntity;
import com.cl.entity.view.JingdianxinxiView;

import com.cl.service.JingdianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 景点信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
@RestController
@RequestMapping("/jingdianxinxi")
public class JingdianxinxiController {
    @Autowired
    private JingdianxinxiService jingdianxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi,
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianxinxiEntity jingdianxinxi){
       	EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
        return R.ok().put("data", jingdianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianxinxiEntity jingdianxinxi){
        EntityWrapper< JingdianxinxiEntity> ew = new EntityWrapper< JingdianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
		JingdianxinxiView jingdianxinxiView =  jingdianxinxiService.selectView(ew);
		return R.ok("查询景点信息成功").put("data", jingdianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxi.setClicktime(new Date());
		jingdianxinxiService.updateById(jingdianxinxi);
		jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxi.setClicktime(new Date());
		jingdianxinxiService.updateById(jingdianxinxi);
		jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	jingdianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	jingdianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.updateById(jingdianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "jingdianleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "jingdianxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JingdianxinxiEntity> jingdianxinxiList = new ArrayList<JingdianxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                jingdianxinxiList.addAll(jingdianxinxiService.selectList(new EntityWrapper<JingdianxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        List<JingdianxinxiEntity> pageList = (List<JingdianxinxiEntity>)page.getList();
        if(jingdianxinxiList.size()<limit) {
            int toAddNum = (limit-jingdianxinxiList.size())<=pageList.size()?(limit-jingdianxinxiList.size()):pageList.size();
            for(JingdianxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(JingdianxinxiEntity o2 : jingdianxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    jingdianxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(jingdianxinxiList.size()>limit) {
            jingdianxinxiList = jingdianxinxiList.subList(0, limit);
        }
        page.setList(jingdianxinxiList);
        return R.ok().put("data", page);
    }







}
