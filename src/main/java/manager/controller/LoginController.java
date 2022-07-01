package manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String displayLogin(@RequestParam(name="error", required = false) String error
                                , Model model){
        String message = null;
        if(error != null){
            message= "Username or Password is not correct ";

        }
        model.addAttribute("errorMessage",message);

        return "login.html";
    }

    @RequestMapping("/logout")
    public String displayLogout(HttpServletRequest httpRequest, HttpServletResponse response){
        Authentication auf = SecurityContextHolder.getContext().getAuthentication();
        if(auf != null){
            new SecurityContextLogoutHandler().logout(httpRequest,response,auf);
        }
        return "redirect:/home";

    }
}
