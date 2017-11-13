package com.mike.floatynaut.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mike.gamename.Common.GameCongif;
import com.mike.gamename.GameName;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= (int)GameCongif.SCREEN_WIDTH;
		config.height=(int)GameCongif.SCREEN_HEIGHT;
		new LwjglApplication(new GameName(), config);
	}
}
