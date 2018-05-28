package com.framework.Figuras.Grupos;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.PropiedadesFisicas;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoPoligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoDinamico;

/** Grupo de polígonos que actúan como un bloque físico*/

public class GrupoFisico extends Grupo implements PropiedadesFisicas
{
    /** Cuerpo perteneciente al grupo*/

    private CuerpoPoligono cuerpoPoligono;

    /** Crea grupo físico*/

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

    /** Crea el cuerpo para el grupo*/

    private void crearCuerpo()
    {
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico());
    }

    private void crearCuerpo(float densidad,float friccion,float restitucion)
    {
        cuerpoPoligono =new CuerpoPoligono(getElementos(),new CuerpoDinamico(),densidad,friccion,restitucion);
    }

    @Override
    public void cambioPosicion()
    {
        for (Poligono p:getElementos())
        {
            p.setPosicion(cuerpoPoligono.getX()*100, cuerpoPoligono.getY()*100);
            p.setRotacion(cuerpoPoligono.getRotacion());
        }
    }
    @Override
    public void setDensidad(float densidad)
    {
        cuerpoPoligono.setDensidad(densidad);
    }
    @Override
    public void setFriccion(float friccion)
    {
        cuerpoPoligono.setFriccion(friccion);
    }
    @Override
    public void setRebote(float restitucion)
    {
        cuerpoPoligono.setRebote(restitucion);
    }
    @Override
    public void setSensor(boolean sensor)
    {
        cuerpoPoligono.setSensor(sensor);
    }
    @Override
    public void setPropiedades(float densidad,float friccion,float restitucion)
    {
        setDensidad(densidad);
        setRebote(restitucion);
        setFriccion(friccion);
    }
    @Override
    public void setTipoCuerpo(TipoCuerpo tipoCuerpo)
    {
        cuerpoPoligono.cambiarTipo(tipoCuerpo);
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
