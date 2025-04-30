package RtB.rounds;

import RtB.card;
import RtB.deck;
import java.util.Scanner;

public class Round4 {
    private Scanner scanner;
    private deck deck;

    public Round4(Scanner scanner, deck deck) {
        this.scanner = scanner;
        this.deck = deck;
    }

    public card play() {
        System.out.println("Round 4: Guess the suit (1=Hearts, 2=Diamonds, 3=Clubs, 4=Spades):");
        int guess = scanner.nextInt();

        card c = deck.draw();
        String expected = new String[]{"H","D","C","S"}[guess - 1];
        if (!c.getSymbol().equals(expected)) {
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