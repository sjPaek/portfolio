const loadingSpinner = $('#loading-spinner');
const msgModal = $('#msgModal');
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

function showMessage(_title, _msg){
    msgModal.off('hidden.bs.modal', false);

    const modalTitle = $('#msgModalTitle');
    const modalBody = $('#msgModalBody');

    modalTitle.text(_title);
    modalBody.html(_msg);

    msgModal.modal('show');
}