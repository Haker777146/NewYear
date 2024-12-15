package ru.cuty.newyear;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter
{
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Texture imgBackGround, imgSnow, imgGerlund, imgStarEle, imgSnowPeople;

    private Sound sndPhraza1, sndPhraza2, sndPhraza3, sndPhraza4, sndPhraza5, sndPhraza6;

    private Music sndNewYear;

    private BitmapFont font;

    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;
    public static final float SPAWN_SNOW1_Y = 750;

    private int numbersnow, g;

    private Vector3 touch;

    StarEle[] starEle = new StarEle[12];
    SnowPeople[] snowPeople = new SnowPeople[6];
    Snow1[] snow = new Snow1[10000000];

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

        imgBackGround = new Texture("Pictures/BackGround.png");
        imgSnow = new Texture("Pictures/Snow.png");
        imgGerlund = new Texture("Pictures/Gerlunds.png");
        imgStarEle = new Texture("Pictures/StarEle.png");
        imgSnowPeople = new Texture("Pictures/SnowPeople.png");

        sndNewYear = Gdx.audio.newMusic(Gdx.files.internal("Sounds/NewYearsounds.mp3"));
        sndPhraza1 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza1.mp3"));
        sndPhraza2 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza2.mp3"));
        sndPhraza3 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza3.mp3"));
        sndPhraza4 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza4.mp3"));
        sndPhraza5 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza5.mp3"));
        sndPhraza6 = Gdx.audio.newSound(Gdx.files.internal("Sounds/sndPhraza6.mp3"));

        font = new BitmapFont(Gdx.files.internal("Fonts/comisex.fnt"));

        for (int i = 0; i < starEle.length; i++)
        {
            starEle[0] = new StarEle(910, 292, 50, 50, imgStarEle);
            starEle[1] = new StarEle(835, 250, 45, 45, imgStarEle);
            starEle[2] = new StarEle(927, 480, 40, 40, imgStarEle);
            starEle[3] = new StarEle(425, 425, 23, 23, imgStarEle);
            starEle[4] = new StarEle(527, 365, 25, 25, imgStarEle);
            starEle[5] = new StarEle(863, 415, 25, 25, imgStarEle);
            starEle[6] = new StarEle(805, 370, 20, 20, imgStarEle);
            starEle[7] = new StarEle(-50, 380, 500, 150, imgGerlund);
            starEle[8] = new StarEle(1050, 450, 300, 200, imgGerlund);
            starEle[9] = new StarEle(1000, 350, 330, 200, imgGerlund);
            starEle[10] = new StarEle(1000, 230, 330, 200, imgGerlund);
            starEle[11] = new StarEle(-10, 228, 500, 150, imgGerlund);
        }

        for (int i = 0; i < snowPeople.length; i++)
        {
            snowPeople[0] = new SnowPeople(110, 20,100, 100, imgSnowPeople, sndPhraza1);
            snowPeople[1] = new SnowPeople(100, 320, 100, 100, imgSnowPeople, sndPhraza2);
            snowPeople[2] = new SnowPeople(300, 292, 100, 100, imgSnowPeople, sndPhraza3);
            snowPeople[3] = new SnowPeople(485, 145, 120, 120, imgSnowPeople, sndPhraza4);
            snowPeople[4] = new SnowPeople(720, 160, 110, 110, imgSnowPeople, sndPhraza5);
            snowPeople[5] = new SnowPeople(1170, 10, 120, 120, imgSnowPeople, sndPhraza6);
        }

        sndNewYear.setVolume(0.2f);
        sndNewYear.play();
    }

    @Override
    public void render()
    {
        if(Gdx.input.justTouched())
        {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);
            System.out.println(touch.x + " / " + touch.y);
            for (SnowPeople sn : snowPeople)
            {
                if(sn.hit(touch.x, touch.y))
                {
                    sn.snd.play(1);
                }
            }
        }

        Snowers();
        Snowers1();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for (SnowPeople s: snowPeople)
        {
            batch.draw(s.img, s.x, s.y, s.width, s.height);
        }

        font.draw(batch, "1", 168, 110);
        font.draw(batch, "2", 157, 412);
        font.draw(batch, "3", 358, 383);
        font.draw(batch, "4", 554, 253);
        font.draw(batch, "5", 784, 260);
        font.draw(batch, "6", 1241, 119);

        for (StarEle s : starEle)
        {
            batch.draw(s.img, s.x, s.y, s.width, s.height);
        }

        for (int i = 0; i < numbersnow; i++)
        {
            batch.draw(imgSnow, snow[i].x, snow[i].y, snow[i].width, snow[i].height);
        }
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();

        imgBackGround.dispose();
        imgSnow.dispose();
        imgGerlund.dispose();
        imgStarEle.dispose();
        imgSnowPeople.dispose();

        sndNewYear.dispose();
        sndPhraza1.dispose();
        sndPhraza2.dispose();
        sndPhraza3.dispose();
        sndPhraza4.dispose();
        sndPhraza5.dispose();
        sndPhraza6.dispose();

        font.dispose();
    }

    private void Snowers()
    {
        g++;
        if(g%10 == 0 && numbersnow < snow.length)
        {
            float wh = MathUtils.random(20f,30);
            float x = MathUtils.random(15f,1235);
            snow[numbersnow] = new Snow1(x, SPAWN_SNOW1_Y, wh, wh, imgSnow);
            numbersnow++;
        }
    }

    private void Snowers1()
    {
        for(int i = 0; i < numbersnow; i++)
        {
            snow[i].fly();
        }
    }
}
