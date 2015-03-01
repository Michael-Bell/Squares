package ca.michaelbell.helpers;

import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class CollisionHandler {
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
                for (int b = 0; b <= trailList.size(); b++) {// for each square, go through the first squares trail segments
                    boolean actualPositive = true;
                    Vector2[] vect;
                    if (b == trailList.size()) {
                        vect = square.getTrail().getCurrentLine();
                    } else {
                        vect = trailList.get(b);
                    }
                    if ((b == trailList.size() || b == trailList.size() - 1) && i == a)
                        actualPositive = false;


                    float intersecting = Intersector.distanceSegmentPoint(vect[0], vect[1], secondSquare.getPosition()); // does the first square trail segment collide w/ second square vector?

                    if (intersecting < 1) {
                        Gdx.app.log("Trail", "Intersect");
                        if (actualPositive)
                            secondSquare.getTrail().Reset();
                    }

                    //todo does not detect collision on current line... why? B/C Current line is not added to trail list?


                }


            }
        }
    }

}
