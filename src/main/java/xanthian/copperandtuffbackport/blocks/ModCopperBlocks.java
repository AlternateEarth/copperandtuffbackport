package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.blocks.custom.*;
import xanthian.copperandtuffbackport.util.ModBlockSetTypes;
import xanthian.copperandtuffbackport.util.ModSounds;

import static net.minecraft.block.Blocks.*;

public class ModCopperBlocks {

    public static final Block CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(COPPER_BLOCK));
    public static final Block EXPOSED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(EXPOSED_COPPER));
    public static final Block OXIDIZED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(OXIDIZED_COPPER));
    public static final Block WEATHERED_CHISELED_COPPER = new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(WEATHERED_COPPER));
    public static final Block WAXED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(CHISELED_COPPER));
    public static final Block WAXED_EXPOSED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(EXPOSED_CHISELED_COPPER));
    public static final Block WAXED_OXIDIZED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(OXIDIZED_CHISELED_COPPER));
    public static final Block WAXED_WEATHERED_CHISELED_COPPER = new Block(FabricBlockSettings.copyOf(WEATHERED_CHISELED_COPPER));

    public static final Block COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(COPPER_BLOCK.getDefaultMapColor()).strength(3.0F, 6.0F).nonOpaque().requiresTool().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block WAXED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(COPPER_DOOR), ModBlockSetTypes.COPPER);
    public static final Block EXPOSED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(EXPOSED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_EXPOSED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_DOOR), ModBlockSetTypes.COPPER);
    public static final Block OXIDIZED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(OXIDIZED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_OXIDIZED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_DOOR), ModBlockSetTypes.COPPER);
    public static final Block WEATHERED_COPPER_DOOR = new OxidizableDoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_DOOR).mapColor(WEATHERED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_WEATHERED_COPPER_DOOR = new CopperDoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_DOOR), ModBlockSetTypes.COPPER);

    public static final Block COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(COPPER_BLOCK.getDefaultMapColor()).strength(3.0F, 6.0F).requiresTool().nonOpaque().allowsSpawning(Blocks::never));
    public static final Block WAXED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copyOf(COPPER_TRAPDOOR), ModBlockSetTypes.COPPER);
    public static final Block EXPOSED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(EXPOSED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_EXPOSED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_TRAPDOOR), ModBlockSetTypes.COPPER);
    public static final Block OXIDIZED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(OXIDIZED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_OXIDIZED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_TRAPDOOR), ModBlockSetTypes.COPPER);
    public static final Block WEATHERED_COPPER_TRAPDOOR = new OxidizableTrapdoorBlock(ModBlockSetTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_TRAPDOOR).mapColor(WEATHERED_COPPER.getDefaultMapColor()));
    public static final Block WAXED_WEATHERED_COPPER_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_TRAPDOOR), ModBlockSetTypes.COPPER);

    public static final Block COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().strength(3.0F, 6.0F).sounds(ModSounds.COPPER_GRATE).mapColor(MapColor.ORANGE).nonOpaque().requiresTool().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never));
    public static final Block WAXED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(COPPER_GRATE));
    public static final Block EXPOSED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block WAXED_EXPOSED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_GRATE));
    public static final Block WEATHERED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(MapColor.DARK_AQUA));
    public static final Block WAXED_WEATHERED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_GRATE));
    public static final Block OXIDIZED_COPPER_GRATE = new OxidizableGrateBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_GRATE).mapColor(MapColor.TEAL));
    public static final Block WAXED_OXIDIZED_COPPER_GRATE = new GrateBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_GRATE));

    public static final Block COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.create().mapColor(COPPER_BLOCK.getDefaultMapColor()).strength(3.0F, 6.0F).sounds(ModSounds.COPPER_BULB).requiresTool().solidBlock(Blocks::never).luminance(createLightLevelFromLitBlockState(15)));
    public static final Block WAXED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(COPPER_BULB));
    public static final Block EXPOSED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(COPPER_BULB).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).luminance(createLightLevelFromLitBlockState(12)));
    public static final Block WAXED_EXPOSED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER_BULB));
    public static final Block WEATHERED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(COPPER_BULB).mapColor(MapColor.DARK_AQUA).luminance(createLightLevelFromLitBlockState(8)));
    public static final Block WAXED_WEATHERED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER_BULB));
    public static final Block OXIDIZED_COPPER_BULB = new OxidizableBulbBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(COPPER_BULB).mapColor(MapColor.TEAL).luminance(createLightLevelFromLitBlockState(4)));
    public static final Block WAXED_OXIDIZED_COPPER_BULB = new BulbBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER_BULB));

    public static void registerBlocks() {

        register("chiseled_copper", CHISELED_COPPER);
        register("exposed_chiseled_copper", EXPOSED_CHISELED_COPPER);
        register("oxidized_chiseled_copper", OXIDIZED_CHISELED_COPPER);
        register("weathered_chiseled_copper", WEATHERED_CHISELED_COPPER);
        register("waxed_chiseled_copper", WAXED_CHISELED_COPPER);
        register("waxed_exposed_chiseled_copper", WAXED_EXPOSED_CHISELED_COPPER);
        register("waxed_oxidized_chiseled_copper", WAXED_OXIDIZED_CHISELED_COPPER);
        register("waxed_weathered_chiseled_copper", WAXED_WEATHERED_CHISELED_COPPER);

        register("copper_door", COPPER_DOOR);
        register("exposed_copper_door", EXPOSED_COPPER_DOOR);
        register("oxidized_copper_door", OXIDIZED_COPPER_DOOR);
        register("weathered_copper_door", WEATHERED_COPPER_DOOR);
        register("waxed_copper_door", WAXED_COPPER_DOOR);
        register("waxed_exposed_copper_door", WAXED_EXPOSED_COPPER_DOOR);
        register("waxed_oxidized_copper_door", WAXED_OXIDIZED_COPPER_DOOR);
        register("waxed_weathered_copper_door", WAXED_WEATHERED_COPPER_DOOR);

        register("copper_trapdoor", COPPER_TRAPDOOR);
        register("exposed_copper_trapdoor", EXPOSED_COPPER_TRAPDOOR);
        register("oxidized_copper_trapdoor", OXIDIZED_COPPER_TRAPDOOR);
        register("weathered_copper_trapdoor", WEATHERED_COPPER_TRAPDOOR);
        register("waxed_copper_trapdoor", WAXED_COPPER_TRAPDOOR);
        register("waxed_exposed_copper_trapdoor", WAXED_EXPOSED_COPPER_TRAPDOOR);
        register("waxed_oxidized_copper_trapdoor", WAXED_OXIDIZED_COPPER_TRAPDOOR);
        register("waxed_weathered_copper_trapdoor", WAXED_WEATHERED_COPPER_TRAPDOOR);

        register("copper_grate", COPPER_GRATE);
        register("exposed_copper_grate", EXPOSED_COPPER_GRATE);
        register("oxidized_copper_grate", OXIDIZED_COPPER_GRATE);
        register("weathered_copper_grate", WEATHERED_COPPER_GRATE);
        register("waxed_copper_grate", WAXED_COPPER_GRATE);
        register("waxed_exposed_copper_grate", WAXED_EXPOSED_COPPER_GRATE);
        register("waxed_oxidized_copper_grate", WAXED_OXIDIZED_COPPER_GRATE);
        register("waxed_weathered_copper_grate", WAXED_WEATHERED_COPPER_GRATE);

        register("copper_bulb", COPPER_BULB);
        register("exposed_copper_bulb", EXPOSED_COPPER_BULB);
        register("oxidized_copper_bulb", OXIDIZED_COPPER_BULB);
        register("weathered_copper_bulb", WEATHERED_COPPER_BULB);
        register("waxed_copper_bulb", WAXED_COPPER_BULB);
        register("waxed_exposed_copper_bulb", WAXED_EXPOSED_COPPER_BULB);
        register("waxed_oxidized_copper_bulb", WAXED_OXIDIZED_COPPER_BULB);
        register("waxed_weathered_copper_bulb", WAXED_WEATHERED_COPPER_BULB);
    }

    private static void register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}