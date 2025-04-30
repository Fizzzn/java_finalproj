package game.mygame;
// inheritance from participant
public class Player extends Participant {
    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new hand();
    }

    public String getName() {
        return name;
    }
}
