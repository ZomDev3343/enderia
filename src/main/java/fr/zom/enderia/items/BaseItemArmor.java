package fr.zom.enderia.items;

import fr.zom.enderia.Enderia;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class BaseItemArmor extends ArmorItem {

    public BaseItemArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot) {
        this(pMaterial, pSlot, new Item.Properties().tab(Enderia.ITEMS));
    }

    public BaseItemArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }
}
