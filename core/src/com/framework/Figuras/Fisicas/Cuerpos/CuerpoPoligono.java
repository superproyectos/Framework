package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;

public class CuerpoPoligono extends Cuerpo
{
    private Array<Poligono> elementos;

    public CuerpoPoligono(Poligono elemento,TipoCuerpo tipoCuerpo)
    {
        this.elementos=new Array<Poligono>();
        elementos.add(elemento);
        setTipo(tipoCuerpo);
        setPropiedad(new PropiedadCuerpo());
        setMundo(Mundo.MUNDO);
        crearCuerpo();
    }
    public CuerpoPoligono(Array<Poligono> elementos, TipoCuerpo tipoCuerpo)
    {
        this.elementos=elementos;
        setTipo(tipoCuerpo);
        setPropiedad(new PropiedadCuerpo());
        setMundo(Mundo.MUNDO);
        crearCuerpo();
    }

    public CuerpoPoligono(Array<Poligono> elementos, TipoCuerpo tipoCuerpo, float densidad, float friccion, float restitucion)
    {
        setTipo(tipoCuerpo);
        this.elementos=elementos;
        setPropiedad(new PropiedadCuerpo(new PolygonShape(),densidad,friccion,restitucion));
        setMundo(Mundo.MUNDO);
        crearCuerpo();
    }

    @Override
    public void crearCuerpo()
    {
        setCuerpo(nuevoCuerpo(elementos.get(0)));
        setInfoCuerpo("CuerpoPoligono");
        for (Poligono p:elementos)
        {
            getPropiedad().setForma(crearForma(p));
            addPropiedad();
        }

    }

    private PolygonShape crearForma(Poligono p)
    {
        PolygonShape shape=new PolygonShape();
        shape.set(p.getVertices().redimensionar(100));
        return shape;
    }

}
