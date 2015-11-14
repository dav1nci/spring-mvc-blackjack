package org.dav1nci.feed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rometools.rome.io.WireFeedOutput;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;

/**
 * Created by dav1nci on 14.11.15.
 */
public class CustomRssView {

    static Channel createChannel()
    {
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("My firs RSS title");
        channel.setDescription("My first RSS description.");
        channel.setLink("http://myIPAddress:portNo/WebAppName");
        return channel;
    }

    static Item createItem()
    {
        Item item = new Item();
        item.setTitle("Article first");
        return item;
    }

    static Channel addItemsToChannel(Channel channel, Item item)
    {
        List items = (List) channel.getItems();
        if (items == null)
            items = new ArrayList();
        items.add(item);
        channel.setItems(items);
        return channel;
    }

    static boolean publishRssChannel(Channel channel)
    {
        try {
            File RSSDoc = new File("rssfeed.rss");
            System.out.println(RSSDoc.getAbsolutePath());
            if (!RSSDoc.exists())
                RSSDoc.createNewFile();
            WireFeedOutput wfo = new WireFeedOutput();
            wfo.output(channel, RSSDoc);
        } catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}
