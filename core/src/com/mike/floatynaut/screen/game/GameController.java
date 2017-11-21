package com.mike.floatynaut.screen.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.mike.floatynaut.Common.GameCongif;
import com.mike.floatynaut.prefabs.Astronaut;
import com.mike.floatynaut.prefabs.Obstacle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikeldiez on 08/09/2017.
 */

//implementamos inputprocessor para la entrada de teclado
public class GameController implements InputProcessor {

    /*game units*/
    private Astronaut astronaut;
    private List<Obstacle> obstacles;
    private int score;

    /**
     * game variables
     **/

    private boolean gameOver = false;

    /**
     * Debug Variables
     **/
    private boolean isFreezed = false;


    public GameController() {
        init();

    }


    private void init() {
        //al implemtar la interfaz necesitamos instanciarla
        Gdx.input.setInputProcessor(this);
        astronaut = new Astronaut(3, 11, 0.5f);
        obstacles = new ArrayList<Obstacle>();
        obstacles.add(new Obstacle(GameCongif.WORLD_WIDTH / 2, 7));
        obstacles.add(new Obstacle((GameCongif.WORLD_WIDTH / 2) + 9, 5));


    }

    public void update(float delta) {

        //freeze for debug puroposes
        if (!isFreezed && !gameOver) {
            astronaut.applyGravity();
            enableScore();
            for (Obstacle o : obstacles) {
                o.moveOnX();
            }
            checkColissions();
        }


    }


    /*player logic*/


    /*gates logic*/
    private void moveGates() {

    }

    /*collision detection*/
    private void checkColissions() {
        for (Obstacle o : obstacles) {
            if (Intersector.overlaps(astronaut.getBounds(), o.getDownBounds()) || Intersector.overlaps(astronaut.getBounds(), o.getUpBounds())) {
                gameOver = true;
            }
        }
    }

    //enableScore logic
    private void enableScore() {
        for (Obstacle o : obstacles) {

        }
    }


    public Astronaut getAstronaut() {
        return astronaut;
    }





    /*obstacle logic*/

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.SPACE == keycode) {
            astronaut.applyYforce();

        } else if (Input.Keys.P == keycode) {
            isFreezed = !isFreezed;
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
        if (Input.Buttons.LEFT == button) {
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

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
