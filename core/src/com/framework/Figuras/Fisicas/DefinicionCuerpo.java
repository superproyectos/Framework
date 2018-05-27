package com.framework.Figuras.Fisicas;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.framework.Figuras.Poligonos.Poligono;
import com.framework.Figuras.Fisicas.TiposDeCuerpos.TipoCuerpo;

public class DefinicionCuerpo
{
    private BodyDef definicion;
    public DefinicionCuerpo(float x,float y,TipoCuerpo tipo)
    {
        definicion=new BodyDef();
        definicion.type=tipo.getTipo();
        definicion.position.set(x,y);
    }
    public DefinicionCuerpo(Poligono p, TipoCuerpo tipo)
    {
        definicion=new BodyDef();
        definicion.type=tipo.getTipo();
        definicion.position.set(p.getPoligono().getX(),p.getPoligono().getY());
    }

    public BodyDef getDefinicion()
    {
        return definicion;
    }
}
