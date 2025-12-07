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
 * 林业政策
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
@TableName("linyezhengce")
public class LinyezhengceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LinyezhengceEntity() {
		
	}
	
	public LinyezhengceEntity(T t) {
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
	 * 申请条件
	 */
					
	private String shenqingtiaojian;
	
	/**
	 * 政策内容
	 */
					
	private String zhengceneirong;
	
	/**
	 * 发布日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faburiqi;
	
	/**
	 * 政策图片
	 */
					
	private String zhengcetupian;
	
	/**
	 * 林业局名称
	 */
					
	private String linyejumingcheng;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：申请条件
	 */
	public void setShenqingtiaojian(String shenqingtiaojian) {
		this.shenqingtiaojian = shenqingtiaojian;
	}
	/**
	 * 获取：申请条件
	 */
	public String getShenqingtiaojian() {
		return shenqingtiaojian;
	}
	/**
	 * 设置：政策内容
	 */
	public void setZhengceneirong(String zhengceneirong) {
		this.zhengceneirong = zhengceneirong;
	}
	/**
	 * 获取：政策内容
	 */
	public String getZhengceneirong() {
		return zhengceneirong;
	}
	/**
	 * 设置：发布日期
	 */
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
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
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
