package com.framework.Figuras;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;

public class Grupo
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
    /*private void addBloques(Array<Poligono> elementos)
    {
        for(Poligono elemento:elementos)
            this.elementos.add(elemento);
    }*/
}
