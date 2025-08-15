package xanthian.copperandtuffbackport.util;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import xanthian.copperandtuffbackport.blocks.ModCopperBlocks;
import xanthian.copperandtuffbackport.blocks.ModCopperBulb;
import xanthian.copperandtuffbackport.blocks.ModCopperDoor;
import xanthian.copperandtuffbackport.blocks.ModCopperGrate;
import xanthian.copperandtuffbackport.blocks.ModCopperTrapDoor;

public class ModRegistries {

        public static void registerOxidizableBlocks() {
                registerOxidizable();
        }

        private static void registerOxidizable() {

                ModCopperDoor.registerOxidizable();
                ModCopperTrapDoor.registerOxidizable();
                ModCopperGrate.registerOxidizable();
                ModCopperBulb.registerOxidizable();

                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.CHISELED_COPPER,
                                ModCopperBlocks.EXPOSED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_CHISELED_COPPER,
                                ModCopperBlocks.WEATHERED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_CHISELED_COPPER,
                                ModCopperBlocks.OXIDIZED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.CHISELED_COPPER,
                                ModCopperBlocks.WAXED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_CHISELED_COPPER,
                                ModCopperBlocks.WAXED_EXPOSED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_CHISELED_COPPER,
                                ModCopperBlocks.WAXED_WEATHERED_CHISELED_COPPER);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_CHISELED_COPPER,
                                ModCopperBlocks.WAXED_OXIDIZED_CHISELED_COPPER);

                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_LANTERN,
                                ModCopperBlocks.EXPOSED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_LANTERN,
                                ModCopperBlocks.WEATHERED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_LANTERN,
                                ModCopperBlocks.OXIDIZED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_LANTERN,
                                ModCopperBlocks.WAXED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_LANTERN,
                                ModCopperBlocks.WAXED_EXPOSED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_LANTERN,
                                ModCopperBlocks.WAXED_WEATHERED_COPPER_LANTERN);
                OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_LANTERN,
                                ModCopperBlocks.WAXED_OXIDIZED_COPPER_LANTERN);
        }
}
