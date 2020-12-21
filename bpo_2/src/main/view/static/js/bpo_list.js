$(document).ready(function(){

    const images = document.getElementsByClassName("BackgroundImage");
    var ImgIndex = 0,ImgNum = 1;

    document.getElementById("MainDiv").addEventListener('mousemove',(e) => {
        let width = $("#BackgroundImage" + ImgIndex).width() - window.innerWidth;
        let percentageX = (e.clientX - window.innerWidth / 2) / window.innerWidth;
        let offsetX = width * percentageX;

        let height = $("#BackgroundImage" + ImgIndex).height() - window.innerHeight;
        let percentageY = (e.clientY - window.innerHeight / 2) / window.innerHeight;
        let offsetY = height * percentageY;

        document.getElementById("Background").style.setProperty('--offsetX',`${offsetX}px`);
        document.getElementById("Background").style.setProperty('--offsetY',`${offsetY}px`);
    });

    $("#ProjectType a").click(function(){
        $("#ProjectType a").each(function (){
            // $(this).css("background", "transparent");
            $(this).removeClass("ItemSelected");
        });
        $(this).addClass("ItemSelected");
        // $(this).css("background","rgba(220,139,20,0.5)");
    });

    $("#MoneySelect a").click(function(){
        $("#MoneySelect a").each(function (){
            // $(this).css("background", "transparent");
            $(this).removeClass("ItemSelected");
        });
        // $(this).css("background","rgba(220,139,20,0.5)");
        $(this).addClass("ItemSelected");
    });

});
