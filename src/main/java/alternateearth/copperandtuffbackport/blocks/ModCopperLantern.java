package alternateearth.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.blocks.custom.OxidizableLanternBlock;
import alternateearth.copperandtuffbackport.util.ModItemGroup;

import static net.minecraft.block.Blocks.*;

public class ModCopperLantern {

    private static Block COPPER_LANTERN;
    private static Block EXPOSED_COPPER_LANTERN;
    private static Block WEATHERED_COPPER_LANTERN;
    private static Block OXIDIZED_COPPER_LANTERN;
    private static Block WAXED_COPPER_LANTERN;
    private static Block WAXED_EXPOSED_COPPER_LANTERN;
    private static Block WAXED_WEATHERED_COPPER_LANTERN;
    private static Block WAXED_OXIDIZED_COPPER_LANTERN;

    // Register all copper lantern blocks and items.
    public static void register() {
        registerLantern();
        registerExposedLantern();
        registerWeatheredLantern();
        registerOxidizedLantern();
        registerWaxedLantern();
        registerWaxedExposedLantern();
        registerWaxedWeatheredLantern();
        registerWaxedOxidizedLantern();
    }

    // Register the copper lanterns as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_LANTERN, EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_LANTERN, OXIDIZED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_LANTERN, WAXED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_LANTERN, WAXED_EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_LANTERN, WAXED_WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_LANTERN, WAXED_OXIDIZED_COPPER_LANTERN);
    }

    // Register the copper lanterns in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_LANTERN);
            content.add(EXPOSED_COPPER_LANTERN);
            content.add(WEATHERED_COPPER_LANTERN);
            content.add(OXIDIZED_COPPER_LANTERN);
            content.add(WAXED_COPPER_LANTERN);
            content.add(WAXED_EXPOSED_COPPER_LANTERN);
            content.add(WAXED_WEATHERED_COPPER_LANTERN);
            content.add(WAXED_OXIDIZED_COPPER_LANTERN);
        });
    }

    // Setup the block render layer map for the copper lanterns, used by the client
    // init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EXPOSED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WEATHERED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OXIDIZED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_EXPOSED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_WEATHERED_COPPER_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_OXIDIZED_COPPER_LANTERN, RenderLayer.getCutout());
    }

    private static void registerLantern() {
        COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED,
                FabricBlockSettings.copy(LANTERN));
        registryRegister("copper_lantern", COPPER_LANTERN);
    }

    private static void registerExposedLantern() {
        EXPOSED_COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED,
                FabricBlockSettings.copy(COPPER_LANTERN));
        registryRegister("exposed_copper_lantern", EXPOSED_COPPER_LANTERN);
    }

    private static void registerWeatheredLantern() {
        WEATHERED_COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED,
                FabricBlockSettings.copy(COPPER_LANTERN));
        registryRegister("weathered_copper_lantern", WEATHERED_COPPER_LANTERN);
    }

    private static void registerOxidizedLantern() {
        OXIDIZED_COPPER_LANTERN = new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED,
                FabricBlockSettings.copy(COPPER_LANTERN));
        registryRegister("oxidized_copper_lantern", OXIDIZED_COPPER_LANTERN);
    }

    private static void registerWaxedLantern() {
        WAXED_COPPER_LANTERN = new LanternBlock(FabricBlockSettings.copy(COPPER_LANTERN));
        registryRegister("waxed_copper_lantern", WAXED_COPPER_LANTERN);
    }

    private static void registerWaxedExposedLantern() {
        WAXED_EXPOSED_COPPER_LANTERN = new LanternBlock(FabricBlockSettings.copy(EXPOSED_COPPER_LANTERN));
        registryRegister("waxed_exposed_copper_lantern", WAXED_EXPOSED_COPPER_LANTERN);
    }

    private static void registerWaxedWeatheredLantern() {
        WAXED_WEATHERED_COPPER_LANTERN = new LanternBlock(FabricBlockSettings.copy(WEATHERED_COPPER_LANTERN));
        registryRegister("waxed_weathered_copper_lantern", WAXED_WEATHERED_COPPER_LANTERN);
    }

    private static void registerWaxedOxidizedLantern() {
        WAXED_OXIDIZED_COPPER_LANTERN = new LanternBlock(FabricBlockSettings.copy(OXIDIZED_COPPER_LANTERN));
        registryRegister("waxed_oxidized_copper_lantern", WAXED_OXIDIZED_COPPER_LANTERN);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
