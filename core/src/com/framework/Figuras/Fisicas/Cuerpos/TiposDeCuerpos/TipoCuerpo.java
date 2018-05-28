package com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public abstract class TipoCuerpo
{
    private BodyDef.BodyType tipo;
    public TipoCuerpo(BodyDef.BodyType tipo)
    {
        this.tipo = tipo;
    }
    public BodyDef.BodyType getTipo()
    {
        return tipo;
    }

}
