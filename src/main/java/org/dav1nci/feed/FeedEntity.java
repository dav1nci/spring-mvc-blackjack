package org.dav1nci.feed;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dav1nci on 14.11.15.
 */
@Repository
public class FeedEntity
{
    private int id;
    private String title;
    private String description;
    private String link;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<FeedEntity> createFeed() {
        List<FeedEntity> feeds = new ArrayList<>();
        FeedEntity feed1 = new FeedEntity();
        feed1.setId(100);
        feed1.setTitle("Title one");
        feed1.setDescription("This is description one");
        feed1.setLink("http://www.urlone.com");
        feed1.setDate(new Date());
        feeds.add(feed1);
        FeedEntity feed2 = new FeedEntity();
        feed2.setId(200);
        feed2.setTitle("Title two");
        feed2.setDescription("This is description two");
        feed2.setLink("http://www.urltwo.com");
        feed2.setDate(new Date());
        feeds.add(feed2);
        return feeds;
    }
}
