package com.framework.Figuras.Fisicas.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class CuerpoKinematico extends TipoCuerpo
{
    public CuerpoKinematico()
    {
        setTipo(BodyDef.BodyType.KinematicBody);
    }
}
