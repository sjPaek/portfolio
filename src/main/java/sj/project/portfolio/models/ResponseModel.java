package sj.project.portfolio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel <T> {
    private boolean ok;
    private String msg;
    private T object;;
    private List<T> list;
}
