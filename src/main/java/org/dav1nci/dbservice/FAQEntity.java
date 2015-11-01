package org.dav1nci.dbservice;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by dav1nci on 31.10.15.
 */
@Entity
@Table(name = "faq")
public class FAQEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "question")
    @Type(type = "text")
    private String question;
    @Column(name = "answer")
    @Type(type = "text")
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
