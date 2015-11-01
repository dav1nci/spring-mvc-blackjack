package org.dav1nci.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dav1nci on 31.10.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class FAQService implements IFAQService {

    @Autowired
    private IFAQDAO ifaqdao;
    /*@Inject
    private IPagination ipagination;*/
    private static final int PAGE_SIZE = 10;

    @Override
    @Transactional
    public List<FAQEntity> getContent() {
        /*PageRequest request = new PageRequest(pageNumber-1, PAGE_SIZE, Sort.Direction.DESC, "startTime");*/
        return ifaqdao.getContent();
    }
}
