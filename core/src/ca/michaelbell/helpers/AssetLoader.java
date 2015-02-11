package ca.michaelbell.helpers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture texture;
    public static TextureRegion playerTexture;


    public static void load() {

        texture = new Texture(Gdx.files.internal("player.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        playerTexture = new TextureRegion(texture, 0, 0, 16, 16);
        playerTexture.flip(false, true);



    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}