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


import com.dao.ZhengceshenqingDao;
import com.entity.ZhengceshenqingEntity;
import com.service.ZhengceshenqingService;
import com.entity.vo.ZhengceshenqingVO;
import com.entity.view.ZhengceshenqingView;

@Service("zhengceshenqingService")
public class ZhengceshenqingServiceImpl extends ServiceImpl<ZhengceshenqingDao, ZhengceshenqingEntity> implements ZhengceshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengceshenqingEntity> page = this.selectPage(
                new Query<ZhengceshenqingEntity>(params).getPage(),
                new EntityWrapper<ZhengceshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengceshenqingEntity> wrapper) {
		  Page<ZhengceshenqingView> page =new Query<ZhengceshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhengceshenqingVO> selectListVO(Wrapper<ZhengceshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhengceshenqingVO selectVO(Wrapper<ZhengceshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhengceshenqingView> selectListView(Wrapper<ZhengceshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengceshenqingView selectView(Wrapper<ZhengceshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
