package com.framework.Figuras;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;

public class GrupoFisico extends Grupo
{
    private Cuerpo cuerpo;
    public GrupoFisico(Array<Poligono> elementos)
    {
        super(elementos);
        crearCuerpo();
    }
    public GrupoFisico(Poligono... elementos)
    {
        super(elementos);
    }
    private void crearCuerpo()
    {

    }
}
