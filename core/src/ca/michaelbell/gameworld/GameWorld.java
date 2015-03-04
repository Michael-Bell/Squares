package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Enemy;
import ca.michaelbell.gameobjects.Player;
import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.gameobjects.easterEgg;
import ca.michaelbell.helpers.CollisionHandler;
import ca.michaelbell.screens.GameScreen;
import ca.michaelbell.tron.Tron;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.Iterator;

public class GameWorld {
    private Player player, player2;
    private easterEgg egg;
    private int midpointX, midpointY;

    private ArrayList<Square> squareList;
    private Enemy enemy;
    private CollisionHandler collisionHandler;
    private Tron game;

    public GameWorld(int midpointX, int midpointY, Tron game) {
        this.game = game;
        squareList = new ArrayList<Square>();
        enemy = new Enemy(-50, -50, 16, 16, "Enemy1", this);
        //    public Player(float x, float y, int width, int height, Color color, int UP, int DOWN, int LEFT, int RIGHT, int STOP, int RESET, int EGG, GameWorld world ) {

        player = new Player(midpointX * 2, midpointY, 16, 16, Color.CYAN, Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.SPACE, Input.Keys.BACKSLASH, Input.Keys.END, "Cyan Player", this);
        player2 = new Player(0, midpointY, 16, 16, Color.ORANGE, Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D, Input.Keys.C, Input.Keys.V, Input.Keys.X, "Orange Player", this);

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
