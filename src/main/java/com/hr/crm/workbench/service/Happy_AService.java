package com.hr.crm.workbench.service;

import com.hr.crm.vo.PaginationVO;

import com.hr.crm.workbench.domain.Happy_A;

import java.util.Map;

public interface Happy_AService {
    PaginationVO<Happy_A> pageList(Map<String, Object> map);
}
