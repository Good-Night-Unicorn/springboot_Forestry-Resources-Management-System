package com.dao;

import com.entity.ZhengceleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhengceleixingVO;
import com.entity.view.ZhengceleixingView;


/**
 * 政策类型
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface ZhengceleixingDao extends BaseMapper<ZhengceleixingEntity> {
	
	List<ZhengceleixingVO> selectListVO(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);
	
	ZhengceleixingVO selectVO(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);
	
	List<ZhengceleixingView> selectListView(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);

	List<ZhengceleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);

	
	ZhengceleixingView selectView(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);
	

}
