package com.dao;

import com.entity.KaifaliyongbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaifaliyongbaogaoVO;
import com.entity.view.KaifaliyongbaogaoView;


/**
 * 开发利用报告
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifaliyongbaogaoDao extends BaseMapper<KaifaliyongbaogaoEntity> {
	
	List<KaifaliyongbaogaoVO> selectListVO(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);
	
	KaifaliyongbaogaoVO selectVO(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);
	
	List<KaifaliyongbaogaoView> selectListView(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);

	List<KaifaliyongbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);

	
	KaifaliyongbaogaoView selectView(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);
	

}
