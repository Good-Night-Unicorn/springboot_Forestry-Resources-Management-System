package com.dao;

import com.entity.KaifaqiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaifaqiyeVO;
import com.entity.view.KaifaqiyeView;


/**
 * 开发企业
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifaqiyeDao extends BaseMapper<KaifaqiyeEntity> {
	
	List<KaifaqiyeVO> selectListVO(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);
	
	KaifaqiyeVO selectVO(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);
	
	List<KaifaqiyeView> selectListView(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);

	List<KaifaqiyeView> selectListView(Pagination page,@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);

	
	KaifaqiyeView selectView(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);
	

}
