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
    ArrayList TrailList; // list of line segments
    Square square; // local reference to the square
    private Iterator<Vector2[]> itr; // iterator to go through line segments when rendering
    private float trailWidth; // how wide the trail is so I can change it without breaking code
    private Boolean push; // switches, pushes every other line x origin left
    // TODO Find better var name
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

    public ArrayList getTrailList() {
        return TrailList;
    }

    public void setTrailList(ArrayList trailList) {
        TrailList = trailList;
    }

    public void update() {
        currentLine[1] = square.getPosition().cpy().add(square.getWidth() / 2, square.getHeight() / 2);
    }

    public void Reset(){
        Vector2 offScreen[] = new Vector2[2];
        offScreen[0] = new Vector2(-100,-100);
        offScreen[1] = new Vector2(-50,-50);
        intersect = new Intersector();
        trailWidth = square.getWidth();  // 5 px for now
        TrailList = new ArrayList<Vector2[]>(); // ArrayList of Vector2 arrays
        TrailList.add(offScreen);
        currentLine = new Vector2[2];
        currentLine[0] = square.getPosition().cpy().add(square.getWidth() / 2, square.getHeight() / 2); // .cpy to make it static, adds half the square size to try centering... Also needs to have half the line removed?
        currentLine[1] = square.getPosition().cpy().add(square.getWidth() / 2, square.getHeight() / 2);
        itr = TrailList.iterator(); // init the iterator
        push = true;
    }

    public Vector2[] newTrail() {
        Vector2 temp[] = new Vector2[2]; // temp vector array to add currentLine to TrailList. Probably not needed?
        temp[0] = currentLine[0].cpy();
        temp[1] = currentLine[1].cpy();
        TrailList.add(temp);
        currentLine[0] = square.getPosition().cpy().add(square.getWidth() / 2, square.getHeight() / 2);
        currentLine[1] = square.getPosition().cpy().add(square.getWidth() / 2, square.getHeight() / 2);
        if(push)
            //currentLine[0].add(trailWidth/2,0);
        push = !push;
        //itr = TrailList.iterator();
        return currentLine; // if anyone wants it
    }

    public void render(ShapeRenderer shapeRenderer, SpriteBatch batcher) {
        batcher.end();
        itr = TrailList.iterator(); // reset on each render... Probably taxing, but I don't want to forget a render

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255 / 255f, 0 / 255f, 9 / 255f, 1); // red
        shapeRenderer.rectLine(currentLine[0].cpy(), currentLine[1].cpy(), 2.5f); // curent line

        while (itr.hasNext()) { // iterator
            shapeRenderer.setColor(0 / 255f, 255 / 255f, 9 / 255f, 1); // green
            Vector2[] vect = itr.next();
         //   Gdx.app.log("Trail", vect[1].toString());
            shapeRenderer.rectLine(vect[0], vect[1], 2.5f);
        }
        shapeRenderer.end();
        batcher.begin();
    }
}