package com.hr.crm.workbench.dao;


import com.hr.crm.workbench.domain.Activity;
import com.hr.crm.workbench.domain.Temp;

import java.util.List;
import java.util.Map;

public interface ActivityDao {

    List<Activity> getActivityListByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);

    void UpdateEqual1(Map<String, Object> map);

    void UpdateEqual2(Map<String, Object> map);


    void UpdateEqual3(Map<String, Object> map);

    void UpdateEqual4(Map<String, Object> map);

    void UpdateEqualNearly1(Map<String, Object> map);

    void UpdateEqualNearly2(Map<String, Object> map);

    void UpdateEqualNearly3(Map<String, Object> map);

    void UpdateEqualNearly4(Map<String, Object> map);

    List<Temp> getjointureListByCondition(Map<String, Object> map);
}
