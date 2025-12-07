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

import com.entity.ZhengceshenqingEntity;
import com.entity.view.ZhengceshenqingView;

import com.service.ZhengceshenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 政策申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
@RestController
@RequestMapping("/zhengceshenqing")
public class ZhengceshenqingController {
    @Autowired
    private ZhengceshenqingService zhengceshenqingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhengceshenqingEntity zhengceshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
			zhengceshenqing.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("kaifaqiye")) {
			zhengceshenqing.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhengceshenqingEntity> ew = new EntityWrapper<ZhengceshenqingEntity>();



		PageUtils page = zhengceshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengceshenqing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhengceshenqingEntity zhengceshenqing, 
		HttpServletRequest request){
        EntityWrapper<ZhengceshenqingEntity> ew = new EntityWrapper<ZhengceshenqingEntity>();

		PageUtils page = zhengceshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengceshenqing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhengceshenqingEntity zhengceshenqing){
       	EntityWrapper<ZhengceshenqingEntity> ew = new EntityWrapper<ZhengceshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhengceshenqing, "zhengceshenqing")); 
        return R.ok().put("data", zhengceshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhengceshenqingEntity zhengceshenqing){
        EntityWrapper< ZhengceshenqingEntity> ew = new EntityWrapper< ZhengceshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhengceshenqing, "zhengceshenqing")); 
		ZhengceshenqingView zhengceshenqingView =  zhengceshenqingService.selectView(ew);
		return R.ok("查询政策申请成功").put("data", zhengceshenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhengceshenqingEntity zhengceshenqing = zhengceshenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhengceshenqing,deSens);
        return R.ok().put("data", zhengceshenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhengceshenqingEntity zhengceshenqing = zhengceshenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhengceshenqing,deSens);
        return R.ok().put("data", zhengceshenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增政策申请") 
    public R save(@RequestBody ZhengceshenqingEntity zhengceshenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengceshenqing);
        zhengceshenqingService.insert(zhengceshenqing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增政策申请")
    @RequestMapping("/add")
    public R add(@RequestBody ZhengceshenqingEntity zhengceshenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengceshenqing);
        zhengceshenqingService.insert(zhengceshenqing);
        return R.ok().put("data",zhengceshenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改政策申请")
    public R update(@RequestBody ZhengceshenqingEntity zhengceshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhengceshenqing);
        //全部更新
        zhengceshenqingService.updateById(zhengceshenqing);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核政策申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhengceshenqingEntity> list = new ArrayList<ZhengceshenqingEntity>();
        for(Long id : ids) {
            ZhengceshenqingEntity zhengceshenqing = zhengceshenqingService.selectById(id);
            zhengceshenqing.setSfsh(sfsh);
            zhengceshenqing.setShhf(shhf);
            list.add(zhengceshenqing);
        }
        zhengceshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除政策申请")
    public R delete(@RequestBody Long[] ids){
        zhengceshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
