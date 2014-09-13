/**
 * Created by martinmckeaveney on 13/09/2014.
 */
$(document).ready(function(){
    $('#app-row').fadeIn(2000);
    $('#details-row').fadeIn(2000);
    $('.navbar-default').fadeIn(2000);

});

$(document).ready(function(){
    $(".wards li").hide();
    $(".wards").click(function(){
        $(".wards").animate({
            height: "40em"
        });
        $(".wards li").each(function() {
            $(this).fadeIn(1000);
        });
        $(".beds").animate({
        });
        $(".beds li").each(function() {
            $(this).fadeIn(1000);
        });
    });
});

$(document).ready(function() {
    $(".ward").click(function () {
        console.log("hello");
        $(this).animate({
            backgroundColor: "#66C266"
        }, 1000);
        $(this).animate({
            backgroundColor: "#ccc"
        }, 1000);
    });
});

$(document).ready(function() {
    $(".bed").click(function () {
        console.log("hello");
        $(this).animate({
            backgroundColor: "green"
        }, 1000);
        $(this).animate({
            backgroundColor: "#ccc"
        }, 1000);
    });
});

$(document).ready(function(){
    $(".bed li").hide();
    $(".wards").click(function(){
        $(".wards li").each(function() {
            $(this).fadeIn(1000);
        });
        $(".beds").animate({
        });
        $(".beds li").each(function() {
            $(this).fadeIn(1000);
        });
    });
});

