package com.framework;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.framework.Figuras.Grupo;
import com.framework.Figuras.Poligonos.Cuadrado;

public class Framework extends ApplicationAdapter
{
	final float PPM =100;
	private OrthographicCamera camara;
	private Box2DDebugRenderer camaraBordes;
	private boolean debug;
	PolygonSprite poly,seg;
	PolygonSpriteBatch polyBatch;
	Texture textureSolid;
	World mundo;
	Body algg;
	ShapeRenderer sss;
	Cuadrado cuadrado;
	Grupo grupo;
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
		Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
		pix.setColor(Color.BLUE); // DE is red, AD is green and BE is blue.
		pix.fill();
		textureSolid = new Texture(pix);
		pix.setColor(Color.RED); // DE is red, AD is green and BE is blue.
		pix.fill();
		PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
				b, new short[] {
				0, 1, 2,         // Two triangles using vertex indices.
				0, 2, 3          // Take care of the counter-clockwise direction.
		});
		sss=new ShapeRenderer();
		poly = new PolygonSprite(polyReg);
		poly.setOrigin(poly.getX(), poly.getY());
		polyBatch = new PolygonSpriteBatch();
		mundo=new World(new Vector2(0,-1f),true);
		algg=(createPhysicsObjectFromGraphics(a,new Vector2(poly.getX(),poly.getY()),BodyDef.BodyType.DynamicBody));
		createPhysicsObjectFromGraphics(c,new Vector2(0,0),BodyDef.BodyType.StaticBody);
		cuadrado=new Cuadrado(350,150,100,Colores.MORADO);
		grupo=new Grupo(new Cuadrado(300,400,100,Colores.AMARILLO),
				new Cuadrado(400,400,100,Colores.AZUL));
	}

	@Override
	public void render ()
	{
		mundo.step(Gdx.graphics.getDeltaTime(), 8, 3);
        Gdx.gl.glClearColor(120/255f, 40/255f, 150/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		//Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		polyBatch.begin();
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
		//poly.rotate(1.1f);
        camaraBordes.render(mundo,camara.combined);
        grupo.dibujar();
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