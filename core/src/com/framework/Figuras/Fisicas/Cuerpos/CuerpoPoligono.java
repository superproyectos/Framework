package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.framework.Camara;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;

/**Crea un cuerpo de polígonos*/

public class CuerpoPoligono extends Cuerpo
{

    /**Polígonos regulares pertenecientes al grupo*/

    private Array<Poligono> elementos;


    /**Crea un cuerpo que englobe a un grupo*/

    public CuerpoPoligono(Poligono elemento,TipoCuerpo tipoCuerpo)
    {
        this.elementos=new Array<Poligono>();
        elementos.add(elemento);
        setTipo(tipoCuerpo);
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

    /**Crea una forma física idéntica a la del polígono actual*/

    private PolygonShape crearForma(Poligono p)
    {
        PolygonShape shape=new PolygonShape();
        shape.set(p.getVertices().redimensionar(Camara.getPPM()));
        return shape;
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



}
