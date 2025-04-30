package game.mygame;

import java.io.*;
import java.util.Scanner;

public class gamemanager {
    private static final int STARTING_CREDITS = 100;
    private int highScore;
    private int credits;
    private int currentBet;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public gamemanager(String playerName) {
        this.player = new Player(playerName);
        this.dealer = new Dealer();
        this.credits = STARTING_CREDITS;
        this.highScore = loadHighScore();
        this.scanner = new Scanner(System.in);
    }

    public void startGameLoop() {
        while (credits > 0) {
            System.out.println("\nCredits: " + credits);

            // Asking bet amount
            while (true) {
                System.out.print("How much would you like to bet? (Available: " + credits + "): ");
                try {
                    currentBet = Integer.parseInt(scanner.nextLine());
                    if (currentBet > 0 && currentBet <= credits) {
                        break;
                    } else {
                        System.out.println("Invalid bet amount.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            deck deck = new deck();
            player.newHand(deck);
            dealer.newHand(deck);

            boolean playerBJ = player.hasBlackjack();
            boolean dealerBJ = dealer.hasBlackjack();

            if (playerBJ || dealerBJ) {
                System.out.println("\nYour hand:");
                player.showHand();
                System.out.println("Total: " + player.getHandValue());

                System.out.println("\nDealer's hand:");
                dealer.revealHand();
                System.out.println("Total: " + dealer.getHandValue());

                if (playerBJ && dealerBJ) {
                    System.out.println("Both have Blackjack! It's a tie.");
                } else if (playerBJ) {
                    System.out.println(
    "██████╗ ██╗      █████╗  ██████╗██╗  ██╗      ██╗  ████╗  ██████╗ ██╗  ██╗\n" +
    "██╔══██╗██║     ██╔══██╗██╔════╝██║ ██╔╝      ██║ ██╔══██╗██╔═══╝ ██║ ██╔╝\n" +
    "██████╔╝██║     ███████║██║     █████╔╝  ██   ██║ ███████║██║     █████╔╝\n" +
    "██╔══██ ██║     ██╔══██║██║     ██╔═██╗  ██   ██║ ██╔══██║██║     ██╔═██╗\n" +
    "███████ ███████╗██║  ██║╚██████╗██║  ██╗ ╚█████╔╝ ██║  ██║╚██████╗██║  ██╗\n" +
    "╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝  ╚════╝  ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝\n"+
                    "Blackjack! You win with a 3:2 bonus payout!");
                    credits += (int)(currentBet * 1.5);
                } else {
                    System.out.println("Dealer has Blackjack! You lose.");
                    credits -= currentBet;
                }

                if (credits > highScore) {
                    highScore = credits;
                    saveHighScore(highScore);
                }

                if (credits <= 0) {
                    System.out.println("\nGAME OVER! Final credits: 0");
                    System.out.println("Highest credits earned: " + highScore);
                    break;
                }

                System.out.print("\nWould you like to play another round? (y/n): ");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Thanks for playing! Final credits: " + credits);
                    System.out.println("Highest credits earned: " + highScore);
                    break;
                } else {
                    continue;
                }
            }

            // Dealer doing dealer things by only showing one card
            System.out.println("\nDealer's visible card:");
            dealer.showOneCard();

            // Player Turn
            while (true) {
                System.out.println("\nYour Hand:");
                player.showHand();
                System.out.println("Total value: " + player.getHandValue());

                if (player.getHandValue() > 21) {
                    System.out.println("You bust! Dealer wins!");
                    credits -= currentBet;
                    break;
                }

                System.out.print("Hit (h) or Stand (s)? ");
                String move = scanner.nextLine();

                if (move.equalsIgnoreCase("h")) {
                    player.hit(deck);
                } else {
                    break;
                }
            }

            if (player.getHandValue() <= 21) {
                System.out.println("\nDealer's full hand revealed:");
                dealer.revealHand();
                dealer.playTurn(deck);

                System.out.println("\nFinal Results:");
                System.out.println("Your total: " + player.getHandValue());
                System.out.println("Dealer total: " + dealer.getHandValue());

                if (dealer.getHandValue() > 21 || player.getHandValue() > dealer.getHandValue()) {
                    System.out.println("You win!");
                    credits += currentBet;
                } else if (player.getHandValue() < dealer.getHandValue()) {
                    System.out.println("Dealer wins!");
                    credits -= currentBet;
                } else {
                    System.out.println("STANDOFF (tie...)");
                }
            }

            if (credits > highScore) {
                highScore = credits;
                saveHighScore(highScore);
            }

            if (credits <= 0) {
                System.out.println("\nGAME OVER! Final credits: 0");
                System.out.println("Highest credits earned: " + highScore);
                break;
            }

            System.out.print("\nWould you like to play another round? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing! Final credits: " + credits);
                System.out.println("Highest credits earned: " + highScore);
                break;
            }
        }
    }

    private int loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            return STARTING_CREDITS;
        }
    }

    private void saveHighScore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"))) {
            writer.write(String.valueOf(score));
        } catch (IOException e) { //fail case if high score not obtained
            System.out.println("Failed to save high score.");
        }
    }
}
