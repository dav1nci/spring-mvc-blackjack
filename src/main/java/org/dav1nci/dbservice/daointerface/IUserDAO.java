package org.dav1nci.dbservice.daointerface;

import org.dav1nci.dbservice.UserEntity;

import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
public interface IUserDAO
{
    void addContact(UserEntity contact);

    List<UserEntity> listContact();

    UserEntity getUser(String email);

    void removeContact(Integer id);

}
