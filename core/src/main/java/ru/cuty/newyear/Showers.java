package ru.cuty.newyear;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Showers
{
    float x;
    float y;
    float stepY;
    float width;
    float height;
    Texture img;
    void fly()
    {
        y -= stepY;
    }
    public Showers(float x, float y, float width, float height, Texture img)
    {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        stepY = MathUtils.random( 2.9f, 3);
        this.img = img;
    }
}
