<#--照片列表-->
<div>
    <ul class="ace-thumbnails clearfix">

        <#list photoList as pl>
            <li>
                <a href="/static/gallery/3/${pl.photo_path}" data-rel="colorbox">
                    <img width="150" height="150" alt="150x150" src="/static/gallery/3/${pl.photo_path}" />
                    <div class="tags">
                    <span class="label-holder">
                        <span class="label label-info arrowed">fountain</span>
                    </span>

                        <span class="label-holder">
                        <span class="label label-danger">recreation</span>
                    </span>
                    </div>
                </a>

                <div class="tools tools-top">
                    <a href="#">
                        <i class="ace-icon fa fa-link"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-paperclip"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-pencil"></i>
                    </a>

                    <a href="#" onclick="delPhoto(${pl.photo_id})">
                        <i class="ace-icon fa fa-times red"></i>
                    </a>
                </div>
            </li>
        </#list>



    </ul>
</div><!-- PAGE CONTENT ENDS -->

<#--分隔栏-->
<div class="hr hr-18 dotted hr-double"></div>
<h4 class="pink">
    <i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
    <a href="#modal-table" role="button" class="green" data-toggle="modal"> 上传照片 </a>
</h4>
<div class="hr hr-18 dotted hr-double"></div>

<#--<div id="dropz" class="dropzone"></div>-->
<#--上传照片div-->
<div>
    <form  class="dropzone well" id="dropzone">
        <div class="fallback">
            <input name="file" type="file" multiple="" />
        </div>
    </form>
</div>

<#--上传按钮-->
<p>
    <button class="btn btn-white btn-info btn-bold">
        <i class="ace-icon fa fa-check-square-o bigger-120 blue"></i>
        Commit
    </button>


    <button class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-times red2"></i>
        Cancel
    </button>
</p>

<#--<p>
    <button class="btn">
        <i class="ace-icon fa fa-pencil align-top bigger-125"></i>
        Default
    </button>

    <button class="btn btn-primary">
        <i class="ace-icon fa fa-flask align-top bigger-125"></i>
        Primary
    </button>

    <button class="btn btn-info">
        Info
        <i class="ace-icon fa fa-print  align-top bigger-125 icon-on-right"></i>
    </button>
</p>-->

<div id="preview-template" class="hide">
    <div class="dz-preview dz-file-preview">
        <div class="dz-image">
            <img data-dz-thumbnail="" />
        </div>

        <div class="dz-details">
            <div class="dz-size">
                <span data-dz-size=""></span>
            </div>

            <div class="dz-filename">
                <span data-dz-name=""></span>
            </div>
        </div>

        <div class="dz-progress">
            <span class="dz-upload" data-dz-uploadprogress=""></span>
        </div>

        <div class="dz-error-message">
            <span data-dz-errormessage=""></span>
        </div>

        <div class="dz-success-mark">
            <span class="fa-stack fa-lg bigger-150">
                <i class="fa fa-circle fa-stack-2x white"></i>

                <i class="fa fa-check fa-stack-1x fa-inverse green"></i>
            </span>
        </div>

        <div class="dz-error-mark">
            <span class="fa-stack fa-lg bigger-150">
                <i class="fa fa-circle fa-stack-2x white"></i>

                <i class="fa fa-remove fa-stack-1x fa-inverse red"></i>
            </span>
        </div>
    </div>
</div>


<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($){
        try {
            Dropzone.autoDiscover = false;

            var myDropzone = new Dropzone('#dropzone', {
                previewTemplate: $('#preview-template').html(),
                url: "/upload/image",
                method: "post",  //也可用put
                paramName: "file", //默认为file

                thumbnailHeight: 120,
                thumbnailWidth: 120,
                maxFilesize: 3,

                addRemoveLinks : true,
                //dictRemoveFile: 'Remove',

                dictDefaultMessage :
                    '<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
                    <span class="smaller-80 grey">(or click)</span> <br /> \
                    <i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>'
                ,
                thumbnail: function(file, dataUrl) {
                    if (file.previewElement) {
                        $(file.previewElement).removeClass("dz-file-preview");
                        var images = $(file.previewElement).find("[data-dz-thumbnail]").each(function() {
                            var thumbnailElement = this;
                            thumbnailElement.alt = file.name;
                            thumbnailElement.src = dataUrl;
                        });
                        setTimeout(function() { $(file.previewElement).addClass("dz-image-preview"); }, 1);
                    }
                },
                init:function(){
                    this.on("success",function(file,data){
                        //上传成功触发的事件
                        console.log('ok');
                        file.status = Dropzone.SUCCESS;
                        console.log(data)
                        //上传到数据库
                        getJsonAJ("sysadmin/savePhotoByGalleryId",{gallery_id:3},"添加成功！")

                        //self.emit("success", file, 'success', null);
                        //self.emit("complete", file);
                        //self.processQueue();
                        //$("#file_id").val(data.name);
                    });
                    this.on("error",function (file,data) {
                        //上传失败触发的事件
                        console.log('fail');
                        var message = '';
                        //lavarel框架有一个表单验证，
                        //对于ajax请求，JSON 响应会发送一个 422 HTTP 状态码，
                        //对应file.accepted的值是false，在这里捕捉表单验证的错误提示
                        if (file.accepted){
                            $.each(data,function (key,val) {
                                message = message + val[0] + ';';
                            })
                            //控制器层面的错误提示，file.accepted = true的时候；
                            alert(message);
                        }
                    });
                    this.on("removedfile",function(file){
                        //删除文件时触发的方法
                        var file_id = angular.element(appElement).scope().file_id;
                        if (file_id){
                            $.post('/admin/del/'+ file_id,{'_method':'DELETE'},function (data) {
                                console.log('删除结果:'+data.message);
                            })
                        }
                        angular.element(appElement).scope().file_id = 0;
                        document.querySelector('div .dz-default').style.display = 'block';
                    });
                }

            });


            //simulating upload progress
            var minSteps = 6,
                maxSteps = 60,
                timeBetweenSteps = 100,
                bytesPerStep = 100000;


 /*           myDropzone.uploadFiles = function(files) {
                var self = this;

                for (var i = 0; i < files.length; i++) {
                    var file = files[i];
                    console.log(file)
                    getJsonAJ("/upload/image","",file);
                    totalSteps = Math.round(Math.min(maxSteps, Math.max(minSteps, file.size / bytesPerStep)));

                    for (var step = 0; step < totalSteps; step++) {
                        var duration = timeBetweenSteps * (step + 1);
                        setTimeout(function(file, totalSteps, step) {
                            return function() {
                                file.upload = {
                                    progress: 100 * (step + 1) / totalSteps,
                                    total: file.size,
                                    bytesSent: (step + 1) * file.size / totalSteps
                                };

                                self.emit('uploadprogress', file, file.upload.progress, file.upload.bytesSent);
                                if (file.upload.progress == 100) {
                                    file.status = Dropzone.SUCCESS;
                                    self.emit("success", file, 'success', null);
                                    self.emit("complete", file);
                                    self.processQueue();
                                }
                            };
                        }(file, totalSteps, step), duration);
                    }
                }
            }*/

            //remove dropzone instance when leaving this page in ajax mode
            $(document).one('ajaxloadstart.page', function(e) {
                try {
                    myDropzone.destroy();
                } catch(e) {}
            });

        } catch(e) {
            alert('Dropzone.js does not support older browsers!');
        }

    });
</script>


<#--
<script>
    jQuery(function($) {
        var myDropzone = new Dropzone("#dropz", {
            url: "/upload",
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropzFile", // 传到后台的参数名称
            init: function () {
                this.on("success", function (file, data) {
                    // 上传成功触发的事件
                });
            }
        });
    });
</script>-->
