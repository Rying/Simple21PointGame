package com.game;

import javax.naming.directory.Attribute;
import java.util.List;

public class Simple21PointGame {
    static final int MAXPOINT = 21;
    private Role role;
    private Cards cards;
    private int cardsIndex;
    private String result;
    private boolean over;


    public Simple21PointGame() {
        cards = new Cards();
        cardsIndex = 0;
        result = "";
        over = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Simple21PointGame)) return false;

        Simple21PointGame that = (Simple21PointGame) o;

        if (cardsIndex != that.cardsIndex) return false;
        if (!result.equals(that.result)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = role.PLAYER.hashCode();
        result1 = role.HOST.hashCode();
        result1 = 31 * result1 + cardsIndex;
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }

    public void start() {
        if (!over) {
            for (int i = 0; i < 2; i++) {
                role.PLAYER.hit(cards.getCard(cardsIndex++));
                role.HOST.hit(cards.getCard(cardsIndex++));

                role.PLAYER.backCard(i);
                role.HOST.backCard(i);
            }
            role = Role.PLAYER;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void hit() {
        if (!over) {
            role.hit(cards.getCard(cardsIndex));
            checkResult(role.PLAYER.getScore(), role.HOST.getScore());
        }
    }

    public void stay() {
        if (role.equals(Role.PLAYER))
            setRole(Role.HOST);
        else
            over = true;
    }

    public String getResult() {
        return result;
    }

    public void checkResult(int playerScore, int hostScore) {
        if (playerScore > MAXPOINT)
            result = "Host win!";
        else {
            if (getRole().equals(Role.HOST)) {
                if (over)
                    if (hostScore > MAXPOINT)
                        result = "Player win!";
                    else if (playerScore > hostScore)
                        result = "Player win!";
                    else if (playerScore < hostScore)
                        result = "Host win!";
                    else
                        result = "Equal!";

            }
        }
    }

    public void clean() {
        Role.PLAYER.clean();
        Role.HOST.clean();
        cardsIndex = 0;
        result = "";
        cards.Reshuffle();
        over = false;
    }

    public List<String> getCardPaths() {
        return role.getCards();
    }
}
