package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifaqiyeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaifaqiyeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaifaqiyeView;


/**
 * 开发企业
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifaqiyeService extends IService<KaifaqiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaifaqiyeVO> selectListVO(Wrapper<KaifaqiyeEntity> wrapper);
   	
   	KaifaqiyeVO selectVO(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);
   	
   	List<KaifaqiyeView> selectListView(Wrapper<KaifaqiyeEntity> wrapper);
   	
   	KaifaqiyeView selectView(@Param("ew") Wrapper<KaifaqiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaifaqiyeEntity> wrapper);

   	

}

