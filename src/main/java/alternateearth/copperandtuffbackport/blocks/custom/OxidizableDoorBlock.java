package alternateearth.copperandtuffbackport.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

public class OxidizableDoorBlock extends DoorBlock implements Oxidizable {
    private final OxidationLevel oxidationLevel;

    public OxidizableDoorBlock(BlockSetType type, Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings, type);
        this.oxidationLevel = oxidationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(DoorBlock.HALF) == DoubleBlockHalf.LOWER) {
            this.tickDegradation(state, world, pos, random);
        }

    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
            WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        if (direction.getAxis() == Direction.Axis.Y
                && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.getBlock() instanceof DoorBlock && neighborState.get(HALF) != doubleBlockHalf
                    ? neighborState.with(HALF, doubleBlockHalf)
                    : Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN
                    && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                            : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
