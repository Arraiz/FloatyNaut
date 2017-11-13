package com.mike.floatynaut.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mike.floatynaut.Common.GameCongif;

/**Utilidades de debudeo para la camara
 * Renderizado de los limites de camara y control de camara WASD y estadisticas como FPS
 * **/

public class CameraDebugUtils {


    private static final float ZOOM_IN__OUT_AMOUNT = 0.02f;
    private static final float MOVE_AMOUNT = 0.2f;

    private static final int UP_KEY = Input.Keys.W;
    private static final int DOWN_KEY = Input.Keys.S;
    private static final int LEFT_KEY = Input.Keys.A;
    private static final int RIGHT_KEY = Input.Keys.D;


    public static void RenderBounds(ShapeRenderer renderer, Viewport viewport) {


        Color prevColor = renderer.getColor();
        renderer.setColor(Color.BLACK);

        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();

        //horizontales
        for (int i = 0; i <= worldHeight; i++) {
            renderer.line(0, i, worldWidth, i);
        }
        //verticales
        for (int i = 0; i <= worldWidth; i++) {
            renderer.line(i, 0, i, worldHeight);
        }

        //rectangunlo delimitador de alto y ancho de nuestro viewport
        renderer.setColor(Color.RED);
        renderer.rect(0, 0, worldWidth, worldHeight);

        //cross at center
        renderer.x(worldWidth/ 2f,worldHeight / 2f, 0.1f);


        renderer.setColor(prevColor);

    }
    public static void debugHUDStatistics(Viewport worldViewport,SpriteBatch batch, BitmapFont font){
        //estadisticas de FPS y posicion del raton entre otros
        //informacion sobre FPS y camara de debugo
        font.draw(batch, "FPS: "+Float.toString(Gdx.graphics.getFramesPerSecond()), 0, GameCongif.HUD_HEIGHT);
        font.draw(batch, "MouseX(world units): " + Float.toString((Gdx.input.getX() / GameCongif.HUD_WIDTH) * GameCongif.WORLD_WIDTH), 0, GameCongif.HUD_HEIGHT - 20);
        font.draw(batch, "MouseY(world units): " + Float.toString((Gdx.input.getY() / GameCongif.HUD_HEIGHT) * GameCongif.WORLD_HEIGHT), 0, GameCongif.HUD_HEIGHT - 40);
        font.draw(batch, "move: WSAD zoom in E zoom out Q", 0, GameCongif.HUD_HEIGHT - 60);
        font.draw(batch, "WorldSize: "+worldViewport.getWorldWidth()+" "+worldViewport.getWorldHeight(), GameCongif.HUD_WIDTH, GameCongif.HUD_HEIGHT -40);
        font.draw(batch, "PixelSize: "+GameCongif.SCREEN_HEIGHT +"x"+GameCongif.SCREEN_WIDTH, GameCongif.HUD_WIDTH, GameCongif.HUD_HEIGHT -60);


    }

    public static void SetCameraControls(OrthographicCamera camera,Viewport viewport) {
        /*ZOOM CONTROLS*/

        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();

        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            camera.zoom += ZOOM_IN__OUT_AMOUNT;
        } else if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            camera.zoom -= ZOOM_IN__OUT_AMOUNT;
        }
        /*MOVEMENT CONTROLS*/
        if (Gdx.input.isKeyPressed(LEFT_KEY)) {
            camera.position.x = camera.position.x - MOVE_AMOUNT;
        } else if (Gdx.input.isKeyPressed(RIGHT_KEY)) {
            camera.position.x = camera.position.x + MOVE_AMOUNT;
        } else if (Gdx.input.isKeyPressed(UP_KEY)) {
            camera.position.y = camera.position.y + MOVE_AMOUNT;
        } else if (Gdx.input.isKeyPressed(DOWN_KEY)) {
            camera.position.y = camera.position.y - MOVE_AMOUNT;
        }
        /*reset */
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            //reset
            camera.position.set( worldWidth/ 2f, worldHeight / 2f, 0);
            camera.zoom = 1;
        }
    }




}
