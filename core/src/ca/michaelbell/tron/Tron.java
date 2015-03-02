package ca.michaelbell.tron;

import ca.michaelbell.helpers.AssetLoader;
import ca.michaelbell.screens.EndScreen;
import ca.michaelbell.screens.GameScreen;
import ca.michaelbell.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tron extends Game {
    public SpriteBatch batch;
    public BitmapFont font;

    StartScreen startScreen;
    GameScreen gameScreen;
    EndScreen endScreen;

	@Override
	public void create() {
		Gdx.app.log("Tron", "created");
        AssetLoader.load();
        batch = new SpriteBatch();
// Use LibGDX's default Arial font.
        font = new BitmapFont();
        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        endScreen = new EndScreen(this);
        this.setScreen(startScreen);
    }

    public void render() {
        super.render(); // important!
    }
    @Override
    public void dispose(){
        super.dispose();
        batch.dispose();
        font.dispose();
        AssetLoader.dispose();
    }

    public void setGameScreen() {
        this.setScreen(gameScreen);
    }

    public void setStartScreen() {
        this.setScreen(startScreen);
    }

    public void setEndScreen() {
        this.setScreen(endScreen);
    }
}

