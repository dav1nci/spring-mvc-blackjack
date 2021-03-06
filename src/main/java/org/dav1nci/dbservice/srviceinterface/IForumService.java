package org.dav1nci.dbservice.srviceinterface;

import org.dav1nci.forum.CommentEntity;
import org.dav1nci.forum.ForumEntity;

import java.util.List;

/**
 * Created by dav1nci on 04.11.15.
 */
public interface IForumService
{
    public List<ForumEntity> listPost();
    public void addPost(ForumEntity forumEntity);
    ForumEntity showPost(int id);
    void addComment(int id, CommentEntity comment);
}
