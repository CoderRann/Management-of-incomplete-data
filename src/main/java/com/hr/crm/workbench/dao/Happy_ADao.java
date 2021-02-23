package com.hr.crm.workbench.dao;


import com.hr.crm.workbench.domain.Happy_A;

import java.util.List;
import java.util.Map;

public interface Happy_ADao {

    int getTotalByCondition(Map<String, Object> map);

    void UpdateEqual4(Map<String, Object> map);

    void UpdateEqual3(Map<String, Object> map);

    void UpdateEqual2(Map<String, Object> map);

    void UpdateEqual1(Map<String, Object> map);

    void UpdateEqualNearly4(Map<String, Object> map);

    void UpdateEqualNearly3(Map<String, Object> map);

    void UpdateEqualNearly2(Map<String, Object> map);

    void UpdateEqualNearly1(Map<String, Object> map);

    List<Happy_A> getHappy_AListByCondition(Map<String, Object> map);
}
