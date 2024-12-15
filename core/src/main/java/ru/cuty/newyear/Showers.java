package ru.cuty.newyear;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Showers
{
    float x;
    float y;
    float stepY;
    float stepX;
    float width;
    float height;
    Texture img;
    void fly()
    {
        y -= stepY;
        x -= stepX;
    }
    public Showers(float x, float y, float width, float height, Texture img)
    {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        stepY = MathUtils.random(1f,1.3f);
        stepX = MathUtils.random(-0.13f, 0.13f);
        this.img = img;
    }
}
