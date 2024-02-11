
const evtSubmitLogin = (e) => {
    e.preventDefault();
    console.log('login');
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