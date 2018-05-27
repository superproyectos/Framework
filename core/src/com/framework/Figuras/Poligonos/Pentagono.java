package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Pentagono extends PoligonoRegular
{
    /**Crea un pentágono*/
    public Pentagono(float x,float y,float radio,Color color)
    {
        super(x,y,radio,color);
        setVertices(generarPoligonoRegular(x,y,radio,5));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
    }
}
