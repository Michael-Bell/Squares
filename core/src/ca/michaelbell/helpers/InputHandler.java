package ca.michaelbell.helpers;

import ca.michaelbell.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by 788732 on 23/02/2015.
 */
public class InputHandler {
    private InputMultiplexer inputMultiplexer;
    private GameWorld world;
    public InputHandler(GameWorld myworld){
        world = myworld;
        InputProcessor inputProcessorOne = new KeyboardHandler(world);
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
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputProcessorOne);
        inputMultiplexer.addProcessor(inputProcessorTwo);
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }
}
