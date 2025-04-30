package Blackjack;
// usd in this class: abstraction and inheritance
public abstract class Participant {
    protected hand hand = new hand();

    public void newHand(deck deck) {
        this.hand = new hand();
        hand.drawHand(deck, 2);
    }

    public void hit(deck deck) {
        hand.drawHand(deck, 1);
    }

    public void showHand() {
        hand.showhand();
    }

    public int getHandValue() {
        return hand.getHandvalue();
    }

    public boolean hasBlackjack() {
        return hand.isBlackjack();
    }

    public void revealHand() {
        hand.showhand();
    }

    public void showOneCard() {
        hand.showOneCard();
    }
}


