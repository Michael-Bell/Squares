package ca.michaelbell.gameworld;

import ca.michaelbell.gameobjects.Player;
import ca.michaelbell.gameobjects.Square;
import ca.michaelbell.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Iterator;

/**
 * Created by Michael on 2015-01-31.
 */
public class GameRenderer {
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;
    private Player player;

    private int midPointY;
    private int gameHeight;
    private Iterator<Square> itr; // iterator to go through line segments when rendering

    public GameRenderer(GameWorld world, int gameWidth,  int gameHeight, int midPointY) {
        myWorld = world;

        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        player = myWorld.getPlayer(); // who is that again?
    }


    public void render(float runTime) {
        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        // Begin SpriteBatch
        batcher.begin();
        itr = myWorld.getSquareList().iterator();
        while (itr.hasNext()) { // iterator
            Square square = itr.next();
            square.getTrail().render(shapeRenderer, batcher); // render the trail from the trail method
            batcher.draw(AssetLoader.playerTexture, square.getX() - square.getWidth() / 2, square.getY() - square.getHeight() / 2, square.getWidth(), square.getHeight()); // Draw the player... He probably could be a rectangle... Oh well
        }
        batcher.end();
    }
}
