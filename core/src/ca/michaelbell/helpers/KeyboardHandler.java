package ca.michaelbell.helpers;

import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.gameobjects.easterEgg;
import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2015-01-31.
 */
public class KeyboardHandler implements InputProcessor {
    private ArrayList<Square> squareArrayList;
    private Vector2 lastTouch = new Vector2();
    private easterEgg egg;
    private GameWorld world;
    public KeyboardHandler(GameWorld world) {
        squareArrayList = world.getSquareList();
        this.egg = world.getEgg();
        this.world =world;
        Gdx.app.log("KeyboardHandler", "init");
    }

    @Override
    public boolean keyDown(int keycode) {
        Iterator<Square> itr = world.getSquareList().iterator(); // Iterate through the squares
        while (itr.hasNext()) {
            itr.next().controlCheck(keycode);// send keys to players for checks
        }

        if (keycode == Input.Keys.Q) {
            world.getEnemy().setPosition(new Vector2(1920 / 2, 0));
            world.getEnemy().getTrail().newTrail();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("Input", "TouchDown");
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("Input", "TouchUp");

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Gdx.app.log("Input", "TouchDragged");

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
