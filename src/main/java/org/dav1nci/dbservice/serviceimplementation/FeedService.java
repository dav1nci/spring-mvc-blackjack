package org.dav1nci.dbservice.serviceimplementation;

import org.dav1nci.dbservice.daointerface.IFeedDAO;
import org.dav1nci.dbservice.srviceinterface.IFeedService;
import org.dav1nci.feed.FeedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dav1nci on 15.11.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class FeedService implements IFeedService {

    @Autowired
    private IFeedDAO iFeedDAO;

    @Override
    @Transactional
    public List<FeedEntity> listFeeds() {
        return iFeedDAO.listFeeds();
    }

    @Transactional
    @Override
    public void addFeed(FeedEntity forumEntity) {
        iFeedDAO.addFeed(forumEntity);
    }

    @Override
    @Transactional
    public FeedEntity showPost(int id) {
        return null;
    }
}
