package sj.project.portfolio.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("menuList")
public class MenuList {

    public static final String MENU_01 = "HOME";
    public static final String MENU_02 = "PROJECT";
    public static final String MENU_03 = "STUDY";

    public static final String MENU_04 = "SETTING";

    public static List<MenuModel> mainMenuList;


    public MenuList(){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new MenuModel(MENU_01, "Home", "/", false, 1, "home"));
        mainMenuList.add(new MenuModel(MENU_02, "Project", "/project", false, 0, "list"));
        mainMenuList.add(new MenuModel(MENU_03, "Study", "/study", true, 0, "edit_note"));
        mainMenuList.add(new MenuModel(MENU_04, "Setting", "/setting", true, 0, "settings"));
    }

}
