package org.dav1nci.dbservice.srviceinterface;

import org.dav1nci.playgame.CardEntity;

import java.util.List;

/**
 * Created by dav1nci on 20.12.15.
 */
public interface ICardService
{
    List<CardEntity> listCards();
    void updateCards(List<CardEntity> cards);
    void resetDeck();
    CardEntity getCard();
}
