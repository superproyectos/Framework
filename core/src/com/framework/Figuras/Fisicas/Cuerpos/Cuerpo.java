package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.framework.Figuras.Figura;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.PropiedadesFisicas;

/**Cuerpo-Caja de colisión*/

public abstract class Cuerpo implements PropiedadesFisicas
{
    /**Cuerpo perteneciente al objeto*/

    private Body cuerpo;

    /**Tipo de cuerpo*/

    private TipoCuerpo tipo;

    /**Conjunto de propiedades del cuerpo*/

    private PropiedadCuerpo propiedad=new PropiedadCuerpo();

    /**Mundo al que pertenece el cuerpo*/

    private World mundo=Mundo.MUNDO;

    /**Retorna el cuerpo manejado*/

    public Body getCuerpo()
    {
        return cuerpo;
    }

    /**Retorna el mundo manejado*/

    public World getMundo()
    {
        return mundo;
    }

    /**Retorna el tipo del cuerpo*/

    public TipoCuerpo getTipo()
    {
        return tipo;
    }

    /**Establece el mundo a manejar*/

    public void setMundo(World mundo)
    {
        this.mundo = mundo;
    }

    /**Retorna las propiedades del cuerpo*/

    public PropiedadCuerpo getPropiedad()
    {
        return propiedad;
    }

    /**Establece las propiedades del cuerpo*/

    public void setPropiedad(PropiedadCuerpo propiedad)
    {
        this.propiedad = propiedad;
    }

    /**Establece el tipo del cuerpo*/

    public void setTipo(TipoCuerpo tipo)
    {
        this.tipo = tipo;
    }

    /**Establece un cuerpo al cuerpo*/

    public void setCuerpo(Body cuerpo)
    {
        this.cuerpo = cuerpo;
    }

    /**Establece el id del cuerpo*/

    public void setInfoCuerpo(String info)
    {
        this.cuerpo.setUserData(info);
    }

    /**Cambia el tipo del cuerpo en un cuerpo creado*/

    public void cambiarTipo(TipoCuerpo nuevoTipo)
    {
        this.tipo=nuevoTipo;
        destruirCuerpo();
        crearCuerpo();
    }

    /**Añade un nuevo cuerpo al mundo*/

    public Body nuevoCuerpo(Figura figura)
    {
        return mundo.createBody(new DefinicionCuerpo(figura,tipo).getDefinicion());
    }

    /**Retorna la posicón relativa en X del cuerpo*/

    public float getX()
    {
        return cuerpo.getPosition().x;
    }

    /**Retorna la posición relativa en Y del cuerpo*/

    public float getY()
    {
        return cuerpo.getPosition().y;
    }

    /**Retorna la rotación del cuerpo*/

    public float getRotacion()
    {
        return (float)Math.toDegrees(cuerpo.getAngle());
    }

    /**Destuye el cuerpo*/

    public void destruirCuerpo()
    {
        mundo.destroyBody(cuerpo);
    }

    /**Añade al cuerpo un anexo*/

    public void addPropiedad()
    {
        cuerpo.createFixture(propiedad.getPropiedades());
    }

    @Override
    public void setRebote(float rebote)
    {
        propiedad.setRebote(rebote);
        destruirCuerpo();
        crearCuerpo();
    }

    @Override
    public void setDensidad(float densidad)
    {
        propiedad.setDensidad(densidad);
        destruirCuerpo();
        crearCuerpo();
    }

    @Override
    public void setPropiedades(float densidad, float friccion, float restitucion)
    {
        propiedad.setDensidad(densidad);
        propiedad.setFriccion(friccion);
        propiedad.setRebote(restitucion);
        destruirCuerpo();
        crearCuerpo();
    }

    @Override
    public void setTipoCuerpo(TipoCuerpo tipoCuerpo)
    {
        cambiarTipo(tipoCuerpo);
    }

    @Override
    public void setFriccion(float friccion)
    {
        propiedad.setFriccion(friccion);
        destruirCuerpo();
        crearCuerpo();
    }

    @Override
    public void setSensor(boolean sensor)
    {
        propiedad.setSensor(sensor);
        destruirCuerpo();
        crearCuerpo();
    }

    @Override
    public void cambioPosicion()
    {
        //No aplica
    }

    /**Crea el cuerpo*/

    public abstract void crearCuerpo();
}
