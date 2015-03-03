package ca.michaelbell.helpers;

import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.gameworld.GameWorld;
import ca.michaelbell.screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class CollisionHandler {
    private GameWorld world;

    public CollisionHandler(GameWorld world) {
        this.world = world;
    }

    public void update(GameScreen screen) {
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
                    float size = 500;
                    //    float secondSize = trailList.get(trailList.size()-1)[0].dst2(trailList.get(trailList.size()-1)[1]);
                    try {
                        size = trailList.get(trailList.size() - 2)[1].dst2(trailList.get(trailList.size() - 2)[0]);

                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                    if (size <= square.getWidth() || size <= square.getHeight())
                        Gdx.app.log("size", Float.toString(size));
                    if ((b == trailList.size() || b == trailList.size() - 1 || (b == trailList.size() - 3 && size <= square.getWidth() || size <= square.getHeight())) && i == a) {
                        actualPositive = false;
                    }
                    float intersecting = Intersector.distanceSegmentPoint(vect[0], vect[1], secondSquare.getPosition()); // does the first square trail segment collide w/ second square vector?

                    if (intersecting < secondSquare.getWidth() / 2) {
                        //Gdx.app.log("Trail", "Intersect");
                        if (actualPositive) {
                            screen.dispose();
                            world.getGame().setEndScreen();
                        }
                    }



                }


            }
        }
    }

}
