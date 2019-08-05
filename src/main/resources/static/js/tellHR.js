$(document).ready(function() {
    $("#errorMessage").hide();
    $("#successMessage").hide();

    /**
     * Checks to make sure the information is valid, displays appropriate modals, then sends to backend
     */
    $("#send").click(function() {
        var text = $("#message").val();
        var subject = $("#subject").val();

        var invalidText = (text === undefined || text === "");
        var invalidSubject = (subject === undefined || subject === "-1");

        if (invalidText || invalidSubject) {
            // Invalid submission → Show error message
            $("#errorMessage").show();
        } else {
            // Valid submission → Send to backend
            var destinationURL = "/home/tellHR";
            var form = $("#tellHR");
            //ajax method
            $.ajax({
                type : "POST",
                url : destinationURL,
                data : form.serialize(),
                success : function() {
                    // Show the success message
                    $("#errorMessage").hide();
                    $("#tellHR").hide();
                    $("#successMessage").show();
                    // Delay clearing by 3 sec
                    setTimeout(function() {
                        location.reload()
                    }, 3000);
                }
            });
        }
    })
});