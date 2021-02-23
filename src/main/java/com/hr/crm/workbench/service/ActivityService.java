package com.hr.crm.workbench.service;


import com.hr.crm.vo.PaginationVO;
import com.hr.crm.workbench.domain.Activity;
import com.hr.crm.workbench.domain.Temp;

import java.util.Map;

public interface ActivityService {

    PaginationVO<Activity> pageList(Map<String, Object> map);

    PaginationVO<Temp> jointureList(Map<String, Object> map);
}
