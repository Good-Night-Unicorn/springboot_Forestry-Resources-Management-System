package com.dao;

import com.entity.ZhengceshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhengceshenqingVO;
import com.entity.view.ZhengceshenqingView;


/**
 * 政策申请
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface ZhengceshenqingDao extends BaseMapper<ZhengceshenqingEntity> {
	
	List<ZhengceshenqingVO> selectListVO(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);
	
	ZhengceshenqingVO selectVO(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);
	
	List<ZhengceshenqingView> selectListView(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);

	List<ZhengceshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);

	
	ZhengceshenqingView selectView(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);
	

}
