$(document).ready(function () {
    var createAnnouncementModal = "#createAnnouncementModal";
    $(".validationAnnouncements").hide();


    $(".save").click(function (event) {
        var announcementId = event.target.id;
        var subjectId = "#subject" + announcementId;
        var subject = $(subjectId).val();
        var descriptionId = "#description" + announcementId;
        var description = $(descriptionId).val();

        //By default, The subject and description should not be empty.
        var invalidSubject = (subject === undefined || subject === "");
        var invalidDescription = (description === undefined || description === "");

        if (invalidSubject || invalidDescription) {
            $(".validationAnnouncements").show();
            event.preventDefault();
        }
        else {
            $(".validationAnnouncements").hide();
        }
    });

    // Get the button that opens the modal
    //Clear the form and hide errors
    $("#createAnnouncementBtn").click(function () {
        $("#announcementModalHeading").html("Add");
        $(".validationAnnouncements").hide();
        $("#subject").val("");
        $("#description").val("");
        $(createAnnouncementModal).show();
    });

    var modalId; //Set modal id based on button click below

    // Get the edit button that opens the modal
    $(".editAnnouncementBtn").click(function (event) {
        var modal = "#modal" + event.target.id;
        modalId = "#modal" + event.target.id;
        $(".validationAnnouncements").hide();
        $(modal).show();
        event.preventDefault();
    });

    // Get the Delete modal
    $(".delAnnouncementBtn").click(function (event) {
        var modal = "#delete" + event.target.id;
        modalId = "#delete" + event.target.id;
        $(modal).show();
    });

    // Get the <span> element that closes the modal
    $("span.close").add(".cancel").click(function (e) {
        $(modalId).hide();
        $("#createAnnouncementModal").hide();
    });
});