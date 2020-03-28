<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/job.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.page.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/job.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
    <style>
        .lodingProgress{
            top: calc(50% - 100px);
            left: calc(50% - 150px);
            position: absolute;
            width: 300px;
            display: none;
            z-index: 1000;
        }
    </style>
</head>
<body>
<div class="box">

    <div id="listImBox" class="listImgBox visible-xs">
        <img class="list-img" src="${pageContext.request.contextPath}/images/list.png"/>
    </div>

    <div id="leftNavBox" class="left-nav hidden-xs">
        <ul id="leftNavUl">
            <li class="visible-xs closeLi">关闭</li>
        </ul>

        <div class="ale">
            注*： 已发布且批改完毕的作业有可能显示失败！
        </div>
    </div>

    <div id="topicBox" class="topicBox">
        <h3 id="topicTitle" class="topicTitle"></h3>
        <div class="topicTable" id="userTab">
            <table class="table table-striped table-bordered text-center table-hover">

                <thead>
                <tr>
                    <th class="text-secondary text-center">作业</th>
                    <th class="text-secondary text-center">章节名称</th>
                    <th class="text-secondary text-center">答案信息</th>
                </tr>
                </thead>

                <tbody id="tbo" class="tbo">
                </tbody>

            </table>
            <div class="pageBox">
                <div id="page" class="page fl">


                </div>
            </div>
        </div>


    </div>
    </div>

    <div style="line-height:100%;color: rebeccapurple" id="loding" class="loding">
    </div>
    <div class="lodingProgress">
        <div id="progressBox" style="margin-bottom: 10px;margin-top: 20px" class="progress">
            <div id="ldProgress" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"  style="width: 90%;font-weight: normal;font-size: 14px">
            正在加载...
            </div>
        </div>
    </div>

<div id="answerBox" class="answerBox">
    <div class="answerTitle">
        <div id="objText" class="objsText"></div>
        <div class="answerCloseBtn"><button class="closeAnswerBox closeAnswerBtn btn btn-success">关闭</button></div>
    </div>

    <div class="answerMainBody">

        <div class="topicAndAnsweBox">

            <h4 style="font-weight: bold; border-bottom: 2px solid #dedede">客观题</h4>
            <div id="objsBox" class="objsBox">


            </div>

            <h4 style="font-weight: bold; border-bottom: 2px solid #dedede; margin-top: 25px">主观题</h4>
            <div id="subsBox" class="subsBox">

            </div>

        </div>

    </div>


    <div class="answerFoot">
        <div class="answerFootText">注*：题目及答案不排序，注意。</div>
        <button class="closeAnswerBox okAnswerBtn btn btn-danger">确认</button>
    </div>
    <div class="objsBox"></div>
</div>

</div>
<script>
    var majorCurriculum = null;
    var classId = null;
    var className = null;
    $(function () {
        majorCurriculum = ${requestScope.majorCurriculum};
        classId = ${requestScope.classId};
        className = "${requestScope.className}";
        for (var i = 0; i < majorCurriculum.length; i ++) {
            var major = majorCurriculum[i];
            if (i == 0) {
                $("#leftNavUl").append("<li class='select majorName' value='" + major.Id + "'>" + (major.Name.length>11?(major.Name.substring(0,11)+"..."):(major.Name)) + "</li>")
            }else {
                $("#leftNavUl").append("<li class='majorName' value='" + major.Id + "'>" + (major.Name.length>10?(major.Name.substring(0,11)+"..."):(major.Name)) + "</li>");
            }
        }
        $("#loding").slideDown(100);
        $(".lodingProgress").css("display","block");
        var subject = $(".select").attr("value");
        var majorName = majorCurriculum[0].Name;
        $.post("${pageContext.request.contextPath}/job/getJobInfo",{classId:classId,subjectId:subject,majorName:majorName,className:className},function (data) {
            $(".lodingProgress").css("display","none");
            $("#loding").slideUp(100);
            countData = data;

            var tempData = new Array();
            for (var i = 0; i < 10; i++) {
                tempData[i] = data[i];
            }

            createTopic(tempData);
            createPage();
        },"json")

        $(".closeAnswerBox").on("click",function () {
            $("#answerBox").slideUp(200);
            $("#loding").slideUp(0);
        })
    })
</script>
</body>
</html>

