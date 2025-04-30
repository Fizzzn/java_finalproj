package RtB;

import java.util.Scanner;
import RtB.rounds.Round1;
import RtB.rounds.Round2;
import RtB.rounds.Round3;
import RtB.rounds.Round4;

public class Game {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        deck deck = new deck();

        card c1 = new Round1(scanner, deck).play();
        card c2 = new Round2(scanner, deck, c1).play();
        // Pass the second card (c2) and first card (c1) into Round3
        new Round3(scanner, deck, c1, c2).play();
        new Round4(scanner, deck).play();

        scanner.close();
        System.out.println("Congratulations! You completed Ride The Bus!");
    }
}