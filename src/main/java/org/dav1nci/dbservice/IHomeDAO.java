package org.dav1nci.dbservice;

import java.util.List;

/**
 * Created by dav1nci on 29.10.15.
 */
public interface IHomeDAO
{
    public List<HomeEntity> getContent();
    public void save(HomeEntity homeEntity);
}
