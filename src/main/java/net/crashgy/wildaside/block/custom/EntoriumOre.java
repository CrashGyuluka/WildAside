package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class EntoriumOre extends OreBlock {
    public EntoriumOre(Properties properties, UniformInt of) {
        super(properties, of);
    }

//    @Override
//    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
//        float chance = 0.3f;
//        if (chance < pRandom.nextFloat())
//        {
//            pLevel.addParticle(ModParticles.VIBRION_PARTICLE.get(),
//                    pPos.getX() + pRandom.nextDouble() * 1.5, pPos.getY() + pRandom.nextDouble() * 1.5, pPos.getZ() + pRandom.nextDouble() * 1.5,
//                    1d, 1d, 1d);
//        }
//    }
}
