package com.myflappygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Myflappygame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background,tubeTop,tubeBottom;
	Texture birds[];
	int flapState = 0;
	boolean gameState=false;
	float gravity = 1.5f;
	float velocity = 0;
	float birdY = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		tubeTop = new Texture("toptube.png");
		tubeBottom = new Texture("bottomtube.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2f - birds[flapState].getHeight()/2f;
	}



	@Override
	public void render () {
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if(Gdx.input.justTouched()){
			gameState = true;
			velocity = -30;
		}

		if(gameState){

			if( flapState == 0 ){ flapState = 1; }
			else { flapState = 0; }

			if( birdY > 0 || velocity < 0 ){
				velocity = velocity + gravity;
				birdY = birdY - velocity;
			}


		}


		batch.draw(tubeBottom,Gdx.graphics.getWidth()/2f - tubeBottom.getWidth()/2f,-Gdx.graphics.getHeight()/2f);
		batch.draw(tubeTop,Gdx.graphics.getWidth()/2f - tubeTop.getWidth()/2f,Gdx.graphics.getHeight()*3/4f);

		batch.draw(birds[flapState], Gdx.graphics.getWidth() /2f - birds[flapState].getWidth()/2f,birdY);
		batch.end();
          }
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}