/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Animations;

import android.util.Log;

import com.minerva.andnevermindengine.Core.Listeners.AnimationControllerListener;
import com.minerva.andnevermindengine.Core.Object.Property;
import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationController extends Property {

    Dictionary<String, Animation> animations = new Hashtable<>();

    Animation currentAnimation;

    Timer t = new Timer();

    private List<AnimationControllerListener> listeners = new ArrayList<>();

    public AnimationController(Dictionary<String, Animation> animations) {
        this.animations = animations;
    }

    public void runAnimation(String name){
        stopAnimations();
        Log.d("AnimController", "Starting Animation");
        if (currentAnimation != null){
            currentAnimation.cancel();
        }
        for (AnimationControllerListener l : listeners){
            l.onAnimationStart();
        }
        currentAnimation = animations.get(name);
        currentAnimation.setController(this);
        t.scheduleAtFixedRate(currentAnimation, 0, (long) (currentAnimation.getAcceleration() * Settings.TargetUpdateInterval));
    }

    public void triggerOnAnimationEnded(){
        stopAnimations();
        currentAnimation.cancel();
        currentAnimation = null;
        for (AnimationControllerListener l : listeners){
            l.onAnimationEnd();
        }
    }

    public void stopAnimations(){
        t = new Timer();
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public void addAnimationControllerListener(AnimationControllerListener l){
        listeners.add(l);
    }

    public void clearListeners(){
        listeners.clear();
    }
}
