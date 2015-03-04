package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.graphics.Color;

public class Player extends Square {
    private int UP, DOWN, LEFT, RIGHT, STOP, EGG, RESET;
    private GameWorld world;

    public Player(float x, float y, int width, int height, Color color, int UP, int DOWN, int LEFT, int RIGHT, int STOP, int RESET, int EGG, String enemy, GameWorld world) {
        super(x, y, width, height, enemy, world);
        this.world = world;
        this.UP = UP;
        this.DOWN = DOWN;
        this.LEFT = LEFT;
        this.RIGHT = RIGHT;
        this.STOP = STOP;
        this.EGG = EGG;
        this.RESET = RESET;
        setColor(color);
    }

    @Override
    public void controlCheck(int keycode) {
        if (keycode == LEFT)
            this.Left();
        if (keycode == RIGHT)
            this.Right();
        if (keycode == UP)
            this.Up();
        if (keycode == DOWN)
            this.Down();
        if (keycode == STOP)
            this.Stop();
        if (keycode == RESET)
            this.getTrail().Reset();
        if (keycode == EGG)
            world.getEgg().specialTrail(this, world);

    }

}
