package org.dav1nci.playgame;

/**
 * Created by dav1nci on 10.01.16.
 */
public class ServerRequest
{
    private int scorePlayer;
    private int isAce;

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public int getIsAce() {
        return isAce;
    }

    public void setIsAce(int isAce) {
        this.isAce = isAce;
    }
}
