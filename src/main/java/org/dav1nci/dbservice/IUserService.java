package org.dav1nci.dbservice;

import java.util.List;

/**
 * Created by dav1nci on 28.10.15.
 */
public interface IUserService
{
    public void addContact(UserEntity contact);

    public UserEntity getUser(String email);

    public List<UserEntity> listContact();

    public void removeContact(Integer id);
}
