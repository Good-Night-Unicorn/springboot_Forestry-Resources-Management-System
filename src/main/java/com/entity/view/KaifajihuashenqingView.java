package com.entity.view;

import com.entity.KaifajihuashenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 开发计划申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@TableName("kaifajihuashenqing")
public class KaifajihuashenqingView  extends KaifajihuashenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaifajihuashenqingView(){
	}
 
 	public KaifajihuashenqingView(KaifajihuashenqingEntity kaifajihuashenqingEntity){
 	try {
			BeanUtils.copyProperties(this, kaifajihuashenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
