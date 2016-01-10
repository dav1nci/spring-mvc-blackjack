package org.dav1nci.dbservice.daointerface;

import org.dav1nci.playgame.CardEntity;

import java.util.List;

/**
 * Created by dav1nci on 20.12.15.
 */
public interface ICardDAO
{
    List<CardEntity> listCards();
    void updateCards(CardEntity ... cards);
    void resetDeck();
    CardEntity getCard();
}
