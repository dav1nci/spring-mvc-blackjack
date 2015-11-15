package org.dav1nci.dbservice;

import org.dav1nci.feed.FeedEntity;

import java.util.List;

/**
 * Created by dav1nci on 15.11.15.
 */
public interface IFeedService
{
    List<FeedEntity> listFeeds();
    void addFeed(FeedEntity forumEntity);
    FeedEntity showPost(int id);
}
