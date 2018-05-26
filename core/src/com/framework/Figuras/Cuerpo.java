package com.framework.Figuras;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.TiposDeCuerpos.TipoCuerpo;
import com.framework.Framework;

public class Cuerpo
{
    private Body cuerpo;
    private TipoCuerpo tipo;
    public Cuerpo(Array<Poligono> elementos,TipoCuerpo tipo)
    {
        this.tipo=tipo;
        crearCuerpo(elementos);
    }

    private void crearCuerpo(Array<Poligono> elementos)
    {
        cuerpo = Framework.mundo.createBody(new DefinicionCuerpo(elementos.get(0),tipo).getDefinicion());
        for (Poligono p:elementos)
        {
            PolygonShape shape=new PolygonShape();
            shape.set(p.getVertices().redimensionar(100));
            cuerpo.createFixture(new PropiedadCuerpo(shape,5,0.2f,5).getPropiedades());
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
}
