package org.dav1nci.dbservice;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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

        return sessionFactory.getCurrentSession().createQuery("from users").list();
    }

    public void removeContact(Integer id) {
        UserEntity contact = (UserEntity) sessionFactory.getCurrentSession().load(
                UserEntity.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }

    }
}
