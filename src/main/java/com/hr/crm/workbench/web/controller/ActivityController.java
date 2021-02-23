package com.hr.crm.workbench.web.controller;

import com.hr.crm.settings.domain.User;
import com.hr.crm.settings.service.UserService;
import com.hr.crm.settings.service.impl.UserServiceImpl;
import com.hr.crm.utils.MD5Util;
import com.hr.crm.utils.PrintJson;
import com.hr.crm.utils.ServiceFactory;
import com.hr.crm.utils.SqlSessionUtil;
import com.hr.crm.vo.PaginationVO;
import com.hr.crm.workbench.dao.ActivityDao;
import com.hr.crm.workbench.domain.Activity;
import com.hr.crm.workbench.domain.Temp;
import com.hr.crm.workbench.service.ActivityService;
import com.hr.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityController extends HttpServlet {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到市场活动控制器");

        String path = request.getServletPath();

        if ("/workbench/activity/getUserList.do".equals(path)){
           getUserList(request,response);
        }else if ("/workbench/activity/pageList.do".equals(path)){
            pageList(request,response);
        }else if ("/workbench/jointure/pageList.do".equals(path)){
            jointureList(request,response);
        }
    }

    private void jointureList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("jointure");


        String id = request.getParameter("id");

        String mag_r = request.getParameter("mag_r");
        String u_g = request.getParameter("u_g");
        String g_r = request.getParameter("g_r");
        String pageNoStr = request.getParameter("pageNo");


        int pageNo = Integer.valueOf(pageNoStr);
        //每页展现记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        //略过记录数
        int skipCount = (pageNo-1)*pageSize;

        //传到dao层打包数据(map)
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("mag_r",mag_r);
        map.put("u_g",u_g);
        map.put("g_r",g_r);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        PaginationVO<Temp> vo = as.jointureList(map);

        PrintJson.printJsonObj(response,vo);

    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("activity infos");

        String id = request.getParameter("id");

        String mag_r = request.getParameter("mag_r");
        String u_g = request.getParameter("u_g");
        String g_r = request.getParameter("g_r");
        String pageNoStr = request.getParameter("pageNo");


        int pageNo = Integer.valueOf(pageNoStr);
        //每页展现记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        //略过记录数
        int skipCount = (pageNo-1)*pageSize;

        //传到dao层打包数据(map)
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("mag_r",mag_r);
        map.put("u_g",u_g);
        map.put("g_r",g_r);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        PaginationVO<Activity> vo = as.pageList(map);


        PrintJson.printJsonObj(response,vo);

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("user list");

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = us.getUserList();

        PrintJson.printJsonObj(response,uList);
    }


}























































































