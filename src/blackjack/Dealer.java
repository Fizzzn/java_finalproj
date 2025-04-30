package blackjack;
// inheritance from participant
public class Dealer extends Participant {

    public Dealer() {
        this.hand = new hand();
    }

    public void playTurn(Deck deck) {
        System.out.println("\nDealer's Turn:");
        while (hand.getHandvalue() < 17) {
            System.out.println("Dealer hits.");
            hand.drawHand(deck, 1);
            hand.showhand();
        }
    }
}
