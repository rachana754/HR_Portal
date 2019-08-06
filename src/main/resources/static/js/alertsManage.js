$(document).ready(function () {

    $(".validationAlerts").hide();
    $("#alertSuccess").hide();
   
    $("#alertsSubmit").click(function (event) {
        var subject = $("#alertSubject").val();
        var description = $("#alertDescription").val();
        var invalidSubject = (subject === undefined || subject === "");
        var invalidDescription = (description === undefined || description === "");

        if (invalidSubject || invalidDescription) {
            $("#alertsError").show();
            event.preventDefault();
        }
    });

    // Get the create button that opens the modal
    $("#createAlertBtn").click(function (event) {
        $(".validationAlerts").hide();
        $("#alertsError").hide();
        $("#createAlertModal").show();
    });

    var modalId;
    // Get the edit button that opens the modal
    $(".editAlertBtn").click(function (event) {
        var modal = "#modal" + event.target.id;
        modalId = "#modal" + event.target.id;
        $(".validationAlerts").hide();
        $(modal).show();
        event.preventDefault();    
    });
    // Get the <span> element that closes the modal
    $("span.close").click(function (e) {
        $(modalId).hide();
        $("#createAlertModal").hide();
    });
    // Get the button element that closes the modal   
    $(".cancel").click(function (e) {
        $(modalId).hide();
        $("#createAlertModal").hide();
    });

    // Get the Delete modal
    var modaldel;
    var deleteAlertModal = "#deleteAlertModal";
    var deleteAlert = "deleteAlertModal";

    $(".delAlertBtn").click(function (event) {
        var modal = "#delete" + event.target.id;
        modaldel = "#delete" + event.target.id;
        $(modal).show();
    });
    // Get the <span> element that closes the modal
    $("span.delete").click(function () {
        $(modaldel).hide();
    });
    // Get the button element that closes the modal   
    $(".deleteNo").click(function () {
        $(modaldel).hide();
    });

});