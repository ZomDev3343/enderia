package fr.zom.enderia.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public final class ModTiers {

    /* TOOLS */

    public static final ForgeTier ENDERITE_TIER = new ForgeTier(3,
            2021,
            10f,
            3.5f,
            10,
            ModObjects.NEEDS_ENDRITE_TOOL,
            () -> Ingredient.of(ModObjects.ENDERITE_INGOT.get()));

}
