package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Application extends ApplicationAdapter {
	World world;
	 Box2DDebugRenderer b2dr;

	OrthographicCamera camera;
	private Body player,pp,dd;

	@Override
	public void create () {
   		float h = Gdx.graphics.getHeight();
   		float w = Gdx.graphics.getWidth();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w/2,  h/ 2);
		world = new World(new Vector2(0,-9.8f), false);
		b2dr = new Box2DDebugRenderer();
		player = createPlayer(); pp = createBack();dd = createdd2();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(Gdx.graphics.getDeltaTime());
		b2dr.render(world, camera.combined);
	}
	@Override
	public void resize( int width, int heigth)
	{

	}

	@Override
	public void dispose () {
		b2dr.dispose();
		world.dispose();
	}

	void update ( float delta)
	{
		world.step(1/30f , 9,2);
		camera.update();
	}
	public Body createPlayer()
	{
		Body pBody;
		BodyDef def = new BodyDef();
		def.type = BodyDef.BodyType.DynamicBody;
		def.position.set(75, 300);
		def.fixedRotation = false;
		pBody = world.createBody(def);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(32/2, 32/2);
		pBody. createFixture(shape,10f);

		return pBody;
	}

	public Body createdd2()
	{
		Body pBody;
		BodyDef dd = new BodyDef();
		dd.type = BodyDef.BodyType.DynamicBody;
		dd.position.set(89, 340);
		dd.fixedRotation = false;
		pBody = world.createBody(dd);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(32/2, 32/2);
		pBody. createFixture(shape,100f);

		return pBody;
	}


	public Body createBack()
	{
		Body pBody;
		BodyDef dd = new BodyDef();
		dd.type = BodyDef.BodyType.StaticBody;
		dd.position.set(89, 200);
		dd.fixedRotation = false;
		pBody = world.createBody(dd);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(50, 20);
		pBody. createFixture(shape,100f);

		return pBody;
	}


}

