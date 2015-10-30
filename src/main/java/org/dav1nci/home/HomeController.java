package org.dav1nci.home;

import org.dav1nci.dbservice.HomeEntity;
import org.dav1nci.dbservice.HomeService;
import org.dav1nci.dbservice.UserEntity;
import org.dav1nci.dbservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dav1nci on 27.10.15.
 */
@Controller
@ComponentScan("org.dav1nci.home")
public class HomeController
{
    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/")
    public String home(Model model)
    {
        model.addAttribute("row", new HomeEntity());
        model.addAttribute("content", homeService.listContact());
        return "home/home";
    }
}
