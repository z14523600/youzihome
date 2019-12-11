//通用ajax返回页面
function getHtmlAJ(container,url,dataObj){
    $.ajax({
        url:url,
        type:"post",
        cache:false,
        async:false,
        data:dataObj,
        success:function (data) {
            //console.log(data);
            $("#"+container).html(data);
        },
        error:function (a,b,c) {
            console.log(a);
            console.log(b);
            console.log(c);
        }
    })
}

function getJsonAJ(url,dataObj,tip){
    $.ajax({
        url:url,
        type:"post",
        cache:false,
        async:false,
        data:dataObj,
        success:function (data) {
            console.log(data);
            alert(tip)
        },
        error:function (a,b,c) {
            console.log(a);
            console.log(b);
            console.log(c);
        }
    })
}