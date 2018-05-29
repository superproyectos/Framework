package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.CircleShape;
import com.framework.Figuras.Circulos.Circulo;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;

/**Crea un cuerpo circular*/

public class CuerpoCircular extends Cuerpo
{

    private Circulo circulo;
    public CuerpoCircular(Circulo circulo, TipoCuerpo tipoCuerpo)
    {
        this.circulo=circulo;
        setTipo(tipoCuerpo);
        crearCuerpo();
    }
    private CircleShape crearForma()
    {
        CircleShape shape=new CircleShape();
        shape.setRadius(circulo.getRadio());
        return shape;
    }
    @Override
    public void crearCuerpo()
    {
        setCuerpo(nuevoCuerpo(circulo));
        setInfoCuerpo("Circulo");
        getPropiedad().setForma(crearForma());
        addPropiedad();
    }
}
