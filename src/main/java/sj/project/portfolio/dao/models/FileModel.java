package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileModel {
    private int seq;
    private String fileName;
    private String originFileName;

}
