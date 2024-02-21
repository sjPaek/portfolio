package sj.project.portfolio.dao.models;

import lombok.Data;

@Data
public class RoomModel {
    private int seq;
    private String roomName;
    private String roomDesc;
    private int userSeq;
}
