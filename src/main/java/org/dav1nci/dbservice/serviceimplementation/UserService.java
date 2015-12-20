package org.dav1nci.dbservice.serviceimplementation;

import org.dav1nci.dbservice.UserEntity;
import org.dav1nci.dbservice.daointerface.IUserDAO;
import org.dav1nci.dbservice.srviceinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class UserService implements IUserService {
    @Autowired
    private IUserDAO contactDAO;

    @Transactional
    public void addContact(UserEntity contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    @Override
    public UserEntity getUser(String email) {
        return contactDAO.getUser(email);
    }

    @Transactional
    public List<UserEntity> listContact() {

        return contactDAO.listContact();
    }

    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }
}
