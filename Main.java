package game.mygame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        deck deck = new deck();
        hand player = new hand();
        hand dealer = new hand();
        Scanner scanner = new Scanner(System.in);

        player.drawHand(deck, 1);
        player.drawHand(deck, 1);

        //PLAYERS TURN
        boolean playerTurnn = true;
        while(playerTurnn){
            System.out.println("Your Hand");
            player.showhand();
            System.out.println("Total value:" + player.getHandvalue());
        //loss condition
        if(player.getHandvalue() > 21){
            System.out.println("You bust! dealer wins!");
            return;
        }
        // move
        System.out.println("Hit(h) or Stand(s)?");
        String move = scanner.nextLine();

        if (move.equalsIgnoreCase("h")) {
            player.drawHand(deck, 1);
        } else {
            playerTurnn = false;
        }
     }

     //DEALER TURN
     System.out.println("\nDealer's hand:");
     dealer.showhand();
     while(dealer.getHandvalue() < 17){
        System.out.println("Dealer hits.");
        dealer.drawHand(deck, 1);
        dealer.showhand();
     }
     if(dealer.getHandvalue() > 21){
        System.out.println("Dealer busts! You win!!");
        return;
     }

     // comparing dealer and player hands

        int playerValue = player.getHandvalue();
        int dealerValue = dealer.getHandvalue();

        System.out.println("\nFinal Results: ");
        System.out.println("Your total: ");
        System.out.println("Dealers total: ");

        if(playerValue > dealerValue){
            System.out.println("You win!");
        }
            else if(playerValue < dealerValue){
                System.out.println("dealer wins!"); 
            }
                else{
                    System.out.println("STANDOFF(tie...)");
                }
        




       //TEST-- cards drawn -- hand.drawHand(deck, 5); // Draw 5 cards
       //TEST-- cards print -- hand.showhand();        // Print them
    }
}
