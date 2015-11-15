package org.dav1nci.feed;

import org.dav1nci.dbservice.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dav1nci on 14.11.15.
 */
@Controller
public class FeedController
{

    @Autowired
    private FeedService feedService;

    @RequestMapping(value = "/feed")
    public String feed()
    {
        return "redirect:/";
    }

    @RequestMapping(value = "/rss", method = RequestMethod.GET)
    public ModelAndView getFeed(Model model)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rssViewer");
        mav.addObject("feedContent", feedService.listFeeds());
        return mav;
    }
}
