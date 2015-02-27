package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.*;

import java.util.ArrayList;
import java.util.Iterator;

public class GameWorld {
    private Player player;
    private easterEgg egg;
    private int midpointX, midpointY;

    private ArrayList<Square> squareList;
    private Enemy enemy;
    private CollisionHandler collisionHandler;

    public GameWorld(int midpointX, int midpointY) {
        squareList = new ArrayList<Square>();
        enemy = new Enemy(midpointX - 100, 5, 16, 16, this);
        player = new Player(midpointX, midpointY, 16, 16, this);
        enemy.Down();
        egg = new easterEgg();
        this.midpointX = midpointX;
        this.midpointY = midpointY;
        collisionHandler = new CollisionHandler(this);
    }

    public easterEgg getEgg() {
        return egg;
    }

    public void update(float delta) {
        Iterator<Square> squareIterator = squareList.iterator();
        while (squareIterator.hasNext()) {
            Square square = squareIterator.next();
            square.update(delta);
            square.getTrail().update();
        }
        collisionHandler.update();
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

    public ArrayList<Square> getSquareList() {
        return squareList;
    }
}
