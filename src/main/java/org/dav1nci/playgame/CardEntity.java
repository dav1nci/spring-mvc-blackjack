package org.dav1nci.playgame;

import javax.persistence.*;

/**
 * Created by dav1nci on 20.12.15.
 */
@Entity
@Table(name = "cards")
public class CardEntity
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "lear")
    private String lear;
    @Column(name = "value")
    private String value;
    @Column(name = "cost")
    private int cost;
    @Column(name = "in_deck")
    private int inDeck;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLear() {
        return lear;
    }

    public void setLear(String lear) {
        this.lear = lear;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getInDeck() {
        return inDeck;
    }

    public void setInDeck(int inDeck) {
        this.inDeck = inDeck;
    }
}
