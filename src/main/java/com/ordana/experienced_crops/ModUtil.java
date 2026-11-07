package com.ordana.experienced_crops;


//? fabric {
import net.fabricmc.loader.api.FabricLoader;
//?} else {
/*import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
*///?}

import java.nio.file.Path;
import java.util.List;

public class ModUtil {

	public static Path getConfigDir() {
		//? fabric
		return FabricLoader.getInstance().getConfigDir();
		//? neoforge
		//return FMLPaths.CONFIGDIR.get();
	}

	public static boolean isModLoaded(String mod) {
		//? fabric
		return FabricLoader.getInstance().isModLoaded(mod);
		//? neoforge
		//return ModList.get().isLoaded(mod);
	}

}