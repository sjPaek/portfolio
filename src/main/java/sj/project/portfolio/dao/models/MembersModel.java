package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembersModel {

    private int seq;
    private String userName;
    private String userId;
    private String userPassword;
    private String userTel;
    private String userAddress;

}
