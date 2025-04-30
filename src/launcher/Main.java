package launcher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a game:");
        System.out.println("1) Ride The Bus");
        System.out.println("2) Blackjack");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Calls RtB’s Main.main(...)
                RtB.Main.main(args);
                break;
            case 2:
                // Calls blackjack’s Main.main(...)
                blackjack.Main.main(args);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}