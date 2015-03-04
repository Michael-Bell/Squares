package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;


public class Enemy extends Square {

    public Enemy(float x, float y, int width, int height, String enemy, GameWorld world) {
        super(x, y, width, height, enemy, world);
    }

}
