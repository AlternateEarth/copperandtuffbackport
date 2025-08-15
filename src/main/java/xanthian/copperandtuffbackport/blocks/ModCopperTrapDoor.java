package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.*;
import xanthian.copperandtuffbackport.util.ModBlockSetTypes;
import xanthian.copperandtuffbackport.util.ModItemGroup;

import static net.minecraft.block.Blocks.*;

public class ModCopperTrapDoor {

    private static final FabricBlockSettings COPPER_BLOCK_SETTINGS = FabricBlockSettings.create()
            .mapColor(COPPER_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .nonOpaque()
            .requiresTool()
            .allowsSpawning(Blocks::never);

    private static Block COPPER_TRAPDOOR;
    private static Block EXPOSED_COPPER_TRAPDOOR;
    private static Block WEATHERED_COPPER_TRAPDOOR;
    private static Block OXIDIZED_COPPER_TRAPDOOR;
    private static Block WAXED_COPPER_TRAPDOOR;
    private static Block WAXED_EXPOSED_COPPER_TRAPDOOR;
    private static Block WAXED_WEATHERED_COPPER_TRAPDOOR;
    private static Block WAXED_OXIDIZED_COPPER_TRAPDOOR;

    // Register all copper trapdoor blocks and items.
    public static void register() {
        registerTrapdoor();
        registerExposedTrapdoor();
        registerWeatheredTrapdoor();
        registerOxidizedTrapdoor();
        registerWaxedTrapdoor();
        registerWaxedExposedTrapdoor();
        registerWaxedWeatheredTrapdoor();
        registerWaxedOxidizedTrapdoor();
    }

    // Register the copper doors as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_TRAPDOOR, EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_TRAPDOOR, WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_TRAPDOOR, OXIDIZED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_TRAPDOOR, WAXED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_TRAPDOOR, WAXED_EXPOSED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_TRAPDOOR, WAXED_WEATHERED_COPPER_TRAPDOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_TRAPDOOR, WAXED_OXIDIZED_COPPER_TRAPDOOR);
    }

    // Register the copper doors in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_TRAPDOOR);
            content.add(EXPOSED_COPPER_TRAPDOOR);
            content.add(OXIDIZED_COPPER_TRAPDOOR);
            content.add(WEATHERED_COPPER_TRAPDOOR);
            content.add(WAXED_COPPER_TRAPDOOR);
            content.add(WAXED_EXPOSED_COPPER_TRAPDOOR);
            content.add(WAXED_OXIDIZED_COPPER_TRAPDOOR);
            content.add(WAXED_WEATHERED_COPPER_TRAPDOOR);
        });
    }

    // Setup the block render layer map for the copper trapdoors, used by the client
    // init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_EXPOSED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_WEATHERED_COPPER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_OXIDIZED_COPPER_TRAPDOOR, RenderLayer.getCutout());
    }

    private static void registerTrapdoor() {
        COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(
                ModBlockSetTypes.COPPER,
                Oxidizable.OxidationLevel.UNAFFECTED,
                COPPER_BLOCK_SETTINGS);
        registryRegister("copper_trapdoor", COPPER_TRAPDOOR);
    }

    private static void registerExposedTrapdoor() {
        EXPOSED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER,
                Oxidizable.OxidationLevel.EXPOSED,
                COPPER_BLOCK_SETTINGS.mapColor(EXPOSED_COPPER.getDefaultMapColor()));
        registryRegister("exposed_copper_trapdoor", EXPOSED_COPPER_TRAPDOOR);
    }

    private static void registerWeatheredTrapdoor() {
        WEATHERED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER,
                Oxidizable.OxidationLevel.WEATHERED,
                COPPER_BLOCK_SETTINGS.mapColor(WEATHERED_COPPER.getDefaultMapColor()));
        registryRegister("weathered_copper_trapdoor", WEATHERED_COPPER_TRAPDOOR);
    }

    private static void registerOxidizedTrapdoor() {
        OXIDIZED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER,
                Oxidizable.OxidationLevel.OXIDIZED,
                COPPER_BLOCK_SETTINGS.mapColor(OXIDIZED_COPPER.getDefaultMapColor()));
        registryRegister("oxidized_copper_trapdoor", OXIDIZED_COPPER_TRAPDOOR);
    }

    private static void registerWaxedTrapdoor() {
        WAXED_COPPER_TRAPDOOR = new TrapdoorBlock(COPPER_BLOCK_SETTINGS, ModBlockSetTypes.COPPER);
        registryRegister("waxed_copper_trapdoor", WAXED_COPPER_TRAPDOOR);
    }

    private static void registerWaxedExposedTrapdoor() {
        WAXED_EXPOSED_COPPER_TRAPDOOR = new TrapdoorBlock(COPPER_BLOCK_SETTINGS, ModBlockSetTypes.COPPER);
        registryRegister("waxed_exposed_copper_trapdoor", WAXED_EXPOSED_COPPER_TRAPDOOR);
    }

    private static void registerWaxedWeatheredTrapdoor() {
        WAXED_WEATHERED_COPPER_TRAPDOOR = new TrapdoorBlock(COPPER_BLOCK_SETTINGS, ModBlockSetTypes.COPPER);
        registryRegister("waxed_weathered_copper_trapdoor", WAXED_WEATHERED_COPPER_TRAPDOOR);
    }

    private static void registerWaxedOxidizedTrapdoor() {
        WAXED_OXIDIZED_COPPER_TRAPDOOR = new TrapdoorBlock(COPPER_BLOCK_SETTINGS, ModBlockSetTypes.COPPER);
        registryRegister("waxed_oxidized_copper_trapdoor", WAXED_OXIDIZED_COPPER_TRAPDOOR);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
