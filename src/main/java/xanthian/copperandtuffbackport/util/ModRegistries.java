package xanthian.copperandtuffbackport.util;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import xanthian.copperandtuffbackport.blocks.ModCopperBlocks;

public class ModRegistries {

    public static void registerOxidizableBlocks() {
        registerOxidizable();

    }

    private static void registerOxidizable() {

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_DOOR, ModCopperBlocks.EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_DOOR, ModCopperBlocks.WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_DOOR, ModCopperBlocks.OXIDIZED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_DOOR, ModCopperBlocks.WAXED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_DOOR, ModCopperBlocks.WAXED_EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_DOOR, ModCopperBlocks.WAXED_WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_DOOR, ModCopperBlocks.WAXED_OXIDIZED_COPPER_DOOR);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_TRAPDOOR, ModCopperBlocks.EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_TRAPDOOR, ModCopperBlocks.WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_TRAPDOOR, ModCopperBlocks.OXIDIZED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_TRAPDOOR, ModCopperBlocks.WAXED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_TRAPDOOR, ModCopperBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_TRAPDOOR, ModCopperBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_TRAPDOOR, ModCopperBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_GRATE, ModCopperBlocks.EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_GRATE, ModCopperBlocks.WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_GRATE, ModCopperBlocks.OXIDIZED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_GRATE, ModCopperBlocks.WAXED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_GRATE, ModCopperBlocks.WAXED_EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_GRATE, ModCopperBlocks.WAXED_WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_GRATE, ModCopperBlocks.WAXED_OXIDIZED_COPPER_GRATE);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_BULB, ModCopperBlocks.EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_BULB, ModCopperBlocks.WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_BULB, ModCopperBlocks.OXIDIZED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_BULB, ModCopperBlocks.WAXED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_BULB, ModCopperBlocks.WAXED_EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_BULB, ModCopperBlocks.WAXED_WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_BULB, ModCopperBlocks.WAXED_OXIDIZED_COPPER_BULB);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.CHISELED_COPPER, ModCopperBlocks.EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_CHISELED_COPPER, ModCopperBlocks.WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_CHISELED_COPPER, ModCopperBlocks.OXIDIZED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.CHISELED_COPPER, ModCopperBlocks.WAXED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_CHISELED_COPPER, ModCopperBlocks.WAXED_EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_CHISELED_COPPER, ModCopperBlocks.WAXED_WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_CHISELED_COPPER, ModCopperBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_LANTERN, ModCopperBlocks.EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_LANTERN, ModCopperBlocks.WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_LANTERN, ModCopperBlocks.OXIDIZED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_LANTERN, ModCopperBlocks.WAXED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_LANTERN, ModCopperBlocks.WAXED_EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_LANTERN, ModCopperBlocks.WAXED_WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_LANTERN, ModCopperBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
    }
}
