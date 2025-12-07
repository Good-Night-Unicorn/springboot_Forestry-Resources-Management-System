package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhengceshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhengceshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengceshenqingView;


/**
 * 政策申请
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:22
 */
public interface ZhengceshenqingService extends IService<ZhengceshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengceshenqingVO> selectListVO(Wrapper<ZhengceshenqingEntity> wrapper);
   	
   	ZhengceshenqingVO selectVO(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);
   	
   	List<ZhengceshenqingView> selectListView(Wrapper<ZhengceshenqingEntity> wrapper);
   	
   	ZhengceshenqingView selectView(@Param("ew") Wrapper<ZhengceshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengceshenqingEntity> wrapper);

   	

}

