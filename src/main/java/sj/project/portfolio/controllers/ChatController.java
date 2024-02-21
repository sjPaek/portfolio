package sj.project.portfolio.controllers;

import lombok.RequiredArgsConstructor;
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

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageModel message){
        template.convertAndSend("/sub/chat/room");
    }

}
