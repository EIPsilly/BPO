$(document).ready(function (){
    $("#main").ready(function(){
        $.ajax({
            url:"pages/front/selectUnexaminedProject",
            type:"GET",
            data:"",
            contentType : "application/json",
            dataType:"json",
            success: function (json){
                var jsonStr = json;

                // console.log(jsonStr);

                var projectType = "<p>" + jsonStr[0].projectType + "</p>"
                $("#SelectType").html(projectType);
                var equipmentName = "<p>" + jsonStr[0].equipmentName + "</p>"
                $("#ClientSupport").html(equipmentName);
                $("#ProjectName").html(jsonStr[0].projectName);
                $("#ProjectRequirement").html(jsonStr[0].projectRequirement);
                $("#SkillsRequirement").html(jsonStr[0].skillsRequirement);
                $("#Budget").html("￥"+jsonStr[0].projectBudget);
                $("#Period").html(jsonStr[0].projectPeriod+"天");
                $("#ConnectName").html(jsonStr[0].connectName);
                $("#ConnectTel").html(jsonStr[0].connectTel);
                $("#hideEmployerId").html(jsonStr[0].projectId);
                $("#hideEmployerId").val(jsonStr[0].projectId);
                $("person").ready(function (){
                    $.ajax({
                        url:"pages/back/findEmployerInfo",
                        type: "GET",
                        data:{
                            "projectId" : $("#hideEmployerId").text()
                        },
                        // contentType: "application/json",
                        dataType: "json",
                        success: function(json){
                            let jsonStr = json;
                            console.log(jsonStr);
                            $("#TableItemName").html(jsonStr.userEmployerName);
                            $("#TableItemRegion").html(jsonStr.userEmployerRegion);
                            $("#TableItemSelfIntroduction").html(jsonStr.userEmployerInctroduction);
                            $("#TableItemTel").html(jsonStr.userEmployerTel);
                        }

                    })
                })
            },
            error:function(resp){
                // $.message.alert('出错了','系统出错，请联系管理员','error');
                console.log("666");
            }
        })
    })


})
