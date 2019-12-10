package com.kzki.youzihome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SysAdmMainController {

    //后台首页
    @RequestMapping("sysadmin/main")
    public ModelAndView loadSysMain(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","youzi");
        mav.setViewName("sysadmin/main");
        return mav;
    }
}
