package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 788732 on 25/02/2015.
 */
public class Square {
    Vector2 velocity;
    private Vector2 position;
    private int width;
    private int height;
    private int speed;
    private Trail trail;
    private int direction;
    private Color color;
    public Square(float x, float y, int width, int height, GameWorld world) {
        direction = 0; // Squares should start still, so 0 direction
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        speed = 10;
        trail = new Trail(this, world); // attatch a trail
        world.getSquareList().add(this); // add the square to the list of squares in the current world for iterating
        color = Color.ORANGE;
    }


    public Vector2 getPosition() {
        return position;
    }
    //  1 == North
    //  2 == East
    //  3 == South
    //  4 == West
    //  0 == Stopped

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Trail getTrail() {
        return trail;
    }

// TODO: Find Better Logic System

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }

    public void switchs() {

    }

    public void Left() {
        if (this.direction != 2) { //TODO move all into setDirection, call setDirection from the Keyboard handler
            velocity.x = -speed;
            velocity.y = 0;
            setDirection(4);
        }
    }

    public void Right() {
        if (this.direction != 4) {
            velocity.x = speed;
            velocity.y = 0;
            setDirection(2);
        }
    }

    public void setDirection(int direction) {
        if (this.direction != 0 && direction != this.direction)
            trail.newTrail();
        this.direction = direction;

    }

    public void Up() {
        if (this.direction != 3) {
            velocity.y = -speed;
            velocity.x = 0;
            setDirection(1);
        }
    }

    public void Down() {
        if (this.direction != 1) {
            velocity.y = speed;
            velocity.x = 0;
            setDirection(3);
        }
    }

    public void Stop() {
        velocity.x = 0;
        velocity.y = 0;
        setDirection(0);
    }

    public void controlCheck(int keycode) {

    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(ShapeRenderer shapeRenderer, SpriteBatch batcher) {
        batcher.end();// stop the batcher
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(getX() - getWidth() / 2, getY() - getHeight() / 2, getHeight(), getWidth());

        shapeRenderer.end(); // finished with shape renderer
        batcher.begin(); // start batcher again
    }
}
