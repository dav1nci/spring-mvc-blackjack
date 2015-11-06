package org.dav1nci.forum;

import org.dav1nci.dbservice.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;
import java.util.Random;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPostGet(Model model)
    {
        model.addAttribute("post", new ForumEntity());
        return "forum/addpost";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPostPost(@ModelAttribute("post") ForumEntity post, Model model, Principal principal)
    {
        Random rnd = new Random();
        post.setAuthor(principal.getName());
        post.setDate(new Date());
        post.setRating(rnd.nextInt(5));
        forumService.addPost(post);
        return "redirect:/forum";
    }

    @RequestMapping(value = "/forum/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") int id, Model model)
    {
        ForumEntity forumEntity = forumService.showPost(id);
        model.addAttribute("post", forumEntity);
        return "forum/showpost";
    }
}
