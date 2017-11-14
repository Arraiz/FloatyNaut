package com.mike.floatynaut.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by mikeldiez on 07/09/2017.
 */

public class MouseDebug {

    public static void MouseCoords(ShapeRenderer renderer, Viewport viewport) {


        //pillamos el color anterior
        Color prevColor = renderer.getColor();
        renderer.setColor(Color.RED);

        //coord del raton
        Vector2 worldMouse = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));

        //clampeamos las coordenadas del juego
        worldMouse.x = MathUtils.clamp(worldMouse.x, 0, viewport.getWorldWidth());
        worldMouse.y = MathUtils.clamp(worldMouse.y, 0, viewport.getWorldHeight());

        //renderizamos las lineas
        renderer.line(0, worldMouse.y, worldMouse.x, worldMouse.y);
        renderer.line(worldMouse.x, 0, worldMouse.x, worldMouse.y);


        renderer.setColor(prevColor);



    }
}
