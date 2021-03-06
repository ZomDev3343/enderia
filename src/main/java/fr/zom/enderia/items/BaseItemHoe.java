package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class BaseItemHoe extends HoeItem {

    public BaseItemHoe(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 0, -3.0f, new Properties().tab(group));
    }

    public BaseItemHoe(Tier itemTier) {
        this(itemTier, Enderia.ITEMS);
    }
}
