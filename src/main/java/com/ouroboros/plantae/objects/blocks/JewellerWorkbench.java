package com.ouroboros.plantae.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class JewellerWorkbench extends Block{

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = 
			Stream.of(
				Block.makeCuboidShape(0, 0, 0, 2, 16, 16),
				Block.makeCuboidShape(14, 0, 0, 16, 16, 16),
				Block.makeCuboidShape(2, 0, 9, 14, 16, 16),
				Block.makeCuboidShape(2, 0, 2, 14, 14, 9)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = 
			Stream.of(
				Block.makeCuboidShape(14, 0, 0, 16, 16, 16),
				Block.makeCuboidShape(0, 0, 0, 2, 16, 16),
				Block.makeCuboidShape(2, 0, 0, 14, 16, 7),
				Block.makeCuboidShape(2, 0, 7, 14, 14, 14)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_E =
			Stream.of(
				Block.makeCuboidShape(0, 0, 0, 16, 16, 2),
				Block.makeCuboidShape(0, 0, 14, 16, 16, 16),
				Block.makeCuboidShape(0, 0, 2, 7, 16, 14),
				Block.makeCuboidShape(7, 0, 2, 14, 14, 14)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = 
			Stream.of(
				Block.makeCuboidShape(0, 0, 14, 16, 16, 16),
				Block.makeCuboidShape(0, 0, 0, 16, 16, 2),
				Block.makeCuboidShape(9, 0, 2, 16, 16, 14),
				Block.makeCuboidShape(2, 0, 2, 9, 14, 14)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public JewellerWorkbench(Properties properties) {
		super(properties);
	
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
			case NORTH: return SHAPE_N;
			case SOUTH: return SHAPE_S;
			case EAST: return SHAPE_E;
			case WEST: return SHAPE_W;			
			default: return SHAPE_N;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
