
$(function () {
    $("#answerReference").on("click",function () {
        if ($("#bjMBox").css("display") == 'none') {
            $.post("../job/classInfo",{},function (data) {

                $("#bjL").empty();
                for (var key in data) {
                    $("#bjL").append("<li class='bjm' value='" + data[key] + "'>" + key + "</li>");
                }
            },"json")
            $("#bjMBox").slideDown(260);
        } else {
            $("#bjMBox").slideUp(260);
        }
    })
    
    $(document).on("click",".bjm",function () {
        let className = $(this).text();
        className = className.substring(0,className.indexOf("("));
        className = "20"+className;
        console.log(className);
        location.href = "../job/galaJob/" + className + "/" + $(this).attr("value");
    })
    
})