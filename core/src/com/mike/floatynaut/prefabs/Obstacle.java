package com.mike.floatynaut.prefabs;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mike.floatynaut.Common.GameCongif;
import com.mike.floatynaut.Common.PrefabsSettings;

/**
 * Created by mikeldiez on 15/11/2017.
 */

public class Obstacle {
    /*regiones*/
    private Rectangle bounds;
    private Rectangle upBounds;
    private Rectangle downBounds;
    /*parametros*/
    private float xPos;
    private float yPos;


    private final float yOpening = PrefabsSettings.Y_OPENING;
    private final float xOpening = PrefabsSettings.X_OPENING;

    private final float ySpeed = PrefabsSettings.OBS_Y_SPEED;
    private final float xSpeed = PrefabsSettings.OBS_X_SPEED;


    public Obstacle(float xPos, float yPos) {
        bounds = new Rectangle(xPos, yPos, xOpening, yOpening);

        downBounds = new Rectangle(xPos, 0, xOpening, yPos);
        upBounds = new Rectangle(xPos, yPos + yOpening, xOpening, GameCongif.WORLD_HEIGHT - yPos - yOpening);

        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void moveOnY() {

        yPos += ySpeed;
        setPosition();
    }

    public void moveOnX() {
        //*check if we leave the game world*//
        if (xPos <= -(xOpening + 0f)) {
            //respawn with other coordinates
            xPos = GameCongif.WORLD_WIDTH + 4;
            yPos = MathUtils.random(5, GameCongif.WORLD_HEIGHT - 5);
        }
        xPos -= xSpeed;
        setPosition();
    }

    private void setPosition() {

        bounds.setPosition(xPos, yPos);
        downBounds.setPosition(xPos, 0);
        downBounds.setSize(xOpening, yPos);
        upBounds.setPosition(xPos, yPos + yOpening);
        upBounds.setSize(xOpening, GameCongif.WORLD_HEIGHT - yPos - yOpening);
    }

    public Rectangle getDownBounds() {
        return downBounds;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public float getyOpening() {
        return yOpening;
    }

    public float getxOpening() {
        return xOpening;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Rectangle getUpBounds() {
        return upBounds;
    }

}
