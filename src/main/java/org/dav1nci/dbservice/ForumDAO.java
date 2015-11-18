package org.dav1nci.dbservice;

import org.dav1nci.forum.CommentEntity;
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
    @SuppressWarnings("unchecked")
    public List<ForumEntity> listPost() {
        return sessionFactory.getCurrentSession().createQuery("FROM ForumEntity ORDER BY date").list();
    }

    @Override
    public void addPost(ForumEntity forumEntity) {
        sessionFactory.getCurrentSession().persist(forumEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ForumEntity showPost(int id) {
        return (ForumEntity)sessionFactory.getCurrentSession().createQuery("FROM ForumEntity WHERE id=?").setParameter(0, id).list().get(0);
    }

    @Override
    public void addComent(int id, CommentEntity commentEntity) {
        ForumEntity forumEntity = (ForumEntity)sessionFactory.getCurrentSession().createQuery("FROM ForumEntity WHERE id=?").setParameter(0, id).list().get(0);
        //commentEntity.setPost(forumEntity);
        forumEntity.getComments().add(commentEntity);
        sessionFactory.getCurrentSession().save(commentEntity);
        sessionFactory.getCurrentSession().update(forumEntity);
    }

}
