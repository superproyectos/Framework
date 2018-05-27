package com.framework.Figuras.Fisicas;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.TiposDeCuerpos.TipoCuerpo;

public class Cuerpo
{
    private Array<Poligono> elementos;
    private Body cuerpo;
    private TipoCuerpo tipo;
    private PropiedadCuerpo propiedad;
    private World mundo;

    public Cuerpo(Array<Poligono> elementos,TipoCuerpo tipo)
    {
        this.elementos=elementos;
        this.tipo=tipo;
        propiedad=new PropiedadCuerpo();
        mundo=Mundo.MUNDO;
        crearCuerpo();
    }

    public Cuerpo(Array<Poligono> elementos,TipoCuerpo tipo,float densidad,float friccion,float restitucion)
    {
        this.tipo=tipo;
        this.elementos=elementos;
        propiedad=new PropiedadCuerpo(new PolygonShape(),densidad,friccion,restitucion);
        mundo=Mundo.MUNDO;
        crearCuerpo();
    }

    private void crearCuerpo()
    {
        cuerpo = mundo.createBody(new DefinicionCuerpo(elementos.get(0),tipo).getDefinicion());
        cuerpo.setUserData(this);
        for (Poligono p:elementos)
        {
            PolygonShape shape=new PolygonShape();
            shape.set(p.getVertices().redimensionar(100));
            propiedad.setForma(shape);
            cuerpo.createFixture(propiedad.getPropiedades());
            shape.dispose();
        }
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
    public PropiedadCuerpo getPropiedad()
    {
        return propiedad;
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
    public void setTipo(TipoCuerpo tipo)
    {
        this.tipo = tipo;
    }
    public void setPropiedad(PropiedadCuerpo propiedad)
    {
        this.propiedad = propiedad;
    }
    public TipoCuerpo getTipo()
    {
        return tipo;
    }

    public void setMundo(World mundo)
    {
        this.mundo = mundo;
    }

    public World getMundo()
    {
        return mundo;
    }
}
