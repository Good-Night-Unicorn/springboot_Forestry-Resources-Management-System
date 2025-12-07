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
 * 开发利用报告
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@TableName("kaifaliyongbaogao")
public class KaifaliyongbaogaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaifaliyongbaogaoEntity() {
		
	}
	
	public KaifaliyongbaogaoEntity(T t) {
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
	 * 林地名称
	 */
					
	private String lindimingcheng;
	
	/**
	 * 林地类型
	 */
					
	private String lindileixing;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 林地面积
	 */
					
	private String lindimianji;
	
	/**
	 * 林地图片
	 */
					
	private String linditupian;
	
	/**
	 * 开发时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kaifashijian;
	
	/**
	 * 开发结果
	 */
					
	private String kaifajieguo;
	
	/**
	 * 开发内容
	 */
					
	private String kaifaneirong;
	
	/**
	 * 林业局名称
	 */
					
	private String linyejumingcheng;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	
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
	 * 设置：林地名称
	 */
	public void setLindimingcheng(String lindimingcheng) {
		this.lindimingcheng = lindimingcheng;
	}
	/**
	 * 获取：林地名称
	 */
	public String getLindimingcheng() {
		return lindimingcheng;
	}
	/**
	 * 设置：林地类型
	 */
	public void setLindileixing(String lindileixing) {
		this.lindileixing = lindileixing;
	}
	/**
	 * 获取：林地类型
	 */
	public String getLindileixing() {
		return lindileixing;
	}
	/**
	 * 设置：区域
	 */
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
	/**
	 * 设置：林地面积
	 */
	public void setLindimianji(String lindimianji) {
		this.lindimianji = lindimianji;
	}
	/**
	 * 获取：林地面积
	 */
	public String getLindimianji() {
		return lindimianji;
	}
	/**
	 * 设置：林地图片
	 */
	public void setLinditupian(String linditupian) {
		this.linditupian = linditupian;
	}
	/**
	 * 获取：林地图片
	 */
	public String getLinditupian() {
		return linditupian;
	}
	/**
	 * 设置：开发时间
	 */
	public void setKaifashijian(Date kaifashijian) {
		this.kaifashijian = kaifashijian;
	}
	/**
	 * 获取：开发时间
	 */
	public Date getKaifashijian() {
		return kaifashijian;
	}
	/**
	 * 设置：开发结果
	 */
	public void setKaifajieguo(String kaifajieguo) {
		this.kaifajieguo = kaifajieguo;
	}
	/**
	 * 获取：开发结果
	 */
	public String getKaifajieguo() {
		return kaifajieguo;
	}
	/**
	 * 设置：开发内容
	 */
	public void setKaifaneirong(String kaifaneirong) {
		this.kaifaneirong = kaifaneirong;
	}
	/**
	 * 获取：开发内容
	 */
	public String getKaifaneirong() {
		return kaifaneirong;
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

}
