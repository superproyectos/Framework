package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Cuadrado extends PoligonoRegular
{
    public Cuadrado(float x,float y,float lado,Color color)
    {
        super(x,y,lado,color);
        setVertices(generarPoligonoRegular(x,y,lado*(float)Math.sqrt(2)/2,4));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
        //getVertices().mostrar(getVertices().getVertices());
    }

    @Override
    public void dibujar()
    {
        LIENZO.begin();
        getPoligono().draw(LIENZO);
        LIENZO.end();
    }
}
