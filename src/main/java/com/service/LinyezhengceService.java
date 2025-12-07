package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LinyezhengceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LinyezhengceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LinyezhengceView;


/**
 * 林业政策
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface LinyezhengceService extends IService<LinyezhengceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LinyezhengceVO> selectListVO(Wrapper<LinyezhengceEntity> wrapper);
   	
   	LinyezhengceVO selectVO(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);
   	
   	List<LinyezhengceView> selectListView(Wrapper<LinyezhengceEntity> wrapper);
   	
   	LinyezhengceView selectView(@Param("ew") Wrapper<LinyezhengceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LinyezhengceEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LinyezhengceEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LinyezhengceEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LinyezhengceEntity> wrapper);



}

