$(document).ready(function () {

    $(".validationAlerts").hide();

    $(".save").click(function (event) {
        var alertId = event.target.id;
        var subjectId = "#subject" + alertId;
        var subject = $(subjectId).val().trim();
        var descriptionId = "#description" + alertId;
        var description = $(descriptionId).val().trim();
        var invalidSubject = (subject === undefined || subject === "");
        var invalidDescription = (description === undefined || description === "");
        if (invalidSubject || invalidDescription) {
            $(".validationAlerts").show();
            event.preventDefault();
        }
    });
    
    // Get the create button that opens the modal
    $("#createAlertBtn").click(function () {
        $(".validationAlerts").hide();
        $("#subject").val("");
        $("#description").val("");
        $("#createAlertModal").show();
    });

    var modalId; // set modal id based on button click below
    
    // Get the edit button that opens the modal
    $(".editAlertBtn").click(function (event) {
        var modal = "#modal" + event.target.id;
        modalId = "#modal" + event.target.id;
        $(".validationAlerts").hide();
        $(modal).show();
        event.preventDefault();    
    });
    
    $(".delAlertBtn").click(function (event) {
        var modal = "#delete" + event.target.id;
        modalId = "#delete" + event.target.id;
        $(modal).show();
    });
    
    // Get the button and <span> element that closes the modal
    $("span.close").add(".cancel").click(function () {
        $(modalId).hide();
        $("#createAlertModal").hide();
    });
    
});