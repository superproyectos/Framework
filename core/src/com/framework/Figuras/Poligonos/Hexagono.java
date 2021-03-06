package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Hexagono extends PoligonoRegular
{
    /**Crea un hexágono*/
    public Hexagono(float x,float y,float radio,Color color)
    {
        super(x,y,radio,color);
        setVertices(generarPoligonoRegular(x,y,radio,6));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
    }
}
