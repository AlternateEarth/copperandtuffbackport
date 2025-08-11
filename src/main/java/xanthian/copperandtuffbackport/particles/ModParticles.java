package xanthian.copperandtuffbackport.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;

public class ModParticles {
    public static final DefaultParticleType COPPER_FLAME = Registry.register(
            Registries.PARTICLE_TYPE,
            new Identifier(Initialise.MOD_ID, "copper_flame"),
            FabricParticleTypes.simple()
    );

    public static void init() {}
}
