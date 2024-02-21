package sj.project.portfolio.controllers;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
>>>>>>> 318aa45edfc5a6ea749edbb2cf1cedcb4fad4b76
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import sj.project.portfolio.dao.models.ChatMessageModel;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    // @GetMapping("/chat")
    // public String chat() {
    //     return "chat";
    // }

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageModel message){
        template.convertAndSend("/sub/chat/room");
    }

    @MessageMapping(value = "/{roomSeq}") //여기로 전송되면 메소드 호출
    @SendTo("/room/{roomSeq}") // 구독하고 있는 장소로 메시지 전송 (목적지)
    public ChatMessageModel message(ChatMessageModel message, @DestinationVariable Long roomSeq){
        return ChatMessageModel.builder()
                .message(message.getMessage())
                .sender("temp")
                .build();
    }

}
