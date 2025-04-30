package RtB.rounds;

import RtB.card;
import RtB.deck;
import java.util.Scanner;

public class Round2 {
    private Scanner scanner;
    private deck deck;
    private card prev;

    public Round2(Scanner scanner, deck deck, card prev) {
        this.scanner = scanner;
        this.deck = deck;
        this.prev = prev;
    }

    public card play() {
        System.out.println("Round 2: Guess if next is higher (1) or lower (2) than " + prev.getRank() + ":");
        int guess = scanner.nextInt();

        card c = deck.draw();
        boolean higher = c.getValue() > prev.getValue();
        if ((guess == 1) != higher) {
            // reveal card before exit
            System.out.println("It was " + c.toString());
            System.out.println("Your card: ");
            System.out.println(c.getcardASCII());
            System.out.println("You Lost, Thanks for Participating!");
            System.exit(0);
        }
        System.out.println("Correct! It was " + c.toString());
        System.out.println("Your card: ");
        System.out.println(c.getcardASCII());
        return c;
    }
}