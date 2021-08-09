package com.minerva.andnevermindengine.Core.Animations;

import com.minerva.andnevermindengine.Core.Object.Object;
import com.minerva.andnevermindengine.Core.Object.Property;
import com.minerva.andnevermindengine.Core.Primitives.Sprite;
import com.minerva.andnevermindengine.Core.Settings.Settings;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpriteAnimation extends Property {

    Object object;
    Sprite[] sprites;

    int currentSpriteIndex = 0;

    TimerTask updateTask;

    ScheduledExecutorService service;

    private boolean endless = false;

    public SpriteAnimation(Object object, Sprite[] sprites) {
        this.object = object;
        this.sprites = sprites;

        service = Executors.newSingleThreadScheduledExecutor();

        updateTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    object.setCurrentSprite(sprites[currentSpriteIndex]);
                    currentSpriteIndex += 1;
                } catch (IndexOutOfBoundsException e){
                    if (endless){
                        currentSpriteIndex = 0;
                    }
                    else {
                        service.shutdown();
                    }
                }
            }
        };
        service.scheduleAtFixedRate(updateTask, 0, Settings.getFrameRate(), TimeUnit.MILLISECONDS);
    }



    @Override
    public void run() {

    }
}
