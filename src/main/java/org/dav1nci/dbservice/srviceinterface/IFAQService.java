package org.dav1nci.dbservice.srviceinterface;

import org.dav1nci.dbservice.FAQEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dav1nci on 31.10.15.
 */
public interface IFAQService
{
    public List<FAQEntity> getContent();

}
