package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Enemy;
import ca.michaelbell.gameobjects.Player;
import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.gameobjects.easterEgg;
import ca.michaelbell.helpers.CollisionHandler;
import ca.michaelbell.screens.GameScreen;
import ca.michaelbell.tron.Tron;

import java.util.ArrayList;
import java.util.Iterator;

public class GameWorld {
    private Player player;
    private easterEgg egg;
    private int midpointX, midpointY;

    private ArrayList<Square> squareList;
    private Enemy enemy;
    private CollisionHandler collisionHandler;
    private Tron game;

    public GameWorld(int midpointX, int midpointY, Tron game) {
        this.game = game;
        squareList = new ArrayList<Square>();
        enemy = new Enemy(midpointX - 20, midpointY - 25, 16, 16, this);
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

    public void update(float delta, GameScreen screen) {
        Iterator<Square> squareIterator = squareList.iterator();
        while (squareIterator.hasNext()) {
            Square square = squareIterator.next();
            square.update(delta);
            square.getTrail().update();
        }
        collisionHandler.update(screen);
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

    public Enemy getEnemy() {
        return enemy;
    }

    public Tron getGame() {
        return game;
    }
}
