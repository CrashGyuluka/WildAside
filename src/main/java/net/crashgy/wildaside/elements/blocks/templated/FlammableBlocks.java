package net.crashgy.wildaside.elements.blocks.templated;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FlammableBlocks {
    @Mod.EventBusSubscriber(modid = WildAsideMod.MOD_ID)
    public static class LogBlocks extends RotatedPillarBlock {
        public LogBlocks(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }

//        @Nullable
//        @Override
//        //stripping the wood
//        public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player,
//                                               ItemStack stack, ToolAction toolAction) {
//            if(stack.getItem() instanceof AxeItem) {
//                return Stripping.strippageRegistry(state);
//            }
//            return super.getToolModifiedState(state, world, pos, player, stack, toolAction);
//        }
    }
    public static class FlammableStone extends Block {
        public FlammableStone(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 1;
        }
    }
    public static class Planks extends Block {
        public Planks(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Door extends DoorBlock {
        public Door(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Fence extends FenceBlock {
        public Fence(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class FenceGate extends FenceGateBlock {
        public FenceGate(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Slab extends SlabBlock {
        public Slab(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Stairs extends StairBlock {
        public Stairs(Supplier<BlockState> state, Properties properties) {
            super(state, properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Trapdoor extends TrapDoorBlock {
        public Trapdoor(Properties properties) {
            super(properties);
        }
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
    public static class Leaves extends LeavesBlock {
        public Leaves(Properties properties) {
            super(properties);
        }

        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return 5;
        }
    }
}
