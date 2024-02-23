let stompClient = null;

const funcConnection = () => {
    let socket = new SockJS("http://localhost:8080/ws");
    
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function(frame){
        console.log("connected");
    })
    
}

const funcSendChat = () => {
    stompClient.send("/pub/1", {}, 
        JSON.stringify({
            "sender" : "soonjae",
            "message" : $('#message').val()
        })
    );

    $('#message').val('');
}

$(() => {
    funcConnection();
    $('#sendBtn').on('click', funcSendChat);
})