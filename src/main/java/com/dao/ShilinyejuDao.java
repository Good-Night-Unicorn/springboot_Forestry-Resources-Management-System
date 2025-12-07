package com.dao;

import com.entity.ShilinyejuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShilinyejuVO;
import com.entity.view.ShilinyejuView;


/**
 * 市林业局
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface ShilinyejuDao extends BaseMapper<ShilinyejuEntity> {
	
	List<ShilinyejuVO> selectListVO(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);
	
	ShilinyejuVO selectVO(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);
	
	List<ShilinyejuView> selectListView(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);

	List<ShilinyejuView> selectListView(Pagination page,@Param("ew") Wrapper<ShilinyejuEntity> wrapper);

	
	ShilinyejuView selectView(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);
	

}
