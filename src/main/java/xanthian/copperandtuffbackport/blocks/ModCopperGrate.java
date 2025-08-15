package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Oxidizable;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.GrateBlock;
import xanthian.copperandtuffbackport.blocks.custom.OxidizableGrateBlock;
import xanthian.copperandtuffbackport.util.ModItemGroup;
import xanthian.copperandtuffbackport.util.ModSounds;

public class ModCopperGrate {

    private static final FabricBlockSettings COPPER_BLOCK_SETTINGS = FabricBlockSettings.create()
            .strength(3.0F, 6.0F)
            .sounds(ModSounds.COPPER_GRATE)
            .mapColor(MapColor.ORANGE)
            .nonOpaque()
            .requiresTool()
            .allowsSpawning(Blocks::never)
            .solidBlock(Blocks::never)
            .suffocates(Blocks::never)
            .blockVision(Blocks::never);

    private static Block COPPER_GRATE;
    private static Block EXPOSED_COPPER_GRATE;
    private static Block WEATHERED_COPPER_GRATE;
    private static Block OXIDIZED_COPPER_GRATE;
    private static Block WAXED_COPPER_GRATE;
    private static Block WAXED_EXPOSED_COPPER_GRATE;
    private static Block WAXED_WEATHERED_COPPER_GRATE;
    private static Block WAXED_OXIDIZED_COPPER_GRATE;

    // Register all copper grate blocks and items.
    public static void register() {
        registerGrate();
        registerExposedGrate();
        registerWeatheredGrate();
        registerOxidizedGrate();
        registerWaxedGrate();
        registerWaxedExposedGrate();
        registerWaxedWeatheredGrate();
        registerWaxedOxidizedGrate();
    }

    // Register the copper grates as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_GRATE, EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_GRATE, WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_GRATE, OXIDIZED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_GRATE, WAXED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_GRATE, WAXED_EXPOSED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_GRATE, WAXED_WEATHERED_COPPER_GRATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_GRATE, WAXED_OXIDIZED_COPPER_GRATE);
    }

    // Register the copper grates in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_GRATE);
            content.add(EXPOSED_COPPER_GRATE);
            content.add(WEATHERED_COPPER_GRATE);
            content.add(OXIDIZED_COPPER_GRATE);
            content.add(WAXED_COPPER_GRATE);
            content.add(WAXED_EXPOSED_COPPER_GRATE);
            content.add(WAXED_WEATHERED_COPPER_GRATE);
            content.add(WAXED_OXIDIZED_COPPER_GRATE);
        });
    }

    // Setup the block render layer map for the copper grates, used by the client
    // init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EXPOSED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WEATHERED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OXIDIZED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_EXPOSED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_WEATHERED_COPPER_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_OXIDIZED_COPPER_GRATE, RenderLayer.getCutout());
    }

    private static void registerGrate() {
        COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.UNAFFECTED, COPPER_BLOCK_SETTINGS);
        registryRegister("copper_grate", COPPER_GRATE);
    }

    private static void registerExposedGrate() {
        EXPOSED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.EXPOSED,
                COPPER_BLOCK_SETTINGS.mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        registryRegister("exposed_copper_grate", EXPOSED_COPPER_GRATE);
    }

    private static void registerWeatheredGrate() {
        WEATHERED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.WEATHERED,
                COPPER_BLOCK_SETTINGS.mapColor(MapColor.DARK_AQUA));
        registryRegister("weathered_copper_grate", WEATHERED_COPPER_GRATE);
    }

    private static void registerOxidizedGrate() {
        OXIDIZED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.OXIDIZED,
                COPPER_BLOCK_SETTINGS.mapColor(MapColor.TEAL));
        registryRegister("oxidized_copper_grate", OXIDIZED_COPPER_GRATE);
    }

    private static void registerWaxedGrate() {
        WAXED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(COPPER_GRATE));
        registryRegister("waxed_copper_grate", WAXED_COPPER_GRATE);
    }

    private static void registerWaxedExposedGrate() {
        WAXED_EXPOSED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_GRATE));
        registryRegister("waxed_exposed_copper_grate", WAXED_EXPOSED_COPPER_GRATE);
    }

    private static void registerWaxedWeatheredGrate() {
        WAXED_WEATHERED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_GRATE));
        registryRegister("waxed_weathered_copper_grate", WAXED_WEATHERED_COPPER_GRATE);
    }

    private static void registerWaxedOxidizedGrate() {
        WAXED_OXIDIZED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_GRATE));
        registryRegister("waxed_oxidized_copper_grate", WAXED_OXIDIZED_COPPER_GRATE);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
