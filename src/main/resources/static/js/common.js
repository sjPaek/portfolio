const loadingSpinner = $('#loading-spinner');
$.ajaxSetup({
    beforeSend: function (){
        spinnerOn();
    },
    complete: function (){
        spinnerOff();
    }
})

function spinnerOn(){
    loadingSpinner.removeClass('d-none');
    loadingSpinner.addClass('d-block');
}

function spinnerOff(){
    loadingSpinner.addClass('d-none');
    loadingSpinner.removeClass('d-block');
}