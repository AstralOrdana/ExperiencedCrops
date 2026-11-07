package com.ordana.experienced_crops;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.IntegerRange;

public class ModConfig extends WrappedConfig {
	@Comment("Minimum amount of experience dropped by crops.")
	@IntegerRange(min=0, max=1000)
	public int minExperience = 2;
	@Comment("Maximum amount of experience dropped by crops.")
	@IntegerRange(min=1, max=1000)
	public int maxExperience = 5;
}
