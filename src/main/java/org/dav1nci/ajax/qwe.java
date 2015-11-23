package org.dav1nci.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dav1nci on 23.11.15.
 */
@Controller
public class qwe
{
    @RequestMapping(value = "/ajaxjsp")
    public String page()
    {
        return "ajax/ajaxdemo";
    }
}
