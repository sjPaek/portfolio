package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageModel {
    private String type;
    private String sender;
    private String receiver;
    private Object data;

    public void setSender(String sender){this.sender = sender;}

    public void newConnect(){
        this.type = "new";
    }

    public void closeConnect(){
        this.type="close";
    }
}
