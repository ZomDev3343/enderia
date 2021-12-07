package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BaseItemPickaxe extends PickaxeItem {

    public BaseItemPickaxe(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 1, -2.8f, new Properties().tab(group));
    }

    public BaseItemPickaxe(Tier itemTier) {
        this(itemTier, Enderia.ITEMS);
    }
}
