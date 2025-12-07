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

import com.entity.KaifajihuashenqingEntity;
import com.entity.view.KaifajihuashenqingView;

import com.service.KaifajihuashenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 开发计划申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/kaifajihuashenqing")
public class KaifajihuashenqingController {
    @Autowired
    private KaifajihuashenqingService kaifajihuashenqingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaifajihuashenqingEntity kaifajihuashenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
			kaifajihuashenqing.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("kaifaqiye")) {
			kaifajihuashenqing.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();



		PageUtils page = kaifajihuashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifajihuashenqing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaifajihuashenqingEntity kaifajihuashenqing, 
		HttpServletRequest request){
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();

		PageUtils page = kaifajihuashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifajihuashenqing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaifajihuashenqingEntity kaifajihuashenqing){
       	EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaifajihuashenqing, "kaifajihuashenqing")); 
        return R.ok().put("data", kaifajihuashenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaifajihuashenqingEntity kaifajihuashenqing){
        EntityWrapper< KaifajihuashenqingEntity> ew = new EntityWrapper< KaifajihuashenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaifajihuashenqing, "kaifajihuashenqing")); 
		KaifajihuashenqingView kaifajihuashenqingView =  kaifajihuashenqingService.selectView(ew);
		return R.ok("查询开发计划申请成功").put("data", kaifajihuashenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaifajihuashenqingEntity kaifajihuashenqing = kaifajihuashenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifajihuashenqing,deSens);
        return R.ok().put("data", kaifajihuashenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaifajihuashenqingEntity kaifajihuashenqing = kaifajihuashenqingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifajihuashenqing,deSens);
        return R.ok().put("data", kaifajihuashenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增开发计划申请") 
    public R save(@RequestBody KaifajihuashenqingEntity kaifajihuashenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaifajihuashenqing);
        kaifajihuashenqingService.insert(kaifajihuashenqing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增开发计划申请")
    @RequestMapping("/add")
    public R add(@RequestBody KaifajihuashenqingEntity kaifajihuashenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaifajihuashenqing);
        kaifajihuashenqingService.insert(kaifajihuashenqing);
        return R.ok().put("data",kaifajihuashenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改开发计划申请")
    public R update(@RequestBody KaifajihuashenqingEntity kaifajihuashenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaifajihuashenqing);
        //全部更新
        kaifajihuashenqingService.updateById(kaifajihuashenqing);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核开发计划申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<KaifajihuashenqingEntity> list = new ArrayList<KaifajihuashenqingEntity>();
        for(Long id : ids) {
            KaifajihuashenqingEntity kaifajihuashenqing = kaifajihuashenqingService.selectById(id);
            kaifajihuashenqing.setSfsh(sfsh);
            kaifajihuashenqing.setShhf(shhf);
            list.add(kaifajihuashenqing);
        }
        kaifajihuashenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除开发计划申请")
    public R delete(@RequestBody Long[] ids){
        kaifajihuashenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("kaifaqiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = kaifajihuashenqingService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kaifaqiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = kaifajihuashenqingService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kaifaqiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = kaifajihuashenqingService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kaifaqiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = kaifajihuashenqingService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kaifaqiye")) {
            ew.eq("qiyemingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = kaifajihuashenqingService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }



    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,KaifajihuashenqingEntity kaifajihuashenqing, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            kaifajihuashenqing.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("kaifaqiye")) {
            kaifajihuashenqing.setQiyemingcheng((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<KaifajihuashenqingEntity> ew = new EntityWrapper<KaifajihuashenqingEntity>();
        int count = kaifajihuashenqingService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifajihuashenqing), params), params));
        return R.ok().put("data", count);
    }



}
