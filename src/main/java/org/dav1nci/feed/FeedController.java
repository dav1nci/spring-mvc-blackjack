package org.dav1nci.feed;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Item;
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
    private FeedEntity feedEntity;

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String getFeed(Model model)
    {
        Channel channel = CustomRssView.createChannel();
        Item item = CustomRssView.createItem();
        CustomRssView.addItemsToChannel(channel, item);
        CustomRssView.publishRssChannel(channel);
        return "home/home";
    }
}
