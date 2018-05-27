package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Dibujable;
import com.framework.Figuras.Poligonos.Poligono;

public class Grupo implements Dibujable
{
    private Array<Poligono> elementos;
    public Grupo(Array<Poligono> elementos)
    {
        this.elementos=new Array<Poligono>(elementos);
    }
    public Grupo(Poligono... elementos)
    {
        this.elementos=new Array<Poligono>(elementos);
    }
    @Override
    public void dibujar()
    {
        for (Poligono elemento:elementos)
            elemento.dibujar();
    }

    public Array<Poligono> getElementos()
    {
        return elementos;
    }

    public void setElementos(Array<Poligono> elementos)
    {
        this.elementos = elementos;
    }

    public void addElemento(Poligono e)
    {
        elementos.add(e);
    }
}
