/**
 * Created by manon.carbonnel on 14/04/2016.
 *
 * Input control for Habitation Wizard
 */

$('#surface').blur(function() {

    if($(this).val() < 9){
        $('#surfaceAlert').show();
        $(this).focus();
        $(this).css("border-color", "#a94442");
    } else {
        $('#surfaceAlert').hide();
        $(this).css("border-color", "#ccc");
    }
});


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