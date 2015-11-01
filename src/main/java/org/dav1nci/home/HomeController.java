package org.dav1nci.home;

import org.dav1nci.dbservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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
    private UserService homeService;

    @RequestMapping(value = "/")
    public String home(Model model)
    {
        /*UserEntity user = homeService.getUser("dimskii@mail.zp.ua");
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(Roles.USER.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
        model.addAttribute("row", new HomeEntity());
        model.addAttribute("content", );*/
        return "home/home";
    }
}
