package com.mike.floatynaut.prefabs;


import com.badlogic.gdx.math.Rectangle;
import com.mike.floatynaut.Common.GameCongif;

/**
 * Created by mikeldiez on 15/11/2017.
 */

public class Obstacle {
    private Rectangle bounds;
    private Rectangle upBounds;


    private Rectangle downBounds;
    private float xPos;
    private float yPos;
    private float yOpening;
    private float xOpening;

    public Obstacle(float xPos, float yPos, float yOpening, float xOpening) {
        bounds = new Rectangle(xPos, yPos, xOpening, yOpening);
        downBounds = new Rectangle(xPos, 0, xOpening, yPos);
        upBounds = new Rectangle(xPos, yPos+yOpening, xOpening, GameCongif.WORLD_HEIGHT - yPos - yOpening);

        this.xPos = xPos;
        this.yPos = yPos;
        this.xOpening = xOpening;
        this.yOpening = yOpening;
    }

    private void setPosition() {
        bounds.setPosition(xPos, yPos);
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
