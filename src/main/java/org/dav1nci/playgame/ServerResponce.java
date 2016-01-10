package org.dav1nci.playgame;

import java.util.List;

/**
 * Created by dav1nci on 07.01.16.
 */
public class ServerResponce
{
    private int scoreDealer;
    private int scorePlayer;
    private List<CardEntity> cards;
    private int win;

    public int getScoreDealer() {
        return scoreDealer;
    }

    public void setScoreDealer(int scoreDealer) {
        this.scoreDealer = scoreDealer;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public List<CardEntity> getCards() {
        return cards;
    }

    public void setCards(List<CardEntity> cards) {
        this.cards = cards;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
