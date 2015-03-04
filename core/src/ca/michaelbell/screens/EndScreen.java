package ca.michaelbell.screens;

import ca.michaelbell.tron.Tron;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class EndScreen implements Screen {
    final Tron game;
    OrthographicCamera camera;
    float gameWidth, gameHeight;
    public EndScreen(Tron game) {
        this.game = game;
        gameWidth = game.getGameWidth();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        gameHeight = screenHeight * gameWidth / screenWidth;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameWidth, gameHeight);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Game Over", gameWidth / 2, gameHeight - 25);
        game.font.draw(game.batch, "Tap anywhere to try again", 100, gameHeight - 100);
        game.font.draw(game.batch, game.getEndPlayer() + " ended the game", 100, gameHeight - 125);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}