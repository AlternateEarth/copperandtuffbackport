package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.MapColor;
import net.minecraft.block.Oxidizable;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.BulbBlock;
import xanthian.copperandtuffbackport.blocks.custom.OxidizableBulbBlock;
import xanthian.copperandtuffbackport.util.ModItemGroup;
import xanthian.copperandtuffbackport.util.ModSounds;

public class ModCopperBulb {

    private static final FabricBlockSettings COPPER_BLOCK_SETTINGS = FabricBlockSettings.create()
            .mapColor(net.minecraft.block.Blocks.COPPER_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .sounds(ModSounds.COPPER_BULB)
            .requiresTool()
            .solidBlock(Blocks::never)
            .luminance(net.minecraft.block.Blocks.createLightLevelFromLitBlockState(15));

    private static Block COPPER_BULB;
    private static Block EXPOSED_COPPER_BULB;
    private static Block WEATHERED_COPPER_BULB;
    private static Block OXIDIZED_COPPER_BULB;
    private static Block WAXED_COPPER_BULB;
    private static Block WAXED_EXPOSED_COPPER_BULB;
    private static Block WAXED_WEATHERED_COPPER_BULB;
    private static Block WAXED_OXIDIZED_COPPER_BULB;

    // Register all copper bulb blocks and items.
    public static void register() {
        registerBulb();
        registerExposedBulb();
        registerWeatheredBulb();
        registerOxidizedBulb();
        registerWaxedBulb();
        registerWaxedExposedBulb();
        registerWaxedWeatheredBulb();
        registerWaxedOxidizedBulb();
    }

    // Register the copper bulbs as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_BULB, EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_BULB, WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_BULB, OXIDIZED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_BULB, WAXED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_BULB, WAXED_EXPOSED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_BULB, WAXED_WEATHERED_COPPER_BULB);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_BULB, WAXED_OXIDIZED_COPPER_BULB);
    }

    // Register the copper bulbs in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_BULB);
            content.add(EXPOSED_COPPER_BULB);
            content.add(WEATHERED_COPPER_BULB);
            content.add(OXIDIZED_COPPER_BULB);
            content.add(WAXED_COPPER_BULB);
            content.add(WAXED_EXPOSED_COPPER_BULB);
            content.add(WAXED_WEATHERED_COPPER_BULB);
            content.add(WAXED_OXIDIZED_COPPER_BULB);
        });
    }

    // Setup the block render layer map for the copper bulbs, used by the client
    // init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EXPOSED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WEATHERED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OXIDIZED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_EXPOSED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_WEATHERED_COPPER_BULB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_OXIDIZED_COPPER_BULB, RenderLayer.getCutout());
    }

    private static void registerBulb() {
        COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.UNAFFECTED, COPPER_BLOCK_SETTINGS);
        registryRegister("copper_bulb", COPPER_BULB);
    }

    private static void registerExposedBulb() {
        EXPOSED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.EXPOSED,
                FabricBlockSettings.copyOf(COPPER_BULB)
                        .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                        .luminance(net.minecraft.block.Blocks.createLightLevelFromLitBlockState(12)));
        registryRegister("exposed_copper_bulb", EXPOSED_COPPER_BULB);
    }

    private static void registerWeatheredBulb() {
        WEATHERED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.WEATHERED,
                FabricBlockSettings.copyOf(COPPER_BULB)
                        .mapColor(MapColor.TERRACOTTA_BROWN)
                        .luminance(net.minecraft.block.Blocks.createLightLevelFromLitBlockState(8)));
        registryRegister("weathered_copper_bulb", WEATHERED_COPPER_BULB);
    }

    private static void registerOxidizedBulb() {
        OXIDIZED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.OXIDIZED,
                FabricBlockSettings.copyOf(COPPER_BULB)
                        .mapColor(MapColor.TERRACOTTA_GRAY)
                        .luminance(net.minecraft.block.Blocks.createLightLevelFromLitBlockState(4)));
        registryRegister("oxidized_copper_bulb", OXIDIZED_COPPER_BULB);
    }

    private static void registerWaxedBulb() {
        WAXED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(COPPER_BULB));
        registryRegister("waxed_copper_bulb", WAXED_COPPER_BULB);
    }

    private static void registerWaxedExposedBulb() {
        WAXED_EXPOSED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_BULB));
        registryRegister("waxed_exposed_copper_bulb", WAXED_EXPOSED_COPPER_BULB);
    }

    private static void registerWaxedWeatheredBulb() {
        WAXED_WEATHERED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_BULB));
        registryRegister("waxed_weathered_copper_bulb", WAXED_WEATHERED_COPPER_BULB);
    }

    private static void registerWaxedOxidizedBulb() {
        WAXED_OXIDIZED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_BULB));
        registryRegister("waxed_oxidized_copper_bulb", WAXED_OXIDIZED_COPPER_BULB);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
