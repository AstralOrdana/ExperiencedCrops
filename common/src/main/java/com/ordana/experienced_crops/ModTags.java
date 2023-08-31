package com.ordana.experienced_crops;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Block> CROPS_WITHOUT_EXP = registerBlockTag("crops_without_exp");

    private static TagKey<Block> registerBlockTag(String id) {
        return TagKey.create(Registries.BLOCK, ExperiencedCrops.res(id));
    }
}
