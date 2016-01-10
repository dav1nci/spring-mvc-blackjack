package org.dav1nci.dbservice.daoimplementation;

import org.dav1nci.dbservice.daointerface.ICardDAO;
import org.dav1nci.playgame.CardEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Random;

/**
 * Created by dav1nci on 20.12.15.
 */
@Repository
@EnableTransactionManagement
public class CardDAO implements ICardDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<CardEntity> listCards() {
        return sessionFactory.getCurrentSession().createQuery("from CardEntity where in_deck = 1").list();
    }

    @Override
    public void updateCards(CardEntity ... cards)
    {
        for (CardEntity i : cards)
            sessionFactory.getCurrentSession().update(i);
    }

    @Override
    public void resetDeck() {
        sessionFactory.getCurrentSession().createQuery("UPDATE CardEntity SET in_deck = 1").executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public CardEntity getCard()
    {
        List<CardEntity> deck = listCards();
        if (deck.size() == 0)
            return null;
        Random random = new Random();
        while (true)
        {
            int card_id = random.nextInt(53);
            for (CardEntity card : deck)
            {
                if (card.getId() == card_id)
                {
                    card.setInDeck(0);
                    updateCards(card);
                    return card;
                }
            }
        }
    }


}
