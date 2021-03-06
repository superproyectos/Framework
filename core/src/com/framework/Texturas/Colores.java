package com.framework.Texturas;

import com.badlogic.gdx.graphics.Color;

public class Colores
{
    //PALETA DE COLORES https://htmlcolorcodes.com/es/
    public static final Color AZUL=getColor(52, 152, 219 ,1);
    public static final Color ROJO=getColor(231, 76, 60,1);
    public static final Color MORADO=getColor(142, 68, 173,1);
    public static final Color TURQUESA=getColor(26, 188, 156,1);
    public static final Color VERDE=getColor(30, 132, 73 ,1);
    public static final Color AMARILLO=getColor(241, 196, 15  ,1);
    public static final Color NARANJA=getColor(220, 118, 51  ,1);
    public static final Color GRIS=getColor(149, 165, 166  ,1);

    public static final Color getColor(float r,float g,float b,float a)
    {
        return new Color(r/255f,g/255f,b/255f,a);
    }
    public static final Color degradado(Color color,float degradado)
    {
        degradado/=100;
        return new Color(color.r-degradado,color.g-degradado,color.b-degradado,color.a);
    }
}
