package com.example.springboot02;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class userHandler {

//    @RequestMapping({"/","/login.html"})
//    public String user(){
//        return "login";
//    }



    @PostMapping("/user/login")
    public  String login(@RequestParam("username") String username ,
                         @RequestParam("password") String password  ,
                         Map<String,Object> map, HttpSession session){

        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            System.out.println(username);
            System.out.println(password);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
