package com.kzki.youzihome.controller;

import com.kzki.youzihome.entity.MapperData;
import com.kzki.youzihome.service.BaseService;
import com.kzki.youzihome.util.DataMap;
import com.kzki.youzihome.util.UploadResp;
import com.kzki.youzihome.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

    //上传后保存图片
    @ResponseBody
    @RequestMapping("/sysadmin/savePhotoByGalleryId")
    public String savePhotoByGalleryId(HttpServletRequest request){
        String gallery_id=request.getParameter("gallery_id");
        ArrayList<MapperData> mdlist=new ArrayList<MapperData>();
        String photoArryJson=request.getParameter("photo_arry");
        List<UploadResp> urlist=JsonUtil.jsonToList((String) photoArryJson,UploadResp.class);
        for(UploadResp ur:urlist){
            DataMap dm=new DataMap();
            dm.put("gallery_id",gallery_id);
            dm.put("name",ur.getName());
            mdlist.add(new MapperData("save","GalleryMapper.savePhotoByGalleryId",dm));
        }

        boolean savePhotoStatus=baseService.executeBaseDataTran(mdlist);

        return savePhotoStatus==true?"success":"error";

    }

}
