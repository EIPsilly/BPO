$(document).ready(function(){

    const images = document.getElementsByClassName("BackgroundImage");
    var ImgIndex = 0,ImgNum = 1;

    document.getElementById("LoginDiv").addEventListener('mousemove',(e) => {
        let width = $("#BackgroundImage" + ImgIndex).width() - window.innerWidth;
        let percentageX = (e.clientX - window.innerWidth / 2) / window.innerWidth;
        let offsetX = width * percentageX;

        let height = $("#BackgroundImage" + ImgIndex).height() - window.innerHeight;
        let percentageY = (e.clientY - window.innerHeight / 2) / window.innerHeight;
        let offsetY = height * percentageY;

        document.getElementById("Background").style.setProperty('--offsetX',`${offsetX}px`);
        document.getElementById("Background").style.setProperty('--offsetY',`${offsetY}px`);
    });

    $("#Login").click(function () {
        $.ajax({
            type: "get",
            url:"/User/login.do",
            data:$("#UserForm").serializeArray(),
            success:function(result){
                console.log(result);
                if (result == "登录成功"){

                }
                else $("#message").html(result);
            },
            error:function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        })
    })

    $("#Register").click(function () {
        window.location.href="./register.html";
    })
});