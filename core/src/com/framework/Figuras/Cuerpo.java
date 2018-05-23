package com.framework.Figuras;

import com.badlogic.gdx.utils.Array;
import com.framework.Figuras.Poligonos.Poligono;

public class Cuerpo
{

    public Cuerpo(Array<Poligono> elementos)
    {

    }

    /*public Body crearCuerpo(Vertices v, Vector2 position, BodyDef.BodyType bodyType)
    {
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = bodyType;
        boxBodyDef.position.x = position.x/PPM;
        boxBodyDef.position.y = position.y/PPM;
        Body boxBody = mundo.createBody(boxBodyDef);
        PolygonShape boxPoly = new PolygonShape();
        boxPoly.set(a);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = boxPoly;
        fixtureDef.density=1;
        fixtureDef.restitution=0.2f;
        boxBody.createFixture(fixtureDef);

        boxPoly.dispose();
        boxBody.setUserData("as");
        return boxBody;
    }*/
}
