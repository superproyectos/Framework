package com.framework.Figuras.Poligonos;

import com.badlogic.gdx.graphics.Color;
import com.framework.Texturas.TexturaColor;


public abstract class PoligonoRegular extends Poligono
{
    public PoligonoRegular(float x, float y,float lado, Color color)
    {
        setCentro(x,y);
        setLado(lado);
        setRelleno(new TexturaColor(color));
    }
    private float[] generaVertices(float x, float y, float radio, int n)
    {
        double angulo=2*Math.PI/n;
        double aux=n%2==0?angulo/2:Math.PI/2;
        float vertices[]=new float[n*2];
        for(int i=0;i<2*n;i+=2)
        {
            vertices[i]=x+radio*(float)Math.cos(aux)-(float)Math.cos(aux)*getBorde();
            vertices[i+1]=y+radio*(float)Math.sin(aux)-(float)Math.sin(aux)*getBorde();
            aux+=angulo;
        }
        return vertices;
    }
    private short[] generaTriangulos(int longitud)
    {
        short triangulos[]=new short[3*(longitud/2-2)];
        for(int i=1,index=0;index<triangulos.length;i++,index+=3)
        {
            triangulos[index]=0;
            triangulos[index+1]=(short)i;
            triangulos[index+2]=(short)(i+1);
        }
        return triangulos;
    }
    public Vertices generarPoligonoRegular(float x, float y, float radio, int nLados)
    {
        if(nLados>2&&nLados<9)
        {
            float vertices[]= generaVertices(x,y,radio,nLados);
            short triangulos[]=generaTriangulos(vertices.length);
            return new Vertices(vertices,triangulos);
        }
        return null;
    }
}
