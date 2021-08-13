/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Animations;

import java.util.TimerTask;

public abstract class Animation extends TimerTask {
    private float acceleration = 1;

    private boolean endless = false;

    private boolean ended = false;

    AnimationController controller;

    public AnimationController getController() {
        return controller;
    }

    public void setController(AnimationController controller) {
        this.controller = controller;
    }

    public Animation() {
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public boolean isEndless() {
        return endless;
    }

    public void setEndless(boolean endless) {
        this.endless = endless;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }
}
