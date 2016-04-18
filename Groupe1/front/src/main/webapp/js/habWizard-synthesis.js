/**
 * Created by manon.carbonnel on 17/04/2016.
 */
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