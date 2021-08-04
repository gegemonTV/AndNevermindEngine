/*
 * Copyright (c) 2021.
 * Vladimir Mekhtiev
 * This product was published under MIT license.
 */

package com.minerva.andnevermindengine.Core.Settings;

import android.widget.FrameLayout;

import java.util.Timer;

public class Settings {
    public static boolean AutoResizeEnabled = false;
    public static boolean FullScreen = false;
    public static int TargetFrameRate = 60;
    public static int TargetUpdateInterval = 1000 / TargetFrameRate;
    public static float ScaleFactorY=1;
    public static float ScaleFactorX=1;
    public static int DefaultXRes = 1080;
    public static int DefaultYRes = 1920;
    public static int CurrentXRes;
    public static int CurrentYRes;
    public static int RealFrameRate=0;
    public static int FrameCounter = 0;

    public static void GenerateSettings(int w, int h)
    {
        Settings.CurrentXRes = w;
        Settings.CurrentYRes = h;
        Settings.ScaleFactorX = (float)Settings.CurrentXRes/(float)Settings.DefaultXRes;
        Settings.ScaleFactorY = (float)Settings.CurrentYRes/(float)Settings.DefaultYRes;
        if (Settings.ScaleFactorX!=1||Settings.ScaleFactorY!=1)
        {
            Settings.AutoResizeEnabled=true;
        }
    }

    public static void setTargetFrameRate(int fr)
    {
        Settings.TargetFrameRate=fr;
        TargetUpdateInterval = 1000/TargetFrameRate;

    }

    public static void setDefaultRes(int x, int y)
    {
        Settings.DefaultXRes = x;
        Settings.DefaultYRes = y;
    }

    public static int getFrameRate()
    {
        RealFrameRate = 1000 / FrameCounter;
        return Settings.RealFrameRate;
    }

    public static void newFrame()
    {
        Settings.FrameCounter++;
    }
}
