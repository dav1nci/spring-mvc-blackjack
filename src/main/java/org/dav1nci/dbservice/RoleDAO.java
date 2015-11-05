package org.dav1nci.dbservice;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class RoleDAO implements IRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public UserProfile getRole(int id) {
        return (UserProfile)sessionFactory.getCurrentSession().load(UserProfile.class, id);
    }
}
