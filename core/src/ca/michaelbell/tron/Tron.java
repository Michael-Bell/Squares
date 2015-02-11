package ca.michaelbell.tron;

import ca.michaelbell.helpers.AssetLoader;
import ca.michaelbell.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tron extends Game {


	@Override
	public void create() {
		Gdx.app.log("Tron", "created");
        AssetLoader.load();
		setScreen(new GameScreen());
	}

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
