package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.*;
import xanthian.copperandtuffbackport.particles.ModParticles;

import static net.minecraft.block.Blocks.*;

public class ModCopperBlocks {

        private static final int COPPER_TORCH_LIGHT_LEVEL = 12;

        public static final Block CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                        FabricBlockSettings.copyOf(COPPER_BLOCK));
        public static final Block EXPOSED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED,
                        FabricBlockSettings.copyOf(EXPOSED_COPPER));
        public static final Block OXIDIZED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED,
                        FabricBlockSettings.copyOf(OXIDIZED_COPPER));
        public static final Block WEATHERED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED,
                        FabricBlockSettings.copyOf(WEATHERED_COPPER));
        public static final Block WAXED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(CHISELED_COPPER));
        public static final Block WAXED_EXPOSED_CHISELED_COPPER = new Block(
                        FabricBlockSettings.copyOf(EXPOSED_CHISELED_COPPER));
        public static final Block WAXED_OXIDIZED_CHISELED_COPPER = new Block(
                        FabricBlockSettings.copyOf(OXIDIZED_CHISELED_COPPER));
        public static final Block WAXED_WEATHERED_CHISELED_COPPER = new Block(
                        FabricBlockSettings.copyOf(WEATHERED_CHISELED_COPPER));

        public static final Block COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                        FabricBlockSettings.copy(LANTERN));
        public static final Block WAXED_COPPER_LANTERN = new LanternBlock(FabricBlockSettings.copy(COPPER_LANTERN));
        public static final Block EXPOSED_COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED,
                        FabricBlockSettings.copy(COPPER_LANTERN));
        public static final Block WAXED_EXPOSED_COPPER_LANTERN = new LanternBlock(
                        FabricBlockSettings.copy(EXPOSED_COPPER_LANTERN));
        public static final Block WEATHERED_COPPER_LANTERN = new OxidizableLanternBlock(
                        Oxidizable.OxidationLevel.WEATHERED,
                        FabricBlockSettings.copy(COPPER_LANTERN));
        public static final Block WAXED_WEATHERED_COPPER_LANTERN = new LanternBlock(
                        FabricBlockSettings.copy(WEATHERED_COPPER_LANTERN));
        public static final Block OXIDIZED_COPPER_LANTERN = new OxidizableLanternBlock(
                        Oxidizable.OxidationLevel.OXIDIZED,
                        FabricBlockSettings.copy(COPPER_LANTERN));
        public static final Block WAXED_OXIDIZED_COPPER_LANTERN = new LanternBlock(
                        FabricBlockSettings.copy(OXIDIZED_COPPER_LANTERN));

        public static final Block COPPER_TORCH = new TorchBlock(
                        Block.Settings
                                        .create()
                                        .noCollision()
                                        .breakInstantly()
                                        .luminance(state -> COPPER_TORCH_LIGHT_LEVEL)
                                        .sounds(BlockSoundGroup.WOOD)
                                        .pistonBehavior(PistonBehavior.DESTROY),
                        ModParticles.COPPER_FLAME);
        public static final Block COPPER_WALL_TORCH = new WallTorchBlock(
                        FabricBlockSettings.copyOf(COPPER_TORCH).dropsLike(COPPER_TORCH), ModParticles.COPPER_FLAME);

        public static void registerBlocks() {

                ModCopperDoor.register();
                ModCopperTrapDoor.register();
                ModCopperGrate.register();
                ModCopperBulb.register();

                register("chiseled_copper", CHISELED_COPPER);
                register("exposed_chiseled_copper", EXPOSED_CHISELED_COPPER);
                register("oxidized_chiseled_copper", OXIDIZED_CHISELED_COPPER);
                register("weathered_chiseled_copper", WEATHERED_CHISELED_COPPER);
                register("waxed_chiseled_copper", WAXED_CHISELED_COPPER);
                register("waxed_exposed_chiseled_copper", WAXED_EXPOSED_CHISELED_COPPER);
                register("waxed_oxidized_chiseled_copper", WAXED_OXIDIZED_CHISELED_COPPER);
                register("waxed_weathered_chiseled_copper", WAXED_WEATHERED_CHISELED_COPPER);

                register("copper_lantern", COPPER_LANTERN);
                register("exposed_copper_lantern", EXPOSED_COPPER_LANTERN);
                register("oxidized_copper_lantern", OXIDIZED_COPPER_LANTERN);
                register("weathered_copper_lantern", WEATHERED_COPPER_LANTERN);
                register("waxed_copper_lantern", WAXED_COPPER_LANTERN);
                register("waxed_exposed_copper_lantern", WAXED_EXPOSED_COPPER_LANTERN);
                register("waxed_oxidized_copper_lantern", WAXED_OXIDIZED_COPPER_LANTERN);
                register("waxed_weathered_copper_lantern", WAXED_WEATHERED_COPPER_LANTERN);

                registerBlockOnly("copper_torch", COPPER_TORCH);
                registerBlockOnly("copper_wall_torch", COPPER_WALL_TORCH);
        }

        private static void registerBlockOnly(String name, Block block) {
                Identifier identifier = new Identifier(Initialise.MOD_ID, name);
                Registry.register(Registries.BLOCK, identifier, block);
        }

        private static void register(String name, Block block) {
                Identifier identifier = new Identifier(Initialise.MOD_ID, name);
                Registry.register(Registries.BLOCK, identifier, block);
                Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        }
}