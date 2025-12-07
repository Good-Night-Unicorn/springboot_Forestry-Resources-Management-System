package com.entity.view;

import com.entity.KaifaliyongbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 开发利用报告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@TableName("kaifaliyongbaogao")
public class KaifaliyongbaogaoView  extends KaifaliyongbaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaifaliyongbaogaoView(){
	}
 
 	public KaifaliyongbaogaoView(KaifaliyongbaogaoEntity kaifaliyongbaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, kaifaliyongbaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
