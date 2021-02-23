package com.hr.crm.workbench.service.impl;


import com.hr.crm.utils.SqlSessionUtil;
import com.hr.crm.vo.PaginationVO;

import com.hr.crm.workbench.dao.Teedy_cDao;
import com.hr.crm.workbench.domain.Teedy_c;

import com.hr.crm.workbench.service.Teedy_cService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Teedy_cServiceImpl implements Teedy_cService {

    private Teedy_cDao teedy_cDao = SqlSessionUtil.getSqlSession().getMapper(Teedy_cDao.class);

    @Override
    public PaginationVO<Teedy_c> pageList(Map<String, Object> map) {
        int total = teedy_cDao.getTotalByCondition(map);

        String tKey = getKey(map,map.get("g_r"));
        if(map.get("g_r")!="" && map.get(tKey)!=""){
            teedy_cDao.UpdateEqual1(map);
            teedy_cDao.UpdateEqual2(map);
            teedy_cDao.UpdateEqual3(map);
            teedy_cDao.UpdateEqual4(map);


            teedy_cDao.UpdateEqualNearly1(map);
            teedy_cDao.UpdateEqualNearly2(map);
            teedy_cDao.UpdateEqualNearly3(map);
            teedy_cDao.UpdateEqualNearly4(map);

        }

        List<Teedy_c> dataList = teedy_cDao.getTeedy_cListByCondition(map);

        PaginationVO<Teedy_c> vo = new PaginationVO<Teedy_c>();

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

