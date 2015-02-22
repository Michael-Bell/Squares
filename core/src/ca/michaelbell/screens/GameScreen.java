package ca.michaelbell.screens;


import ca.michaelbell.gameworld.GameRenderer;
import ca.michaelbell.gameworld.GameWorld;
import ca.michaelbell.helpers.KeyboardHandler;
import ca.michaelbell.helpers.TouchHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 1920;
        float gameHeight = screenHeight * gameWidth / screenWidth;

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);


        world = new GameWorld(midPointX, midPointY); // initialize world
        renderer = new GameRenderer(world, (int) gameWidth, (int) gameHeight, midPointY); // initialize renderer
        Gdx.input.setInputProcessor(new KeyboardHandler(world.getPlayer()));
        InputProcessor inputProcessorOne = new KeyboardHandler(world.getPlayer());
        TouchHandler inputProcessorTwo = new TouchHandler(new TouchHandler.DirectionListener() {

            @Override
            public void onUp() {
                world.getPlayer().Up();
                Gdx.app.log("Touch", "up");
            }

            @Override
            public void onRight() {
                world.getPlayer().Right();
                Gdx.app.log("Touch", "Right");

            }

            @Override
            public void onLeft() {
                world.getPlayer().Left();
                Gdx.app.log("Touch", "Left");

            }

            @Override
            public void onDown() {
                world.getPlayer().Down();
                Gdx.app.log("Touch", "Down");

            }

            @Override
            public void reset(){
                world.getPlayer().getTrail().Reset();
            }

            @Override
            public void pause() {
                world.getPlayer().Stop();
            }
        });
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputProcessorOne);
        inputMultiplexer.addProcessor(inputProcessorTwo);

        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        runTime += delta;
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