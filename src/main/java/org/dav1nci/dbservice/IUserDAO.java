package org.dav1nci.dbservice;

import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
public interface IUserDAO
{
    public void addContact(UserEntity contact);

    public List<UserEntity> listContact();

    public UserEntity getUser(String email);

    public void removeContact(Integer id);
}
