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

import com.entity.ShilinyejuEntity;
import com.entity.view.ShilinyejuView;

import com.service.ShilinyejuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 市林业局
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/shilinyeju")
public class ShilinyejuController {
    @Autowired
    private ShilinyejuService shilinyejuService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ShilinyejuEntity u = shilinyejuService.selectOne(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"shilinyeju",  "市林业局" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShilinyejuEntity shilinyeju){
    	//ValidatorUtils.validateEntity(shilinyeju);
    	ShilinyejuEntity u = shilinyejuService.selectOne(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		shilinyeju.setId(uId);
        shilinyejuService.insert(shilinyeju);
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
        ShilinyejuEntity u = shilinyejuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ShilinyejuEntity u = shilinyejuService.selectOne(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        shilinyejuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShilinyejuEntity shilinyeju,
		HttpServletRequest request){
        EntityWrapper<ShilinyejuEntity> ew = new EntityWrapper<ShilinyejuEntity>();



		PageUtils page = shilinyejuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shilinyeju), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShilinyejuEntity shilinyeju, 
		HttpServletRequest request){
        EntityWrapper<ShilinyejuEntity> ew = new EntityWrapper<ShilinyejuEntity>();

		PageUtils page = shilinyejuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shilinyeju), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShilinyejuEntity shilinyeju){
       	EntityWrapper<ShilinyejuEntity> ew = new EntityWrapper<ShilinyejuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shilinyeju, "shilinyeju")); 
        return R.ok().put("data", shilinyejuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShilinyejuEntity shilinyeju){
        EntityWrapper< ShilinyejuEntity> ew = new EntityWrapper< ShilinyejuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shilinyeju, "shilinyeju")); 
		ShilinyejuView shilinyejuView =  shilinyejuService.selectView(ew);
		return R.ok("查询市林业局成功").put("data", shilinyejuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShilinyejuEntity shilinyeju = shilinyejuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shilinyeju,deSens);
        return R.ok().put("data", shilinyeju);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShilinyejuEntity shilinyeju = shilinyejuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shilinyeju,deSens);
        return R.ok().put("data", shilinyeju);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增市林业局") 
    public R save(@RequestBody ShilinyejuEntity shilinyeju, HttpServletRequest request){
        if(shilinyejuService.selectCount(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()))>0) {
            return R.error("林业局名称已存在");
        }
    	shilinyeju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shilinyeju);
    	ShilinyejuEntity u = shilinyejuService.selectOne(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		shilinyeju.setId(new Date().getTime());
        shilinyejuService.insert(shilinyeju);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增市林业局")
    @RequestMapping("/add")
    public R add(@RequestBody ShilinyejuEntity shilinyeju, HttpServletRequest request){
        if(shilinyejuService.selectCount(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()))>0) {
            return R.error("林业局名称已存在");
        }
    	shilinyeju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shilinyeju);
    	ShilinyejuEntity u = shilinyejuService.selectOne(new EntityWrapper<ShilinyejuEntity>().eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		shilinyeju.setId(new Date().getTime());
        shilinyejuService.insert(shilinyeju);
        return R.ok().put("data",shilinyeju.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改市林业局")
    public R update(@RequestBody ShilinyejuEntity shilinyeju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shilinyeju);
        if(shilinyejuService.selectCount(new EntityWrapper<ShilinyejuEntity>().ne("id", shilinyeju.getId()).eq("linyejumingcheng", shilinyeju.getLinyejumingcheng()))>0) {
            return R.error("林业局名称已存在");
        }
        //全部更新
        shilinyejuService.updateById(shilinyeju);
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(shilinyeju.getLinyejumingcheng());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", shilinyeju.getId()));

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除市林业局")
    public R delete(@RequestBody Long[] ids){
        shilinyejuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
