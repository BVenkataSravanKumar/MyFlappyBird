package com.myflappygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Myflappygame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background, tubeTop, tubeBottom;
    Texture birds[];
    int flapState = 0;
    boolean gameState = false;
    float gravity = 1.5f;
    float velocity = 0;
    float birdY = 0;
    float gap = 400; // Gap between top and bottom tubes
    float maxTubeOffset;
    float tubeVelocity = 4;
    int numberOfTubes = 4;
    float tubeX[] = new float[numberOfTubes];
    float tubeOffset[] = new float[numberOfTubes];
    float distanceBetweenTubes;

    int score = 0;
    int scoringTube = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        tubeTop = new Texture("toptube.png");
        tubeBottom = new Texture("bottomtube.png");
        birds = new Texture[2];
        birds[0] = new Texture("bird.png");
        birds[1] = new Texture("bird2.png");
        birdY = Gdx.graphics.getHeight() / 2f - birds[flapState].getHeight() / 2f;

        maxTubeOffset = Gdx.graphics.getHeight() / 2 - gap / 2 - 100;
        distanceBetweenTubes = Gdx.graphics.getWidth() * 3 / 4;

        for (int i = 0; i < numberOfTubes; i++) {
            tubeX[i] = Gdx.graphics.getWidth() / 2 - tubeTop.getWidth() / 2 + i * distanceBetweenTubes;
            tubeOffset[i] = (float) (Math.random() * (2 * maxTubeOffset) - maxTubeOffset);
        }
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (Gdx.input.justTouched()) {
            gameState = true;
            velocity = -30;
        }

        if (gameState) {
            for (int i = 0; i < numberOfTubes; i++) {
                if (tubeX[i] < -tubeTop.getWidth()) {
                    tubeX[i] += numberOfTubes * distanceBetweenTubes;
                    tubeOffset[i] = (float) (Math.random() * (2 * maxTubeOffset) - maxTubeOffset);
                } else {
                    tubeX[i] -= tubeVelocity;

                    // Increment score when the bird passes a tube
                    if (tubeX[i] < Gdx.graphics.getWidth() / 2 - tubeTop.getWidth() / 2) {
                        score++;
                        if (scoringTube < numberOfTubes - 1)
                            scoringTube++;
                        else
                            scoringTube = 0;
                    }
                }

                batch.draw(tubeTop, tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i]);
                batch.draw(tubeBottom, tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - tubeBottom.getHeight() + tubeOffset[i]);

                // Check for collision with tubes
                if (Gdx.graphics.getWidth() / 2f - birds[flapState].getWidth() / 2f < tubeX[i] + tubeTop.getWidth()
                        && Gdx.graphics.getWidth() / 2f - birds[flapState].getWidth() / 2f + birds[flapState].getWidth() > tubeX[i]
                        && (birdY < Gdx.graphics.getHeight() / 2f + gap / 2 + tubeOffset[i] || birdY + birds[flapState].getHeight() > Gdx.graphics.getHeight() / 2f - gap / 2 - tubeBottom.getHeight() + tubeOffset[i])) {
                    // Collision detected, set gameState to false
                    gameState = false;
                }
            }

            if (flapState == 0) {
                flapState = 1;
            } else {
                flapState = 0;
            }

            if (birdY > 0 || velocity < 0) {
                velocity = velocity + gravity;
                birdY = birdY - velocity;
            }
        }

        batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2f - birds[flapState].getWidth() / 2f, birdY);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        tubeTop.dispose();
        tubeBottom.dispose();
    }
}
