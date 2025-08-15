package alternateearth.copperandtuffbackport.blocks.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableTrapdoorBlock extends TrapdoorBlock implements Oxidizable {

    private final OxidationLevel oxidationLevel;

    public OxidizableTrapdoorBlock(BlockSetType type, OxidationLevel oxidationLevel, Settings settings) {
        super(settings, type);
        this.oxidationLevel = oxidationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
