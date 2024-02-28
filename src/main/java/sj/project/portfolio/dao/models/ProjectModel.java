package sj.project.portfolio.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    private int seq;
    private String projectName;
    private String content;
    private String author;
    private LocalDateTime uploadDt;
    private LocalDateTime updateDt;
    private LocalDate projectStartDt;
    private LocalDate projectEndDt;

    private String projectStartDtStr;
    private String projectEndDtStr;
}
