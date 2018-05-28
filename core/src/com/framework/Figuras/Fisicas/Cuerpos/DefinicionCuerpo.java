package com.framework.Figuras.Fisicas.Cuerpos;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.framework.Figuras.Figura;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.TipoCuerpo;

public class DefinicionCuerpo
{
    private BodyDef definicion;
    public DefinicionCuerpo(float x,float y,TipoCuerpo tipo)
    {
        definicion=new BodyDef();
        definicion.type=tipo.getTipo();
        definicion.position.set(x,y);
    }
    public DefinicionCuerpo(Figura figura, TipoCuerpo tipo)
    {
        definicion=new BodyDef();
        definicion.type=tipo.getTipo();
        definicion.position.set(figura.getPosicionRelativa());
    }

    public BodyDef getDefinicion()
    {
        return definicion;
    }
}
