package com.mike.floatynaut.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mike.floatynaut.Common.GameCongif;
import com.mike.floatynaut.FloatyNaut;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= (int)GameCongif.SCREEN_WIDTH;
		config.height=(int)GameCongif.SCREEN_HEIGHT;
		new LwjglApplication(new FloatyNaut(), config);
	}
}
