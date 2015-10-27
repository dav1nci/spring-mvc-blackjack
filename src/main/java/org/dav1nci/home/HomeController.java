package org.dav1nci.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dav1nci on 27.10.15.
 */
@Controller
public class HomeController
{
    @RequestMapping(value = "/")
    public String home()
    {
        return "home/home";
    }
}
