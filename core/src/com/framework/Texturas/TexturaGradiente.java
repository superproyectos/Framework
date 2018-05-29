package com.framework.Texturas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
/*https://searchcode.com/codesearch/view/25582909/*/
public class TexturaGradiente extends TexturaColor
{
    public TexturaGradiente()
    {
        setRelleno(new Pixmap(100, 100, Pixmap.Format.RGBA8888));
        setTextura(new Texture(getRelleno()));
    }
    public TexturaGradiente(Color color)
    {
        setRelleno(new Pixmap(2, 2, Pixmap.Format.RGBA8888));
        setColor(color);
        setTextura(new Texture(getRelleno()));
        getTextura().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }
    @Override
    public void setColor(Color color)
    {
        getRelleno().drawPixel(0,0,Color.rgba8888(Colores.degradado(color,30)));
        getRelleno().drawPixel(1,0,Color.rgba8888(Colores.degradado(color,30)));
        getRelleno().drawPixel(0,1,Color.rgba8888(color));
        getRelleno().drawPixel(1,1,Color.rgba8888(color));

    }
}
