package com.ordana.experienced_crops.mixins;

import com.ordana.experienced_crops.ExperiencedCrops;
import com.ordana.experienced_crops.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public abstract class CropsMixin {

    @Inject(method = "spawnAfterBreak", at = @At(value = "HEAD"))
    private void spawnExperienceFromCrops(BlockState state, ServerLevel level, BlockPos pos, ItemStack tool, boolean dropExperience, CallbackInfo ci) {
        if (state.getBlock() instanceof CropBlock cropBlock) {
            if (!cropBlock.isMaxAge(state) || state.is(ModTags.CROPS_WITHOUT_EXP)) return;
            if (level instanceof ServerLevel serverLevel) {
                int min = 2;
                int max = 5;
                if (ExperiencedCrops.CONFIG.minExperience<=ExperiencedCrops.CONFIG.maxExperience) {
                    min = ExperiencedCrops.CONFIG.minExperience;
                    max = ExperiencedCrops.CONFIG.maxExperience;
                } else {
                    ExperiencedCrops.LOGGER.error("Minimum experience must be lower than maximum experience! Configured value will be ignored.");
                }

				((BlockAccessor) cropBlock).callPopExperience(serverLevel, pos, level.getRandom().nextIntBetweenInclusive(min, max));
			}
        }
    }
}
