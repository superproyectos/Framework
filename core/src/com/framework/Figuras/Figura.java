package com.framework.Figuras;

/**Figuras con la capacidad de dibujarse*/

public abstract class Figura implements Dibujable
{
    /**Posicion del centro de la figura*/

    private float x,y;

    /**Margen de la figura*/

    private float margen =0;

    /**Diametro de la circunferencia que circunscribe a la figura*/

    private float radio;

    /**Retorna la posición horizontal del centro de la figura*/

    public float getX()
    {
        return x;
    }

    /**Retorna la posición vertical del centro de la figura*/

    public float getY()
    {
        return y;
    }

    /**Establece la posición horizontal del centro de la figura*/

    public void setX(float x)
    {
        this.x = x;
    }

    /**Establece la posición vertical del centro de la figura*/

    public void setY(float y)
    {
        this.y = y;
    }

    /**Establece la posición del centro de la figura*/

    public void setCentro(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    /**Establece el grueso del margen*/

    public void setMargen(float margen)
    {
        this.margen = margen;
    }

    /**Retorna el grueso del margen*/

    public float getMargen()
    {
        return margen;
    }

    /**Retorna el radio de la figura*/

    public float getRadio()
    {
        return radio;
    }

    /**Establece el radio de la figura*/

    public void setRadio(float radio)
    {
        this.radio = radio;
    }
}
