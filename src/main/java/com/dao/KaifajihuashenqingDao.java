package com.dao;

import com.entity.KaifajihuashenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaifajihuashenqingVO;
import com.entity.view.KaifajihuashenqingView;


/**
 * 开发计划申请
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifajihuashenqingDao extends BaseMapper<KaifajihuashenqingEntity> {
	
	List<KaifajihuashenqingVO> selectListVO(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);
	
	KaifajihuashenqingVO selectVO(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);
	
	List<KaifajihuashenqingView> selectListView(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);

	List<KaifajihuashenqingView> selectListView(Pagination page,@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);

	
	KaifajihuashenqingView selectView(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);



}
