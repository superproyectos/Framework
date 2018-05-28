package com.framework.Figuras.Fisicas.Cuerpos.Colisiones;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public abstract class Contacto implements ContactListener
{
    @Override
    public void beginContact(Contact contact)
    {
        System.out.println("Contacto");
    }

    @Override
    public void endContact(Contact contact)
    {
        System.out.println("Fin Contacto");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold)
    {
        System.out.println("PRE");
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse)
    {
        System.out.println("POST");
    }
}
