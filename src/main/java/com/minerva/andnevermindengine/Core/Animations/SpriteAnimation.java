package com.minerva.andnevermindengine.Core.Animations;

import android.util.Log;

import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Object.Property;
import com.minerva.andnevermindengine.Core.Primitives.Sprite;
import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpriteAnimation extends Animation {

    Object object;
    Sprite[] sprites;

    int currentSpriteIndex = 0;

    public SpriteAnimation(Object object, Sprite[] sprites) {
        this.object = object;
        this.sprites = sprites;
    }

    @Override
    public void run() {
        Log.d("SpritesAnim", "setting next sprite");
        try {
            object.setCurrentSprite(sprites[currentSpriteIndex]);
            currentSpriteIndex += 1;
        } catch (IndexOutOfBoundsException e){
            if (isEndless()){
                currentSpriteIndex = 0;
            }
            else {
                setEnded(true);
                controller.triggerOnAnimationEnded();
            }
        }
    }
}
