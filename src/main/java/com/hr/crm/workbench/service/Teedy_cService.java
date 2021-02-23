package com.hr.crm.workbench.service;

import com.hr.crm.vo.PaginationVO;

import com.hr.crm.workbench.domain.Teedy_c;

import java.util.Map;

public interface Teedy_cService {
    PaginationVO<Teedy_c> pageList(Map<String, Object> map);
}
