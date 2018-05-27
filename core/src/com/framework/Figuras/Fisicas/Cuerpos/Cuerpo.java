package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;
import com.framework.Figuras.Poligonos.Poligono;

public abstract class Cuerpo
{
    private Body cuerpo;
    private TipoCuerpo tipo;
    private PropiedadCuerpo propiedad;
    private World mundo;

    public Body getCuerpo()
    {
        return cuerpo;
    }

    public World getMundo()
    {
        return mundo;
    }

    public void setMundo(World mundo)
    {
        this.mundo = mundo;
    }

    public TipoCuerpo getTipo()
    {
        return tipo;
    }

    public void setPropiedad(PropiedadCuerpo propiedad)
    {
        this.propiedad = propiedad;
    }

    public void setTipo(TipoCuerpo tipo)
    {
        this.tipo = tipo;
    }

    public PropiedadCuerpo getPropiedad()
    {
        return propiedad;
    }

    public void setCuerpo(Body cuerpo)
    {
        this.cuerpo = cuerpo;
    }
    /**aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/
    public Body nuevoCuerpo(Poligono f)
    {
        return mundo.createBody(new DefinicionCuerpo(f,tipo).getDefinicion());
    }

    public void setInfoCuerpo(String info)
    {
        this.cuerpo.setUserData(info);
    }

    public float getX()
    {
        return cuerpo.getPosition().x;
    }

    public float getY()
    {
        return cuerpo.getPosition().y;
    }

    public float getRotacion()
    {
        return (float)Math.toDegrees(cuerpo.getAngle());
    }

    public void setRebote(float rebote)
    {
        propiedad.setRebote(rebote);
        destruirCuerpo();
        crearCuerpo();
    }
    public void setDensidad(float densidad)
    {
        propiedad.setDensidad(densidad);
        destruirCuerpo();
        crearCuerpo();
    }
    public void setFriccion(float friccion)
    {
        propiedad.setFriccion(friccion);
        destruirCuerpo();
        crearCuerpo();
    }

    public void setSensor(boolean sensor)
    {
        propiedad.setSensor(sensor);
        destruirCuerpo();
        crearCuerpo();
    }

    public void destruirCuerpo()
    {
        mundo.destroyBody(cuerpo);
    }

    public void addPropiedad()
    {
        cuerpo.createFixture(propiedad.getPropiedades());
    }

    public abstract void crearCuerpo();
}
