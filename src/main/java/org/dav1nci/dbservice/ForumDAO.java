package org.dav1nci.dbservice;

import org.dav1nci.forum.ForumEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by dav1nci on 04.11.15.
 */
@Repository
@EnableTransactionManagement
public class ForumDAO implements IForumDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ForumEntity> listPost() {
        return sessionFactory.getCurrentSession().createQuery("FROM ForumEntity").list();
    }

    @Override
    public void addPost(ForumEntity forumEntity) {
        sessionFactory.getCurrentSession().save(forumEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ForumEntity showPost(int id) {
        return (ForumEntity)sessionFactory.getCurrentSession().createQuery("FROM ForumEntity WHERE id=?").setParameter(0, id).list().get(0);
    }
}
