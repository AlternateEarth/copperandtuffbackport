package alternateearth.copperandtuffbackport.blocks;

import alternateearth.copperandtuffbackport.Initialise;
import alternateearth.copperandtuffbackport.util.ModItemGroup;
import alternateearth.copperandtuffbackport.util.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModTuffBrick {
    private static Block TUFF_BRICKS;
    private static Block TUFF_BRICK_SLAB;
    private static Block TUFF_BRICK_STAIRS;
    private static Block TUFF_BRICK_WALL;

    // Register all tuff brick blocks and items.
    public static void register() {
        registerTuffBricks();
        registerTuffBrickSlab();
        registerTuffBrickStairs();
        registerTuffBrickWall();
    }

    // Register the polished tuff blocks in the mod's item group.
    public static void registerModItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.BACKPORT_MOD_ITEM_GROUP_KEY).register(content -> {
            content.add(TUFF_BRICKS);
            content.add(TUFF_BRICK_SLAB);
            content.add(TUFF_BRICK_STAIRS);
            content.add(TUFF_BRICK_WALL);
        });
    }

    private static void registerTuffBricks() {
        TUFF_BRICKS = new Block(FabricBlockSettings.copy(TUFF).sounds(ModSounds.TUFF_BRICKS));
        registryRegister("tuff_bricks", TUFF_BRICKS);
    }

    private static void registerTuffBrickSlab() {
        TUFF_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(TUFF_BRICKS));
        registryRegister("tuff_brick_slab", TUFF_BRICK_SLAB);
    }

    private static void registerTuffBrickStairs() {
        TUFF_BRICK_STAIRS = new StairsBlock(TUFF_BRICKS.getDefaultState(), FabricBlockSettings.copy(TUFF_BRICKS));
        registryRegister("tuff_brick_stairs", TUFF_BRICK_STAIRS);
    }

    private static void registerTuffBrickWall() {
        TUFF_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(TUFF_BRICKS).solid());
        registryRegister("tuff_brick_wall", TUFF_BRICK_WALL);
    }

    private static void registryRegister(String name, Block block) {
        var identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
