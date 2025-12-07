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
 * 林业资源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@TableName("linyeziyuan")
public class LinyeziyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LinyeziyuanEntity() {
		
	}
	
	public LinyeziyuanEntity(T t) {
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
	 * 林种类型
	 */
					
	private String linzhongleixing;
	
	/**
	 * 森林覆盖率
	 */
					
	private Double senlinfugailv;
	
	/**
	 * 林木蓄积量
	 */
					
	private Double linmuxujiliang;
	
	/**
	 * 申请状态
	 */
					
	private String shenqingzhuangtai;
	
	/**
	 * 林地图片
	 */
					
	private String linditupian;
	
	/**
	 * 林业局名称
	 */
					
	private String linyejumingcheng;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
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
	 * 设置：林种类型
	 */
	public void setLinzhongleixing(String linzhongleixing) {
		this.linzhongleixing = linzhongleixing;
	}
	/**
	 * 获取：林种类型
	 */
	public String getLinzhongleixing() {
		return linzhongleixing;
	}
	/**
	 * 设置：森林覆盖率
	 */
	public void setSenlinfugailv(Double senlinfugailv) {
		this.senlinfugailv = senlinfugailv;
	}
	/**
	 * 获取：森林覆盖率
	 */
	public Double getSenlinfugailv() {
		return senlinfugailv;
	}
	/**
	 * 设置：林木蓄积量
	 */
	public void setLinmuxujiliang(Double linmuxujiliang) {
		this.linmuxujiliang = linmuxujiliang;
	}
	/**
	 * 获取：林木蓄积量
	 */
	public Double getLinmuxujiliang() {
		return linmuxujiliang;
	}
	/**
	 * 设置：申请状态
	 */
	public void setShenqingzhuangtai(String shenqingzhuangtai) {
		this.shenqingzhuangtai = shenqingzhuangtai;
	}
	/**
	 * 获取：申请状态
	 */
	public String getShenqingzhuangtai() {
		return shenqingzhuangtai;
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
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
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
