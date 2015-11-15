package org.dav1nci.dbservice;

import org.dav1nci.feed.FeedEntity;
import org.dav1nci.forum.ForumEntity;

import java.util.List;

/**
 * Created by dav1nci on 14.11.15.
 */
public interface IFeedDAO
{
    List<FeedEntity> listFeeds();
    void addFeed(FeedEntity forumEntity);
    FeedEntity showPost(int id);
}
