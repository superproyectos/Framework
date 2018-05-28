package com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class CuerpoKinematico extends TipoCuerpo
{
    public CuerpoKinematico()
    {
        super(BodyDef.BodyType.KinematicBody);
    }
}
