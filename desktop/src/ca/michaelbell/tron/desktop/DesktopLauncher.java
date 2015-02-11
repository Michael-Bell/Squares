package ca.michaelbell.tron.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ca.michaelbell.tron.Tron;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Testing Stuffs";
		config.height = 360*2;
		config.width = 640*2;
		new LwjglApplication(new Tron(), config);
	}
}
