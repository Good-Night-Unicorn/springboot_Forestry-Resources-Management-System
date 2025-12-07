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

import com.entity.TokenEntity;
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

import com.entity.KaifaqiyeEntity;
import com.entity.view.KaifaqiyeView;

import com.service.KaifaqiyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 开发企业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/kaifaqiye")
public class KaifaqiyeController {
    @Autowired
    private KaifaqiyeService kaifaqiyeService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		KaifaqiyeEntity u = kaifaqiyeService.selectOne(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"kaifaqiye",  "开发企业" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KaifaqiyeEntity kaifaqiye){
    	//ValidatorUtils.validateEntity(kaifaqiye);
    	KaifaqiyeEntity u = kaifaqiyeService.selectOne(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		kaifaqiye.setId(uId);
        kaifaqiyeService.insert(kaifaqiye);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        KaifaqiyeEntity u = kaifaqiyeService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	KaifaqiyeEntity u = kaifaqiyeService.selectOne(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        kaifaqiyeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaifaqiyeEntity kaifaqiye,
		HttpServletRequest request){
        EntityWrapper<KaifaqiyeEntity> ew = new EntityWrapper<KaifaqiyeEntity>();



		PageUtils page = kaifaqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifaqiye), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaifaqiyeEntity kaifaqiye, 
		HttpServletRequest request){
        EntityWrapper<KaifaqiyeEntity> ew = new EntityWrapper<KaifaqiyeEntity>();

		PageUtils page = kaifaqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaifaqiye), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaifaqiyeEntity kaifaqiye){
       	EntityWrapper<KaifaqiyeEntity> ew = new EntityWrapper<KaifaqiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaifaqiye, "kaifaqiye")); 
        return R.ok().put("data", kaifaqiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaifaqiyeEntity kaifaqiye){
        EntityWrapper< KaifaqiyeEntity> ew = new EntityWrapper< KaifaqiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaifaqiye, "kaifaqiye")); 
		KaifaqiyeView kaifaqiyeView =  kaifaqiyeService.selectView(ew);
		return R.ok("查询开发企业成功").put("data", kaifaqiyeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaifaqiyeEntity kaifaqiye = kaifaqiyeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifaqiye,deSens);
        return R.ok().put("data", kaifaqiye);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaifaqiyeEntity kaifaqiye = kaifaqiyeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kaifaqiye,deSens);
        return R.ok().put("data", kaifaqiye);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增开发企业") 
    public R save(@RequestBody KaifaqiyeEntity kaifaqiye, HttpServletRequest request){
        if(kaifaqiyeService.selectCount(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
    	kaifaqiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaifaqiye);
    	KaifaqiyeEntity u = kaifaqiyeService.selectOne(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		kaifaqiye.setId(new Date().getTime());
        kaifaqiyeService.insert(kaifaqiye);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增开发企业")
    @RequestMapping("/add")
    public R add(@RequestBody KaifaqiyeEntity kaifaqiye, HttpServletRequest request){
        if(kaifaqiyeService.selectCount(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
    	kaifaqiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaifaqiye);
    	KaifaqiyeEntity u = kaifaqiyeService.selectOne(new EntityWrapper<KaifaqiyeEntity>().eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		kaifaqiye.setId(new Date().getTime());
        kaifaqiyeService.insert(kaifaqiye);
        return R.ok().put("data",kaifaqiye.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改开发企业")
    public R update(@RequestBody KaifaqiyeEntity kaifaqiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaifaqiye);
        if(kaifaqiyeService.selectCount(new EntityWrapper<KaifaqiyeEntity>().ne("id", kaifaqiye.getId()).eq("qiyemingcheng", kaifaqiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
        //全部更新
        kaifaqiyeService.updateById(kaifaqiye);
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(kaifaqiye.getQiyemingcheng());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", kaifaqiye.getId()));

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除开发企业")
    public R delete(@RequestBody Long[] ids){
        kaifaqiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
