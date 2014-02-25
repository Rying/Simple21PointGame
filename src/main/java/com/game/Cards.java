package com.game;


import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class Cards {

    public static final int TOTAL = 52;
    private List<Card> cards;

    public Cards() {
        cards = new ArrayList<Card>();
        String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suit = {"Club", "Diamond", "Heart", "Spade"};

        for (String s : suit) {
            for (String f : face) {
                cards.add(new Card(f, s));
            }
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void oneReshuffle(Random random) {
        int splitPosition = random.nextInt(TOTAL);
        for (int index = 0; index + splitPosition < TOTAL; index++) {
            swap(cards, index, index + splitPosition);
        }
    }
}
