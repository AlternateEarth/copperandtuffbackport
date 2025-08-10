package xanthian.copperandtuffbackport.blocks;

import static net.minecraft.block.Blocks.register;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.item.Item;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;

public class ModCopperTorch {

    public static final DefaultParticleType COPPER_FIRE_FLAME_PARTICLE = FabricParticleTypes.simple();

    public static final Block COPPER_TORCH = new TorchBlock(Block.Settings.copy(Blocks.TORCH), COPPER_FIRE_FLAME_PARTICLE);
    public static final Block COPPER_WALL_TORCH = new WallTorchBlock(Block.Settings.copy(Blocks.WALL_TORCH).dropsLike(COPPER_TORCH), COPPER_FIRE_FLAME_PARTICLE);
    //public static final Item COPPER_TORCH_ITEM = new StandingAndWallBlockItem(COPPER_TORCH, COPPER_WALL_TORCH, new Item.Properties().fireResistant(), Direction.DOWN );

    public static void registerTorch() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Initialise.MOD_ID, "copper_fire_flame_particle"), COPPER_FIRE_FLAME_PARTICLE);

        register("copper_torch", COPPER_TORCH);
        register("copper_wall_torch", COPPER_WALL_TORCH);
    }
}
