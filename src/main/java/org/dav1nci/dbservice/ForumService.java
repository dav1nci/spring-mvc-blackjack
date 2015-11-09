package org.dav1nci.dbservice;

import org.dav1nci.forum.CommentEntity;
import org.dav1nci.forum.ForumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dav1nci on 04.11.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class ForumService implements IForumService
{
    @Autowired
    private IForumDAO iForumDAO;

    @Override
    @Transactional
    public List<ForumEntity> listPost() {
        return iForumDAO.listPost();
    }

    @Override
    @Transactional
    public void addPost(ForumEntity forumEntity) {
        iForumDAO.addPost(forumEntity);
    }

    @Override
    @Transactional
    public ForumEntity showPost(int id) {
        return iForumDAO.showPost(id);
    }

    @Override
    @Transactional
    public void addComment(int id, CommentEntity comment) {
        ForumEntity forumEntity = showPost(id);
        forumEntity.getComments().add(comment);
    }
}
