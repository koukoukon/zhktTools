<%--
  Created by IntelliJ IDEA.
  User: damofengxue
  Date: 2019/12/21
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>智慧课堂小工具</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tip.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/home2.js"></script>
    <style>

        body{
            font-family: 宋体;
            font-size: 16px;
            font-weight: bold;
            position: relative;
            -webkit-overflow-scrolling: touch;
            overflow-scrolling: touch;
        }

        .l1:hover{
            cursor: pointer;
        }
        #s{
            width: 55px;
            height: 40px;
            transform: rotate(90deg);
        }
        #answerTextImage{
            margin-right: 12px;
            width: 32px;
            height: 35px;
        }
        .kmBox, .bjMBox{
            display: none;
        }
        .kmBox .km,.bjm{
            /*border-top: 1px solid #d5d5d5;*/
            overflow: hidden;
            font-size: 14px;
            line-height: 40px;
            list-style: none;
            display: block;
            cursor: pointer;
            margin: 0px 0px;
            background-color: #ddffffff;
            width: 100%;
            height: 40px;
        }

        /*.d{*/
        /*    border-bottom: 1px solid #d5d5d5;*/
        /*}*/

        .kmBox ul li:hover,.bjMBox ul li:hover{
            background-color: lightgrey;
        }

        @media screen and (max-width: 550px) {

            /*body{*/
            /*    background: none;*/
            /*}*/

            .box{
                background-color: #ddffffff;
                width: 90%;
                height: 90%;
                font-size: 1.2em;
            }
            .remove{
                width: 300px;
                height: 253px;
                top: 23%;
                left: calc(50% - 150px);
            }
            .remove h2{
                overflow: hidden;
            }
        }
        @media screen and (max-width: 350px) {

            /*body{*/
            /*    background: none;*/
            /*}*/

            .box{
                background-color: #ddffffff;
                width: 90%;
                height: 95%;
                font-size: 0.7em;
            }
            .remove{
                width: 300px;
                height: 253px;
                top: 23%;
                left: calc(50% - 150px);
            }
            .remove h2{
                overflow: hidden;
            }
        }
    </style>
</head>
<body>


    <div class="box">
        <div id="name">
        </div>

        <div class="list">

            <div class="l1">
                <div class="pull-left">自动签到</div>
                <div class="pull-right"><label class="la pull-left switch">
                    <input id="of" type="checkbox" checked>
                    <div class="slider round"></div>
                </label></div>
            </div>
            <div id="sk" class="l1">
                <div class="pull-left">刷课堂资源</div>
                <div class="pull-right">
                    <div>
                        <img id="s" src="${pageContext.request.contextPath}/images/s.png" />
                    </div>
                </div>
            </div>
            <div id="kmBox" class="kmBox">
                <ul id="kmL" class="text-center">

                </ul>
            </div>

            <div id="answerReference" class="l1">
                <div class="pull-left">格莱云作业答案参考</div>
                <div class="pull-right">
                    <div>
                        <img id="answerTextImage" src="${pageContext.request.contextPath}/images/answer_text.png" />
                    </div>
                </div>
            </div>
            <div id="bjMBox" class="bjMBox">
                <ul id="bjL" class="text-center">

                </ul>
            </div>

            <div onclick="ExitLogin()" class="l1">
                安全退出
            </div>
            
        </div>

        <div id="zyBox" class="zyBox">


            <!--点击删除按钮后弹出的页面-->
            <div class="zhezhao"></div>
            <div class="remove" id="removeUse">
                <div class="removerChid">
                    <h2 id="zyKm" style="text-align: center"></h2>
                    <img id="cloZyDLG" src="${pageContext.request.contextPath}/images/clo.png">
                    <div class="removeMain">
                        <p style="text-align: center;font-size: 14px">一共&nbsp;<span style="color: #ff3b25;font-size: 24px;line-height: 32px" id="countZy"></span>&nbsp;个文件</p>
                        <p style="text-align: center;font-size: 14px">未浏览&nbsp;<span style="color: #ff3b25;font-size: 24px;line-height: 32px" id="notBrowseZy"></span>&nbsp;个文件</p>
                        <p style="text-align: center;font-size: 14px">已浏览&nbsp;<span style="color: #ff3b25;font-size: 24px;line-height: 32px" id="browsedZy"></span>&nbsp;个文件</p>
                        <div id="progressBox" style="margin-bottom: 10px;margin-top: 20px" class="progress">
                            <div id="zyProgress" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;font-weight: normal;font-size: 14px">
                            </div>
                        </div>
                        <a href="#" id="startBrowse">开始浏览</a>
                    </div>
                </div>
            </div>

        </div>

    </div>


</body>

    <script>

        function stop(){
            var mo=function(e){passive: false ;};
            document.body.style.overflow='hidden';
            document.addEventListener("touchmove",mo,false);//禁止页面滑动
        }

        $(function () {


            $.post("${pageContext.request.contextPath}/user/info",{},function (data) {
                if (data.name == null) {
                    $("#name").html("你好： <a class='aa' style='cursor: pointer; text-underline: none' href='../../login.jsp'>请登录</a>");
                    $("#of").attr("checked",false);
                } else {
                    $("#name").html("欢迎：" + data.name);
                    if (data.autoSign == 0) {
                        $("#of").attr("checked",false);
                    }else {
                        $("#of").attr("checked","checked");
                    }
                }
            },"json")
            
            $("#sk").on("click",function () {
                if ($("#kmBox").css("display") == 'none') {
                    $("#kmL").empty();
                    $.post("${pageContext.request.contextPath}/user/getKtInfo",{},function (data) {
                        if (data.result != null) {
                            alert("身份为教师");
                        } else {
                            for (var key in data) {
                                $("#kmL").append("<li class='km' value='" + data[key] + "'>" + key + "</li>");
                            }
                            var i = 90;
                            var tr = setInterval(function () {
                                $("#s").css("transform","rotate(" + (i--) + "deg)")
                                if (i == 0) {
                                    clearInterval(tr);
                                }
                            },0.00001)
                            i = 90;
                            $("#kmBox").slideDown(260);
                        }
                    },"json")
                }else {
                    var i = 0;
                    var tr = setInterval(function () {
                        $("#s").css("transform","rotate(" + (i++) + "deg)")
                        if (i == 90) {
                            clearInterval(tr);
                        }
                    },0.00001)
                    i = 0;
                    $("#kmBox").slideUp(260);
                }
            })

            
        })

        $(document).on("click",".km",function () {
            var kmMc = $(this).text();
            var kmBh = $(this).attr("value");
            $.post("${pageContext.request.contextPath}/browse/getZyInfo",{ktBh:kmBh},function (data) {
                var kmStr = kmMc.substring(0,10);
                if (kmStr.length == 10){
                    kmStr = kmStr+"...";
                }
                $("#zyKm").text(kmStr);
                ktBh = kmBh;
                flushZyBox(data);
                openZyDLG();
            },"json")
        })

        function flushZyBox(data) {
            dt = data;
            var notBrowse = 0;
            var browsed = 0;
            for (var key in data) {
                if (data[key] == "是") {
                    browsed = browsed+1;
                } else {
                    notBrowse = notBrowse+1;
                }
            }
            $("#countZy").text(notBrowse+browsed);
            $("#notBrowseZy").text(notBrowse);
            $("#browsedZy").text(browsed);

        }

    </script>

</html>
