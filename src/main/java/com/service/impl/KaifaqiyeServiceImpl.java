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


import com.dao.KaifaqiyeDao;
import com.entity.KaifaqiyeEntity;
import com.service.KaifaqiyeService;
import com.entity.vo.KaifaqiyeVO;
import com.entity.view.KaifaqiyeView;

@Service("kaifaqiyeService")
public class KaifaqiyeServiceImpl extends ServiceImpl<KaifaqiyeDao, KaifaqiyeEntity> implements KaifaqiyeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaifaqiyeEntity> page = this.selectPage(
                new Query<KaifaqiyeEntity>(params).getPage(),
                new EntityWrapper<KaifaqiyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaifaqiyeEntity> wrapper) {
		  Page<KaifaqiyeView> page =new Query<KaifaqiyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KaifaqiyeVO> selectListVO(Wrapper<KaifaqiyeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaifaqiyeVO selectVO(Wrapper<KaifaqiyeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaifaqiyeView> selectListView(Wrapper<KaifaqiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaifaqiyeView selectView(Wrapper<KaifaqiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
