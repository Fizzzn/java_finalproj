package RtB;

import java.util.*;

public class deck {
    private List<card> cards;

    public deck() {
        cards = new ArrayList<>();
        String[] suits = {"H","D","C","S"};
        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public card draw() {
        if (cards.isEmpty()) throw new NoSuchElementException("Deck is empty");
        return cards.remove(0);
    }
}