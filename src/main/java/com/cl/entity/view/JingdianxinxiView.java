package com.cl.entity.view;

import com.cl.entity.JingdianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 景点信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-03 21:52:09
 */
@TableName("jingdianxinxi")
public class JingdianxinxiView  extends JingdianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingdianxinxiView(){
	}
 
 	public JingdianxinxiView(JingdianxinxiEntity jingdianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jingdianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
