package com.framework.Figuras.Fisicas.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class CuerpoEstatico extends TipoCuerpo
{
    public CuerpoEstatico()
    {
        setTipo(BodyDef.BodyType.StaticBody);
    }
}
