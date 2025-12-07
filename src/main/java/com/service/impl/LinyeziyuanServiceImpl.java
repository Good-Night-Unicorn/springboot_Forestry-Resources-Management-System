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


import com.dao.LinyeziyuanDao;
import com.entity.LinyeziyuanEntity;
import com.service.LinyeziyuanService;
import com.entity.vo.LinyeziyuanVO;
import com.entity.view.LinyeziyuanView;

@Service("linyeziyuanService")
public class LinyeziyuanServiceImpl extends ServiceImpl<LinyeziyuanDao, LinyeziyuanEntity> implements LinyeziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LinyeziyuanEntity> page = this.selectPage(
                new Query<LinyeziyuanEntity>(params).getPage(),
                new EntityWrapper<LinyeziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LinyeziyuanEntity> wrapper) {
		  Page<LinyeziyuanView> page =new Query<LinyeziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LinyeziyuanVO> selectListVO(Wrapper<LinyeziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LinyeziyuanVO selectVO(Wrapper<LinyeziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LinyeziyuanView> selectListView(Wrapper<LinyeziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LinyeziyuanView selectView(Wrapper<LinyeziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LinyeziyuanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LinyeziyuanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LinyeziyuanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
