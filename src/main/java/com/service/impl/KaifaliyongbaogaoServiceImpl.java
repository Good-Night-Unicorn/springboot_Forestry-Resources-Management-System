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


import com.dao.KaifaliyongbaogaoDao;
import com.entity.KaifaliyongbaogaoEntity;
import com.service.KaifaliyongbaogaoService;
import com.entity.vo.KaifaliyongbaogaoVO;
import com.entity.view.KaifaliyongbaogaoView;

@Service("kaifaliyongbaogaoService")
public class KaifaliyongbaogaoServiceImpl extends ServiceImpl<KaifaliyongbaogaoDao, KaifaliyongbaogaoEntity> implements KaifaliyongbaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaifaliyongbaogaoEntity> page = this.selectPage(
                new Query<KaifaliyongbaogaoEntity>(params).getPage(),
                new EntityWrapper<KaifaliyongbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaifaliyongbaogaoEntity> wrapper) {
		  Page<KaifaliyongbaogaoView> page =new Query<KaifaliyongbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KaifaliyongbaogaoVO> selectListVO(Wrapper<KaifaliyongbaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaifaliyongbaogaoVO selectVO(Wrapper<KaifaliyongbaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaifaliyongbaogaoView> selectListView(Wrapper<KaifaliyongbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaifaliyongbaogaoView selectView(Wrapper<KaifaliyongbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
