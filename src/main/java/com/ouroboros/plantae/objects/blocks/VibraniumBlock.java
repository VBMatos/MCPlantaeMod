package com.ouroboros.plantae.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.ouroboros.plantae.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class VibraniumBlock extends Block {

	public VibraniumBlock(Block.Properties properties) {
		super(properties);
    }
	
	/**
	 * Change the block
	 */
	@Override
    public void func_225534_a_(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
    	boolean absorbingHeat = this.isChangingHeat(serverWorld, blockPos, FluidTags.LAVA);
    	boolean losingHeat = this.isChangingHeat(serverWorld, blockPos, FluidTags.WATER);
    	
		if(absorbingHeat | losingHeat) {
	    	if(absorbingHeat)
	    		serverWorld.setBlockState(blockPos, BlockInit.vibranium_heated_block.getDefaultState(), 2);
	    	else if(losingHeat) {
				//serverWorld.setBlockState(blockPos, BlockInit.vibranium_frozen_block.getDefaultState(), 2);
	    	}
    	}
    }

	@Override @Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		scheduleTick(context.getWorld(), context.getPos());
	   
		return this.getDefaultState();
	}
    
    /**
	 * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific face passed in.
	 */
    @Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    	scheduleTick(worldIn, currentPos);

    	return stateIn;
	}
   
	private void scheduleTick(IWorld worldIn, BlockPos currentPos) {
		if(this.isChangingHeat(worldIn, currentPos, FluidTags.LAVA))
			worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 60 + worldIn.getRandom().nextInt(40));
	}
	
	/**
	 * The current block is considered chaging heat if it is facing some flow
	 */
    protected boolean isChangingHeat(IBlockReader blockReader, BlockPos blockPos, Tag<Fluid> fluid) {
    	IFluidState iFluidState;
    	
    	for(Direction direction : Direction.values()) {
          iFluidState = blockReader.getFluidState(blockPos.offset(direction));
          
          if(iFluidState.isTagged(fluid))
        	  return true;
       }
       return false;
    }
}









