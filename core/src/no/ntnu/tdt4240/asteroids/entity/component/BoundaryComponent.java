package no.ntnu.tdt4240.asteroids.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class BoundaryComponent implements Component, Pool.Poolable {

    public static final int MODE_BOUND = 0;
    public static final int MODE_FREE = 1;

    public int boundaryMode;

    @SuppressWarnings("unused")
    public BoundaryComponent() {
    }

    public BoundaryComponent(int boundaryMode) {
        this.boundaryMode = boundaryMode;
    }

    @Override
    public void reset() {
        boundaryMode = MODE_BOUND;
    }
}