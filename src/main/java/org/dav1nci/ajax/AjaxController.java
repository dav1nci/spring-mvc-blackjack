package org.dav1nci.ajax;

import com.google.gson.Gson;
import org.dav1nci.dbservice.serviceimplementation.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dav1nci on 23.11.15.
 */
@RestController
public class AjaxController
{
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/show")
    public ResponseEntity<String> getResponce()
    {
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(forumService.listPost()), HttpStatus.OK);
    }
}
