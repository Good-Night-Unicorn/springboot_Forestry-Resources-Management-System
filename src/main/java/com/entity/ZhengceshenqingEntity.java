package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 政策申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
@TableName("zhengceshenqing")
public class ZhengceshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhengceshenqingEntity() {
		
	}
	
	public ZhengceshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 政策名称
	 */
					
	private String zhengcemingcheng;
	
	/**
	 * 政策类型
	 */
					
	private String zhengceleixing;
	
	/**
	 * 政策图片
	 */
					
	private String zhengcetupian;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 申请材料
	 */
					
	private String shenqingcailiao;
	
	/**
	 * 林业局名称
	 */
					
	private String linyejumingcheng;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：政策名称
	 */
	public void setZhengcemingcheng(String zhengcemingcheng) {
		this.zhengcemingcheng = zhengcemingcheng;
	}
	/**
	 * 获取：政策名称
	 */
	public String getZhengcemingcheng() {
		return zhengcemingcheng;
	}
	/**
	 * 设置：政策类型
	 */
	public void setZhengceleixing(String zhengceleixing) {
		this.zhengceleixing = zhengceleixing;
	}
	/**
	 * 获取：政策类型
	 */
	public String getZhengceleixing() {
		return zhengceleixing;
	}
	/**
	 * 设置：政策图片
	 */
	public void setZhengcetupian(String zhengcetupian) {
		this.zhengcetupian = zhengcetupian;
	}
	/**
	 * 获取：政策图片
	 */
	public String getZhengcetupian() {
		return zhengcetupian;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
	/**
	 * 设置：申请材料
	 */
	public void setShenqingcailiao(String shenqingcailiao) {
		this.shenqingcailiao = shenqingcailiao;
	}
	/**
	 * 获取：申请材料
	 */
	public String getShenqingcailiao() {
		return shenqingcailiao;
	}
	/**
	 * 设置：林业局名称
	 */
	public void setLinyejumingcheng(String linyejumingcheng) {
		this.linyejumingcheng = linyejumingcheng;
	}
	/**
	 * 获取：林业局名称
	 */
	public String getLinyejumingcheng() {
		return linyejumingcheng;
	}
	/**
	 * 设置：企业名称
	 */
	public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
	}
	/**
	 * 获取：企业名称
	 */
	public String getQiyemingcheng() {
		return qiyemingcheng;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
