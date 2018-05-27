package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.framework.Figuras.Dibujable;
import com.framework.Texturas.TexturaRelleno;
/**Polígonos que se puedan dibujar*/
public abstract class Poligono implements Dibujable
{
    /**Conjunto de estructuras para formar un polígono*/
    private Vertices vertices;
    /**Figura a dibujar*/
    private PolygonSprite poligono;
    /**Textura de la figura*/
    TexturaRelleno relleno;
    /**Lienzo que comparten todas las figuras*/
    public static final PolygonSpriteBatch LIENZO=new PolygonSpriteBatch();
    /**Posicion del centro del polígono*/
    private float x,y;
    /**Diametro de la circunferencia que circunscribe al polígono*/
    private float lado;
    /**Margen del polígono*/
    private float borde=0;
    /**Dibuja en un lienzo estático*/
    @Override
    public void dibujar()
    {
        LIENZO.begin();
        getPoligono().draw(LIENZO);
        LIENZO.end();
    }

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

    public float getBorde()
    {
        return borde;
    }

    public void setBorde(float borde)
    {
        this.borde = borde;
    }
}
