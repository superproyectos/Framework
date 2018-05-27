package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;

public class Octagono extends PoligonoRegular
{
    /**Crea un Octágono*/
    public Octagono(float x,float y,float radio,Color color)
    {
        super(x,y,radio,color);
        setVertices(generarPoligonoRegular(x,y,radio,8));
        setPoligono(crearPoligono(getRelleno(),getVertices()));
        setOrigenPoligono();
    }
}
