package ca.michaelbell.screens;


import ca.michaelbell.gameworld.GameRenderer;
import ca.michaelbell.gameworld.GameWorld;
import ca.michaelbell.helpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 1920;
        float gameHeight = screenHeight*gameWidth/screenWidth;

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);


        world = new GameWorld(midPointX, midPointY); // initialize world
        renderer = new GameRenderer(world, (int) gameWidth, (int) gameHeight, midPointY); // initialize renderer
        Gdx.input.setInputProcessor(new InputHandler(world.getPlayer()));
    }

    @Override
    public void render(float delta) {
        runTime +=delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}