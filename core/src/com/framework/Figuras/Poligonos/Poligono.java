package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.framework.Figuras.Dibujable;
import com.framework.Figuras.Figura;
import com.framework.Texturas.TexturaRelleno;

/**Polígonos que se puedan dibujar*/

public abstract class Poligono extends Figura
{
    /**Lienzo que comparten todas las figuras*/

    public static final PolygonSpriteBatch LIENZO=new PolygonSpriteBatch();

    /**Conjunto de estructuras para formar un polígono*/

    private Vertices vertices;

    /**Figura a dibujar*/

    private PolygonSprite poligono;

    /**Textura de la figura*/

    TexturaRelleno relleno;

    /**Dibuja en un lienzo estático*/

    @Override
    public void dibujar()
    {
        LIENZO.begin();
        poligono.draw(LIENZO);
        LIENZO.end();
    }

    /**Retorna la estuctura que conforma al polígono*/

    public Vertices getVertices()
    {
        return vertices;
    }

    /**Retorna la forma del polígono*/

    public PolygonSprite getPoligono()
    {
        return poligono;
    }

    /**Retorna el relleno del polígono*/

    public TexturaRelleno getRelleno()
    {
        return relleno;
    }

    /**Establece el relleno del polígono*/

    public void setRelleno(TexturaRelleno color)
    {
        this.relleno = color;
    }

    /**Establece la forma del polígono*/

    public void setPoligono(PolygonSprite poligono)
    {
        this.poligono = poligono;
    }

    /**Establece la estuctura que conforma al polígono*/

    public void setVertices(Vertices vertices)
    {
        this.vertices=vertices;
    }

    /**Crear polígono*/

    public PolygonSprite crearPoligono(TexturaRelleno color,Vertices vertices)
    {
        return new PolygonSprite(new PolygonRegion(new TextureRegion(color.getTextura()), vertices.getVertices(), vertices.getTriangulos()));
    }

    /**Establecer origen de rotación del polígono*/
    public void setOrigenPoligono(float x,float y)
    {
        poligono.setOrigin(x,y);
    }
    public void setOrigenPoligono()
    {
        poligono.setOrigin(poligono.getX(),poligono.getY());
    }

    /**Establecer posición del polígono*/
    public void setPosicion(float x,float y)
    {
        poligono.setPosition(x,y);
    }

    /**Establecer rotación del polígono*/

    public void setRotacion(float grados)
    {
        poligono.setRotation(grados);
    }
}
