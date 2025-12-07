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


import com.dao.KaifajihuashenqingDao;
import com.entity.KaifajihuashenqingEntity;
import com.service.KaifajihuashenqingService;
import com.entity.vo.KaifajihuashenqingVO;
import com.entity.view.KaifajihuashenqingView;

@Service("kaifajihuashenqingService")
public class KaifajihuashenqingServiceImpl extends ServiceImpl<KaifajihuashenqingDao, KaifajihuashenqingEntity> implements KaifajihuashenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaifajihuashenqingEntity> page = this.selectPage(
                new Query<KaifajihuashenqingEntity>(params).getPage(),
                new EntityWrapper<KaifajihuashenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaifajihuashenqingEntity> wrapper) {
		  Page<KaifajihuashenqingView> page =new Query<KaifajihuashenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KaifajihuashenqingVO> selectListVO(Wrapper<KaifajihuashenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaifajihuashenqingVO selectVO(Wrapper<KaifajihuashenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaifajihuashenqingView> selectListView(Wrapper<KaifajihuashenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaifajihuashenqingView selectView(Wrapper<KaifajihuashenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KaifajihuashenqingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KaifajihuashenqingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KaifajihuashenqingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
