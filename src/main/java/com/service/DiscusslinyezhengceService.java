package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslinyezhengceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslinyezhengceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslinyezhengceView;


/**
 * 林业政策评论表
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:23
 */
public interface DiscusslinyezhengceService extends IService<DiscusslinyezhengceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslinyezhengceVO> selectListVO(Wrapper<DiscusslinyezhengceEntity> wrapper);
   	
   	DiscusslinyezhengceVO selectVO(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);
   	
   	List<DiscusslinyezhengceView> selectListView(Wrapper<DiscusslinyezhengceEntity> wrapper);
   	
   	DiscusslinyezhengceView selectView(@Param("ew") Wrapper<DiscusslinyezhengceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslinyezhengceEntity> wrapper);

   	

}

