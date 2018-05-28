package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Dibujable;
import com.framework.Figuras.Poligonos.Poligono;
/** Conjunto de polígonos*/
public class Grupo implements Dibujable
{
    /** Polígonos pertenecientes al conjunto*/

    private Array<Poligono> elementos;

    /** Nuevo grupo*/

    public Grupo(Array<Poligono> elementos)
    {
        this.elementos=new Array<Poligono>(elementos);
    }

    public Grupo(Poligono... elementos)
    {
        this.elementos=new Array<Poligono>(elementos);
    }

    /** Devuelve los polígonos pertenecientes al grupo*/

    public Array<Poligono> getElementos()
    {
        return elementos;
    }

    /** Establece los polígonos pertenecientes al grupo*/

    public void setElementos(Array<Poligono> elementos)
    {
        this.elementos = elementos;
    }

    /** Añade un polígono al grupo*/

    public void addElemento(Poligono e)
    {
        elementos.add(e);
    }

    /** Recorre cada polígono para dibujarlo*/
    @Override
    public void dibujar()
    {
        for (Poligono elemento:elementos)
            elemento.dibujar();
    }

}
