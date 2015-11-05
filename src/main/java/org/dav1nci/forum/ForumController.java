package org.dav1nci.forum;

import org.dav1nci.dbservice.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dav1nci on 04.11.15.
 */
@Controller
public class ForumController
{
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/forum")
    public String forum(Model model)
    {
        model.addAttribute("post", new ForumEntity());
        model.addAttribute("posts", forumService.listPost());
        return "forum/forum";
    }
}
