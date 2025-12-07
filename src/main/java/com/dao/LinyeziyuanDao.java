package com.dao;

import com.entity.LinyeziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LinyeziyuanVO;
import com.entity.view.LinyeziyuanView;


/**
 * 林业资源
 * 
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface LinyeziyuanDao extends BaseMapper<LinyeziyuanEntity> {
	
	List<LinyeziyuanVO> selectListVO(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);
	
	LinyeziyuanVO selectVO(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);
	
	List<LinyeziyuanView> selectListView(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);

	List<LinyeziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);

	
	LinyeziyuanView selectView(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);



}
