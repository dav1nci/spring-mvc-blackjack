package org.dav1nci.signup;

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
public class SignUpController
{
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpForm(Model model)
    {
        model.addAttribute("user", new User());
        return "signup/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpFormSubmit(@ModelAttribute User user, @RequestParam ("confirmPassword") String confirmPas,  Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("confrimpass", confirmPas);
        return "signup/signupsuccess";
    }
}
