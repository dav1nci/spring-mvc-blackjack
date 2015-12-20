package org.dav1nci.dbservice.daoimplementation;

import org.dav1nci.dbservice.daointerface.IFeedDAO;
import org.dav1nci.feed.FeedEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by dav1nci on 14.11.15.
 */
@Repository
@EnableTransactionManagement
public class FeedDAO implements IFeedDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<FeedEntity> listFeeds() {
        return (List<FeedEntity>)sessionFactory.getCurrentSession().createQuery("FROM FeedEntity").list();
    }

    @Override
    public void addFeed(FeedEntity forumEntity) {
        sessionFactory.getCurrentSession().save(forumEntity);
    }

    @Override
    public FeedEntity showPost(int id) {
        return null;
    }
}
