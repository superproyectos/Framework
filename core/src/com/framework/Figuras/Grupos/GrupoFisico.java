package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoPoligono;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoDinamico;

public class GrupoFisico extends Grupo
{
    private CuerpoPoligono cuerpoPoligono;
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
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico());
    }
    private void crearCuerpo(float densidad,float friccion,float restitucion)
    {
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico(),densidad,friccion,restitucion);
    }
    private void cambioPosicion()
    {
        for (Poligono p:getElementos())
        {
            p.setPosicion(cuerpoPoligono.getX()*100, cuerpoPoligono.getY()*100);
            p.setRotacion(cuerpoPoligono.getRotacion());
        }
    }
    public void setDensidad(float densidad)
    {
        cuerpoPoligono.setDensidad(densidad);
    }
    public void setFriccion(float friccion)
    {
        cuerpoPoligono.setFriccion(friccion);
    }
    public void setRebote(float restitucion)
    {
        cuerpoPoligono.setRebote(restitucion);
    }
    public void setSensor(boolean sensor)
    {
        cuerpoPoligono.setSensor(sensor);
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
