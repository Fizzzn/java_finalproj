package RtB.rounds;

import RtB.card;
import RtB.deck;
import java.util.Scanner;

public class Round3 {
    private Scanner scanner;
    private deck deck;
    private card c1, c2;

    public Round3(Scanner scanner, deck deck, card c1, card c2) {
        this.scanner = scanner;
        this.deck = deck;
        this.c1 = c1;
        this.c2 = c2;
    }

    public card play() {
        // Determine lower and upper bound cards
        card lowCard = (c1.getValue() <= c2.getValue()) ? c1 : c2;
        card highCard = (c1.getValue() >  c2.getValue()) ? c1 : c2;
        System.out.println("Round 3: Guess inside (1) or outside (2) range [" + 
            lowCard.getRank() + "–" + highCard.getRank() + "]:");
        int guess = scanner.nextInt();

        card c = deck.draw();
        boolean inside = c.getValue() > lowCard.getValue() && c.getValue() < highCard.getValue();
        // Reveal drawn card
        System.out.println("It was " + c.toString());
        System.out.println("Your card: ");
        System.out.println(c.getcardASCII());
        if ((guess == 1) != inside) {
            System.out.println("You Lost, Thanks for Participating!");
            System.exit(0);
        }
        System.out.println("Correct!");
        return c;
    }
}