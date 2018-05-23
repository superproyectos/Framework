package com.framework.Figuras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class TexturaColor extends TexturaRelleno
{
    public TexturaColor()
    {
        setRelleno(new Pixmap(1, 1, Pixmap.Format.RGBA8888));
        setTextura(new Texture(getRelleno()));
    }
    public TexturaColor(Color color)
    {
        setRelleno(new Pixmap(1, 1, Pixmap.Format.RGBA8888));
        setColor(color);
        setTextura(new Texture(getRelleno()));
    }
    public void setColor(Color color)
    {
        getRelleno().setColor(color);
        getRelleno().fill();
    }
}
