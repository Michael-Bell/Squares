package ca.michaelbell.screens;


import ca.michaelbell.gameworld.GameRenderer;
import ca.michaelbell.gameworld.GameWorld;
import ca.michaelbell.helpers.InputHandler;
import ca.michaelbell.tron.Tron;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

    final Tron game;
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen(Tron Game) {
        Gdx.app.log("GameScreen", "Attached");
        this.game = Game;
        float gameWidth = game.getGameWidth();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameHeight = screenHeight * gameWidth / screenWidth;

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);


        world = new GameWorld(midPointX, midPointY, game); // initialize world
        renderer = new GameRenderer(world, (int) gameWidth, (int) gameHeight, midPointY); // initialize renderer


        Gdx.input.setInputProcessor(new InputHandler(world).getInputMultiplexer());
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta, this);
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