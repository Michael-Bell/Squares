package ca.michaelbell.helpers;

import ca.michaelbell.gameobjects.Player;
import ca.michaelbell.gameobjects.easterEgg;
import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Michael on 2015-01-31.
 */
public class KeyboardHandler implements InputProcessor {
    private Player player;
    private Vector2 lastTouch = new Vector2();
    private easterEgg egg;
    private GameWorld world;
    public KeyboardHandler(GameWorld world) {
        player = world.getPlayer();
        this.egg = world.getEgg();
        this.world =world;
        Gdx.app.log("KeyboardHander", "init");
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.A)
            player.Left();
        if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.D)
            player.Right();
        if (keycode == Input.Keys.UP || keycode == Input.Keys.W)
            player.Up();
        if (keycode == Input.Keys.DOWN || keycode == Input.Keys.S)
            player.Down();
        if (keycode == Input.Keys.SPACE)
            player.Stop();
        if (keycode == Input.Keys.R)
            player.getTrail().Reset();
        if(keycode == Input.Keys.J)
            egg.specialTrail(player, world);
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
