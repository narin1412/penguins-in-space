package no.ntnu.tdt4240.asteroids.entity.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.ntnu.tdt4240.asteroids.entity.component.DrawableComponent;
import no.ntnu.tdt4240.asteroids.entity.component.PositionComponent;

import static no.ntnu.tdt4240.asteroids.entity.util.ComponentMappers.drawableMapper;
import static no.ntnu.tdt4240.asteroids.entity.util.ComponentMappers.positionMapper;

public class RenderSystem extends IteratingSystem {

    private static final String TAG = RenderSystem.class.getSimpleName();
    private final OrthographicCamera camera;
    private SpriteBatch batch;

    public RenderSystem(OrthographicCamera camera) {
        super(Family.all(PositionComponent.class, DrawableComponent.class).get());
        this.camera = camera;
        batch = new SpriteBatch();
    }

    @Override
    public void update(float deltaTime) {
        camera.update();
        batch.begin();
        super.update(deltaTime);
        batch.setProjectionMatrix(camera.combined);
        batch.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = positionMapper.get(entity);
        DrawableComponent drawable = drawableMapper.get(entity);
        batch.draw(drawable.getRegion(), position.getX(), position.getY());
    }
}
