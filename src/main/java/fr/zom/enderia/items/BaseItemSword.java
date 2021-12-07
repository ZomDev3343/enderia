package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class BaseItemSword extends SwordItem {

    public BaseItemSword(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 3, -2.4f, new Properties().tab(group));
    }

    public BaseItemSword(Tier itemTier) {
        this(itemTier, Enderia.ITEMS);
    }
}
