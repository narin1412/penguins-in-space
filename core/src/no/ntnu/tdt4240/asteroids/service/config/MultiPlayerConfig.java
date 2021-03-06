package no.ntnu.tdt4240.asteroids.service.config;

@SuppressWarnings("FieldCanBeLocal")
public class MultiPlayerConfig implements IGameConfig {

    private static double obstacleSpawnChance = 0.0;
    private static int maxObstacles = 0;
    private static int minObstacles = 0;
    private static double powerupSpawnChance = 0.2;
    private static float playerGravity = 0.01f;
    private static int obstacleMaxSpeed = 200;
    private static float accelerationScalar = 500;
    private static int playerNoSpawnRadius = 50;

    public double getObstacleSpawnChance() {
        return obstacleSpawnChance;
    }

    public int getMaxObstacles() {
        return maxObstacles;
    }

    public int getMinObstacles() {
        return minObstacles;
    }

    public double getPowerupSpawnChance() {
        return powerupSpawnChance;
    }

    public float getPlayerGravity() {
        return playerGravity;
    }

    public int getObstacleMaxSpeed() {
        return obstacleMaxSpeed;
    }

    public float getAccelerationScalar() {
        return accelerationScalar;
    }

    public int getPlayerNoSpawnRadius() {
        return playerNoSpawnRadius;
    }

    @Override
    public float getBombDelay() {
        return 2;
    }

    @Override
    public float getMissileDelay() {
        return 3;
    }
}
