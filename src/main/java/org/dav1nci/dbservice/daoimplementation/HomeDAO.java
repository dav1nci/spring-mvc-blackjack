package org.dav1nci.dbservice.daoimplementation;

import org.dav1nci.dbservice.HomeEntity;
import org.dav1nci.dbservice.daointerface.IHomeDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by dav1nci on 29.10.15.
 */
@Repository
@EnableTransactionManagement
public class HomeDAO implements IHomeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<HomeEntity> getContent(String tableName)
    {
       /* List<HomeEntity> list = sessionFactory.getCurrentSession().createQuery("from " + tableName).list();
        for (HomeEntity i : list)
        {
            System.out.println(i.getContent());
        }*/
        return (List<HomeEntity>)sessionFactory.getCurrentSession().createQuery("from " + tableName).list();
    }

    @Override
    public void save(HomeEntity homeEntity) {
        sessionFactory.getCurrentSession().save(homeEntity);
    }
}
