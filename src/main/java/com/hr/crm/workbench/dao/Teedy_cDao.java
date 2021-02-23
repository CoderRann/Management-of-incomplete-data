package com.hr.crm.workbench.dao;

import com.hr.crm.workbench.domain.Teedy_c;

import java.util.List;
import java.util.Map;

public interface Teedy_cDao {

    int getTotalByCondition(Map<String, Object> map);

    void UpdateEqual4(Map<String, Object> map);

    void UpdateEqual3(Map<String, Object> map);

    void UpdateEqual2(Map<String, Object> map);

    void UpdateEqual1(Map<String, Object> map);

    void UpdateEqualNearly4(Map<String, Object> map);

    void UpdateEqualNearly3(Map<String, Object> map);

    void UpdateEqualNearly2(Map<String, Object> map);

    void UpdateEqualNearly1(Map<String, Object> map);

    List<Teedy_c> getTeedy_cListByCondition(Map<String, Object> map);
}
