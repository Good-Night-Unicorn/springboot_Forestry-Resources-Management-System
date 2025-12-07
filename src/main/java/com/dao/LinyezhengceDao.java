package com.dao;

import com.entity.LinyezhengceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LinyezhengceVO;
import com.entity.view.LinyezhengceView;


/**
 * 林业政策
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface LinyezhengceDao extends BaseMapper<LinyezhengceEntity> {
	
	List<LinyezhengceVO> selectListVO(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);
	
	LinyezhengceVO selectVO(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);
	
	List<LinyezhengceView> selectListView(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);

	List<LinyezhengceView> selectListView(Pagination page,@Param("ew") Wrapper<LinyezhengceEntity> wrapper);

	
	LinyezhengceView selectView(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyezhengceEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyezhengceEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyezhengceEntity> wrapper);



}
