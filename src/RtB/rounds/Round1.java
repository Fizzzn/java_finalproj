package RtB.rounds;

import RtB.card;
import RtB.deck;
import java.util.Scanner;

public class Round1 {
    private Scanner scanner;
    private deck deck;

    public Round1(Scanner scanner, deck deck) {
        this.scanner = scanner;
        this.deck = deck;
    }

    public card play() {
        System.out.println("Round 1: Guess the color (1=Red, 2=Black):");
        int guess = scanner.nextInt();

        card c = deck.draw();
        int color = (c.getSymbol().equals("H") || c.getSymbol().equals("D")) ? 1 : 2;
        String colorName = (color == 1) ? "Red" : "Black";

        if (guess != color) {
            System.out.println("It was " + colorName);
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