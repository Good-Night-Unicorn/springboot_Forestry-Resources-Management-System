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


import com.dao.ZhengceleixingDao;
import com.entity.ZhengceleixingEntity;
import com.service.ZhengceleixingService;
import com.entity.vo.ZhengceleixingVO;
import com.entity.view.ZhengceleixingView;

@Service("zhengceleixingService")
public class ZhengceleixingServiceImpl extends ServiceImpl<ZhengceleixingDao, ZhengceleixingEntity> implements ZhengceleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengceleixingEntity> page = this.selectPage(
                new Query<ZhengceleixingEntity>(params).getPage(),
                new EntityWrapper<ZhengceleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengceleixingEntity> wrapper) {
		  Page<ZhengceleixingView> page =new Query<ZhengceleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhengceleixingVO> selectListVO(Wrapper<ZhengceleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhengceleixingVO selectVO(Wrapper<ZhengceleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhengceleixingView> selectListView(Wrapper<ZhengceleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengceleixingView selectView(Wrapper<ZhengceleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
