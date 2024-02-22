package sj.project.portfolio.dao.mappers;

import org.apache.ibatis.annotations.Mapper;
import sj.project.portfolio.dao.models.RoomModel;

import java.util.List;

@Mapper
public interface ChatRoomMapper {

    List<RoomModel> selectChatRooms ();
}
