package org.dav1nci.dbservice;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by dav1nci on 31.10.15.
 */
@Entity
@Table(name = "rules")
public class RulesEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "content")
    @Type(type = "text")
    private String content;

    public RulesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
