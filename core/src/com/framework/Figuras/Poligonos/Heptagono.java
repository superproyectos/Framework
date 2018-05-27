package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Heptagono extends PoligonoRegular
{
    /**Crea un heptágono*/
    public Heptagono(float x,float y,float radio,Color color)
    {
        super(x,y,radio,color);
        setVertices(generarPoligonoRegular(x,y,radio,7));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
    }
}
