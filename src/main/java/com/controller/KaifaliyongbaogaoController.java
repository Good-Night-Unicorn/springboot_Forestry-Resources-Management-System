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

import com.entity.KaifaliyongbaogaoEntity;
import com.entity.view.KaifaliyongbaogaoView;

import com.service.KaifaliyongbaogaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 开发利用报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/kaifaliyongbaogao")
public class KaifaliyongbaogaoController {
    @Autowired
    private KaifaliyongbaogaoService kaifaliyongbaogaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaifaliyongbaogaoEntity kaifaliyongbaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
			kaifaliyongbaogao.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("kaifaqiye")) {
			kaifaliyongbaogao.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaifaliyongbaogaoEntity> ew = new EntityWrapper<KaifaliyongbaogaoEntity>();



		PageUtils page = kaifaliyongbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifaliyongbaogao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaifaliyongbaogaoEntity kaifaliyongbaogao, 
		HttpServletRequest request){
        EntityWrapper<KaifaliyongbaogaoEntity> ew = new EntityWrapper<KaifaliyongbaogaoEntity>();

		PageUtils page = kaifaliyongbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifaliyongbaogao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaifaliyongbaogaoEntity kaifaliyongbaogao){
       	EntityWrapper<KaifaliyongbaogaoEntity> ew = new EntityWrapper<KaifaliyongbaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaifaliyongbaogao, "kaifaliyongbaogao")); 
        return R.ok().put("data", kaifaliyongbaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaifaliyongbaogaoEntity kaifaliyongbaogao){
        EntityWrapper< KaifaliyongbaogaoEntity> ew = new EntityWrapper< KaifaliyongbaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaifaliyongbaogao, "kaifaliyongbaogao")); 
		KaifaliyongbaogaoView kaifaliyongbaogaoView =  kaifaliyongbaogaoService.selectView(ew);
		return R.ok("查询开发利用报告成功").put("data", kaifaliyongbaogaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaifaliyongbaogaoEntity kaifaliyongbaogao = kaifaliyongbaogaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifaliyongbaogao,deSens);
        return R.ok().put("data", kaifaliyongbaogao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaifaliyongbaogaoEntity kaifaliyongbaogao = kaifaliyongbaogaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifaliyongbaogao,deSens);
        return R.ok().put("data", kaifaliyongbaogao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增开发利用报告") 
    public R save(@RequestBody KaifaliyongbaogaoEntity kaifaliyongbaogao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaifaliyongbaogao);
        kaifaliyongbaogaoService.insert(kaifaliyongbaogao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增开发利用报告")
    @RequestMapping("/add")
    public R add(@RequestBody KaifaliyongbaogaoEntity kaifaliyongbaogao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaifaliyongbaogao);
        kaifaliyongbaogaoService.insert(kaifaliyongbaogao);
        return R.ok().put("data",kaifaliyongbaogao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改开发利用报告")
    public R update(@RequestBody KaifaliyongbaogaoEntity kaifaliyongbaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaifaliyongbaogao);
        //全部更新
        kaifaliyongbaogaoService.updateById(kaifaliyongbaogao);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除开发利用报告")
    public R delete(@RequestBody Long[] ids){
        kaifaliyongbaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
