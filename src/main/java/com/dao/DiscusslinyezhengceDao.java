package com.dao;

import com.entity.DiscusslinyezhengceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslinyezhengceVO;
import com.entity.view.DiscusslinyezhengceView;


/**
 * 林业政策评论表
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:23
 */
public interface DiscusslinyezhengceDao extends BaseMapper<DiscusslinyezhengceEntity> {
	
	List<DiscusslinyezhengceVO> selectListVO(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);
	
	DiscusslinyezhengceVO selectVO(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);
	
	List<DiscusslinyezhengceView> selectListView(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);

	List<DiscusslinyezhengceView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);

	
	DiscusslinyezhengceView selectView(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);
	

}
