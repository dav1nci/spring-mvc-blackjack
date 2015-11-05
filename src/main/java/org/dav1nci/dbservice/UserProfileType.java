package org.dav1nci.dbservice;

/**
 * Created by dav1nci on 05.11.15.
 */
public enum UserProfileType
{
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }
}
