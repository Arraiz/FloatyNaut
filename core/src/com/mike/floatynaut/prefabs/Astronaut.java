package com.mike.floatynaut.prefabs;

import com.badlogic.gdx.math.Circle;
import com.mike.floatynaut.Common.PrefabsSettings;

/**
 * Created by mikeldiez on 14/11/2017.
 */

public class Astronaut {

    /*Posicion*/
    private Circle bounds;
    private float xPos;
    private float yPos;

    /*gravity*/
    private float yVel = 0.01f;
    private float yVelTotal = 0;
    private float yJumpForce = 0.3f;


    public Astronaut(float xPos, float yPos, float radius) {
        this.bounds = new Circle(xPos, yPos, PrefabsSettings.PLAYER_RADIUS);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void applyGravity() {
        yVelTotal -= yVel;
        yPos += yVelTotal;
        this.setPosition(xPos, yPos);
    }

    public void applyYforce() {
        yVelTotal = PrefabsSettings.PLAYER_JUMP_SPEED;
    }

    public void setPosition(float xPos, float yPos) {
        bounds.setPosition(xPos, yPos);
    }

    public Circle getBounds() {
        return bounds;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyVel() {
        return yVel;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setyVelTotal(float yVelTotal) {
        this.yVelTotal = yVelTotal;
    }

    public float getyVelTotal() {
        return yVelTotal;
    }

    public float getyJumpForce() {
        return yJumpForce;
    }

    public float getyPos() {
        return yPos;
    }
}
