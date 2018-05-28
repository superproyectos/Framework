package com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class CuerpoEstatico extends TipoCuerpo
{
    public CuerpoEstatico()
    {
        super(BodyDef.BodyType.StaticBody);
    }
}
