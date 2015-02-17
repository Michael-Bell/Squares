package ca.michaelbell.gameobjects;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by Michael on 2015-02-13.
 */
public class Trail {
    private Rectangle currentRectangle;
    ArrayList<Rectangle> TrailList;

    public Trail(){
        TrailList = new ArrayList<Rectangle>();
        currentRectangle = new Rectangle(0, 0, 17, 12);
        //current rectangle between old turn and new position
        // center and stretch
        //on turn: add rect to list of old rect, make new rect at new turn to new position...
        // use iterator in game renderer for batch rendering...
        // How to detect collisions??????
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
