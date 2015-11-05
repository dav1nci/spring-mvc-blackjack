package org.dav1nci.dbservice;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
@Repository
@EnableTransactionManagement
public class UserDAO implements IUserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(UserEntity contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> listContact() {
        List<UserEntity> usersList = sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
        return usersList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEntity getUser(String email) {
        List<UserEntity> users = sessionFactory.getCurrentSession().createQuery("FROM UserEntity WHERE email='" + email + "'").list();
        if (users.size() > 0)
            return users.get(0);
        return null;
    }

    public void removeContact(Integer id) {
        UserEntity contact = (UserEntity) sessionFactory.getCurrentSession().load(UserEntity.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }

    }
}
