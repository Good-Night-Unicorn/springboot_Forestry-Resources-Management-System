package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifajihuashenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaifajihuashenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaifajihuashenqingView;


/**
 * 开发计划申请
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifajihuashenqingService extends IService<KaifajihuashenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaifajihuashenqingVO> selectListVO(Wrapper<KaifajihuashenqingEntity> wrapper);
   	
   	KaifajihuashenqingVO selectVO(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);
   	
   	List<KaifajihuashenqingView> selectListView(Wrapper<KaifajihuashenqingEntity> wrapper);
   	
   	KaifajihuashenqingView selectView(@Param("ew") Wrapper<KaifajihuashenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaifajihuashenqingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KaifajihuashenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KaifajihuashenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KaifajihuashenqingEntity> wrapper);



}

