package com.framework.Texturas;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public abstract class TexturaRelleno
{
    private Pixmap relleno;
    private Texture textura;
    public void setTextura(Texture textura)
    {
        this.textura = textura;
    }
    public void setRelleno(Pixmap relleno)
    {
        this.relleno = relleno;
    }
    public Texture getTextura()
    {
        return textura;
    }
    public Pixmap getRelleno()
    {
        return relleno;
    }
}
