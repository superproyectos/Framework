package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Fisicas.Cuerpo;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.TiposDeCuerpos.CuerpoDinamico;

public class GrupoFisico extends Grupo
{
    private Cuerpo cuerpo;
    public GrupoFisico(Array<Poligono> elementos)
    {
        super(elementos);
        crearCuerpo();
    }
    public GrupoFisico(Array<Poligono> elementos,float densidad,float friccion,float restitucion)
    {
        super(elementos);
        crearCuerpo(densidad,friccion,restitucion);
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
    private void crearCuerpo(float densidad,float friccion,float restitucion)
    {
        cuerpo=new Cuerpo(getElementos(),new CuerpoDinamico(),densidad,friccion,restitucion);
    }
    private void cambioPosicion()
    {
        for (Poligono p:getElementos())
        {
            p.setPosicion(cuerpo.getX()*100,cuerpo.getY()*100);
            p.setRotacion(cuerpo.getRotacion());
        }
    }
    public void setDensidad(float densidad)
    {
        cuerpo.setDensidad(densidad);
    }
    public void setFriccion(float friccion)
    {
        cuerpo.setFriccion(friccion);
    }
    public void setRebote(float restitucion)
    {
        cuerpo.setRebote(restitucion);
    }
    public void setSensor(boolean sensor)
    {
        cuerpo.setSensor(sensor);
    }
    public void setPropiedades(float densidad,float friccion,float restitucion)
    {
        setDensidad(densidad);
        setRebote(restitucion);
        setFriccion(friccion);
    }

    @Override
    public void addElemento(Poligono e)
    {
        super.addElemento(e);
        crearCuerpo();
    }

    @Override
    public void dibujar()
    {
        cambioPosicion();
        super.dibujar();
    }
}
