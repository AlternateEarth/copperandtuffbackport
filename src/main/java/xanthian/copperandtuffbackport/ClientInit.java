package xanthian.copperandtuffbackport;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import xanthian.copperandtuffbackport.blocks.*;
import xanthian.copperandtuffbackport.particles.ModParticles;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.COPPER_FLAME, FlameParticle.Factory::new);

        ModCopperDoor.setupBlockRenderLayerMap();
        ModCopperTrapDoor.setupBlockRenderLayerMap();
        ModCopperGrate.setupBlockRenderLayerMap();
        ModCopperLantern.setupBlockRenderLayerMap();
        ModCopperTorch.setupBlockRenderLayerMap();
    }
}
