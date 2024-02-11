package sj.project.portfolio.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sj.project.portfolio.dao.models.MembersModel;
import sj.project.portfolio.models.ResponseModel;
import sj.project.portfolio.services.LoginService;
import sj.project.portfolio.services.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    private static PasswordEncoder passwordEncoder = new PasswordEncoder();

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public @ResponseBody ResponseModel<MembersModel> doLogin(MembersModel model, HttpServletRequest request){
        MembersModel member = loginService.getMemberByUserId(model);
        if(member == null){
            return new ResponseModel<>(false, "일치하는 정보가 없습니다. 다시 로그인해주세요", null, null);
        }
        String enterPassword  = passwordEncoder.encode(model.getUserPassword());
        if(member.getUserPassword().equals(enterPassword)){
            HttpSession session = request.getSession();
            session.setAttribute("logged", member);
            return new ResponseModel<>(true, "정상적으로 로그인 되었습니다", null, null);
        }else{
            return new ResponseModel<>(false, "일치하는 정보가 없습니다. 다시 로그인해주세요", null, null);
        }

    }
}

