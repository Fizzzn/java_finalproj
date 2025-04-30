package RtB;

public class card {
    private String rank;
    private String symbol;

    public card(String rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Numeric value used for comparisons: A=1, 2-10 as numbers, J=11, Q=12, K=13
     */
        /**
     * Numeric value used for comparisons: 2-10 as numbers, J=11, Q=12, K=13, A=14
     */
    public int getValue() {
        switch (rank) {
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return Integer.parseInt(rank);
        }
    }

    /**
     * Full suit name from symbol
     */
    public String getSuitName() {
        switch (symbol) {
            case "H": return "Hearts";
            case "D": return "Diamonds";
            case "C": return "Clubs";
            case "S": return "Spades";
            default:  return "Unknown";
        }
    }

    @Override
    public String toString() {
        return rank + " of " + getSuitName();
    }

    public String getcardASCII() {
        String top    = "┌─────────┐";
        String rankL  = String.format("│ %-2s      │", rank);
        String empty  = "│         │";
        String mid    = String.format("│    %s    │", symbol);
        String rankR  = String.format("│      %-2s │", rank);
        String bottom = "└─────────┘";
        return String.join("\n", top, rankL, empty, mid, empty, rankR, bottom);
    }
}