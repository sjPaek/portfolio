
const evtSubmitLogin = (e) => {
    e.preventDefault();
    showMessage("알림", "로그인 하시겠습니까?");
    const url = '/login';
    const post = $.post(url, $('#loginForm').serialize());
    const {ok, msg} = post;

    // if(ok){
    //     location.href="/";
    // }else{
    //     location.href="/login";
    // }
}

$(() => {
    $('#loginForm').on('submit', evtSubmitLogin);
})