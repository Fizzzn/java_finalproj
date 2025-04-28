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

    public int getHandvalue(){
        int value = 0;
        int aceCount = 0;

        for(card card : hand){
            int cardValue = card.getvalue();
            value += cardValue;
            if(cardValue == 11){
                aceCount++;
            }
        }
            //adjusting acees values too easy
        while(value > 21 && aceCount > 0){
            value -= 10; // treating ace as 1 instead of 11
            aceCount--;
        }
        return value;
    }

}
