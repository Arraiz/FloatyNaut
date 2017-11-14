package com.mike.floatynaut.screen.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mike.floatynaut.prefabs.Astronaut;

/**
 * Created by mikeldiez on 08/09/2017.
 */

public class GameController implements InputProcessor{

    /*atributes*/
    private Astronaut astronaut;




    public GameController() {
        init();

    }


    private void init() {
        //al implemtar la interfaz necesitamos instanciarla
        Gdx.input.setInputProcessor(this);
        astronaut = new Astronaut(3, 11, 0.5f);

    }

    public void update(float delta) {

        astronaut.applyGravity();


    }

    public Astronaut getAstronaut() {
        return astronaut;
    }


    @Override
    public boolean keyDown(int keycode) {
        if(Input.Keys.SPACE==keycode){
            astronaut.applyYforce();

        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(Input.Buttons.LEFT==button){
            astronaut.applyYforce();

        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
