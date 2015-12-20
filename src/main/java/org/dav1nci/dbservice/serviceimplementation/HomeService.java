package org.dav1nci.dbservice.serviceimplementation;

import org.dav1nci.dbservice.HomeEntity;
import org.dav1nci.dbservice.daointerface.IHomeDAO;
import org.dav1nci.dbservice.srviceinterface.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dav1nci on 29.10.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class HomeService implements IHomeService
{
    @Autowired
    private IHomeDAO iHomeDAO;

    @Override
    @Transactional
    public List<HomeEntity> listContact(String tableName) {
        return iHomeDAO.getContent(tableName);
    }

    @Override
    @Transactional
    public void save(HomeEntity homeEntity) {
        iHomeDAO.save(homeEntity);
    }



}
