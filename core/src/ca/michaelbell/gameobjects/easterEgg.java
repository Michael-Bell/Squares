package ca.michaelbell.gameobjects;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class easterEgg {

    public easterEgg() {

    }

    public void specialTrail(Player player, GameWorld world) {
        int space = 30;
        player.getTrail().Reset();
        ArrayList<Vector2[]> trailList = player.getTrail().getTrailList();
        for (int i = 0; i <= (player.getY()/space); i++) {
            Vector2 temp[] = new Vector2[2];
            temp[0] = new Vector2(player.getX(), player.getY() + i * space).cpy();
            temp[1] = new Vector2(player.getX() - i * space, player.getY()).cpy();
            trailList.add(temp);
            Vector2 temp1[] = new Vector2[2];
            temp1[0] = new Vector2(player.getX(), player.getY() + i * space).cpy();
            temp1[1] = new Vector2(player.getX() + i * space, player.getY()).cpy();
            trailList.add(temp1);
            Vector2 temp2[] = new Vector2[2];

            temp2[0] = new Vector2(player.getX(), player.getY() - i * space).cpy();
            temp2[1] = new Vector2(player.getX() - i * space, player.getY()).cpy();
            trailList.add(temp2);
            Vector2 temp3[] = new Vector2[2];

            temp3[0] = new Vector2(player.getX(), player.getY() - i * space).cpy();
            temp3[1] = new Vector2(player.getX() + i * space, player.getY()).cpy();
            trailList.add(temp3);


        }

    }

}
