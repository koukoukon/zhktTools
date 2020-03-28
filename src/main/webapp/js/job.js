var countData;
$(function () {
    
    $(".list-img").on("click",function () {
        $(this).parent().removeClass("visible-xs");
        $(this).parent().slideUp(100);
        $("#leftNavBox").css({width: "50%",position:"absolute",left:"-50%"});
        $("#leftNavBox").removeClass("hidden-xs");
        var i = 1;
        var setIn = setInterval(function () {
            if (i == 50){
                clearInterval(setIn)
            }
            $("#leftNavBox").css("left",(i-50)+"%");
            i = i+1;
        },0.001)
    })

    $(".closeLi").on("click",function () {
        var i = 1;
        var setIn = setInterval(function () {
            if (i == 50){
                clearInterval(setIn);
                $("#listImBox").addClass("visible-xs");
                $("#leftNavBox").addClass("hidden-xs");
                $("#leftNavBox").css({position:"static",width:"15%"})
            }
            $("#leftNavBox").css("left",(0-i)+"%");
            i = i+1;
        },0.001)
    })
})

$(document).on("click",".majorName",function () {

    $(".select").removeClass("select");
    $(this).addClass("select");
    if($(".closeLi").css("display") == "block") {
        var i = 1;
        var setIn = setInterval(function () {
            if (i == 50){
                clearInterval(setIn);
                $("#listImBox").addClass("visible-xs");
                $("#leftNavBox").addClass("hidden-xs");
                $("#leftNavBox").css({position:"static",width:"15%"})
            }
            $("#leftNavBox").css("left",(0-i)+"%");
            i = i+1;
        },0.001)
    }
    $("#loding").slideDown(100);
    $(".lodingProgress").css("display","block");
    var subject = $(this).attr("value");
    var allMajor = $(".majorName");
    var majorName = null;
    // console.log(allMajor[0].attr("value"));
    for (var i = 0; i < allMajor.length; i ++) {
        if ((allMajor.eq(i).attr("value")) == subject){
            majorName = majorCurriculum[i].Name;
        }
    }
    $.post("../../getJobInfo",{classId:classId,subjectId:subject,majorName:majorName,className:className},function (data) {
        $(".lodingProgress").css("display","none");
        $("#loding").slideUp(100);
        countData = data;
        var tempData = new Array();
        for (var o = 0; o < 10; o ++) {
            tempData[o] = data[o];
        }
        createTopic(tempData);
        createPage();
    },"json")


})

function createTopic(data) {
    $("#tbo").empty();
    var allMajor = $(".majorName");
    var majorName = null;
    for (var i = 0; i < allMajor.length; i ++) {
        if (allMajor[i].className.indexOf('select') == -1) {
        }else {
            majorName = majorCurriculum[i].Name;
        }
    }
    $("#topicTitle").text(majorName);
    for (var i = 0; i < data.length; i ++) {
        var o = data[i];
        var str = o.ChapterName;
        var arr = str.split(" ");
        var startStr = arr[0];
        var endStr = "";
        // console.log(arr);
        for (var m = 1; m < arr.length; m ++) {
            endStr = endStr+arr[m];
        }
        endStr = endStr.length>11?(endStr.substring(0,11)+".."):(endStr);
        $("#tbo").append("<tr value='" + o.jobId + "' class=''><td style='line-height: 2.7'>" + startStr + "</td><td style='line-height: 2.7'>" + endStr + "</td style='line-height: 2.7'><td style='line-height: 2.7'><button class='answer btn btn-success'>查看答案</button></button></td></tr>");
    }
}

function createPage() {
    let number = Math.ceil(countData.length/10);
    $("#page").Page({
        totalPages: number,//total Pages
        liNums: 7,//the li numbers(advice use odd)
        activeClass: 'activP', //active class style
        // firstPage: '首页',//first button name
        // lastPage: '末页',//last button name
        // prv: '?',//prev button name
        // next: '?',//next button name
        hasFirstPage: false,//whether has first button
        hasLastPage: false,//whether has last button
        hasPrv: true,//whether has prev button
        hasNext: true,//whether has next button
        callBack : function(page){
            var k = 0;
            var tempData = new Array();
            for (var i = ((page-1)*10); i < ((page-1)*10)+10; i ++) {
                if (countData[i] == undefined || countData[i] == null) {
                    break;
                }else {
                    tempData[k] = countData[i];
                    k++;
                }
            }
            createTopic(tempData);
        }
    });
}

$(document).on("click",".answer",function () {
    $("#objText").text(($(this).parent().prev().text()));
    $("#loding").slideDown(0);
    $(".lodingProgress").slideDown(0);
    var chapter = $(this).parent().parent().attr("value");
    $.post("../../getAnswer",{chapterId:chapter},function (data) {
        $(".lodingProgress").slideUp(0);
        $("#answerBox").slideDown(200);
        createObjs(data.objs);
        createSubs(data.subs);
        // console.log((data.objs)[0].Title)
    },"json")
})

function createObjs(data) {
    $("#objsBox").empty();

    for (var i = 0; i < data.length; i ++) {
        let obj = data[i];
        let answer = obj.Answer;
        switch (answer) {
            case "1":
                $("#objsBox").append("<div class='objs'><div class='objsTitle'>" + (i+1)+"."+(obj.Title.substring(3,obj.Title.length-4)) + "</div> <div class='objsAnswer'> <div class='objItems correct'>A." + obj.Item1 + "</div> <div class='objItems'>B." + obj.Item2 + "</div> <div class='objItems'>C." + obj.Item3 + "</div> <div class='objItems'>D." + obj.Item4 + "</div> </div> </div></div>");
                break;
            case "2":
                $("#objsBox").append("<div class='objs'><div class='objsTitle'><p>" + (i+1) + "." + (obj.Title.substring(3,obj.Title.length-4)) + "</p></div> <div class='objsAnswer'> <div class='objItems'>A." + obj.Item1 + "</div> <div class='objItems correct'>B." + obj.Item2 + "</div> <div class='objItems'>C." + obj.Item3 + "</div> <div class='objItems'>D." + obj.Item4 + "</div> </div> </div></div>");
                break;
            case "3":
                $("#objsBox").append("<div class='objs'><div class='objsTitle'><p>" + (i+1) + "." + (obj.Title.substring(3,obj.Title.length-4)) + "</p></div> <div class='objsAnswer'> <div class='objItems'>A." + obj.Item1 + "</div> <div class='objItems'>B." + obj.Item2 + "</div> <div class='objItems correct'>C." + obj.Item3 + "</div> <div class='objItems'>D." + obj.Item4 + "</div> </div> </div></div>");
                break;
            case "4":
                $("#objsBox").append("<div class='objs'><div class='objsTitle'><p>" + (i+1) + "." + (obj.Title.substring(3,obj.Title.length-4)) + "</p></div> <div class='objsAnswer'> <div class='objItems'>A." + obj.Item1 + "</div> <div class='objItems'>B." + obj.Item2 + "</div> <div class='objItems'>C." + obj.Item3 + "</div> <div class='objItems correct'>D." + obj.Item4 + "</div> </div> </div></div>");
                break;
        }
    }

}

function createSubs(data) {
    $("#subsBox").empty();
    for (var i = 0; i < data.length; i ++) {
        let sub = data[i];
        $("#subsBox").append("<div class='subs'><div class='subsTitle'>" + (i+1) + "." + sub.Title + "</div><div class='subsAnswer'>" + sub.Parsing + "</div></div>")
    }
}