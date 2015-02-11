package ca.michaelbell.gameobjects;

import com.badlogic.gdx.math.Vector2;


public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
    private int speed;

    private int direction;
    //  1 == North
    //  2 == East
    //  3 == South
    //  4 == West

    public Player(float x, float y, int width, int height) {
        direction = 1;
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        speed = 75;
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {

        //velocity.add(acceleration.cpy().scl(delta));

        position.add(velocity.cpy().scl(delta));


    }



    public void Left() {
        velocity.x = -speed;
        velocity.y = 0;;
    }

    public void Right() {
        velocity.x = speed;
        velocity.y = 0;;
    }

    public void Up() {
        velocity.y = -speed;
        velocity.x = 0;;
    }

    public void Down() {
        velocity.y = speed;
        velocity.x = 0;;
    }

    public void Stop(){
        velocity.x = 0;
        velocity.y = 0;
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
