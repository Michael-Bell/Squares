package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Michael on 2015-01-31.
 */
public class GameWorld {
    private Player player;

    public GameWorld(int midpointX, int midpointY){
        player = new Player(midpointX, midpointY, 16, 16);
    }

    public void update(float delta) {
        player.update(delta);
        player.getTrail().update();
    }

    public Player getPlayer(){
        return player;
    }
}
