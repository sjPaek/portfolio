package sj.project.portfolio.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import sj.project.portfolio.dao.models.ChatMessageModel;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @MessageMapping(value = "/{roomId}")
    public void chat(@DestinationVariable Long roomId, ChatMessageModel model){
        log.info(model.toString());
        template.convertAndSend("/sub/chat/room/1", model);
    }

}
