package sj.project.portfolio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuModel {
    private String category;
    private String name;
    private String url;
    private boolean hasSunMenu;
    private int level;
    private String icon;

}
