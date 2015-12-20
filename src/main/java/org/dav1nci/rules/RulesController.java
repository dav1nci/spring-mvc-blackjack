package org.dav1nci.rules;

import org.dav1nci.dbservice.serviceimplementation.HomeService;
import org.dav1nci.dbservice.RulesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dav1nci on 31.10.15.
 */
@Controller
public class RulesController
{
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/rules")
    public String rules(Model model)
    {
        model.addAttribute("content", homeService.listContact("RulesEntity"));
        model.addAttribute("row", new RulesEntity());
        return "rules/rules";
    }
}
