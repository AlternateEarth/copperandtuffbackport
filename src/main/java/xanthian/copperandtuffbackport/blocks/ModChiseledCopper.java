package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.util.ModItemGroup;

import static net.minecraft.block.Blocks.*;

public class ModChiseledCopper {
    public static Block CHISELED_COPPER;
    private static Block EXPOSED_CHISELED_COPPER;
    private static Block OXIDIZED_CHISELED_COPPER;
    private static Block WEATHERED_CHISELED_COPPER;
    private static Block WAXED_CHISELED_COPPER;
    private static Block WAXED_EXPOSED_CHISELED_COPPER;
    private static Block WAXED_OXIDIZED_CHISELED_COPPER;
    private static Block WAXED_WEATHERED_CHISELED_COPPER;

    // Register all chiseled copper blocks and items.
    public static void register() {
        registerChiseled();
        registerExposedChiseled();
        registerWeatheredChiseled();
        registerOxidizedChiseled();
        registerWaxedChiseled();
        registerWaxedExposedChiseled();
        registerWaxedWeatheredChiseled();
        registerWaxedOxidizedChiseled();
    }

    // Register the chiseled copper blocks as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHISELED_COPPER, EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_CHISELED_COPPER, WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_CHISELED_COPPER, OXIDIZED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHISELED_COPPER, WAXED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_CHISELED_COPPER, WAXED_EXPOSED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_CHISELED_COPPER, WAXED_WEATHERED_CHISELED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_CHISELED_COPPER, WAXED_OXIDIZED_CHISELED_COPPER);
    }

    // Register the chiseled copper blocks in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(CHISELED_COPPER);
            content.add(EXPOSED_CHISELED_COPPER);
            content.add(WEATHERED_CHISELED_COPPER);
            content.add(OXIDIZED_CHISELED_COPPER);
            content.add(WAXED_CHISELED_COPPER);
            content.add(WAXED_EXPOSED_CHISELED_COPPER);
            content.add(WAXED_WEATHERED_CHISELED_COPPER);
            content.add(WAXED_OXIDIZED_CHISELED_COPPER);
        });
    }

    // Setup the block render layer map for the chiseled copper blocks, used by the
    // client init system.
    public static void setupBlockRenderLayerMap() {
        throw new UnsupportedOperationException(
                "Chiseled copper blocks do not support block render layer mapping, they have no transparent parts.");
    }

    private static void registerChiseled() {
        CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                FabricBlockSettings.copyOf(COPPER_BLOCK));
        registryRegister("chiseled_copper", CHISELED_COPPER);
    }

    private static void registerExposedChiseled() {
        EXPOSED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED,
                FabricBlockSettings.copyOf(COPPER_BLOCK));
        registryRegister("exposed_chiseled_copper", EXPOSED_CHISELED_COPPER);
    }

    private static void registerWeatheredChiseled() {
        WEATHERED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED,
                FabricBlockSettings.copyOf(COPPER_BLOCK));
        registryRegister("weathered_chiseled_copper", WEATHERED_CHISELED_COPPER);
    }

    private static void registerOxidizedChiseled() {
        OXIDIZED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED,
                FabricBlockSettings.copyOf(COPPER_BLOCK));
        registryRegister("oxidized_chiseled_copper", OXIDIZED_CHISELED_COPPER);
    }

    private static void registerWaxedChiseled() {
        WAXED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(CHISELED_COPPER));
        registryRegister("waxed_chiseled_copper", WAXED_CHISELED_COPPER);
    }

    private static void registerWaxedExposedChiseled() {
        WAXED_EXPOSED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(EXPOSED_CHISELED_COPPER));
        registryRegister("waxed_exposed_chiseled_copper", WAXED_EXPOSED_CHISELED_COPPER);
    }

    private static void registerWaxedWeatheredChiseled() {
        WAXED_WEATHERED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(WEATHERED_CHISELED_COPPER));
        registryRegister("waxed_weathered_chiseled_copper", WAXED_WEATHERED_CHISELED_COPPER);
    }

    private static void registerWaxedOxidizedChiseled() {
        WAXED_OXIDIZED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(OXIDIZED_CHISELED_COPPER));
        registryRegister("waxed_oxidized_chiseled_copper", WAXED_OXIDIZED_CHISELED_COPPER);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
