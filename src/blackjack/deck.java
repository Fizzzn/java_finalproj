package blackjack;
import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] symbols = {"H", "D", "C", "S"}; // String[] symbols = {"♥", "♦", "♣", "♠"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < suits.length; i++) {
            String symbol = symbols[i];
            for (String rank : ranks) {
                cards.add(new Card(rank, symbol)); 
            }
        }
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}
