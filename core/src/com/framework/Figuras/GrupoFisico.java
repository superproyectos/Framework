package com.framework.Figuras;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.TiposDeCuerpos.CuerpoDinamico;

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
        crearCuerpo();
    }
    private void crearCuerpo()
    {
        cuerpo=new Cuerpo(getElementos(),new CuerpoDinamico());
    }
    private void cambioPosicion()
    {
        for (Poligono p:getElementos())
        {
            p.setPosicion(cuerpo.getX()*100,cuerpo.getY()*100);
            p.setRotacion(cuerpo.getRotacion());
        }
    }
    @Override
    public void dibujar()
    {
        cambioPosicion();
        super.dibujar();
    }
}
