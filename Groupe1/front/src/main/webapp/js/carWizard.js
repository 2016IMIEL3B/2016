/**
 * Created by EVER on 17/04/2016.
 */
$(document).ready(function(){

    switch(horsepower) {
        case 1:
            price = 3;
            break;
        case 2:
            price = 4;
            break;
        case 3:
            price = 5;
            break;
        case 4:
            price = 6;
            break;
        case 5:
            price = 7;
            break;
        default:
            price = 8;
    }
    $('#price').text(price);

});