package com.hr.crm.workbench.service.impl;


import com.hr.crm.utils.SqlSessionUtil;
import com.hr.crm.vo.PaginationVO;

import com.hr.crm.workbench.dao.Happy_ADao;
import com.hr.crm.workbench.domain.Happy_A;
import com.hr.crm.workbench.service.Happy_AService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Happy_AServiceImpl implements Happy_AService {

    private Happy_ADao happy_aDao = SqlSessionUtil.getSqlSession().getMapper(Happy_ADao.class);

    @Override
    public PaginationVO<Happy_A> pageList(Map<String, Object> map) {
        int total = happy_aDao.getTotalByCondition(map);

        String tKey = getKey(map,map.get("g_r"));
        if(map.get("g_r")!="" && map.get(tKey)!=""){
            happy_aDao.UpdateEqual1(map);
            happy_aDao.UpdateEqual2(map);
            happy_aDao.UpdateEqual3(map);
            happy_aDao.UpdateEqual4(map);


            happy_aDao.UpdateEqualNearly1(map);
            happy_aDao.UpdateEqualNearly2(map);
            happy_aDao.UpdateEqualNearly3(map);
            happy_aDao.UpdateEqualNearly4(map);

        }

        List<Happy_A> dataList = happy_aDao.getHappy_AListByCondition(map);

        PaginationVO<Happy_A> vo = new PaginationVO<Happy_A>();

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

