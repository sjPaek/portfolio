package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sj.project.portfolio.models.MessageType;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageModel {

    private int roomSeq;
    private String type;
    private String sender;
    private String receiver;
    private String message;

    public void setSender(String sender){this.sender = sender;}

    public void newConnect(){
        this.type = "new";
    }

    public void closeConnect(){
        this.type="close";
    }
}
