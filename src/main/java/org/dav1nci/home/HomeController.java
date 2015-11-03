package org.dav1nci.home;

import org.dav1nci.dbservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<HomeEntity> list = homeService.listContact("HomeEntity");
        for (HomeEntity i : list)
        {
            System.out.println(i.getContent());
        }
        model.addAttribute("row", new HomeEntity());
        model.addAttribute("content", list);
        return "home/home";
    }
}
