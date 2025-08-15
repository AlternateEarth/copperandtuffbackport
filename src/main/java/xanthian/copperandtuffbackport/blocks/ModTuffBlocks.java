package xanthian.copperandtuffbackport.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.copperandtuffbackport.Initialise;
import xanthian.copperandtuffbackport.util.ModSounds;

import static net.minecraft.block.Blocks.TUFF;

public class ModTuffBlocks {

    public static final Block TUFF_SLAB = new SlabBlock(FabricBlockSettings.copy(TUFF));
    public static final Block TUFF_STAIRS = new StairsBlock(TUFF.getDefaultState(), FabricBlockSettings.copy(TUFF));
    public static final Block TUFF_WALL = new WallBlock(FabricBlockSettings.copy(TUFF).solid());
    public static final Block POLISHED_TUFF = new Block(FabricBlockSettings.copy(TUFF).sounds(ModSounds.POLISHED_TUFF));
    public static final Block POLISHED_TUFF_SLAB = new SlabBlock(FabricBlockSettings.copy(POLISHED_TUFF));
    public static final Block POLISHED_TUFF_STAIRS = new StairsBlock(POLISHED_TUFF.getDefaultState(),
            FabricBlockSettings.copy(POLISHED_TUFF));
    public static final Block POLISHED_TUFF_WALL = new WallBlock(FabricBlockSettings.copy(POLISHED_TUFF).solid());
    public static final Block CHISELED_TUFF = new Block(FabricBlockSettings.copy(TUFF));
    public static final Block TUFF_BRICKS = new Block(FabricBlockSettings.copy(TUFF).sounds(ModSounds.TUFF_BRICKS));
    public static final Block TUFF_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(TUFF_BRICKS));
    public static final Block TUFF_BRICK_STAIRS = new StairsBlock(TUFF_BRICKS.getDefaultState(),
            FabricBlockSettings.copy(TUFF_BRICKS));
    public static final Block TUFF_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(TUFF_BRICKS).solid());
    public static final Block CHISELED_TUFF_BRICKS = new Block(FabricBlockSettings.copy(TUFF_BRICKS));

    public static void registerBlocks() {
        register("tuff_slab", TUFF_SLAB);
        register("tuff_stairs", TUFF_STAIRS);
        register("tuff_wall", TUFF_WALL);

        register("polished_tuff", POLISHED_TUFF);
        register("polished_tuff_slab", POLISHED_TUFF_SLAB);
        register("polished_tuff_stairs", POLISHED_TUFF_STAIRS);
        register("polished_tuff_wall", POLISHED_TUFF_WALL);

        register("chiseled_tuff", CHISELED_TUFF);
        register("chiseled_tuff_bricks", CHISELED_TUFF_BRICKS);

        register("tuff_bricks", TUFF_BRICKS);
        register("tuff_brick_slab", TUFF_BRICK_SLAB);
        register("tuff_brick_stairs", TUFF_BRICK_STAIRS);
        register("tuff_brick_wall", TUFF_BRICK_WALL);

    }

    private static void register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
    }
}
