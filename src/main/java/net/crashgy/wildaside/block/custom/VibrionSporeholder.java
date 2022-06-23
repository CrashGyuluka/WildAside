package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.effect.ModEffects;
import net.crashgy.wildaside.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class VibrionSporeholder extends Block {
    public VibrionSporeholder(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 4, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).canOcclude();
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        if (pEntity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(ModEffects.CONTAMINATED.get(), 200, 0));
//            if (pLevel.isClientSide())
//            {
//                pLevel.addParticle(ModParticles.VIBRION_PARTICLE.get(),
//                        pPos.getX() + 0.5f, pPos.getY() + 0.5, pPos.getZ() + 0.5d,
//                        8d, 8.3d, 8d);
//            }
        }
    }

//    @Override
//    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
//        float chance = 0.15f;
//        if (chance < pRandom.nextFloat())
//        {
//            pLevel.addParticle(ModParticles.VIBRION_PARTICLE.get(),
//                    pPos.getX() + pRandom.nextDouble(), pPos.getY() + 0.3, pPos.getZ() + pRandom.nextDouble(),
//                    1d, 1.1d, 1d);
//        }
//    }
}