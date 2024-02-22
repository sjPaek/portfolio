var stompClient;
const funcWebSocketConnection = () => {
    var socket = new SockJS("/stomp/chat");

    stompClient = Stomp.over(socket);


    stompClient.subscribe("/room/1", function(){
        console.log('subscribe');
    })
}

const funcSendChat = () => {
    stompClient.send("/send/1", {},
    JSON.stringify({
        'sender' : "A",
        'message' : $('#message').val()
    }))
    $('#message').val('');
}


$(() => {
    funcWebSocketConnection();
    $('#sendBtn').on('click', funcSendChat);
})