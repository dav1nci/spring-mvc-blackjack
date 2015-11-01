package org.dav1nci.dbservice;

import java.util.List;

/**
 * Created by dav1nci on 29.10.15.
 */
public interface IHomeService
{
    public List<HomeEntity> listContact(String tableName);
    public void save(HomeEntity homeEntity);
}
