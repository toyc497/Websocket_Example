let stompClient = null;

function connectWebsocket(){
    let socket = new SockJS('http://127.0.0.1:8084/connectiongate');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        console.log("Connected: "+frame);
        stompClient.subscribe('/topic/mensagens',function(messageOutput){
            showMessage(messageOutput);
            //alert(messageOutput);
        });
    });
}

function showMessage(message){

    conteudo = message;

    let message_list = document.getElementById('message-list');
    let chat = document.createElement('li');
    chat.appendChild(document.createTextNode(conteudo));
    message_list.appendChild(chat);

}

function sendMessage(){
    let textMessage = document.getElementById('message-input').value;
    //console.log(textMessage);
    const headers = {
        "content-type": "application/json"
    }
    stompClient.send("/app/endpointmessage", headers, JSON.stringify({"name": textMessage}));
}