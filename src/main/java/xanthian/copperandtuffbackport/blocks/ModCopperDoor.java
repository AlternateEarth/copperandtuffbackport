package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.*;
import xanthian.copperandtuffbackport.particles.ModParticles;
import xanthian.copperandtuffbackport.util.ModBlockSetTypes;
import xanthian.copperandtuffbackport.util.ModSounds;

import static net.minecraft.block.Blocks.*;

public static final class ModCopperDoor {

    private static final Settings COPPER_BLOCK_SETTINGS = FabricBlockSettings.create()
            .mapColor(COPPER_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .nonOpaque()
            .requiresTool()
            .pistonBehavior(PistonBehavior.DESTROY);
    
    private Block COPPER_DOOR;
    private Block EXPOSED_COPPER_DOOR; 
    private Block OXIDIZED_COPPER_DOOR;
    private Block WEATHERED_COPPER_DOOR;
    private Block WAXED_COPPER_DOOR;
    private Block WAXED_EXPOSED_COPPER_DOOR;
    private Block WAXED_OXIDIZED_COPPER_DOOR;
    private Block WAXED_WEATHERED_COPPER_DOOR;
                
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

    public static void registerOxidizable(){
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.COPPER_DOOR, ModCopperBlocks.EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.EXPOSED_COPPER_DOOR, ModCopperBlocks.WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(ModCopperBlocks.WEATHERED_COPPER_DOOR, ModCopperBlocks.OXIDIZED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.COPPER_DOOR, ModCopperBlocks.WAXED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.EXPOSED_COPPER_DOOR, ModCopperBlocks.WAXED_EXPOSED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.WEATHERED_COPPER_DOOR, ModCopperBlocks.WAXED_WEATHERED_COPPER_DOOR);
        OxidizableBlocksRegistry.registerWaxableBlockPair(ModCopperBlocks.OXIDIZED_COPPER_DOOR, ModCopperBlocks.WAXED_OXIDIZED_COPPER_DOOR);
    }

    public static void registerModItemGroup(){
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

    public static void registerBuildingBlocksItemGroup(){

    }

    private static void registerDoor(){
        COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED, COPPER_BLOCK_SETTINGS);
        registryRegister("copper_door", COPPER_DOOR);
    }

    private static void registerExposedDoor(){
        EXPOSED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED, COPPER_BLOCK_SETTINGS.mapColor(EXPOSED_COPPER.getDefaultMapColor()));
        registryRegister("exposed_copper_door", EXPOSED_COPPER_DOOR);
    }

    private static void registerOxidizedDoor(){
        OXIDIZED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED, COPPER_BLOCK_SETTINGS.mapColor(OXIDIZED_COPPER.getDefaultMapColor()));
        registryRegister("oxidized_copper_door", OXIDIZED_COPPER_DOOR);
    }

    private static void registerWeatheredDoor(){
        WEATHERED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED, COPPER_BLOCK_SETTINGS.mapColor(WEATHERED_COPPER.getDefaultMapColor()));
        registryRegister("weathered_copper_door", WEATHERED_COPPER_DOOR);
    }

    private static void registerWaxedDoor() {
        WAXED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER);
        registryRegister("waxed_copper_door", waxedBlock);
    }

    private static void registerWaxedExposedDoor() {
        WAXED_EXPOSED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_DOOR), ModBlockSetTypes.COPPER);
        registryRegister("waxed_exposed_copper_door", WAXED_EXPOSED_COPPER_DOOR);
    }

    private static void registerWaxedOxidizedDoor() {
        WAXED_OXIDIZED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_DOOR), ModBlockSetTypes.COPPER);
        registryRegister("waxed_oxidized_copper_door", WAXED_OXIDIZED_COPPER_DOOR);
    }

    private static void registerWaxedWeatheredDoor() {
        WAXED_WEATHERED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_DOOR), ModBlockSetTypes.COPPER);
        registryRegister("waxed_weathered_copper_door", WAXED_WEATHERED_COPPER_DOOR);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }

    
}