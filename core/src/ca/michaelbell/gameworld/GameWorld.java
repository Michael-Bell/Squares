package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Player;


public class GameWorld {
    private Player player;

    public GameWorld(int midpointX, int midpointY) {
        player = new Player(midpointX, midpointY, 16, 16);
    }

    public void update(float delta) {
        player.update(delta);
        player.getTrail().update();
    }

    public Player getPlayer() {
        return player;
    }
}
