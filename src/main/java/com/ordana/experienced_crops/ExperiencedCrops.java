package com.ordana.experienced_crops;

import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExperiencedCrops {

    public static final String MOD_ID = "experienced_crops";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ModConfig CONFIG = ModConfig.createToml(ModUtil.getConfigDir(), "", MOD_ID, ModConfig.class);

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void commonInit() {

    }

}