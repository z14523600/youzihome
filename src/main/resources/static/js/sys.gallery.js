//点击进入详情页
function loadPhotoDtl(gallery_id){
    var dataObj={gallery_id:gallery_id}
    $("#hd_gallery_id").val(gallery_id);
    getHtmlAJ('page_content_div','/sysadmin/getPhotoByGalleryId',dataObj);
}

//删除照片
function delPhoto(photo_id){
    if(confirm("确定要删除吗？")){
        var dataObj={photo_id:photo_id}
        getJsonAJ('/sysadmin/delPhotoById',dataObj,"删除成功！");
        loadPhotoDtl($("#hd_gallery_id").val());
    }

}