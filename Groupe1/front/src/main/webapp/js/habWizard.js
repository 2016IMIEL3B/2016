/**
 * Created by manon.carbonnel on 14/04/2016.
 */

$('#bathroomNumber').blur(function() {

    if($(this).val() > $('#roomNumber').val()){
        $('#roomNumberAlert').show();
        $(this).focus();
        $(this).css("border-color", "#a94442");
    } else {
        $('#roomNumberAlert').hide();
        $(this).css("border-color", "#ccc");
    }

});