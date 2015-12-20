package org.dav1nci.dbservice.daoimplementation;

import org.dav1nci.dbservice.FAQEntity;
import org.dav1nci.dbservice.daointerface.IFAQDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by dav1nci on 31.10.15.
 */
@Repository
@EnableTransactionManagement
public class FAQDAO implements IFAQDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<FAQEntity> getContent() {
        return sessionFactory.getCurrentSession().createQuery("from FAQEntity").list();
    }
}
