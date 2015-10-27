package org.dav1nci.hellocontroller;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dav1nci on 17.10.15.
 */
public class User
{
    @Size(min = 3, max = 10)
    private String userName;
    private String email;
    private String message;
    private Date date;
    private ArrayList<String> skills;

    public User() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
