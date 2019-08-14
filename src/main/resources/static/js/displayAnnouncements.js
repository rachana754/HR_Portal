$(document).ready(function () {
    $("#slide0").show();

    $(".color").each(function () {
        var color = $(this).text();
        var slideId = $(this).attr('id');
        switch (color) {
            case "PURPLE":
                $('#slide' + slideId).addClass("purpleSlide");
                break;
            case "BLUE":
                $('#slide' + slideId).addClass("blueSlide");
                break;
            case "ORANGE":
                $('#slide' + slideId).addClass("orangeSlide");
                break;
        }
    });
    
    var announcementLength = $(".announcement-slide").length;
    var currentId = 0;

    //nav to the left of slide and once it reach to the last slider it will go back to the first id
    $(".prev").on("click", function () {
        var prevId = parseInt(currentId) - 1;
        if (prevId == -1) {
            prevId = announcementLength - 1;
        }
        goToSlide(prevId);
    });

    //nav to the right of slide and once it reach to the last slider it will go back to the first id
    $(".next").on("click", function () {
        var nextId = parseInt(currentId) + 1;
        if (nextId == announcementLength) {
            nextId = 0;
        }
        goToSlide(nextId);
    });

    //nav dot will find the associate id
    $(".dot").on("click", function (event) {
        var dotId = event.target.id;
        $("#" + dotId).addClass("active-dot");
        
        var desiredId = dotId.replace('dot','');
        goToSlide(desiredId);
    });

    function goToSlide(desiredSlide) {
        $("#slide" + currentId).hide();
        $("#slide" + desiredSlide).show();
        $("#dot" + currentId).removeClass("active-dot");
        currentId = desiredSlide;
    }

});