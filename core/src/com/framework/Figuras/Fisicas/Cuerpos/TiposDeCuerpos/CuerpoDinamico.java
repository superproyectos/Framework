package com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class CuerpoDinamico extends TipoCuerpo
{
    public CuerpoDinamico()
    {
        setTipo(BodyDef.BodyType.DynamicBody);
    }
}
