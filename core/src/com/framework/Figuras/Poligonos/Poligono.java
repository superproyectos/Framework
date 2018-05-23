package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.framework.Figuras.TexturaRelleno;
import com.framework.Figuras.Vertices;

public abstract class Poligono
{
    private Vertices vertices;
    private PolygonSprite poligono;
    TexturaRelleno relleno;
    public static final PolygonSpriteBatch LIENZO=new PolygonSpriteBatch();
    private float x,y,lado;

    public abstract void dibujar();

    public Vertices getVertices()
    {
        return vertices;
    }

    public PolygonSprite getPoligono()
    {
        return poligono;
    }

    public float getLado()
    {
        return lado;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public TexturaRelleno getRelleno()
    {
        return relleno;
    }

    public void setRelleno(TexturaRelleno color)
    {
        this.relleno = color;
    }

    public void setLado(float lado)
    {
        this.lado = lado;
    }

    public void setPoligono(PolygonSprite poligono)
    {
        this.poligono = poligono;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }
    public void setCentro(float x,float y)
    {
        this.x=x;
        this.y=y;
    }
    public void setVertices(Vertices vertices)
    {
        this.vertices=vertices;
    }
    public PolygonSprite crearPoligono(TexturaRelleno color,Vertices vertices)
    {
        return new PolygonSprite(new PolygonRegion(new TextureRegion(color.getTextura()), vertices.getVertices(), vertices.getTriangulos()));
    }
    public void setOrigenPoligono(float x,float y)
    {
        poligono.setOrigin(x,y);
    }
    public void setOrigenPoligono()
    {
        poligono.setOrigin(poligono.getX(),poligono.getY());
    }
    public void setPosicion(float x,float y)
    {
        poligono.setPosition(x,y);
    }
    public void setRotacion(float grados)
    {
        poligono.setRotation(grados);
    }
}
