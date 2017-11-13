package com.mike.floatynaut.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by mikeldiez on 06/09/2017.
 */

public class ScreenUtilities {

    public static void ClearScreen() {
        ClearScreen(Color.BLACK);
    }

    public static void ClearScreen(Color color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
