package game.mygame;

import java.util.*;

public class hand {
    private List<card> hand = new ArrayList<>();

    public void drawHand(deck deck, int count) {
        for (int i = 0; i < count; i++) {
            hand.add(deck.draw());
        }
    }

    public void showhand() {
        for (int line = 0; line < 7; line++) {
            for (card card : hand) {
                System.out.print(card.getcardoneline(line) + " ");
            }
            System.out.println();
        }
    }

    public void showOneCard() {
        for (int line = 0; line < 7; line++) {
            // Show first card fully
            System.out.print(hand.get(0).getcardoneline(line) + " ");

            // Show back of card for the rest
            for (int i = 1; i < hand.size(); i++) {
                System.out.print(getHiddenCardLine(line) + " ");
            }
            System.out.println();
        }
    }
    //hiding card
    private String getHiddenCardLine(int line) {
        String[] hidden = {
            "┌─────────┐",
            "│░░░░░░░░░│",
            "│░░░░░░░░░│",
            "│░░ HIDDEN ░│",
            "│░░░░░░░░░│",
            "│░░░░░░░░░│",
            "└─────────┘"
        };
        return hidden[line];
    }

    public int getHandvalue() {
        int value = 0;
        int aceCount = 0;
        for (card card : hand) {
            int cardValue = card.getvalue();
            value += cardValue;
            if (cardValue == 11) {
                aceCount++;
            }
        }
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }
        return value;
    }
    public boolean isBlackjack() {
        return hand.size() == 2 && getHandvalue() == 21;
    }
    
}
