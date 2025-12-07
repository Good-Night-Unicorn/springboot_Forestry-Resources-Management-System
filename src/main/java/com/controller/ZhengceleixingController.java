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

import com.entity.ZhengceleixingEntity;
import com.entity.view.ZhengceleixingView;

import com.service.ZhengceleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 政策类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
@RestController
@RequestMapping("/zhengceleixing")
public class ZhengceleixingController {
    @Autowired
    private ZhengceleixingService zhengceleixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhengceleixingEntity zhengceleixing,
		HttpServletRequest request){
        EntityWrapper<ZhengceleixingEntity> ew = new EntityWrapper<ZhengceleixingEntity>();



		PageUtils page = zhengceleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengceleixing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhengceleixingEntity zhengceleixing, 
		HttpServletRequest request){
        EntityWrapper<ZhengceleixingEntity> ew = new EntityWrapper<ZhengceleixingEntity>();

		PageUtils page = zhengceleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengceleixing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhengceleixingEntity zhengceleixing){
       	EntityWrapper<ZhengceleixingEntity> ew = new EntityWrapper<ZhengceleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhengceleixing, "zhengceleixing")); 
        return R.ok().put("data", zhengceleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhengceleixingEntity zhengceleixing){
        EntityWrapper< ZhengceleixingEntity> ew = new EntityWrapper< ZhengceleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhengceleixing, "zhengceleixing")); 
		ZhengceleixingView zhengceleixingView =  zhengceleixingService.selectView(ew);
		return R.ok("查询政策类型成功").put("data", zhengceleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhengceleixingEntity zhengceleixing = zhengceleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhengceleixing,deSens);
        return R.ok().put("data", zhengceleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhengceleixingEntity zhengceleixing = zhengceleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhengceleixing,deSens);
        return R.ok().put("data", zhengceleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增政策类型") 
    public R save(@RequestBody ZhengceleixingEntity zhengceleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengceleixing);
        zhengceleixingService.insert(zhengceleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增政策类型")
    @RequestMapping("/add")
    public R add(@RequestBody ZhengceleixingEntity zhengceleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengceleixing);
        zhengceleixingService.insert(zhengceleixing);
        return R.ok().put("data",zhengceleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改政策类型")
    public R update(@RequestBody ZhengceleixingEntity zhengceleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhengceleixing);
        //全部更新
        zhengceleixingService.updateById(zhengceleixing);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除政策类型")
    public R delete(@RequestBody Long[] ids){
        zhengceleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
