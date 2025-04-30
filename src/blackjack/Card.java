package blackjack;

public class Card {
    private String rank;
    private String symbol;

    public Card(String rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public String getcardASCII() {
        String top = "┌─────────┐";
        String empty = "│         │";
        String mid = String.format("│    %s    │", symbol);
        String rankLeft = String.format("│ %-2s      │", rank);
        String rankRight = String.format("│      %-2s │", rank);
        String bottom = "└─────────┘";

        return String.join("\n", top, rankLeft, empty, mid, empty, rankRight, bottom);
    }

    public String getcardoneline(int line) {
        String[] lines = getcardASCII().split("\n");
        return lines[line];
    }

    public int getvalue() {
        switch (rank) {
            case "A":
                return 11; // Can be treated as 1 later based on hand logic
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(rank); // 2–10
        }
    }
}
