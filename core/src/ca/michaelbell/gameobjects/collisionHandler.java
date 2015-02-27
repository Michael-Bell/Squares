package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

public class CollisionHandler {
    Iterator<Square> itr;
    private GameWorld world;


    public CollisionHandler(GameWorld world) {
        this.world = world;
    }

    public void update() {
        ArrayList<Square> squareList = world.getSquareList();
        for (int i = 0; i < squareList.size(); i++) { // iterate through all squares
            Square square = squareList.get(i); // set current square
            for (int a = 0; a < squareList.size(); a++) { // iterate through each square again so squarexsquare
                ArrayList<Vector2[]> trailList = square.getTrail().getTrailList();
                Square secondSquare = squareList.get(a);
                for (int b = 0; b < trailList.size(); b++) {// for each square, go through the first squares trail segments
                    Vector2[] vect = trailList.get(b);
                    float intersecting = Intersector.distanceSegmentPoint(vect[0], vect[1], secondSquare.getPosition()); // does the first square trail segment collide w/ second square vector?
                    if (b == trailList.size() - 1) {
                        Gdx.app.log("For", "This");
                        Gdx.app.log("Square", square.toString());
                        Gdx.app.log("secondSquare", secondSquare.toString());
                        Gdx.app.log("Intersecting", Float.toString(intersecting));
                        Gdx.app.log("End", "this");
                    }
                    if (intersecting < 5) {
                        Gdx.app.log("Trail", "Intersect");
                        secondSquare.getTrail().Reset();
                    }


                }


            }
        }
    }

}
