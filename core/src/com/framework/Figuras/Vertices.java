package com.framework.Figuras;

public final class Vertices
{
    private float vertices[];
    private short triangulos[];
    public Vertices(float vertices[], short triangulos[])
    {
        this.vertices=vertices;
        this.triangulos=triangulos;
    }
    public float[] getVertices()
    {
        return vertices;
    }
    public short[] getTriangulos()
    {
        return triangulos;
    }

    public void setVertices(float[] vertices)
    {
        this.vertices = vertices;
    }
    public void setTriangulos(short[] triangulos)
    {
        this.triangulos = triangulos;
    }


    public void mostrar()
    {
        for(int i=0;i<vertices.length;i++)
        {
            System.out.print(vertices[i]+" ");
        }
    }
}
