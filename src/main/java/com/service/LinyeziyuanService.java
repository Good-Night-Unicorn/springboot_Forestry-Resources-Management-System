package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LinyeziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LinyeziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LinyeziyuanView;


/**
 * 林业资源
 *
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
public interface LinyeziyuanService extends IService<LinyeziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LinyeziyuanVO> selectListVO(Wrapper<LinyeziyuanEntity> wrapper);
   	
   	LinyeziyuanVO selectVO(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);
   	
   	List<LinyeziyuanView> selectListView(Wrapper<LinyeziyuanEntity> wrapper);
   	
   	LinyeziyuanView selectView(@Param("ew") Wrapper<LinyeziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LinyeziyuanEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LinyeziyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LinyeziyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LinyeziyuanEntity> wrapper);



}

