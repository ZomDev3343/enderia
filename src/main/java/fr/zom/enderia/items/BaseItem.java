package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {

    public BaseItem(Properties properties) {
        super(properties);
    }

    public BaseItem(CreativeModeTab group, int maxStackSize, int maxDamage) {
        this(new Properties().tab(group).stacksTo(maxStackSize).defaultDurability(maxDamage));
    }

    public BaseItem(CreativeModeTab group, int maxStackSize) {
        this(new Properties().tab(group).stacksTo(maxStackSize));
    }

    public BaseItem(CreativeModeTab group) {
        this(new Properties().tab(group));
    }

    public BaseItem() {
        this(Enderia.ITEMS);
    }
}
