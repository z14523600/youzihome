package com.kzki.youzihome.controller;

import com.kzki.youzihome.util.UploadResp;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
public class UploadController {

    //上传图片
    @RequestMapping("/upload/image")
    @ResponseBody
    public UploadResp upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, ModelMap model) {
        UploadResp uploadResp = new UploadResp();

        /* 获取上传文件的后缀 */
        String suffix = multipartFile.getOriginalFilename().substring (multipartFile.getOriginalFilename().lastIndexOf("."));
        /* 保存文件名称 */
        String logImageName = UUID.randomUUID().toString()+ suffix;
        /* 构建图片保存的目录 */
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String logoPathDir = "/static/gallery";//+ dateformat.format(System.currentTimeMillis());
        /* 返回相对路径给客户端 */
        uploadResp.setName(logoPathDir+"/"+logImageName);

        /* 得到图片保存目录的真实路径 */
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(logoRealPathDir);
        if(!logoSaveFile.exists()) logoSaveFile.mkdirs();

        //构建文件名称
        //String logImageName = multipartFile.getOriginalFilename();
        /**拼成完整的文件保存路径加文件**/
        String fileName = logoRealPathDir + File.separator + logImageName;
        try {
            File file = new File(fileName);
            multipartFile.transferTo(file);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace(); }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return uploadResp;
    }


}
