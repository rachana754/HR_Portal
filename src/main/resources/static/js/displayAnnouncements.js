$(document).ready(function () {
    /* This code will be replace with JQuery, Will comeback and fix this code, for now it is commented temporary*/
    var slideIndex = document.getElementsByClassName("Annoucement-Slide")[0].id;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("Annoucement-Slide");
        var dots = document.getElementsByClassName("dot");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        //slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
        setTimeout(showSlides, 10000);
    }

    /* FIX ME--Will come back and fix this code, for now it is commented temporary */
    /* $('.next').on("click",function() {
         var currentSlide = $('.active-slide');
         var nextSlide = currentSlide.next();
         
         var currentDot = $('.active-dot');
         var nextDot = currentDot.next();
         
         if ( nextSlide.length == 0 ) {
             nextSlide = $('.Annoucement-Slide').first();
             nextDot = $('.dot').first();
         } 
         
         currentSlide.fadeOut(1300).removeClass('active-slide');
         nextSlide.fadeIn(1300).addClass('active-slide');
         
         currentDot.removeClass('active-dot');
         nextDot.addClass('active-dot');
     });
     $('.prev').on("click",function() {
         var currentSlide = $('.active-slide');
         var prevSlide = currentSlide.prev();
         
         var currentDot = $('.active-dot');
         var prevDot = currentDot.prev();
         
         if ( prevSlide.length == 0 ) {
             prevSlide = $('.Annoucement-Slide').last();
             prevDot = $('.dot').last();
         }
         
         currentSlide.fadeOut(1300).removeClass('active-slide');
         prevSlide.fadeIn(1300).addClass('active-slide');
         
         currentDot.removeClass('dot');
         prevDot.addClass('dot');
     });
     $(".Annoucement-Slide .dot").on("click",function(){
         var index = $(this).index()
         console.log(index)
         var currentSlide = $('.active-slide');
         var newSlide = currentSlide.parent().children().eq(index)
             var currentDot = $(this);
         currentDot.addClass('active-dot').siblings().removeClass('active-dot');

         currentSlide.fadeOut(1300).removeClass('active-slide');
         newSlide.fadeIn(1300).addClass('active-slide');
         
     
     })*/

});