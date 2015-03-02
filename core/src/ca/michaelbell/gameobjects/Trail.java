package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

public class Trail {
    Vector2 currentLine[]; // Array to hold the vector of the current path [0] is starting point, [1] is current point(updates)
    ArrayList<Vector2[]> TrailList; // list of line segments
    Square square; // local reference to the square
    private Iterator<Vector2[]> itr; // iterator to go through line segments when rendering
    private float trailWidth; // how wide the trail is so I can change it without breaking code
    private Intersector intersect;
    // rect(float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float degrees)
    public Trail(Square square, GameWorld world) {
        this.square = square;
        TrailList = new ArrayList<Vector2[]>(); // ArrayList of Vector2 arrays
        currentLine = new Vector2[2];
        Reset();

    }

    public Vector2[] getCurrentLine() {
        return currentLine;
    }

    public ArrayList<Vector2[]> getTrailList() {
        return TrailList;
    }

    public void setTrailList(ArrayList trailList) {
        TrailList = trailList;
    }

    public void update() {
        currentLine[1] = square.getPosition().cpy();
    }

    public void Reset(){
        square.Stop();
        //Vector2 offScreen[] = new Vector2[2]; // make an offscreen line, in old collision code this prevented a collision when you begin moving
        //offScreen[0] = new Vector2(-100,-100); // probably not needed any more
        //offScreen[1] = new Vector2(-50,-50);
        intersect = new Intersector(); // math class for calculating the distance between points
        trailWidth = 2.5f;  // sets trail width
        TrailList = new ArrayList<Vector2[]>(); // ArrayList of line segments. Holds all but current line
        //TrailList.add(offScreen);
        currentLine = new Vector2[2]; // line segment that connects to player, [0] is turning point, [1] is player position
        currentLine[0] = square.getPosition().cpy();
        currentLine[1] = square.getPosition().cpy(); // Possible to rewrite code to only store turing points...
        itr = TrailList.iterator(); // init for going through all line segments
    }

    public Vector2[] newTrail() {
        Vector2 temp[] = new Vector2[2]; // temp vector array to add currentLine to TrailList.
        temp[0] = currentLine[0].cpy(); // .cpy to avoid things being updated
        temp[1] = currentLine[1].cpy();
        TrailList.add(temp);
        currentLine[0] = square.getPosition().cpy();
        currentLine[1] = square.getPosition().cpy();
        return currentLine; // if anyone wants it
    }

    public void render(ShapeRenderer shapeRenderer, SpriteBatch batcher) {
        batcher.end();// stop the batcher
        itr = TrailList.iterator(); // reset on each render...
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255 / 255f, 0 / 255f, 9 / 255f, 1); // red
        shapeRenderer.rectLine(currentLine[0].cpy(), currentLine[1].cpy(), trailWidth); // current line

        while (itr.hasNext()) { // Trail list iterator
            shapeRenderer.setColor(0 / 255f, 255 / 255f, 9 / 255f, 1); // green
            Vector2[] vect = itr.next(); // trail line segment
            shapeRenderer.rectLine(vect[0], vect[1], trailWidth); // render segment
        }
        shapeRenderer.end(); // finished with shape renderer
        batcher.begin(); // start batcher again
    }
}