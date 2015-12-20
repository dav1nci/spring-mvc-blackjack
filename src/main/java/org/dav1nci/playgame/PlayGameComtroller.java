package org.dav1nci.playgame;

import org.dav1nci.dbservice.HomeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dav1nci on 20.12.15.
 */
@Controller
public class PlayGameComtroller
{
    @RequestMapping(value = "/game")
    public String home(Model model)
    {

        return "playgame/gamefield";
    }
}
