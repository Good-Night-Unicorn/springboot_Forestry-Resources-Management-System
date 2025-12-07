package com.controller;

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
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
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
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.QuyuEntity;
import com.entity.view.QuyuView;

import com.service.QuyuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 区域
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/quyu")
public class QuyuController {
    @Autowired
    private QuyuService quyuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuyuEntity quyu,
		HttpServletRequest request){
        EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();



		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuyuEntity quyu, 
		HttpServletRequest request){
        EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();

		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuyuEntity quyu){
       	EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quyu, "quyu")); 
        return R.ok().put("data", quyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuyuEntity quyu){
        EntityWrapper< QuyuEntity> ew = new EntityWrapper< QuyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quyu, "quyu")); 
		QuyuView quyuView =  quyuService.selectView(ew);
		return R.ok("查询区域成功").put("data", quyuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(quyu,deSens);
        return R.ok().put("data", quyu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(quyu,deSens);
        return R.ok().put("data", quyu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增区域") 
    public R save(@RequestBody QuyuEntity quyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quyu);
        quyuService.insert(quyu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增区域")
    @RequestMapping("/add")
    public R add(@RequestBody QuyuEntity quyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quyu);
        quyuService.insert(quyu);
        return R.ok().put("data",quyu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改区域")
    public R update(@RequestBody QuyuEntity quyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyu);
        //全部更新
        quyuService.updateById(quyu);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除区域")
    public R delete(@RequestBody Long[] ids){
        quyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
