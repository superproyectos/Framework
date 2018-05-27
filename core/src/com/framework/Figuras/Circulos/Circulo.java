package com.framework.Figuras.Circulos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.framework.Figuras.Figura;

public class Circulo extends Figura
{
    public static final ShapeRenderer LIENZO=new ShapeRenderer();
    public Circulo(float x,float y,float radio)
    {
        setCentro(x,y);
        setRadio(radio);
    }
    public Circulo(float x,float y,float radio,Color color)
    {
        setCentro(x,y);
        setRadio(radio);
        LIENZO.setColor(color);
    }

    public void setColor(Color color)
    {
        LIENZO.setColor(color);
    }

    @Override
    public void dibujar()
    {
        LIENZO.begin(ShapeRenderer.ShapeType.Filled);
            LIENZO.circle(getX(),getY(),getRadio());
        LIENZO.end();
    }
}
