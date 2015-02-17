package ca.michaelbell.gameobjects;

import com.badlogic.gdx.Gdx;
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
    //  0 == Stopped

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
        if(this.direction == 1 || this.direction == 3 || this.direction == 0) {
            velocity.x = -speed;
            velocity.y = 0;
           setDirection(2);
            Gdx.app.log("Player", "Left");
        }
    }

    public void Right() {
        if(this.direction == 1 || this.direction == 3 || this.direction == 0) {
            velocity.x = speed;
            velocity.y = 0;
            setDirection(4);
            Gdx.app.log("Player", "Right");
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void Up() {
        if(this.direction == 2 || this.direction == 4 || this.direction == 0) {
            velocity.y = -speed;
            velocity.x = 0;
            setDirection(1);
            Gdx.app.log("Player", "Up");
        }
    }

    public void Down() {
        if(this.direction == 2 || this.direction == 4 || this.direction == 0) {
            velocity.y = speed;
            velocity.x = 0;
            setDirection(3);
            Gdx.app.log("Player", "Down");
        }
    }

    public void Stop(){
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
