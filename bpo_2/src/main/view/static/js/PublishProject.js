$(document).ready(function(){
    $(".TypeDiv").click(function () {
        $(".TypeDiv").each(function () {
            $(this).removeClass("SelectedType");
        });
        $(this).addClass("SelectedType");
    })

    $(".SelectGroup li").click(function () {
        $(this).toggleClass("SelectedSkill");
        let str = $("[name='SkillsRequirement']").val();
        if (str == ""){
            $("[name='SkillsRequirement']").val($(this).text());
        } else{
            let strs = str.split(","),flag = 0,value = "";
            for (let t in strs){
                if (strs[t] == $(this).text()){
                    flag = 1;
                }
                else {
                    if (value == "") value = strs[t];
                    else value += "," + strs[t];
                }
            }
            if (!flag) value += "," + $(this).text()
            $("[name='SkillsRequirement']").val(value);
        }
    });

    $(".PeriodLabel").click(function () {
        $(".PeriodLabel").each(function () {
            $(this).removeClass("PeriodLabelSelected");
        });
        $(this).addClass("PeriodLabelSelected");
    })

    $("#dropdownMenu1").click(function () {
        $("#SkillMenu").toggle();
    })
})