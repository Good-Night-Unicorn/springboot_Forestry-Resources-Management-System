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


import com.dao.LinyezhengceDao;
import com.entity.LinyezhengceEntity;
import com.service.LinyezhengceService;
import com.entity.vo.LinyezhengceVO;
import com.entity.view.LinyezhengceView;

@Service("linyezhengceService")
public class LinyezhengceServiceImpl extends ServiceImpl<LinyezhengceDao, LinyezhengceEntity> implements LinyezhengceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LinyezhengceEntity> page = this.selectPage(
                new Query<LinyezhengceEntity>(params).getPage(),
                new EntityWrapper<LinyezhengceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LinyezhengceEntity> wrapper) {
		  Page<LinyezhengceView> page =new Query<LinyezhengceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LinyezhengceVO> selectListVO(Wrapper<LinyezhengceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LinyezhengceVO selectVO(Wrapper<LinyezhengceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LinyezhengceView> selectListView(Wrapper<LinyezhengceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LinyezhengceView selectView(Wrapper<LinyezhengceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LinyezhengceEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LinyezhengceEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LinyezhengceEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
