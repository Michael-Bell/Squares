package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Player;
import ca.michaelbell.gameobjects.easterEgg;


public class GameWorld {
    private Player player;
    private easterEgg egg;
    private int midpointX, midpointY;
    public easterEgg getEgg() {
        return egg;
    }

    public GameWorld(int midpointX, int midpointY) {
        player = new Player(midpointX, midpointY, 16, 16);
        egg = new easterEgg();
        this.midpointX = midpointX;
        this.midpointY = midpointY;
    }

    public void update(float delta) {
        player.update(delta);
        player.getTrail().update();
    }

    public Player getPlayer() {
        return player;
    }

    public int getMidpointX() {
        return midpointX;
    }

    public int getMidpointY() {
        return midpointY;
    }
}
