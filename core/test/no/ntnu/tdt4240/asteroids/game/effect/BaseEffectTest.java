package no.ntnu.tdt4240.asteroids.game.effect;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;

import org.junit.Before;
import org.junit.Test;

import no.ntnu.tdt4240.asteroids.game.entity.EntityComponent;
import no.ntnu.tdt4240.asteroids.game.entity.component.DamageComponent;
import no.ntnu.tdt4240.asteroids.game.entity.component.EffectComponent;
import no.ntnu.tdt4240.asteroids.game.entity.component.HealthComponent;
import no.ntnu.tdt4240.asteroids.game.entity.util.EffectTextureFactory;
import no.ntnu.tdt4240.asteroids.service.AppComponent;
import no.ntnu.tdt4240.asteroids.service.AssetService;
import no.ntnu.tdt4240.asteroids.service.ServiceLocator;
import no.ntnu.tdt4240.asteroids.service.audio.AudioService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BaseEffectTest {

    private PooledEngine engine;
    private Entity entity;
    private BaseEffect fixture;
    private EffectComponent effectComponent;
    private AudioService audioService;

    @Before
    public void setup() {
        engine = mock(PooledEngine.class);
        when(engine.createComponent(HealthComponent.class)).thenReturn(new HealthComponent());
        when(engine.createComponent(DamageComponent.class)).thenReturn(new DamageComponent());
        ServiceLocator.appComponent = mock(AppComponent.class);
        audioService = mock(AudioService.class);
        when(ServiceLocator.getAppComponent().getAudioService()).thenReturn(audioService);
        ServiceLocator.entityComponent = mock(EntityComponent.class);
        when(ServiceLocator.getEntityComponent().getEffectTextureFactory()).thenReturn(mock(EffectTextureFactory.class));
        entity = mock(Entity.class);
        fixture = spy(BaseEffect.class);
        effectComponent = mock(EffectComponent.class);
        when(fixture.getDuration()).thenReturn(5f);
    }

    @Test
    public void tick_validEffect_shouldApply() {
        fixture.tick(engine, entity, effectComponent, 1);
        verify(fixture).applyEffect(engine, entity, effectComponent);
    }

    @Test
    public void tick_validEffect_shouldRemove() {
        fixture.tick(engine, entity, effectComponent, 1);
        fixture.tick(engine, entity, effectComponent, 10);
        fixture.tick(engine, entity, effectComponent, 1);

        verify(fixture).removeEffect(any(PooledEngine.class), any(Entity.class), any(EffectComponent.class));
    }

    @Test
    public void tick_validEffect_shouldPlaySound() {
        fixture.tick(engine, entity, effectComponent, 1);
        verify(audioService).playSound(AssetService.SoundAsset.SOUND_POWERUP_WAV);
    }

}
