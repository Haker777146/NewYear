package ru.cuty.newyear;

import com.badlogic.gdx.graphics.Texture;

public class StarEle
{
    float x;
    float y;
    float width;
    float height;
    Texture img;
    public StarEle(float x, float y, float width, float height, Texture img)
    {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        this.img = img;
    }
}
