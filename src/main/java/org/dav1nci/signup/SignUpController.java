package org.dav1nci.signup;

import org.dav1nci.dbservice.UserEntity;
import org.dav1nci.dbservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dav1nci on 27.10.15.
 */
@Controller
@Configuration
@ComponentScan("org.dav1nci.signup")
public class SignUpController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpForm(Model model)
    {
        model.addAttribute("user", new UserEntity());
        return "signup/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpFormSubmit(@ModelAttribute("user") UserEntity userEntity, @RequestParam ("confirmPassword") String confirmPas,  Model model)
    {
        userService.addContact(userEntity);
        model.addAttribute("userEntity", userEntity);
        model.addAttribute("confrimpass", confirmPas);
        return "signup/signupsuccess";
    }
}
