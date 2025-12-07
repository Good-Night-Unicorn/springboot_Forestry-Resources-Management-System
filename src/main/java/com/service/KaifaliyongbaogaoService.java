package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifaliyongbaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaifaliyongbaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaifaliyongbaogaoView;


/**
 * 开发利用报告
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface KaifaliyongbaogaoService extends IService<KaifaliyongbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaifaliyongbaogaoVO> selectListVO(Wrapper<KaifaliyongbaogaoEntity> wrapper);
   	
   	KaifaliyongbaogaoVO selectVO(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);
   	
   	List<KaifaliyongbaogaoView> selectListView(Wrapper<KaifaliyongbaogaoEntity> wrapper);
   	
   	KaifaliyongbaogaoView selectView(@Param("ew") Wrapper<KaifaliyongbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaifaliyongbaogaoEntity> wrapper);

   	

}

