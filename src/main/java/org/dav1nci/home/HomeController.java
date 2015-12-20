package org.dav1nci.home;

import org.dav1nci.dbservice.*;
import org.dav1nci.dbservice.serviceimplementation.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dav1nci on 27.10.15.
 */
@Controller
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

    @RequestMapping(value="/signout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/ajaxdemo", method = RequestMethod.GET)
    public @ResponseBody String ajaxTest()
    {
        System.out.println("I'm in AJAX TEST CONTROLLER");
        return "Hello WORLD!!! FROM SERVER!!!! WITH LOVE!!!";
    }
}
