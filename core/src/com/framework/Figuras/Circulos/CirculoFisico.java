package com.framework.Figuras.Circulos;

import com.badlogic.gdx.graphics.Color;
import com.framework.Figuras.Fisicas.Cuerpos.Cuerpo;

public class CirculoFisico extends Circulo
{
    private Cuerpo cuerpo;
    public CirculoFisico(float x, float y, float radio)
    {
        super(x, y, radio);
    }
    public CirculoFisico(float x, float y, float radio, Color color)
    {
        super(x, y, radio,color);
    }
}
