package cn.lyuxc.exprorser.block;

import com.refinedmods.refinedstorage.RSBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExposerBlock extends Block implements EntityBlock {
    public ExposerBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new TileExposer(blockPos,blockState);
    }

    @SuppressWarnings("all")
    @Override
    public void neighborChanged(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(pNeighborBlock == RSBlocks.EXTERNAL_STORAGE.get()) {
            pLevel.setBlockAndUpdate(pNeighborPos,Blocks.AIR.defaultBlockState());
        }
    }
}