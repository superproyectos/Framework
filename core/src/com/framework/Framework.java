package com.framework;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.framework.Figuras.Circulos.Circulo;
import com.framework.Figuras.Circulos.CirculoFisico;
import com.framework.Figuras.Fisicas.Cuerpos.Colisiones.Contacto;
import com.framework.Figuras.Fisicas.Cuerpos.TiposDeCuerpos.CuerpoEstatico;
import com.framework.Figuras.Fisicas.Mundo;
import com.framework.Figuras.Grupos.Grupo;
import com.framework.Figuras.Grupos.GrupoFisico;
import com.framework.Figuras.Poligonos.Cuadrado;
import com.framework.Figuras.Poligonos.Heptagono;
import com.framework.Figuras.Poligonos.Hexagono;
import com.framework.Figuras.Poligonos.Pentagono;
import com.framework.Texturas.Colores;

public class Framework extends ApplicationAdapter
{
	final float PPM =100;
	private OrthographicCamera camara;
	private Box2DDebugRenderer camaraBordes;
	private boolean debug;
	PolygonSprite poly,seg;
	PolygonSpriteBatch polyBatch;
	Texture textureSolid;
	public static World mundo;
	Body algg;
	ShapeRenderer sss;
	Cuadrado cuadrado;
	Grupo grupo;
	Circulo cir;
	float a[]={2,2,3,2, 3, 1, 2, 1,3,1,4,1,4,2,3,2};

	float b[]={200, 200,300, 200, 300, 100, 200, 100};
	float c[]={0, 0,2.2f, 0,0, 0.5f, 2.2f, 0.5f};
	@Override
	public void create ()
	{
		camara=new OrthographicCamera();
		camara.setToOrtho(false,Gdx.graphics.getWidth()/PPM,Gdx.graphics.getHeight()/PPM);
		camara.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);
		camaraBordes=new Box2DDebugRenderer();
		mundo= Mundo.MUNDO;

		mundo.setGravity(new Vector2(0,-5));
		createPhysicsObjectFromGraphics(c,new Vector2(0,0),BodyDef.BodyType.StaticBody);
		cuadrado=new Cuadrado(350,150,100,Colores.MORADO);
		grupo=new GrupoFisico(
		        new Cuadrado(250,400,100,Colores.AMARILLO),
				new Pentagono(350,400,50,Colores.AZUL),
		        new Hexagono(250,300,50,Colores.NARANJA),
                new Heptagono(150,400,50,Colores.TURQUESA));

		((GrupoFisico) grupo).setDensidad(1);
		((GrupoFisico) grupo).setRebote(1);
		cir=new CirculoFisico(100,450,30);
		((CirculoFisico) cir).setDensidad(15);
	}

	@Override
	public void render ()
	{
		mundo.step(Gdx.graphics.getDeltaTime(), 8, 3);
        Gdx.gl.glClearColor(120/255f, 40/255f, 150/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		//Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		/*polyBatch.begin();
		poly.draw(polyBatch);
		polyBatch.end();
		//poly.setOrigin(poly.getX(),poly.getY());
		poly.setRotation((float)Math.toDegrees(algg.getAngle()));
		poly.setPosition(algg.getPosition().x*PPM,algg.getPosition().y*PPM);
		sss.begin(ShapeRenderer.ShapeType.Filled);
			sss.circle(poly.getOriginX(),poly.getOriginY(),5);
		sss.end();
		cuadrado.setRotacion((float)Math.toDegrees(algg.getAngle()));
	cuadrado.setPosicion(algg.getPosition().x*PPM,algg.getPosition().y*PPM);
		cuadrado.dibujar();
		//poly.rotate(1.1f);*/
        camaraBordes.render(mundo,camara.combined);
        grupo.dibujar();
        cir.dibujar();
	}
	private Body createPhysicsObjectFromGraphics(float a[], Vector2 position, BodyDef.BodyType bodyType)
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
	}
	@Override
	public void dispose () {

	}
}
