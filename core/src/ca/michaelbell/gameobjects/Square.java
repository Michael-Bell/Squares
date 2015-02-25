package ca.michaelbell.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 788732 on 25/02/2015.
 */
public class Square {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float rotation;
    private int width;
    private int height;
    private int speed;
    private Trail trail;
    private int direction;

    public Square(float x, float y, int width, int height) {
        direction = 0;
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        speed = 75;
        acceleration = new Vector2(0, 460);
        trail = new Trail(this);
    }

    public Vector2 getPosition() {
        return position;
    }
    //  1 == North
    //  2 == East
    //  3 == South
    //  4 == West
    //  0 == Stopped

    public Trail getTrail() {
        return trail;
    }

    public void update(float delta) {
        //velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
    }

// TODO: Find Better Logic System

    public void Left() {
        if (this.direction == 1 || this.direction == 3 || this.direction == 0) {
            velocity.x = -speed;
            velocity.y = 0;
            setDirection(2);
        }
    }

    public void Right() {
        if (this.direction == 1 || this.direction == 3 || this.direction == 0) {
            velocity.x = speed;
            velocity.y = 0;
            setDirection(4);
        }
    }

    public void setDirection(int direction) {
        if(direction != 0)
            trail.newTrail();
        this.direction = direction;

    }

    public void Up() {
        if (this.direction == 2 || this.direction == 4 || this.direction == 0) {
            velocity.y = -speed;
            velocity.x = 0;
            setDirection(1);
        }
    }

    public void Down() {
        if (this.direction == 2 || this.direction == 4 || this.direction == 0) {
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

    public float getRotation() {
        return rotation;
    }
}