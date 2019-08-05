//file needs UI clean up (javaScript needs to be converted to jQuery)

document.addEventListener('DOMContentLoaded', function (event) {
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function () {
            for (let i = 0; i < acc.length; i++) {
                acc[i].classList.remove("active");
                acc[i].style.maxHeight = null;
                acc[i].nextElementSibling.style.maxHeight = null;
            }
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            }
            else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }

        }
    }
});