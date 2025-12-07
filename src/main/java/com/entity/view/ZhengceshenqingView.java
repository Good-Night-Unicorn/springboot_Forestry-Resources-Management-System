package com.entity.view;

import com.entity.ZhengceshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 政策申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
@TableName("zhengceshenqing")
public class ZhengceshenqingView  extends ZhengceshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhengceshenqingView(){
	}
 
 	public ZhengceshenqingView(ZhengceshenqingEntity zhengceshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, zhengceshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
