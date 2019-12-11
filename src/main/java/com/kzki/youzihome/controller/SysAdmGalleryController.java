package com.kzki.youzihome.controller;

import com.kzki.youzihome.entity.MapperData;
import com.kzki.youzihome.service.BaseService;
import com.kzki.youzihome.util.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class SysAdmGalleryController {

    @Autowired
    private BaseService baseService;

    //相册首页
    @ResponseBody
    @RequestMapping("/sysadmin/gallery")
    public ModelAndView locateGalleryFront(){
        ModelAndView mav=new ModelAndView();
        ArrayList<HashMap> galleryList=baseService.getDataList("GalleryMapper.getGalleryList",null);
        mav.addObject("galleryList",galleryList);
        mav.setViewName("sysadmin/gallery");
        return mav;
    }


    //照片页
    @ResponseBody
    @RequestMapping("/sysadmin/getPhotoByGalleryId")
    public ModelAndView getPhotoByGalleryId(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        DataMap dm=new DataMap(request);
        ArrayList<HashMap> photoList=baseService.getDataList("GalleryMapper.getPhotoByGalleryId",dm);
        mav.addObject("photoList",photoList);
        mav.setViewName("sysadmin/photo");
        return mav;
    }

    //删除照片
    @ResponseBody
    @RequestMapping("/sysadmin/delPhotoById")
    public String delPhotoById(HttpServletRequest request){
        DataMap dm=new DataMap(request);
        boolean delPhotoStatus=baseService.executeBaseData("GalleryMapper.delPhotoById",dm,"delete");

        return delPhotoStatus==true?"success":"error";
    }


    @ResponseBody
    @RequestMapping("/sysadmin/upload")
    public String upload(HttpServletRequest request){
        DataMap dm=new DataMap(request);
        boolean delPhotoStatus=baseService.executeBaseData("GalleryMapper.delPhotoById",dm,"delete");

        return delPhotoStatus==true?"success":"error";
    }

}
