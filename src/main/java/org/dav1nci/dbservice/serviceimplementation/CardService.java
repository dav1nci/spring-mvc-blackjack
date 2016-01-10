package org.dav1nci.dbservice.serviceimplementation;

import org.dav1nci.dbservice.daointerface.ICardDAO;
import org.dav1nci.dbservice.srviceinterface.ICardService;
import org.dav1nci.playgame.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dav1nci on 20.12.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class CardService implements ICardService
{
    @Autowired
    private ICardDAO cardDAO;

    @Transactional
    @Override
    public List<CardEntity> listCards() {
        return cardDAO.listCards();
    }

    @Transactional
    @Override
    public void updateCards(List<CardEntity> cards) {
        /*cardDAO.updateCards(cards);*/
    }

    @Transactional
    @Override
    public void resetDeck() {
        cardDAO.resetDeck();
    }

    @Transactional
    @Override
    public CardEntity getCard() {
        return cardDAO.getCard();
    }
}
