$(function () {



    $("#of").on("click",function () {

        var is = $("#of:checked").val();
        if ($("#name").text().toString().substring(0,1) == "你") {
            alert("请先登录");
            return false;
        }else {
            if (is == null){

                aj("clo");
                $("#of").attr("checked","checked");
            }else {
                $("#of").attr("checked",false);
                aj("open");
            }
        }
    })




})

function aj(str) {
    $.post("../user/sign",{"zt":str},function (data) {
        if (data.result == "openSuccess") {

            alert("开启成功");
            alert("ps:\n如果在微信上更改密码，需要重新登陆开启才能有效。\n（自动签到仅支持普通签到，gps和二维码不行）");

            $("#of").attr("checked","checked");
        } else if (data.result == "cloSuccess") {
            $("#of").attr("checked",false);
            alert("关闭成功");
        } else {
            $("#of").attr("checked",false);
            $("#of").attr('disabled', 'disabled');
            alert(data.result);
        }
    },"json")
}

function ExitLogin() {
        location.href="../login.jsp"
}


