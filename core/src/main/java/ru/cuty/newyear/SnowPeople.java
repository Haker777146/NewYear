package ru.cuty.newyear;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class SnowPeople
{
    float x;
    float y;
    float width;
    float height;
    Texture img;
    Sound snd;
    public SnowPeople(float x, float y, float width, float height, Texture img, Sound snd)
    {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        this.img = img;
        this.snd = snd;
    }
    boolean hit(float tx, float ty)
    {
        return x < tx && tx < x + width && y < ty && ty < y + height;
    }
}
