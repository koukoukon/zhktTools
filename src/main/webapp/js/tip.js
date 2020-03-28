var obj = null;
var interval=null;
var dt = null;
var ktBh = null;
$(function(){
    // 点击"删除"按钮触发
    $(".delete").on("click",function(){
        obj = $(this);
        openZyDLG();
    });
    // 点击提示框中的"取消"按钮触发
    $('#cloZyDLG').click(function () {
        clearInterval(interval);
        dt = null;
        ktBh = null;
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
    // 点击提示框中的"确定"按钮触发
    $('#startBrowse').click(function () {

        if ($("#startBrowse").text() == "开始浏览") {

            if ($("#notBrowseZy").text() == 0) {
                alert("本课程没有未浏览资源");
            } else {
                $("#startBrowse").text("停止浏览");
                var zyBhs = new Array();
                var i = 0;
                for (var key in dt) {
                    if (dt[key] == "否") {
                        zyBhs[i] = key;
                        i = i+1;
                    }
                }
                i = 0;
                var progressNum = 100/zyBhs.length;
                var progressNumFlag = progressNum;
                // console.log(progressNum);
                interval = setInterval(function () {
                    $("#zyProgress").width((progressNum+"%"));
                    progressNum = progressNum+progressNumFlag;
                    $.post("../browse/browseZy",{zyBh:zyBhs[i],ktBh:ktBh},function (data) {
                        flushZyBox(data);
                    },"json")

                    i = i+1;
                    if (i == zyBhs.length) {
                        clearInterval(interval);
                        $("#startBrowse").text("浏览完成");
                    }
                },100)
            }

        }else if($("#startBrowse").text()=="停止浏览") {
            clearInterval(interval);
            $("#startBrowse").text("开始浏览");
        }else if ($("#startBrowse").text()=="浏览完成") {
            clearInterval(interval);
            dt = null;
            ktBh = null;
            $('.zhezhao').css('display', 'none');
            $('#removeUse').fadeOut();
        }

    });
});

//发送ajax请求删除内容


// 显示提示框
function openZyDLG(){
    $("#startBrowse").text("开始浏览");
    $("#zyProgress").css("width",0);
    $('.zhezhao').css('display', 'block');
    $('#removeUse').fadeIn();
}
