package org.dav1nci.home;

import org.dav1nci.dbservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dav1nci on 27.10.15.
 */
@Controller
@ComponentScan("org.dav1nci.home")
public class HomeController
{
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/")
    public String home(Model model)
    {
        model.addAttribute("row", new HomeEntity());
        model.addAttribute("content", homeService.listContact("HomeEntity"));
        return "home/home";
    }

/*    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model)
    {
        model.addAttribute("user", getPrincipal());
        return "home/admin";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(Model model)
    {
        model.addAttribute("user", getPrincipal());
        return "home/dba";
    }*/

    @RequestMapping(value="/signout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:home/signin?signout";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
