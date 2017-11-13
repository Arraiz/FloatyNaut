package com.mike.floatynaut.screen.game;
import com.badlogic.gdx.ScreenAdapter;
import com.mike.floatynaut.FloatyNaut;


/**
 * Created by mikeldiez on 08/09/2017.
 */

public class  GameScreen extends ScreenAdapter {

    /*atributos*/
    private final FloatyNaut game;
    /**cada una de las partes de esta pantalla del juego controllador:logica renderer:renderizado**/
    private  GameController controller;
    private  GameRenderer renderer;



    /*contructor*/
    public GameScreen(FloatyNaut game) {
        this.game=game;
    }

    @Override
    public void show() {
        super.show();
        /**inicializamos**/
        this.controller=new GameController();
        this.renderer=new GameRenderer(controller,game.getBatch());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        /**actualizamos controllador y renderizador**/
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        renderer.resize(width, height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        renderer.dispose();


    }
}
