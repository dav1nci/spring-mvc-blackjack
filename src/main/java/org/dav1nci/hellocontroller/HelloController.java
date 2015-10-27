package org.dav1nci.hellocontroller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class HelloController extends PropertyEditorSupport
{
    @InitBinder
    public void validate(WebDataBinder binder)
    {
        binder.setDisallowedFields(new String[]{"skills"});
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(sdf, false));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("registration_form");
        return modelAndView;
    }

    @ModelAttribute
    public void greetingMessage(Model model)
    {
        model.addAttribute("greetingMessage", "Hi useR!!!!!");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView rules(@Valid @ModelAttribute("user") User user, BindingResult result)
    {
        if (result.hasErrors())
        {
            ModelAndView modelAndView = new ModelAndView("registration_form");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("registration_success");
        return modelAndView;
    }
}
