package ca.michaelbell.gameobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2015-02-13.
 */
public class Trail {
    private Rectangle currentRectangle;
    Vector2 currentLine[];
    ArrayList TrailList;
    private Iterator<Rectangle> itr;

    // rect(float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float degrees)
    public Trail(Player player){
        TrailList = new ArrayList<Vector2 []>();
        currentLine[0] = player.getPosition();


/*        TrailList = new ArrayList<Rectangle>();
        Iterator<Rectangle> itr = TrailList.iterator();
        currentRectangle = new Rectangle(0,0,0,0)*/;
        //current rectangle between old turn and new position
        // center and stretch
        //on turn: add rect to list of old rect, make new rect at new turn to new position...
        // use iterator in game renderer for batch rendering...
        // How to detect collisions??????
    }
    public void update(){

    }

    public Rectangle newTrail(){
/*        TrailList.add(currentRectangle);
        currentRectangle = new Rectangle(0,0,0,0);
        Iterator<Rectangle> itr = TrailList.iterator();*/

        // return new current rectangle
        return null;
    }
    public void render(ShapeRenderer shapeRenderer){
        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(44/255f, 62/255f, 80/255f,1);
/*        shapeRenderer.rect(currentRectangle.getX(), currentRectangle.getY(), currentRectangle.getWidth(), currentRectangle.getHeight());


        while(itr.hasNext()) {
            Rectangle rect = itr.next();
            shapeRenderer.rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

        }*/

        // End ShapeRenderer
        shapeRenderer.end();
    }
}

/*

ArrayList<String> list = new ArrayList<String>();
list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
        String str = itr.next();

        System.out.println(str + " is " + str.length() + " chars long.");
        }*/
