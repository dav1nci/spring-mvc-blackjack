package org.dav1nci.dbservice.daointerface;

import org.dav1nci.forum.CommentEntity;
import org.dav1nci.forum.ForumEntity;

import java.util.List;

/**
 * Created by dav1nci on 04.11.15.
 */
public interface IForumDAO {

    List<ForumEntity> listPost();
    void addPost(ForumEntity forumEntity);
    ForumEntity showPost(int id);
    void addComent(int id, CommentEntity commentEntity);
}
