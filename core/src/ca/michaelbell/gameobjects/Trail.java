package ca.michaelbell.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2015-02-13.
 */
public class Trail {
    private Rectangle currentRectangle;
    Vector2 currentLine[];
    ArrayList TrailList;
    private Iterator<Vector2 []> itr;
    Player player;
    private float trailWidth;
    // rect(float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float degrees)
    public Trail(Player player){
        trailWidth = 5;
        this.player =player;
        TrailList = new ArrayList<Vector2[]>();
        currentLine = new Vector2[2];
        currentLine[0] = player.getPosition().cpy().add(player.getWidth()/2, player.getHeight()/2);
        currentLine[1] = player.getPosition().add(player.getWidth() / 2, player.getHeight() / 2);
        itr = TrailList.iterator();
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
        currentLine[1] = player.getPosition().cpy();
    }

    public Vector2[] newTrail(){
        Vector2 temp[] = new Vector2[2];
        temp[0] = currentLine[0].cpy();
        temp[1] = currentLine[1].cpy();
        TrailList.add(temp);
        currentLine[0] = player.getPosition().cpy().add(player.getWidth() / 2, player.getHeight() / 2);
        currentLine[1] = player.getPosition().cpy().add(player.getWidth()/2, player.getHeight()/2);
        itr = TrailList.iterator();
/*        TrailList.add(currentRectangle);
        currentRectangle = new Rectangle(0,0,0,0);
        Iterator<Rectangle> itr = TrailList.iterator();*/

        // return new current rectangle
        return currentLine;
    }
    public void render(ShapeRenderer shapeRenderer){
       // Gdx.app.log("Trail", "Render");
        itr = TrailList.iterator();

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(255/255f, 0/255f, 9/255f,1);
        //shapeRenderer.rect(25f,5f, 50f,50f);
        shapeRenderer.rectLine(currentLine[0].cpy(), currentLine[1].cpy(), 2.5f);
    /*    Gdx.app.log("CurrentLine[0]", currentLine[0].toString());
        Gdx.app.log("currentline[1]", currentLine[1].toString());
*/
        while(itr.hasNext()) {
            shapeRenderer.setColor(0/255f, 255/255f, 9/255f ,1);
            Vector2[] vect = itr.next();
            Gdx.app.log("Trail", vect[1].toString());
            shapeRenderer.rectLine(vect[0], vect[1], 2.5f);

        }

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
