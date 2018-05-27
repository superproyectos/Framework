package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Triangulo extends PoligonoRegular
{
    public Triangulo(float x,float y,float radio,Color color)
    {
        super(x,y,radio,color);
        setVertices(generarPoligonoRegular(x,y,radio,3));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
    }
}
