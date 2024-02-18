package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sj.project.portfolio.models.MessageType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageModel {
    private MessageType type;
    private String content;
    private String sender;
}
