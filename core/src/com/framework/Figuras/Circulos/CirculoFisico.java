package com.framework.Figuras.Circulos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.framework.Camara;
import com.framework.Figuras.Fisicas.Cuerpos.CuerpoCircular;
import com.framework.Figuras.Fisicas.Cuerpos.PropiedadCuerpo;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoDinamico;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;
import com.framework.Figuras.PropiedadesFisicas;

public class CirculoFisico extends Circulo implements PropiedadesFisicas
{
    private CuerpoCircular cuerpo;
    private TipoCuerpo tipoCuerpo;
    public CirculoFisico(float x, float y, float radio)
    {
        super(x, y, radio);
        tipoCuerpo=new CuerpoDinamico();
        cuerpo=new CuerpoCircular(redimensionar(),tipoCuerpo);
    }
    public CirculoFisico(float x, float y, float radio, Color color)
    {
        super(x, y, radio,color);
        tipoCuerpo=new CuerpoDinamico();
        cuerpo=new CuerpoCircular(redimensionar(),tipoCuerpo);
    }
    private Circulo redimensionar()
    {
        Circulo aux=new Circulo(getX()/Camara.getPPM(),getY()/Camara.getPPM(),getRadio()/Camara.getPPM());
        return aux;
    }
    public TipoCuerpo getTipoCuerpo()
    {
        return tipoCuerpo;
    }

    @Override
    public void setDensidad(float densidad)
    {
        cuerpo.setDensidad(densidad);
    }

    @Override
    public void setFriccion(float friccion)
    {
        cuerpo.setFriccion(friccion);
    }

    @Override
    public void setRebote(float restitucion)
    {
        cuerpo.setRebote(restitucion);
    }

    @Override
    public void setSensor(boolean sensor)
    {
        cuerpo.setSensor(sensor);
    }

    @Override
    public void setPropiedades(float densidad, float friccion, float restitucion)
    {
        cuerpo.setPropiedad(new PropiedadCuerpo(new CircleShape(),densidad,friccion,restitucion));
    }

    public void setTipoCuerpo(TipoCuerpo tipoCuerpo)
    {
        this.tipoCuerpo=tipoCuerpo;
    }

    @Override
    public void cambioPosicion()
    {
        setCentro(getCuerpo().getCuerpo().getPosition().x*100,getCuerpo().getCuerpo().getPosition().y*100);
    }

    public CuerpoCircular getCuerpo()
    {
        return cuerpo;
    }

    @Override
    public void dibujar()
    {
        cambioPosicion();
        super.dibujar();
    }
}
