package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShilinyejuDao;
import com.entity.ShilinyejuEntity;
import com.service.ShilinyejuService;
import com.entity.vo.ShilinyejuVO;
import com.entity.view.ShilinyejuView;

@Service("shilinyejuService")
public class ShilinyejuServiceImpl extends ServiceImpl<ShilinyejuDao, ShilinyejuEntity> implements ShilinyejuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShilinyejuEntity> page = this.selectPage(
                new Query<ShilinyejuEntity>(params).getPage(),
                new EntityWrapper<ShilinyejuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShilinyejuEntity> wrapper) {
		  Page<ShilinyejuView> page =new Query<ShilinyejuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShilinyejuVO> selectListVO(Wrapper<ShilinyejuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShilinyejuVO selectVO(Wrapper<ShilinyejuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShilinyejuView> selectListView(Wrapper<ShilinyejuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShilinyejuView selectView(Wrapper<ShilinyejuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
