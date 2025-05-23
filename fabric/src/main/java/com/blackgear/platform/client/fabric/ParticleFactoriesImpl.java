package com.blackgear.platform.client.fabric;

import com.blackgear.platform.client.ParticleFactories;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.util.function.Supplier;

public class ParticleFactoriesImpl {
    public static <T extends ParticleOptions, P extends ParticleType<T>> void create(Supplier<P> type, ParticleProvider<T> provider) {
        ParticleFactoryRegistry.getInstance().register(type.get(), provider);
    }

    public static <T extends ParticleOptions, P extends ParticleType<T>> void create(Supplier<P> type, ParticleFactories.Factory<T> factory) {
        ParticleFactoryRegistry.getInstance().register(type.get(), factory::create);
    }
}