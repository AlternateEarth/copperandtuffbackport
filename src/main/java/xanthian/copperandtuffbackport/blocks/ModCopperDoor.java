package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
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

public class ModCopperDoor {

    private static final FabricBlockSettings COPPER_BLOCK_SETTINGS = FabricBlockSettings.create()
            .mapColor(COPPER_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .nonOpaque()
            .requiresTool()
            .pistonBehavior(PistonBehavior.DESTROY);

    private static Block COPPER_DOOR;
    private static Block EXPOSED_COPPER_DOOR;
    private static Block OXIDIZED_COPPER_DOOR;
    private static Block WEATHERED_COPPER_DOOR;
    private static Block WAXED_COPPER_DOOR;
    private static Block WAXED_EXPOSED_COPPER_DOOR;
    private static Block WAXED_OXIDIZED_COPPER_DOOR;
    private static Block WAXED_WEATHERED_COPPER_DOOR;

    // Register all copper door blocks and items.
    public static void register() {
        registerDoor();
        registerExposedDoor();
        registerOxidizedDoor();
        registerWeatheredDoor();
        registerWaxedDoor();
        registerWaxedExposedDoor();
        registerWaxedOxidizedDoor();
        registerWaxedWeatheredDoor();
    }

    // Register the copper doors as oxidizable for the Fabric system.
    public static void registerOxidizable() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_DOOR, EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_DOOR, WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_DOOR, OXIDIZED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_DOOR, WAXED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_DOOR, WAXED_EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_DOOR, WAXED_WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_DOOR, WAXED_OXIDIZED_COPPER_DOOR);
    }

    // Register the copper doors in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(COPPER_DOOR);
            content.add(EXPOSED_COPPER_DOOR);
            content.add(WEATHERED_COPPER_DOOR);
            content.add(OXIDIZED_COPPER_DOOR);
            content.add(WAXED_COPPER_DOOR);
            content.add(WAXED_EXPOSED_COPPER_DOOR);
            content.add(WAXED_WEATHERED_COPPER_DOOR);
            content.add(WAXED_OXIDIZED_COPPER_DOOR);
        });
    }

    // Setup the block render layer map for the copper doors, used by the client init system.
    public static void setupBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlock(COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_EXPOSED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_OXIDIZED_COPPER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WAXED_WEATHERED_COPPER_DOOR, RenderLayer.getCutout());
    }

    public static void registerBuildingBlocksItemGroup() {

    }

    private static void registerDoor() {
        COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED,
                COPPER_BLOCK_SETTINGS);
        registryRegister("copper_door", COPPER_DOOR);
    }

    private static void registerExposedDoor() {
        EXPOSED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED,
                COPPER_BLOCK_SETTINGS.mapColor(EXPOSED_COPPER.getDefaultMapColor()));
        registryRegister("exposed_copper_door", EXPOSED_COPPER_DOOR);
    }

    private static void registerOxidizedDoor() {
        OXIDIZED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED,
                COPPER_BLOCK_SETTINGS.mapColor(OXIDIZED_COPPER.getDefaultMapColor()));
        registryRegister("oxidized_copper_door", OXIDIZED_COPPER_DOOR);
    }

    private static void registerWeatheredDoor() {
        WEATHERED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED,
                COPPER_BLOCK_SETTINGS.mapColor(WEATHERED_COPPER.getDefaultMapColor()));
        registryRegister("weathered_copper_door", WEATHERED_COPPER_DOOR);
    }

    private static void registerWaxedDoor() {
        WAXED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER);
        registryRegister("waxed_copper_door", WAXED_COPPER_DOOR);
    }

    private static void registerWaxedExposedDoor() {
        WAXED_EXPOSED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_DOOR),
                ModBlockSetTypes.COPPER);
        registryRegister("waxed_exposed_copper_door", WAXED_EXPOSED_COPPER_DOOR);
    }

    private static void registerWaxedOxidizedDoor() {
        WAXED_OXIDIZED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_DOOR),
                ModBlockSetTypes.COPPER);
        registryRegister("waxed_oxidized_copper_door", WAXED_OXIDIZED_COPPER_DOOR);
    }

    private static void registerWaxedWeatheredDoor() {
        WAXED_WEATHERED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_DOOR),
                ModBlockSetTypes.COPPER);
        registryRegister("waxed_weathered_copper_door", WAXED_WEATHERED_COPPER_DOOR);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }

}