package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;

public class BaseItemAxe extends AxeItem {

    public BaseItemAxe(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 5f, -3.2f, new Properties().tab(group));
    }

    public BaseItemAxe(Tier itemTier) {
        this(itemTier, Enderia.ITEMS);
    }
}
