package com.kzki.youzihome.controller;

import com.kzki.youzihome.service.BaseService;
import com.kzki.youzihome.util.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class SysAdmUserController {

    @Autowired
    private BaseService baseService;

    //登陆
    @RequestMapping(value="/sysadmin/login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        ModelAndView mav = new ModelAndView();
        //初始首页页面数据
        //mav=hCtrl.initHomepageData(mav,session);
        //Post方式访问进行登录验证
        if (request.getMethod().equalsIgnoreCase("GET")){
            mav.setViewName("sysadmin/login");
        }else{
            //进行身份验证，成功后保存用户信息到session
            if(authenticate_user(request)){
                //增加登录用户信息
                //mav.addObject("userinfo", );
                mav.setViewName("sysadmin/main");
            }else{
                mav.setViewName("sysadmin/login");
                mav.addObject("login_error_msg", "用户名或密码错误！");
            }
        }
        return mav;
    }

    //身份验证
    private boolean authenticate_user(HttpServletRequest request){
        DataMap dm=new DataMap(request);
        ArrayList<HashMap> userList=baseService.getDataList("UserMapper.getUserInfoByAcess",dm);
        if (userList.size()>0){
            request.getSession().setAttribute("userinfo",userList.get(0));
            return true;
        }else{
            return false;
        }

    }



    //用户管理首页
    @RequestMapping("/sysadmin/user")
    public ModelAndView locateGalleryFront(){
        ModelAndView mav=new ModelAndView();
        ArrayList<HashMap> userList=baseService.getDataList("UserMapper.getUserList",null);
        mav.addObject("userList",userList);
        mav.setViewName("sysadmin/user");
        return mav;
    }


}
