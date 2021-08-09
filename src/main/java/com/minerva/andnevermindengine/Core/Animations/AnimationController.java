/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Animations;

import com.minerva.andnevermindengine.Core.Object.Property;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

public class AnimationController extends Property {

    Dictionary<String, Property> animations = new Hashtable<>();

    Property currentAnimation;

    public AnimationController(Dictionary<String, Property> animations) {
        this.animations = animations;
    }


    @Override
    public void run() {

    }
}
