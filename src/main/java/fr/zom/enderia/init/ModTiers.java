package fr.zom.enderia.init;

import cpw.mods.modlauncher.EnumerationHelper;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
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
