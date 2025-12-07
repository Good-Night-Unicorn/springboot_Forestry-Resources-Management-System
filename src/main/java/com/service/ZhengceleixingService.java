package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhengceleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhengceleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengceleixingView;


/**
 * 政策类型
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface ZhengceleixingService extends IService<ZhengceleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengceleixingVO> selectListVO(Wrapper<ZhengceleixingEntity> wrapper);
   	
   	ZhengceleixingVO selectVO(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);
   	
   	List<ZhengceleixingView> selectListView(Wrapper<ZhengceleixingEntity> wrapper);
   	
   	ZhengceleixingView selectView(@Param("ew") Wrapper<ZhengceleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengceleixingEntity> wrapper);

   	

}

