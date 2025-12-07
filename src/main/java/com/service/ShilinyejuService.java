package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShilinyejuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShilinyejuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShilinyejuView;


/**
 * 市林业局
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface ShilinyejuService extends IService<ShilinyejuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShilinyejuVO> selectListVO(Wrapper<ShilinyejuEntity> wrapper);
   	
   	ShilinyejuVO selectVO(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);
   	
   	List<ShilinyejuView> selectListView(Wrapper<ShilinyejuEntity> wrapper);
   	
   	ShilinyejuView selectView(@Param("ew") Wrapper<ShilinyejuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShilinyejuEntity> wrapper);

   	

}

