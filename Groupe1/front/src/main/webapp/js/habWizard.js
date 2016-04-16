/**
 * Created by manon.carbonnel on 14/04/2016.
 */

$('#bathroomNumber').blur(function() {

    if($(this).val() > $('#roomNumber').val() || $(this).val() == 0){
        $('#roomNumberAlert').show();
        $(this).focus();
        $(this).css("border-color", "#a94442");
    } else {
        $('#roomNumberAlert').hide();
        $(this).css("border-color", "#ccc");
    }

});

$('#floor').blur(function() {

    if($(this).val() > 167){
        $('#floorAlert').show();
        $(this).focus();
        $(this).css("border-color", "#a94442");
    } else {
        $('#floorAlert').hide();
        $(this).css("border-color", "#ccc");
    }

});


$(document).ready(function(){

    switch(nbPieces) {
        case 1:
            price = 6;
            break;
        case 2:
            price = 8;
            break;
        case 3:
            price = 10;
            break;
        case 4:
            price = 12;
            break;
        case 5:
            price = 14;
            break;
        case 6:
            price = 16;
            break;
        default:
            price = 6;
    }

    $('#price').text(price);

});

$('input[type=radio][name="quote.summary"]').change(function() {

    switch(nbPieces) {
        case 1:
            price = 6;
            break;
        case 2:
            price = 8;
            break;
        case 3:
            price = 10;
            break;
        case 4:
            price = 12;
            break;
        case 5:
            price = 14;
            break;
        case 6:
            price = 16;
            break;
        default:
            price = 6;
    }

    if($(this).val() == "full"){
        price += 2;
    }

    $('#price').text(price);

});