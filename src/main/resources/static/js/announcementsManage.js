$(document).ready(function () {
    var createAnnouncementModal = "#createAnnouncementModal";
    $("#announcementsError").hide();
    $("#announcementsSuccess").hide();
    // Get the button that opens the modal
    //Clear the form and hide errors
    $("#createAnnouncementBtn").click(function () {
        $(createAnnouncementModal).show();
        $("#announcementModalHeading").html("Add");
    });


    // Get the <span> element that closes the modal
    $("span.close").click(function () {
        $(createAnnouncementModal).hide();
    });
    // Get the button element that closes the modal   
    $("#cancel").click(function () {
        $(createAnnouncementModal).hide();
    });

    $("#announcementsSubmit").click(function (event) {
        var subject = $("#announcementsSubject").val();
        var description = $("#announcementsDescription").val();
        var link = $("#announcementslink").val();
        var selectedColor = $("#announcementsselectedColor").val();
        var invalidSubject = (subject === undefined || subject === "");
        var invalidDescription = (description === undefined || description === "");
        var invalidlink =(link === undefined || link === "");
        var invalidselectedColor = (selectedColor === undefined || selectedColor === "");
        if (invalidSubject || invalidDescription) {
            $("#announcementsError").show();
            event.preventDefault();
        }
        else{
            var destinationURL = "/announcementsManage";
            var form = $("#createAnnouncementModal");
            $("#announcementsSuccess").show();
        }

    });

    
    // Get the Edit Modal start
    var editAnnouncementModal = "#editAnnouncementModal";
    var deleteAlert = "deleteAnnouncementModal";
    // Get the button that opens the modal
    $("#editAnnouncementBtn").click(function () {
        $(editAnnouncementModal).show();
    });

    // Get the <span> element that closes the modal
    $("span.close").click(function () {
        $(editAnnouncementModal).hide();
    });
    // Get the Edit Modal end
    
    
    // Get the Delete modal
    var deleteAnnouncementModal = "#deleteAnnouncementModal";
    var deleteAlert = "deleteAnnouncementModal";
    // Get the button that opens the modal
    $("#delAnnouncementBtn").click(function () {
        $(deleteAnnouncementModal).show();
    });

    // Get the <span> element that closes the modal
    $("span.delete").click(function () {
        $(deleteAnnouncementModal).hide();
    });
    // Get the button element that closes the modal   
    $("#deleteNo").click(function () {
        $(deleteAnnouncementModal).hide();
    });
    // When the user clicks anywhere outside of the modal, close it
    $(window).click(function (e) {
        if (e.target.id == deleteAlert) {
            $(deleteAnnouncementModal).hide();
        }
    });
});