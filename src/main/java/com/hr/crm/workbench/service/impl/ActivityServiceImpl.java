package com.hr.crm.workbench.service.impl;



import com.hr.crm.settings.dao.UserDao;
import com.hr.crm.utils.SqlSessionUtil;
import com.hr.crm.vo.PaginationVO;
import com.hr.crm.workbench.dao.ActivityDao;
import com.hr.crm.workbench.domain.Activity;
import com.hr.crm.workbench.domain.Temp;
import com.hr.crm.workbench.service.ActivityService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);


    @Override
    public PaginationVO<Activity> pageList(Map<String, Object> map) {

        int total = activityDao.getTotalByCondition(map);

        String tKey = getKey(map,map.get("g_r"));
        if(map.get("g_r")!="" && map.get(tKey)!=""){
            activityDao.UpdateEqual1(map);
            activityDao.UpdateEqual2(map);
            activityDao.UpdateEqual3(map);
            activityDao.UpdateEqual4(map);


            activityDao.UpdateEqualNearly1(map);
            activityDao.UpdateEqualNearly2(map);
            activityDao.UpdateEqualNearly3(map);
            activityDao.UpdateEqualNearly4(map);

        }


        List<Activity>  dataList = activityDao.getActivityListByCondition(map);

        PaginationVO<Activity> vo = new PaginationVO<Activity>();

        vo.setDataList(dataList);
        vo.setTotal(total);

        return vo;
    }

    @Override
    public PaginationVO<Temp> jointureList(Map<String, Object> map) {
        int total = activityDao.getTotalByCondition(map);

        List<Temp> dataList = activityDao.getjointureListByCondition(map);

        PaginationVO<Temp> vo = new PaginationVO<Temp>();

        vo.setDataList(dataList);
        vo.setTotal(total);

        return vo;
    }

    public static String getKey(Map map, Object value){
        String a = "";

        List<Object> keyList = new ArrayList<Object>();
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }

        for(int i = 0;i < keyList.size();i++){
             a = keyList.get(i).toString();
        }
        return a;
    }
}






















