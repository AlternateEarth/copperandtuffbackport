package xanthian.copperandtuffbackport.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xanthian.copperandtuffbackport.util.ModSounds;

public class BulbBlock extends Block {
    public static final BooleanProperty POWERED;
    public static final BooleanProperty LIT;

    static {
        POWERED = Properties.POWERED;
        LIT = Properties.LIT;
    }

    public BulbBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(LIT, false)).with(POWERED, false));
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }

    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }

    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean) state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean) state.get(POWERED)) {
                blockState = (BlockState) blockState.cycle(LIT);
                world.playSound((PlayerEntity) null, pos, (Boolean) blockState.get(LIT) ? ModSounds.BLOCK_COPPER_BULB_TURN_ON : ModSounds.BLOCK_COPPER_BULB_TURN_OFF, SoundCategory.BLOCKS);
            }
            world.setBlockState(pos, blockState.with(POWERED, bl), 3);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT, POWERED});
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return world.getBlockState(pos).get(LIT) ? 15 : 0;
    }
}
