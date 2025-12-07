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


import com.dao.DiscusslinyezhengceDao;
import com.entity.DiscusslinyezhengceEntity;
import com.service.DiscusslinyezhengceService;
import com.entity.vo.DiscusslinyezhengceVO;
import com.entity.view.DiscusslinyezhengceView;

@Service("discusslinyezhengceService")
public class DiscusslinyezhengceServiceImpl extends ServiceImpl<DiscusslinyezhengceDao, DiscusslinyezhengceEntity> implements DiscusslinyezhengceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslinyezhengceEntity> page = this.selectPage(
                new Query<DiscusslinyezhengceEntity>(params).getPage(),
                new EntityWrapper<DiscusslinyezhengceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslinyezhengceEntity> wrapper) {
		  Page<DiscusslinyezhengceView> page =new Query<DiscusslinyezhengceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusslinyezhengceVO> selectListVO(Wrapper<DiscusslinyezhengceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslinyezhengceVO selectVO(Wrapper<DiscusslinyezhengceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslinyezhengceView> selectListView(Wrapper<DiscusslinyezhengceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslinyezhengceView selectView(Wrapper<DiscusslinyezhengceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
