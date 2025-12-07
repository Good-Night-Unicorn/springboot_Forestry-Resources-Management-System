package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.LinyeziyuanEntity;
import com.entity.view.LinyeziyuanView;

import com.service.LinyeziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 林业资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-31 16:18:21
 */
@RestController
@RequestMapping("/linyeziyuan")
public class LinyeziyuanController {
    @Autowired
    private LinyeziyuanService linyeziyuanService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LinyeziyuanEntity linyeziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
			linyeziyuan.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();



		PageUtils page = linyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linyeziyuan), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LinyeziyuanEntity linyeziyuan, 
		HttpServletRequest request){
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();

		PageUtils page = linyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linyeziyuan), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LinyeziyuanEntity linyeziyuan){
       	EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( linyeziyuan, "linyeziyuan")); 
        return R.ok().put("data", linyeziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LinyeziyuanEntity linyeziyuan){
        EntityWrapper< LinyeziyuanEntity> ew = new EntityWrapper< LinyeziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( linyeziyuan, "linyeziyuan")); 
		LinyeziyuanView linyeziyuanView =  linyeziyuanService.selectView(ew);
		return R.ok("查询林业资源成功").put("data", linyeziyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LinyeziyuanEntity linyeziyuan = linyeziyuanService.selectById(id);
		linyeziyuan.setClicknum(linyeziyuan.getClicknum()+1);
		linyeziyuanService.updateById(linyeziyuan);
        linyeziyuan = linyeziyuanService.selectView(new EntityWrapper<LinyeziyuanEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(linyeziyuan,deSens);
        return R.ok().put("data", linyeziyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LinyeziyuanEntity linyeziyuan = linyeziyuanService.selectById(id);
		linyeziyuan.setClicknum(linyeziyuan.getClicknum()+1);
		linyeziyuanService.updateById(linyeziyuan);
        linyeziyuan = linyeziyuanService.selectView(new EntityWrapper<LinyeziyuanEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(linyeziyuan,deSens);
        return R.ok().put("data", linyeziyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增林业资源") 
    public R save(@RequestBody LinyeziyuanEntity linyeziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(linyeziyuan);
        linyeziyuanService.insert(linyeziyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增林业资源")
    @RequestMapping("/add")
    public R add(@RequestBody LinyeziyuanEntity linyeziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(linyeziyuan);
        linyeziyuanService.insert(linyeziyuan);
        return R.ok().put("data",linyeziyuan.getId());
    }

    /**
     * 批量生成数据
     */
    @RequestMapping("/batch/gen")
    @SysLog("批量生成数据")
    public R batch(int recordNum){
        List<LinyeziyuanEntity> list = linyeziyuanService.selectList(new EntityWrapper<LinyeziyuanEntity>().last("order by rand() limit 50"));
        if(list!=null && list.size()>0 && recordNum>0) {
            List<LinyeziyuanEntity> batchList = new ArrayList<LinyeziyuanEntity>(recordNum);
            int max = list.size();
            Random random = new Random();
            for(int i=0;i<recordNum;i++) {
                LinyeziyuanEntity linyeziyuan = new LinyeziyuanEntity();
               linyeziyuan.setLindimingcheng(list.get(random.nextInt(max)).getLindimingcheng());
               linyeziyuan.setLindileixing(list.get(random.nextInt(max)).getLindileixing());
               linyeziyuan.setQuyu(list.get(random.nextInt(max)).getQuyu());
               linyeziyuan.setLindimianji(list.get(random.nextInt(max)).getLindimianji());
               linyeziyuan.setLinzhongleixing(list.get(random.nextInt(max)).getLinzhongleixing());
               linyeziyuan.setSenlinfugailv(list.get(random.nextInt(max)).getSenlinfugailv());
               linyeziyuan.setLinmuxujiliang(list.get(random.nextInt(max)).getLinmuxujiliang());
               linyeziyuan.setShenqingzhuangtai(list.get(random.nextInt(max)).getShenqingzhuangtai());
               linyeziyuan.setLinditupian(list.get(random.nextInt(max)).getLinditupian());
               linyeziyuan.setLinyejumingcheng(list.get(random.nextInt(max)).getLinyejumingcheng());
               linyeziyuan.setClicktime(list.get(random.nextInt(max)).getClicktime());
               linyeziyuan.setClicknum(list.get(random.nextInt(max)).getClicknum());
               linyeziyuan.setStoreupnum(list.get(random.nextInt(max)).getStoreupnum());
                batchList.add(linyeziyuan);
            }
            linyeziyuanService.insertBatch(batchList);
        }
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改林业资源")
    public R update(@RequestBody LinyeziyuanEntity linyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(linyeziyuan);
        //全部更新
        linyeziyuanService.updateById(linyeziyuan);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除林业资源")
    public R delete(@RequestBody Long[] ids){
        linyeziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LinyeziyuanEntity linyeziyuan, HttpServletRequest request,String pre){
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = linyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linyeziyuan), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,LinyeziyuanEntity linyeziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "linyeziyuan"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity storeup : storeups) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(storeup.getUserid().toString())) {
                    userRatings = ratings.get(storeup.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(storeup.getUserid().toString(), userRatings);
                }

                if(userRatings.containsKey(storeup.getRefid().toString())) {
                    userRatings.put(storeup.getRefid().toString(), userRatings.get(storeup.getRefid().toString())+1.0);
                } else {
                    userRatings.put(storeup.getRefid().toString(), 1.0);
                }
            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = linyeziyuanService.queryPage(params, ew);
        List<LinyeziyuanEntity> pageList = (List<LinyeziyuanEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<LinyeziyuanEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(linyeziyuanService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }



    @RequestMapping("/importExcel")
    @SysLog("导入林业资源")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    LinyeziyuanEntity linyeziyuanEntity =new LinyeziyuanEntity();
                    linyeziyuanEntity.setId(new Date().getTime());
                    String lindimingcheng = CommonUtil.getCellValue(row.getCell(0));
                    linyeziyuanEntity.setLindimingcheng(lindimingcheng);
                    String lindileixing = CommonUtil.getCellValue(row.getCell(1));
                    linyeziyuanEntity.setLindileixing(lindileixing);
                    String quyu = CommonUtil.getCellValue(row.getCell(2));
                    linyeziyuanEntity.setQuyu(quyu);
                    String lindimianji = CommonUtil.getCellValue(row.getCell(3));
                    linyeziyuanEntity.setLindimianji(lindimianji);
                    String linzhongleixing = CommonUtil.getCellValue(row.getCell(4));
                    linyeziyuanEntity.setLinzhongleixing(linzhongleixing);
                    String senlinfugailv = CommonUtil.getCellValue(row.getCell(5));
                    linyeziyuanEntity.setSenlinfugailv(Double.parseDouble(senlinfugailv));
                    String linmuxujiliang = CommonUtil.getCellValue(row.getCell(6));
                    linyeziyuanEntity.setLinmuxujiliang(Double.parseDouble(linmuxujiliang));
                    String shenqingzhuangtai = CommonUtil.getCellValue(row.getCell(7));
                    linyeziyuanEntity.setShenqingzhuangtai(shenqingzhuangtai);
                    String linditupian = CommonUtil.getCellValue(row.getCell(8));
                    linyeziyuanEntity.setLinditupian(linditupian);
                    String linyejumingcheng = CommonUtil.getCellValue(row.getCell(9));
                    linyeziyuanEntity.setLinyejumingcheng(linyejumingcheng);
                     
                    //想数据库中添加新对象
                    linyeziyuanService.insert(linyeziyuanEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }



        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = linyeziyuanService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = linyeziyuanService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = linyeziyuanService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = linyeziyuanService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            ew.eq("linyejumingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = linyeziyuanService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }



    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,LinyeziyuanEntity linyeziyuan, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("shilinyeju")) {
            linyeziyuan.setLinyejumingcheng((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<LinyeziyuanEntity> ew = new EntityWrapper<LinyeziyuanEntity>();
        int count = linyeziyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linyeziyuan), params), params));
        return R.ok().put("data", count);
    }



}
