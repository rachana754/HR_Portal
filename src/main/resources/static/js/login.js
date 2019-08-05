
//file needs UI clean up (javaScript needs to be converted to jQuery)
//js used for forgot password modal functionality and front validation

$(document).ready(function() {

    // open forgot password modal
    $('a[id=myBtn]').click(function(event) {
        document.getElementById("myModal").style.display = "block";
        $("#valMessage").hide();
        $("#messageArrow").hide();
        
    });

    // close forgot password modal
    $('button[id=close]').click(function() {
        document.getElementById("myModal").style.display = "none";
        $("#errorEmailMessage").hide();
        $("#successEmailMessage").hide();
        return false;
    });

    // Regular Expressions
    // no special characters
    var specChars = /^\s*[a-zA-Z0-9,\s]+\s*$/;
    // min characters 6, max characters 12
    var maxChars = /^([a-zA-Z0-9]{6,12})$/;
    // must contain a numeric value
    var numerics = /^[0-9]*$/;
    // checks possible fake text
    var fakeText = /(.)\1{2,}/;

    // function to validate forgot password modal form
    $("#frgtSubmit").on("click", function(event) {
        var username = $("#username2").val();
        if (!username.match(specChars) || !username.match(maxChars) || username.match(fakeText)) {
            $("#valMessage").html("Please enter a valid username");
            document.getElementById("messageArrow").style.display = "block";
            document.getElementById("valMessage").style.display = "block";
            event.preventDefault();
        }
    });

});
